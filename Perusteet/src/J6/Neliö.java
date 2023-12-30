package J6;

/*
 * Neliö Liikkuu laatikon rajojen sisällä määrietyllä nopeudella 
 */

import javax.swing.*;
import java.awt.*;

public class Neliö extends JPanel {

    /*
     *  Neliön koordinaatit
     *  Neliön nopeus x,y -suunnassa
     */
    private int x, y; 
    private int speedX = 5; 
    private int speedY = 5; 

    public Neliö() {
        x = 100;
        y = 100;

        /* Säie neliön liikuttamista varten
         * Päivitä neliön koordinaatit
         * Pidetään neliö ikkunan sisällä
         * Käännetään nopeuden suunta x, y suunnassa, jotta liike olisi jatkuvaa
         * Keskeytetään säie 20 ms
         */
        Thread movingThread = new Thread(() -> {
            while (true) {
                try {
                    
                    x += speedX;
                    y += speedY;

                    
                    if (x < 0 || x + 50 > getWidth()) {
                        speedX = -speedX; 
                    }
                    if (y < 0 || y + 50 > getHeight()) {
                        speedY = -speedY; 
                    }

                    repaint(); // Päivitä ikkunan näkymä

                    Thread.sleep(20); // Keskeytä säie m/s
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        movingThread.start(); // Käynnistä säie
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(x, y, 50, 50);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Neliö::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Neliö");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new Neliö());
        frame.setVisible(true);
    }
}
