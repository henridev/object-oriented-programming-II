package ui;

import java.util.*;

class CollectionOperaties {    
    //methode verwijderOpLetter: uit de collectie worden alle elementen verwijderd die beginnen met de parameter letter
    //-------------------------
    public static void verwijderOpLetter(Collection<String> collection, Character c){
        collection.removeIf(item -> item.startsWith(c.toString()));
        /*
        Iterator<String> iter = collection.iterator();
        while (iter.hasNext()) {
            String item = iter.next();
            if(item.startsWith(c.toString())){
                iter.remove();
            }
        }
        */
    }

    //methode verwijderSequence: uit de lijst moet een reeks woorden verwijderd worden, alle woorden tussen eerste en laatste voorkomen van de parameter woord
    //-------------------------
    public static void verwijderSequence(Collection<String> collection, String word){
        collection.removeIf(item -> item.contains(word));
    }
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
        list = new ArrayList<>();
        for (String[] e : kist) {
            list.addAll(Arrays.asList(e));
        }

        CollectionOperaties.verwijderOpLetter(list, 'p');
        System.out.println("na verwijder letter ('p') :  " + list + "\n");

        CollectionOperaties.verwijderSequence(list, "kiwi");
        System.out.println("na verwijder sequence (kiwi) : " + list + "\n");

//Plaats het resultaat terug in een array mand en sorteer die oplopend.
//---------------------------------------------------------------------
        mand = list.toArray(new String[0]);
        Arrays.sort(mand);

//Toon de inhoud van de array "mand" op het scherm
//------------------------------------------------
        System.out.println(String.join(",",mand));
    }
}
