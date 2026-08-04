# Semester Project: Advanced Object-Oriented Programming with AI Assistance

## Project Overview
This repository contains the semester project for the Programming Workshop course (2026) at Universidad Manuela Beltrán. The project demonstrates the application of advanced Object-Oriented Programming (OOP) concepts, robust error handling, functional programming in Java, and design patterns structured according to the SOLID principles.

Additionally, this project incorporates artificial intelligence workflows by integrating GitHub Copilot as a pair programming assistant, evaluating its suggestions critically to ensure clean, maintainable, and scalable software architecture.

## Architectural & Technical Highlights
- **Six Pillars of OOP**: Implementation of abstraction, encapsulation, inheritance, polymorphism, association, and high cohesion across core domain entities.
- **SOLID Principles**: Strict adherence to Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, and Dependency Inversion principles.
- **Custom Exception Hierarchy**: A three-tiered custom exception model (`DomainException` → `OrderException` → `InsufficientStockException`) integrated with SLF4J logging for robust runtime error management.
- **Functional Programming**: Usage of `@FunctionalInterface`, Java stream operations, dynamic lambda expressions, and method references.
- **Standard Project Structure**: Organized following the standard Maven layout, separating `domain`, `application`, and `infrastructure` layers.

## How to Run the Project
1. Clone this repository to your local machine.
2. Open the project folder in Visual Studio Code with the Java Extension Pack installed.
3. Build the project using Maven.
4. Run the unit tests with JUnit 5 to verify that all business rules and exceptions behave as expected.

## Authors & Environment
**Developers:**
- Danna Valentina Chamorro Castellar
- Stefany Alejandra Garzón Quevedo

**Institution:** Universidad Manuela Beltrán (UMB)
**IDE & Tools:** Visual Studio Code, GitHub Copilot, Java 21, Gradle, JUnit 5.
