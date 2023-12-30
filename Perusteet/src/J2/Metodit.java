package J2;

import java.util.Scanner;

public class Metodit {
    public static void main(String[] args) {
        Scanner Lukija = new Scanner(System.in); //Luodaan olio scannerist
        
        System.out.print("Numeroiden määrä: "); //tulostetaann käyttäjälle kommentti
        int määrä = Lukija.nextInt(); //odotetaan käyttäjän numero syötettä 
        
        //luodaan taulukko, johonka tallennetaan käyttäjän syöttämä numero määrä
        int[] numerot = new int[määrä]; 
        for (int i = 0; i < määrä; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            numerot[i] = Lukija.nextInt();
        }
        
        double keskiarvo = Laske_keskiarvo(numerot); //kutsumalla lasketaan numerot taulukossa
        System.out.println("Keskiarvo: " + keskiarvo);//tulostetaan keskiarvo
        
        Lukija.close(); //suljetaan lukija
    }

    public static double Laske_keskiarvo(int[] numerot) {//luodaan metodi, jota kutsumalla lasketaan numeroiden keskiarvo
        int summa = 0; //asetetaan lähtöarvo 
        for (int numero : numerot) {
            summa += numero;
        }
        
        return (double) summa / numerot.length; // Palautetaan keskiarvo double tyyppinä
    }
}