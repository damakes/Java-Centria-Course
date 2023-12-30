package J2;

import java.util.Scanner;

public class Switch_case {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in); // Luodaan olio "lukija" lukemaan käyttäjän syöte 
        System.out.print("Syötä merkki, käännän sen ASCII-koodiksi: ");//Tulostetaan käyttäjälle kysymys
        char merkki = lukija.next().charAt(0); //Luetaan käyttäjän syöttämä merkki
        int asciiK = (int) merkki; // Pakkomuuntaa toiseksi tyypiksi 
        //Tulostetaan syötetty merkki ja käännetty muoto, omille riveilleen.
        System.out.println("Käännettävä merkki: "+merkki
        +"\nKäännetty ASCII muotoon: "+asciiK);
        lukija.close(); //suljetaan lukija
    }
}
