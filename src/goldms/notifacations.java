package goldms;

import com.formdev.flatlaf.FlatLightLaf;
import jalalicalendar.JalaliCalendar.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
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
        styleTable();
        setLocationRelativeTo(this);
        jTable_notification.getTableHeader().setFont(new Font("B Nazanin", Font.BOLD, 20));
        jTable_notification.getTableHeader().setOpaque(false);
        jTable_notification.getTableHeader().setForeground(new Color(0, 0, 0));
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
    
    
    private void styleTable() {

    jTable_notification.setRowHeight(30);

    // حذف خطوط داخلی برای ظاهر مدرن
    jTable_notification.setShowGrid(false);
    jTable_notification.setIntercellSpacing(new java.awt.Dimension(0, 0));

    // رنگ هدر (بالای جدول)
    jTable_notification.getTableHeader().setBackground(new java.awt.Color(234, 220, 230));
    jTable_notification.getTableHeader().setForeground(java.awt.Color.WHITE);

    jTable_notification.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtstartdate = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txttypperations1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_notification = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtenddate = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
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

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("جستجوی عمومی:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 110, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 170, 3));
        jLabel2.setText("رودیدادهای سیستم");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("نوع رودیداد:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 100, -1, -1));

        txtstartdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------" }));
        jPanel1.add(txtstartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 300, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txttypperations1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txttypperations1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اضافه شده", "حذف شده", "ویرایش شده" }));
        txttypperations1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttypperations1ActionPerformed(evt);
            }
        });
        jPanel1.add(txttypperations1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 140, 300, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setText("جدول خالی است");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, -1, -1));

        jTable_notification.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_notification);
        if (jTable_notification.getColumnModel().getColumnCount() > 0) {
            jTable_notification.getColumnModel().getColumn(0).setHeaderValue("اسم کاربر");
            jTable_notification.getColumnModel().getColumn(1).setHeaderValue("عملیات");
            jTable_notification.getColumnModel().getColumn(2).setHeaderValue("پیام");
            jTable_notification.getColumnModel().getColumn(3).setHeaderValue("عنوان");
            jTable_notification.getColumnModel().getColumn(4).setHeaderValue("نوع هشدار");
            jTable_notification.getColumnModel().getColumn(5).setHeaderValue(" تاریخ");
            jTable_notification.getColumnModel().getColumn(6).setHeaderValue("وضیعت");
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 1330, 490));

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsearchKeyTyped(evt);
            }
        });
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 300, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("تا تاریخ:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        txtenddate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------" }));
        jPanel1.add(txtenddate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 300, 40));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ازتاریخ:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, 50, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new Exite().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txttypperations1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttypperations1ActionPerformed

        try {
            String selected = txttypperations1.getSelectedItem().toString().trim();
            String start = txtstartdate.getSelectedItem().toString().trim();
            String end = txtenddate.getSelectedItem().toString().trim();

            YearMonthDate date = new YearMonthDate(2026, 2, 19);
            for (int i = 0; i < 20; i++) {
                 txtstartdate.addItem(jalalicalendar.JalaliCalendar.gregorianToJalali(date).toString());
            }
            txtstartdate.addItem(jalalicalendar.JalaliCalendar.gregorianToJalali(date).toString());

            DefaultTableModel model = (DefaultTableModel) jTable_notification.getModel();
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
            } else {
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
        DefaultTableModel model = (DefaultTableModel) jTable_notification.getModel();
        String search = txtsearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        jTable_notification.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtsearchKeyTyped

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      try {
            String selected = txttypperations1.getSelectedItem().toString().trim();
            String start = txtstartdate.getSelectedItem().toString().trim();
            String end = txtenddate.getSelectedItem().toString().trim();

            YearMonthDate date = new YearMonthDate(2026, 2, 19);

            txtstartdate.addItem(jalalicalendar.JalaliCalendar.gregorianToJalali(date).toString());

            DefaultTableModel model = (DefaultTableModel) jTable_notification.getModel();
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
            } else {
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

    }//GEN-LAST:event_formWindowActivated

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
    private javax.swing.JTable jTable_notification;
    private javax.swing.JComboBox<String> txtenddate;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JComboBox<String> txtstartdate;
    private javax.swing.JComboBox<String> txttypperations1;
    // End of variables declaration//GEN-END:variables
}
