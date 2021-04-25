package ui;

import java.util.*;

public class KleineOefeningenList {

    private static final String COLORS[] = {"red", "white", "blue"};

    
    //declareer list en list2 van type List. De collections zullen Strings bijhouden.
    //------------------------------------------------------------------------------
    public KleineOefeningenList() {
        List<String> list = new ArrayList<String>(Arrays.asList("red", "white", "blue"));


        // cre�er arrayList list en vul op met { "red", "white", "blue" }  (= 1 instructie)
        // Voeg "green" op het einde van de arrayList toe
        // Voeg "green" toe op index 2
        //----------------------------------------------------
        list.add("green");
        list.add(2, "green");
        weergevenLijst("oplossing: red white green blue green", list);
//


        //verwijder het tweede element
        //---------------------------
        list.remove(1);
        weergevenLijst("oplossing: red green blue green", list);

        //verwijder de string "green"
        //---------------------------------
        list.remove("green");
        weergevenLijst("oplossing: red blue green", list);

        //Geef het tweede element weer op het scherm d.m.v. printf
        //--------------------------------------------------------
        //Komt "blue" weer in de arrayList
        //-----------------------------------------------
        System.out.printf("%s%n",list.get(1));
        System.out.println("oplossing: blue komt voor");
        /*
   	if (                  )
   		System.out.println("           blue komt voor\n");
   	else
   		System.out.println("           blue komt niet voor\n");

         */

        //wijzig het derde element naar de string "yellow"
        //------------------------------------------------
        list.set(2, "yellow");
        weergevenLijst("oplossing: red blue yellow", list);

        // cre�er een tweede lege arrayList (list2)
        //-------------------------------------------
        List<String> list2 = new ArrayList<>(list);
        
        //alle elementen van list kopi�ren naar een tweede arrayList list2 (= 1 instructie)
        //---------------------------------------------------------------------------------
        
        // is list = list2 ?
        //------------------
        System.out.println(list.equals(list2) ? "equal" : "unequal");
        System.out.println("Oplossing : idem");
        /*
   	if (              )
   			System.out.println("            idem\n");
   	else
   			System.out.println("            niet idem\n");
         */

        naarHoofdletterOmzetten(list);
        weergevenLijst("oplossing: alle elementen van list in hoofdletters", list);

        naarKleineLettersOmzetten(list);
        weergevenLijst("oplossing: alle elementen van list in kleine letters", list);

   } // end constructor

   public void weergevenLijst(String oplossing, List<String> list) {
        //Geef alle elementen van de list weer (laat een spatie tussen elk element).
        //Gebruik printf*/
        //--------------------------------------------------------------------------
        System.out.printf("%s%n%s%s", oplossing, "resultaat: ", String.join(" ", list));

        
        System.out.println("\n");

    }

    public void naarHoofdletterOmzetten(List<String> list) {
        //Alle strings van list worden omgezet naar hoofdletters
        //-------------------------------------------------------------
        list.replaceAll(String::toUpperCase);
    }

    public void naarKleineLettersOmzetten(List<String> list){
       ////De strings van list worden omgezet naar kleine letters en worden
        //als nieuwe List<String> teruggegeven.  
       //-------------------------------------------------------------
        list.replaceAll(String::toLowerCase);
    }

    public static void main(String args[]) {
        new KleineOefeningenList();
    }

} // end class KleineOefeningenList_Opgave
