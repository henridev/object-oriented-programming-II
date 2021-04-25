package persistentie;

import domein.Bier;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class BierMapper {

    public List<Bier> geefLijstBieren() {
        
        List<Bier> bieren = new ArrayList<>();
        bieren.add(new Bier("WestVleteren_Blond","blond", 5.0, 9.3, "Sint-Sixtusabdij van Westvleteren"));
        bieren.add(new Bier("Tripel_Kanunnik", "tripel" ,8.2, 9.1, "Wilderen"));
        bieren.add(new Bier("Black_Albert", "donker", 13.0, 9.0 ,"De Struise Brouwers"));
        bieren.add(new Bier("Rochefort_10", "onbekend", 11.0, 9.1, "Brasserie de l'Abbaye de Saint-R�my"));
        bieren.add(new Bier("Alpaïde" ,"donker", 9.5 ,9.0 ,"Nieuwhuys Hoegaarden"));
        bieren.add(new Bier("Cantillon_Geuze", "geuze", 5.0, 8.5,"Cantillon"));
        bieren.add(new Bier("Moinette_Blonde", "blond" ,8.5, 8.5, "Dupont"));
       	bieren.add(new Bier("Wilderen_Goud", "blond" ,6.0, 8.4, "Wilderen"));
        bieren.add(new Bier("Tripel_Karmeliet" ,"tripel" ,8.4, 8.3, "Bosteels"));
        bieren.add(new Bier("Westmalle_Tripel", "tripel" ,9.5 ,8.2, "Abdij der trappisten van Westmalle"));
        return bieren;
    }
  
}
