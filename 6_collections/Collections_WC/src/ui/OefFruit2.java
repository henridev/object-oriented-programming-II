package ui;

import java.util.*;

class CollectionOperaties {    
    //methode verwijderOpLetter: uit de collectie worden alle elementen verwijderd die beginnen met de parameter letter
    //-------------------------

    //methode verwijderSequence: uit de lijst moet een reeks woorden verwijderd worden, alle woorden tussen eerste en laatste voorkomen van de parameter woord
    //-------------------------
}

public class OefFruit2 {
    public static void main(String args[]) {
        String kist[][] = {{"appel", "peer", "citroen", "kiwi", "perzik"},
        {"banaan", "mango", "citroen", "kiwi", "zespri", "pruim"},
        {"peche", "lichi", "kriek", "kers", "papaya"}};

        List<String> list;
        String mand[];

//Voeg de verschillende kisten samen in een ArrayList list.
//--------------------------------------------------------


        CollectionOperaties.verwijderOpLetter(list, 'p');
        System.out.println("na verwijder letter ('p') :  " + list + "\n");

        CollectionOperaties.verwijderSequence(list, "kiwi");
        System.out.println("na verwijder sequence (kiwi) : " + list + "\n");

//Plaats het resultaat terug in een array mand en sorteer die oplopend.
//---------------------------------------------------------------------


//Toon de inhoud van de array "mand" op het scherm
//------------------------------------------------


    }
}
