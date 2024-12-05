package projectfordatabaseandoop;



import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.List;
import projectfordatabaseandoop.InventoryProducts.Product;
import projectfordatabaseandoop.InventoryProducts.ProductDAO;


public class ProductWindow extends javax.swing.JFrame {

 private ProductDAO productDAO;
 
    public ProductWindow() {
        productDAO = new ProductDAO();
        initComponents();
        showAvailableProducts();
        setLocationRelativeTo(null);
        setResizable(false);
        
        JTableHeader tableHeader = ProductTable.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 16)); 
        tableHeader.setPreferredSize(new Dimension(tableHeader.getPreferredSize().width, 30)); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ProductTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Price", "Stock"
            }
        ));
        ProductTable.setRowHeight(28);
        jScrollPane1.setViewportView(ProductTable);

        jButton1.setText("Restock Product");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modify Product");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Add Product");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete Product");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        addProduct();        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        restockProduct();            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        modifyPrice();                
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        deleteProduct();       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();        
    }//GEN-LAST:event_jButton5ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ProductTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private static final String URL = "jdbc:mysql://localhost:3306/inventorydbb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "Hernandez14";
    
    private void showAvailableProducts() {
        List<Product> products = productDAO.getAllProducts();
        DefaultTableModel tableModel = (DefaultTableModel) ProductTable.getModel();
        tableModel.setRowCount(0); // Clear the table

        for (Product product : products) {
            tableModel.addRow(new Object[]{product.getId(), product.getProductName(), product.getPrice(), product.getStock()});
        }

        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No available Product");
        }
    }

    private void addProduct() {
        String name = JOptionPane.showInputDialog("Enter product name:");
        if (name == null) {
            return;
        }
        String priceStr = JOptionPane.showInputDialog("Enter product price:");
        if (priceStr == null) {
            return;
        }
        String quantityStr = JOptionPane.showInputDialog("Enter product quantity:");
        if (quantityStr == null) {
            return;
        }
        try {
            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(quantityStr);

            if (price <= 0 || quantity < 0) {
                JOptionPane.showMessageDialog(this, "Invalid input. Price must be positive and quantity cannot be negative.");
                return;
            }
            Product product = new Product(0, name, price, quantity); 
            boolean success = productDAO.addProduct(product);

            if (success) {
                JOptionPane.showMessageDialog(this, "Product added successfully.");
                showAvailableProducts(); // Refresh the product list

                try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    resetAutoIncrement(conn);  // Reset AUTO_INCREMENT
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error resetting AUTO_INCREMENT: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add product.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
    }
}

    private void restockProduct() {
        String productId = JOptionPane.showInputDialog("Enter product ID to restock:");
     if (productId == null) {
            return;
        }
        String quantityStr = JOptionPane.showInputDialog("Enter quantity to add:");
        if (quantityStr == null) {
            return;
        }

        try {
            int id = Integer.parseInt(productId);
            int quantity = Integer.parseInt(quantityStr);

            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be greater than 0.");
                return;
            }

            boolean success = productDAO.restockProduct(id, quantity);
            if (success) {
                JOptionPane.showMessageDialog(this, "Product restocked successfully.");
                showAvailableProducts(); // Refresh the product list
            } else {
                JOptionPane.showMessageDialog(this, "Product ID not found.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
        }
    }

    private void modifyPrice() {
        String productId = JOptionPane.showInputDialog("Enter product ID to modify price:");
     if (productId == null) {
            return;
        }
        String newPriceStr = JOptionPane.showInputDialog("Enter new price:");
            if (newPriceStr == null) {
            return;
        }
        try {
            int id = Integer.parseInt(productId);
            double newPrice = Double.parseDouble(newPriceStr);

            if (newPrice <= 0) {
                JOptionPane.showMessageDialog(this, "Price must be greater than 0.");
                return;
            }
            boolean success = productDAO.modifyProductPrice(id, newPrice);  // Pass the int id

            if (success) {
                JOptionPane.showMessageDialog(this, "Product price updated successfully.");
                showAvailableProducts(); // Refresh the product list
            } else {
                JOptionPane.showMessageDialog(this, "Product ID not found.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
        }
    }

    private void deleteProduct() {
        String productId = JOptionPane.showInputDialog("Enter product ID to delete:");
        if (productId == null) {
            return;
        }
        try {
            int id = Integer.parseInt(productId);
            boolean success = productDAO.deleteProduct(id);

            if (success) {
                JOptionPane.showMessageDialog(this, "Product deleted successfully.");

                // Refresh the product list
                showAvailableProducts(); 

                // Ensure the connection is opened here before calling resetAutoIncrement
                try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

                    // Renumber product IDs after deletion
                    String tempTableQuery = 
                        "CREATE TEMPORARY TABLE temp_table AS " +
                        "SELECT id, (@count := @count + 1) AS new_id " +
                        "FROM (SELECT @count := 0) AS init, inventory " +
                        "ORDER BY id";

                    try (PreparedStatement tempTableStmt = conn.prepareStatement(tempTableQuery)) {
                        tempTableStmt.executeUpdate();
                    }

                    String updateQuery = 
                        "UPDATE inventory AS i " +
                        "JOIN temp_table AS t ON i.id = t.id " +
                        "SET i.id = t.new_id";

                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        updateStmt.executeUpdate();
                    }
                        showAvailableProducts(); 
                        resetAutoIncrement(conn);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error resetting AUTO_INCREMENT or renumbering product IDs: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Product ID not found.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid product ID.");
    }
}

    private void resetAutoIncrement(Connection conn) throws SQLException {
        String resetAutoIncrementQuery = "ALTER TABLE inventory AUTO_INCREMENT = 1";
        try (PreparedStatement resetStmt = conn.prepareStatement(resetAutoIncrementQuery)) {
            resetStmt.executeUpdate();
        }
    }
}
