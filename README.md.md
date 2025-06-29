
# 📚 Advanced Library Management System – Exercise 3

Welcome to the **Library Management System**, a Java-based console application developed as part of the *Advanced Programming* course – Exercise 3.

> 🧠 Focus: **Object-Oriented Design**, **Inheritance**, **Interfaces**, and **Practical Command-Line Processing**

---

## 🚀 Features

✅ Object-Oriented Architecture (Inheritance, Interface usage)  
✅ Role-based Access Control (Admin, Students, Professors, etc.)  
✅ Multiple Resource Types: Books, Theses, Rare Books, and Sale Items  
✅ Command-Based System for managing libraries, users, resources  
✅ Persian Input Support ✍️  
✅ Manual & Automated Input Validation

---

## 🏗️ Class Architecture

- `User` (abstract): Base for all user roles
  - `Admin`
  - `Student`
  - `Professor`
  - `Staff`
  - `LibraryManager`
- `Resource` (abstract): Base for all resource types
  - `Book`
  - `Thesis`
  - `GanjinehBook`
  - `SellingBook`

> JavaDoc is used throughout the project for full API documentation.

---

## ⚙️ Installation Guide

### Prerequisites
- Java JDK 8 or higher installed

### Steps

```bash
# Check Java installation
java -version

# Clone the project
git clone https://github.com/your-username/library-management-system.git
cd library-management-system

# Compile and run
javac Main.java
java Main
```

---

## 🧾 Command Samples

Each operation is executed via structured commands in the following format:

### ➕ Add a Library
```
add-library#admin|AdminPass|L001|Central Library|1358|38|Aut Main Campus
```

### ➕ Add a Student
```
add-student#admin|AdminPass|14010011234|PassWd|Test|Testi|0123456789|1382|Tehran, Mirdamad
```

### 🔍 Search for Resources
```
search#Programming
```

### 📘 Borrow a Book
```
borrow#14010011234|PassWd|L001|B001|2025-04-10|10:00
```

---

## 📦 Output Messages

- `success` ✅ – Operation completed
- `duplicate-id` 🔁 – ID already exists
- `not-found` ❓ – Item or user not found
- `permission-denied` 🔐 – Insufficient privileges
- `invalid-pass` 🔑 – Incorrect password
- `not-allowed` 🚫 – Rule violation (e.g. overdue, duplicate borrow)

---

## 📮 Contact

If you have questions, suggestions, or encounter bugs, please reach out via GitHub issues or contact the course instructors.

---
**© 2025 - Advanced Programming – Dr. Kalbasi & Dr. Zeynali**
