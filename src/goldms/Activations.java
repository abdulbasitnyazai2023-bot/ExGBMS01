/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.awt.Image;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class Activations extends javax.swing.JFrame {

    /**
     * Creates new form Activations
     */
    public Activations() {
        initComponents();
        getConnection();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtidsystem = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtlicens = new javax.swing.JTextField();
        txtstate = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtidsystem1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("آي دی لیسانس:");

        txtidsystem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtidsystem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtid.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtidFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("آي دی سیستم:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("آی دی فعالسازی:");

        txtlicens.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtlicens.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtlicens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlicensActionPerformed(evt);
            }
        });

        txtstate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "blocked", "active" }));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("تاریخ ختم:");

        jButton1.setText("add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtidsystem1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtidsystem1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("jLabel5");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jButton3.setText("jButton2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("وضیعت:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(307, 307, 307))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(txtstate, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtidsystem, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(txtidsystem1))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtlicens, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(555, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(88, 88, 88)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlicens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtidsystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidsystem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(txtstate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(85, 85, 85))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(120, 120, 120)
                    .addComponent(jLabel3)
                    .addContainerGap(340, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            String sql = "INSERT INTO Activation "
                    + "(License_id, System_uuid, Expire_at, Status) "
                    + "VALUES (?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtlicens.getText())); // License_id
            ps.setString(2, txtidsystem.getText());               // System_uuid
            ps.setString(3, txtidsystem1.getText());               // Expire_at
            ps.setString(4, txtstate.getSelectedItem().toString()); // Status

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "فعال‌سازی موفقانه اضافه شد");
            this.txtid.setText("");
            this.txtidsystem.setText("");
            this.txtidsystem1.setText("");
            this.txtlicens.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidFocusGained

        try {
            ps = conn.prepareStatement("select max(Activation_id)+1 from Activation");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtid.setText(rs.getString("max(Activation_id)+1"));
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_txtidFocusGained

    private void txtlicensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlicensActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlicensActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            // گرفتن تاریخ فعلی میلادی
//    LocalDateTime now = LocalDateTime.now();
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    String gregorianDate = now.format(formatter);
            String sql = "UPDATE Activation SET "
                    + "System_uuid = ?, "
                    + "Expire_at = ?, "
                    + "Status = ? "
                    + "WHERE License_id = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, txtidsystem.getText());               // System_uuid
            ps.setString(2, txtidsystem1.getText());               // Expire_at
            ps.setString(3, txtstate.getSelectedItem().toString()); // Status
            ps.setInt(4, Integer.parseInt(txtlicens.getText())); // License_id

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {

                // نمایش تاریخ جلالی
//        PersianDate jalali = PersianDate.now();
//        txtDateLabel.setText(jalali.toString());
                JOptionPane.showMessageDialog(this, "ویرایش موفقانه انجام شد");
                this.txtid.setText("");
                this.txtidsystem.setText("");
                this.txtidsystem1.setText("");
                this.txtlicens.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "رکوردی پیدا نشد");
                this.txtid.setText("");
                this.txtidsystem.setText("");
                this.txtidsystem1.setText("");
                this.txtlicens.setText("");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        try {
            ps = conn.prepareStatement("SELECT *FROM Activation WHERE Activation_id=?");
            ps.setString(1, txtid.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                txtlicens.setText(rs.getString(2));
                txtidsystem.setText(rs.getString(3));
                txtidsystem1.setText(rs.getString(4));
                txtstate.setSelectedItem(rs.getString(5));

            } else {
                JOptionPane.showMessageDialog(this, "به این آی دی" + txtid.getText() + "کارمند نیست!");
                this.txtid.setText("");
                this.txtidsystem.setText("");
                this.txtidsystem1.setText("");
                this.txtlicens.setText("");
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {

            String txtid = this.txtid.getText();
            String full = txtidsystem.getText();
            if (txtid.equals("") || full.equals("")) {
                JOptionPane.showMessageDialog(this, "اول باید معلومات را از دیتابییس بگیرید سپس حذف کنید!");

            } else {

                ps = conn.prepareStatement("DELETE FROM Activation WHERE Activation_id=?");
                ps.setString(1, this.txtid.getText());
                int a = JOptionPane.showConfirmDialog(null, "ایاموفق هستیدکه" + this.txtid.getText() + "است حذف شود؟", "پيام برنامه", JOptionPane.YES_OPTION);
                if (a == 0) {

                    ps.executeUpdate();
                    ps.close();
                    JOptionPane.showMessageDialog(null, "موافقانه کلید فعال سازی حذف شد!");
                    this.txtid.setText("");
                    this.txtidsystem.setText("");
                    this.txtidsystem1.setText("");
                    this.txtlicens.setText("");

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Activations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Activations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Activations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Activations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GOLDMS gb = new GOLDMS();
        gb.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Activations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidsystem;
    private javax.swing.JTextField txtidsystem1;
    private javax.swing.JTextField txtlicens;
    private javax.swing.JComboBox<String> txtstate;
    // End of variables declaration//GEN-END:variables
}
