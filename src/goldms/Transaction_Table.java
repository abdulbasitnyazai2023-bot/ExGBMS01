package goldms;

import java.awt.*;
import java.sql.*;

import javax.swing.*;

import javax.swing.event.*;

import javax.swing.table.*;

/**
 *
 * @author DELL
 */
public class Transaction_Table extends javax.swing.JFrame {

    /**
     * Creates new form Approval_Request
     */
    public Transaction_Table() {
        initComponents();
        getConnection();
        styleTable();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "null", "null"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("در خواست تاییدی معاملات");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1195, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(252, 252, 252))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
//

// 1. Table Model
DefaultTableModel model = new DefaultTableModel(
        new Object[]{
            "جواب به درخواست", "آی دی", "نوع معامله", "نوع پول", "تاریخ", "وزن",
            "قیمت فی گرام", "مجموع هرگرام", "عیار", "گرفت دالر", "پرداخت دالر",
            "گرفت افغانی", "پرداخت افغانی", "گرفت طلا", "پرداخت طلا",
            "گرفت نقره", "پرداخت نقره", "وضیعت"}, 0) {

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) return Boolean.class;
        return super.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 0;
    }
};

jTable1.setModel(model);


// 2. Load Data
try {
    getConnection();

    String sql = "SELECT Transaction_id, Type_txt, Type_money, Date, Weight,"
            + "Gold_rate,Gold_amount, Source_carat, USD_in,USD_out,AFG_in,AFG_out,"
            + "Gold_in,Gold_out,Silver_in,Silver_out,status FROM Transactions";

    ps = conn.prepareStatement(sql);
    rs = ps.executeQuery();

    model.setRowCount(0);

    while (rs.next()) {

        boolean isPending = "PENDING".equals(rs.getString("status"));

        Object[] row = {
            isPending,
            rs.getInt("Transaction_id"),
            rs.getString("Type_txt"),
            rs.getString("Type_money"),
            rs.getString("Date"),
            rs.getString("Weight"),
            rs.getString("Gold_rate"),
            rs.getString("Gold_amount"),
            rs.getString("Source_carat"),
            rs.getString("USD_in"),
            rs.getString("USD_out"),
            rs.getString("AFG_in"),
            rs.getString("AFG_out"),
            rs.getString("Gold_in"),
            rs.getString("Gold_out"),
            rs.getString("Silver_in"),
            rs.getString("Silver_out"),
            rs.getString("status")
        };

        model.addRow(row);
    }

} catch (Exception e) {
    e.printStackTrace();
}


// 3. Checkbox Logic
jTable1.getDefaultEditor(Boolean.class).addCellEditorListener(new CellEditorListener() {

    @Override
    public void editingStopped(ChangeEvent e) {

        DefaultTableModel currentModel = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();

        if (row >= 0) {

            Boolean selected = (Boolean) currentModel.getValueAt(row, 0);
            String status = currentModel.getValueAt(row, 17).toString();
            int requestId = (int) currentModel.getValueAt(row, 1);

            try {

                // ✅ که COMPLETED وي → مستقیم PENDING شي
                if (selected && "COMPLETED".equals(status)) {

                    String sql = "UPDATE Transactions SET status = ? WHERE Transaction_id = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, "PENDING");
                    ps.setInt(2, requestId);
                    ps.executeUpdate();

                    currentModel.setValueAt("PENDING", row, 17);
                    currentModel.setValueAt(true, row, 0);
                    jTable1.repaint();
                    return;
                }

                // ✅ که PENDING وي → OptionPane ښکاره شي
                if (selected && "PENDING".equals(status)) {

                    String[] options = {"موافقم با معامله", "بستن صفحه"};

                    int choice = JOptionPane.showOptionDialog(
                            null,
                            "آیا میخواهید این معامله تکمیل شود؟",
                            "پیام درخواست",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            options,
                            options[0]
                    );

                    if (choice == 0) {

                        String sql = "UPDATE Transactions SET status = ? WHERE Transaction_id = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, "COMPLETED");
                        ps.setInt(2, requestId);
                        ps.executeUpdate();

                        currentModel.setValueAt("COMPLETED", row, 17);
                        currentModel.setValueAt(true, row, 0);
                        jTable1.repaint();

                    } else {
                        currentModel.setValueAt(false, row, 0);
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void editingCanceled(ChangeEvent e) {}
});


// 4. Renderer
jTable1.getColumn("وضیعت").setCellRenderer(new DefaultTableCellRenderer() {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value != null) {
            String status = value.toString();

            switch (status) {
                case "PENDING":
                    setBackground(Color.YELLOW);
                    break;
                case "COMPLETED":
                    setBackground(Color.GREEN);
                    break;
                default:
                    setBackground(Color.WHITE);
            }
        }

        return this;
    }
});
    }//GEN-LAST:event_formWindowActivated
int posX, posY;
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        posX=evt.getX();
        posY=evt.getY();

    }//GEN-LAST:event_formMouseEntered

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
      this.setLocation(evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
    }//GEN-LAST:event_formMouseDragged

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
            java.util.logging.Logger.getLogger(Transaction_Table.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaction_Table.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaction_Table.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaction_Table.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        GOLDMS gb = new GOLDMS();
        gb.form();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaction_Table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
