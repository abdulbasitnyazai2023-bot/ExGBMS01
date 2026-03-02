package goldms;

import com.formdev.flatlaf.FlatLightLaf;
import jalalicalendar.JalaliCalendar.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Abdul Basit Niazi
 */
public class notifacations extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public notifacations() {
        initComponents();
        getConnection();
        formSetting();
        setLocationRelativeTo(this);
        jTable1.getTableHeader().setFont(new Font("B Nazanin", Font.BOLD, 20));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setForeground(new Color(0, 0, 0));

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtstartdate = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txttypperations1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtenddate = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
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

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("جستجوی عمومی:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 110, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 170, 3));
        jLabel2.setText("رودیدادهای سیستم");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("نوع رودیداد:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 110, -1, -1));

        txtstartdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------" }));
        jPanel1.add(txtstartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 300, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txttypperations1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txttypperations1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "همه", "اضافه شده", "حذف شده", "ویرایش شده" }));
        txttypperations1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttypperations1ActionPerformed(evt);
            }
        });
        jPanel1.add(txttypperations1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 150, 300, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setText("جدول خالی است");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "اسم کاربر", "عملیات", "پیام", "عنوان", "نوع هشدار", " تاریخ", "وضیعت"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("اسم کاربر");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("عملیات");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("پیام");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("عنوان");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("نوع هشدار");
            jTable1.getColumnModel().getColumn(5).setHeaderValue(" تاریخ");
            jTable1.getColumnModel().getColumn(6).setHeaderValue("وضیعت");
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 1320, 470));

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsearchKeyTyped(evt);
            }
        });
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 300, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("تا تاریخ:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, -1, -1));

        txtenddate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------" }));
        jPanel1.add(txtenddate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 300, 40));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ازتاریخ:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 110, 50, -1));

        jTextField1.setText("jTextField1");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 40, 220, -1));

        jTextField2.setText("jTextField1");
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 220, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txttypperations1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttypperations1ActionPerformed

        
        
        
        
        
        
        
        
        
        
        // مثال کامل برای JTable با فیلتر تاریخ و عملیات و نمایش جلالی

