/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class Transfer extends javax.swing.JFrame {


    public Transfer() {
        initComponents();
//total.getDocument().addDocumentListener(new DocumentListener() {
//    private boolean isUpdating = false;
//
//    @Override
//    public void insertUpdate(DocumentEvent e) { format(); }
//    @Override
//    public void removeUpdate(DocumentEvent e) { format(); }
//    @Override
//    public void changedUpdate(DocumentEvent e) { format(); }
//
//    private void format() {
//        if (isUpdating) return;
//
//        String text = total.getText().replaceAll(",", "");
//        if (text.isEmpty()) return;
//
//        try {
//            long number = Long.parseLong(text);
//            if (number >= 1000) {
//                isUpdating = true;
//
//                // مهمه برخه: د EDT په بل Runnable کې اپډیټ کول
//                SwingUtilities.invokeLater(() -> {
//                    DecimalFormat df = new DecimalFormat("#,###");
//                    total.setText(df.format(number));
//                    total.setCaretPosition(total.getText().length());
//                    isUpdating = false;
//                });
//            }
//        } catch (NumberFormatException ex) {
//            // که عدد سم نه وي، هیڅ کار مه کوه
//            isUpdating = false;
//        }
//    }
//});
        getConnection();
        loadCustomers();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public void loadCustomers() {
        try {

            String sql = "SELECT  Fullname FROM Customers";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            cmbsender.removeAllItems();
            cmbreciver.removeAllItems();

            while (rs.next()) {
                // موږ id او نوم دواړه ذخیره کوو
                cmbsender.addItem(rs.getString("Fullname"));
                cmbreciver.addItem(rs.getString("Fullname"));
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
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        search = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        cmbmonytype = new javax.swing.JComboBox<>();
        cmbsender = new javax.swing.JComboBox<>();
        cmbreciver = new javax.swing.JComboBox<>();
        txtdescription = new javax.swing.JTextField();
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
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 150, 40));

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
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 150, 40));

        search.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_23px.png"))); // NOI18N
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });
        jPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 170, 40, 40));

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
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 150, 40));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("نام گیرنده");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 181, 3));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 181, 3));
        jLabel3.setText("انتقال بین حساب ها");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("نام فرستنده");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("آی دی ثبت");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("توضیحات");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 350, -1, -1));

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
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 1670, 550));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("مقدار پول");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 250, -1, -1));

        total.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        jPanel2.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 420, 40));

        cmbmonytype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "افغانی", "دالر" }));
        cmbmonytype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbmonytypeActionPerformed(evt);
            }
        });
        jPanel2.add(cmbmonytype, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 290, 420, 40));

        cmbsender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نام فرستنده" }));
        jPanel2.add(cmbsender, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 420, 40));

        cmbreciver.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نام گیرنده" }));
        jPanel2.add(cmbreciver, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 420, 40));

        txtdescription.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtdescription.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtdescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescriptionActionPerformed(evt);
            }
        });
        jPanel2.add(txtdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 400, 420, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("واحد پول");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 250, -1, -1));

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


    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                
        try {
            
            getConnection();

            String txtid = txtID.getText();
            if (txtid.equals("")) {
                JOptionPane.showMessageDialog(this, "اول باید اطلاعات را انتخاب کنید سپس حذف کنید!");
            } else {
                ps = conn.prepareStatement("DELETE FROM Transfer_account WHERE Transfer_id=?");
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
                    total.setText("");
                    txtdescription.setText("");
                    cmbsender.setSelectedIndex(0);
                    cmbreciver.setSelectedIndex(0);
                    cmbmonytype.setSelectedIndex(0);
                    txtID.setText("");
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

        //max id
        try {
            getConnection();
            ps = conn.prepareStatement("SELECT MAX(Transfer_id)+1 FROM Transfer_account");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtID.setText(rs.getString("MAX(Transfer_id)+1"));
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }//GEN-LAST:event_txtIDFocusGained

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            getConnection();

            int senderId = 0;
            String senderName = cmbsender.getSelectedItem().toString();
            String findSender = "SELECT Customers_id FROM Customers WHERE Fullname = ?";
            PreparedStatement psSender = conn.prepareStatement(findSender);
            psSender.setString(1, senderName);
            ResultSet rsSender = psSender.executeQuery();

            if (rsSender.next()) {
                senderId = rsSender.getInt("Customers_id");
            }
            rsSender.close();
            psSender.close();

            int receiverId = 0;
            String receiverName = cmbreciver.getSelectedItem().toString();
            String findReceiver = "SELECT Customers_id FROM Customers WHERE Fullname = ?";
            PreparedStatement psReceiver = conn.prepareStatement(findReceiver);
            psReceiver.setString(1, receiverName);
            ResultSet rsReceiver = psReceiver.executeQuery();

            if (rsReceiver.next()) {
                receiverId = rsReceiver.getInt("Customers_id");
            }
            rsReceiver.close();
            psReceiver.close();

// د txttotal څخه متن واخلئ
            String totalText = total.getText().trim();
            String formatted = "";
            try {
                double totalValue = Double.parseDouble(totalText);

                // که عدد له 1000 څخه زیات وي
                if (totalValue >= 1000) {
                    // DecimalFormat د زرګونو جلا کولو لپاره
                    DecimalFormat df = new DecimalFormat("#,###");
                    formatted = df.format(totalValue);

                    total.setText(formatted);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "مهرباني وکړئ سم عدد داخل کړئ!");
            }
            String sql = "UPDATE Transfer_account SET "
                    + "Sender_Customer_id = ?, "
                    + "Receiver_Customer_id = ?, "
                    + "Amount = ?, "
                    + "Currency = ?, "
                    + "Status = ?, "
                    + "Description = ? "
                    + "WHERE Transfer_id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setString(3, formatted);
            ps.setString(4, cmbmonytype.getSelectedItem().toString());
            ps.setString(5, "PENDING");
            ps.setString(6, txtdescription.getText());

            ps.setInt(7, Integer.parseInt(txtID.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "انتقال موفقانه اپډیټ شد!");
                txtID.setText("");
                txtdescription.setText("");
                total.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "ریکارډ پیدا نشد!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "مشکل: " + e.getMessage());
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            getConnection();
            String money_type = cmbmonytype.getSelectedItem().toString();
            if (money_type.equals("افغانی")) {
                money_type = "afg";

            } else {
                money_type = "usd";
            }
            int senderId = 0;
            String senderName = cmbsender.getSelectedItem().toString();
            String findSender = "SELECT Customers_id FROM Customers WHERE Fullname = ?";
            PreparedStatement psSender = conn.prepareStatement(findSender);
            psSender.setString(1, senderName);
            ResultSet rsSender = psSender.executeQuery();

            if (rsSender.next()) {
                senderId = rsSender.getInt("Customers_id");
            }

            rsSender.close();
            psSender.close();

            int receiverId = 0;
            String receiverName = cmbreciver.getSelectedItem().toString();
            String findReceiver = "SELECT Customers_id FROM Customers WHERE Fullname = ?";
            PreparedStatement psReceiver = conn.prepareStatement(findReceiver);
            psReceiver.setString(1, receiverName);
            ResultSet rsReceiver = psReceiver.executeQuery();

            if (rsReceiver.next()) {
                receiverId = rsReceiver.getInt("Customers_id");
            }

            rsReceiver.close();
            psReceiver.close();

            String sql = "INSERT INTO Transfer_account "
                    + "(Sender_Customer_id, Receiver_Customer_id, Amount, Currency, Status, Description) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setDouble(3, Double.parseDouble(total.getText()));
            ps.setString(4, money_type);
            ps.setString(5, "PENDING");
            ps.setString(6, txtdescription.getText());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "انتقال موفقانه ثبت شد!");

                txtID.setText("");
                txtdescription.setText("");
                total.setText("");
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Exite().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void txtdescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescriptionActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed

    }//GEN-LAST:event_searchKeyPressed

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        //search customer
        try {
            getConnection();
            ps = conn.prepareStatement("SELECT * FROM Transfer_account WHERE Transfer_id=?");
            ps.setString(1, txtID.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                cmbsender.setSelectedItem(rs.getString(""));
                cmbreciver.setSelectedItem(rs.getString(3));
                cmbmonytype.setSelectedItem(rs.getString(4));
                total.setText(rs.getString(5));
                txtdescription.setText(rs.getString(6));

            } else {
                JOptionPane.showMessageDialog(this, "به این آی دی" + txtID.getText() + "به این ای دی انتقال صورت نگرفته");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_searchMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{
                    "انتخاب", "ID", "فرستنده", "گیرنده", "مقدار", "نوع پول", "توضیحات", "وضیعت"
                }, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0; // یواځې چک باکس ایډیټ کیدی شي
            }
        };

        jTable1.setModel(model);

        try {
            getConnection();

            String sql = "SELECT t.Transfer_id, s.Fullname AS SenderName, r.Fullname AS ReceiverName, "
                    + "t.Amount, t.Currency, t.Description, t.Status "
                    + "FROM Transfer_account t "
                    + "JOIN Customers s ON t.Sender_Customer_id = s.Customers_id "
                    + "JOIN Customers r ON t.Receiver_Customer_id = r.Customers_id";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            model.setRowCount(0); // جدول پاک کړئ

            while (rs.next()) {
                boolean isPending = "PENDING".equals(rs.getString("Status"));

                Object[] row = {
                    isPending, // چک باکس
                    rs.getInt("Transfer_id"),
                    rs.getString("SenderName"),
                    rs.getString("ReceiverName"),
                    rs.getDouble("Amount"),
                    rs.getString("Currency"),
                    rs.getString("Description"),
                    rs.getString("Status")
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
        jTable1.getColumn("وضیعت").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value != null) {
                    String status = value.toString();
                    switch (status) {
                        case "PENDING":
                            setBackground(Color.YELLOW);
                            break;
                        case "APPROVED":
                            setBackground(Color.GREEN);
                            break;
                        case "REJECTED":
                            setBackground(Color.RED);
                            break;
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
                String status = currentModel.getValueAt(row, 7).toString(); // ستونز وضیعت

                try {
                    getConnection();
                    int transferId = (int) currentModel.getValueAt(row, 1);

                    if (selected && "PENDING".equals(status)) {
                        // OptionPane ښکاره شي
                        String[] options = {"تایید", "رد", "بستن"};
                        int choice = JOptionPane.showOptionDialog(
                                null,
                                "یکی از گزینه‌های زیر را انتخاب کنید:",
                                "پیام وضعیت انتقال",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                options,
                                options[0]
                        );

                        String newStatus = status; // که څه هم نه بدلیږي
                        switch (choice) {
                            case 0:
                                newStatus = "APPROVED";
                                break;
                            case 1:
                                newStatus = "REJECTED";
                                break;
                            default:
                                newStatus = "PENDING";
                                break;
                        }

                        // اپډیټ په دیتابیس کې
                        ps = conn.prepareStatement("UPDATE Transfer_account SET Status=? WHERE Transfer_id=?");
                        ps.setString(1, newStatus);
                        ps.setInt(2, transferId);
                        ps.executeUpdate();

                        // JTable تازه کول
                        currentModel.setValueAt(newStatus, row, 7);
                        currentModel.setValueAt(false, row, 0); // چک باکس بېرته false شي
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

    private void cmbmonytypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbmonytypeActionPerformed

    }//GEN-LAST:event_cmbmonytypeActionPerformed

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
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbmonytype;
    private javax.swing.JComboBox<String> cmbreciver;
    private javax.swing.JComboBox<String> cmbsender;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel search;
    private javax.swing.JTextField total;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtdescription;
    // End of variables declaration//GEN-END:variables
}
