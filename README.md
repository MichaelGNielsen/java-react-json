# Java Spring Boot + React Fullstack Template

## 📖 Om Projektet

Dette er en demonstrations-applikation, der viser integrationen mellem en Java Spring Boot backend og en React frontend.

* **Backend:** Java 21 (Spring Boot) - Kører REST API på port 8080.
* **Frontend:** React (Vite) - Kører brugergrænseflade på port 5173.
* **Miljø:** Opsat til WSL2 på Ubuntu 24.04.

## 🛠️ Installation

Hvis du ikke har Java 21, Maven eller Node.js installeret, kan du køre opsætningsscriptet:

## check files

````bash
tree -a -L 3
./inst.sh
````

## 🚀 Start Applikationen

Du skal bruge to separate terminaler for at køre hele systemet samtidig.

### Terminal 1: Start Backend

````bash

#term backend
./start_java_backend.sh
````

### Terminal 2: Start Frontend

````bash
#tern frontend
./start_react_frontend.sh
````

## 🧪 Test API

Du kan teste at backenden virker ved at sende data til den fra en tredje terminal:

````bash
# tilføj ny bruger

curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name": "Mads", "email": "mads@example.com"}'
````

## 🛠️ Fejlfinding

### Frontend starter på forkert port (f.eks. 5174 eller 5175)?

Dette sker, hvis port 5173 allerede er optaget af en tidligere kørsel, der ikke blev lukket korrekt.

Du kan frigive porten ved at køre:

````bash
fuser -k 5173/tcp

#(Gentag evt. for 5174 hvis den stadig driller)
````
