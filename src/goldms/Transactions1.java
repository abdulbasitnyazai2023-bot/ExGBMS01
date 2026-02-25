/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.awt.Image;
import java.sql.*;
import static java.util.Arrays.fill;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Transactions1 extends javax.swing.JFrame {

    /**
     * Creates new form Customers
     */
    public Transactions1() {
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
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCom_ustomer = new javax.swing.JComboBox<>();
        typeofgold = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_w_t = new javax.swing.JTextField();
        Com_Type_gold = new javax.swing.JComboBox<>();
        Com_type_thing = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Recived_gold = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtnic8 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Com_txt = new javax.swing.JComboBox<>();
        Price_t = new javax.swing.JTextField();
        Price_all = new javax.swing.JTextField();
        txt_w_g = new javax.swing.JTextField();
        txt_c = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Price_t1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        Price_all1 = new javax.swing.JTextField();
        Price_t2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(16, 23, 42));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(0, 102, 255));
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
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 710, 420, 40));

        jButton3.setBackground(new java.awt.Color(0, 102, 255));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_refresh_34px_1.png"))); // NOI18N
        jButton3.setText("ویرایش");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 700, 420, 40));

        txtID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIDFocusGained(evt);
            }
        });
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 170, 420, 40));

        jButton4.setBackground(new java.awt.Color(0, 102, 255));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_delete_trash_34px_1.png"))); // NOI18N
        jButton4.setText("حذف");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 710, 420, 40));

        jLabel3.setBackground(new java.awt.Color(255, 181, 3));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 181, 3));
        jLabel3.setText("جدول ثبت معاملات ");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("نام مشتری");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("آی دی معامله");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("نوع جنس");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 280, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jCom_ustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نام مشتری" }));
        jPanel2.add(jCom_ustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 420, 40));

        typeofgold.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        typeofgold.setForeground(new java.awt.Color(255, 255, 255));
        typeofgold.setText("نوع طلا");
        jPanel2.add(typeofgold, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 280, -1, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("وزن به گرام");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        txt_w_t.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txt_w_t.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_w_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_w_tActionPerformed(evt);
            }
        });
        jPanel2.add(txt_w_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 420, 40));

        Com_Type_gold.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "پاسه", "برگ" }));
        jPanel2.add(Com_Type_gold, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 420, 40));

        Com_type_thing.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "طلا", "نقره", "مس", "پلاتین" }));
        Com_type_thing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Com_type_thingActionPerformed(evt);
            }
        });
        jPanel2.add(Com_type_thing, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 320, 420, 40));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("وزن به طوله");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 380, -1, -1));

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("عیار طلا");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 380, -1, -1));

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("قیمت فی طوله");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 470, -1, -1));

        Recived_gold.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Recived_gold.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Recived_gold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recived_goldActionPerformed(evt);
            }
        });
        jPanel2.add(Recived_gold, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 420, 40));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("قیمت مجموعی");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 470, -1, -1));

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("گرفت طلا");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, -1, -1));

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("پرداخت طلا");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 560, -1, -1));

        txtnic8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtnic8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtnic8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnic8ActionPerformed(evt);
            }
        });
        jPanel2.add(txtnic8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 600, 420, 40));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("نوع معامله");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        Com_txt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "خرید", "فروش" }));
        jPanel2.add(Com_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 420, 40));

        Price_t.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Price_t.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Price_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Price_tActionPerformed(evt);
            }
        });
        jPanel2.add(Price_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 510, 420, 40));

        Price_all.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Price_all.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Price_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Price_allActionPerformed(evt);
            }
        });
        jPanel2.add(Price_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, 420, 40));

        txt_w_g.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txt_w_g.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_w_g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_w_gActionPerformed(evt);
            }
        });
        jPanel2.add(txt_w_g, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 420, 40));

        txt_c.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txt_c.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cActionPerformed(evt);
            }
        });
        jPanel2.add(txt_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 420, 420, 40));

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("گرفت نقره");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 560, -1, -1));

        Price_t1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Price_t1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Price_t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Price_t1ActionPerformed(evt);
            }
        });
        jPanel2.add(Price_t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 600, 420, 40));

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("پراخت نقره");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 570, -1, -1));

        Price_all1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Price_all1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Price_all1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Price_all1ActionPerformed(evt);
            }
        });
        jPanel2.add(Price_all1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 600, 420, 40));

        Price_t2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Price_t2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Price_t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Price_t2ActionPerformed(evt);
            }
        });
        jPanel2.add(Price_t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 420, 40));

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("وزن به طوله");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 70, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1690, 810));

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        /*
        try {

            String txtid = txtID.getText();
            String full = txtfullname.getText();
            if (txtid.equals("") || full.equals("")) {
                JOptionPane.showMessageDialog(this, "اول باید معلومات را از دیتابییس بگیرید سپس حذف کنید!");

            } else {

                ps = conn.prepareStatement("delete from Customers where Customers_id=?");
                ps.setString(1, txtID.getText());
                int a = JOptionPane.showConfirmDialog(null, "ایاموفق هستیدکه" + txtID.getText() + "است حذف شود؟", "پيام برنامه", JOptionPane.YES_OPTION);
                if (a == 0) {

                    ps.executeUpdate();
                    ps.close();
                    JOptionPane.showMessageDialog(null, "موافقانه مشتری حذف شد");
                    txtID.setText("");
                    txtfullname.setText("");
                    txtaddress.setText("");
                    txtphone.setText("");
                    txtnic.setText("");

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
         */
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusGained
        // TODO add your handling code here:

        //max id
