# Inpatient Management System

A full-stack healthcare application to manage inpatient records, admissions, and billing workflows. Built with **Spring Boot**, **Angular**, **JPA/Hibernate**, and **Oracle/H2 Database**.

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Java 17, Spring Boot 3.2.2, Spring Data JPA |
| Frontend | Angular 16, TypeScript, Bootstrap 5 |
| Database | H2 (dev/demo), Oracle DB (production) |
| Build | Maven, frontend-maven-plugin |
| Containerization | Docker, Docker Compose |

## Features

- **Patient Management** — Register, update, delete, and search patients
- **Medical Records** — Create and manage patient medical records with doctor assignments
- **Admission Management** — Track patient admissions, ward assignments, and discharges
- **Billing Workflow** — Generate bills, track payments, and manage billing statuses
- **Dashboard** — Real-time overview with key metrics (patients, admissions, revenue)
- **Search** — Full-text search across all modules
- **RESTful APIs** — Clean REST API design with proper error handling
- **Responsive UI** — Professional healthcare-themed interface with sidebar navigation

## Architecture

```
├── Backend (Spring Boot)
│   ├── Controllers (REST APIs)
│   ├── Services (Business Logic)
│   ├── Repositories (JPA Data Access)
│   ├── Entities (JPA Entities)
│   └── Config (CORS, Exception Handling, Data Seeder)
│
├── Frontend (Angular 16)
│   ├── Dashboard
│   ├── Patient Management (List + Form)
│   ├── Medical Records (List + Form)
│   ├── Admission Management (List + Form)
│   └── Billing Management (List + Form)
│
└── Database
    ├── H2 In-Memory (Default)
    └── Oracle DB (Production Profile)
```

## Getting Started

### Prerequisites
- Java 17+
- Node.js 18+
- Maven 3.8+

### Run Locally

```bash
# Install frontend dependencies
npm install

# Start Angular dev server (port 4200)
npm start

# In another terminal, start Spring Boot (port 8080)
mvn spring-boot:run
```

### Build Single JAR (Full-Stack)

```bash
# Builds Angular + Spring Boot into a single executable JAR
mvn clean package

# Run the JAR
java -jar target/InpatientManagement-0.0.1.jar
```

### Docker

```bash
# Build and run with Docker
docker build -t inpatient-management .
docker run -p 8080:8080 inpatient-management

# Or use Docker Compose
docker-compose up --build
```

### Oracle DB Profile

```bash
java -jar target/InpatientManagement-0.0.1.jar --spring.profiles.active=oracle
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/dashboard` | Dashboard statistics |
| GET/POST | `/api/patients` | List/Create patients |
| GET/PUT/DELETE | `/api/patients/{id}` | Get/Update/Delete patient |
| GET/POST | `/api/records` | List/Create medical records |
| GET/PUT/DELETE | `/api/records/{id}` | Get/Update/Delete record |
| GET/POST | `/api/admissions` | List/Create admissions |
| PUT | `/api/admissions/{id}/discharge` | Discharge patient |
| GET/POST | `/api/billing` | List/Create billing records |
| PUT | `/api/billing/{id}/pay` | Mark bill as paid |
