import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Faculty {
    private String name;
    private String qualification;
    private String designation;
    private String subject;
    private String department;
    private double salary;

    public Faculty(String name, String qualification, String designation, String subject, String department, double salary) {
        this.name = name;
        this.qualification = qualification;
        this.designation = designation;
        this.subject = subject;
        this.department = department;
        this.salary = salary;
    }

    public void updateSalary(double percentage) {
        this.salary *= (1 + percentage / 100);
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nQualification: %s\nDesignation: %s\nSubject: %s\nDepartment: %s\nSalary: %.2f\n",
                name, qualification, designation, subject, department, salary);
    }
}

public class FacultyDatabase {
    public static void main(String[] args) {
        // Database credentials
        String jdbcUrl = "jdbc:mysql://localhost:3306/faculty_db";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Creating faculty table if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS faculty " +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, " +
                    " name VARCHAR(255), " +
                    " qualification VARCHAR(255), " +
                    " designation VARCHAR(255), " +
                    " subject VARCHAR(255), " +
                    " department VARCHAR(255), " +
                    " salary DOUBLE)";
            PreparedStatement createTableStatement = connection.prepareStatement(createTableSQL);
            createTableStatement.execute();

            // Inserting faculty data
            String insertDataSQL = "INSERT INTO faculty (name, qualification, designation, subject, department, salary) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertDataStatement = connection.prepareStatement(insertDataSQL);
            insertDataStatement.setString(1, "John Doe");
            insertDataStatement.setString(2, "Ph.D.");
            insertDataStatement.setString(3, "Professor");
            insertDataStatement.setString(4, "Computer Science");
            insertDataStatement.setString(5, "Engineering");
            insertDataStatement.setDouble(6, 50000);
            
            
            insertDataStatement.setString(1, "John");
            insertDataStatement.setString(2, "MBA");
            insertDataStatement.setString(3, "Teacher");
            insertDataStatement.setString(4, "Computer Science");
            insertDataStatement.setString(5, "Engineering");
            insertDataStatement.setDouble(6, 50000);
            insertDataStatement.execute();

            // Updating salaries of all employees by 10%
            String updateSalarySQL = "UPDATE faculty SET salary = salary * 1.1";
            PreparedStatement updateSalaryStatement = connection.prepareStatement(updateSalarySQL);
            updateSalaryStatement.execute();

            // Retrieving and displaying faculty details
            String selectDataSQL = "SELECT * FROM faculty";
            PreparedStatement selectDataStatement = connection.prepareStatement(selectDataSQL);
            ResultSet resultSet = selectDataStatement.executeQuery();

            System.out.println("Faculty Details:");
            while (resultSet.next()) {
                Faculty faculty = new Faculty(
                        resultSet.getString("name"),
                        resultSet.getString("qualification"),
                        resultSet.getString("designation"),
                        resultSet.getString("subject"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary")
                );
                System.out.println(faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
