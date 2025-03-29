import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/emp";  // Ensure 'emp' database exists
        String user = "root";  // Your MySQL username
        String password = "Pappu@123";  // Your MySQL password

        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Insert Multiple Employees
            String insertSQL = "INSERT INTO employee (Id, Name, Salary, Address) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                System.out.print("How many employees do you want to insert? ");
                int count = sc.nextInt();
                sc.nextLine(); // Consume newline

                for (int i = 1; i <= count; i++) {
                    System.out.println("\nEnter details for Employee " + i);
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine(); // Consume newline

                    System.out.print("Enter Employee Address: ");
                    String address = sc.nextLine();

                    pstmt.setInt(1, id);
                    pstmt.setString(2, name);
                    pstmt.setDouble(3, salary);
                    pstmt.setString(4, address);

                    pstmt.executeUpdate();
                }
                System.out.println("\n✅ Employees inserted successfully!");
            }

            // Search Employee by ID
            String searchSQL = "SELECT * FROM employee WHERE Id = ?";
            try (PreparedStatement searchStmt = conn.prepareStatement(searchSQL)) {
                System.out.print("\nEnter Employee ID to search: ");
                int searchId = sc.nextInt();

                searchStmt.setInt(1, searchId);
                ResultSet rs = searchStmt.executeQuery();

                if (rs.next()) {
                    System.out.println("\n🔍 Employee Found:");
                    System.out.println("ID: " + rs.getInt("Id"));
                    System.out.println("Name: " + rs.getString("Name"));
                    System.out.println("Salary: " + rs.getDouble("Salary"));
                    System.out.println("Address: " + rs.getString("Address"));
                } else {
                    System.out.println("❌ No employee found with ID " + searchId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
