# 🥗 Nutrition Daily

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

# 🥗 Nutrition Daily

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)](https://jwt.io/)
[![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)](https://gradle.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)

A modular Java backend for tracking daily nutrition: meals, foods, calories, macronutrients and goals.

The main goal of this project is to practice and demonstrate **Domain-Driven Design (DDD)** and **Hexagonal Architecture (Ports & Adapters)** in a real-world-style domain, keeping business rules isolated from frameworks and infrastructure.

---

## 📌 Table of Contents

- [Features](#-features)
- [Architecture](#-architecture)
- [Tech Stack](#-tech-stack)
- [Getting Started](#-getting-started)
- [API Overview](#-api-overview)
- [Testing](#-testing)
- [Roadmap](#-roadmap)
- [Contributing](#-contributing)
- [License](#-license)
- [Author](#-author)

---

## ✨ Features

| Feature | Status |
|---|---|
| User registration and authentication (JWT) | ✅ / 🚧 <!-- TODO: adjust --> |
| Register daily meals | ✅ / 🚧 <!-- TODO: adjust --> |
| Register consumed foods | ✅ / 🚧 <!-- TODO: adjust --> |
| Calorie and macronutrient tracking | ✅ / 🚧 <!-- TODO: adjust --> |
| Nutrition goals | ✅ / 🚧 <!-- TODO: adjust --> |
| Eating pattern analysis | 🗺️ Planned |

> ✅ Done · 🚧 In progress · 🗺️ Planned

---

## 🏛️ Architecture

The project is split into **bounded contexts**, each one organized in three layers following Ports & Adapters:

```
com.kvales
├── app                     # Application entry point (Main)
│   └── src/Main.java
│
├── user                    # Bounded context: user management
│   ├── domain              # Entities, value objects, domain rules
│   ├── application         # Use cases and ports
│   └── adapter             # Controllers, repositories, external integrations
│
├── nutrition               # Bounded context: meals, foods, macros, goals
│   ├── domain
│   ├── application
│   └── adapter
│
└── auth                    # Bounded context: authentication and security
    ├── adapter
    ├── application
    └── config              # Security and JWT configuration
```

### Design decisions

- **Domain first:** the `domain` layer has no dependency on Spring, JPA or any other framework.
- **Use cases in `application`:** each use case depends only on interfaces (ports), never on concrete implementations.
- **Infrastructure in `adapter`:** web controllers, persistence and integrations plug into the ports and can be swapped without touching business rules.
- **Separate contexts:** `user`, `nutrition` and `auth` evolve independently and communicate through well-defined boundaries.

<!-- TODO: add an architecture diagram here, e.g. docs/architecture.png -->

---

## 🛠️ Tech Stack

- **Language:** Java <!-- TODO: version, e.g. 21 -->
- **Framework:** Spring (Spring Boot, Spring Security, Spring Data JPA) <!-- TODO: confirm -->
- **Database:** PostgreSQL
- **Security:** JWT (JSON Web Tokens)
- **Build tool:** Gradle (wrapper included)

---

## 🚀 Getting Started

### Prerequisites

- JDK <!-- TODO: version --> or higher
- PostgreSQL running locally (or via Docker)
- Git

### 1. Clone the repository

```bash
git clone https://github.com/KleberVales/nutrition-daily.git
cd nutrition-daily
```

### 2. Start PostgreSQL

Using Docker:

```bash
docker run --name nutrition-db \
  -e POSTGRES_DB=nutrition_daily \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  -d postgres:16
```

### 3. Configure environment

Set the following values (via `application.properties`, `application.yml` or environment variables): <!-- TODO: match your real property names -->

| Variable | Description | Example |
|---|---|---|
| `DB_URL` | JDBC connection URL | `jdbc:postgresql://localhost:5432/nutrition_daily` |
| `DB_USER` | Database user | `postgres` |
| `DB_PASSWORD` | Database password | `postgres` |
| `JWT_SECRET` | Secret used to sign tokens | *(use a long random value)* |
| `JWT_EXPIRATION` | Token lifetime in ms | `3600000` |

> ⚠️ Never commit real secrets to the repository.

### 4. Build and run

```bash
./gradlew build
./gradlew bootRun
```

On Windows, use `gradlew.bat` instead of `./gradlew`.

The API will be available at `http://localhost:8080`. <!-- TODO: confirm port -->

---

## 📡 API Overview

> <!-- TODO: replace with your real endpoints. Example below. -->

| Method | Endpoint | Description | Auth |
|---|---|---|---|
| `POST` | `/auth/register` | Create a new user | No |
| `POST` | `/auth/login` | Authenticate and receive a JWT | No |
| `POST` | `/meals` | Register a meal | Yes |
| `GET` | `/meals?date=YYYY-MM-DD` | List meals for a given day | Yes |
| `GET` | `/summary/daily` | Calories and macros for the day | Yes |
| `PUT` | `/goals` | Define nutrition goals | Yes |

### Example

```bash
# Login
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email": "user@example.com", "password": "secret"}'

# Use the returned token
curl http://localhost:8080/meals \
  -H "Authorization: Bearer <your-token>"
```

<!-- TODO (recommended): add Swagger/OpenAPI and link it here, e.g. http://localhost:8080/swagger-ui.html -->

---

## 🧪 Testing

```bash
./gradlew test
```

<!-- TODO: describe the testing strategy (unit tests for domain, use case tests with fake ports, integration tests with Testcontainers) -->

---

## 🗺️ Roadmap

- [ ] Eating pattern analysis (weekly and monthly trends)
- [ ] Food catalog with nutritional data
- [ ] OpenAPI / Swagger documentation
- [ ] Dockerfile and `docker-compose.yml` for one-command setup
- [ ] CI pipeline with GitHub Actions (build + tests)
- [ ] Integration tests with Testcontainers

---

## 🤝 Contributing

Suggestions and pull requests are welcome.

1. Fork the project
2. Create a feature branch: `git checkout -b feature/my-feature`
3. Commit your changes: `git commit -m "feat: add my feature"`
4. Push to the branch: `git push origin feature/my-feature`
5. Open a Pull Request

---

## 📄 License

Distributed under the MIT License. See [LICENSE](LICENSE) for more information.

---

## 👤 Author

**Kleber Vales** — Java & Spring Software Engineer

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kleber-vales)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:klebervales.dev@gmail.com)
---

### ✉️ Contact

LinkedIn: www.linkedin.com/in/kleber-vales  
E-mail: klebervales.dev@gmail.com

### Kleber Vales

**Java & Spring Software Engineer**

| Cloud | DevOps | Architectures | Generative AI | Methodologies |

🎓 **Bachelor's Degree in Computer Science**  
🎓 **MBA in Web Software Development**

**Certifications**  
🏆 **Oracle Certified Associate – Java SE 7 Programmer**  
🏆 **Microsoft MTA – Software Development Fundamentals**  
🏆 **Scrum Fundamentals Certified (SFC™)**  
🏆 **Oracle Cloud Infrastructure 2025 – DevOps Professional**  
🏆 **Oracle Cloud Infrastructure 2025 – Generative AI Professional**  
🏆 **Agentic AI Certified Fundations Associate**


