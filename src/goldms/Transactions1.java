/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldms;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
        showmithqal.setVisible(false);
        txttotalafg.setVisible(false);
        txtweightafg.setVisible(false);
        txttotalafg.setVisible(false);

        txtcalc.setVisible(false);
        lblbarkafg.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jLabel22.setVisible(false);
        txttola.setVisible(false);
        jRadioButton2.setVisible(false);
        jRadioButton1.setVisible(false);
        loadCustomers();

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

    private void calculate() {
        try {

            if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
                return;
            }

            double distcarat = Double.parseDouble(txtsourceweight.getText());
            double sourcecarat = Double.parseDouble(txtsourcecarat.getText());
            double tolarate = Double.parseDouble(txtpricepurtola.getText());

            double international_carat = jRadioButton1.isSelected()
                    ? Double.parseDouble(jRadioButton1.getText())
                    : Double.parseDouble(jRadioButton2.getText());

            double findWeight = (distcarat * sourcecarat) / international_carat;
            txtweight.setText(String.format("%.4f", findWeight));

            double convert_to_tola = findWeight / 12.15;
            txttola.setText(String.format("%.4f", convert_to_tola));

            double final_money = convert_to_tola * tolarate;
            txttotalprice.setText(String.format("%.4f", final_money));

        } catch (NumberFormatException e) {
            txttotalprice.setText("");
        }
    }

    private void calculateBark() {
        try {
            // گرفتن وزن به گرام
            double gram = Double.parseDouble(txtweightafg.getText().trim());

            // قیمت فی مثقال
            double pricePerMathqal = Double.parseDouble(pricemithqal.getText().trim());

            // تبدیل گرام به مثقال (1 مثقال = 4.58 گرام)
            double mathqal = (gram / 4.58);

            // نمایش تعداد مثقال
            showmithqal.setText(String.format("%.4f", mathqal));

            // محاسبه قیمت نهایی
            double finalPrice = (mathqal * pricePerMathqal);

            // نمایش قیمت نهایی
            txttotalafg.setText(String.format("%.4f", finalPrice));

            txttotalafg.requestFocus();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "لطفاً مقدار عددی صحیح وارد کنید!");
        }
    }

    public void loadCustomers() {
        try {

            String sql = "SELECT  Fullname FROM Customers";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            jCom_ustomer.removeAllItems();

            while (rs.next()) {
                // موږ id او نوم دواړه ذخیره کوو
                jCom_ustomer.addItem(
                        rs.getString("Fullname")
                );
            }

            conn.close();
            ps.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double parseDoubleSafe(JTextField field) {
        if (field == null) {
            return 0.0;
        }

        String text = field.getText();

        if (text == null || text.trim().isEmpty()) {
            return 0.0;
        }

        try {
            return Double.parseDouble(text.trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        asset_form = new javax.swing.JComboBox<>();
        type_money = new javax.swing.JComboBox<>();
        lblmaqsad = new javax.swing.JLabel();
        lblayar = new javax.swing.JLabel();
        lbltola = new javax.swing.JLabel();
        lblpric = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtsourceweight = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txttola = new javax.swing.JLabel();
        lblmabda = new javax.swing.JLabel();
        txtsourcecarat = new javax.swing.JTextField();
        txtweight = new javax.swing.JTextField();
        txtpricepurtola = new javax.swing.JTextField();
        txttotalprice = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblbarkafg = new javax.swing.JLabel();
        txtcalc = new javax.swing.JLabel();
        lbltotalafg = new javax.swing.JLabel();
        pricemthqal = new javax.swing.JLabel();
        pricemithqal = new javax.swing.JTextField();
        txtweightafg = new javax.swing.JTextField();
        txttotalafg = new javax.swing.JTextField();
        showmithqal = new javax.swing.JTextField();
        txttola1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblweithkilo = new javax.swing.JLabel();
        lblusdtotal = new javax.swing.JLabel();
        lblkilorate = new javax.swing.JLabel();
        txtweightbykilo = new javax.swing.JTextField();
        txtpurkilo = new javax.swing.JTextField();
        txttotalusdsilver = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        type_txt = new javax.swing.JComboBox<>();
        Com_currency = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
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

        asset_form.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "پاسه", "برگ", "نقره" }));
        asset_form.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asset_formActionPerformed(evt);
            }
        });
        jPanel2.add(asset_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 420, 40));

        type_money.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "طلا", "نقره", "مس", "پلاتین" }));
        type_money.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_moneyActionPerformed(evt);
            }
        });
        jPanel2.add(type_money, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 250, 420, 40));

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
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, -1, -1));

        jRadioButton1.setBackground(new java.awt.Color(16, 23, 42));
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("23.88");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jRadioButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButton1KeyPressed(evt);
            }
        });
        jPanel2.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(16, 23, 42));
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("24");
        jPanel2.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, -1, -1));

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("عیار مقصد");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 210, -1));

        txttola.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txttola.setForeground(new java.awt.Color(255, 255, 255));
        txttola.setText("0");
        jPanel2.add(txttola, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, -1, -1));

        lblmabda.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblmabda.setForeground(new java.awt.Color(255, 255, 255));
        lblmabda.setText("وزن مبدا(گرام(");
        jPanel2.add(lblmabda, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 140, -1));

        txtsourcecarat.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtsourcecarat.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsourcecarat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsourcecaratActionPerformed(evt);
            }
        });
        jPanel2.add(txtsourcecarat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 350, 420, 40));

        txtweight.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtweight.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtweight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtweightActionPerformed(evt);
            }
        });
        jPanel2.add(txtweight, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 420, 40));

        txtpricepurtola.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtpricepurtola.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtpricepurtola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpricepurtolaActionPerformed(evt);
            }
        });
        txtpricepurtola.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpricepurtolaKeyPressed(evt);
            }
        });
        jPanel2.add(txtpricepurtola, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 440, 430, 40));

        txttotalprice.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txttotalprice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttotalprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalpriceActionPerformed(evt);
            }
        });
        jPanel2.add(txttotalprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, 420, 40));

        jPanel3.setBackground(new java.awt.Color(16, 23, 41));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblbarkafg.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblbarkafg.setForeground(new java.awt.Color(255, 255, 255));
        lblbarkafg.setText("وزن فزیکی(گرام)");
        jPanel3.add(lblbarkafg, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 5, 130, -1));

        txtcalc.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtcalc.setForeground(new java.awt.Color(255, 255, 255));
        txtcalc.setText("مقدارمحاسبه شده(مثقال(");
        jPanel3.add(txtcalc, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 95, 220, -1));

        lbltotalafg.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lbltotalafg.setForeground(new java.awt.Color(255, 255, 255));
        lbltotalafg.setText("مجموع پول(افغانی(");
        jPanel3.add(lbltotalafg, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 95, 190, -1));

        pricemthqal.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        pricemthqal.setForeground(new java.awt.Color(255, 255, 255));
        pricemthqal.setText("نرخ مثقال(افغانی)");
        jPanel3.add(pricemthqal, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 5, 140, -1));

        pricemithqal.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        pricemithqal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pricemithqal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricemithqalActionPerformed(evt);
            }
        });
        pricemithqal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pricemithqalKeyPressed(evt);
            }
        });
        jPanel3.add(pricemithqal, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 420, 40));

        txtweightafg.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtweightafg.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtweightafg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtweightafgActionPerformed(evt);
            }
        });
        txtweightafg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtweightafgKeyPressed(evt);
            }
        });
        jPanel3.add(txtweightafg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 420, 40));

        txttotalafg.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txttotalafg.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttotalafg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalafgActionPerformed(evt);
            }
        });
        jPanel3.add(txttotalafg, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 420, 40));

        showmithqal.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        showmithqal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        showmithqal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showmithqalActionPerformed(evt);
            }
        });
        jPanel3.add(showmithqal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 420, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 1000, 190));

        txttola1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txttola1.setForeground(new java.awt.Color(255, 255, 255));
        txttola1.setText("وزن به توله");
        jPanel2.add(txttola1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, -1, -1));

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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtweightbykilo, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblweithkilo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtpurkilo, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblkilorate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(550, 550, 550)
                        .addComponent(txttotalusdsilver, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(820, 820, 820)
                        .addComponent(lblusdtotal)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblkilorate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblweithkilo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtweightbykilo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpurkilo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(lblusdtotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttotalusdsilver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 490, 990, 200));

        jButton5.setBackground(new java.awt.Color(30, 41, 59));
        jButton5.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_save_34px_1.png"))); // NOI18N
        jButton5.setText("ثبت");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 620, 160, 40));

        jButton6.setBackground(new java.awt.Color(30, 41, 59));
        jButton6.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_refresh_34px_1.png"))); // NOI18N
        jButton6.setText("ویرایش");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 620, 160, 40));

        jButton1.setBackground(new java.awt.Color(30, 41, 59));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_icon/icons8_delete_trash_34px_1.png"))); // NOI18N
        jButton1.setText("حذف");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, 160, 40));

        type_txt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "خرید", "فروش" }));
        jPanel2.add(type_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 420, 40));

        Com_currency.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "usd", "afg" }));
        jPanel2.add(Com_currency, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 80, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        //max id
        try {
            getConnection();
            ps = conn.prepareStatement("select max(Transaction_id)+1 from Transactions");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtID.setText(rs.getString("max(Transaction_id)+1"));
            }
            conn.close();
        } catch (Exception e) {

        }
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
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtweightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtweightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtweightActionPerformed

    private void txtpricepurtolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpricepurtolaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpricepurtolaActionPerformed

    private void txtsourceweightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsourceweightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsourceweightActionPerformed

    private void txtsourcecaratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsourcecaratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsourcecaratActionPerformed

    private void type_moneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_moneyActionPerformed
        String gold = type_money.getSelectedItem().toString().trim();
        if (gold.equals("نقره")) {
            asset_form.setVisible(false);
            txtsourceweight.setVisible(false);
            typeofgold.setVisible(false);
            txtweight.setVisible(false);
            txtpricepurtola.setVisible(false);
            txttotalprice.setVisible(false);
            txtsourcecarat.setVisible(false);
            lblayar.setVisible(false);
            lblmabda.setVisible(false);
            lblmaqsad.setVisible(false);
            lblpric.setVisible(false);
            lbltola.setVisible(false);
            jPanel4.setVisible(true);
            jPanel3.setVisible(false);
            jLabel22.setVisible(false);
            txttola.setVisible(false);
            txttola1.setVisible(false);

        } else {
            asset_form.setVisible(true);
            jPanel4.setVisible(false);
            jPanel3.setVisible(false);
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
    }//GEN-LAST:event_type_moneyActionPerformed

    private void txttotalpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalpriceActionPerformed

    private void asset_formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asset_formActionPerformed

        String gold = asset_form.getSelectedItem().toString().trim();
        if (gold.equals("برگ")) {
            txtsourceweight.setText("");
            txtpricepurtola.setText("");
            txtweight.setText("");
            txttotalprice.setText("");
            txtsourcecarat.setText("");

            txtsourceweight.setVisible(false);
//            typeofgold.setVisible(false);
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
            jRadioButton1.setVisible(false);
            jRadioButton2.setVisible(false);
            lbltotalafg.setVisible(true);
            pricemthqal.setVisible(true);
            showmithqal.setVisible(true);
            txttotalafg.setVisible(true);
            txtweightafg.setVisible(true);
            txttotalafg.setVisible(true);
            txtcalc.setVisible(true);
            lblbarkafg.setVisible(true);
            jLabel22.setVisible(false);
            txttola.setVisible(false);
            txttola1.setVisible(false);

//            int x = txtsourceweight.getX();
//            int y = txtsourceweight.getY();
//
//            jPanel3.setBounds(x, y, jPanel3.getWidth(), jPanel3.getHeight());
            jPanel3.setVisible(true);

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
            jLabel22.setVisible(true);
            txttola.setVisible(true);
            txttola1.setVisible(true);
            jRadioButton1.setVisible(true);
            jRadioButton2.setVisible(true);
        }
    }//GEN-LAST:event_asset_formActionPerformed

    private void txtweightbykiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtweightbykiloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtweightbykiloActionPerformed

    private void txtpurkiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpurkiloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpurkiloActionPerformed

    private void txttotalusdsilverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalusdsilverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalusdsilverActionPerformed

    private void txtpricepurtolaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpricepurtolaKeyPressed
        txtpricepurtola.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calculate();
            }
        });


    }//GEN-LAST:event_txtpricepurtolaKeyPressed

    private void pricemithqalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricemithqalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pricemithqalActionPerformed

    private void pricemithqalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pricemithqalKeyPressed

        if (evt.getKeyCode() == 10) {

            //            try {
            //                //عیار مقصد
            //                double sourceweight = Double.parseDouble(txtsourceweight.getText());
            //                //وزن
            //                double weight = Double.parseDouble(txtweight.getText());
            //                //عیارمبدا
            //                double sourcecarat = Double.parseDouble(txtsourcecarat.getText());
            //                //قیمت طوله
            //                double pricetola = Double.parseDouble(txtpricepurtola.getText());
            ////        تبدیل به عیار مبدا  وزن
            //                double carat_to_weight = weight * sourceweight / sourcecarat;
            //                //تبدیل به توله
            //                double convert_to_tola = sourceweight / 12.15;
            //                //قیمت نهایی
            //                double final_tola = convert_to_tola * pricetola;
            //
            //                txttotalprice.setText(String.valueOf(final_tola));
            try {
                //عیار مقصد
                double masqalweight = Double.parseDouble(txtweightafg.getText());
                //وزن
                double price = Double.parseDouble(showmithqal.getText());
                //عیارمبدا
                double total = Double.parseDouble(pricemithqal.getText());
                //قیمت طوله
                double gram_to_masqal = masqalweight / 4.58;
                double total_money = price * total;

                txttotalafg.setText(String.valueOf(total_money));
                txttotalafg.requestFocus();

            } catch (Exception e) {
                txttotalafg.setText("");
            }
        }
    }//GEN-LAST:event_pricemithqalKeyPressed

    private void txtweightafgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtweightafgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtweightafgActionPerformed

    private void txttotalafgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalafgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalafgActionPerformed

    private void showmithqalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showmithqalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showmithqalActionPerformed

    private void txtweightafgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtweightafgKeyPressed
        showmithqal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calculateBark();
            }
        });
        txttotalafg.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calculateBark();
            }
        });
    }//GEN-LAST:event_txtweightafgKeyPressed

    private void jRadioButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton1KeyPressed
        txtweight.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calculate();
            }
        });
    }//GEN-LAST:event_jRadioButton1KeyPressed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        txtweight.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calculate();
            }
        });
    }//GEN-LAST:event_jRadioButton1MouseClicked
    String assetForm = "";
    String type_txts = "";
    String type_moneys = "";
    String txt_total = "";
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {

            getConnection();

            // =========================
            // ComboBox Safe Read
            // =========================
            txt_total = txtpricepurtola.getText();
            type_txts = (type_txt.getSelectedItem() == null) ? "" : type_txt.getSelectedItem().toString().trim();

            assetForm = (asset_form.getSelectedItem() == null) ? "" : asset_form.getSelectedItem().toString().trim();
            type_moneys = (type_money.getSelectedItem() == null) ? "" : type_money.getSelectedItem().toString().trim();

            String customerName = (jCom_ustomer.getSelectedItem() == null) ? "" : jCom_ustomer.getSelectedItem().toString().trim();

            if (type_txts.isEmpty() || assetForm.isEmpty() || customerName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "لطفاً ټول ضروري معلومات داخل کړئ!");
                return;
            }  

            double usdOut = 0, usdIn = 0;
            double afgOut = 0, afgIn = 0;
            double goldOut = 0, goldIn = 0;
            double silverOut = 0, silverIn = 0;
            if (type_txts.equals("خرید")) {
                type_txts = "buy";

                if (assetForm.equals("پاسه")) {
                    usdOut = Double.parseDouble(txt_total);
                    usdIn = 0;
                }
            } else {
                type_txts = "sale";
                afgOut = Double.parseDouble(txt_total);
            }
            if (type_moneys.equals("طلا")) {
                type_moneys = "gold";
                if (assetForm.equals("پاسه")) {
                    usdIn = Double.parseDouble(txt_total);
                } else {
                    afgIn = Double.parseDouble(txt_total);
                }

            } else {
                type_moneys = "silver";

            }
            // =========================
            // Find Customer ID
            // =========================
            int customerId;

            ps = conn.prepareStatement(
                    "SELECT Customers_id FROM Customers WHERE Fullname=?");
            ps.setString(1, customerName);
            rs = ps.executeQuery();

            if (rs.next()) {
                customerId = rs.getInt("Customers_id");
            } else {
                JOptionPane.showMessageDialog(this, "مشتری پیدا نشد!");
                return;
            }

            rs.close();
            ps.close();

            // =========================
            // Safe TextField Reading
            // =========================
            double weight = parseDoubleSafe(txtsourceweight);
            double sourceCarat = parseDoubleSafe(txtsourcecarat);
            double goldRate = parseDoubleSafe(txtpricepurtola);
            double totalPrice = parseDoubleSafe(txttotalprice);

            String sql = "INSERT INTO Transactions ("
                    + "Transaction_id,Customers_id, Type_txt, Type_money, asset_form, Currency, Date,"
                    + "Weight, Source_carat, Gold_rate, Gold_amount,"
                    + "USD_in, USD_out, AFG_in, AFG_out,"
                    + "Gold_in, Gold_out, Silver_in, Silver_out, status"
                    + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtID.getText()));
            ps.setInt(2, customerId);
            ps.setString(3, type_txts);
            ps.setString(4, type_moneys);
            ps.setString(5, assetForm);

            ps.setString(6, Com_currency.getSelectedItem().toString().trim());

            ps.setString(7, new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));

            ps.setDouble(8, weight);
            ps.setDouble(9, sourceCarat);
            ps.setDouble(10, goldRate);
            ps.setDouble(11, totalPrice);

            ps.setDouble(12, usdIn);
            ps.setDouble(13, usdOut);
            ps.setDouble(14, afgIn);
            ps.setDouble(15, afgOut);

            ps.setDouble(16, goldIn);
            ps.setDouble(17, goldOut);
            ps.setDouble(18, silverIn);
            ps.setDouble(19, silverOut);

            ps.setString(20, "PENDING");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "✔ معامله ثبت شوه!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       try {
           
       
           getConnection();

          if (txtID.getText().trim().isEmpty()) {
               JOptionPane.showMessageDialog(this, "Transaction ID ضروری است!");
              return;
           }

          int transactionId = Integer.parseInt(txtID.getText().trim());

