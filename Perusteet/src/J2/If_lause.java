package J2;
//Käyttäjä syöttää 5 kokonaislukua ja ohjelma kertoo suurimman arvon.
import java.util.Scanner;
public class If_lause {
    public static void main(String[] args) {
        //luodaan olio nimeltä lukija, joka vastaanottaa käyttäjän syötteen
        Scanner lukija = new Scanner(System.in);
        //Alustetaan muuttuja esitteluyn yhteydessä, sisäisellä toiminnolla pienin mahdollinen kokonaisluku. 
        int suurin = Integer.MIN_VALUE;
        //tulostetaan käyttäjälle teksti
        System.out.println("Syötä viisi numeroa, niin tarkistan ken viidestä numerosta on suurin:");
        //Määritetään suurin numero käyttäjän viidestä syötetystä kokonaisluvusta
        for (int i = 0; i < 5; i++) {
            int luku = lukija.nextInt(); //Alustetaan muuttuja käyttäjän syöttämällä luvulla
            if (luku > suurin) { //Verrataan käyttäjän syöttämiä lukuja 
                suurin = luku; //Suurin luku päivitetään 
            }
        }
        //Tulostetaaan suurin luku
        System.out.println("Suurin syöttämänne luku on: " + suurin);
        //suljetaan scanner
        lukija.close();
    }
}