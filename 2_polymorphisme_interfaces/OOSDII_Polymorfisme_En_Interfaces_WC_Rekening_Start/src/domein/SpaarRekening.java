package domein;

public class SpaarRekening extends Rekening {
	// extra attribuut
	private static double aangroeiIntrest;
	final private double GRENS = 300;
	final private int PERCENTAGE_JAARLIJKSE_AANREKENING = 1;

	public SpaarRekening(long rekeningNr, String houder) 
	{
		super(rekeningNr, houder);
	}
	
	@Override
    public String geefCode() {
        return String.format("SR-%d-%.2f", getRekeningNr(), aangroeiIntrest);
    }

	// getter en setter voor attribuut
	public static double getAangroeiIntrest() 
	{
		return aangroeiIntrest;
	}

	public final static void setAangroeiIntrest(double aangroeiIntrest) {
		if (aangroeiIntrest < 0) throw new IllegalArgumentException("Intrest mag niet negatief zijn!");
		SpaarRekening.aangroeiIntrest = aangroeiIntrest;
	}
	
	// extra (overriden) methodes
	@Override
	public boolean haalAf(double bedrag) {
		double saldo = super.getSaldo();
		return bedrag <= saldo ?super.haalAf(bedrag) : false;
	}

	@Override
	public String toString()
	{
		return String.format("%s. Aangroeiintrest = %.2f%%", super.toString(), aangroeiIntrest);
	}

	@Override
	public double geefJaarlijkseKost() { return this.getSaldo() < 300 ? 0.05 * (300 - this.getSaldo()) : 0; }
}
