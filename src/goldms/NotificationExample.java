import javax.swing.*;
import java.awt.*;

public class NotificationExample {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Notification Demo");
        frame.setSize(300,200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // آیکن
        JLabel icon = new JLabel(new ImageIcon("bell.png"));
        icon.setBounds(50, 40, 48, 48);

        // نوتیفیکیشن
        Fingerprintutil badge = new Fingerprintutil();
        badge.setBounds(1, 100, 100, 100);

        frame.add(icon);
        frame.add(badge);

        frame.setVisible(true);

        // تست
        badge.setCount(100);
        int a=100;
        int b=22;
        float c=23.88f;
        double d=a*b/c;
        System.out.println(d);
        
    }
}