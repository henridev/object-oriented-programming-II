package serialisatie.main;

import serialisatie.domein.DomeinController;
import serialisatie.ui.Applicatie;

public class StartUp {
    public static void main(String[] args) {
        new Applicatie(new DomeinController()).start();
    }
 
}
