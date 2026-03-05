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
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
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
        jButton1 = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtUsername = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(16, 23, 42));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 170, 3));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_login_23px.png"))); // NOI18N
        jButton1.setText("ورود");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 390, 40));

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 390, 40));

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameKeyTyped(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 390, 40));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jCheckBox1.setText("نمایش رمز");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, -1, 30));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("رمز عبور:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 70, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 170, 3));
        jLabel2.setText("ورود به سیستم");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("اسم کاربری:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            txtPassword.setEchoChar('\0');

        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained

    }//GEN-LAST:event_txtUsernameFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            String username = txtUsername.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "تمام فیلدها را پر کنید!");
                return;
            }

            String sql = "SELECT * FROM Login WHERE Username=? AND Password_hash=? AND Is_active=1";

            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {

                int role_id = rs.getInt("Role_id"); // 👈 از دیتابیس بگیر
//                txttype.setSelectedItem(role_id);
                if (role_id == 1) {
                    Dashboard dash = new Dashboard(role_id);
                    dash.setVisible(true);
                    dash.txtusername.setText(username);

                    ps.close();
                } else if (role_id == 2) {
                    Dashboard dash = new Dashboard(role_id);
                    dash.setVisible(true);
                    System.out.println(role_id);
                    dash.txtusername.setText(username);
                    ps.close();
                } else {
                    Dashboard dash = new Dashboard(role_id);
                    dash.setVisible(true);
                    System.out.println(role_id);
                    dash.txtusername.setText(username);
                    ps.close();
                }

                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "رمز عبور یا اسم کاربری غلط است!");
                txtUsername.setText("");
                txtPassword.setText("");
            } 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
        char c = evt.getKeyChar();
        if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z')) {
            evt.consume();

        }
    }//GEN-LAST:event_txtUsernameKeyTyped

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new Exite().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked
    int posX, posY;
    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        posX = evt.getX();
        posY = evt.getY();

    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        this.setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
    }//GEN-LAST:event_jPanel1MouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        GOLDMS dm = new GOLDMS();
        dm.form();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
