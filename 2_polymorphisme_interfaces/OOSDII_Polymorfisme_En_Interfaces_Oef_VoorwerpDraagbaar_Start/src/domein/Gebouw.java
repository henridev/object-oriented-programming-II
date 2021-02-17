package domein;

public class Gebouw implements Draagbaar {
	private String naam;
	private double height;
	
	public Gebouw(String naam, double height) {
		super();
		this.setNaam(naam);
		this.setHeight(height);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.controlName(naam);
		this.naam = naam;
	}
	
	public void controlName(String name) {
		if(name.length() < 2) throw new IllegalArgumentException("ongeldige naam");
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.controlHeight(height);
		this.height = height;
	}
	
	public void controlHeight(double height) {
		if(height < 3) throw new IllegalArgumentException("gebouw is te klein");
	}

	@Override
	public boolean isDraagbaar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {return String.format("residentie %s met hoogte %4.2f is %sdraagbaar", this.getNaam(), this.getHeight(), this.isDraagbaar() ? "" : "niet ");}
}
