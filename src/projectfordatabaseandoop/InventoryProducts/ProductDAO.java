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
        String checkQuery = "SELECT Stock FROM inventory WHERE TRIM(LOWER(Product_Name)) = TRIM(LOWER(?))";
        String updateQuery = "UPDATE inventory SET Stock = Stock + ? WHERE TRIM(LOWER(Product_Name)) = TRIM(LOWER(?))";
        String insertQuery = "INSERT INTO inventory (Product_Name, Price, Stock) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Step 1: Check if the product exists
            try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                checkStmt.setString(1, product.getProductName());
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next()) {
                    // Product exists, get current stock
                    int currentStock = rs.getInt("Stock");

                    // Step 2: Ask for additional quantity
                    String additionalStockStr = JOptionPane.showInputDialog(
                        "The product already exists with stock: " + currentStock + "\nEnter quantity to add:"
                    );
                    if (additionalStockStr == null) {
                        return false; // User canceled
                    }
                    try {
                        int additionalStock = Integer.parseInt(additionalStockStr);
                        if (additionalStock < 0) {
                            JOptionPane.showMessageDialog(null, "Quantity cannot be negative.");
                            return false;
                        }

                        // Step 3: Update stock
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                            updateStmt.setInt(1, additionalStock);
                            updateStmt.setString(2, product.getProductName());
                            int rowsUpdated = updateStmt.executeUpdate();
                            return rowsUpdated > 0;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                        return false;
                }
            }
        }
        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
            insertStmt.setString(1, product.getProductName());
            insertStmt.setDouble(2, product.getPrice());
            insertStmt.setInt(3, product.getStock());
            int rowsInserted = insertStmt.executeUpdate();
            return rowsInserted > 0;
        }
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
