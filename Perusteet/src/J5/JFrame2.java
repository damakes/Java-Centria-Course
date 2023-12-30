package J5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class JFrame2 extends JFrame {
private final Font mainFont = new Font("Microsoft Sans Serif", Font.BOLD, 40);
private JTextField tftieto, tfavain;
private JLabel lbtulostus;
private Icon ic = new  ImageIcon("src/J5/eye.PNG");
private Icon ic2 = new  ImageIcon("src/J5/eyeblu.PNG");


public JFrame2() {
    /*  Paneeli */
    
    // tieto
    JLabel lbtieto = new JLabel("Tieto(esim.= Joo=3XX)");
    lbtieto.setFont(mainFont);
    tftieto = new JTextField();
    tftieto.setFont(mainFont);

    // avain
    JLabel lbavain = new JLabel("Avain(esim.=23)");
    lbavain.setFont(mainFont);
    tfavain = new JTextField();
    tfavain.setFont(mainFont);

    // luodaan paneeli
    JPanel formPanel = new JPanel();
    formPanel.setLayout(new GridLayout(4, 1, 5, 5));
    formPanel.setOpaque(false);

    

    // lisätään ja muodostetaan paneeli
    formPanel.add(lbtieto);
    formPanel.add(tftieto);
    formPanel.add(lbavain);
    formPanel.add(tfavain);

    /* tulostus */

    // tulostus 
    lbtulostus = new JLabel();
    lbtulostus.setFont(mainFont);

    /* Nappi Paneeli */

    // luo pura nappi
    JButton btnCrypt = new JButton("Pura");
    btnCrypt.setFont(mainFont);

    // toiminnan lukija käyttäjälle
    btnCrypt.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // hae tieto ja avain 
            String tieto = tftieto.getText();
            int avain = Integer.parseInt(tfavain.getText());

            // toteuta purku
            String tulos = Sala_kirjoita(tieto, (int)avain);
            
            // tulostetaan tulos
            lbtulostus.setText(" : " + tulos );//Purettu
            lbtulostus.setIcon(ic2);

        }
    });

    // luo salaa nappi
    JButton btnDecrypt = new JButton("Salaa");
    btnDecrypt.setFont(mainFont);
    
     // toiminnan lukija käyttäjälle
    btnDecrypt.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // haetaan tieto ja avain teksti ruudusta
            String tieto = tftieto.getText();
            int avain = Integer.parseInt(tfavain.getText());

            // toteutetaan salaus
            String tulos = Pura_Sala(tieto, (int)avain);

            
            lbtulostus.setText(" : " + tulos ); //Salattu
            lbtulostus.setIcon(ic);
        }
    });

    // paneeli napeille 
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
    buttonsPanel.setOpaque(false);

    //lisätään napit paneeliin
    buttonsPanel.add(btnCrypt);
    buttonsPanel.add(btnDecrypt);

    // pää paneeli kaikille komponenteille
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    //taustan väri
    mainPanel.setBackground(new Color(0, 0, 0));

    // pää paneelin rajat
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // paneelin asettelu järjestys
    mainPanel.add(formPanel, BorderLayout.NORTH);
    mainPanel.add(lbtulostus, BorderLayout.CENTER);
    mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

    // JFrame otsikko ja koko
    setTitle("Reaper");
    setSize(500, 600);
    setMinimumSize(new Dimension(300, 400));
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);

    // lisätään pää paneeli JFrameen
    add(mainPanel);
}

public static String Sala_kirjoita(String tieto, int avain) { // luodaan metodi joka ottaa vastaan kaksi parametria
    StringBuilder salattu = new StringBuilder(); //merkkijonon rakentamiseen

    for (int i = 0; i < tieto.length(); i++) { //silmukka "tieto"
        char viesti = tieto.charAt(i); //taltioidaan 
        char salattu_viesti = (char) (viesti + (int)avain); //suoritetaan salaus
        salattu.append(salattu_viesti);// lisätään salattu viesti
    }

    return salattu.toString(); //Palautetaan salattu merkkijono muuttujan avulla.
}

public static String Pura_Sala(String salattu, int avain) { // luodaan metodi joka ottaa vastaan kaksi parametria
    StringBuilder purettu = new StringBuilder(); //merkkijonon rakentamiseen

    for (int i = 0; i < salattu.length(); i++) { //silmukka "salattu"
        char viesti = salattu.charAt(i); //taltioidaan 
        char purettu_viesti = (char) (viesti - (int)avain); //suoritetaan purku
        purettu.append(purettu_viesti);//lisätään purettu viesti
    }

    return purettu.toString(); //Palautetaan salattu merkkijono muuttujan avulla.
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new JFrame2();
        }
    });
}
}