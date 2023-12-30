package J2;

import java.util.Scanner;

public class Taulukot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Artikkeli: ");
        String nimi = scanner.nextLine();

        System.out.print("Artikkeli.numero: ");
        int avain = scanner.nextInt();

        scanner.nextLine(); // Tyhjentää rivinvaihdon merkit

        System.out.print("\n"+"*".repeat(3)+"VALMIS"+"*".repeat(3)+"\n"+"\nS - SALAA"+"\nP - PALAUTA");
        String valinta = scanner.nextLine();

        String tulos = "";
        if (valinta.equalsIgnoreCase("S")) {
            tulos = Sala_kirjoita(nimi, avain);
        } else if (valinta.equalsIgnoreCase("P")) {
            tulos = Pura_Sala(nimi, avain);
        } else {
            System.out.println("Virheellinen valinta!");
            System.exit(0);
        }

        System.out.println("Tulos: " + tulos);

        scanner.close();
    }

    public static String Sala_kirjoita(String nimi, int avain) {
        StringBuilder salattu = new StringBuilder();

        for (int i = 0; i < nimi.length(); i++) {
            char kirjain = nimi.charAt(i);
            char salaK = (char) (kirjain + avain);
            salattu.append(salaK);
        }

        return salattu.toString();
    }

    public static String Pura_Sala(String salaN, int avain) {
        StringBuilder purettu = new StringBuilder();

        for (int i = 0; i < salaN.length(); i++) {
            char kirjain = salaN.charAt(i);
            char purettuKirjain = (char) (kirjain - avain);
            purettu.append(purettuKirjain);
        }

        return purettu.toString();
    }
}