/*
        try {
            ps = conn.prepareStatement("select max(Customers_id)+1 from Customers");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtID.setText(rs.getString("max(Customers_id)+1"));
            }
        } catch (Exception e) {

        }
         */
    }//GEN-LAST:event_txtIDFocusGained

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        //update customer
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
                ps = conn.prepareStatement("UPDATE Customers SET Fullname=?,NIC=?,Phone=?,Address=? WHERE Customers_id=?");

                ps.setString(1, txtfullname.getText());
                ps.setString(2, txtnic.getText());
                ps.setString(3, txtphone.getText());
                ps.setString(4, txtaddress.getText());
                ps.setString(5, txtID.getText());
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(this, "موافقانه معلومات" + txtfullname.getText() + "-" + "ویرایش شد");
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
    }//GEN-LAST:event_jButton3ActionPerformed

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

    private void txt_w_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_w_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_w_tActionPerformed

    private void Recived_goldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recived_goldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recived_goldActionPerformed

    private void txtnic8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnic8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnic8ActionPerformed

    private void Price_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Price_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Price_tActionPerformed

    private void Price_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Price_allActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Price_allActionPerformed

    private void txt_w_gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_w_gActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_w_gActionPerformed

    private void txt_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cActionPerformed

    private void Price_t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Price_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Price_t1ActionPerformed

    private void Price_all1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Price_all1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Price_all1ActionPerformed

    private void Price_t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Price_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Price_t2ActionPerformed

    private void Com_type_thingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Com_type_thingActionPerformed
        String gold = Com_type_thing.getSelectedItem().toString().trim();
        if (gold.equals("نقره")) {
            Com_Type_gold.setVisible(false);
            typeofgold.setVisible(false);

        } else {
            Com_Type_gold.setVisible(true);
            typeofgold.setVisible(true);
        }
    }//GEN-LAST:event_Com_type_thingActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double txt_w_g = Double.parseDouble(this.txt_w_g.getText());
        double txt_c = Double.parseDouble(this.txt_c.getText());
        double txt_w_t = Double.parseDouble(this.txt_w_t.getText());
        double price_t = Double.parseDouble(this.Price_t.getText());
        double price_all = Double.parseDouble(this.Price_all.getText());
        double weighttola = txt_w_g / 12.88;
        double weight = (price_t * txt_c) / 23.88;
        double final_price = weighttola * weight;
       
       Price_all.setText(String.format("%.2f", final_price));

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Transactions1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transactions1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transactions1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transactions1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transactions1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Com_Type_gold;
    private javax.swing.JComboBox<String> Com_txt;
    private javax.swing.JComboBox<String> Com_type_thing;
    private javax.swing.JTextField Price_all;
    private javax.swing.JTextField Price_all1;
    private javax.swing.JTextField Price_t;
    private javax.swing.JTextField Price_t1;
    private javax.swing.JTextField Price_t2;
    private javax.swing.JTextField Recived_gold;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jCom_ustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txt_c;
    private javax.swing.JTextField txt_w_g;
    private javax.swing.JTextField txt_w_t;
    private javax.swing.JTextField txtnic8;
    private javax.swing.JLabel typeofgold;
    // End of variables declaration//GEN-END:variables
}
