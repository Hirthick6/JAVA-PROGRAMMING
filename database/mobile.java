import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Mobile {
    private int modelId;
    private String modelName;
    private double price;
    private String company;

    public Mobile(int modelId, String modelName, double price, String company) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.price = price;
        this.company = company;
    }

    public void decreasePrice(double amount) {
        this.price -= amount;
    }

    @Override
    public String toString() {
        return String.format("Model ID: %d\nModel Name: %s\nPrice: %.2f\nCompany: %s\n",
                modelId, modelName, price, company);
    }
}

public class MobileShowroomDatabase {
    public static void main(String[] args) {
        // Database credentials
        String jdbcUrl = "jdbc:mysql://localhost:3306/mobile_showroom";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Creating mobile table if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS mobile " +
                    "(model_id INT PRIMARY KEY, " +
                    " model_name VARCHAR(255), " +
                    " price DOUBLE, " +
                    " company VARCHAR(255))";
            PreparedStatement createTableStatement = connection.prepareStatement(createTableSQL);
            createTableStatement.execute();

            // Inserting mobile data
            String insertDataSQL = "INSERT INTO mobile (model_id, model_name, price, company) VALUES (?, ?, ?, ?)";
            PreparedStatement insertDataStatement = connection.prepareStatement(insertDataSQL);
            insertDataStatement.setInt(1, 1);
            insertDataStatement.setString(2, "Mobile A");
            insertDataStatement.setDouble(3, 5000);
            insertDataStatement.setString(4, "Nokia");
            insertDataStatement.execute();

            insertDataStatement.setInt(1, 2);
            insertDataStatement.setString(2, "Mobile B");
            insertDataStatement.setDouble(3, 6000);
            insertDataStatement.setString(4, "Samsung");
            insertDataStatement.execute();

            // Decreasing price for Samsung mobiles
            String decreasePriceSQL = "UPDATE mobile SET price = price - 1000 WHERE company = 'Samsung'";
            PreparedStatement decreasePriceStatement = connection.prepareStatement(decreasePriceSQL);
            decreasePriceStatement.executeUpdate();

            // Retrieving and displaying mobile details
            String selectDataSQL = "SELECT * FROM mobile";
            PreparedStatement selectDataStatement = connection.prepareStatement(selectDataSQL);
            ResultSet resultSet = selectDataStatement.executeQuery();

            System.out.println("Mobile Showroom Inventory:");
            while (resultSet.next()) {
                Mobile mobile = new Mobile(
                        resultSet.getInt("model_id"),
                        resultSet.getString("model_name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("company")
                );
                System.out.println(mobile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
