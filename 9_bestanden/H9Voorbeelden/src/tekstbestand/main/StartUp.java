package tekstbestand.main;

import tekstbestand.domein.DomeinController;
import tekstbestand.ui.Applicatie;

public class StartUp {
    public static void main(String[] args) {
        new Applicatie(new DomeinController()).start();
    }
 
}
