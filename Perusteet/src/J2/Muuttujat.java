package J2;

public class Muuttujat {

//Esitellään muuttujat ja niiden tyypit  
static char merkki ; 
static int suomenVakilukuMiljoonia;
static double kellonaika; 
static int luku; 
static String postinumero;
static int huoneenPintaAla;
static String matkaAika;

    public static void main(String[] args) {

        //Sijoitetaan esiteltyihin muutujiin arvo sijoitusoperaattorilla 
        merkki = 'A'; // Yksi merkki
        suomenVakilukuMiljoonia = 5; 
        kellonaika = 12.55; 
        luku = 5000; 
        postinumero = "00100"; 
        huoneenPintaAla = 30; 
        matkaAika = "4 tuntia"; 
        
        //tulostetaan muuttujat omille riveilleen 
        System.out.println("Merkki: " + merkki +"\nSuomen väkiluku, miljoonia: " 
        + suomenVakilukuMiljoonia +"\nKellonaika: " 
        + kellonaika +"\nLuku: " 
        + luku + "\nPostinumero: " 
        + postinumero + "\nHuoneen pinta-ala: " 
        + huoneenPintaAla +"\nMatka-aika Kokkola-Helsinki: " 
        + matkaAika);
    }
}
