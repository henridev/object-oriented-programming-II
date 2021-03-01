package domein;

import java.util.List;

import persistentie.KostenMapper;

public class KostenRepository {
	public KostenRepository(KostenMapper km) {
		super();
		this.km = km;
		this.lijstje = km.getCosts();
	}

	private KostenMapper km;
	private List<Kosten> lijstje;
	
	
	public String geefOverzichtAantalDocumenten() {
	   this.lijstje = km.getCosts();
	   int ticketCount = km.getTicketCount(), 
		   verplaatsingCountAuto = km.getVerplaatsingCountAuto(), 
		   verplaatsingCountOpenbaar = km.getVerplaatsingCountOpenbaar();

		String text = String.format("Volgende documenten werden ingediend: %n"
				+ "%d ticket(s), %d verplaatsing(en) per auto "
				+ "en %d verplaatsing(en) per bus/tram.", ticketCount, verplaatsingCountAuto, verplaatsingCountOpenbaar);
		return text;

	}
	
	public String geefKostenLijst() {
		this.lijstje = km.getCosts();
		String rijen = String.format("%n%nOverzicht gemaakte kosten %n%n"); 
		rijen += String.format("%100s%15s%n", "Kostenpost", "Bedrag");
		double totalCost = 0;
		for (Kosten item : lijstje) {
			   String row = "";
			   double prijs = item.berekenPrijs();
			   totalCost += prijs;
			   if (item instanceof Ticket) {
				  row += String.format("%100s%13.2f%n", 
						  ((Ticket) item).getOmschrijving(), 
						  prijs);
			   } else  {
				  row += String.format("%100s%13.2f%n", 
						  item.toString(), 
						  prijs - (prijs * 0.21));
			   }
			   rijen += row;
	    };
		String eindBerekening = String.format("Totaal gedeclareerde kosten = %5.2f", totalCost);
		return rijen + String.format("\n\n") + eindBerekening;
	}
}
