/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Cancle_transaction extends javax.swing.JFrame {

    /**
     * Creates new form Customers
     */
    public Cancle_transaction() {
        initComponents();
        getConnection();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadEmployees();
        LoadTrans();
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

    public void loadEmployees() {
        try {

            String sql = "SELECT  Role_name FROM Roles";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            cmbbycalceled.removeAllItems();

            while (rs.next()) {
                cmbbycalceled.addItem(rs.getString("Role_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LoadTrans() {
        try {

            String sql = "SELECT  Transaction_id FROM Transactions";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            txtTransactionId.removeAllItems();

            while (rs.next()) {
                txtTransactionId.addItem(rs.getString("Transaction_id"));
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
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtReason = new javax.swing.JTextField();
        txtTransactionId = new javax.swing.JComboBox<>();
        cmbbycalceled = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtnic2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtnic4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtnic5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

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
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 150, 40));

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
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 150, 40));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_23px.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 173, -1, 40));

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
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 150, 40));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("توسط کدام کاربر لغومی شود");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 181, 3));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 181, 3));
        jLabel3.setText("جدول لغو معاملات");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("آی دی معامله");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("آی دی ثبت");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 130, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "عملیه", "توضیحات", "کاربری که لغو کرده", "آی دی معامله", "آی دی"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 1670, 510));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtReason.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtReason.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtReason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReasonActionPerformed(evt);
            }
        });
        jPanel2.add(txtReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 290, 420, 40));

        txtTransactionId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نام فرستنده" }));
        jPanel2.add(txtTransactionId, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 420, 40));

        cmbbycalceled.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نام گیرنده" }));
        jPanel2.add(cmbbycalceled, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 420, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("جستجوی معاملات");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 360, -1, 40));

        txtnic2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtnic2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtnic2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnic2ActionPerformed(evt);
            }
        });
        jPanel2.add(txtnic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 410, 420, 40));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("از تاریخ");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 360, -1, 40));

        txtnic4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtnic4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtnic4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnic4ActionPerformed(evt);
            }
        });
        jPanel2.add(txtnic4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, 420, 40));

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("از تاریخ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, -1, 40));

        txtnic5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtnic5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtnic5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnic5ActionPerformed(evt);
            }
        });
        jPanel2.add(txtnic5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 420, 40));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("توضیحات");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 250, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1690, 1030));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            getConnection(); // اتصال به دیتابیس

            if (txtTransactionId.getSelectedItem().toString().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "لطفاً Transaction ID را وارد کنید");
                return;
            }

            int transactionId = Integer.parseInt(txtTransactionId.getSelectedItem().toString().trim());

            // حذف رکورد
            String sql = "DELETE FROM Canceled_transaction WHERE C_transaction_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtID.getText());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "لغو معامله با موفقیت حذف شد ✅");

                // پاک کردن فیلدهای فرم بعد از حذف
                txtTransactionId.setSelectedIndex(0);
                cmbbycalceled.setSelectedIndex(0);
                txtReason.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "رکوردی با این Transaction ID پیدا نشد!");
            }

            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "تېروتنه: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusGained

        //max id
        try {
            ps = conn.prepareStatement("SELECT  MAX(C_transaction_id)+1 FROM Canceled_transaction");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtID.setText(rs.getString("MAX(C_transaction_id)+1"));
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_txtIDFocusGained

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            // اتصال به دیتابیس
            getConnection(); // فرض بر این است که conn آماده می‌شود

            // گرفتن نقش انتخاب شده از ComboBox
            String roleName = cmbbycalceled.getSelectedItem().toString();

            // پیدا کردن Role_id از روی نام
            int roleId = 0;
            String findRole = "SELECT Role_id FROM Roles WHERE Role_name = ?";
            PreparedStatement psRole = conn.prepareStatement(findRole);
            psRole.setString(1, roleName);
            ResultSet rsRole = psRole.executeQuery();

            if (rsRole.next()) {
                roleId = rsRole.getInt("Role_id");
            }

            rsRole.close();
            psRole.close();

            // گرفتن Transaction ID و دلیل لغو از فرم
            int transactionId = Integer.parseInt(txtTransactionId.getSelectedItem().toString().trim());
            String reason = txtReason.getText().trim();

            // ویرایش رکورد جدول Canceled_transaction
            String sql = "UPDATE Canceled_transaction "
                    + "SET Canceled_by = ?, Reason = ? "
                    + "WHERE Transaction_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, roleId);
            ps.setString(2, reason);
            ps.setInt(3, transactionId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "لغو معامله با موفقیت ویرایش شد!");

                // پاک کردن فیلدها بعد از ویرایش
                txtTransactionId.setSelectedIndex(0);
                txtReason.setText("");
                cmbbycalceled.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "رکوردی برای ویرایش پیدا نشد!");
            }

            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "تېروتنه: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            // اتصال به دیتابیس
            getConnection(); // فرض بر این است که conn آماده می‌شود

            // گرفتن نقش انتخاب شده از ComboBox
            String roleName = cmbbycalceled.getSelectedItem().toString();

            // پیدا کردن Role_id از روی نام
            int roleId = 0;
            String findRole = "SELECT Role_id FROM Roles WHERE Role_name = ?";
            PreparedStatement psRole = conn.prepareStatement(findRole);
            psRole.setString(1, roleName);
            ResultSet rsRole = psRole.executeQuery();

            if (rsRole.next()) {
                roleId = rsRole.getInt("Role_id");
            }

            rsRole.close();
            psRole.close();

            // گرفتن Transaction ID و دلیل لغو از فرم
            int transactionId = Integer.parseInt(txtTransactionId.getSelectedItem().toString().trim());
            String reason = txtReason.getText().trim();

            // ثبت در جدول Canceled_transaction
            String sql = "INSERT INTO Canceled_transaction "
                    + "(Transaction_id, Canceled_by, Reason) "
                    + "VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, transactionId);
            ps.setInt(2, roleId);
            ps.setString(3, reason);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "لغو معامله با موفقیت ثبت شد!");

                // پاک کردن فیلدها بعد از ثبت
                txtTransactionId.setSelectedIndex(0);
                txtReason.setText("");
                cmbbycalceled.setSelectedIndex(0);
            }

            ps.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "تېروتنه: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtReasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReasonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReasonActionPerformed

    private void txtnic2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnic2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnic2ActionPerformed

    private void txtnic4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnic4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnic4ActionPerformed

    private void txtnic5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnic5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnic5ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        try {
            getConnection();

            // SQL با WHERE برای Transaction_id
            String sql = "SELECT Roles.Role_name, Canceled_transaction.Transaction_id, Canceled_transaction.Reason "
                    + "FROM Canceled_transaction "
                    + "LEFT JOIN Roles ON Roles.Role_id = Canceled_transaction.Canceled_by "
                    + "WHERE Canceled_transaction.C_transaction_id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtID.getText())); // ای دی وارد شده در txtID

            rs = ps.executeQuery();

            if (rs.next()) {
                // ✅ Transaction_id را داخل txtTransactionId نمایش می‌دهد
                txtTransactionId.setSelectedItem(String.valueOf(rs.getInt("Transaction_id")));

                // ✅ نام نقش را در ComboBox انتخاب می‌کند
                cmbbycalceled.setSelectedItem(rs.getString("Role_name"));

                // ✅ دلیل لغو را در TextField یا TextArea ست می‌کند
                txtReason.setText(rs.getString("Reason"));

            } else {

                JOptionPane.showMessageDialog(this, "به این ای دی معامله لغوه نشده است");
                txtReason.setText("");
                txtID.setText("");
                cmbbycalceled.setSelectedIndex(0);
                txtTransactionId.setSelectedIndex(0);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // ساخت مدل جدول
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{
                    "انتخاب", "Transaction ID", "کاربر لغوکننده", "دلیل", "وضعیت"
                }, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class; // فقط ستون اول چک باکس
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0; // فقط چک باکس قابل ویرایش
            }
        };

        jTable1.setModel(model);

        try {
            getConnection();

            // گرفتن داده‌ها از Canceled_transaction با JOIN روی Roles
            String sql = "SELECT c.C_transaction_id, r.Role_name, c.Reason, c.Canceled_at "
                    + "FROM Canceled_transaction c "
                    + "LEFT JOIN Roles r ON c.Canceled_by = r.Role_id";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            model.setRowCount(0); // پاک کردن جدول

            while (rs.next()) {
                Object[] row = {
                    false, // چک باکس
                    rs.getInt("C_transaction_id"),
                    rs.getString("Role_name"),
                    rs.getString("Reason"),
                    "CANCELED" // وضعیت پیشفرض
                };
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

// رنگ‌آمیزی ستون وضعیت
        jTable1.getColumn("وضعیت").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value != null) {
                    String status = value.toString();
                    switch (status) {
                        case "CANCELED":
                            setBackground(Color.LIGHT_GRAY);
                            break;
                        default:
                            setBackground(Color.WHITE);
                    }
                }
                return this;
            }
        });

