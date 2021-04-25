package ui;

import java.util.*;

public class OefLinkedList {

    public OefLinkedList() {

        //creeer een Integer-array "getallen" en initialiseer met 4, 3, 9 en 7
        //-------------------------------------------------------------------
        Integer getallen[] = { 4, 3, 9 , 7};
        
        //creeer een 'arrayList' en vul op met de array "getallen" (1 instructie)
        //-----------------------------------------------------------------------------------
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(getallen));

        //creeer de linkedList "lijstInteger" en vul op met de inhoud van de arrayList ( 1 instructie )
        //--------------------------------------------------------------------------------
        List<Integer> lijstInteger = new LinkedList<>(Arrays.asList(getallen));

        //Voeg vooraan in "lijstInteger" getal 2 toe
        lijstInteger.add(0, 2);


        //Voeg achteraan in "lijstInteger" getal 12 toe
        lijstInteger.add(lijstInteger.size(), 12);


//        weergevenLijst("oplossing: 2 4 3 9 7 12", lijstInteger);

        //Verwijder het eerste element van "lijstInteger" en toon op het scherm d.m.v. printf
//        System.out.printf("%s%n%s", "oplossing: 2", "           ");
        Integer eersteElement = lijstInteger.remove(0);
//         System.out.printf("%d%n",eersteElement);

        metEenVerhogen(lijstInteger);
//        weergevenLijst("oplossing: 5 4 10 8 13", lijstInteger);

        metEenVerhogen(lijstInteger);
//        weergevenLijst("oplossing: 6 5 11 9 14", lijstInteger);

        elementenMetOnevenIndexVerwijderen(lijstInteger);
        weergevenLijst("oplossing: 6 11 14",lijstInteger);

        elementenToevoegenNaOnevenGetallen(lijstInteger);
        weergevenLijst("oplossing: 6 11 13 14", lijstInteger);
        
        String woorden[] = {"aaa", "bbb", "ccc", "ddd", "eee", "fff"};

        //creëer de LinkedList "lijstString" en vul op met de array "woorden" (1 instructie)
        System.out.println();
        List<String> lijstString = new LinkedList<>(Arrays.asList(woorden));
        System.out.println(String.join(", ", lijstString));
        elementenMetOnevenIndexVerwijderen((List<?>) lijstString);

        weergevenLijst("oplossing: aaa ccc eee", lijstString);
        
        weergevenLijstOmgekeerdeVolgorde("oplossing: eee ccc aaa", lijstString);

    }

    public void metEenVerhogen(List<Integer> lijst) {
        for (int i = 0; i < lijst.size(); i++) {
            lijst.set(i, lijst.get(i) + 1);
        }
    }

    
    //generieke methode:
    public void elementenMetOnevenIndexVerwijderen(List<?> lijst) {
        //Alle elementen, met oneven index, verwijderen (enkel met een iterator werken)
        //-----------------------------------------------------------------------------
        ListIterator<?> iter = lijst.listIterator();
        boolean remove = false;
        while(iter.hasNext()){
            iter.next();
            if(remove){
                iter.remove();
                remove = false;
            } else {
                remove = true;
            }
        }
    }
    
    public void elementenToevoegenNaOnevenGetallen(List<Integer> lijst) //-----------
    //Na ieder oneven getal wordt hetzelfde getal+2 toegevoegd in de Lijst
    //vb. 5 10 13 wordt 5 7 10 13 15
    //---------------------------------------------------
    {
        ListIterator<Integer> iter = lijst.listIterator();
        while(iter.hasNext()){
            Integer huidigGetal = iter.next();
            if(huidigGetal % 2 != 0){
                iter.add(huidigGetal + 2);
            }
        }
    }


    public void weergevenLijst(String oplossing, Collection<String> lijst) {
        System.out.printf("%s%n%s", oplossing, "           ");
        for (String element : lijst) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
    
    public void weergevenLijst(String oplossing, List<Integer> lijst) {
        System.out.printf("%s%n%s", oplossing, "           ");
        for (int element : lijst) {
            System.out.printf("%d ", element);
        }
        System.out.println();
    }
    
    //generieke methode:
    public void weergevenLijstOmgekeerdeVolgorde(String oplossing, List<String> lijstString) {
    // Alle elementen van de List<Integer> in omgekeerde volgorde weergeven 
    //--------------------------------------------------------------------------------------
       System.out.printf("%s%n%s", oplossing, "           ");
        ListIterator<?> li = lijstString.listIterator(lijstString.size());
        while (li.hasPrevious()) {
            System.out.printf("%s ", li.previous());
        }

        System.out.println();
       
       System.out.println();
    }

    public static void main(String args[]) {
        new OefLinkedList();
    }
}
