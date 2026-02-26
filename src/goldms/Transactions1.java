/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.awt.Image;
import java.sql.*;
import static java.util.Arrays.fill;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Transactions1 extends javax.swing.JFrame {

    /**
     * Creates new form Customers
     */
    public Transactions1() {
        initComponents();
        getConnection();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ButtonGroup bg = new ButtonGroup();
        bg.add(jRadioButton1);

        bg.add(jRadioButton2);

        lbltotalafg.setVisible(false);
        pricemthqal.setVisible(false);
        txtpricemathqal.setVisible(false);
        txttotalafg.setVisible(false);
        txtweightafg.setVisible(false);
        txtsilvergram.setVisible(false);

        txtcalc.setVisible(false);
        lblbarkafg.setVisible(false);
     

    }
    private int panelX = 510;
    private int panelY = 550;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCom_ustomer = new javax.swing.JComboBox<>();
        typeofgold = new javax.swing.JLabel();
        Com_Type_gold = new javax.swing.JComboBox<>();
        Com_type_thing = new javax.swing.JComboBox<>();
        lblmaqsad = new javax.swing.JLabel();
        lblayar = new javax.swing.JLabel();
        lbltola = new javax.swing.JLabel();
        lblpric = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Com_txt = new javax.swing.JComboBox<>();
        txtsourceweight = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        lblmabda = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblbarkafg = new javax.swing.JLabel();
        txtweightafg = new javax.swing.JTextField();
        txtcalc = new javax.swing.JLabel();
        txtsilvergram = new javax.swing.JTextField();
        txttotalafg = new javax.swing.JTextField();
        lbltotalafg = new javax.swing.JLabel();
        txtpricemathqal = new javax.swing.JTextField();
        pricemthqal = new javax.swing.JLabel();
        txtweight = new javax.swing.JTextField();
        txtsourcecarat = new javax.swing.JTextField();
        txtpricepurtola = new javax.swing.JTextField();
        txttotalprice = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblweithkilo = new javax.swing.JLabel();
        lblusdtotal = new javax.swing.JLabel();
        lblkilorate = new javax.swing.JLabel();
        txtweightbykilo = new javax.swing.JTextField();
        txtpurkilo = new javax.swing.JTextField();
        txttotalusdsilver = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(16, 23, 42));
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
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 830, 420, 40));

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
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 840, 420, 40));

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
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 840, 420, 40));

        jLabel3.setBackground(new java.awt.Color(255, 181, 3));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 181, 3));
        jLabel3.setText("جدول ثبت معاملات ");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("نام مشتری");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("آی دی معامله");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("نوع جنس");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 210, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_28px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jCom_ustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نام مشتری" }));
        jPanel2.add(jCom_ustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 420, 40));

        typeofgold.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        typeofgold.setForeground(new java.awt.Color(255, 255, 255));
        typeofgold.setText("نوع طلا");
        jPanel2.add(typeofgold, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, -1, -1));

        Com_Type_gold.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "پاسه", "برگ", "نقره" }));
        Com_Type_gold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Com_Type_goldActionPerformed(evt);
            }
        });
        jPanel2.add(Com_Type_gold, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 420, 40));

        Com_type_thing.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "طلا", "نقره", "مس", "پلاتین" }));
        Com_type_thing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Com_type_thingActionPerformed(evt);
            }
        });
        jPanel2.add(Com_type_thing, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 250, 420, 40));

        lblmaqsad.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblmaqsad.setForeground(new java.awt.Color(255, 255, 255));
        lblmaqsad.setText("وزن مقصد(گرام)");
        jPanel2.add(lblmaqsad, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, -1, 40));

        lblayar.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblayar.setForeground(new java.awt.Color(255, 255, 255));
        lblayar.setText("عیار مبدا:");
        jPanel2.add(lblayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 310, -1, -1));

        lbltola.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lbltola.setForeground(new java.awt.Color(255, 255, 255));
        lbltola.setText("قیمت فی طوله");
        jPanel2.add(lbltola, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 400, -1, -1));

        lblpric.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblpric.setForeground(new java.awt.Color(255, 255, 255));
        lblpric.setText("قیمت مجموعی");
        jPanel2.add(lblpric, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 410, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("نوع معامله");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        Com_txt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "خرید", "فروش" }));
        jPanel2.add(Com_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 420, 40));

        txtsourceweight.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtsourceweight.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsourceweight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsourceweightActionPerformed(evt);
            }
        });
        jPanel2.add(txtsourceweight, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 420, 40));

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("توضیحات");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, -1, -1));

        jRadioButton1.setBackground(new java.awt.Color(51, 51, 51));
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("23.88");
        jPanel2.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(51, 51, 51));
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("23.88");
        jPanel2.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, -1));

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("عیار مقصد");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 300, -1));

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("وزن به توله");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

        lblmabda.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblmabda.setForeground(new java.awt.Color(255, 255, 255));
        lblmabda.setText("وزن مبدا(گرام(");
        jPanel2.add(lblmabda, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 140, -1));

        jPanel3.setBackground(new java.awt.Color(16, 23, 41));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblbarkafg.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblbarkafg.setForeground(new java.awt.Color(255, 255, 255));
        lblbarkafg.setText("وزن فزیکی(گرام)");
        jPanel3.add(lblbarkafg, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 5, 130, -1));

        txtweightafg.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtweightafg.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtweightafg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtweightafgActionPerformed(evt);
            }
        });
        jPanel3.add(txtweightafg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 420, 40));

        txtcalc.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtcalc.setForeground(new java.awt.Color(255, 255, 255));
        txtcalc.setText("مقدارمحاسبه شده(مثقال(");
        jPanel3.add(txtcalc, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 95, 220, -1));

        txtsilvergram.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtsilvergram.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsilvergram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsilvergramActionPerformed(evt);
            }
        });
        jPanel3.add(txtsilvergram, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 420, 40));

        txttotalafg.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txttotalafg.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttotalafg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalafgActionPerformed(evt);
            }
        });
        jPanel3.add(txttotalafg, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 420, 40));

        lbltotalafg.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lbltotalafg.setForeground(new java.awt.Color(255, 255, 255));
        lbltotalafg.setText("مجموع پول(افغانی(");
        jPanel3.add(lbltotalafg, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 95, 190, -1));

        txtpricemathqal.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtpricemathqal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtpricemathqal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpricemathqalActionPerformed(evt);
            }
        });
        jPanel3.add(txtpricemathqal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 420, 40));

        pricemthqal.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        pricemthqal.setForeground(new java.awt.Color(255, 255, 255));
        pricemthqal.setText("نرخ مثقال(افغانی)");
        jPanel3.add(pricemthqal, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 5, 140, -1));

        txtweight.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtweight.setForeground(new java.awt.Color(255, 255, 255));
        txtweight.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtweight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtweightActionPerformed(evt);
            }
        });
        jPanel3.add(txtweight, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 44, 420, 40));

        txtsourcecarat.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtsourcecarat.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsourcecarat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsourcecaratActionPerformed(evt);
            }
        });
        jPanel3.add(txtsourcecarat, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 32, 420, 40));

        txtpricepurtola.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtpricepurtola.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtpricepurtola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpricepurtolaActionPerformed(evt);
            }
        });
        jPanel3.add(txtpricepurtola, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 134, 420, 40));

        txttotalprice.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txttotalprice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttotalprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalpriceActionPerformed(evt);
            }
        });
        jPanel3.add(txttotalprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 142, 420, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 1000, 190));

        jPanel4.setBackground(new java.awt.Color(16, 23, 41));

        lblweithkilo.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblweithkilo.setForeground(new java.awt.Color(255, 255, 255));
        lblweithkilo.setText("وزن فزیکی به کیلو");

        lblusdtotal.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblusdtotal.setForeground(new java.awt.Color(255, 255, 255));
        lblusdtotal.setText("مجموع پول(افغانی(");

        lblkilorate.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblkilorate.setForeground(new java.awt.Color(255, 255, 255));
        lblkilorate.setText("نرخ فی کیلو(دالر(");

        txtweightbykilo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtweightbykilo.setForeground(new java.awt.Color(255, 255, 255));
        txtweightbykilo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtweightbykilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtweightbykiloActionPerformed(evt);
            }
        });

        txtpurkilo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtpurkilo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtpurkilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpurkiloActionPerformed(evt);
            }
        });

        txttotalusdsilver.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txttotalusdsilver.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttotalusdsilver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalusdsilverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtweightbykilo, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(txtpurkilo, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txttotalusdsilver, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap(301, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(lblweithkilo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(390, 390, 390)
                            .addComponent(lblkilorate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblusdtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 10, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(txtweightbykilo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(txtpurkilo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(txttotalusdsilver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 3, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblweithkilo)
                        .addComponent(lblkilorate))
                    .addGap(60, 60, 60)
                    .addComponent(lblusdtotal)
                    .addGap(0, 67, Short.MAX_VALUE)))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1675, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1690, 780));

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

    private void txtIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusGained
        // TODO add your handling code here:

        //max id
/*
        try {
            ps = conn.prepareStatement("select max(Customers_id)+1 from Customers");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtID.setText(rs.getString("max(Customers_id)+1"));
            }
        } catch (Exception e) {

        }
         */
    }//GEN-LAST:event_txtIDFocusGained

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

        ///add new customer
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
                ps = conn.prepareStatement("INSERT INTO Customers(Customers_id,Fullname,NIC,Phone,Address)VALUES(?,?,?,?,?)");
                ps.setString(1, txtID.getText());
                ps.setString(2, txtfullname.getText());
                ps.setString(3, txtnic.getText());
                ps.setString(4, txtphone.getText());
                ps.setString(5, txtaddress.getText());
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(this, "Successfuly added new Customer");
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Exite().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtweightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtweightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtweightActionPerformed

    private void txtpricepurtolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpricepurtolaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpricepurtolaActionPerformed

    private void txttotalafgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalafgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalafgActionPerformed

    private void txtsourceweightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsourceweightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsourceweightActionPerformed

    private void txtsourcecaratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsourcecaratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsourcecaratActionPerformed

    private void Com_type_thingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Com_type_thingActionPerformed
        String gold = Com_type_thing.getSelectedItem().toString().trim();
        if (gold.equals("نقره")) {
            Com_Type_gold.setVisible(false);
            typeofgold.setVisible(false);
            txtweight.setVisible(false);
            txtpricepurtola.setVisible(false);

        } else {
            Com_Type_gold.setVisible(true);

            txtsourceweight.setVisible(true);
            typeofgold.setVisible(true);
            txtweight.setVisible(true);
            txtpricepurtola.setVisible(true);
            txtpricepurtola.setVisible(true);
            txttotalprice.setVisible(true);
            txtsourcecarat.setVisible(true);
            lblayar.setVisible(true);
            lblmabda.setVisible(true);
            lblmaqsad.setVisible(true);
            lblpric.setVisible(true);
            lbltola.setVisible(true);
            
        }
    }//GEN-LAST:event_Com_type_thingActionPerformed

    private void txttotalpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalpriceActionPerformed

    private void txtpricemathqalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpricemathqalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpricemathqalActionPerformed

    private void txtweightafgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtweightafgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtweightafgActionPerformed

    private void txtsilvergramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsilvergramActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsilvergramActionPerformed

    private void Com_Type_goldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Com_Type_goldActionPerformed

        String gold = Com_Type_gold.getSelectedItem().toString().trim();
        if (gold.equals("برگ")) {
            txtsourceweight.setVisible(false);
            typeofgold.setVisible(false);
            txtweight.setVisible(false);
            txtpricepurtola.setVisible(false);
            txtpricepurtola.setVisible(false);
            txttotalprice.setVisible(false);
            txtsourcecarat.setVisible(false);
            lblayar.setVisible(false);
            lblmabda.setVisible(false);
            lblmaqsad.setVisible(false);
            lblpric.setVisible(false);
            lbltola.setVisible(false);
            lbltotalafg.setVisible(true);
            pricemthqal.setVisible(true);
            txtpricemathqal.setVisible(true);
            txttotalafg.setVisible(true);
            txtweightafg.setVisible(true);
            txtsilvergram.setVisible(true);
            txtcalc.setVisible(true);
            lblbarkafg.setVisible(true);

//            int x = txtsourceweight.getX();
//            int y = txtsourceweight.getY();
//
//            jPanel3.setBounds(x, y, jPanel3.getWidth(), jPanel3.getHeight());
            jPanel5.setVisible(true);

        } else {
            txtsourceweight.setVisible(true);
            typeofgold.setVisible(true);
            txtweight.setVisible(true);
            txtpricepurtola.setVisible(true);
            txtpricepurtola.setVisible(true);
            txttotalprice.setVisible(true);
            txtsourcecarat.setVisible(true);
            lblayar.setVisible(true);
            lblmabda.setVisible(true);
            lblmaqsad.setVisible(true);
            lblpric.setVisible(true);
            lbltola.setVisible(true);
            jPanel3.setVisible(false);
        }
    }//GEN-LAST:event_Com_Type_goldActionPerformed

    private void txtweightbykiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtweightbykiloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtweightbykiloActionPerformed

    private void txtpurkiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpurkiloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpurkiloActionPerformed

    private void txttotalusdsilverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalusdsilverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalusdsilverActionPerformed

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
            java.util.logging.Logger.getLogger(Transactions1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transactions1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transactions1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transactions1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GOLDMS dm = new GOLDMS();
        dm.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transactions1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Com_Type_gold;
    private javax.swing.JComboBox<String> Com_txt;
    private javax.swing.JComboBox<String> Com_type_thing;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jCom_ustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblayar;
    private javax.swing.JLabel lblbarkafg;
    private javax.swing.JLabel lblkilorate;
    private javax.swing.JLabel lblmabda;
    private javax.swing.JLabel lblmaqsad;
    private javax.swing.JLabel lblpric;
    private javax.swing.JLabel lbltola;
    private javax.swing.JLabel lbltotalafg;
    private javax.swing.JLabel lblusdtotal;
    private javax.swing.JLabel lblweithkilo;
    private javax.swing.JLabel pricemthqal;
    private javax.swing.JTextField txtID;
    private javax.swing.JLabel txtcalc;
    private javax.swing.JTextField txtpricemathqal;
    private javax.swing.JTextField txtpricepurtola;
    private javax.swing.JTextField txtpurkilo;
    private javax.swing.JTextField txtsilvergram;
    private javax.swing.JTextField txtsourcecarat;
    private javax.swing.JTextField txtsourceweight;
    private javax.swing.JTextField txttotalafg;
    private javax.swing.JTextField txttotalprice;
    private javax.swing.JTextField txttotalusdsilver;
    private javax.swing.JTextField txtweight;
    private javax.swing.JTextField txtweightafg;
    private javax.swing.JTextField txtweightbykilo;
    private javax.swing.JLabel typeofgold;
    // End of variables declaration//GEN-END:variables
}
