package goldms;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.ComponentOrientation;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Abdul Basit Niazi
 */
public class Systme_logs extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public Systme_logs() {
        initComponents();
        getConnection();
        formSetting();
        setLocationRelativeTo(this);
     //   SetHeader();

    }
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public Class<?> getColumnClass(int i) {
            switch (i) {
                case 0:
                    return String.class;
                case 1:
                    return String.class;

                case 2:
                    return String.class;
                case 3:
                    return Date.class;
                case 4:
                    return Integer.class;
                case 5:
                    return ImageIcon.class;
                default:
                    return Object.class;

            }
        }
    };
//             
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

    private void SetHeader() {
        model.addColumn("Fullname");
        model.addColumn("Message");
        model.addColumn("title");
        model.addColumn("create");
        model.addColumn("ID");
        model.addColumn("Picture");
        jTable1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtsearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nodate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsearch.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtsearch.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtsearchFocusGained(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsearchKeyTyped(evt);
            }
        });
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 390, 40));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 170, 3));
        jLabel2.setText("وضیعت سیستم");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, -1, -1));

        nodate.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        nodate.setText("جدول خالی است");
        jPanel1.add(nodate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "اسم کاربر", "پیام", "عنوان", "تاریخ", "آی دی"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(80);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1100, 430));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("نوعیت کاربری:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 180, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsearchFocusGained

    }//GEN-LAST:event_txtsearchFocusGained

    private void txtsearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyTyped
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String search = txtsearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

    }//GEN-LAST:event_txtsearchKeyTyped

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new Exite().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

//        //select table code
        if (conn != null) {
            DefaultTableModel mode=(DefaultTableModel) jTable1.getModel();
            
            try {
                ps = conn.prepareStatement("select Employee.Fullname,Systemlogs.Notification_id,Systemlogs.Employee_id,Systemlogs.Title,Systemlogs.Message,Systemlogs.is_read,Systemlogs.Created_at from Systemlogs LEFT JOIN Employee ON Employee.Employee_id=Systemlogs.Employee_id");
                rs = ps.executeQuery();
                while (rs.next()) {

                    mode.addRow(new Object[]{
                        rs.getString("Fullname"),
                        rs.getString("Message"),
                        rs.getString("Title"),
                        rs.getString("Created_at"),
                        rs.getString("Notification_id"),
                      
                    });
                    {

                    }
                }
                mode.fireTableDataChanged();
                if (mode.getRowCount() == 0) {
                    nodate.setVisible(true);

                } else {
                    nodate.setVisible(false);
                }

                //mode.addRow(new Object[]{"جدول خالی است"});
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

//
//// این کو عکس کارمند راهم نمایش میدهد اما به کندی
//        try {
//            ps = conn.prepareStatement("select Employee.Fullname,Employee.Profile_picture,Systemlogs.Notification_id,Systemlogs.Employee_id,Systemlogs.Title,Systemlogs.Message,Systemlogs.is_read,Systemlogs.Created_at from Systemlogs LEFT JOIN Employee ON Employee.Employee_id=Systemlogs.Employee_id");
//            rs = ps.executeQuery();
////            javax.swing.ImageIcon@6ef8ff5b
//            Object[] data = new Object[6];
//
//            while (rs.next()) {
//
//                data[0] = rs.getString("Fullname");
//
//                data[1] = rs.getString("Message");
//
//                data[2] = rs.getString("Title");
//
//                data[3] = rs.getDate("Created_at");
//
//                data[4] = rs.getInt("Notification_id");
//
//                Image img = new ImageIcon(rs.getBytes("Profile_picture")).getImage();
//                img = img.getScaledInstance(100, 100, Image.SCALE_FAST);
//                data[5] = new ImageIcon(img);
//                model.addRow(data);
//
//            }
//            model.fireTableDataChanged();
//            conn.close();
//            ps.close();
//            rs.close();
//            if (model.getRowCount() == 0) {
//                nodate.setVisible(true);
//
//            } else {
//                nodate.setVisible(false);
//            }
//            jTable1.setModel(model);
//            jTable1.setRowHeight(100);
//            jTable1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//
//        }


    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        GOLDMS dm = new GOLDMS();
        dm.form();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Systme_logs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nodate;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
