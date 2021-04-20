package ui;

import domein.DomeinController;
import domein.Draagbaar;
import domein.Wapen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DraagbaarApplicatie {
    private final DomeinController dc;
    Scanner scanner = new Scanner(System.in);
    public DraagbaarApplicatie(DomeinController dc)
    {
        this.dc = dc;
    }
    

    public void start() {
        int keuze;
        try {
            keuze = geefKeuzeUitMenu();
            switch (keuze) {
                case 1 -> {
                    voegWapenToe();
                }
                case 2 -> {
                    voegSleutelToe();
                }
                case 3 -> {
                    voegGebouwToe();
                }
                case 4 -> {
                    System.out.println(dc.geefOverzicht());
                }
            }
            if(keuze != 5){
                start();
            }
        } catch (IllegalArgumentException|InputMismatchException e) {
            System.out.println(e.toString());
            System.out.println("Voer een geheel getal in");
            start();
        } finally {
             scanner.close();
        }

    }

    private int geefKeuzeUitMenu() {
        int keuze = 0;
        while (keuze < 1 || keuze > 5) {
                System.out.println("Kies uit");
                System.out.println("1. Voeg wapen toe");
                System.out.println("2. Voeg sleutel toe");
                System.out.println("3. Voeg gebouw toe");
                System.out.println("4. Toon huidig overzicht");
                System.out.println("5. Stop Applicatie");
                System.out.println("");
                keuze = scanner.nextInt();
                scanner.nextLine();
        }
        return keuze;
    }

    private void voegWapenToe() {
        try{
            String naam; double gewicht; int niveau, kracht; boolean gebruikt;
            System.out.println("Geef een naam zonder spatie");naam = scanner.nextLine();
            if(naam.contains(" ")) throw new IllegalArgumentException("geen spaties toegelaten");
            System.out.println("Geef het gewicht"); gewicht = scanner.nextDouble();
            System.out.println("Geef het niveau"); niveau = scanner.nextInt();
            System.out.println("Geef de kracht"); kracht = scanner.nextInt();
            System.out.println("Werd het reeds gebruikt (true/false)"); gebruikt = scanner.nextBoolean();
            dc.voegWapenToe(naam, gewicht, niveau, kracht, gebruikt);
        } catch (IllegalArgumentException|InputMismatchException e) {
            voegWapenToe();
        }

    }

    private void voegSleutelToe() {
        try {
            String naam;double gewicht;int niveau, deur;
            System.out.println("Geef een naam zonder spatie");naam = scanner.nextLine();
            if (naam.contains(" ")) throw new IllegalArgumentException("geen spaties toegelaten");
            System.out.println("Geef het gewicht");gewicht = scanner.nextDouble();
            System.out.println("Geef het niveau");niveau = scanner.nextInt();
            System.out.println("Geef het nummer van de deur");deur = scanner.nextInt();
            dc.voegSleutelToe(naam, gewicht, niveau, deur);
        } catch (IllegalArgumentException|InputMismatchException e) {
            voegSleutelToe();
        }
    }

    private void voegGebouwToe() {
        try{
            String naam; double hoogte;
            System.out.println("Geef een naam zonder spatie"); naam = scanner.nextLine();
            if(naam.contains(" ")) throw new IllegalArgumentException("geen spaties toegelaten");
            System.out.println("Geef de hoogte"); hoogte = scanner.nextDouble();
            dc.voegGebouwToe(naam, hoogte);
        } catch (IllegalArgumentException|InputMismatchException e) {
            voegGebouwToe();
        }
    }
}
