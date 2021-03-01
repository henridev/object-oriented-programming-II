package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Kosten;
import domein.Ticket;
import domein.VerplaatsingPerAuto;
import domein.VerplaatsingPerBusTram;

public class KostenMapper {
	private List<Kosten> kosten;
	private int ticketCount = 0, verplaatsingCountAuto = 0, verplaatsingCountOpenbaar = 0;
	
	public int getTicketCount() {
		return ticketCount;
	}

	public int getVerplaatsingCountAuto() {
		return verplaatsingCountAuto;
	}

	public int getVerplaatsingCountOpenbaar() {
		return verplaatsingCountOpenbaar;
	}

	public KostenMapper() {
		kosten = new ArrayList<Kosten>();
	}
	
	public void addCost(Kosten c) {
		 if (c instanceof Ticket) {ticketCount ++; } 
		 else if(c instanceof VerplaatsingPerAuto) {verplaatsingCountAuto++;} 
		 else if(c instanceof VerplaatsingPerBusTram) {verplaatsingCountOpenbaar++;}
		 kosten.add(c);
	}
	
	public List<Kosten> getCosts() {
		return kosten;
	}
}
