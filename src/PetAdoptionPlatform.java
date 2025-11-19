
// Imports
import java.sql.*;
import java.util.Scanner;

public class PetAdoptionPlatform {
    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/pet_adoption"; // MySQL URL
    private static final String USER = "root"; // MySQL username
    private static final String PASSWORD = "1231231230"; // MySQL password

    public static void main(String[] args) {
        // Establishing a connection to the database
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(conn); // Create the Pets table if it doesn't exist

            // User input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the Pet Adoption Platform!");
            // Add a new pet
            System.out.println("1. Add Pet");
            // View all pets
            System.out.println("2. View All Pets");
            System.out.print("Choose an option: ");
            // User's choice
            int choice = scanner.nextInt();

            // Adding a pet or viewing all pets based on user input
            if (choice == 1) {
                // Call method to add a new pet
                addPet(conn, scanner);
            } else if (choice == 2) {
                // Call method to view all pets
                viewAllPets(conn);
            } else {
                System.out.println("Invalid choice!"); // Handle invalid choice
            }
        } catch (SQLException e) {
            // Handle database connection failure
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    // Method to create the Pets table in the database
    private static void createTable(Connection conn) throws SQLException {
        // SQL statement to create the Pets table if it doesn't exist
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Pets ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, " // Primary key with auto-increment
                + "name VARCHAR(50), " // Pet's name
                + "breed VARCHAR(50), " // Pet's breed
                + "age INT, " // Pet's age
                + "isAvailable BOOLEAN DEFAULT true)"; // Availability status
        // Execute the SQL statement
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Pets table is ready."); // Confirmation message
        }
    }

    // Method to add a new pet to the database
    private static void addPet(Connection conn, Scanner scanner) throws SQLException {
        // Collecting pet details from user input
        System.out.print("Enter pet name: ");
        // Pet's name
        String name = scanner.next();
        System.out.print("Enter pet breed: ");
        // Pet's breed
        String breed = scanner.next();
        System.out.print("Enter pet age: ");
        // Pet's age
        int age = scanner.nextInt();
        System.out.print("Is the pet available for adoption? (true/false): ");
        // Pet's availability status
        boolean isAvailable = scanner.nextBoolean();

        // SQL statement to insert a new pet into the Pets table
        String insertSQL = "INSERT INTO Pets (name, breed, age, isAvailable) VALUES (?, ?, ?, ?)";
        // Prepare the SQL statement to prevent SQL injection
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            // Setting the parameters for the prepared statement
            pstmt.setString(1, name);
            pstmt.setString(2, breed);
            pstmt.setInt(3, age);
            pstmt.setBoolean(4, isAvailable);
            pstmt.executeUpdate(); // Execute the insert operation
            System.out.println("Pet added successfully."); // Confirmation message
        }
    }

    // Method to retrieve and display all pets from the database
    private static void viewAllPets(Connection conn) throws SQLException {
        // SQL statement to select all pets from the Pets table
        String selectSQL = "SELECT * FROM Pets";
        // Execute the select statement and process the results
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(selectSQL)) {
            while (rs.next()) {
                // Display each pet's details
                System.out.println("ID: " + rs.getInt("id")
                        + ", Name: " + rs.getString("name")
                        + ", Breed: " + rs.getString("breed")
                        + ", Age: " + rs.getInt("age")
                        + ", Available: " + rs.getBoolean("isAvailable"));
            }
        }
    }
}

// // Output
// Welcome to the Pet Adoption Platform!
// 1. Add Pet
// 2. View All Pets
// Choose an option: 1
// Pets table is ready.
// Enter pet name: Buddy
// Enter pet breed: Golden Retriever
// Enter pet age: 3
// Is the pet available for adoption? (true/false): true
// Pet added successfully.

// Choose an option: 2
// ID: 1, Name: Buddy, Breed: Golden Retriever, Age: 3, Available: true
