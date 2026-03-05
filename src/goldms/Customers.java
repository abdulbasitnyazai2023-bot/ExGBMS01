/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.sql.*;
import javax.swing.*;

import javax.swing.table.*;
import javax.xml.validation.Validator;
import utils.validitoar;


        


/**
 *
 * @author DELL
 */
public class Customers extends javax.swing.JFrame {

    /**
     * Creates new form Customers
     */
    public Customers() {
        initComponents();
         
        getConnection();
      
        styleTable();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validitoar.allowOnlyText(txtfullname);
        validitoar.allowOnlyNumbers(txtnic);
        validitoar.allowOnlyNumbersWithLimit(txtphone, 10);
        txtphone.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {

            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                checkPhone();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                checkPhone();
            }

            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                checkPhone();
            }

            private void checkPhone() {
                String number = validitoar.normalizeAfghanNumber(txtphone.getText());

                if (number.matches("\\d{10}")
                        && (number.startsWith("078")
                        || number.startsWith("077")
                        || number.startsWith("076")
                        || number.startsWith("073")
                        || number.startsWith("079")
                        || number.startsWith("074"))) {

                    txtphone.setBackground(new java.awt.Color(200, 255, 200)); // سبز
                } else {
                    txtphone.setBackground(new java.awt.Color(255, 200, 200)); // قرمز
                }
            }
        });

        // فرض کنید نام جدول شما jTableCustomers است
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // پیدا کردن ردیف انتخاب شده
                int row = jTable1.getSelectedRow();

                if (row != -1) { // مطمئن شویم ردیفی انتخاب شده است
                    // گرفتن آی‌دی مشتری از ستون اول (ایندکس 0)
                    // مقدار را به Integer تبدیل می‌کنیم
                    int id = Integer.parseInt(jTable1.getValueAt(row, 0).toString());

                    // بستن فرم فعلی (اختیاری) و باز کردن فرم بیلانس
                    BalanceForm balanceForm = new BalanceForm(id);
                    balanceForm.setVisible(true);
                    balanceForm.setLocationRelativeTo(null); // نمایش در مرکز مانیتور
                }
            }
        });

    }
    // Pagination
