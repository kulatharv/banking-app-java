# Java Banking Application — Console Based Project

A simple and fully functional Banking Management System developed in Core Java using a Console-Based Interface.
This project demonstrates core programming concepts such as Object-Oriented Programming (OOP), file handling, user authentication, and transaction management.

# Project Overview
  - The Java Banking Application allows users to:
  - Create an account
  - Login using secure authentication
  - Deposit money
  - Withdraw money
  - Check available balance
  - View transaction history
  - Maintain persistent data storage using serialization

**This project is ideal for:**
  - College assignments
  - Java mini-projects
  - Learning OOP concepts
  - Understanding file handling in Java

**Features** 


  1. User Authentication
     -Register using a username and password
     -Passwords are securely hashed before storage
     -Login with credential validation
  
   3. Banking Operations
        - Deposit money
        - Withdraw money (with insufficient balance checks)
        - Check account balance
        - View detailed transaction history
    
  4. Persistent Storage
        - User data stored in a local file using object serialization
        - Automatically loads existing data on startup
        - Automatically saves state after every operation
    
  5. Clean Modular Code
        - User.java → Handles user data & transactions
        - BankSystem.java → Contains all banking logic
        - Utils.java → Password hashing utilities
        - Main.java → Main application (menu-driven program)

**Technologies Used**
    Technology	Purpose
        - Java (Core Java)	Main programming language
        - OOP Principles	Class, Object, Encapsulation
        - File Handling (Serialization)	Persistent data storage
        - SHA-256 Hashing	Secure password management
        - VS Code / IntelliJ / Eclipse	IDE

**Project Structure**
    banking-app-java/
    │
    ├── Main.java             # Main program (menu-driven)
    ├── BankSystem.java       # Core banking functionalities
    ├── User.java             # User model class
    ├── Utils.java            # Hashing utility functions
    │
    ├── users.db              # Auto-generated storage file
    ├── README.md             # Project documentation
    └── .gitignore            # Git ignore file

**How to Run the Project**
  1. Clone the repository
          git clone https://github.com/kulatharv/banking-app-java.git
          cd banking-app-java
    
  2. Compile the Java files
          javac *.java
    
  3. Run the application
          java Main

**Sample Console Output**

                === Banking App ===
        1. Register
        2. Login
        3. Exit
        Choose: 1
        Choose username: atharv
        Choose password: ****

         Registration successful!
        
        === Banking App ===
        1. Register
        2. Login
        3. Exit
        Choose: 2
        Username: atharv
        Password: ****

        Welcome atharv!
  
        1. Deposit
        2. Withdraw
        3. Check Balance
        4. Transaction History
        5. Logout
  
 

**Security Features**
       - Uses SHA-256 Hashing to store passwords (not plain text)
       - Prevents balance from going below zero
       - Data is stored in a serialized file to avoid direct editing


**Future Enhancements**
    - Here are additional features that can be added:
    - Role-based Admin Login
    - Funds Transfer between users
    - Loan Module
    - ATM Simulation
    - GUI version using Java Swing / JavaFX
    - Database integration (MySQL / SQLite)

**Author**
      Atharv Ramesh Kulkarni
      GitHub: @kulatharv

**License**
      This project is licensed under the MIT License.
