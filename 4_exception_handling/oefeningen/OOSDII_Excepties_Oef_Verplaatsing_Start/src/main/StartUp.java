package main;

import domein.DomeinController;
import ui.VerplaatsingApplicatie;

public class StartUp {
    public static void main(String args[]) {
            try {
                DomeinController dc = new DomeinController();
                new VerplaatsingApplicatie(dc).start();
            } catch (IllegalArgumentException e){
                System.out.println("Applicatie gestopt omwille van ongeldig argument");
            }
    }
}
