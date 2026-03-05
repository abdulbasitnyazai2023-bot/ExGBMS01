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
import javax.swing.table.DefaultTableModel;

/**
 * e
 *
 * @author DELL
 */
public class Deposite_payment extends javax.swing.JFrame {

    /**
     * Creates new form Customers
     */
    public Deposite_payment() {
        initComponents();
        getConnection();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        styleTable();
        loadCustomers();
        loadEmployees();
        Deposite();
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
            getConnection();
            String sql = "SELECT  Fullname FROM Customers";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            cmbcustomer.removeAllItems();

            while (rs.next()) {
                // موږ id او نوم دواړه ذخیره کوو
                cmbcustomer.addItem(rs.getString("Fullname"));

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

    public void loadEmployees() {
        try {
            getConnection();
            String sql = "SELECT  Role_name FROM Roles";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            cmbapprovel.removeAllItems();

            while (rs.next()) {
                cmbapprovel.addItem(rs.getString("Role_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Deposite() {
        try {
            getConnection();
            String sql = "SELECT  Deposite_recept_id FROM Deposite_payment";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            Deposit.removeAllItems();

            while (rs.next()) {
                Deposit.addItem(rs.getString("Deposite_recept_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        search = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtamount = new javax.swing.JTextField();
        cmbcustomer = new javax.swing.JComboBox<>();
        txtcurrency = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtnic5 = new javax.swing.JTextField();
        cmbapprovel = new javax.swing.JComboBox<>();
        Deposit = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
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
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 150, 40));

        jButton3.setBackground(new java.awt.Color(30, 41, 59));
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
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 150, 40));

        search.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_23px.png"))); // NOI18N
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        jPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 170, -1, 40));

        txtID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIDFocusGained(evt);
            }
        });
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 170, 420, 40));

        jButton4.setBackground(new java.awt.Color(30, 41, 59));
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
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 150, 40));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("مقدار ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 181, 3));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 181, 3));
        jLabel3.setText("جدول ثبت پرداخت ها");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("نام مشتری");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("نام تایید کننده:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, -1));

        jTable1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "نام تایید کننده", "وضیعت", "تاریخ", "ارز", "مقدارپول", "نام کامل مشتری", "آی دی گرفت", "آی دی سپرده"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 1670, 540));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtamount.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamountActionPerformed(evt);
            }
        });
        jPanel2.add(txtamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 420, 40));

        cmbcustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نام فرستنده" }));
        jPanel2.add(cmbcustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 420, 40));

        txtcurrency.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtcurrency.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtcurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcurrencyActionPerformed(evt);
            }
        });
        jPanel2.add(txtcurrency, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 300, 420, 40));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("جستوی مشتری");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 410, -1, 40));

        txtnic5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtnic5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtnic5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnic5ActionPerformed(evt);
            }
        });
        jPanel2.add(txtnic5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, 820, 40));

        cmbapprovel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نام فرستنده" }));
        jPanel2.add(cmbapprovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 420, 40));

        Deposit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نام فرستنده" }));
        jPanel2.add(Deposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 420, 40));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("واحد");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 260, -1, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("واحد");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 260, -1, -1));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ای دی سپرده:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 260, -1, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("آی دی ثبت");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 130, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1690, 1030));

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
        try {
            getConnection();

            String txtid = txtID.getText();
            if (txtid.equals("")) {
                JOptionPane.showMessageDialog(this, "اول باید اطلاعات را انتخاب کنید سپس حذف کنید!");
            } else {
                ps = conn.prepareStatement("DELETE FROM Deposite_payment WHERE Deposite_payment_id=?");
                ps.setInt(1, Integer.parseInt(txtid));

                String[] options = {"بلی", "نخیر"};
                int choice = JOptionPane.showOptionDialog(
                        null,
                        "آیا میخواهید این انتقال حذف شود؟",
                        "پیام درخواست",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]
                );

                if (choice == 0) {
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "عملیات حذف با موفقیت انجام شد!");

                    // پاکول فرم فیلدها
                    txtID.setText("");
                    txtamount.setText("");
                    txtcurrency.setText("");

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusGained
        // TODO add your handling code here:

        try {
            getConnection();

            ps = conn.prepareStatement("SELECT MAX(Deposite_payment_id)+1 from Deposite_payment");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtID.setText(rs.getString("MAX(Deposite_payment_id)+1"));
            }
            ps.close();
            conn.close();
            rs.close();
        } catch (Exception e) {

        }

    }//GEN-LAST:event_txtIDFocusGained

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {

            getConnection();
            int customerId;
            String customerName = cmbcustomer.getSelectedItem() == null
                    ? ""
                    : cmbcustomer.getSelectedItem().toString().trim();

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
            // گرفتن نقش انتخاب شده از ComboBox
            getConnection();
            String roleName = cmbapprovel.getSelectedItem().toString();

//            // پیدا کردن Role_id از روی نام
//            int roleId = 0;
//            String findRole = "SELECT Role_id FROM Roles WHERE Role_name = ?";
//            PreparedStatement psRole = conn.prepareStatement(findRole);
//            psRole.setString(1, roleName);
//            ResultSet rsRole = psRole.executeQuery();
//            
//            if (rsRole.next()) {
//                roleId = rsRole.getInt("Role_id");
//            }
//            
//            rsRole.close();
//            psRole.close();
            String sql = "UPDATE Deposite_payment SET Deposite_recept_id=?,Customers_id=?,Amount=?,Currency=?,status=?,approved_by=? "
                    + "WHERE  Deposite_payment_id=?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, Deposit.getSelectedItem().toString().trim());
            ps.setInt(2, customerId);
            ps.setString(3, txtamount.getText());
            ps.setString(4, txtcurrency.getText());
            ps.setString(5, "Completed");
            ps.setString(6, cmbapprovel.getSelectedItem().toString().trim());
            ps.setString(7, txtID.getText());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "موافقانه ویرایش شد");

                // =========================
                // پاکول
