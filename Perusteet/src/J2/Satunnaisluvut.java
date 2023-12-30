package J2;

import java.util.Random;

public class Satunnaisluvut{
    public static void main(String[] args) {
        Random random = new Random();
        
        // random x koordinaatti 0-79 y koordinaatti 0-23 
        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(80); 
            int y = random.nextInt(24); 

            tulostaX(x, y); //kutsutaan metodia parametreineen
        }
    }

    public static void tulostaX(int x, int y) { //luodaan metodi ja annetaan sille kaksi parametria x,y
        //luodaan silmukka, joka tulostaa käyttäjälle 24.rivi ja 80.sarake välille satunnaisesti kirjaimen. 
        for (int i = 0; i < 24; i++) { //muuttuja i vaihtelee välillä 0-24
            for (int j = 0; j < 80; j++) {//muuttuja j vaihtelee välillä 0-80
                if (i == y && j == x) {//verrataan ovatko muuttuja yhtä suuri parametrin kanssa, 
                    //mikäli pitää paikkansa asetataan uudet koordinaatit kirjaimeen ja tulostetaan tämä näytölle
                    System.out.print("Käärijä");
                } else { //muussa tapauksessa tulostetaan tyhjiö koordinaatin kohdalle 
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}