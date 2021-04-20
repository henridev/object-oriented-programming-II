package ui;

import java.util.*;

public class OefLinkedList {

    public OefLinkedList() {

//cre�er een Integer-array "getallen" en initialiseer met 4, 3, 9 en 7
//-------------------------------------------------------------------
        //Integer getallen[] =
        
//cre�er een 'arrayList' en vul op met de array "getallen" (1 instructie)
//-----------------------------------------------------------------------------------

//cre�er de linkedList "lijstInteger" en vul op met de inhoud van de arrayList ( 1 instructie )
//--------------------------------------------------------------------------------

//Voeg vooraan in "lijstInteger" getal 2 toe
//------------------------------------------------

//Voeg achteraan in "lijstInteger" getal 12 toe
//---------------------------------------------------
        weergevenLijst("oplossing: 2 4 3 9 7 12", lijstInteger);

//Verwijder het eerste element van "lijstInteger" en toon op het scherm d.m.v. printf
//----------------------------------------------------------------
        System.out.printf("%s%n%s", "oplossing: 2", "           ");
        // int eersteElement =
        // System.out.printf(

        metEenVerhogen(lijstInteger);
        weergevenLijst("oplossing: 5 4 10 8 13", lijstInteger);

        metEenVerhogen(lijstInteger);
        weergevenLijst("oplossing: 6 5 11 9 14", lijstInteger);

        elementenMetOnevenIndexVerwijderen(lijstInteger);
        weergevenLijst("oplossing: 6 11 14", lijstInteger);

        elementenToevoegenNaOnevenGetallen(lijstInteger);
        weergevenLijst("oplossing: 6 11 13 14", lijstInteger);
        
        String woorden[] = {"aaa", "bbb", "ccc", "ddd", "eee", "fff"};

//creëer de LinkedList "lijstString" en vul op met de array "woorden" (1 instructie)
//-----------------------------------------------------------------------
        elementenMetOnevenIndexVerwijderen(lijstString);

        weergevenLijst("oplossing: aaa ccc eee", lijstString);
        
        weergevenLijstOmgekeerdeVolgorde(
		"oplossing: eee ccc aaa", lijstString);

    }

    public void metEenVerhogen(lijst) //------------
    {
        //Alle elementen van de lijst wijzigen:
        //alle elementen worden met ��n verhoogd


    }

    
    //generieke methode:
    public void elementenMetOnevenIndexVerwijderen(lijst) //---                                           -------------
    {
        //Alle elementen, met oneven index, verwijderen (enkel met een iterator werken)
        //-----------------------------------------------------------------------------

    }
    
    public void elementenToevoegenNaOnevenGetallen(lijst) //-----------
    //Na ieder oneven getal wordt hetzelfde getal+2 toegevoegd in de Lijst
    //vb. 5 10 13 wordt 5 7 10 13 15
    //---------------------------------------------------
    {

    }


    public void weergevenLijst(String oplossing, Collection<String> lijst) {
        System.out.printf("%s%n%s", oplossing, "           ");
        for (String element : lijst)
         {
         System.out.printf("%s ", element);
         }
        System.out.println();
    }
    
    public void weergevenLijst(String oplossing, List<Integer> lijst) {
        System.out.printf("%s%n%s", oplossing, "           ");
        for (int element : lijst)
         {
         System.out.printf("%d ", element);
         }
        System.out.println();
    }
    
    //generieke methode:
    public void weergevenLijstOmgekeerdeVolgorde(String oplossing, lijst) {
    // Alle elementen van de List<Integer> in omgekeerde volgorde weergeven 
    //--------------------------------------------------------------------------------------
       System.out.printf("%s%n%s", oplossing, "           ");

       
       System.out.println();
    }

    public static void main(String args[]) {
        new OefLinkedList_opgave();
    }
}
