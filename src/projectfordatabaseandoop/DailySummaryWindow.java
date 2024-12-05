package projectfordatabaseandoop;


import java.awt.Dimension;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.table.JTableHeader;

public class DailySummaryWindow extends javax.swing.JFrame {

    public DailySummaryWindow() {
        initComponents();
        loadSalesData();
        setLocationRelativeTo(null);
        setResizable(false);
        
        JTableHeader tableHeader = SalesTable.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 12)); 
        tableHeader.setPreferredSize(new Dimension(tableHeader.getPreferredSize().width, 30)); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        SalesTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SalesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sale ID", "Total Amount", "Data/Time"
            }
        ));
        jScrollPane1.setViewportView(SalesTable);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("View All Sales");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         loadAllSalesData();       // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DailySummaryWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DailySummaryWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DailySummaryWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DailySummaryWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new DailySummaryWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SalesTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private static final String URL = "jdbc:mysql://localhost:3306/inventorydbb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "Hernandez14";
    
    private void loadSalesData() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Sale ID", "Total Amount", "Date/Time"});
        SalesTable.setModel(model);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            java.sql.Date today = new java.sql.Date(System.currentTimeMillis());

            String query = "SELECT sale_id, total_amount, timestamp FROM sales WHERE DATE(timestamp) = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDate(1, today);
            ResultSet rs = stmt.executeQuery();

            boolean hasSales = false;
            while (rs.next()) {
                hasSales = true;
                int saleId = rs.getInt("sale_id");
                double totalSales = rs.getDouble("total_amount");
                Timestamp timestamp = rs.getTimestamp("timestamp");
                model.addRow(new Object[]{saleId, String.format("%.2f", totalSales), timestamp});
            }

            if (!hasSales) {
                model.addRow(new Object[]{"No sales recorded for today", "", ""});
            }
        } catch (SQLException e) {
            model.addRow(new Object[]{"Error retrieving sales data", "", ""});
    }
}
    
    private void loadAllSalesData() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Sale ID", "Total Amount", "Date/Time"});
        SalesTable.setModel(model);

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                // SQL query to retrieve all sales data
                String query = "SELECT sale_id, total_amount, timestamp FROM sales ORDER BY timestamp DESC";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                boolean hasSales = false;
                while (rs.next()) {
                    hasSales = true;
                    int saleId = rs.getInt("sale_id");
                    double totalSales = rs.getDouble("total_amount");
                    Timestamp timestamp = rs.getTimestamp("timestamp");
                    model.addRow(new Object[]{saleId, String.format("%.2f", totalSales), timestamp});
                }

                if (!hasSales) {
                    model.addRow(new Object[]{"No sales recorded in the inventory", "", ""});
                }
            } catch (SQLException e) {
                model.addRow(new Object[]{"Error retrieving sales data", "", ""});
        }
    }
}


