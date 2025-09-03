# Capstone_Project_PayRoll_Management_System
# Payroll Management System

A full-stack web application to streamline employee payroll processing, attendance tracking, statutory compliance, and payslip generation.  
Built using **Spring Boot** (Java) for backend, **MySQL** for data storage, and an optional **React** frontend for a modern user interface.

---

## 🚀 Features

- **Role-Based Access Control**
  - **Admin:** Manage employees, salary structures, payroll periods, and reports.
  - **HR:** Attendance/leave management, approvals, employee onboarding.
  - **Employees:** View profiles, apply for leave, download payslips.

- **Payroll Processing**
  - Automatic computation of gross/net salaries.
  - Support for allowances, deductions, and statutory contributions (PF/ESI/Tax).

- **Attendance & Leave Integration**
  - Import attendance records and adjust payroll accordingly.
  - Leave approval workflows.

- **Document Generation**
  - PDF payslips and payroll registers.
  - Exportable bank advice and tax forms.

- **Reports & Analytics**
  - Payroll summaries and component-wise analytics.
  - Audit-ready logs for compliance.

---

## 🛠️ Tech Stack

**Backend**
- Java 17, Spring Boot, Spring Security, JWT Authentication
- Spring Data JPA, Hibernate ORM
- MySQL / PostgreSQL Database
- Springdoc OpenAPI (Swagger)

**Frontend (optional)**
- React 18, Vite, React Router, Tailwind CSS
- Axios for API calls

**Other**
- Maven/Gradle for build
- Docker-ready configuration (optional)

---

## 📂 Project Structure

payroll-management-system/
│
├── backend/
│ ├── src/main/java/... # Spring Boot application code
│ ├── src/main/resources/ # application.properties, templates
│ └── pom.xml # Maven dependencies
│
├── frontend/ (optional)
│ ├── src/ # React components and routes
│ └── package.json # Frontend dependencies


---

## ⚙️ Setup & Installation

### Prerequisites
- Java 17+
- Maven or Gradle
- Node.js & npm (for frontend)
- MySQL (or other configured DB)

### Backend Setup
```bash
cd backend
# Update DB credentials in src/main/resources/application.properties
mvn clean package -DskipTests
java -jar target/*.jar
# Swagger UI: http://localhost:8080/swagger-ui/index.html


### Frontend Setup
cd frontend
npm install
npm run dev
# Visit: http://localhost:5173

### Testing
mvn test

