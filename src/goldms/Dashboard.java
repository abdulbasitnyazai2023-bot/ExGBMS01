/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Locale;
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
        Transactions();
        setLocationRelativeTo(this);
        excnage();
        payed();
        recive();
        customer();
        cancelTransaction();
        buyGold();
        buySilver();
        saleGold();
        saleSilver();
        expense();
        treaAfa();
        treaGold();
        treaUsd();
        treaSilver();
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

    private void Transactions() {
        try {

            ps = conn.prepareStatement("SELECT COUNT(Transaction_id) FROM Transactions");

            rs = ps.executeQuery();
            if (rs.next()) {
                txttrans.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }

    // -------------end counting customer------------
    private void excnage() {
        try {

            ps = conn.prepareStatement("SELECT COUNT(rate_id) FROM exchange_rate");

            rs = ps.executeQuery();
            if (rs.next()) {

                txtexchange.setText(rs.getString(1));
                ps.close();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }

    private void payed() {
        try {

            ps = conn.prepareStatement("SELECT SUM(Payed) FROM Gold_ledger");

            rs = ps.executeQuery();
            if (rs.next()) {

                payed.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }

    private void recive() {
        try {

            ps = conn.prepareStatement("SELECT SUM(Amount) FROM Deposite_payment");

            rs = ps.executeQuery();
            if (rs.next()) {
                txtrecieve.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }

    private void customer() {
        try {

            ps = conn.prepareStatement("SELECT COUNT(Customers_id) FROM Customers");

            rs = ps.executeQuery();
            if (rs.next()) {
                txtcust.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }

    private void cancelTransaction() {
        try {

            ps = conn.prepareStatement("SELECT COUNT(C_transaction_id) FROM Canceled_Transaction");

            rs = ps.executeQuery();
            if (rs.next()) {
                txtcancel.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }

    private void buySilver() {
        try {

            ps = conn.prepareStatement("SELECT SUM(Recived) FROM Silver_ledger");

            rs = ps.executeQuery();
            if (rs.next()) {
                txtbuysilver.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }

    private void saleSilver() {
        try {

            ps = conn.prepareStatement("SELECT SUM(Payed) FROM Silver_ledger");

            rs = ps.executeQuery();
            if (rs.next()) {
                txtsalesilver.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }

    private void buyGold() {
        try {

            ps = conn.prepareStatement("SELECT SUM(Recived) FROM Gold_ledger");

            rs = ps.executeQuery();
            if (rs.next()) {
                txtbuygold.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }

    private void saleGold() {
        try {

            ps = conn.prepareStatement("SELECT SUM(Payed) FROM Gold_ledger");

            rs = ps.executeQuery();
            if (rs.next()) {
                txtsalegold.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }

   private void expense() {
        try {

            ps = conn.prepareStatement("SELECT SUM(Amount) FROM Expense WHERE Currency='usd'");
            rs = ps.executeQuery();

            if (rs.next()) {

                double total = rs.getDouble(1);

                // که NULL وي
                if (rs.wasNull()) {
                    txtexpen.setText("۰");
                    return;
                }

                // نمبر format کول (comma سره)
                java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);

                String formatted = nf.format(total);

                // انګلیسي عدد فارسی ته اړول
                formatted = convertToPersianNumbersexpense(formatted);

                txtexpen.setText(formatted+"افغانی ودالر");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private String convertToPersianNumbersexpense(String input) {

        char[] english = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] persian = {'۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹'};

        for (int i = 0; i < english.length; i++) {
            input = input.replace(english[i], persian[i]);
        }

        return input;
    }

    private void treaAfa() {
        try {

             ps = conn.prepareStatement("SELECT SUM(Balance) FROM Treasury WHERE Currency='afg'");
            rs = ps.executeQuery();

            if (rs.next()) {

                double total = rs.getDouble(1);

                // که NULL وي
                if (rs.wasNull()) {
                    txtafa.setText("۰");
                    return;
                }

                // نمبر format کول (comma سره)
                java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);

                String formatted = nf.format(total);

                // انګلیسي عدد فارسی ته اړول
                formatted = convertToPersianNumbers(formatted);

                txtafa.setText(formatted+"افغانی");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private String convertToPersianNumbers(String input) {

        char[] english = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] persian = {'۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹'};

        for (int i = 0; i < english.length; i++) {
            input = input.replace(english[i], persian[i]);
        }

        return input;
    }

    private void treaUsd() {
        try {

              ps = conn.prepareStatement("SELECT SUM(Balance) FROM Treasury WHERE Currency='usd'");
            rs = ps.executeQuery();

            if (rs.next()) {

                double total = rs.getDouble(1);

                // که NULL وي
                if (rs.wasNull()) {
                    txtusd.setText("۰");
                    return;
                }

                // نمبر format کول (comma سره)
                java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);

                String formatted = nf.format(total);

                // انګلیسي عدد فارسی ته اړول
                formatted = convertToPersianNumbersusd(formatted);

                txtusd.setText(formatted+"دالر");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private String convertToPersianNumbersusd(String input) {

        char[] english = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] persian = {'۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹'};

        for (int i = 0; i < english.length; i++) {
            input = input.replace(english[i], persian[i]);
        }

        return input;
    }

   private void treaSilver() {
        try {

              ps = conn.prepareStatement("SELECT SUM(Balance) FROM Treasury WHERE Currency='silver'");
            rs = ps.executeQuery();

            if (rs.next()) {

                double total = rs.getDouble(1);

                // که NULL وي
                if (rs.wasNull()) {
                    txtsilver.setText("۰");
                    return;
                }

                // نمبر format کول (comma سره)
                java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);

                String formatted = nf.format(total);

                // انګلیسي عدد فارسی ته اړول
                formatted = convertToPersianNumberssilver(formatted);

                txtsilver.setText(formatted+"گرام");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private String convertToPersianNumberssilver(String input) {

        char[] english = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] persian = {'۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹'};

        for (int i = 0; i < english.length; i++) {
            input = input.replace(english[i], persian[i]);
        }

        return input;
    }

 private void treaGold() {
        try {

            ps = conn.prepareStatement("SELECT SUM(Balance) FROM Treasury WHERE Currency='gold'");
            rs = ps.executeQuery();

            if (rs.next()) {

                double total = rs.getDouble(1);

                // که NULL وي
                if (rs.wasNull()) {
                    txtusd.setText("۰");
                    return;
                }

                // نمبر format کول (comma سره)
                java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);

                String formatted = nf.format(total);

                // انګلیسي عدد فارسی ته اړول
                formatted = convertToPersianNumbersgold(formatted);

                txtgold.setText(formatted+"گرام");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private String convertToPersianNumbersgold(String input) {

        char[] english = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] persian = {'۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹'};

        for (int i = 0; i < english.length; i++) {
            input = input.replace(english[i], persian[i]);
        }

        return input;
    }
    
 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtsilver = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtafa = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txtexpen = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtgold = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtusd = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtsalesilver = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtcancel = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtbuysilver = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtbuygold = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtsalegold = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtexchange = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txttrans = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        payed = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtrecieve = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtcust = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();

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

        txtsilver.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtsilver.setForeground(new java.awt.Color(255, 183, 51));
        txtsilver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtsilver.setText("0");
        txtsilver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel17.add(txtsilver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, 30));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_engagement_ring_60px.png"))); // NOI18N
        jPanel17.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 480, 280, 120));

        jPanel19.setBackground(new java.awt.Color(30, 41, 59));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("مجموع خزانه افغانی");
        jPanel19.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        txtafa.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtafa.setForeground(new java.awt.Color(255, 183, 51));
        txtafa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtafa.setText("0");
        txtafa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel19.add(txtafa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 150, 30));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/expense.png"))); // NOI18N
        jPanel19.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, 280, 120));

        jPanel20.setBackground(new java.awt.Color(30, 41, 59));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("مجموع مصارفات");
        jPanel20.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        txtexpen.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtexpen.setForeground(new java.awt.Color(255, 183, 51));
        txtexpen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtexpen.setText("0");
        txtexpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel20.add(txtexpen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 30));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_transfer.png"))); // NOI18N
        jPanel20.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 280, 120));

        jPanel16.setBackground(new java.awt.Color(30, 41, 59));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("مجموع خزانه طلا");
        jPanel16.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        txtgold.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtgold.setForeground(new java.awt.Color(255, 183, 51));
        txtgold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtgold.setText("0");
        txtgold.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel16.add(txtgold, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 30));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_gold_t.png"))); // NOI18N
        jPanel16.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 480, 280, 120));

        jPanel18.setBackground(new java.awt.Color(30, 41, 59));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("مجموع خزانه دالر");
        jPanel18.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 40));

        txtusd.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtusd.setForeground(new java.awt.Color(255, 183, 51));
        txtusd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtusd.setText("0");
        txtusd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel18.add(txtusd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 30));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_usd_txt.png"))); // NOI18N
        jPanel18.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, 280, 120));

        jPanel13.setBackground(new java.awt.Color(30, 41, 59));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("مجموع فروش نقره");
        jPanel13.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 40));

        txtsalesilver.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtsalesilver.setForeground(new java.awt.Color(255, 183, 51));
        txtsalesilver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtsalesilver.setText("0");
        txtsalesilver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel13.add(txtsalesilver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 30));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sale_silver.png"))); // NOI18N
        jPanel13.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 330, 280, 120));

        jPanel15.setBackground(new java.awt.Color(30, 41, 59));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText(" معاملات لغو شده");
        jPanel15.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        txtcancel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtcancel.setForeground(new java.awt.Color(255, 183, 51));
        txtcancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcancel.setText("0");
        txtcancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel15.add(txtcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 30));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_transfer.png"))); // NOI18N
        jPanel15.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 280, 120));

        jPanel14.setBackground(new java.awt.Color(30, 41, 59));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("مجموع خرید نقره");
        jPanel14.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        txtbuysilver.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtbuysilver.setForeground(new java.awt.Color(255, 183, 51));
        txtbuysilver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtbuysilver.setText("0");
        txtbuysilver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel14.add(txtbuysilver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 150, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buy_silver.png"))); // NOI18N
        jPanel14.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 280, 120));

        jPanel12.setBackground(new java.awt.Color(30, 41, 59));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("مجموع خرید طلا");
        jPanel12.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        txtbuygold.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtbuygold.setForeground(new java.awt.Color(255, 183, 51));
        txtbuygold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtbuygold.setText("0");
        txtbuygold.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel12.add(txtbuygold, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_buy_gold.png"))); // NOI18N
        jPanel12.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 330, 280, 120));

        jPanel11.setBackground(new java.awt.Color(30, 41, 59));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("مجموع فروش طلا");
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        txtsalegold.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtsalegold.setForeground(new java.awt.Color(255, 183, 51));
        txtsalegold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtsalegold.setText("0");
        txtsalegold.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel11.add(txtsalegold, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gold_sale.png"))); // NOI18N
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 330, 280, 120));

        jPanel10.setBackground(new java.awt.Color(30, 41, 59));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("مجموع تبادلات");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 40));

        txtexchange.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtexchange.setForeground(new java.awt.Color(255, 183, 51));
        txtexchange.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtexchange.setText("0");
        txtexchange.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel10.add(txtexchange, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_transfer.png"))); // NOI18N
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 280, 120));

        jPanel8.setBackground(new java.awt.Color(30, 41, 59));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("مجموع معاملات");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        txttrans.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txttrans.setForeground(new java.awt.Color(255, 183, 51));
        txttrans.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttrans.setText("0");
        txttrans.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel8.add(txttrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 150, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/all_txt.png"))); // NOI18N
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 280, 120));

        jPanel9.setBackground(new java.awt.Color(30, 41, 59));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("مجموع پرداخت ها");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 40));

        payed.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        payed.setForeground(new java.awt.Color(255, 183, 51));
        payed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        payed.setText("0");
        payed.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel9.add(payed, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/recept.png"))); // NOI18N
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 280, 120));

        jPanel7.setBackground(new java.awt.Color(30, 41, 59));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("مجموع سپرده ها");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        txtrecieve.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtrecieve.setForeground(new java.awt.Color(255, 183, 51));
        txtrecieve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtrecieve.setText("0");
        txtrecieve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(txtrecieve, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/payment.png"))); // NOI18N
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 60));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 180, 280, 120));

        jPanel4.setBackground(new java.awt.Color(30, 41, 59));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("مجموع مشتریان");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 40));

        txtcust.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        txtcust.setForeground(new java.awt.Color(255, 183, 51));
        txtcust.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcust.setText("0");
        txtcust.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(txtcust, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 30));

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
        jLabel2.setText("خوش آمدید");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_minus_28px.png"))); // NOI18N

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_notification_34px.png"))); // NOI18N

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_invite_24px.png"))); // NOI18N

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_user_shield_24px_1.png"))); // NOI18N

        jLabel54.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 181, 3));
        jLabel54.setText("فایده امروز");

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
                .addComponent(jLabel36)
                .addGap(31, 31, 31)
                .addComponent(jLabel50)
                .addGap(28, 28, 28)
                .addComponent(jLabel53)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel54)
                .addContainerGap(1451, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel54))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1910, 50));

        jPanel5.setBackground(new java.awt.Color(30, 41, 59));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Gold_logo.png"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 220, 110));

        jPanel29.setBackground(new java.awt.Color(16, 23, 41));

        jLabel48.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_capital_34px.png"))); // NOI18N
        jLabel48.setText("ثبت سرمایه");
        jLabel48.setFocusable(false);
        jLabel48.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel48)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 200, 50));

        jPanel32.setBackground(new java.awt.Color(16, 23, 41));

        jLabel51.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_alarm_clock_34px.png"))); // NOI18N
        jLabel51.setText("نمایش نوتیفکیشن ها");
        jLabel51.setFocusable(false);
        jLabel51.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 820, 200, 50));

        jPanel31.setBackground(new java.awt.Color(16, 23, 41));

        jLabel47.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_dollar_bitcoin_exchange_34px.png"))); // NOI18N
        jLabel47.setText("ثبت نرخ");
        jLabel47.setFocusable(false);
        jLabel47.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(jLabel47)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 760, 200, 50));

        jPanel26.setBackground(new java.awt.Color(16, 23, 41));

        jLabel49.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_member_34px.png"))); // NOI18N
        jLabel49.setText("ثبت کارمندان");
        jLabel49.setFocusable(false);
        jLabel49.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 200, 50));

        jPanel30.setBackground(new java.awt.Color(16, 23, 41));

        jLabel44.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_check_all_34px.png"))); // NOI18N
        jLabel44.setText("تایید درخواست ها");
        jLabel44.setFocusable(false);
        jLabel44.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 200, 50));

        jPanel27.setBackground(new java.awt.Color(16, 23, 41));

        jLabel52.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_server_shutdown_34px_1.png"))); // NOI18N
        jLabel52.setText("فعال سازی سیستم");
        jLabel52.setFocusable(false);
        jLabel52.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 880, 200, 50));

        jPanel25.setBackground(new java.awt.Color(16, 23, 41));

        jLabel43.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_settings_34px.png"))); // NOI18N
        jLabel43.setText("تنطیمات");
        jLabel43.setFocusable(false);
        jLabel43.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jLabel43)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 940, 200, 50));

        jPanel24.setBackground(new java.awt.Color(16, 23, 41));

        jLabel42.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_card_payment_34px.png"))); // NOI18N
        jLabel42.setText("ثبت مصارفات");
        jLabel42.setFocusable(false);
        jLabel42.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 200, 50));

        jPanel3.setBackground(new java.awt.Color(16, 23, 41));

        jLabel38.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_front_desk_34px.png"))); // NOI18N
        jLabel38.setText("ثبت سپرده");
        jLabel38.setFocusable(false);
        jLabel38.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 200, 50));

        jPanel2.setBackground(new java.awt.Color(16, 23, 41));

        jLabel37.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_undo_34px.png"))); // NOI18N
        jLabel37.setText("ثبت لغو معاملات");
        jLabel37.setFocusable(false);
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 200, 50));

        jPanel21.setBackground(new java.awt.Color(16, 23, 41));

        jLabel39.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_user_34px_1.png"))); // NOI18N
        jLabel39.setText("ثبت مشتریان");
        jLabel39.setFocusable(false);
        jLabel39.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 200, 50));

        jPanel23.setBackground(new java.awt.Color(16, 23, 41));

        jLabel41.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_transaction_34px.png"))); // NOI18N
        jLabel41.setText("ثبت معاملات");
        jLabel41.setFocusable(false);
        jLabel41.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jLabel41)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 200, 50));

        jPanel28.setBackground(new java.awt.Color(16, 23, 41));

        jLabel46.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_transfer_34px.png"))); // NOI18N
        jLabel46.setText("ثبت تبادله حساب ها");
        jLabel46.setFocusable(false);
        jLabel46.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel46)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 200, 50));

        jPanel22.setBackground(new java.awt.Color(16, 23, 41));

        jLabel40.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_blockchain_technology_34px.png"))); // NOI18N
        jLabel40.setText("نمایش خزانه");
        jLabel40.setFocusable(false);
        jLabel40.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 200, -1));

        jLabel45.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon/icons8_shutdown_34px.png"))); // NOI18N
        jLabel45.setText("خروج از سیستم");
        jLabel45.setFocusable(false);
        jLabel45.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel5.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 1000, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1690, 0, 220, 1040));

        jPanel33.setBackground(new java.awt.Color(30, 41, 59));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1690, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 940, 1690, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1910, 1040));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Exite().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        GOLDMS dm = new GOLDMS();
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel payed;
    private javax.swing.JLabel txtafa;
    private javax.swing.JLabel txtbuygold;
    private javax.swing.JLabel txtbuysilver;
    private javax.swing.JLabel txtcancel;
    private javax.swing.JLabel txtcust;
    private javax.swing.JLabel txtexchange;
    private javax.swing.JLabel txtexpen;
    private javax.swing.JLabel txtgold;
    private javax.swing.JLabel txtrecieve;
    private javax.swing.JLabel txtsalegold;
    private javax.swing.JLabel txtsalesilver;
    private javax.swing.JLabel txtsilver;
    private javax.swing.JLabel txttrans;
    private javax.swing.JLabel txtusd;
    // End of variables declaration//GEN-END:variables
}
