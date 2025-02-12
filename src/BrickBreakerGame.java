
//Steg 1: Opprette Spillvinduet (JFrame)
//Lag en ny klasse BrickBreakerGame som setter opp et spillvindu.

package src;
import javax.swing.*;

public class BrickBreakerGame {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Brick Breaker"); // Lager et spill vindu
        GamePanel panel = new GamePanel(); // legger til spillområdet

        frame.add(panel); // Legger GamePanel til JFrame!
        frame.setSize(700, 600); //Størrelse på vinduet
        frame.setResizable(false); // ikke la brukeren endre søttrelse
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Lukk spillet når vinduet lukkes
        frame.setVisible(true); // Gjør vinduet synlig
    }

    //✅ Kjør programmet: Du skal nå se et tomt vindu med tittelen "Brick Breaker".


}
