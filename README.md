# Employee Management System (JDBC + MySQL)

This is a **simple Employee Management System** built using **Java, JDBC, and MySQL**.  
The system allows users to:
- **Insert multiple employees** into the database.
- **Search for an employee** using their ID.

---

## 🚀 Setup & Execution

### 1️⃣ **Create MySQL Database & Table**
Run the following SQL commands in **MySQL**:

```sql
CREATE DATABASE emp;
USE emp;

CREATE TABLE employee (
    Id INT PRIMARY KEY,
    Name VARCHAR(100),
    Salary DOUBLE,
    Address VARCHAR(255)
);


git clone https://github.com/pappukumar35/Employee-Management-JDBC.git
cd Employee-Management-JDBC

