/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class Treasury extends javax.swing.JFrame {

    /**
     * Creates new form Treasury
     */
    public Treasury() {
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

        jPanel1 = new javax.swing.JPanel();
        txtdisc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txusd = new javax.swing.JTextField();
        txtafg = new javax.swing.JTextField();
        txtgold = new javax.swing.JTextField();
        txtsilver = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(16, 23, 42));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtdisc.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtdisc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtdisc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdiscFocusGained(evt);
            }
        });
        txtdisc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdiscKeyTyped(evt);
            }
        });
        jPanel1.add(txtdisc, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 390, 40));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 170, 3));
        jLabel2.setText("ثبت خزانه");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("توضیحات:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, -1));

        txtId.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdFocusGained(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 390, 40));

        txusd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txusd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txusd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txusdFocusGained(evt);
            }
        });
        txusd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txusdKeyTyped(evt);
            }
        });
        jPanel1.add(txusd, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 390, 40));

        txtafg.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtafg.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtafg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtafgFocusGained(evt);
            }
        });
        txtafg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtafgKeyTyped(evt);
            }
        });
        jPanel1.add(txtafg, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 390, 40));

        txtgold.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtgold.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtgold.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtgoldFocusGained(evt);
            }
        });
        txtgold.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtgoldKeyTyped(evt);
            }
        });
        jPanel1.add(txtgold, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 390, 40));

        txtsilver.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtsilver.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsilver.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtsilverFocusGained(evt);
            }
        });
        txtsilver.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsilverKeyTyped(evt);
            }
        });
        jPanel1.add(txtsilver, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 390, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("آی دی خزانه:");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ٔدالر:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("افغانی:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, -1, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("طلا:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, -1, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("نقره:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButton1.setText("حذف");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 640, 390, 40));

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButton2.setText("ثبت");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 540, 390, 40));

        jButton3.setBackground(new java.awt.Color(255, 153, 0));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButton3.setText("ویرایش");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 590, 390, 40));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("آی دی خزانه:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdiscFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdiscFocusGained

    }//GEN-LAST:event_txtdiscFocusGained

    private void txtdiscKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscKeyTyped
////        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        String search = txtsearch.getText();
//        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
////        jTable1.setRowSorter(tr);
//        tr.setRowFilter(RowFilter.regexFilter(search));

    }//GEN-LAST:event_txtdiscKeyTyped

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new Exite().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained
        try {
            ps = conn.prepareStatement("select max(Capital_id)+1 from Capital");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtId.setText(rs.getString("max(Capital_id)+1"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }//GEN-LAST:event_txtIdFocusGained

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKeyTyped

    private void txusdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txusdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txusdFocusGained

    private void txusdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txusdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txusdKeyTyped

    private void txtafgFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtafgFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtafgFocusGained

    private void txtafgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtafgKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtafgKeyTyped

    private void txtgoldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtgoldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgoldFocusGained

    private void txtgoldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgoldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgoldKeyTyped

    private void txtsilverFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsilverFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsilverFocusGained

    private void txtsilverKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsilverKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsilverKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            
            String txtid = txtId.getText();
            String full = txtafg.getText();
            if (txtid.equals("") || full.equals("")) {
                JOptionPane.showMessageDialog(this, "اول باید معلومات را از دیتابییس بگیرید سپس حذف کنید!","<",JOptionPane.OK_OPTION);
                
            } else {
                
                ps = conn.prepareStatement("DELETE  FROM Capital WHERE  Capital_id=?");
                ps.setString(1, txtId.getText());
                int a = JOptionPane.showConfirmDialog(null, "ایاموفق هستیدکه" + txtId.getText() + "است حذف شود؟", "پيام برنامه", JOptionPane.YES_OPTION);
                if (a == 0) {
                    
                    ps.executeUpdate();
                    ps.close();
                    JOptionPane.showMessageDialog(null, "موافقانه مشتری حذف شد");
                }
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "بسیار به معذرت سرمایه بعد از ثبت فقط خوانده نی است نمیتونید آنرا حذف کنید!");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            ps = conn.prepareStatement("INSERT INTO Capital (Capital_id,USD,AF,Gold_gram,Silver_gram,Description)VALUES(?,?,?,?,?,?)");
            ps.setString(1, txtId.getText());
            ps.setString(2, txusd.getText());
            ps.setString(3, txtafg.getText());
            ps.setString(4, txtgold.getText());
            ps.setString(5, txtsilver.getText());
            ps.setString(6, txtdisc.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "سرمایه موافقانه اضافه شد!");
            txtId.setText("");
            txusd.setText("");
            txtafg.setText("");
            txtgold.setText("");
            txtsilver.setText("");
            txtdisc.setText("");

        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        try {
            ps = conn.prepareStatement("SELECT *FROM Capital WHERE Capital_id=?");
            ps.setString(1, txtId.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                txusd.setText(rs.getString(2));
                txtafg.setText(rs.getString(3));
                txtgold.setText(rs.getString(4));
                txtsilver.setText(rs.getString(5));
                txtdisc.setText(rs.getString(6));

            }
            else{
                JOptionPane.showMessageDialog(this, "به این آی دی معامله ثبت نشده!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            ps = conn.prepareStatement("UPDATE Capital SET USD=?,AF=?,Gold_gram=?,Silver_gram=?,Description=? WHERE Capital_id=?");
            ps.setString(1, txusd.getText());
            ps.setString(2, txtafg.getText());
            ps.setString(3, txtgold.getText());
            ps.setString(4, txtsilver.getText());
            ps.setString(5, txtdisc.getText());
            ps.setString(6, txtId.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "موافقانه سرمایه ویرایش شد!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "بسیار به معذرت سرمایه بعد از ثبت فقط خوانده نی است نمیتونید آنرا ویرایش کنید!");
            
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
            java.util.logging.Logger.getLogger(Treasury.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Treasury.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Treasury.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Treasury.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Treasury().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtafg;
    private javax.swing.JTextField txtdisc;
    private javax.swing.JTextField txtgold;
    private javax.swing.JTextField txtsilver;
    private javax.swing.JTextField txusd;
    // End of variables declaration//GEN-END:variables
}
