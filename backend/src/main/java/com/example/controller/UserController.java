package com.example.controller;

import com.example.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

  private static final Path FILE = Path.of("users.json");
  private final ObjectMapper mapper = new ObjectMapper();

  private List<User> load() {
    if (!Files.exists(FILE))
      return new ArrayList<>();
    try {
      String json = Files.readString(FILE);
      return mapper.readValue(json, new TypeReference<List<User>>() {});
    } catch (IOException e) {
      System.err.println("Fejl ved læsning: " + e.getMessage());
      return new ArrayList<>();
    }
  }

  private void save(List<User> users) {
    try {
      String json =
          mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
      Files.writeString(FILE, json);
      System.out.println("Gemte " + users.size() + " brugere til users.json");
    } catch (IOException e) {
      System.err.println("Fejl ved gemning: " + e.getMessage());
    }
  }

  @GetMapping
  public List<User> getAll() {
    return load();
  }

  @PostMapping
  public User create(@RequestBody User user) {
    List<User> users = load();
    long nextId = users.isEmpty() ? 1 : users.get(users.size() - 1).getId() + 1;
    user.setId(nextId);
    users.add(user);
    save(users);
    return user;
  }
}