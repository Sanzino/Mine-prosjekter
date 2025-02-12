 //


package src;
import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {
    private int ballX = 340, ballY = 530; //balpp posisjon
    public GamePanel() {
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Bakgrunnsfarge
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight()); // Bruker getWidth() og getHeight() for fleksibilitet

        // Paddle
        g.setColor(Color.GREEN);
        g.fillRect(300, 550, 100, 10); // (x, y, bredde, høyde)

        // Mursteiner
        g.setColor(Color.RED);
        for (int i = 0; i < 6; i++) {
            g.fillRect(50 + i * 100, 50, 80, 30); // (x, y, bredde, høyde)
        }

        // Ball 🎾
        g.setColor(Color.YELLOW);
        g.fillOval(340, 530, 15, 15); // (x, y, diameter, diameter)
    }


}