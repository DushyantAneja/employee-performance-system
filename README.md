# Employee Performance Management System

## Overview

A Spring Boot REST API for managing employee performance data, including employees, departments, projects, and performance reviews. The application supports filtering employees by performance score, department, and project, and retrieving detailed employee information.

## Features

### Endpoints
- **GET** `/api/employees?reviewDate=YYYY-MM-DD&minScore=X&departmentIds=A,B&projectIds=C,D`: List employees with filters
- **GET** `/api/employees/{id}`: Get detailed employee info, including department, projects, and last 3 performance reviews

### Installation

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd employee-performance
   ```

2. **Build and Run**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. **Access the Application**:
   - **API**: http://localhost:8080/api/employees
   - **H2 Console**: http://localhost:8080/h2-console 
     - Username: `sa`
     - Password: (empty)
       
## API Usage

### Filter Employees
```bash
curl "http://localhost:8080/api/employees?reviewDate=2025-01-01&minScore=80&departmentIds=1,2&projectIds=1"
```

### Get Employee Details
```bash
curl "http://localhost:8080/api/employees/1"
```

## Assumptions

- Used H2 for simplicity; replace with PostgreSQL/MySQL for production
- Implemented many-to-many relationship for Employee-Project using a join table
- Added DTO for detailed employee response to optimize data transfer

## Industry Standards

### Code Structure
- Follows MVC pattern with clear separation of concerns
- Adheres to Java naming conventions and REST best practices
