/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.awt.Color;
import java.awt.Component;
import java.sql.*;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.event.*;

import javax.swing.table.*;

/**
 *
 * @author DELL
 */
public class Approval_Request extends javax.swing.JFrame {

    /**
     * Creates new form Approval_Request
     */
    public Approval_Request() {
        initComponents();
        getConnection();
        setLocationRelativeTo(this);

    }

    // د ډیټابېس مسیر (Path)
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    void getConnection() {

        try {
            // SQLite Driver Load
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:./src/db/Golds-1.db");

            System.out.println("cont");

        } catch (ClassNotFoundException ex) {
            System.out.println("not found" + ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "null", "null"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1430, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

// 1. لومړی موډل د میتود په سر کې یا د کلاس په کچه تعریف کړئ
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"جواب به درخواست", "آی دی", "نوع معامله", "آی دی موجودی", "مقدار", "ارز", "نوع دارایی", "Status"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };

        jTable1.setModel(model);

// 2. د ډېټا لوډ کولو برخه
        try {
            // ډاډ ترلاسه کړئ چې conn او SQL سم دي
            String sql = "SELECT request_id, entity_type, entity_id, amount, currency, asset_type, status FROM approval_requests ORDER BY requested_at DESC";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            model.setRowCount(0); // د جدول پاکول مخکې له نوي ډېټا [cite: 4]

            while (rs.next()) {
                boolean isPending = "PENDING".equals(rs.getString("status"));

                Object[] row = {
                    isPending, // Select (Boolean) [cite: 5]
                    rs.getInt("request_id"), // ID [cite: 5]
                    rs.getString("entity_type"), // Transaction Type [cite: 5]
                    rs.getInt("entity_id"), // Entity ID [cite: 5]
                    rs.getDouble("amount"), // Amount [cite: 5]
                    rs.getString("currency"), // Currency [cite: 5]
                    rs.getString("asset_type"), // Asset [cite: 5]
                    rs.getString("status") // Status [cite: 5]
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

// 3. د چک باکس ایډیټ کولو منطق
        jTable1.getDefaultEditor(Boolean.class).addCellEditorListener(new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {
                // له جدول څخه مستقیم موډل اخیستل ترڅو "mode نه پیژني" ستونزه حل شي
                DefaultTableModel currentModel = (DefaultTableModel) jTable1.getModel();
                int row = jTable1.getEditingRow();
                if (row < 0) {
                    row = jTable1.getSelectedRow();
                }

                if (row >= 0) {
                    Boolean selected = (Boolean) currentModel.getValueAt(row, 0);
                    String status = currentModel.getValueAt(row, 7).toString();
// که REJECTED وي او تیک شي -> بېرته PENDING ته لاړ شي
                    if (selected && "REJECTED".equals(status)) {
                        try {
                            int requestId = (int) currentModel.getValueAt(row, 1);
                            String sql = "UPDATE approval_requests SET status = ? WHERE request_id = ?";
                            ps = conn.prepareStatement(sql);
                            ps.setString(1, "PENDING");
                            ps.setInt(2, requestId);
                            ps.executeUpdate();

                            currentModel.setValueAt("PENDING", row, 7);
//                            currentModel.setValueAt(false, row, 0);
                            currentModel.setValueAt(true, row, 0);
                            jTable1.repaint();
                            return;
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    // که COMPLETE وي او تیک شي -> بېرته PENDING ته لاړ شي
                    if (selected && "COMPLETE".equals(status)) {
                        try {
                            int requestId = (int) currentModel.getValueAt(row, 1);
                            String sql = "UPDATE approval_requests SET status = ? WHERE request_id = ?";
                            ps = conn.prepareStatement(sql);
                            ps.setString(1, "PENDING");
                            ps.setInt(2, requestId);
                            ps.executeUpdate();

                            currentModel.setValueAt("PENDING", row, 7);
                            currentModel.setValueAt(true, row, 0);  // تیک پاتې شي

                            jTable1.repaint();
                            return;
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (selected && "PENDING".equals(status)) {
                        String[] options = {"Approve", "Reject", "Cancel"};
                        int choice = JOptionPane.showOptionDialog(null, "Select Action", "Approval",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                        String newStatus = "";
                        if (choice == 0) {
                            newStatus = "COMPLETE";
                        } else if (choice == 1) {
                            newStatus = "REJECTED";
                        }

                        if (!newStatus.isEmpty()) {
                            try {
                                int requestId = (int) currentModel.getValueAt(row, 1);
                                String sql = "UPDATE approval_requests SET status = ? WHERE request_id = ?";
                                ps = conn.prepareStatement(sql);
                                ps.setString(1, newStatus);
                                ps.setInt(2, requestId);
                                int executeUpdate = ps.executeUpdate();

                                currentModel.setValueAt(newStatus, row, 7);
                                currentModel.setValueAt(false, row, 0);

                                jTable1.repaint();
                                return;
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            currentModel.setValueAt(false, row, 0);
                        }
                    }
                }
            }

            @Override
            public void editingCanceled(ChangeEvent e) {
            }
        });

// 4. د رنګونو تنظیم (Renderer)
        jTable1.getColumn("Status").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (value != null) {
                    String status = value.toString();
                    switch (status) {
                        case "PENDING":
                            setBackground(Color.YELLOW);
                            break;
                        case "COMPLETE":
                            setBackground(Color.GREEN);
                            break;
                        case "REJECTED":
                            setBackground(Color.RED);
                            break;
                        default:
                            setBackground(Color.WHITE);
                    }
                }
                return this;
            }
        });
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Approval_Request.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Approval_Request.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Approval_Request.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Approval_Request.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        GOLDMS gb = new GOLDMS();
        gb.form();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Approval_Request().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