//    int currentPage = 1;
//    int rowsPerPage = 10;
//    int totalPages = 0;
    // د ډیټابېس مسیر (Path)
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    void getConnection() {

        try {
            // SQLite Driver Load
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:./src/db/Golds-1.db");
//            int offset = (currentPage - 1) * rowsPerPage;
            System.out.println("cont");

        } catch (ClassNotFoundException ex) {
            System.out.println("not found" + ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtnic = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtfullname = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblpage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(16, 23, 42));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(30, 41, 59));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_save_34px_1.png"))); // NOI18N
        jButton2.setText("ثبت");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 130, 40));

        jButton3.setBackground(new java.awt.Color(30, 41, 59));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_refresh_34px_1.png"))); // NOI18N
        jButton3.setText("ویرایش");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 140, 40));

        txtnic.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtnic.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtnic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnicActionPerformed(evt);
            }
        });
        txtnic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnicKeyTyped(evt);
            }
        });
        jPanel2.add(txtnic, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 400, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_23px.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 163, -1, 30));

        txtID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
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
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, 400, 40));

        txtfullname.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtfullname.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtfullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfullnameKeyTyped(evt);
            }
        });
        jPanel2.add(txtfullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 400, 40));

        txtaddress.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtaddress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel2.add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 400, 40));

        jButton4.setBackground(new java.awt.Color(30, 41, 59));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_delete_trash_34px_1.png"))); // NOI18N
        jButton4.setText("حذف");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 130, 40));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("نمبر تذکره مشتری");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 181, 3));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("جدول ثبت مشتریان");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("نام کامل مشتری");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("آدرس مشتری");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, -1, -1));

        txtphone.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtphone.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel2.add(txtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 280, 400, 40));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("تلفون مشتری");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 240, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblpage.setText("jLabel5");
        jPanel2.add(lblpage, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 730, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "عملیه", "آدرس ", "تلفون", "تذکره", "نام کامل", "آی دی"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 1380, 400));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("آی دی مشتری");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 120, -1, -1));

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

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

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

    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusGained
        // TODO add your handling code here:

        //max id
        try {
            ps = conn.prepareStatement("select max(Customers_id)+1 from Customers");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtID.setText(rs.getString("max(Customers_id)+1"));
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_txtIDFocusGained

    private void txtnicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnicActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (validitoar.isEmpty(txtfullname, "نام را وارد کنید!")) {
            return;
        }
        if (validitoar.isEmpty(txtphone, "شماره را وارد کنید!")) {
            return;
        }

        if (!validitoar.isNumeric(txtphone.getText())) {
            JOptionPane.showMessageDialog(this, "شماره فقط عدد باشد!");
            return;
        }

        if (validitoar.hasNumber(txtfullname.getText())) {
            JOptionPane.showMessageDialog(this, "نام نباید عدد داشته باشد!");
            return;
        }
        if (!validitoar.isValidAfghanNumber(txtphone)) {
            return;   // اگر اشتباه بود ثبت نشودisPhoneDuplicate
        }
        if (validitoar.isPhoneDuplicate(conn, txtphone.toString())) {

            return;
        }

        //update customer
        try {
            String id = txtID.getText();
            String full = txtfullname.getText();
            String nic = txtnic.getText();
            String p = txtphone.getText();
            String add = txtaddress.getText();

            if (id.equals("") || full.equals("") || nic.equals("") || p.equals("") || add.equals("")) {
                JOptionPane.showMessageDialog(this, "فیلدها را پر کنید!");
            } else {
                String phone = validitoar.normalizeAfghanNumber(txtphone.getText());

                if (!validitoar.isValidAfghanNumber(txtphone)) {
                    return;
                }

                if (validitoar.isPhoneDuplicate(conn, phone)) {
                    return;
                }
                if (!validitoar.isValidAfghanNumber(txtphone)) {
                    return;
                }
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        ///add new customer
        try {
            String id = txtID.getText();
            String full = txtfullname.getText();
            String nic = txtnic.getText();
            String p = txtphone.getText();
            String add = txtaddress.getText();
            if (id.equals("") || full.equals("") || nic.equals("") || p.equals("") || add.equals("")) {
                JOptionPane.showMessageDialog(this, "فیلدها را پر کنید!");
            } else {
                if (!validitoar.isValidAfghanNumber(txtphone)) {
                    return;
                }
                ps = conn.prepareStatement("INSERT INTO Customers(Customers_id,Fullname,NIC,Phone,Address)VALUES(?,?,?,?,?)");
                ps.setString(1, txtID.getText());
                ps.setString(2, txtfullname.getText());
                ps.setString(3, txtnic.getText());
                ps.setString(4, txtphone.getText());
                ps.setString(5, txtaddress.getText());
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(this, "مشتری موافقانه اضافه شد");
                txtID.setText("");
                txtfullname.setText("");
                txtaddress.setText("");
                txtphone.setText("");
                txtnic.setText("");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"آی دی", "نام کامل", "تلفون", "نمبرتذکره", "آدرس"}, 0);

        try {
//            int offset = (currentPage - 1) * rowsPerPage;
            String sql = "SELECT Customers_id, Fullname, Phone, NIC, Address "
                    + "FROM Customers ";
            ps = conn.prepareStatement(sql);
//            ps.setInt(1, rowsPerPage);
//            ps.setInt(2, offset);
            rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("Customers_id"),
                    rs.getString("Fullname"),
                    rs.getString("Phone"),
                    rs.getString("NIC"),
                    rs.getString("Address")
                });
            }

            jTable1.setModel(model);
//            lblpage.setText("Page " + currentPage + " of " + totalPages);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_formWindowActivated

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

//    int row = jTable1.getSelectedRow();
//    if (row >= 0) {
//      int customerId = Integer.parseInt(jTable1.getValueAt(row, 0).toString());
//
//        // فرم جدید باز می‌شود و بیلانس نشان داده می‌شود
//        CustomerBalanceDetailForm detailForm = new CustomerBalanceDetailForm(conn,customerId);
//        detailForm.setVisible(true);
//    }

    }//GEN-LAST:event_jTable1MouseClicked

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped

    }//GEN-LAST:event_txtIDKeyTyped

    private void txtfullnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfullnameKeyTyped

    }//GEN-LAST:event_txtfullnameKeyTyped

    private void txtnicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnicKeyTyped

    }//GEN-LAST:event_txtnicKeyTyped

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
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
    }//GEN-LAST:event_jLabel7MouseClicked
    int posX, posY;
    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        posX = evt.getX();
        posY = evt.getY();

    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        this.setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
    }//GEN-LAST:event_jPanel2MouseDragged

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
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblpage;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField txtnic;
    private javax.swing.JTextField txtphone;
    // End of variables declaration//GEN-END:variables
}
