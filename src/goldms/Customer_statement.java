/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import jalalicalendar.JalaliCalendar;
import java.sql.*;
import javax.swing.*;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Customer_statement extends javax.swing.JFrame {

    /**
     * Creates new form Treasury
     */
    public Customer_statement() {
        initComponents();
        getConnection();
        loadCustomers();
        styleTable();

        setLocationRelativeTo(this);
        JalaliCalendar jc = new JalaliCalendar();

        int year = jc.get(Calendar.YEAR);
        int month = jc.get(Calendar.MONTH) + 1;  // چون از 0 شروع می‌شود
        int day = jc.get(Calendar.DAY_OF_MONTH);

// فرمت زیباتر با صفر ابتدایی
        String date = String.format("%04d/%02d/%02d", year, month, day);

        jalalidate.setText(date);
        jalalidate.disable();
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

    public void loadCustomers() {
        try {

            String sql = "SELECT  Fullname FROM Customers";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            cmbselectcustomer.removeAllItems();

            while (rs.next()) {
                // موږ id او نوم دواړه ذخیره کوو
                cmbselectcustomer.addItem(rs.getString("Fullname"));

            }

            conn.close();
            ps.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void styleTable() {

        jTable1.setRowHeight(40);

        // حذف خطوط داخلی برای ظاهر مدرن
        jTable1.setShowGrid(false);
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));

        // رنگ هدر (بالای جدول)
        jTable1.getTableHeader().setBackground(new java.awt.Color(30, 41, 59));
        jTable1.getTableHeader().setForeground(java.awt.Color.WHITE);

        jTable1.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {

            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {

                java.awt.Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                // رنگ انتخاب
                if (isSelected) {
                    c.setBackground(new java.awt.Color(255, 181, 3)); // طلایی GBMS
                    c.setForeground(java.awt.Color.BLACK);
                } else {

                    // Zebra مدرن
                    if (row % 2 == 0) {
                        c.setBackground(new java.awt.Color(248, 249, 250));
                    } else {
                        c.setBackground(new java.awt.Color(235, 240, 245));
                    }

                    c.setForeground(java.awt.Color.BLACK);
                }

                return c;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchinfo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        asset_types = new javax.swing.JComboBox<>();
        cmbdate = new javax.swing.JComboBox<>();
        cmbselectcustomer = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        Amount = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jalalidate = new javax.swing.JTextField();
        gold_form = new javax.swing.JComboBox<>();
        transaction_type = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        asset_type = new javax.swing.JLabel();
        unit = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        deatiles = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
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

        searchinfo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        searchinfo.setForeground(new java.awt.Color(252, 170, 3));
        searchinfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_23px.png"))); // NOI18N
        searchinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchinfoMouseClicked(evt);
            }
        });
        jPanel1.add(searchinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 30, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_undo_34px.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ارز");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("بازه زمانی");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("جستجو به اساس آی دی");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 120, -1, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "تاریخ شمسی", "جزیات", "مقدار", "نوع معامله", "واحد", "نوع طلا", "ارز", "نام مشتری", "آی دی"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 1270, 320));

        asset_types.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        asset_types.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "دالر", "افغانی", "طلا", "نقره" }));
        asset_types.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asset_typesActionPerformed(evt);
            }
        });
        jPanel1.add(asset_types, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 360, 40));

        cmbdate.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cmbdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "همه ", "امروز", "دیروز", "هفته گذشته", "ماه گذشته", "سال گذشته" }));
        jPanel1.add(cmbdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 360, 40));

        cmbselectcustomer.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cmbselectcustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "انتخاب مشتری" }));
        jPanel1.add(cmbselectcustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, 360, 40));

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("نوع معامله");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        Amount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Amount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AmountFocusGained(evt);
            }
        });
        Amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AmountKeyTyped(evt);
            }
        });
        jPanel1.add(Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 530, 40));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("تاریخ شمسی");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 430, -1, -1));

        txtID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIDFocusGained(evt);
            }
        });
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 630, 40));

        jButton3.setBackground(new java.awt.Color(0, 102, 255));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_save_34px_1.png"))); // NOI18N
        jButton3.setText("ثبت");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 540, 40));

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("توضیحات");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, -1, -1));

        jalalidate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jalalidate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jalalidate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jalalidateFocusGained(evt);
            }
        });
        jalalidate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jalalidateKeyTyped(evt);
            }
        });
        jPanel1.add(jalalidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 530, 40));

        gold_form.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        gold_form.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "برگ", "پاسه", " " }));
        jPanel1.add(gold_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 290, 360, 40));

        transaction_type.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        transaction_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "رسیده", "پرداخت شده" }));
        jPanel1.add(transaction_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 360, 40));

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("مقدار");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 340, -1, -1));

        asset_type.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        asset_type.setForeground(new java.awt.Color(255, 255, 255));
        asset_type.setText("نوع طلا");
        jPanel1.add(asset_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 260, -1, -1));

        unit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        unit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "پول", "گرام", "کیلوگرام", "توله", "مثقال", " " }));
        jPanel1.add(unit, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 360, 40));

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("واحد");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 260, -1, -1));

        deatiles.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        deatiles.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        deatiles.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                deatilesFocusGained(evt);
            }
        });
        deatiles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                deatilesKeyTyped(evt);
            }
        });
        jPanel1.add(deatiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 550, 40));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(252, 170, 3));
        jLabel3.setText("مدیریت حساب مشتریان");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("اتنخاب مشتری");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 170, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void AmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AmountFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountFocusGained

    private void AmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmountKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountKeyTyped

    private void txtIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDFocusGained

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            getConnection();
            String asset_type = "";
            asset_type = asset_types.getSelectedItem().toString();

            if (asset_type.equals("افغانی")) {
                asset_type = "AFG";

            } else if (asset_type.equals("دالر")) {
                asset_type = "USD";
            } else if (asset_type.equals("طلا")) {
                asset_type = "GOLD";
            } else {
                asset_type = "SILVER";

            }
            getConnection();
            int customerId;
            String customerName = cmbselectcustomer.getSelectedItem() == null ? "" : cmbselectcustomer.getSelectedItem().toString().trim();

            if (customerName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "لطفاً مشتری انتخاب کړئ!");
                return;
            }

            String findCustomer = "SELECT Customers_id FROM Customers WHERE Fullname = ?";
            PreparedStatement psSelect = conn.prepareStatement(findCustomer);
            psSelect.setString(1, customerName);
            ResultSet rsSelect = psSelect.executeQuery();

            if (rsSelect.next()) {
                customerId = rsSelect.getInt("Customers_id");
            } else {
                JOptionPane.showMessageDialog(this, "مشتری ونه موندل شو!");
                rsSelect.close();
                psSelect.close();
                return;
            }

            rsSelect.close();
            psSelect.close();
            String sql = "INSERT INTO customer_statements "
                    + "(Customer_id, asset_type,gold_form,unit,transaction_type,Amount,details,  jalali_date) "
                    + "VALUES (?, ?, ?, ?, ?, ?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, customerId);

            ps.setString(2, asset_type);

            ps.setString(3, asset == "نقره" ? "NULL" : gold_form.getSelectedItem().toString().trim());
            ps.setString(4, unit.getSelectedItem().toString().trim());
            ps.setString(5, transaction_type.getSelectedItem().toString().trim());
            ps.setString(6, Amount.getText());
            ps.setString(7, deatiles.getText());
            ps.setString(8, jalalidate.getText());
            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "معلومات مشتری ثبت شد");

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
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jalalidateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jalalidateFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jalalidateFocusGained

    private void jalalidateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jalalidateKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jalalidateKeyTyped

    private void deatilesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_deatilesFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_deatilesFocusGained

    private void deatilesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deatilesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_deatilesKeyTyped
    String asset = "";
    private void asset_typesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asset_typesActionPerformed
        asset = asset_types.getSelectedItem().toString().trim();
        if (asset.equals("نقره")) {
            gold_form.setVisible(false);
            asset_type.setVisible(false);

        } else {
            gold_form.setVisible(true);
            asset_type.setVisible(true);
        }
    }//GEN-LAST:event_asset_typesActionPerformed

    private void searchinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchinfoMouseClicked
        try {
            getConnection();
            ps = conn.prepareStatement(
                    "SELECT Customers.Fullname, "
                    + "customer_statements.id, customer_statements.Customer_id, customer_statements.asset_type, "
                    + "customer_statements.gold_form, customer_statements.unit, customer_statements.transaction_type, "
                    + "customer_statements.amount, customer_statements.details, customer_statements.jalali_date "
                    + "FROM customer_statements "
                    + "LEFT JOIN Customers ON Customers.Customers_id = customer_statements.Customer_id "
                    + "WHERE customer_statements.id = ?"
            );

            ps.setString(1, txtID.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                cmbselectcustomer.setSelectedItem(rs.getString("Fullname"));
                asset_types.setSelectedItem(rs.getString("asset_type"));
                gold_form.setSelectedItem(rs.getString("gold_form"));
                unit.setSelectedItem(rs.getString("unit"));
                transaction_type.setSelectedItem(rs.getString("transaction_type"));
                Amount.setText(rs.getString("amount"));
                deatiles.setText(rs.getString("details"));
                jalalidate.setText(rs.getString("jalali_date"));
                conn.close();
                ps.close();
                rs.close();

            } else {

                JOptionPane.showMessageDialog(this, "ای دی موجود نیست");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_searchinfoMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        try {
            getConnection();

            ps = conn.prepareStatement(
                    "SELECT Customers.Fullname, "
                    + "customer_statements.id, customer_statements.Customer_id, customer_statements.asset_type, "
                    + "customer_statements.gold_form, customer_statements.unit, customer_statements.transaction_type, "
                    + "customer_statements.amount, customer_statements.details, customer_statements.jalali_date "
                    + "FROM customer_statements "
                    + "LEFT JOIN Customers ON Customers.Customers_id = customer_statements.Customer_id ORDER BY id DESC"
            );
            rs = ps.executeQuery();

            model.setRowCount(0); // جدول پاک کړئ

            while (rs.next()) {

                Object[] row = {
                    rs.getString("jalali_date"),
                    rs.getString("details"),
                    rs.getDouble("amount"),
                    rs.getString("transaction_type"),
                    rs.getString("unit"),
                    rs.getString("gold_form"),
                    rs.getString("asset_type"),
                    rs.getString("Fullname"),
                    rs.getString("id"),};
                model.addRow(row);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
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
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_formWindowActivated
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
            java.util.logging.Logger.getLogger(Customer_statement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_statement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_statement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_statement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_statement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Amount;
    private javax.swing.JLabel asset_type;
    private javax.swing.JComboBox<String> asset_types;
    private javax.swing.JComboBox<String> cmbdate;
    private javax.swing.JComboBox<String> cmbselectcustomer;
    private javax.swing.JTextField deatiles;
    private javax.swing.JComboBox<String> gold_form;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jalalidate;
    private javax.swing.JLabel searchinfo;
    private javax.swing.JComboBox<String> transaction_type;
    private javax.swing.JTextField txtID;
    private javax.swing.JComboBox<String> unit;
    // End of variables declaration//GEN-END:variables
}
