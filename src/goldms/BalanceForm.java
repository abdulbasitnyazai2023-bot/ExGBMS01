/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.Global.print;

/**
 *
 * @author DELL
 */
public class BalanceForm extends javax.swing.JFrame {

    /**
     * Creates new form Customers
     */
    private int customerId;

    // سازنده فرم که آی‌دی مشتری را می‌گیرد
    public BalanceForm(int id) {
        this.customerId = id;
        initComponents();
        getConnection();
        if (conn != null) {
            loadBalanceData();

        } else {
            System.out.println("نمایش بیلانس برای مشتری شماره: " + customerId);

        }
        // متدی برای خواندن اطلاعات از دیتابیس بر اساس ID
    }

    private void loadBalanceData() {
        // در اینجا کد اتصال به دیتابیس و نمایش بیلانس مشتری با آی‌دی customerId را بنویسید
        System.out.println("نمایش بیلانس برای مشتری شماره: " + customerId);
    }

    // Pagination
    int currentPage = 1;
    int rowsPerPage = 10;
    int totalPages = 0;
    // د ډیټابېس مسیر (Path)
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    void getConnection() {

        try {
            // SQLite Driver Load
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:./src/db/Golds-1.db");
            int offset = (currentPage - 1) * rowsPerPage;
            System.out.println("cont");

        } catch (ClassNotFoundException ex) {
            System.out.println("not found" + ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        silver = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblpage = new javax.swing.JLabel();
        txtname = new javax.swing.JLabel();
        usd = new javax.swing.JLabel();
        afg = new javax.swing.JLabel();
        gold = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(16, 23, 42));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtid.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtid.setForeground(new java.awt.Color(255, 255, 255));
        txtid.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtid.setText("نمبر تذکره مشتری");
        txtid.setToolTipText("");
        txtid.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 181, 3));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("_______________");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 380, 40));

        silver.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        silver.setForeground(new java.awt.Color(255, 255, 255));
        silver.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        silver.setText("نام کامل مشتری");
        silver.setToolTipText("");
        silver.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(silver, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblpage.setText("jLabel5");
        jPanel2.add(lblpage, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 730, -1, -1));

        txtname.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtname.setForeground(new java.awt.Color(255, 255, 255));
        txtname.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtname.setText("نام کامل مشتری");
        txtname.setToolTipText("");
        txtname.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        usd.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        usd.setForeground(new java.awt.Color(255, 255, 255));
        usd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        usd.setText("نام کامل مشتری");
        usd.setToolTipText("");
        usd.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(usd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, 40));

        afg.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        afg.setForeground(new java.awt.Color(255, 255, 255));
        afg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        afg.setText("نام کامل مشتری");
        afg.setToolTipText("");
        afg.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(afg, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, 40));

        gold.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        gold.setForeground(new java.awt.Color(255, 255, 255));
        gold.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gold.setText("نام کامل مشتری");
        gold.setToolTipText("");
        gold.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(gold, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 181, 3));
        jLabel4.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("نمایش بیلانس");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        try {

            String sql = "SELECT Fullname ,Customers_id USD_Balance, AF_Balance, Gold_Balance, Silver_Balance "
                    + "FROM v_CustomerBalance_Detailed WHERE Customers_id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, customerId);

            rs = ps.executeQuery();
            if (rs.next()) {
                double usdBalance = rs.getDouble("USD_Balance");
                double afBalance = rs.getDouble("AF_Balance");
                double goldBalance = rs.getDouble("Gold_Balance");
                double silverBalance = rs.getDouble("Silver_Balance");
                String fullname = rs.getString("Fullname");

                // مثال د JLabel یا JTextField ته نمایش
                usd.setText("بیلانس دالر: " + String.valueOf(usdBalance));
                afg.setText("بیلانس افغانی: " + String.valueOf(afBalance));
                gold.setText("بیلانس طلا: " + String.valueOf(goldBalance));
                silver.setText("بیلانس نقره: " + String.valueOf(silverBalance));
                txtname.setText("نام کامل مشتری: " + String.valueOf(fullname));
                txtid.setText("آی دی مشتری: " + String.valueOf(customerId));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading balance: " + ex.getMessage());
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

    }//GEN-LAST:event_formWindowActivated

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked


    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        getConnection();
//        PrinterJob printerJob = PrinterJob.getPrinterJob();
//        printerJob.setJobName("priten record");
//        printerJob.setPrintable(new Printable() {
//            @Override
//            public int print(Graphics grphcs, PageFormat pf, int pageIndex) throws PrinterException {
//                if (pageIndex > 0) {
//                    getConnection();
//                    return Printable.NO_SUCH_PAGE;
//
//                }
//                Graphics2D graphics2d = (Graphics2D) grphcs;
//                graphics2d.translate(pf.getImageableX() * 2, pf.getImageableY() * 2);
//                graphics2d.scale(0.5, 0.5);
//                jPanel2.paint(graphics2d);
//                return Printable.PAGE_EXISTS;
//
//            }
//        });
//
//        boolean returninRequest = printerJob.printDialog();
//        if (returninRequest) {
//            try {
//
//                printerJob.print();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(this, e.getMessage());
//            }
//        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel afg;
    private javax.swing.JLabel gold;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblpage;
    private javax.swing.JLabel silver;
    private javax.swing.JLabel txtid;
    private javax.swing.JLabel txtname;
    private javax.swing.JLabel usd;
    // End of variables declaration//GEN-END:variables
}
