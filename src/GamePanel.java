package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;

public class GamePanel extends JPanel implements KeyListener {
    private int ballX = 340, ballY = 530; // Ballposisjon
    private int ballDirX = -2, ballDirY = -3; // Bevegelsesretning
    private int paddleX = 300; // Startposisjon for paddle
    private final int PADDLE_WIDTH = 100;
    private final int PADDLE_HEIGHT = 10;
    private final int MOVE_SPEED = 20; // Hvor mye padle flytter seg

    private List<Brick> bricks = new ArrayList<>(); // Liste for mursteinene

    // Murstein-klasse for å representere mursteinene
    class Brick {
        int x, y, width, height;
        boolean isVisible;

        public Brick(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.isVisible = true; // Start synlig
        }
    }

    public GamePanel() {
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this); // Legger til keylistener for tastaturkontroll

        // Legg til mursteinene (6 kolonner, 3 rader)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 6; col++) {
                bricks.add(new Brick(50 + col * 100, 50 + row * 40, 80, 30));
            }
        }

        // Timer for animasjon
        Timer timer = new Timer(10, e -> {
            ballX += ballDirX;
            ballY += ballDirY;

            // Kollisjon med venstre og høyre vegg
            if (ballX <= 0 || ballX >= getWidth() - 15) {
                ballDirX = -ballDirX; // Snur retningen horisontalt
            }

            // Kollisjon med taket
            if (ballY <= 0) {
                ballDirY = -ballDirY; // Snur retningen vertikalt
            }

            // Kollisjon med paddle
            if (ballY >= 550 - 15 && ballX >= paddleX && ballX <= paddleX + PADDLE_WIDTH) {
                ballDirY = -ballDirY; // Spretter tilbake
            }

            // Kollisjon med mursteiner
            for (Brick brick : bricks) {
                if (brick.isVisible && ballX + 15 >= brick.x && ballX <= brick.x + brick.width &&
                        ballY + 15 >= brick.y && ballY <= brick.y + brick.height) {
                    brick.isVisible = false; // Fjern mursteinen
                    ballDirY = -ballDirY; // Snur retningen på ballen
                    break; // Stopp etter første treff
                }
            }

            // Game over hvis ballen går under paddelen
            if (ballY >= getHeight()) {
                ((Timer) e.getSource()).stop(); // Stopper spillet
                System.out.println("Game Over!");
            }

            repaint(); // Tegn på nytt
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Bakgrunnsfarge
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight()); // Bruker getWidth() og getHeight() for fleksibilitet

        // Paddle
        g.setColor(Color.GREEN);
        g.fillRect(paddleX, 550, PADDLE_WIDTH, PADDLE_HEIGHT);

        // Tegn mursteinene
        g.setColor(Color.RED);
        for (Brick brick : bricks) {
            if (brick.isVisible) {
                g.fillRect(brick.x, brick.y, brick.width, brick.height);
            }
        }

        // Ball 🎾
        g.setColor(Color.YELLOW);
        g.fillOval(ballX, ballY, 15, 15); // Bruker ballX og ballY variablene istedet for faste verdier
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (paddleX > 0) { // Sjekker at paddle ikke går ut av skjermen
                paddleX -= MOVE_SPEED;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (paddleX < getWidth() - PADDLE_WIDTH) { // Sjekker at paddle holder seg i rammen
                paddleX += MOVE_SPEED;
            }
        }
        repaint(); // Tegner på nytt for å vise bevegelse
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }
}

