# Spring Boot Hexagonal DDD Template

This is a Spring Boot template implementing **Hexagonal Architecture (Ports and Adapters)** and **Domain-Driven Design (DDD)** principles.

## Architecture

```text
src/main/java/com/zair/
├── application/                    # Application layer
│   ├── exceptions/                     # Application specific exceptions
│   ├── ports/                          # Ports (interfaces for primary and secondary ports)
│   │   ├── in/                             # Input ports (use cases exposed to primary adapters)
│   │   └── out/                            # Output ports (interfaces implemented by secondary adapters)
│   └── services/                       # Application services (use case implementations)
│
├── domain/                         # Domain layer
│   ├── events/                         # Domain events
│   ├── exceptions/                     # Domain specific exceptions
│   └── model/                          # Domain models and aggregates
│       ├── aggregates/                     # Aggregate roots
│       ├── entities/                       # Entities with identity
│       └── valueobjects/                   # Value Objects (immutable, equality by value)
│
├── infrastructure/                 # Infrastructure layer
│   ├── adapters/                       # Adapters (primary and secondary)
│   │   ├── in/                             # Primary adapters (REST controllers, etc.)
│   │   └── out/                            # Secondary adapters (repositories, external services)
│   └── config/                         # Configuration classes
│
└── SpringBootHexagonalDddTemplateApplication.java  # Application entry point

src/test/                           # Test directory
├── java/                               # Test source files
└── resources/                          # Test resources
```
