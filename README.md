# 🐾 Pet Adoption Platform

A complete **Pet Adoption Management System** that includes:

- A **Java console-based application** for managing pet details using a MySQL database.
- A **web-based login system** with three user roles: **Admin**, **Shelter**, and **Adopter**.

This project is designed for students and beginners who want to learn **Java, JDBC, MySQL, and web dashboards** for role-based systems.

---

## 📌 Table of Contents
1. Features (Console App)
2. Features (Web Login System)
3. Requirements
4. Setup Instructions
5. Database Setup
6. Console UI Preview
7. User Role Dashboards (Admin/Shelter/Adopter)
8. Project Structure
9. Technologies Used
10. Contribution
11. License

---

## 🚀 1. Console Application Features

### ➕ Add Pet
Users can enter:
- Pet Name  
- Pet Breed  
- Pet Age  
- Availability (true/false)

The details are saved directly into the MySQL database.

### 📋 View All Pets
Displays a clean list of all pets stored in the database.

---

## 🌐 2. Web Login System Features

The website login page:  
**https://github.com/ujjwalsoni03/PetAdoptionPlatform.git**

### 🔐 User Roles:
- **Admin**
- **Shelter**
- **Adopter**

Each role has its own dashboard and permissions.

---

## 👨‍💻 Admin Dashboard

### Features:
- **Manage Users** – Approve or reject Shelter and Adopter accounts.
- **Manage Pets** – View, edit, or delete any pet.
- **Reports & Analytics** – Track adoption stats and user activity.
- **System Settings** – Backup database, manage roles, update settings.

---

## 🏠 Shelter Dashboard

### Features:
- **Add Pets** – Upload new pet profiles.
- **Manage Pets** – Edit or delete their pets.
- **View Interested Adopters** – Track adoption requests.
- **Update Shelter Profile** – Change details, description, location.

---

## 👤 Adopter Dashboard

### Features:
- **Browse Pets** – Filter by breed, age, location.
- **Apply for Adoption** – Submit adoption requests.
- **Track Applications** – Check request status.
- **Update Profile** – Edit personal details.

---

## 🧰 Requirements

To run the console-based Java application:
- Java JDK 8+  
- MySQL Server  
- MySQL JDBC Driver (Connector/J)

---

## ⚙️ Setup Instructions

### **1. Clone or Download the Project**
```bash
git clone https://github.com/ujjwalsoni03/PetAdoptionPlatform.git
```

---

### **2. Database Configuration**
Ensure that **MySQL is installed and running** on your machine.

#### ➤ Create the Database
```sql
CREATE DATABASE pet_adoption;
```

---

### **3. Configure Database Connection**
Update your Java project with:
- URL: `jdbc:mysql://localhost:3306/pet_adoption`
- Username: `root`
- Password: `your_password`

Also ensure the project includes **MySQL JDBC Connector/J**.

---

### **4. Run the Console Application**
```bash
javac PetAdoptionPlatform.java
java PetAdoptionPlatform
```

---

## 🐾 Example Console Output

```
Welcome to the Pet Adoption Platform!

1. Add Pet
2. View All Pets

Choose an option: 1

Enter pet name: Bella
Enter pet breed: Labrador
Enter pet age: 3
Is the pet available for adoption? (true/false): true

Pet added successfully.
```

---

## 📂 Project Structure
```
PetAdoptionPlatform/
│
├── src/
│   ├── PetAdoptionPlatform.java
│   ├── DatabaseConnection.java
│   └── models/
│       └── Pet.java
│
├── web/
│   ├── login/
│   ├── admin-dashboard/
│   ├── shelter-dashboard/
│   └── adopter-dashboard/
│
├── README.md
└── SQL Scripts/
```

---

## 🛠️ Technologies Used
- Java (Core + JDBC)
- MySQL
- HTML / CSS / JS (for login dashboard)
- Git & GitHub

---

## 🤝 Contribution
Pull requests are welcome! Feel free to fork this repository and enhance the project.

---

## 📜 License
This project is licensed under the **MIT License**.
