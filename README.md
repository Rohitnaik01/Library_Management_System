# 📚 Library Management System (Java + Hibernate + MySQL)

A console-based Library Management System built using Java, Hibernate ORM, and MySQL that allows managing books and members efficiently, designed to practice ORM-based backend development with real-world database interactions.

---

## 📌 Problem Statement

Managing library records such as books, members, and their availability manually can become inefficient and error-prone.  
This project aims to simulate a basic library management system to understand how object-relational mapping (ORM) using Hibernate simplifies database operations in Java applications.

---

## ✅ Solution

This application provides a structured system to manage library resources by allowing librarians to add books, register members, view available books, and manage members.  
Hibernate ORM is used to map Java objects to database tables, reducing manual SQL and improving maintainability.

---

## ✨ Features

- Add new books with title, author, and category  
- Register library members with unique email validation  
- View all books with availability status  
- View all registered members  
- Search books by category  
- Automatic table creation and updates using Hibernate  
- ORM-based persistence with Hibernate annotations  

---

## 🛠 Tech Stack

- **Language:** Java  
- **ORM Framework:** Hibernate  
- **Database:** MySQL  
- **Build Tool:** Maven  
- **Concepts Used:**  
  - Object-Oriented Programming (OOP)  
  - Hibernate ORM & JPA Annotations  
  - Entity Relationships  
  - HQL (Hibernate Query Language)  
  - Transaction Management  
- **Tools:** Git, GitHub, MySQL, Eclipse / IntelliJ / VS Code  

---

## 📂 Project Structure

LibraryManagementSystem/
├── pom.xml
└── src/
├── main/
│ └── java/
│ ├── hibernate.cfg.xml
│ └── com/hibernateProject/LibraryManagementSystem/
│ ├── App.java
│ ├── Model/
│ │ ├── Book.java
│ │ ├── IssueRecord.java
│ │ └── Member.java
│ └── Services/
│ ├── BookManager.java
│ └── MemberManager.java
└── test/
└── java/
└── com/hibernateProject/LibraryManagementSystem/
└── AppTest.java


---

## 🧠 Module Overview

### 🔹 Models
- **Book:** Represents book details such as title, author, category, and availability  
- **Member:** Represents library members with unique email constraint  
- **IssueRecord:** Represents book issue records with issue and return dates  

### 🔹 Services
- **BookManager:** Handles adding books, listing books, and category-based search  
- **MemberManager:** Handles member registration and listing members  

### 🔹 App
- Entry point of the application  
- Handles user input and menu-driven flow  

---

## ▶️ How to Run the Project

### 1️⃣ Database Setup

Create a MySQL database named `Library`.

```sql
CREATE DATABASE Library;
```
Hibernate will automatically create and update tables based on entity classes.

2️⃣ Update Database Credentials

Update the following in hibernate.cfg.xml if needed:

<property name="hibernate.connection.url">jdbc:mysql://127.0.0.1:3306/Library</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">your_password</property>

3️⃣ Run the Application

Import the project as a Maven Project in your IDE

Ensure MySQL server is running

Run App.java

Follow the console menu options

📘 What I Learned

Using Hibernate ORM to map Java classes to database tables

Writing clean entity classes using JPA annotations

Performing CRUD operations without writing SQL queries

Using HQL for database operations

Managing transactions with Hibernate

Structuring projects using layered architecture

🚀 Future Improvements

Implement book issue and return functionality

Track issued books with return dates

Add user authentication and roles

Improve console UI and validations

Convert the project into a web application using Spring Boot

👤 Author

Naik Rohit Ramesh
GitHub: https://github.com/Rohitnaik01
