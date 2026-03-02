/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import jalalicalendar.JalaliCalendar.YearMonthDate;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public final class Transactions extends javax.swing.JFrame {

    private Object jalalicalendar;

    /**
     * Creates new form Transactions
     */
    public Transactions() {
        initComponents();

        setLocationRelativeTo(this);
        getConnection();
        loadCustomers();

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
            Statement stmt = conn.createStatement();
            stmt.execute("PRAGMA journal_mode=WAL;");
            stmt.close();
            stmt.execute("PRAGMA busy_timeout = 5000;");
            stmt.close();

            System.out.println("cont");

        } catch (ClassNotFoundException ex) {
            System.out.println("not found" + ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void loadCustomers() {
        try {

            String sql = "SELECT  Fullname FROM Customers";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            comcustomer.removeAllItems();

            while (rs.next()) {
                // موږ id او نوم دواړه ذخیره کوو
                comcustomer.addItem(
                        rs.getString("Fullname")
                );
            }

            conn.close();
            ps.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttotalprice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtpurgram = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcarat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtweight = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblafnout = new javax.swing.JLabel();
        lblusdin = new javax.swing.JLabel();
        lblusdout = new javax.swing.JLabel();
        txtafnin = new javax.swing.JTextField();
        txtusdin = new javax.swing.JTextField();
        txtafnout = new javax.swing.JTextField();
        txtusdout = new javax.swing.JTextField();
        lblafnin = new javax.swing.JLabel();
        lblgoldout = new javax.swing.JLabel();
        lblsilver = new javax.swing.JLabel();
        txtgoldout = new javax.swing.JTextField();
        lblsilverout = new javax.swing.JLabel();
        txtsilverin = new javax.swing.JTextField();
        txtgoldin = new javax.swing.JTextField();
        txtsilverout = new javax.swing.JTextField();
        lblgoldin = new javax.swing.JLabel();
        comtype = new javax.swing.JComboBox<>();
        comgoold = new javax.swing.JComboBox<>();
        comcustomer = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(16, 23, 42));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 16, 93, 76));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 181, 3));
        jLabel2.setText("جدول ثبت معاملات");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 62, -1, -1));

        search.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_23px.png"))); // NOI18N
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 203, 50, 30));

        txtid.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtid.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtidFocusGained(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidKeyPressed(evt);
            }
        });
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1356, 200, 360, 40));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("آی دی معامله");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1613, 161, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("نوع معامله");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(846, 161, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("نوع جنس");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 161, -1, -1));

        txttotalprice.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txttotalprice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttotalprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttotalpriceKeyPressed(evt);
            }
        });
        jPanel1.add(txttotalprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 311, 360, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("قیمت مجموعی");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 270, -1, -1));

        txtpurgram.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtpurgram.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtpurgram.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpurgramKeyPressed(evt);
            }
        });
        jPanel1.add(txtpurgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 311, 360, 40));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("قیمت فی گرام");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(826, 270, -1, -1));

        txtcarat.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtcarat.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtcarat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcaratKeyPressed(evt);
            }
        });
        jPanel1.add(txtcarat, new org.netbeans.lib.awtextra.AbsoluteConstraints(961, 311, 360, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("عیار");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1256, 270, 47, -1));

        txtweight.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtweight.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtweight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtweightKeyPressed(evt);
            }
        });
        jPanel1.add(txtweight, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 190, 360, 40));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("وزن ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1677, 270, -1, -1));

        lblafnout.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblafnout.setForeground(new java.awt.Color(255, 255, 255));
        lblafnout.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblafnout.setText("پرداخت افغانی");
        jPanel1.add(lblafnout, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 390, -1, -1));

        lblusdin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblusdin.setForeground(new java.awt.Color(255, 255, 255));
        lblusdin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblusdin.setText("گرفت دالر");
        jPanel1.add(lblusdin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 250, -1, -1));

        lblusdout.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblusdout.setForeground(new java.awt.Color(255, 255, 255));
        lblusdout.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblusdout.setText("پرداخت دالر");
        jPanel1.add(lblusdout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 210, -1, -1));

        txtafnin.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtafnin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtafnin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtafninKeyPressed(evt);
            }
        });
        jPanel1.add(txtafnin, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 360, 40));

        txtusdin.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtusdin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtusdin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusdinKeyPressed(evt);
            }
        });
        jPanel1.add(txtusdin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 220, 360, 40));

        txtafnout.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtafnout.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtafnout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtafnoutKeyPressed(evt);
            }
        });
        jPanel1.add(txtafnout, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 422, 360, 40));

        txtusdout.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtusdout.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtusdout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusdoutKeyPressed(evt);
            }
        });
        jPanel1.add(txtusdout, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 130, 360, 40));

        lblafnin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblafnin.setForeground(new java.awt.Color(255, 255, 255));
        lblafnin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblafnin.setText("گرفت افغانی");
        jPanel1.add(lblafnin, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, -1, -1));

        lblgoldout.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblgoldout.setForeground(new java.awt.Color(255, 255, 255));
        lblgoldout.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblgoldout.setText("پرداخت طلا");
        jPanel1.add(lblgoldout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 70, -1, -1));

        lblsilver.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblsilver.setForeground(new java.awt.Color(255, 255, 255));
        lblsilver.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblsilver.setText("گرفت نقره");
        jPanel1.add(lblsilver, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 200, -1, -1));

        txtgoldout.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtgoldout.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtgoldout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtgoldoutKeyPressed(evt);
            }
        });
        jPanel1.add(txtgoldout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 360, 40));

        lblsilverout.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblsilverout.setForeground(new java.awt.Color(255, 255, 255));
        lblsilverout.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblsilverout.setText("پرداخت نقره");
        jPanel1.add(lblsilverout, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 494, -1, -1));

        txtsilverin.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtsilverin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsilverin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsilverinKeyPressed(evt);
            }
        });
        jPanel1.add(txtsilverin, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 360, 40));

        txtgoldin.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtgoldin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtgoldin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtgoldinKeyPressed(evt);
            }
        });
        jPanel1.add(txtgoldin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 210, 360, 40));

        txtsilverout.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtsilverout.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtsilverout, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 533, 360, 40));

        lblgoldin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblgoldin.setForeground(new java.awt.Color(255, 255, 255));
        lblgoldin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblgoldin.setText("گرفت طلا");
        jPanel1.add(lblgoldin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 250, -1, -1));

        comtype.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        comtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "خرید", "فروش" }));
        comtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comtypeActionPerformed(evt);
            }
        });
        jPanel1.add(comtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 200, 360, 40));

        comgoold.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        comgoold.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "طلا", "نقره" }));
        comgoold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comgooldActionPerformed(evt);
            }
        });
        comgoold.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comgooldKeyPressed(evt);
            }
        });
        jPanel1.add(comgoold, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 200, 360, 40));

        comcustomer.setEditable(true);
        comcustomer.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        comcustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        comcustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comcustomerActionPerformed(evt);
            }
        });
        comcustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comcustomerKeyPressed(evt);
            }
        });
        jPanel1.add(comcustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(961, 200, 360, 40));

        jButton1.setBackground(new java.awt.Color(30, 41, 59));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_delete_trash_34px_1.png"))); // NOI18N
        jButton1.setText("حذف");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 601, 160, 40));

        jButton2.setBackground(new java.awt.Color(30, 41, 59));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_refresh_34px_1.png"))); // NOI18N
        jButton2.setText("ویرایش");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 601, 160, 40));

        jButton3.setBackground(new java.awt.Color(30, 41, 59));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_save_34px_1.png"))); // NOI18N
        jButton3.setText("ثبت");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 601, 160, 40));

        jLabel11.setText("jLabel11");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("نام مشتری");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1236, 161, -1, -1));

        jButton4.setText("Table");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 600, 110, 40));

        jButton5.setText("حذف");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 600, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -120, 1783, 1100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Exite().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void comcustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comcustomerActionPerformed

    }//GEN-LAST:event_comcustomerActionPerformed
    String vid = "";
    private void comgooldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comgooldActionPerformed
        String vid = comgoold.getSelectedItem().toString().trim();
        String vidd = comtype.getSelectedItem().toString().trim();
        if (vid.equals("طلا") && vidd.equals("خرید")) {
            txtgoldin.setVisible(true);
            txtgoldout.setVisible(true);
            lblgoldin.setVisible(true);
            lblgoldout.setVisible(true);
            txtsilverin.setVisible(false);
            txtsilverout.setVisible(false);

            lblsilver.setVisible(false);
            lblsilverout.setVisible(false);

        } else if (vid.equals("نقره")) {
            txtsilverin.setVisible(true);
            txtsilverout.setVisible(true);

            lblsilver.setVisible(true);
            lblsilverout.setVisible(true);
            txtgoldin.setVisible(false);
            txtgoldout.setVisible(false);
            lblgoldin.setVisible(false);
            lblgoldout.setVisible(false);
        }
        this.jPanel1.revalidate();
        this.jPanel1.repaint();
    }//GEN-LAST:event_comgooldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            getConnection();

            String gold = comgoold.getSelectedItem().toString().trim();
            String type_txt = comtype.getSelectedItem().toString().trim();
            if (gold.equals("طلا")) {
                gold = "gold";

            } else {
                gold = "silver";
            }
            if (type_txt.equals("خرید")) {
                type_txt = "buy";

            } else {
                type_txt = "sale";
            }
            // 1️⃣ Customer ID پیدا کول
            // =========================
               // =========================
         int customerId = 0;
            String customerName = comcustomer.getSelectedItem().toString().trim();

            if (!customerName.isEmpty()) {
                String findCustomer = "SELECT Customers_id FROM Customers WHERE Fullname = ?";
                PreparedStatement psSelect = conn.prepareStatement(findCustomer);
                psSelect.setString(1, customerName);
                ResultSet rsSelect = psSelect.executeQuery();

                if (rsSelect.next()) {
                    customerId = rsSelect.getInt("Customers_id");
                } else {
                    JOptionPane.showMessageDialog(this, "مشتری ونه موندل شو: " + customerName);
                    return; // که مشتری ونه موندل شو ثبتولو ته ادامه مه ورکوي
                }

                rsSelect.close();
                psSelect.close();
            } else {
                JOptionPane.showMessageDialog(this, "لطفاً مشتری انتخاب کړئ!");
                return;
            }

            // =========================
            // 2️⃣ INSERT عملیات
            // =========================
            String sql = "INSERT INTO Transactions ("
                    + "Transaction_id, Customers_id, Type_txt, Type_money, Date, Weight, Source_carat, "
                    + "Gold_rate, Gold_amount, USD_in, USD_out, AFG_in, AFG_out, "
                    + "Gold_in, Gold_out, Silver_in, Silver_out, status"
                    + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);

            ps.setString(1, txtid.getText());
            ps.setInt(2, customerId); // دلته Customer ID ثبت کیږي
            // gold او type_txt مخکې سم کړل شوي
            ps.setString(3, type_txt); // د خرید/فروش لپاره
            ps.setString(4, gold);     // د طلا/سپینو زر لپاره
            ps.setString(5, new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
            ps.setDouble(6, Double.parseDouble(txtweight.getText().isEmpty() ? "0" : txtweight.getText()));
            ps.setDouble(7, Double.parseDouble(txtcarat.getText().isEmpty() ? "0" : txtcarat.getText()));
            ps.setDouble(8, Double.parseDouble(txtpurgram.getText().isEmpty() ? "0" : txtpurgram.getText()));
            ps.setDouble(9, Double.parseDouble(txttotalprice.getText().isEmpty() ? "0" : txttotalprice.getText()));
            ps.setDouble(10, Double.parseDouble(txtusdin.getText().isEmpty() ? "0" : txtusdin.getText()));
            ps.setDouble(11, Double.parseDouble(txtusdout.getText().isEmpty() ? "0" : txtusdout.getText()));
            ps.setDouble(12, Double.parseDouble(txtafnin.getText().isEmpty() ? "0" : txtafnin.getText()));
            ps.setDouble(13, Double.parseDouble(txtafnout.getText().isEmpty() ? "0" : txtafnout.getText()));
            ps.setDouble(14, Double.parseDouble(txtgoldin.getText().isEmpty() ? "0" : txtgoldin.getText()));
            ps.setDouble(15, Double.parseDouble(txtgoldout.getText().isEmpty() ? "0" : txtgoldout.getText()));
            ps.setDouble(16, Double.parseDouble(txtsilverin.getText().isEmpty() ? "0" : txtsilverin.getText()));
            ps.setDouble(17, Double.parseDouble(txtsilverout.getText().isEmpty() ? "0" : txtsilverout.getText()));
            ps.setString(18, "PENDING");

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "معلومات په بریالیتوب سره ثبت شول!");

                // ========= پاکول =========
                txtafnout.setText("");
                txtafnin.setText("");
                txtusdin.setText("");
                txtusdout.setText("");
                txtweight.setText("");
                txtpurgram.setText("");
                txtgoldin.setText("");
                txtgoldout.setText("");
                txtsilverin.setText("");
                txtsilverout.setText("");
                txttotalprice.setText("");
                txtcarat.setText("");
                txtid.setText("");
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
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtpurgramKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpurgramKeyPressed
        if (evt.getKeyCode() == 10) {

            try {
                int price = Integer.parseInt(txtweight.getText());
                int qun = Integer.parseInt(txtpurgram.getText());
                double total = price * qun;

                txttotalprice.setText(String.valueOf(total));
                txttotalprice.requestFocus();

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        }
    }//GEN-LAST:event_txtpurgramKeyPressed

    private void txtweightKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtweightKeyPressed
        if (evt.getKeyCode() == 10) {
            txtcarat.requestFocus();
        }
    }//GEN-LAST:event_txtweightKeyPressed

    private void txtcaratKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaratKeyPressed
        if (evt.getKeyCode() == 10) {
            txtpurgram.requestFocus();

        }
    }//GEN-LAST:event_txtcaratKeyPressed

    private void txtidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyPressed
        if (evt.getKeyCode() == 10) {
            comcustomer.requestFocus();
        }
    }//GEN-LAST:event_txtidKeyPressed

    private void comcustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comcustomerKeyPressed
        if (evt.getKeyCode() == 10) {
            comtype.requestFocus();
        }
    }//GEN-LAST:event_comcustomerKeyPressed

    private void comgooldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comgooldKeyPressed
        if (evt.getKeyCode() == 10) {
            comgoold.requestFocus();
        }
    }//GEN-LAST:event_comgooldKeyPressed

    private void txttotalpriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalpriceKeyPressed
        if (evt.getKeyCode() == 10) {
            txtusdin.requestFocus();
        }
    }//GEN-LAST:event_txttotalpriceKeyPressed

    private void txtusdoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusdoutKeyPressed
        if (evt.getKeyCode() == 10) {
            txtafnin.requestFocus();
        }
    }//GEN-LAST:event_txtusdoutKeyPressed

    private void txtusdinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusdinKeyPressed
        if (evt.getKeyCode() == 10) {
            txtusdout.requestFocus();
        }
    }//GEN-LAST:event_txtusdinKeyPressed

    private void txtafninKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtafninKeyPressed
        if (evt.getKeyCode() == 10) {
            txtafnout.requestFocus();
        }
    }//GEN-LAST:event_txtafninKeyPressed

    private void txtafnoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtafnoutKeyPressed
        if (evt.getKeyCode() == 10) {
            txtgoldin.requestFocus();
        }
    }//GEN-LAST:event_txtafnoutKeyPressed

    private void txtgoldinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgoldinKeyPressed
        if (evt.getKeyCode() == 10) {
            txtgoldout.requestFocus();
        }
    }//GEN-LAST:event_txtgoldinKeyPressed

    private void txtgoldoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgoldoutKeyPressed
        if (evt.getKeyCode() == 10) {
            txtsilverin.requestFocus();
        }
    }//GEN-LAST:event_txtgoldoutKeyPressed

    private void txtsilverinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsilverinKeyPressed
        if (evt.getKeyCode() == 10) {
            txtsilverout.requestFocus();
        }
    }//GEN-LAST:event_txtsilverinKeyPressed

    private void comtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comtypeActionPerformed
        String vid = comtype.getSelectedItem().toString().trim();
        if (vid.equals("خرید")) {
            txtusdin.setVisible(false);
            txtafnin.setVisible(false);
            lblusdin.setVisible(false);
            lblafnin.setVisible(false);
            txtusdout.setVisible(true);
            txtafnout.setVisible(true);
            lblusdout.setVisible(true);
            lblafnout.setVisible(true);

        } else {
            txtusdin.setVisible(true);
            txtafnin.setVisible(true);
            lblusdin.setVisible(true);
            lblafnin.setVisible(true);
            txtusdout.setVisible(false);
            txtafnout.setVisible(false);
            lblusdout.setVisible(false);
            lblafnout.setVisible(false);

        }
        this.jPanel1.revalidate();
        this.jPanel1.repaint();
    }//GEN-LAST:event_comtypeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        try {
