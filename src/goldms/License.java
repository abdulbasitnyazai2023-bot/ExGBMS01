/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class License extends javax.swing.JFrame {

    /**
     * Creates new form Customers
     */
    public License() {
        initComponents();
        getConnection();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadTable();
        generateSystemId();
       
        
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
    private void loadTable() {
    try {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        ps = conn.prepareStatement("SELECT * FROM License");
        rs = ps.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("License_id"),
                rs.getString("License_key_hash"),
                rs.getString("Type"),
                rs.getInt("Duration_days"),
                rs.getInt("Is_used"),
                rs.getString("Created_at")
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
    private String generateSystemId() {
    try {
        String os = System.getProperty("os.name");
        String arch = System.getProperty("os.arch");
        String mac = java.net.InetAddress.getLocalHost().getHostName();

        String raw = os + arch + mac;
        return hashString(raw);

    } catch (Exception e) {
        return null;
    }
}
    private String hashString(String input) {
    try {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(input.getBytes("UTF-8"));

        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02X", b));
        }

        return sb.toString();

    } catch (Exception e) {
        return null;
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtnic2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtnic3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtnic5 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtnic6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(16, 23, 42));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(0, 102, 255));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_refresh_34px_1.png"))); // NOI18N
        jButton2.setText("Clear");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 560, 160, 40));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("License ID:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 40));

        txtnic2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtnic2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtnic2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnic2ActionPerformed(evt);
            }
        });
        jPanel2.add(txtnic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 320, 40));

        jPanel3.setBackground(new java.awt.Color(30, 41, 59));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 181, 3));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 181, 3));
        jLabel3.setText("License Managment");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(170, 170, 170)
                .addComponent(jLabel3)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 60));

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("License Type:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trial", "Monthly", "Yearly", "Lifetime" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 320, 40));

        txtnic3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtnic3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtnic3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnic3ActionPerformed(evt);
            }
        });
        jPanel2.add(txtnic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 320, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Duration(days):");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 40));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Is Used:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, 40));

        txtnic5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtnic5.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtnic5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnic5ActionPerformed(evt);
            }
        });
        jPanel2.add(txtnic5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 320, 40));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 640, 1));

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("License Key Hash:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, 40));

        txtnic6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtnic6.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtnic6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnic6ActionPerformed(evt);
            }
        });
        jPanel2.add(txtnic6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 320, 40));

        jButton3.setBackground(new java.awt.Color(0, 102, 255));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_create_34px.png"))); // NOI18N
        jButton3.setText("Generate License");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 280, 40));

        jButton4.setBackground(new java.awt.Color(0, 102, 255));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_save_34px_1.png"))); // NOI18N
        jButton4.setText("Save");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 560, 160, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Key", "Type", "Days", "Is Used", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 790, 300));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        //search customer
/*
        try {
            ps = conn.prepareStatement("SELECT *FROM Customers WHERE Customers_id=?");
            ps.setString(1, txtID.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                txtfullname.setText(rs.getString(2));
                txtnic.setText(rs.getString(3));
                txtphone.setText(rs.getString(4));
                txtaddress.setText(rs.getString(5));

            } else {
                JOptionPane.showMessageDialog(this, "به این آی دی" + txtID.getText() + "مشتری نیست!");
            }
        } catch (Exception e) {
        }
        */
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        ///add new customer
/*
        try {
            String id = txtID.getText();
            String full = txtfullname.getText();
            String nic = txtnic.getText();
            String p = txtphone.getText();
            String add = txtaddress.getText();
            if (id.equals("") || full.equals("") || nic.equals("") || p.equals("") || add.equals("")) {
                JOptionPane.showMessageDialog(this, "فیلدها را پر کنید!");
            } else {
                ps = conn.prepareStatement("INSERT INTO Customers(Customers_id,Fullname,NIC,Phone,Address)VALUES(?,?,?,?,?)");
                ps.setString(1, txtID.getText());
                ps.setString(2, txtfullname.getText());
                ps.setString(3, txtnic.getText());
                ps.setString(4, txtphone.getText());
                ps.setString(5, txtaddress.getText());
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(this, "Successfuly added new Customer");
                txtID.setText("");
                txtfullname.setText("");
                txtaddress.setText("");
                txtphone.setText("");
                txtnic.setText("");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
      new Exite().setVisible(true);   
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtnic2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnic2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnic2ActionPerformed

    private void txtnic3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnic3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnic3ActionPerformed

    private void txtnic5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnic5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnic5ActionPerformed

    private void txtnic6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnic6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnic6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 

    try {

        // 1️⃣ Generate Full System Hash
        String fullHash = generateSystemId();

        if (fullHash == null) {
            JOptionPane.showMessageDialog(this, "System ID Error!");
            return;
        }

        // 2️⃣ Short Key
        String licenseKey = fullHash.substring(0, 32);

        // 3️⃣ Get Data
        String type = jComboBox1.getSelectedItem().toString();
        int days = Integer.parseInt(txtnic3.getText());

        // 4️⃣ Insert According To Your Table
        ps = conn.prepareStatement(
            "INSERT INTO License (License_key_hash, Type, Duration_days) VALUES (?,?,?)"
        );

        ps.setString(1, licenseKey);
        ps.setString(2, type);
        ps.setInt(3, days);

        ps.executeUpdate();

        // 5️⃣ Show In Fields
        txtnic6.setText(licenseKey);
        txtnic5.setText("0");

        // 6️⃣ Refresh Table
        loadTable();

        JOptionPane.showMessageDialog(this, "کلید لیسانس ایجاد شد وثبت !");

    } catch (SQLException e) {

        if (e.getMessage().contains("UNIQUE")) {
            JOptionPane.showMessageDialog(this, "مشخصات این سیستم موجود است");
        } else {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
    }

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(License.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(License.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(License.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(License.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new License().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtnic2;
    private javax.swing.JTextField txtnic3;
    private javax.swing.JTextField txtnic5;
    private javax.swing.JTextField txtnic6;
    // End of variables declaration//GEN-END:variables
}
