package goldms;

import java.awt.Image;
import java.sql.*;
import static java.util.Arrays.fill;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Exchange_rate extends javax.swing.JFrame {

    public Exchange_rate() {
        initComponents();
        getConnection();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadEmployees();
        styleTable();
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

            select.removeAllItems();

            while (rs.next()) {
                select.addItem(rs.getString("Role_name"));
            }

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
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        serach = new javax.swing.JLabel();
        rate_id = new javax.swing.JTextField();
        dollar_to_afn = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        afn_to_dollar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtnic5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtnic7 = new javax.swing.JTextField();
        select = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();

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
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 180, 40));

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
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 180, 40));

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
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 180, 40));

        jLabel3.setBackground(new java.awt.Color(255, 181, 3));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 181, 3));
        jLabel3.setText("جدول ثبت ارز");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "تایید شده", "تاریخ", "افغانی به دالر", "دالر به افغانی", "آی دی"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 1670, 610));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        serach.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        serach.setForeground(new java.awt.Color(255, 255, 255));
        serach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_23px.png"))); // NOI18N
        jPanel2.add(serach, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 183, -1, 40));

        rate_id.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        rate_id.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        rate_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rate_idFocusGained(evt);
            }
        });
        rate_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rate_idActionPerformed(evt);
            }
        });
        jPanel2.add(rate_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 180, 360, 40));

        dollar_to_afn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        dollar_to_afn.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dollar_to_afn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dollar_to_afnActionPerformed(evt);
            }
        });
        jPanel2.add(dollar_to_afn, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 360, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("دالر به افغانی");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("افغانی به دالر");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, -1, -1));

        afn_to_dollar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        afn_to_dollar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        afn_to_dollar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afn_to_dollarActionPerformed(evt);
            }
        });
        jPanel2.add(afn_to_dollar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 360, 40));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("از تاریخ");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 270, -1, 40));

        txtnic5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtnic5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtnic5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnic5ActionPerformed(evt);
            }
        });
        jPanel2.add(txtnic5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 320, 360, 40));

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("نام کاربر:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, -1));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("تا تاریخ");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 270, -1, 40));

        txtnic7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtnic7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtnic7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnic7ActionPerformed(evt);
            }
        });
        jPanel2.add(txtnic7, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 320, 360, 40));

        select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 340, 40));

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("آی دی ثبت");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 140, -1, -1));

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
        try {
            getConnection(); // فرض بر این است که conn آماده می‌شود

            ps = conn.prepareStatement("INSERT INTO exchange_rate(rate_id,dollar_to_afn,afn_to_dollar,created_by)VALUES(?,?,?,?)");
            ps.setString(1, rate_id.getText());
            ps.setString(2, dollar_to_afn.getText());
            ps.setString(3, afn_to_dollar.getText());
            ps.setString(4, select.getSelectedItem().toString().trim());
            int row = ps.executeUpdate();
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "قیمت به موافقت ثبت شد!");

            } else {
                JOptionPane.showMessageDialog(this, "مشکل به وجود امد دوباره کوشش کنید!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void afn_to_dollarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afn_to_dollarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afn_to_dollarActionPerformed

    private void txtnic5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnic5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnic5ActionPerformed

    private void dollar_to_afnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dollar_to_afnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dollar_to_afnActionPerformed

    private void rate_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rate_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rate_idActionPerformed

    private void txtnic7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnic7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnic7ActionPerformed

    private void rate_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rate_idFocusGained

        //max id
        try {
            ps = conn.prepareStatement("SELECT  MAX(rate_id)+1 FROM exchange_rate");
            rs = ps.executeQuery();
            if (rs.next()) {
                rate_id.setText(rs.getString("MAX(rate_id)+1"));
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_rate_idFocusGained

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        try {
            getConnection();
            ps = conn.prepareStatement("SELECT *FROM exchange_rate ORDER BY rate_id DESC");
            rs = ps.executeQuery();

            model.setRowCount(0); // جدول پاک کړئ

            while (rs.next()) {

                Object[] row = {
                    rs.getString("created_by"),
                    rs.getString("rate_datetime"),
                    rs.getString("afn_to_dollar"),
                    rs.getString("dollar_to_afn"),
                    rs.getInt("rate_id"),};
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
    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered

        posX = evt.getX();
        posY = evt.getY();

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
            java.util.logging.Logger.getLogger(Exchange_rate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exchange_rate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exchange_rate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exchange_rate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exchange_rate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField afn_to_dollar;
    private javax.swing.JTextField dollar_to_afn;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField rate_id;
    private javax.swing.JComboBox<String> select;
    private javax.swing.JLabel serach;
    private javax.swing.JTextField txtnic5;
    private javax.swing.JTextField txtnic7;
    // End of variables declaration//GEN-END:variables
}
