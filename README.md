Dette er en demonstrations-applikation, der viser integrationen mellem en **Java Spring Boot** backend og en **React** frontend.

Hele projektet er nu opsat til at køre i **Docker**, så du slipper for bøvl med installation af Java, Maven og Node.js versioner lokalt.

* **Backend:** Java 21 (Spring Boot) - Port `8080`
* **Frontend:** React (Vite) - Port `5173`
* **Data:** Gemmes i `backend/users.json` (Persisteret lokalt)

## 🚀 Start med Docker

Det eneste krav er, at du har **Docker Desktop** eller **Docker Engine** installeret.

### 1. Forberedelse (Kun første gang)
Hvis du lige har hentet projektet (og `users.json` ikke fulgte med), skal du oprette database-filen før du bygger:

```bash
echo "[]" > backend/users.json
```

### 2. Start Applikationen

Åbn en terminal i roden af projektet og kør:

```bash
docker compose up --build
```

### 2. Åbn i Browseren

Når containerne er startet (vent på "Started DemoApplication" i loggen), kan du tilgå:

* **Frontend:** http://localhost:5173
* **Backend API:** http://localhost:8080

## 🛠️ Udvikling & Workflow

### Hot Reload

* **Frontend:** Ændringer i `frontend/src` slår igennem med det samme (Hot Module Replacement).
* **Backend:** Hvis du ændrer Java-kode, skal containeren genstartes for at bygge den nye `.jar` fil.

### Genstart Backend

Hvis du har ændret i Java-koden:

```bash
docker compose restart backend
# Eller for en fuld rebuild:
docker compose up -d --build backend
```

### Stop Applikationen

Tryk `Ctrl+C` i terminalen, eller kør:

```bash
docker compose down
```

## 🧪 Test API Manuelt

Du kan stadig bruge `curl` fra din egen maskine mod backenden:

```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name": "DockerUser", "email": "docker@test.com"}'
```

## 📂 Filstruktur & Docker

* `docker-compose.yml`: Definerer services og netværk.
* `backend/Dockerfile`: Multi-stage build for Java (Maven -> JRE).
* `frontend/Dockerfile`: Node.js miljø til React.
* `backend/users.json`: Denne fil er "mounted" ind i containeren, så dine data gemmes på din disk og ikke forsvinder, når Docker stopper.