try {
    // آماده‌سازی مدل جدول
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // پاک کردن جدول

    // 1️⃣ محاسبه تاریخ ۱۰ روز قبل
    LocalDate today = LocalDate.now();
    LocalDate tenDaysAgo = today.minusDays(10);

    // تبدیل به YearMonthDate برای جلالی
    YearMonthDate date = new YearMonthDate(tenDaysAgo.getYear(), tenDaysAgo.getMonthValue(), tenDaysAgo.getDayOfMonth());
    String jalaliDate = jalalicalendar.JalaliCalendar.gregorianToJalali(date).toString();

    // 2️⃣ نمایش تاریخ جلالی در JTextField
    jTextField1.setText(jalaliDate);
    jTextField2.setText(jalaliDate);

    // 3️⃣ فیلتر نوع عملیات
    String selectedOperation = txttypperations1.getSelectedItem().toString().trim(); // INSERT, UPDATE, DELETE یا "همه"

    String sql;
    if (selectedOperation.equals("همه")) {
        sql = "SELECT * FROM notifications WHERE date(created_at) >= ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, tenDaysAgo.toString()); // فقط ۱۰ روز گذشته
    } else {
        sql = "SELECT * FROM notifications WHERE operation_type = ? AND date(created_at) >= ?";
        ps = conn.prepareStatement(sql);

        // تبدیل نام فارسی به انگلیسی
        switch (selectedOperation) {
            case "اضافه شده" 
                    :ps.setString(1, "INSERT");
            case "حذف شده" :ps.setString(1, "DELETE");
            case "ویرایش شده" : ps.setString(1, "UPDATE");
        }
        ps.setString(2, tenDaysAgo.toString());
    }

    // 4️⃣ اجرای کوئری
    rs = ps.executeQuery();
    DateTimeFormatter dbFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    while (rs.next()) {
        String createdAt = rs.getString("created_at");
        LocalDateTime dt = LocalDateTime.parse(createdAt, dbFormatter);

        // تبدیل به جلالی
        LocalDate localDate = dt.toLocalDate();
        YearMonthDate jalaliRowDate = new YearMonthDate(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
        String jalaliCreatedAt = jalalicalendar.JalaliCalendar.gregorianToJalali(jalaliRowDate).toString();

        // افزودن ردیف به JTable
        model.addRow(new Object[]{
            rs.getString("recipient_role"),
            rs.getString("operation_type"),
            rs.getString("message"),
            rs.getString("title"),
            rs.getString("severity"),
            jalaliCreatedAt,  // نمایش جلالی
            rs.getInt("is_read") == 0 ? "خوانده نشده" : "خوانده شده"
        });
    }

} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e.getMessage());
}
        
        
        
        
        
        try {
            String selected = txttypperations1.getSelectedItem().toString().trim();
            // پاک کردن آیتم‌های قبلی
            txtstartdate.removeAllItems();
            txtenddate.removeAllItems();

// گرفتن تاریخ امروز و 10 روز قبل
            LocalDate today = LocalDate.now();
            LocalDate tenDaysAgo = today.minusDays(10);

// تبدیل به YearMonthDate برای کتابخانه شما
            YearMonthDate date = new YearMonthDate(tenDaysAgo.getYear(), tenDaysAgo.getMonthValue(), tenDaysAgo.getDayOfMonth());

// تبدیل به جلالی و اضافه کردن به JComboBox
            String jalaliDate = jalalicalendar.JalaliCalendar.gregorianToJalali(date).toString();
            txtstartdate.addItem(jalaliDate);
            txtenddate.addItem(jalaliDate);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // پاکول

            System.out.println(selected);
            txtenddate.addItem(jalalicalendar.JalaliCalendar.gregorianToJalali(date).toString());
            // د INSERT لپاره دقیق filter
            String sql = "SELECT * FROM notifications WHERE operation_type = ?";
            ps = conn.prepareStatement(sql);
            if (selected.equals("اضافه شده")) {
                selected = "INSERT";
                ps.setString(1, selected);

            } else if (selected.equals("حذف شده")) {
                selected = "DELETE";
                ps.setString(1, selected);
            } else if (selected.equals("ویرایش شده")) {
                selected = "UPDATE";
                ps.setString(1, selected);
            }

            rs = ps.executeQuery();
//            String red="";
//           int read= rs.getInt("is_read");
//            if (read==1) {
//                red="خوانده نشده";
//            }
//            else{
//                red="خوانده شد";
//            }
            while (rs.next()) {
                model.addRow(new Object[]{
                    //                    rs.getString("table_name"),
                    rs.getString("recipient_role"),
                    rs.getString("operation_type"),
                    rs.getString("message"),
                    rs.getString("title"),
                    rs.getString("severity"),
                    rs.getString("created_at"),
                    rs.getString("is_read"),});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            String selected = txttypperations1.getSelectedItem().toString().trim();
            if (selected.equals("همه")) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0); // پاکول
                // د INSERT لپاره دقیق filter
                String sql = "SELECT * FROM notifications";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    model.addRow(new Object[]{
                        //                    rs.getString("table_name"),
                        rs.getString("recipient_role"),
                        rs.getString("operation_type"),
                        rs.getString("message"),
                        rs.getString("title"),
                        rs.getString("severity"),
                        rs.getString("created_at"),
                        rs.getString("is_read"),});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_txttypperations1ActionPerformed
    int posX, posY;
    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        this.setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void txtsearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyTyped
        //jTextField1.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String search = txtsearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtsearchKeyTyped

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            String selected = txttypperations1.getSelectedItem().toString().trim();
            String start = txtstartdate.getSelectedItem().toString().trim();
            String end = txtenddate.getSelectedItem().toString().trim();

            YearMonthDate date = new YearMonthDate(2026, 2, 19);

            txtstartdate.addItem(jalalicalendar.JalaliCalendar.gregorianToJalali(date).toString());

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // پاکول

            System.out.println(selected);
            txtenddate.addItem(jalalicalendar.JalaliCalendar.gregorianToJalali(date).toString());
            if (selected.equals("همه")) {

                // د INSERT لپاره دقیق filter
                String sql = "SELECT * FROM notifications";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    model.addRow(new Object[]{
                        //                    rs.getString("table_name"),
                        rs.getString("recipient_role"),
                        rs.getString("operation_type"),
                        rs.getString("message"),
                        rs.getString("title"),
                        rs.getString("severity"),
                        rs.getString("created_at"),
                        rs.getString("is_read"),});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened


    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        GOLDMS dm = new GOLDMS();
        dm.form();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new notifacations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox<String> txtenddate;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JComboBox<String> txtstartdate;
    private javax.swing.JComboBox<String> txttypperations1;
    // End of variables declaration//GEN-END:variables
}