// Listener برای چک باکس
        jTable1.getDefaultEditor(Boolean.class).addCellEditorListener(new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {
                DefaultTableModel currentModel = (DefaultTableModel) jTable1.getModel();
                int row = jTable1.getEditingRow();
                if (row < 0) {
                    row = jTable1.getSelectedRow();
                }
                if (row < 0) {
                    return;
                }

                Boolean selected = (Boolean) currentModel.getValueAt(row, 0);

                try {
                    getConnection();
                    int transactionId = (int) currentModel.getValueAt(row, 1);

                    if (selected) {
                        // نمایش OptionPane برای تایید یا حذف لغو معامله
                        String[] options = {"حذف", "بستن"};
                        int choice = JOptionPane.showOptionDialog(
                                null,
                                "می‌خواهید این معامله لغو شده را حذف کنید؟",
                                "لغو معامله",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                options,
                                options[0]
                        );

                        if (choice == 0) {
                            // حذف از دیتابیس
                            ps = conn.prepareStatement("DELETE FROM Canceled_transaction WHERE C_transaction_id = ?");
                            ps.setInt(1, transactionId);
                            ps.executeUpdate();

                            // حذف از JTable
                            currentModel.removeRow(row);
                        }

                        // چک باکس را ریست کن
                        jTable1.repaint();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
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
            }

            @Override
            public void editingCanceled(ChangeEvent e) {
            }
        });
    }//GEN-LAST:event_formWindowActivated
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
            java.util.logging.Logger.getLogger(Cancle_transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cancle_transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cancle_transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cancle_transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cancle_transaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbbycalceled;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtReason;
    private javax.swing.JComboBox<String> txtTransactionId;
    private javax.swing.JTextField txtnic2;
    private javax.swing.JTextField txtnic4;
    private javax.swing.JTextField txtnic5;
    // End of variables declaration//GEN-END:variables
}
