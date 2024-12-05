package projectfordatabaseandoop.InventoryProducts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/inventorydbb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "Hernandez14";

    // Get all products
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM inventory";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("Product_Name");
                double price = rs.getDouble("Price");
                int stock = rs.getInt("Stock");
                products.add(new Product(id, productName, price, stock));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public boolean addProduct(Product product) {
            String query = "INSERT INTO inventory (Product_Name, Price, Stock) VALUES (?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, product.getProductName());
                stmt.setDouble(2, product.getPrice());
                stmt.setInt(3, product.getStock());
                int rowsInserted = stmt.executeUpdate();
                return rowsInserted > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
        }
    }

    // Restock a product
    public boolean restockProduct(int productId, int quantity) {
        String query = "UPDATE inventory SET Stock = Stock + ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, quantity);
            stmt.setInt(2, productId);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a product
    public boolean deleteProduct(int productId) {
        String query = "DELETE FROM inventory WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, productId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Modify a product
    public boolean modifyProductPrice(int productId, double newPrice) {
        String query = "UPDATE inventory SET Price = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, newPrice);
            stmt.setInt(2, productId);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }}
}