//                // =========================
                txtID.setText("");
                txtamount.setText("");
                txtcurrency.setText("");

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {

            getConnection();
            int customerId;
            String customerName = cmbcustomer.getSelectedItem() == null
                    ? ""
                    : cmbcustomer.getSelectedItem().toString().trim();

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
            // گرفتن نقش انتخاب شده از ComboBox
            getConnection();
            String roleName = cmbapprovel.getSelectedItem().toString();

//            // پیدا کردن Role_id از روی نام
//            int roleId = 0;
//            String findRole = "SELECT Role_id FROM Roles WHERE Role_name = ?";
//            PreparedStatement psRole = conn.prepareStatement(findRole);
//            psRole.setString(1, roleName);
//            ResultSet rsRole = psRole.executeQuery();
//            
//            if (rsRole.next()) {
//                roleId = rsRole.getInt("Role_id");
//            }
//            
//            rsRole.close();
//            psRole.close();
            String sql = "INSERT INTO Deposite_payment(Deposite_payment_id,"
                    + "Deposite_recept_id,Customers_id,Amount,Currency,status,approved_by)"
                    + "VALUES(?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtID.getText());
            ps.setString(2, Deposit.getSelectedItem().toString().trim());
            ps.setInt(3, customerId);
            ps.setString(4, txtamount.getText());
            ps.setString(5, txtcurrency.getText());
            ps.setString(6, "Completed");
            ps.setString(7, cmbapprovel.getSelectedItem().toString().trim());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "سپرده ثبت شد");

                // =========================
                // پاکول
//                // =========================
                txtID.setText("");
                txtamount.setText("");
                txtcurrency.setText("");

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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtamountActionPerformed

    private void txtcurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcurrencyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcurrencyActionPerformed

    private void txtnic5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnic5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnic5ActionPerformed

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        try {
            getConnection();
            ps = conn.prepareStatement("SELECT *FROM Deposite_payment WHERE Deposite_payment_id=? ");
            ps.setString(1, txtID.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                Deposit.setSelectedItem(rs.getString(2));
                cmbcustomer.setSelectedItem(rs.getString(3));

                txtamount.setText(rs.getString(4));
                txtcurrency.setText(rs.getString(5));
                cmbapprovel.setSelectedItem(rs.getString(7));
                conn.close();
                ps.close();
                rs.close();

            } else {

                JOptionPane.showMessageDialog(this, "رمز عبور یا اسم کاربری غلط است!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_searchMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        try {
            getConnection();

            String sql = "SELECT Deposite_payment.Deposite_payment_id,Deposite_payment.Deposite_recept_id, Customers.Fullname,"
                    + "Deposite_payment.Amount,Deposite_payment.Currency,"
                    + "Deposite_payment.Created_at, Deposite_payment.Status,Deposite_payment.Approved_by "
                    + " FROM Deposite_payment LEFT JOIN Customers "
                    + " ON Customers.Customers_id = Deposite_payment.Customers_id ORDER BY Deposite_payment_id DESC ";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            model.setRowCount(0); // جدول پاک کړئ

            while (rs.next()) {

                Object[] row = {
                    rs.getString("Approved_by"),
                    rs.getString("Status"),
                    rs.getString("Created_at"),
                    rs.getString("Currency"),
                    rs.getDouble("Amount"),
                    rs.getString("Fullname"),
                    rs.getString("Deposite_recept_id"),
                    rs.getInt("Deposite_payment_id")};
                model.addRow(row);
            }

        } catch (Exception e) {
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
    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
         posX=evt.getX();
        posY=evt.getY();

    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
       this.setLocation(evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
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
            java.util.logging.Logger.getLogger(Deposite_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Deposite_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Deposite_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Deposite_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deposite_payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Deposit;
    private javax.swing.JComboBox<String> cmbapprovel;
    private javax.swing.JComboBox<String> cmbcustomer;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel search;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtcurrency;
    private javax.swing.JTextField txtnic5;
    // End of variables declaration//GEN-END:variables
}
