package J5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class JFrame1 {
    private final Font mainFont = new Font("Microsoft Sans Serif", Font.BOLD, 20); //Määritetään muotoilu ja kirjasin koko
    private final String filePath = "src/J5/JFrame2.java"; // tiedosto polku JFrame2
    private Icon knock = new ImageIcon("src/J5/knock.PNG"); // tiedosto polku kuvaan 

    public JFrame1() {
        // Luodaan JButton-instanssi nimeltä "Knock"
        JButton btnPressa = new JButton("Knock");
        btnPressa.setFont(mainFont);
        btnPressa.setBackground(Color.ORANGE);
        btnPressa.setIcon(knock);

    
        // btnPressa ActionListener kuuntelija
        btnPressa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Suoritetaan JFrame2-luokka uudessa prosessissa
                    new ProcessBuilder("java", "-cp", "path/to/class/files", filePath).start();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                // Suljetaan nykyinen JFrame1-ikkuna
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnPressa);
                frame.dispose();
            }
        });
        // Luodaan JFrame nimellä "DOOR"
        JFrame frame = new JFrame("DOOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(btnPressa);
        frame.pack();
        frame.setMinimumSize(new Dimension(300, 300));
        frame.setVisible(true);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFrame1();
            }
        });
    }
}