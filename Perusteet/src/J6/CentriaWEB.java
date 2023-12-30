package J6;

/*
 * Ohjelma hakee URL osoiteesta tiedon, taltioi ja tulostaa tiedon. 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.FileWriter;


public class CentriaWEB {
    public static void main(String[] args) {
        try {
            // olio lukemaan URL 
            URL url = new URL("https://web.centria.fi/"); 

            // Lue sivuston sisältö
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            //Tallennus tyyppi hasetulle tiedolle ja tiedoston nimi
            String fileName = "content.markdown"; //Voisi tallentaa myös *.txt, *.html tai *.AP. Markdown:lla pääsee näkemään myös Preview kohdasta visuaalista rakennetta
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content.toString());
            writer.close();

            // Tulosta tiedoston sisältö ja tallenetun tiedoston nimi
            System.out.println(content.toString());
            System.out.println("Tiedosto tallennettu: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Virhe tiedoston lukemisessa.");
        }
    }
}