//            // =========================
//            // Combo Values
//            // =========================
         String uiType = (type_txt.getSelectedItem() == null) ? ""
                   : type_txt.getSelectedItem().toString().trim();

          String assetForm = (asset_form.getSelectedItem() == null) ? ""
                   : asset_form.getSelectedItem().toString().trim();

           if (uiType.isEmpty() || assetForm.isEmpty()) {
               JOptionPane.showMessageDialog(this, "لطفاً معلومات کامل انتخاب کنید!");
              return;
          }

           String typeTxt = uiType.equals("خرید") ? "buy" : "sale";
         String typeMoney = "gold";
         
            // =========================
         // Safe TextFields
          // =========================
           double weight = parseDoubleSafe(txtsourceweight);
          double sourceCarat = parseDoubleSafe(txtsourcecarat);
           double goldRate = parseDoubleSafe(txtpricepurtola);
            double totalPrice = parseDoubleSafe(txttotalprice);
//
//            // =========================
//            // Default Accounting
//            // =========================
          double usdIn = 0, usdOut = 0;
            double afgIn = 0, afgOut = 0;
          double goldIn = 0, goldOut = 0;
           double silverIn = 0, silverOut = 0;
//
//            // Stock movement
           if (typeTxt.equals("buy")) {
               goldIn = weight;
            } else {
                goldOut = weight;
            }

            // Currency Logic
            if (assetForm.equals("طلا پاسه")) {

                if (typeTxt.equals("buy")) {
                    usdOut = totalPrice;
                } else {
                    usdIn = totalPrice;
                }

            } else if (assetForm.equals("طلا برگ")) {

                if (typeTxt.equals("buy")) {
                    afgOut = totalPrice;
                } else {
                    afgIn = totalPrice;
                }
            }

            String currency = assetForm.equals("طلا پاسه") ? "USD" : "AFG";

            // =========================
            // UPDATE Query
            // =========================
            String sql = "UPDATE Transactions SET "
                    + "Type_txt=?, "
                    + "Type_money=?, "
                    + "asset_form=?, "
                    + "Currency=?, "
                    + "Weight=?, "
                    + "Source_carat=?, "
                    + "Gold_rate=?, "
                    + "Gold_amount=?, "
                    + "USD_in=?, "
                    + "USD_out=?, "
                    + "AFG_in=?, "
                    + "AFG_out=?, "
                    + "Gold_in=?, "
                    + "Gold_out=?, "
                    + "Silver_in=?, "
                    + "Silver_out=? "
                    + "WHERE Transaction_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, typeTxt);
            ps.setString(2, typeMoney);
            ps.setString(3, assetForm);
            ps.setString(4, currency);

            ps.setDouble(5, weight);
            ps.setDouble(6, sourceCarat);
            ps.setDouble(7, goldRate);
            ps.setDouble(8, totalPrice);

            ps.setDouble(9, usdIn);
            ps.setDouble(10, usdOut);
            ps.setDouble(11, afgIn);
            ps.setDouble(12, afgOut);

            ps.setDouble(13, goldIn);
            ps.setDouble(14, goldOut);
            ps.setDouble(15, silverIn);
            ps.setDouble(16, silverOut);

            ps.setInt(17, transactionId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "✔ معامله په بریالیتوب Update شوه!");
            } else {
                JOptionPane.showMessageDialog(this, "Update ناکام شو!");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            getConnection();

            if (txtID.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Transaction ID ضروری است!");
                return;
            }

            int transactionId = Integer.parseInt(txtID.getText().trim());

            String sql = "UPDATE Transactions SET "
                    + "is_deleted = 1, "
                    + "is_canceled = 1, "
                    + "status = 'REJECTED', "
                    + "canceled_at = datetime('now'), "
                    + "canceled_reason = ? "
                    + "WHERE Transaction_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "Deleted by user");
            ps.setInt(2, transactionId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "✔ معامله په بریالیتوب Cancel شوه!");
            } else {
                JOptionPane.showMessageDialog(this, "Delete ناکام شو!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
int posX, posY;
    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
    posX=evt.getX();
        posY=evt.getY();

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
        GOLDMS.form();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Transactions1().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Com_currency;
    private javax.swing.JComboBox<String> asset_form;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jCom_ustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JTextField pricemithqal;
    private javax.swing.JLabel pricemthqal;
    private javax.swing.JTextField showmithqal;
    private javax.swing.JTextField txtID;
    private javax.swing.JLabel txtcalc;
    private javax.swing.JTextField txtpricepurtola;
    private javax.swing.JTextField txtpurkilo;
    private javax.swing.JTextField txtsourcecarat;
    private javax.swing.JTextField txtsourceweight;
    private javax.swing.JLabel txttola;
    private javax.swing.JLabel txttola1;
    private javax.swing.JTextField txttotalafg;
    private javax.swing.JTextField txttotalprice;
    private javax.swing.JTextField txttotalusdsilver;
    private javax.swing.JTextField txtweight;
    private javax.swing.JTextField txtweightafg;
    private javax.swing.JTextField txtweightbykilo;
    private javax.swing.JComboBox<String> type_money;
    private javax.swing.JComboBox<String> type_txt;
    private javax.swing.JLabel typeofgold;
    // End of variables declaration//GEN-END:variables
}
