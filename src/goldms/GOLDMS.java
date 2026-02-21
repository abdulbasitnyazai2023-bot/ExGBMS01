
package goldms;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;


public class GOLDMS {

    /**
     * @param args the command line arguments
 */
    public static void main(String[] args) {
        form();
       
 
       
    }
        public static  void form(){
                    try {
            // فعال کردن FlatLaf و گرد کردن گوشه‌ها
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Component.arc", 50);
            UIManager.put("Button.arc", 50);
            UIManager.put("TextComponent.arc", 50);
            UIManager.put("Panel.arc", 20);   // اضافه کن این را


        } catch (Exception ex) {
            ex.printStackTrace();
        }
      

    }
          // د ډیټابېس مسیر (Path)
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
       public  void getConnection() {

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
          public String convertToPersianNumbersusd(String input) {

        char[] english = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] persian = {'۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹'};

        for (int i = 0; i < english.length; i++) {
            input = input.replace(english[i], persian[i]);
        }

        return input;
    }
           public static void apply(JTable table) {

        // ارتفاع سطر
        table.setRowHeight(30);

        // فونت عمومی
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        // وسط کردن متن
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // استایل Header
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setReorderingAllowed(false);
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);

        // رنگ انتخاب
        table.setSelectionBackground(new Color(0, 120, 215));
        table.setSelectionForeground(Color.WHITE);

        // حذف خطوط عمودی
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(true);

        // Zebra Effect
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table,
                                                           Object value,
                                                           boolean isSelected,
                                                           boolean hasFocus,
                                                           int row,
                                                           int column) {

                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ?
                            Color.WHITE :
                            new Color(245, 245, 245));
                }

                setHorizontalAlignment(JLabel.CENTER);
                return c;
            }
        });

        // بوردر نرم
        table.setBorder(BorderFactory.createEmptyBorder());
    }
}

    
