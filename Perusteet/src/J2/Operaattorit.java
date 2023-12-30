package J2;
//Toteuta ohjelma, joka laskee aineen tiheyden, kun massa on 3000 kilogrammaa ja tilavuus on 2 kuutiometriä. 
//Vihje: tiheys on massa jaettuna tilavuudella.
public class Operaattorit {
    public static void main(String[] args) {
        //alustetaan muuttujat esittelyn yhteydessä 
        int m = 3000; // Massa 
        int v = 2; // Tilavuus k
        double p = ((double) m/v); // Pakkomuuntaa toiseksi tyypiksi sijoittamalla uusi tietotyyppi muuttujan nimen eteen
        
        System.out.println("Aineen tiheys on " + p + " kg/m^3.");//tulostetaan muuttuja tiheys, jonka arvo on massa/tilavuus lopputulos
    }
}
