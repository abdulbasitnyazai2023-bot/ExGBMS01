
package goldms;

import com.formdev.flatlaf.FlatLightLaf;
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
}

    
