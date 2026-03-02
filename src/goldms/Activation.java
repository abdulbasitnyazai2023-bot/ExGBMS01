/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;


import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Enumeration;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Activation extends javax.swing.JFrame {

    /**
     * Creates new form Customers
     */
    public Activation() {
        initComponents();
        getConnection();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFingerprint();
       
      
       
        
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
//    private String getFingerprint() {
//    try {
//        String os = System.getProperty("os.name");
//        String arch = System.getProperty("os.arch");
//        String user = System.getProperty("user.name");
//
//        String raw = os + arch + user;
//
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        byte[] hash = md.digest(raw.getBytes("UTF-8"));
//
//        StringBuilder sb = new StringBuilder();
//        for (byte b : hash) {
//            sb.append(String.format("%02X", b));
//        }
//
//        return sb.toString();
//
//    } catch (Exception e) {
//        return null;
//    }
//}
 




    // --- Fingerprint تولید ---
    public static String getFingerprint() {
        StringBuilder sb = new StringBuilder();

        try {
            String os = System.getProperty("os.name");
        String arch = System.getProperty("os.arch");
        String user = System.getProperty("user.name");

        String raw = os + arch + user;

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(raw.getBytes("UTF-8"));
         for (byte b : hash) {
            sb.append(String.format("%02X", b));
        }

         

            // MAC Address
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface ni : Collections.list(interfaces)) {
                byte[] mac = ni.getHardwareAddress();
                if (mac != null) {
                    for (byte b : mac) {
                        sb.append(String.format("%02X", b));
                    }
                    break;
                }
            }

            // CPU ID (Windows)
            String cpuId = System.getenv("PROCESSOR_IDENTIFIER");
            if (cpuId != null) sb.append(cpuId);

            // Disk Serial (Windows)
            String diskSerial = System.getenv("SystemDrive"); // مثلا C:
            if (diskSerial != null) sb.append(diskSerial);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    // --- SHA-256 hash ---
    public static String sha256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                String h = Integer.toHexString(0xff & b);
                if (h.length() == 1) hex.append('0');
                hex.append(h);
            }
            return hex.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

      
    




public class ActivationChecker {

    private Connection conn; // ستاسو SQLite connection

    public ActivationChecker(Connection connection) {
        this.conn = connection;
    }



    // --- SHA-256 ---
    private String sha256(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(input.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            String h = Integer.toHexString(0xff & b);
            if (h.length() == 1) hex.append('0');
            hex.append(h);
        }
        return hex.toString();
    }

    // --- سیستم چک او Lock کول ---
    public boolean checkAndLockSystem() {
        String fingerprintHash;
        try {
            fingerprintHash = sha256(getFingerprint());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fingerprint hash error: " + e.getMessage());
            return false;
        }

        String query = "SELECT * FROM Activation WHERE Fingerprint_hash=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, fingerprintHash);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    // Fingerprint موجود نه دی، سیستم Activate شوی نه دی
                    JOptionPane.showMessageDialog(null, "System not activated!");
                    return false;
                }

                String status = rs.getString("Status");
                String expireAt = rs.getString("Expire_at");
                String lastRun = rs.getString("Last_run");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               java.util.Date now = new java.util.Date();
               java.util.Date expireDate;
               java.util.Date lastRunDate;

                try {
                    expireDate = sdf.parse(expireAt);
                    lastRunDate = sdf.parse(lastRun);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Date format error!");
                    return false;
                }

                // ✅ Date Back Protection
                if (now.before(lastRunDate) || !status.equals("active")) {
                    lockSystem(fingerprintHash);
                    JOptionPane.showMessageDialog(null, "System blocked due to invalid usage!");
                    return false;
                }

                // ✅ Expire Check
                if (now.after(expireDate)) {
                    lockSystem(fingerprintHash);
                    JOptionPane.showMessageDialog(null, "License expired! System blocked!");
                    return false;
                }

                // ✅ Update Last Run
                try (PreparedStatement psUpdate = conn.prepareStatement(
                        "UPDATE Activation SET Last_run=? WHERE Fingerprint_hash=?")) {
                    psUpdate.setString(1, sdf.format(now));
                    psUpdate.setString(2, fingerprintHash);
                    psUpdate.executeUpdate();
                }

                // System active and valid
                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // --- سیستم Lock کول ---
    private void lockSystem(String fingerprintHash) {
        try (PreparedStatement ps = conn.prepareStatement(
                "UPDATE Activation SET Status='blocked' WHERE Fingerprint_hash=?")) {
            ps.setString(1, fingerprintHash);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtnic3 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(16, 23, 42));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel3.setText("System Activation(GBMS)");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(128, 128, 128))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 60));

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Enter License Key:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, 40));

        txtnic3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtnic3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtnic3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnic3ActionPerformed(evt);
            }
        });
        jPanel2.add(txtnic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 530, 40));

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

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 640, 1));

        jButton3.setBackground(new java.awt.Color(0, 102, 255));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_server_shutdown_34px.png"))); // NOI18N
        jButton3.setText("Activate System");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 530, 40));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("-------------------------");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, -1, 40));

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Activation info");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, 40));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Activated At:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, 40));

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Expire At:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, -1, 40));

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("-------------------------");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 520, -1, 40));

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("License Type:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, -1, 40));

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("-------------------------");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 570, -1, 40));

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Statuse:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, -1, 40));

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("-------------------------");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 620, -1, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
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

       
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
      this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtnic3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnic3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnic3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    

  try {
      
    String enteredKey = txtnic3.getText().trim();

    if (enteredKey.isEmpty()) {
        JOptionPane.showMessageDialog(this, "لطفا قبل از استفاده شماباید کیلید لیسانس داشته باشد");
        return;
    }

    // 1️⃣ Check License Exists
    ps = conn.prepareStatement("SELECT * FROM License WHERE License_key_hash=?");
    ps.setString(1, enteredKey);
    rs = ps.executeQuery();

    if (!rs.next()) {
        JOptionPane.showMessageDialog(this, "این کیلد به مشخصات سیستم شمافرق دارد");
        return;
    }

    int licenseId = rs.getInt("License_id");
    int duration = rs.getInt("Duration_days"); // DB نه Duration واخلئ
    String type = rs.getString("Type");
    int isUsed = rs.getInt("Is_used");

    rs.close(); // ✅ Close ResultSet
    ps.close(); // ✅ Close PreparedStatement

    if (isUsed == 1) {
        JOptionPane.showMessageDialog(this, "این کیلد لیسانس قبلا استفاده شده است!");
        return;
    }

    // 2️⃣ Generate Fingerprint
    String fingerprint = getFingerprint();
    
    // 3️⃣ Calculate dates
    java.util.Date now = new java.util.Date();
    java.sql.Timestamp sqlNow = new java.sql.Timestamp(now.getTime());
    java.util.Calendar cal = java.util.Calendar.getInstance();
    cal.setTime(now);
    cal.add(java.util.Calendar.DAY_OF_MONTH, duration);
    java.util.Date expireDate = cal.getTime();
    java.sql.Timestamp sqlExpireDate = new java.sql.Timestamp(expireDate.getTime());

    // 4️⃣ Insert Activation Record
    ps = conn.prepareStatement(
        "INSERT INTO Activation(License_id, Fingerprint_hash, Activated_at, Expire_at, Last_run, Status) VALUES(?,?,?,?,?,?)"
    );
    ps.setInt(1, licenseId);
    ps.setString(2, fingerprint);
    ps.setTimestamp(3, sqlNow);       // Activated_at
    ps.setTimestamp(4, sqlExpireDate); // Expire_at
    ps.setTimestamp(5, sqlNow);        // Last_run
    ps.setString(6, "active");
    ps.executeUpdate();
    ps.close();

    // 5️⃣ Update License As Used
    ps = conn.prepareStatement("UPDATE License SET Is_used=1 WHERE License_id=?");
    ps.setInt(1, licenseId);
    ps.executeUpdate();
    ps.close();

    // 6️⃣ Show Info On Screen
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    jLabel13.setText(sdf.format(now));         // Activated At
    jLabel18.setText(sdf.format(expireDate));  // Expire At
    jLabel20.setText(type);                     // License Type
    jLabel22.setText("active");                 // Status

    JOptionPane.showMessageDialog(this, "سیستم به موافقیت فعال شد!");

} catch (SQLException e) {
    if (e.getMessage().contains("UNIQUE")) {
        JOptionPane.showMessageDialog(this, "سیستم قبلا فعال شده است");
    } else {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
} catch (Exception ex) {
    JOptionPane.showMessageDialog(this, ex.getMessage());
}

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Activation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Activation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Activation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Activation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

 GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Activation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtnic3;
    // End of variables declaration//GEN-END:variables
}
