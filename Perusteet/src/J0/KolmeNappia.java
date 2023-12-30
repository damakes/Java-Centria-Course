package J0;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class KolmeNappia extends JFrame {

    public static void main(String[] args) {
        KolmeNappia frame = new KolmeNappia(); // luodaan instanssi GK

        //luodaan objekti, käytetään painikkeiden säilijöinä
        FlowLayout flowLayout = new FlowLayout(); 
        Container contentPane = frame.getContentPane();  
        JButton nappi_1 = new JButton("nappi 1");
        JButton nappi_2 = new JButton("nappi 2");
        JButton nappi_3 = new JButton("nappi 3");

        //lisätään napit
        contentPane.setLayout(flowLayout);
        contentPane.add(nappi_1);
        contentPane.add(nappi_2);
        contentPane.add(nappi_3); 
        
        flowLayout.setAlignment(FlowLayout.LEFT); //nappien asettelu tyyli ruudulla
        flowLayout.setHgap(20); //nappien reuna etäisyys toisistaan 
        System.out.print(flowLayout.getHgap()); //haetaan etäisyys


        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

