package J2;

import java.util.Scanner;

public class Silmukat {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in); // luodaan olio lukemaan käyttäjän syöte

        //Pyydetään käyttäjää valitsemaan valikon vaihtoehdoista 
        //Verrataan käyttäjän valintaa, jonka perusteella tulostetaan viesti, lopetetaan ohjelma. 
        //Silmukka päättyy valinnan olessa = 0 
        int valinta;

        do {//silmukka jonka pyöriminen päättyy käyttäjän syötteen ollessa = 0 
            valinta = tulostaValikko(lukija); //luodaan olio jota kutsumalla tulostetaan käyttäjälle valikon vaihtoehdot

            switch (valinta) { //Verrataan täällä käyttäjän syötettä
                case 1:
                    System.out.println("Koska se oli kyllästynyt seisomaan!");
                    break;
                case 2:
                    System.out.println("Koska niillä ei ollut tarpeeksi kolahdinta!");
                    break;
                case 3:
                    System.out.println("Koska molemmissa tilanteissa toivot, että liikenne alkaisi liikkua!");
                    break;
                case 0:
                    System.out.println("Lopetetaan");
                    break;
                default:
                    System.out.println("Virheellinen valinta. Yritä uudelleen.");
                    break;
            }
            System.out.println();
        } while (valinta != 0);
    }
    //Luodaan metodi joka tulostaa valikko vaihtoehdot
    public static int tulostaValikko(Scanner lukija) {
        System.out.println("Minkä vitsin haluat lukea?:"
        +"\n1. Miksi polkupyörä kaatui?"
        +"\n2. Miksi hedelmät eivät voineet soittaa rock-musiikkia?"
        +"\n3. Miksi ruuhkassa ajaminen on kuin kalaan meneminen?"
        +"\n0. En halua lukea vitsejä");
        return lukija.nextInt();
    }
}