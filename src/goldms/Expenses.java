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
public class Expenses extends javax.swing.JFrame {

    /**
     * Creates new form Expenses
     */
    public Expenses() {
        initComponents();
        getConnection();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtamount = new javax.swing.JTextField();
        remove = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtemp = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtcurrency = new javax.swing.JComboBox<>();
        txtdis = new javax.swing.JTextField();
        txttype = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(16, 23, 42));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, -1, -1));

        jButton3.setText("update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, -1, -1));

        txtID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIDFocusGained(evt);
            }
        });
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 270, -1));

        txtamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 270, -1));

        remove.setText("reomve");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("توضیحات:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("جستحو");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("نوع مصارف:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("مقدار:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("نوع ارز:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, -1, -1));

        txtemp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "Manager", " " }));
        jPanel1.add(txtemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 270, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("آی دی مصارف:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

        txtcurrency.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "usd", "afg" }));
        jPanel1.add(txtcurrency, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 270, -1));

        txtdis.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtdis, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 270, -1));

        txttype.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txttype, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 270, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("نام کارمند:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            ps = conn.prepareStatement("INSERT INTO Expense(Expense_id,Employee_id,Expense_type,Amount,Currency,Discription)VALUES(?,?,?,?,?,?)");
//            String select = txtcurrency.getSelectedItem().toString();
//            if (select.equals("افغانی")) {
//                select = "afg";
//                ps.setString(5, select);
//                System.out.println(select);
//
//            } else {
//                select = "usd";
//                 ps.setString(5, select);
//                System.out.println(select);
//            }
            ps.setString(1, txtID.getText());
            ps.setString(2, txtemp.getSelectedItem().toString());
            ps.setString(3, txttype.getText());
            ps.setString(4, txtamount.getText());
            ps.setString(5, txtcurrency.getSelectedItem().toString());
            ps.setString(6, txtdis.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "مصارف ثبت شد");
            txtID.setText("");
            txttype.setText("");
            txtamount.setText("");
            txtdis.setText("");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {

            ps = conn.prepareStatement("UPDATE Expense SET Employee_id=?,Expense_type=?,Amount=?,Currency=?,Discription=? WHERE Expense_id=?");
//            String select = txtcurrency.getSelectedItem().toString();
//            if (select.equals("افغانی")) {
//                select = "afg";
//                ps.setString(5, select);
//                System.out.println(select);
//
//            } else {
//                select = "usd";
//                 ps.setString(5, select);
//                System.out.println(select);
//            }

            ps.setString(1, txtemp.getSelectedItem().toString());
            ps.setString(2, txttype.getText());
            ps.setString(3, txtamount.getText());
            ps.setString(4, txtcurrency.getSelectedItem().toString());
            ps.setString(5, txtdis.getText());
            ps.setString(6, txtID.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "مصارف موافقانه ویرایش شد!");
            txtID.setText("");
            txttype.setText("");
            txtamount.setText("");
            txtdis.setText("");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusGained
        // TODO add your handling code here:
        ///max idd

        try {
            ps = conn.prepareStatement("select max(Expense_id)+1 from Expense");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtID.setText(rs.getString("max(Expense_id)+1"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }//GEN-LAST:event_txtIDFocusGained

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
//remove employee
        try {

            String txtid = txtID.getText();
            String full = txtamount.getText();
            if (txtid.equals("") || full.equals("")) {
                JOptionPane.showMessageDialog(this, "اول باید معلومات را از دیتابییس بگیرید سپس حذف کنید!");

            } else {

                ps = conn.prepareStatement("DELETE FROM Expense WHERE Expense_id=?");
                ps.setString(1, txtID.getText());
                int a = JOptionPane.showConfirmDialog(null, "ایاموفق هستیدکه" + txtID.getText() + "است حذف شود؟", "پيام برنامه", JOptionPane.YES_OPTION);
                if (a == 0) {

                    ps.executeUpdate();
                    ps.close();
                    JOptionPane.showMessageDialog(null, "موافقانه مصارف حذف شد!");
                    txtID.setText("");
                    txtamount.setText("");
                    txttype.setText("");
                    txtdis.setText("");
                  

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_removeActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        try {
            ps = conn.prepareStatement("SELECT *FROM Expense WHERE Expense_id=?");
            ps.setString(1, txtID.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                txtemp.setSelectedItem(rs.getString(2));
                txttype.setText(rs.getString(3));
                txtamount.setText(rs.getString(4));
                txtcurrency.setSelectedItem(rs.getString(5));
                txtdis.setText(rs.getString(6));

            } else {
                JOptionPane.showMessageDialog(this, "به این آی دی" + txtID.getText() + "مصارف نیست!");
            }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_jLabel3MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            String emp = txtemp.getSelectedItem().toString();

            ps = conn.prepareStatement("SELECT*FROM Expense WHERE Employee_id=?");
            ps.setString(1, emp);
            rs = ps.executeQuery();
            if (rs.next()) {

                int role_id = rs.getInt("Employee_id"); // 👈 از دیتابیس بگیر
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>'
        GOLDMS gb = new GOLDMS();
        gb.form();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Expenses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton remove;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtamount;
    private javax.swing.JComboBox<String> txtcurrency;
    private javax.swing.JTextField txtdis;
    private javax.swing.JComboBox<String> txtemp;
    private javax.swing.JTextField txttype;
    // End of variables declaration//GEN-END:variables
}
