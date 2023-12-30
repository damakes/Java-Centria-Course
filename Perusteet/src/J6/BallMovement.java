package J6;

/*
 * Ohjelmassa Liikutetaan palloa nuolinäppäimillä sinisen aitauksen sisällä. 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallMovement extends JFrame implements KeyListener {
    private BallPanel ballPanel;

    public BallMovement() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ballPanel = new BallPanel(700, 500);
        add(ballPanel);

        addKeyListener(this);
        setFocusable(true);
    }

    public static void main(String[] args) {
        BallMovement jvl = new BallMovement();
        jvl.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_RIGHT) {
            ballPanel.moveRight();
        } else if (keyCode == KeyEvent.VK_LEFT) {
            ballPanel.moveLeft();
        } else if (keyCode == KeyEvent.VK_UP) {
            ballPanel.moveUp();
        } else if (keyCode == KeyEvent.VK_DOWN) {
            ballPanel.moveDown();
        }
    }

    
    public void keyReleased(KeyEvent e) {
        
    }

    
    public void keyTyped(KeyEvent e) {
        
    }
}

class BallPanel extends JPanel {
    private int x = 400;
    private int y = 200;
    private int moveDistance = 10;
    private int panelWidth;
    private int panelHeight;

    public BallPanel(int width, int height) {
        setBackground(Color.WHITE);
        panelWidth = width;
        panelHeight = height;
    }

    public void moveLeft() {
        if (x - moveDistance >= 0) {
            x -= moveDistance;
            repaint();
        }
    }

    public void moveRight() {
        if (x + moveDistance + 50 <= panelWidth) {
            x += moveDistance;
            repaint();
        }
    }

    public void moveUp() {
        if (y - moveDistance >= 0) {
            y -= moveDistance;
            repaint();
        }
    }

    public void moveDown() {
        if (y + moveDistance + 50 <= panelHeight) {
            y += moveDistance;
            repaint();
        }
    }

    //Pallo sinisessä laatikossa 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Piirretään rajat
        g.setColor(Color.BLUE); // laatikon rajan väri
        g.drawLine(0, 0, panelWidth, 0);                          // Ylä-viiva
        g.drawLine(0, panelHeight - 1, panelWidth, panelHeight - 1); // Ala-viiva
        g.drawLine(1, 1, 1, panelHeight);                         // Vasen-viiva
        g.drawLine(panelWidth - 1, 0, panelWidth - 1, panelHeight);   // Oikea-viiva

        g.setColor(Color.black);    //asetetaan pallon väri
        g.fillOval(x, y, 50, 50); //pallon korkeus ja leveys 

    }
} 
