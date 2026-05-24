# Student Leave Management System

A desktop-based **Student Leave Management System** built using **Java Swing**, **JDBC**, and **MySQL**.
The application provides a graphical interface to manage student leave requests efficiently while following a clean layered architecture.

---

## Features

* Apply leave requests through GUI
* View all leave applications in a table (JTable)
* Delete leave records by ID
* Fetch leave details by ID *(backend ready)*
* Update leave status *(backend ready)*
* Input validation through service layer

---

## Tech Stack

* Java (Swing)
* JDBC
* MySQL
* SQL

---

## Project Structure

```id="sl1"
Student-Leave-Management-System/
│
├── src/
│   ├── dao/        → database interaction (JDBC)
│   ├── dto/        → leave request data model
│   ├── service/    → business logic & validation
│   ├── ui/         → Swing GUI
│   └── mysql-connector-j-9.x.x.jar
│
├── .gitignore
└── README.md
```

---

## Architecture Overview

The project follows a layered architecture to ensure separation of responsibilities:

* **DTO** – represents leave request data
* **DAO** – handles database operations using JDBC
* **Service** – manages validations and business rules
* **UI** – provides a graphical interface for user interaction

---

## Database Setup

```sql id="sl2"
CREATE DATABASE rnsitdb;
USE rnsitdb;

CREATE TABLE leave_requests (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100),
    reason VARCHAR(255),
    from_date VARCHAR(20),
    to_date VARCHAR(20),
    status VARCHAR(50)
);
```

---

## Running the Project

1. Ensure MySQL server is running
2. Update database credentials in:

   ```
   dao/LeaveDAOImpl.java
   ```
3. Compile the project:

   ```bash
   javac -d . -cp src/mysql-connector-j-9.x.x.jar src/*/*.java
   ```
4. Run the application:

   ```bash
   java -cp ".;src/mysql-connector-j-9.x.x.jar" ui.LeaveUI
   ```

---

## Future Improvements

* Approve/reject leave requests
* Search leave applications by student name
* Add authentication system
* Improve UI using layout managers
* Track leave history and analytics

---

## What I Learned

* Structuring Java applications using layered architecture
* Integrating Java Swing with MySQL using JDBC
* Managing leave records using SQL
* Building interactive desktop-based applications

---

## Author

Manjula R.
