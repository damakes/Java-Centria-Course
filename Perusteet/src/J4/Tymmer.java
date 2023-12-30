package J4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.util.Scanner;

public class Tymmer {
    private static final int DELAY = 1000; // Viive millisekunteina
    private static int seconds_remaining; // Jäljellä olevat sekunnit

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); // Scanner lukemaan käyttäjän syöte

        System.out.print("Syötä sekunttien määrä: "); //pyyden käyttäjää syöttämään aika
        seconds_remaining = reader.nextInt(); // Lue käyttäjän syöte 
        reader.close(); // Sulje Scanner

        JFrame frame = new JFrame("Ajastin"); // otsikko "Countdown Timer"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ikkunan sulkemisoperaatio

        JLabel timer_Label = new JLabel(getTimeText(seconds_remaining)); // jäljellä oleva aika 
        frame.getContentPane().add(timer_Label); //tuodaan aika ikkunaan 

        ActionListener timer_listener = new ActionListener() { // Luo ActionListener-rajapinnan toteuttava objekti
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds_remaining--; // Vähennä jäljellä olevia sekunteja yhdellä
                timer_Label.setText(getTimeText(seconds_remaining)); // Päivitä teksti vastaamaan uutta aikaa

                if (seconds_remaining <= 0) {
                    ((Timer) e.getSource()).stop();
                    System.out.println("Aika");
                 
                }
            }
        };

        Timer timer = new Timer(DELAY, timer_listener); 
        timer.start(); // Käynnistä ajastin

        frame.pack(); // Muotoile ikkuna komponenttien koon mukaan
        frame.setLocationRelativeTo(null); // Aseta ikkuna näytön keskelle
        frame.setVisible(true); // Aseta ikkuna näkyväksi
    }

    private static String getTimeText(int seconds) {
        int minutes = seconds / 60; // Laske minuutit jakamalla sekunnit 60:llä
        int remaining_Seconds = seconds % 60; // Laske jäljelle jäävät sekunnit jakojäännöksen avulla
        return String.format("%02d:%02d", minutes, remaining_Seconds); // Palauta mm/s^2
    }
}