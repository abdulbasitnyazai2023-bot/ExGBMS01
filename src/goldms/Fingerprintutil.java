import javax.swing.*;
import java.awt.*;

public class Fingerprintutil extends JLabel {

    private int count = 0;

    public Fingerprintutil() {
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 12));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVisible(false); // اول مخفی باشد
    }

    public void setCount(int count) {
        this.count = count;

        if (count <= 0) {
            setVisible(false);
        } else {
            setText(String.valueOf(count));
            setVisible(true);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (count > 0) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(Color.RED);
            g2.fillOval(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(g);
    }
}