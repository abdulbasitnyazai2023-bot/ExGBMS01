/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import java.sql.*;
import javax.swing.*;




/**
 *
 * @author Abdul Basit Niazi
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public Dashboard() {
        initComponents();
        getConnection();
        //Transactions();
        setLocationRelativeTo(this);
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
    /*
    private void Transactions() {
        try {

            ps = conn.prepareStatement("SELECT COUNT(Transaction_id) FROM Transactions");

            rs = ps.executeQuery();
            if (rs.next()) {
               trans.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }
    */
    // -------------end counting customer------------

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        trans13 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        trans15 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        trans16 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        trans12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        trans14 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        trans9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        trans11 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        trans10 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        trans8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        trans7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        trans6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        trans4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        trans5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        trans3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        trans2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1910, 1070));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(16, 23, 42));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 42)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 183, 51));
        jLabel5.setText("بــه ســیستــم مـدیـریت طــــــلا فــــــــــروشی ذبــیــــــح الله بــــرهــــــــــــــــــــــــانی خـــــــــــــــــــــــــــــــــــــــــــوش آمـــــــــــــــــــــــــــــــــــــــــــــــــــدید!");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        jPanel17.setBackground(new java.awt.Color(30, 41, 59));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("مجموع خزانه نقره");
        jPanel17.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 40));

        trans13.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans13.setForeground(new java.awt.Color(255, 183, 51));
        trans13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans13.setText("0");
        trans13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel17.add(trans13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, 30));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_engagement_ring_60px.png"))); // NOI18N
        jPanel17.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 480, 280, 120));

        jPanel19.setBackground(new java.awt.Color(30, 41, 59));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("مجموع خزانه افغانی");
        jPanel19.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        trans15.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans15.setForeground(new java.awt.Color(255, 183, 51));
        trans15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans15.setText("0");
        trans15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel19.add(trans15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 150, 30));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/expense.png"))); // NOI18N
        jPanel19.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, 280, 120));

        jPanel20.setBackground(new java.awt.Color(30, 41, 59));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("مجموع مصارفات");
        jPanel20.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        trans16.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans16.setForeground(new java.awt.Color(255, 183, 51));
        trans16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans16.setText("0");
        trans16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel20.add(trans16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 30));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_transfer.png"))); // NOI18N
        jPanel20.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 280, 120));

        jPanel16.setBackground(new java.awt.Color(30, 41, 59));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("مجموع خزانه طلا");
        jPanel16.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        trans12.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans12.setForeground(new java.awt.Color(255, 183, 51));
        trans12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans12.setText("0");
        trans12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel16.add(trans12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 30));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_gold_t.png"))); // NOI18N
        jPanel16.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 480, 280, 120));

        jPanel18.setBackground(new java.awt.Color(30, 41, 59));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("مجموع خزانه دالر");
        jPanel18.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 40));

        trans14.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans14.setForeground(new java.awt.Color(255, 183, 51));
        trans14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans14.setText("0");
        trans14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel18.add(trans14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 30));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_usd_txt.png"))); // NOI18N
        jPanel18.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, 280, 120));

        jPanel13.setBackground(new java.awt.Color(30, 41, 59));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("مجموع فروش نقره");
        jPanel13.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 40));

        trans9.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans9.setForeground(new java.awt.Color(255, 183, 51));
        trans9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans9.setText("0");
        trans9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel13.add(trans9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 30));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sale_silver.png"))); // NOI18N
        jPanel13.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 330, 280, 120));

        jPanel15.setBackground(new java.awt.Color(30, 41, 59));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText(" معاملات لغو شده");
        jPanel15.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        trans11.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans11.setForeground(new java.awt.Color(255, 183, 51));
        trans11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans11.setText("0");
        trans11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel15.add(trans11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 30));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_transfer.png"))); // NOI18N
        jPanel15.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 280, 120));

        jPanel14.setBackground(new java.awt.Color(30, 41, 59));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("مجموع خرید نقره");
        jPanel14.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        trans10.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans10.setForeground(new java.awt.Color(255, 183, 51));
        trans10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans10.setText("0");
        trans10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel14.add(trans10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 150, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buy_silver.png"))); // NOI18N
        jPanel14.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 280, 120));

        jPanel12.setBackground(new java.awt.Color(30, 41, 59));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("مجموع خرید طلا");
        jPanel12.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        trans8.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans8.setForeground(new java.awt.Color(255, 183, 51));
        trans8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans8.setText("0");
        trans8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel12.add(trans8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_buy_gold.png"))); // NOI18N
        jPanel12.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 330, 280, 120));

        jPanel11.setBackground(new java.awt.Color(30, 41, 59));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("مجموع فروش طلا");
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        trans7.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans7.setForeground(new java.awt.Color(255, 183, 51));
        trans7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans7.setText("0");
        trans7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel11.add(trans7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gold_sale.png"))); // NOI18N
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 330, 280, 120));

        jPanel10.setBackground(new java.awt.Color(30, 41, 59));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("مجموع تبادلات");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 40));

        trans6.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans6.setForeground(new java.awt.Color(255, 183, 51));
        trans6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans6.setText("0");
        trans6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel10.add(trans6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_transfer.png"))); // NOI18N
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 280, 120));

        jPanel8.setBackground(new java.awt.Color(30, 41, 59));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("مجموع معاملات");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        trans4.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans4.setForeground(new java.awt.Color(255, 183, 51));
        trans4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans4.setText("0");
        trans4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel8.add(trans4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 150, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_txt.png"))); // NOI18N
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 280, 120));

        jPanel9.setBackground(new java.awt.Color(30, 41, 59));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("مجموع پرداخت ها");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 40));

        trans5.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans5.setForeground(new java.awt.Color(255, 183, 51));
        trans5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans5.setText("0");
        trans5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel9.add(trans5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/recept.png"))); // NOI18N
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 280, 120));

        jPanel7.setBackground(new java.awt.Color(30, 41, 59));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("مجموع سپرده ها");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        trans3.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans3.setForeground(new java.awt.Color(255, 183, 51));
        trans3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans3.setText("0");
        trans3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(trans3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/payment.png"))); // NOI18N
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 180, 280, 120));

        jPanel4.setBackground(new java.awt.Color(30, 41, 59));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("مجموع مشتریان");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 40));

        trans2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        trans2.setForeground(new java.awt.Color(255, 183, 51));
        trans2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans2.setText("0");
        trans2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(trans2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer.png"))); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 180, 280, 120));

        jPanel6.setBackground(new java.awt.Color(30, 41, 59));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 181, 3));
        jLabel2.setText("جناب \"ادمین\" خوش آمدید");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_minus_28px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(1615, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1910, 40));

        jPanel5.setBackground(new java.awt.Color(30, 41, 59));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Gold_logo.png"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 210, 120));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1690, 0, 220, 1070));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1910, 1070));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       new Exite().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    GOLDMS dm=new GOLDMS();
   dm.form();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel trans10;
    private javax.swing.JLabel trans11;
    private javax.swing.JLabel trans12;
    private javax.swing.JLabel trans13;
    private javax.swing.JLabel trans14;
    private javax.swing.JLabel trans15;
    private javax.swing.JLabel trans16;
    private javax.swing.JLabel trans2;
    private javax.swing.JLabel trans3;
    private javax.swing.JLabel trans4;
    private javax.swing.JLabel trans5;
    private javax.swing.JLabel trans6;
    private javax.swing.JLabel trans7;
    private javax.swing.JLabel trans8;
    private javax.swing.JLabel trans9;
    // End of variables declaration//GEN-END:variables
}
