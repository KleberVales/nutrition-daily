# 🥗 Nutrition Daily

A modular Java application designed to help users organize and track their daily nutrition in a structured, domain-driven way.
This project applies DDD (Domain-Driven Design) concepts and modern backend architecture principles to build a scalable and maintainable system.

## 🚀 Project Purpose

Nutrition Daily helps users:

- Track daily meals
- Register consumed foods
- Monitor calories and macronutrients
- Define nutrition goals
- Analyze eating patterns

The system is designed to evolve from a modular monolith to microservices if needed.

## 🏗️ Architecture

The application follows:

✅ Domain-Driven Design (DDD)\
✅ Modular Architecture\
✅ Clean Code principles\
✅ RESTful API\
✅ Event-driven communication (future evolution)

**Suggested Bounded Contexts**

- User Management
- Meal Planning
- Food Catalog
- Nutrition Tracking
- Reports & Analytics

- Macronutrients
- MealType
- Quantity

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- Gradle 

---

## 📂 Project Structure (DDD Style)

```text

com.nutritiondaily

├── user
│   ├── domain
│   ├── application
│   ├── infrastructure
│   └── api
│
├── meal
│   ├── domain
│   ├── application
│   ├── infrastructure
│   └── api
│
├── food
│   ├── domain
│   ├── application
│   ├── infrastructure
│   └── api
│
└── shared

```

---

## 🔄 Example Flow

1. User registers
2. User creates a nutrition goal
3. User logs meals during the day
4. System calculates total calories and macros
5. Reports module generates daily/weekly summaries

--- 

## 📊 Future Improvements

- Authentication with JWT
- Role-based access control
- Integration with wearable devices
- AI-based nutrition recommendations
- Migration to microservices architecture
- Event streaming with Kafka

---

## 🧪 Running the Project

```bash

# Clone the repository
git clone https://github.com/your-username/nutrition-daily.git

# Build the project
./gradlew build

# Run the application
./gradlew bootRun

```

---

## 📌 Roadmap

- User CRUD
- Food registration
- Meal tracking
- Calorie calculation
- Dashboard
- Reports
- Docker deployment

---

## 🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---