//            getConnection();
//
//            // د اپډیټ SQL پوښتنه
//            String sql = "UPDATE Transactions SET "
//                    + "Customers_id = ?, Source_carat = ?, Gold_rate = ?, Gold_amount = ?, "
//                    + "USD_in=?,USD_out=?,AFG_in = ?, AFG_out = ?, Gold_in = ?, Gold_out = ?, "
//                    + "Silver_in = ?, Silver_out = ?, status = ? "
//                    + "WHERE Transaction_id = ?"; // دلته باید د ریکارډ ID موجود وي
//
//            ps = conn.prepareStatement(sql);
//
//            // د قیمتونو تنظیمول (لکه مخکې کوډ)
//            ps.setInt(1, Integer.parseInt(txtid.getText()));
//            ps.setDouble(2, Double.parseDouble(txtcarat.getText().isEmpty() ? "0" : txtcarat.getText()));
//            ps.setDouble(3, Double.parseDouble(txtpurgram.getText().isEmpty() ? "0" : txtpurgram.getText()));
//            ps.setDouble(4, Double.parseDouble(txttotalprice.getText().isEmpty() ? "0" : txttotalprice.getText()));
//
//            ps.setDouble(5, Double.parseDouble(txtusdin.getText().isEmpty() ? "0" : txtafnin.getText()));
//            ps.setDouble(6, Double.parseDouble(txtusdout.getText().isEmpty() ? "0" : txtafnout.getText()));
//            ps.setDouble(7, Double.parseDouble(txtafnin.getText().isEmpty() ? "0" : txtafnin.getText()));
//            ps.setDouble(8, Double.parseDouble(txtafnout.getText().isEmpty() ? "0" : txtafnout.getText()));
//
//            ps.setDouble(9, Double.parseDouble(txtgoldin.getText().isEmpty() ? "0" : txtgoldin.getText()));
//            ps.setDouble(10, Double.parseDouble(txtgoldout.getText().isEmpty() ? "0" : txtgoldout.getText()));
//
//            ps.setDouble(11, Double.parseDouble(txtsilverin.getText().isEmpty() ? "0" : txtsilverin.getText()));
//            ps.setDouble(12, Double.parseDouble(txtsilverout.getText().isEmpty() ? "0" : txtsilverout.getText()));
//
//            ps.setString(13, "PENDING"); // یا بل حالت
//
//            // دلته باید د هغه ریکارډ ID ورکړئ چې غواړئ تغیر پکې راولئ
//            // فرضاً که تاسو یو پټ لیبل یا فیلډ لرئ چې ID پکې ده:
//            ps.setInt(14, Integer.parseInt(txttid.getText()));
//
//            int rows = ps.executeUpdate();
//            if (rows > 0) {
//                JOptionPane.showMessageDialog(this, "معلومات په بریالیتوب سره اپډیټ شول!");
//                txtafnout.setText("");
//                txtafnin.setText("");
//                txtusdin.setText("");
//                txtusdout.setText("");
//                txtweight.setText("");
//                txtpurgram.setText("");
//                txtgoldin.setText("");
//                txtgoldout.setText("");
//                txtsilverin.setText("");
//                txtsilverout.setText("");
//                txttotalprice.setText("");
//                txtcarat.setText("");
//                this.txtid.setText("");
//            } else {
//                JOptionPane.showMessageDialog(this, "ریکارډ پیدا نشو.");
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "تېروتنه: " + e.getMessage());
//        } finally {
//            try {
//                if (ps != null) {
//                    ps.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//

        try {
            getConnection();

            String sql = "UPDATE Transactions SET "
                    + "Customers_id = ?, Source_carat = ?, Gold_rate = ?, Gold_amount = ?, "
                    + "USD_in=?, USD_out=?, AFG_in = ?, AFG_out = ?, Gold_in = ?, Gold_out = ?, "
                    + "Silver_in = ?, Silver_out = ?, status = ? "
                    + "WHERE Transaction_id = ?";

            ps = conn.prepareStatement(sql);

            // =========================
            // 1️⃣ د Customer ID پیدا کول د comcustomer څخه
            // =========================
            int customerId = 0;
            String customerName = comcustomer.getSelectedItem().toString();

            String findCustomer = "SELECT Customers_id FROM Customers WHERE Fullname = ?";
            PreparedStatement psCustomer = conn.prepareStatement(findCustomer);
            psCustomer.setString(1, customerName);
            ResultSet rsCustomer = psCustomer.executeQuery();

            if (rsCustomer.next()) {
                customerId = rsCustomer.getInt("Customers_id");
            }

            ps.setInt(1, customerId);

            rsCustomer.close();
            psCustomer.close();

            // =========================
            // 2️⃣ نور فیلډونه
            // =========================
            ps.setDouble(2, Double.parseDouble(txtcarat.getText().isEmpty() ? "0" : txtcarat.getText()));
            ps.setDouble(3, Double.parseDouble(txtpurgram.getText().isEmpty() ? "0" : txtpurgram.getText()));
            ps.setDouble(4, Double.parseDouble(txttotalprice.getText().isEmpty() ? "0" : txttotalprice.getText()));

            // ✅ دلته ستا کوچنی غلطي اصلاح شوه
            ps.setDouble(5, Double.parseDouble(txtusdin.getText().isEmpty() ? "0" : txtusdin.getText()));
            ps.setDouble(6, Double.parseDouble(txtusdout.getText().isEmpty() ? "0" : txtusdout.getText()));

            ps.setDouble(7, Double.parseDouble(txtafnin.getText().isEmpty() ? "0" : txtafnin.getText()));
            ps.setDouble(8, Double.parseDouble(txtafnout.getText().isEmpty() ? "0" : txtafnout.getText()));

            ps.setDouble(9, Double.parseDouble(txtgoldin.getText().isEmpty() ? "0" : txtgoldin.getText()));
            ps.setDouble(10, Double.parseDouble(txtgoldout.getText().isEmpty() ? "0" : txtgoldout.getText()));

            ps.setDouble(11, Double.parseDouble(txtsilverin.getText().isEmpty() ? "0" : txtsilverin.getText()));
            ps.setDouble(12, Double.parseDouble(txtsilverout.getText().isEmpty() ? "0" : txtsilverout.getText()));

            ps.setString(13, "PENDING");

            // Transaction ID
            ps.setInt(14, Integer.parseInt(txtid.getText()));

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "معلومات په بریالیتوب سره اپډیټ شول!");

                txtafnout.setText("");
                txtafnin.setText("");
                txtusdin.setText("");
                txtusdout.setText("");
                txtweight.setText("");
                txtpurgram.setText("");
                txtgoldin.setText("");
                txtgoldout.setText("");
                txtsilverin.setText("");
                txtsilverout.setText("");
                txttotalprice.setText("");
                txtcarat.setText("");
                this.txtid.setText("");

            } else {
                JOptionPane.showMessageDialog(this, "ریکارډ پیدا نشو.");
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
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidFocusGained
        // TODO add your handling code here:

        //max id
        try {
            getConnection();
            ps = conn.prepareStatement("select max(Transaction_id)+1 from Transactions");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtid.setText(rs.getString("max(Transaction_id)+1"));
            }
            conn.close();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_txtidFocusGained

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        try {
            int selectedTransactionId;
            getConnection();
            // د Transaction_id په اساس لټون
            String sql = "SELECT * FROM Transactions WHERE Transaction_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtid.getText());
            rs = ps.executeQuery();

            if (rs.next()) {
                // د فارم د فیلډونو ډکول
                txtid.setText(rs.getString("Transaction_id"));
                txtweight.setText(rs.getString("Weight"));
                txtcarat.setText(rs.getString("Source_carat"));
                txtpurgram.setText(rs.getString("Gold_rate"));
                txttotalprice.setText(rs.getString("Gold_amount"));
                txtusdin.setText(rs.getString("USD_in"));
                txtusdout.setText(rs.getString("USD_out"));
                txtafnin.setText(rs.getString("AFG_in"));
                txtafnout.setText(rs.getString("AFG_out"));
                txtgoldin.setText(rs.getString("Gold_in"));
                txtgoldout.setText(rs.getString("Gold_out"));
                txtsilverin.setText(rs.getString("Silver_in"));
                txtsilverout.setText(rs.getString("Silver_out"));
                comtype.setSelectedItem(rs.getString("Type_txt"));
                comgoold.setSelectedItem(rs.getString("Type_money"));

                // د آپډیټ لپاره د اصلي ID خوندي کول
                selectedTransactionId = rs.getInt("Transaction_id");

            } else {
                JOptionPane.showMessageDialog(this, "بخښنه غواړو، په دې ID هیڅ ریکارډ پیدا نشو.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "د لټون پر مهال تېروتنه: " + e.getMessage());
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
            } catch (SQLException e) {
            }
        }

    }//GEN-LAST:event_searchMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        try {
//            getConnection();
//            String txtid = txttid.getText();
//
//            if (txtid.equals("")) {
//                JOptionPane.showMessageDialog(this, "اول باید معلومات را از دیتابییس بگیرید سپس حذف کنید!");
//
//            } else {
//
//                ps = conn.prepareStatement("delete from Transactions where Transaction_id=?");
//                ps.setString(1, txttid.getText());
////                int a = JOptionPane.showConfirmDialog(null, "ایاموفق هستیدکه" + txttid.getText() + "است حذف شود؟", "پيام برنامه", JOptionPane.YES_OPTION);
//                String[] options = {"بلی", "نخیر"};
//                int choice = JOptionPane.showOptionDialog(null, "آيا میخواهید که این معامله حذف شود؟", "پیام درخواست ",
//                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
//                if (choice == 0) {
//
//                    ps.executeUpdate();
//
//                    JOptionPane.showMessageDialog(null, "موافقانه  عملیات حذف انجام شد");
//                    txtafnout.setText("");
//                    txtafnin.setText("");
//                    txtusdin.setText("");
//                    txtusdout.setText("");
//                    txtweight.setText("");
//                    txtpurgram.setText("");
//                    txtgoldin.setText("");
//                    txtgoldout.setText("");
//                    txtsilverin.setText("");
//                    txtsilverout.setText("");
//                    txttotalprice.setText("");
//                    txtcarat.setText("");
//                    this.txtid.setText("");
//
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
        try {
            getConnection();

            if (txtid.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "اول باید معلومات را از دیتابییس بگیرید سپس حذف کنید!");
                return;
            }

            String[] options = {"بلی", "نخیر"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "آيا میخواهید که این معامله حذف شود؟",
                    "پیام درخواست",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == 0) {

                String sql = "DELETE FROM Transactions WHERE Transaction_id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(txtid.getText()));

                int rows = ps.executeUpdate();

                if (rows > 0) {

                    JOptionPane.showMessageDialog(null, "موافقانه عملیات حذف انجام شد");

                    txtafnout.setText("");
                    txtafnin.setText("");
                    txtusdin.setText("");
                    txtusdout.setText("");
                    txtweight.setText("");
                    txtpurgram.setText("");
                    txtgoldin.setText("");
                    txtgoldout.setText("");
                    txtsilverin.setText("");
                    txtsilverout.setText("");
                    txttotalprice.setText("");
                    txtcarat.setText("");
                    txtid.setText("");
                    txtid.setText("");

                } else {
                    JOptionPane.showMessageDialog(null, "ریکارډ پیدا نشد!");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "تېروتنه: " + e.getMessage());
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        txtafnout.setText("");
        txtafnin.setText("");
        txtusdin.setText("");
        txtusdout.setText("");
        txtweight.setText("");
        txtpurgram.setText("");
        txtgoldin.setText("");
        txtgoldout.setText("");
        txtsilverin.setText("");
        txtsilverout.setText("");
        txttotalprice.setText("");
        txtcarat.setText("");
        this.txtid.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GOLDMS gb = new GOLDMS();
        gb.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transactions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comcustomer;
    private javax.swing.JComboBox<String> comgoold;
    private javax.swing.JComboBox<String> comtype;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblafnin;
    private javax.swing.JLabel lblafnout;
    private javax.swing.JLabel lblgoldin;
    private javax.swing.JLabel lblgoldout;
    private javax.swing.JLabel lblsilver;
    private javax.swing.JLabel lblsilverout;
    private javax.swing.JLabel lblusdin;
    private javax.swing.JLabel lblusdout;
    private javax.swing.JLabel search;
    private javax.swing.JTextField txtafnin;
    private javax.swing.JTextField txtafnout;
    private javax.swing.JTextField txtcarat;
    private javax.swing.JTextField txtgoldin;
    private javax.swing.JTextField txtgoldout;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtpurgram;
    private javax.swing.JTextField txtsilverin;
    private javax.swing.JTextField txtsilverout;
    private javax.swing.JTextField txttotalprice;
    private javax.swing.JTextField txtusdin;
    private javax.swing.JTextField txtusdout;
    private javax.swing.JTextField txtweight;
    // End of variables declaration//GEN-END:variables
}
