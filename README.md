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

---

## 📂 Project Structure (DDD Style)

```text

nutrition
│
├── domain
│   └── model
│       └── DailyNutrition.java
│
├── application
│   ├── port
│   │   ├── in
│   │   │   └── RegisterMealUseCase.java
│   │   │
│   │   └── out
│   │       └── DailyNutritionRepository.java
│   │
│   └── service
│       └── RegisterMealService.java
│
└── adapter
    ├── in
    │   └── web
    │       └── NutritionController.java
    │
    └── out
        └── persistence
            ├── DailyNutritionJpaEntity.java
            ├── SpringDataDailyNutritionRepository.java
            └── DailyNutritionPersistenceAdapter.java

```
---

## ✉️ Contact

Email: klebervales.dev@gmail.com\
LinkedIn: www.linkedin.com/

**Kleber Vales**

Java & Spring Software Engineer

Microservices | Cloud AWS / OCI | DevOps | Git/Github | Docker | Kubernetes | Scrum | Generative AI | Event-driven Architecture

🎓 **Bachelor's Degree in Computer Science** | 🎓 **MBA in Web Software Development**

🏆 **Oracle Certified Associate – Java SE 7 Programmer**  
🏆 **Microsoft Technology Associate – Software Development Fundamentals**  
🏆 **Scrum Fundamentals Certified (SFC™)**  
🏆 **Oracle Cloud Infrastructure 2025 – DevOps Professional**  
🏆 **Oracle Cloud Infrastructure 2025 – Generative AI Professional**
