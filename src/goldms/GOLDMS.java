
package goldms;

import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.UIManager;


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

}

    
