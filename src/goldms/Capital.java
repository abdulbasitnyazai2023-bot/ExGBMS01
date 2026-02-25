/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class Capital extends javax.swing.JFrame {

    public Capital() {
        initComponents();
//total.getDocument().addDocumentListener(new DocumentListener() {
//    private boolean isUpdating = false;
//
//    @Override
//    public void insertUpdate(DocumentEvent e) { format(); }
//    @Override
//    public void removeUpdate(DocumentEvent e) { format(); }
//    @Override
//    public void changedUpdate(DocumentEvent e) { format(); }
//
//    private void format() {
//        if (isUpdating) return;
//
//        String text = total.getText().replaceAll(",", "");
//        if (text.isEmpty()) return;
//
//        try {
//            long number = Long.parseLong(text);
//            if (number >= 1000) {
//                isUpdating = true;
//
//                // مهمه برخه: د EDT په بل Runnable کې اپډیټ کول
//                SwingUtilities.invokeLater(() -> {
//                    DecimalFormat df = new DecimalFormat("#,###");
//                    total.setText(df.format(number));
//                    total.setCaretPosition(total.getText().length());
//                    isUpdating = false;
//                });
//            }
//        } catch (NumberFormatException ex) {
//            // که عدد سم نه وي، هیڅ کار مه کوه
//            isUpdating = false;
//        }
//    }
//});
        getConnection();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        styleTable();
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

    private void styleTable() {

        jTable1.setRowHeight(40);

        // حذف خطوط داخلی برای ظاهر مدرن
        jTable1.setShowGrid(false);
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));

        // رنگ هدر (بالای جدول)
        jTable1.getTableHeader().setBackground(new java.awt.Color(30, 41, 59));
        jTable1.getTableHeader().setForeground(java.awt.Color.WHITE);

        jTable1.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {

            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {

                java.awt.Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                // رنگ انتخاب
                if (isSelected) {
                    c.setBackground(new java.awt.Color(255, 181, 3)); // طلایی GBMS
                    c.setForeground(java.awt.Color.BLACK);
                } else {

                    // Zebra مدرن
                    if (row % 2 == 0) {
                        c.setBackground(new java.awt.Color(248, 249, 250));
                    } else {
                        c.setBackground(new java.awt.Color(235, 240, 245));
                    }

                    c.setForeground(java.awt.Color.BLACK);
                }

                return c;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        search = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtafg = new javax.swing.JTextField();
        txtdescription = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtusd = new javax.swing.JTextField();
        txtgold = new javax.swing.JTextField();
        txtsilver = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(16, 23, 42));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(30, 41, 59));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_save_34px_1.png"))); // NOI18N
        jButton2.setText("ثبت");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 410, 40));

        search.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_23px.png"))); // NOI18N
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });
        jPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 170, 40, 40));

        txtID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIDFocusGained(evt);
            }
        });
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 170, 420, 40));

        jLabel3.setBackground(new java.awt.Color(255, 181, 3));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 181, 3));
        jLabel3.setText("انتقال بین حساب ها");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("آی دی ثبت");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("جستجوی عمومی");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "تاریخ", "توضیحات", "مقدار نقره", "مقدار طلا", "افغانی", "دالر", "آی دی"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 1670, 550));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("افغانی");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));

        txtafg.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtafg.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtafg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtafgActionPerformed(evt);
            }
        });
        jPanel2.add(txtafg, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 420, 40));

        txtdescription.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtdescription.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtdescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescriptionActionPerformed(evt);
            }
        });
        jPanel2.add(txtdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 390, 420, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("نقره");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 230, -1, -1));

        txtusd.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtusd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtusd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusdActionPerformed(evt);
            }
        });
        jPanel2.add(txtusd, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 420, 40));

        txtgold.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtgold.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtgold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgoldActionPerformed(evt);
            }
        });
        jPanel2.add(txtgold, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 270, 420, 40));

        txtsilver.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtsilver.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsilver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsilverActionPerformed(evt);
            }
        });
        jPanel2.add(txtsilver, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 420, 40));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("دالر");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("طلا");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 230, -1, -1));

        txtsearch.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtsearch.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsearchKeyTyped(evt);
            }
        });
        jPanel2.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 710, 40));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("توضیحات");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 350, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1690, 1030));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked


    }//GEN-LAST:event_jLabel3MouseClicked

    private void txtIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusGained
        // TODO add your handling code here:

        //max id
        try {
            getConnection();
            ps = conn.prepareStatement("SELECT MAX(Capital_id)+1 FROM Capital");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtID.setText(rs.getString("MAX(Capital_id)+1"));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }//GEN-LAST:event_txtIDFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            
            String usd = txtusd.getText();
            if (usd.equals("")) {
                JOptionPane.showMessageDialog(this, "اوووو فیلدها را پرکند!");

            } else {
                getConnection();
                String sql = "INSERT INTO Capital "
                        + "(Capital_id, USD, AF, Gold_gram, Silver_gram, Description) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(txtID.getText()));
                ps.setDouble(2, Double.parseDouble(txtusd.getText().isEmpty() ? "0" : txtusd.getText()));
                ps.setDouble(3, Double.parseDouble(txtafg.getText().isEmpty() ? "0" : txtafg.getText()));
                ps.setDouble(4, Double.parseDouble(txtgold.getText().isEmpty() ? "0" : txtgold.getText()));
                ps.setDouble(5, Double.parseDouble(txtsilver.getText().isEmpty() ? "0" : txtsilver.getText()));
                ps.setString(6, txtdescription.getText().isEmpty() ? "نامعلوم" : txtdescription.getText());

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    new save().setVisible(true);
                    txtafg.setText("");
                    txtdescription.setText("");
                    txtusd.setText("");
                    txtgold.setText("");
                    txtsilver.setText("");

                    txtID.setText("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "تېروتنه: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Exite().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtafgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtafgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtafgActionPerformed

    private void txtdescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescriptionActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed

    }//GEN-LAST:event_searchKeyPressed

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        //search customer
        try {
            getConnection();
            ps = conn.prepareStatement("SELECT * FROM Capital WHERE Capital_id=?");
            ps.setString(1, txtID.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                txtusd.setText(rs.getString(2));
                txtafg.setText(rs.getString(3));
                txtgold.setText(rs.getString(4));
                txtsilver.setText(rs.getString(5));
                txtdescription.setText(rs.getString(6));

            } else {
                JOptionPane.showMessageDialog(this, "به این آی دی" + txtID.getText() + "به این ای دی صورت نگرفته");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_searchMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        try {
            getConnection();

            String sql = "SELECT *FROM Capital ORDER BY Capital_id DESC";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            model.setRowCount(0); // جدول پاک کړئ

            while (rs.next()) {

                Object[] row = {
                    rs.getString("Created_at"),
                    rs.getString("Description"),
                    rs.getString("Silver_gram"),
                    rs.getDouble("Gold_gram"),
                    rs.getString("AF"),
                    rs.getString("USD"),
                    rs.getInt("Capital_id")};
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_formWindowActivated

    private void txtusdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusdActionPerformed

    private void txtgoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgoldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgoldActionPerformed

    private void txtsilverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsilverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsilverActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void txtsearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyTyped
        //jTextField1.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String search = txtsearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtsearchKeyTyped

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
            java.util.logging.Logger.getLogger(Capital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capital().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel search;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtafg;
    private javax.swing.JTextField txtdescription;
    private javax.swing.JTextField txtgold;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtsilver;
    private javax.swing.JTextField txtusd;
    // End of variables declaration//GEN-END:variables
}
