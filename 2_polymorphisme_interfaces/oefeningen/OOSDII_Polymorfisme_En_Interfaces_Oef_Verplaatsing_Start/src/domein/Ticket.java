package domein;

public class Ticket implements Kosten {
	private String omschrijving;
	private double prijs;
	
	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		if(prijs <= 0) {throw new IllegalArgumentException("ongeldige prijs");}
		this.prijs = prijs;
	}

	public Ticket(String omschrijving, double prijs) {
		super();
		this.setOmschrijving(omschrijving);
		this.setPrijs(prijs);
	}

	public double berekenPrijs(){
		return this.getPrijs();	
	}
	
	@Override
	public String toString() {
		return String.format("%20s%8.2f%", this.getOmschrijving(), this.getPrijs());
	}

}
