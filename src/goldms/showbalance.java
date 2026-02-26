/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class showbalance extends javax.swing.JFrame {

    /**
     * Creates new form Customers
     */
    public showbalance() {
        initComponents();
        getConnection();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
 // Pagination
    int currentPage = 1;
    int rowsPerPage = 10;
    int totalPages = 0;
    // د ډیټابېس مسیر (Path)
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    void getConnection() {

        try {
            // SQLite Driver Load
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:./src/db/Golds-1.db");
int offset = (currentPage - 1) * rowsPerPage;
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
        jPanel2 = new javax.swing.JPanel();
        txtfullname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblpage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtfull = new javax.swing.JLabel();
        txtphone = new javax.swing.JLabel();
        txtaddres = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtnin = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(16, 23, 42));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtfullname.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtfullname.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel2.add(txtfullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 720, 40));

        jLabel3.setBackground(new java.awt.Color(255, 181, 3));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ـــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("بیلانس نقره:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblpage.setText("jLabel5");
        jPanel2.add(lblpage, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 730, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 181, 3));
        jLabel5.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("نمایش بیلانس مشتری");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, -1, -1));

        txtfull.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtfull.setForeground(new java.awt.Color(255, 255, 255));
        txtfull.setText("نام مشتری:");
        jPanel2.add(txtfull, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 390, -1, -1));

        txtphone.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtphone.setForeground(new java.awt.Color(255, 255, 255));
        txtphone.setText("تلفون:");
        jPanel2.add(txtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 440, -1, -1));

        txtaddres.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtaddres.setForeground(new java.awt.Color(255, 255, 255));
        txtaddres.setText("آدرس:");
        jPanel2.add(txtaddres, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 520, -1, 40));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("بیلانس دالر:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, -1, -1));

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("بیلانس افغانی:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, -1, -1));

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("بیلانس طلا:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, -1, -1));

        txtnin.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtnin.setForeground(new java.awt.Color(255, 255, 255));
        txtnin.setText("آدرس:");
        jPanel2.add(txtnin, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 480, -1, 40));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("جستجوی به نام کامل مشتری");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        //search customer

        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
      new Exite().setVisible(true);   
    }//GEN-LAST:event_jLabel1MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
                                         



    }//GEN-LAST:event_formWindowActivated

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        
        try {
            ps = conn.prepareStatement("SELECT *FROM Customers WHERE Fullanme=?");
            ps.setString(1, txtfullname.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                txtfullname.setText(rs.getString(2));
                txtnin.setText(rs.getString(3));
                txtphone.setText(rs.getString(4));
                txtaddres.setText(rs.getString(5));

            } else {
                JOptionPane.showMessageDialog(this, "به این آی دی" + txtfullname.getText() + "مشتری نیست!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel10MouseClicked

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
            java.util.logging.Logger.getLogger(showbalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showbalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showbalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showbalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new showbalance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblpage;
    private javax.swing.JLabel txtaddres;
    private javax.swing.JLabel txtfull;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JLabel txtnin;
    private javax.swing.JLabel txtphone;
    // End of variables declaration//GEN-END:variables
}
