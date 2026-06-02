# 📚 Library Management System

## 🧾 Project Overview
This is a Spring Boot based Library Management System developed to manage library operations such as adding books, updating book details, deleting books, and searching books efficiently.

The system provides a simple and user-friendly interface for managing library records.

---

## ⚙️ Tech Stack
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- MySQL
- Thymeleaf
- HTML
- CSS
- Bootstrap

---

## 🚀 Features
- 🔐 User Login System
- 📚 Add New Books
- ✏️ Update Book Details
- ❌ Delete Books
- 🔍 Search Books
- 📊 Dashboard View
- 🗄️ Database Integration with MySQL

---

## 🏗️ Project Architecture
The project follows MVC architecture:

- **Controller** → Handles HTTP requests
- **Service** → Business logic layer
- **Repository** → Database operations (JPA)
- **Entity** → Database tables mapping
- **Templates** → UI layer (Thymeleaf)

---

## 📂 Project Structure


src/main/java
└── com.example.library
├── controller
├── service
├── repository
├── entity

src/main/resources
├── templates
├── static
└── application.properties



---

## 🛠️ How to Run the Project

### 1. Clone Repository
git clone https://github.com/your-username/Library-Management-System.git


### 2. Import Project
Open in STS / Eclipse as Maven Project

### 3. Configure Database
Create MySQL database:
EX: CREATE DATABASE librarydb;


Update `application.properties`:
spring.datasource.url=jdbc:mysql://localhost:3306/librarydb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


### 4. Run Application
Run main class:

Run As → Spring Boot App


---

## 🌐 Access Application
After running, open browser:

http://localhost:8080


---

## 📸 Screenshots
(Add your screenshots here)
- Login Page
- Dashboard
- Add Book Page
- Book List Page

---

## 👩‍💻 Developer
Rohini Sonwane

---

## 📌 Note
This project is developed for learning and internship/placement purposes using Spring Boot and MySQL.

---

## ⭐ Thank You
