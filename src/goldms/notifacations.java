
package goldms;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Abdul Basit Niazi
 */
public class notifacations extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public notifacations() {
        initComponents();
        getConnection();
        formSetting();
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

    private void formSetting() {
        try {
            // فعال کردن FlatLaf و گرد کردن گوشه‌ها
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Component.arc", 50);
            UIManager.put("Button.arc", 50);
            UIManager.put("TextComponent.arc", 60);

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txttypperations = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txttypperations1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(16, 23, 42));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("تاریخ رویداد:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 100, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 170, 3));
        jLabel2.setText("رودیدادهای سیستم");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("نوع رودیداد:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 130, -1, -1));

        txttypperations.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اضافه شده", "حذف شده", "ویرایش", " " }));
        jPanel1.add(txttypperations, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 390, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, -1, -1));

        txttypperations1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اضافه شده", "حذف شده", "ویرایش", " " }));
        jPanel1.add(txttypperations1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 390, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new Exite().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        GOLDMS dm = new GOLDMS();
        dm.form();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new notifacations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> txttypperations;
    private javax.swing.JComboBox<String> txttypperations1;
    // End of variables declaration//GEN-END:variables
}
