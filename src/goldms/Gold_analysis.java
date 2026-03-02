/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Gold_analysis extends javax.swing.JFrame {

    /**
     * Creates new form Treasury
     */
    public Gold_analysis() {
        initComponents();
        getConnection();
        loadCustomers();
        setLocationRelativeTo(this);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtfinalweight = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtgrossweight = new javax.swing.JTextField();
        txtcarat = new javax.swing.JTextField();
        txtpricepurtola = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtdate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txttotalprice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cmbcustomer = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(16, 23, 42));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jPanel1InputMethodTextChanged(evt);
            }
        });
        jPanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanel1PropertyChange(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtfinalweight.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtfinalweight.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtfinalweight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfinalweightFocusGained(evt);
            }
        });
        txtfinalweight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfinalweightKeyTyped(evt);
            }
        });
        jPanel1.add(txtfinalweight, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 380, 40));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 170, 3));
        jLabel2.setText("جدول ثبت طلای خام");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("وزن نهایی");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtsearch.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtsearch.setForeground(new java.awt.Color(255, 255, 255));
        txtsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_23px.png"))); // NOI18N
        txtsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtsearchMouseClicked(evt);
            }
        });
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 143, -1, 40));

        txtId.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdFocusGained(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 140, 380, 40));

        txtgrossweight.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtgrossweight.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtgrossweight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtgrossweightFocusGained(evt);
            }
        });
        txtgrossweight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtgrossweightKeyTyped(evt);
            }
        });
        jPanel1.add(txtgrossweight, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 380, 40));

        txtcarat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtcarat.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtcarat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcaratFocusGained(evt);
            }
        });
        txtcarat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcaratKeyTyped(evt);
            }
        });
        jPanel1.add(txtcarat, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 250, 380, 40));

        txtpricepurtola.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtpricepurtola.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtpricepurtola.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpricepurtolaFocusGained(evt);
            }
        });
        txtpricepurtola.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpricepurtolaKeyTyped(evt);
            }
        });
        jPanel1.add(txtpricepurtola, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 380, 40));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("نام مشتری");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("وزن اولیه");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("عیار مبدا");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("قیمت فی طوله");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, -1, -1));

        jButton2.setBackground(new java.awt.Color(30, 41, 59));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_delete_trash_34px_1.png"))); // NOI18N
        jButton2.setText("حذف");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 135, 40));

        txtdate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtdate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdateFocusGained(evt);
            }
        });
        txtdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdateKeyTyped(evt);
            }
        });
        jPanel1.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 380, 40));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("تاریخ ثبت");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, -1, -1));

        txttotalprice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txttotalprice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttotalprice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txttotalpriceFocusGained(evt);
            }
        });
        txttotalprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttotalpriceKeyTyped(evt);
            }
        });
        jPanel1.add(txttotalprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 360, 380, 40));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("قیمت مجموعی");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 330, -1, -1));

        jButton3.setBackground(new java.awt.Color(30, 41, 59));
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
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 130, 40));

        jButton4.setBackground(new java.awt.Color(30, 41, 59));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_refresh_34px_1.png"))); // NOI18N
        jButton4.setText("ویرایش");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 145, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "عملیه", "تاریخ ثبت", "قیمت مجموعی", "وزن نهایی", "قیمت فی طوله", "عیار طلا", "وزن اولیه", "نام مشتری", "آی دی "
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 1380, 400));

        cmbcustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbcustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 380, 40));

        jButton1.setText("محاسبه");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 420, -1, -1));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("آی دی ثبت");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 110, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfinalweightFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfinalweightFocusGained

    }//GEN-LAST:event_txtfinalweightFocusGained

    private void txtfinalweightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfinalweightKeyTyped
////        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        String search = txtsearch.getText();
//        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
////        jTable1.setRowSorter(tr);
//        tr.setRowFilter(RowFilter.regexFilter(search));

    }//GEN-LAST:event_txtfinalweightKeyTyped

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained
        try {
            getConnection();
            ps = conn.prepareStatement("SELECT  MAX(Gold_analysis_id)+1 FROM Gold_analysis");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtId.setText(rs.getString("MAX(Gold_analysis_id)+1"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }//GEN-LAST:event_txtIdFocusGained

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtgrossweightFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtgrossweightFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgrossweightFocusGained

    private void txtgrossweightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgrossweightKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgrossweightKeyTyped

    private void txtcaratFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcaratFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaratFocusGained

    private void txtcaratKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaratKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaratKeyTyped

    private void txtpricepurtolaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpricepurtolaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpricepurtolaFocusGained

    private void txtpricepurtolaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpricepurtolaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpricepurtolaKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            getConnection();

            String txtid = txtId.getText();
            if (txtid.equals("")) {
                JOptionPane.showMessageDialog(this, "اول باید اطلاعات را انتخاب کنید سپس حذف کنید!");
            } else {
                ps = conn.prepareStatement("DELETE FROM Gold_analysis WHERE Gold_analysis_id=?");
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
                    txtId.setText("");
                    txtcarat.setText("");
                    txtgrossweight.setText("");
                    txtfinalweight.setText("");
                    txtpricepurtola.setText("");
                    txtdate.setText("");

                    cmbcustomer.setSelectedIndex(0);

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


    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtdateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdateFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdateFocusGained

    private void txtdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdateKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdateKeyTyped

    private void txttotalpriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttotalpriceFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalpriceFocusGained

    private void txttotalpriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalpriceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalpriceKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            getConnection();

            // =========================
            // 1️⃣ Customer ID پیدا کول
            // =========================
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

            // =========================
            // 2️⃣ Values اخیستل
            // =========================
            double grossWeight = txtgrossweight.getText().isEmpty() ? 0
                    : Double.parseDouble(txtgrossweight.getText());

            double carat = txtcarat.getText().isEmpty() ? 0
                    : Double.parseDouble(txtcarat.getText());

            double pricePerTola = txtpricepurtola.getText().isEmpty() ? 0
                    : Double.parseDouble(txtpricepurtola.getText());

            double finalWeight = txtfinalweight.getText().isEmpty() ? 0
                    : Double.parseDouble(txtfinalweight.getText());

            // =========================
            // 3️⃣ INSERT عملیات
            // =========================
            String sql = "INSERT INTO Gold_analysis ("
                    + "Gold_analysis_id,Customers_id, Gross_weight, Initial_purity, "
                    + "Tola_rate, Final_weight, Analysis_date"
                    + ") VALUES (?, ?, ?, ?, ?, ?,?)";

            ps = conn.prepareStatement(sql);

            ps.setInt(2, customerId);
            ps.setString(1, txtId.getText());
            ps.setDouble(3, grossWeight);
            ps.setDouble(4, carat);
            ps.setDouble(5, pricePerTola);
            ps.setDouble(6, finalWeight);
            ps.setString(7, txtdate.getText().trim());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Gold Analysis په بریالیتوب سره ثبت شو ✅");

                // =========================
                // پاکول
                // =========================
                txtgrossweight.setText("");
                txtcarat.setText("");
                txtpricepurtola.setText("");
                txtfinalweight.setText("");
                txttotalprice.setText("");
                txtdate.setText("");
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            getConnection();

            int find_customer_by = 0;
            String receiverName = cmbcustomer.getSelectedItem().toString();
            String findReceiver = "SELECT Customers_id FROM Customers WHERE Fullname = ?";
            PreparedStatement psReceiver = conn.prepareStatement(findReceiver);
            psReceiver.setString(1, receiverName);
            ResultSet rsReceiver = psReceiver.executeQuery();

            if (rsReceiver.next()) {
                find_customer_by = rsReceiver.getInt("Customers_id");
            }
            rsReceiver.close();
            psReceiver.close();

            String sql = "UPDATE Gold_analysis SET "
                    + "  Customers_id=?, Gross_weight=?, Initial_purity=?, "
                    + "Tola_rate=?, Final_weight=?, Analysis_date=? WHERE Gold_analysis_id=?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, find_customer_by);

            ps.setDouble(2, Double.parseDouble(txtgrossweight.getText()));
            ps.setDouble(3, Double.parseDouble(txtcarat.getText()));
            ps.setDouble(4, Double.parseDouble(txtpricepurtola.getText()));
            ps.setDouble(5, Double.parseDouble(txtfinalweight.getText()));
            ps.setString(6, txtdate.getText());

            ps.setInt(7, Integer.parseInt(txtId.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "انتقال موفقانه اپډیټ شد!");
            } else {
                JOptionPane.showMessageDialog(this, "ریکارډ پیدا نشد!");
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            double grossWeight = Double.parseDouble(txtgrossweight.getText());
            double init_carat = Double.parseDouble(txtcarat.getText());
            double pricePerTola = Double.parseDouble(txtpricepurtola.getText());

            // =====================
            // محاسبه
            // =====================
            // Final Weight = Gross × (Carat / 24)
            double finalWeight = (grossWeight * init_carat)/ 23.88;

            // Total Price = Final Weight × Price Per Tola
            
/*
         عیار اولیه   1215
            
            
           مجموع پول 20000 
            
          وزن تهایی  1215
            قیمت مجموعی ۲۰۰۰۰۰
            
            
            
            */
            double tola_weight = finalWeight/ 12.15;
            double totalPrice = tola_weight * pricePerTola;

            // =====================
            // نتیجه ښودل
            // =====================
            txtfinalweight.setText(String.format("%.2f", finalWeight));
            txttotalprice.setText(String.format("%.2f", totalPrice));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Number Entered");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanel1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1PropertyChange

    private void jPanel1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jPanel1InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1InputMethodTextChanged

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void txtsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtsearchMouseClicked
        try {
            getConnection();
            String find_id = txtId.getText();
            String sql = "SELECT * FROM Gold_analysis WHERE Gold_analysis_id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, find_id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cmbcustomer.setSelectedItem(rs.getString(2));
                txtgrossweight.setText(rs.getString(3));
                txtcarat.setText(rs.getString(4));
                txtpricepurtola.setText(rs.getString(5));
                txtfinalweight.setText(rs.getString(6));
                txttotalprice.setText(rs.getString(7));
                txtdate.setText(rs.getString("Analysis_date"));

            } else {
                JOptionPane.showMessageDialog(this, "به این آی دی طلا ثبت نشده");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtsearchMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    // 1️⃣ DefaultTableModel جوړول
DefaultTableModel model = new DefaultTableModel(
    new Object[]{"ID", "Customer", "Gross Weight", "Initial Purity", "Tola Rate", "Final Weight", "Date"}, 0
);
jTable1.setModel(model);

// 2️⃣ Database نه Data Load کول
try {
    getConnection();

    String sql = "SELECT g.Gold_analysis_id, c.Fullname, "
               + "g.Gross_weight, g.Initial_purity, g.Tola_rate, g.Final_weight, g.Analysis_date "
               + "FROM Gold_analysis g "
               + "JOIN Customers c ON g.Customers_id = c.Customers_id "
               + "ORDER BY g.Gold_analysis_id DESC";

    ps = conn.prepareStatement(sql);
    rs = ps.executeQuery();

    model.setRowCount(0); // جدول پاکول 

    while (rs.next()) {
        Object[] row = {
            rs.getInt("Gold_analysis_id"),
            rs.getString("Fullname"),
            rs.getDouble("Gross_weight"),
            rs.getDouble("Initial_purity"),
            rs.getDouble("Tola_rate"),
            rs.getDouble("Final_weight"),
            rs.getString("Analysis_date")
        };
        model.addRow(row);
    }

} catch (Exception e) {
    e.printStackTrace();
} finally {
    try {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conn != null) conn.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}

// 3️⃣ Update وروسته جدول ریفریش کول
// Update کوډ کې دا اضافه کړه:

    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Gold_analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gold_analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gold_analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gold_analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gold_analysis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cmbcustomer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtcarat;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtfinalweight;
    private javax.swing.JTextField txtgrossweight;
    private javax.swing.JTextField txtpricepurtola;
    private javax.swing.JLabel txtsearch;
    private javax.swing.JTextField txttotalprice;
    // End of variables declaration//GEN-END:variables
}
