// backend/src/main/java/com/example/controller/EchoController.java
package com.example.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.*;


@RestController
public class EchoController {

  @PostMapping("/api/echo")
  public Map<String, Object> echo(@RequestBody Map<String, Object> input) {
    input.put("received_at", System.currentTimeMillis());
    return input;
  }
}