package ui;

import domeinFiguren.Rechthoek;
import domeinFiguren.Vierkant;

//tag::codeExample[]
public class VierkantApp {
	public static void main( String args[]) {
		// Dit statement instantieert een Vierkant en kent
		// de referentie toe aan ref_1   
		Vierkant ref_1 = new Vierkant("Vierkant 1");

		// Aangezien Rechthoek de superklasse is
		// van Vierkant kan de superklasse referentie
		// ref_2 verwijzen naar een instantie van Vierkant
		Rechthoek ref_2 = new Vierkant("Vierkant 2"); // <1>
       
		// Een referentie van een superklasse kan niet direct 
		// toegekend worden aan een referentie van een subklasse.
		// Expliciet casten is nodig! 
		if (ref_2 instanceof Vierkant) {
       		Vierkant ref_3 = (Vierkant) ref_2; // <2>
       	}
   }
}
//end::codeExample[]
