package domein;

import java.util.Objects;

public class Auto implements Comparable{
	private String nummerplaat;
	private String merk;
	private String model;

	public Auto(String nummerplaat, String merk, String model) {
		setNummerplaat(nummerplaat);
		setMerk(merk);
		setModel(model);
	}

	public String getMerk() {
		return merk;
	}

	private void setMerk(String merk) {
		this.merk = merk;
	}

	public String getModel() {
		return model;
	}

	private void setModel(String model) {
		this.model = model;
	}

	public String getNummerplaat() {
		return nummerplaat;
	}

	private void setNummerplaat(String nummerplaat) {
		this.nummerplaat = nummerplaat;
	}

	@Override
	public String toString() {
		return String.format(
				"%s %s met nummerplaat %s",
				merk,
				model,
				nummerplaat);
	}

	// Twee auto zijn gelijk als dezelfde nummerplaat hebben
	// Override de methodes equals en hashCode uit Object
	// Zorg ook dat deze klasse de interface Comparable implementeert,
	// auto worden op natuurlijke wijze gesorteerd op nummerplaat (alfabetisch)
	@Override
	public int hashCode() {
		return this.nummerplaat.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Auto) || nummerplaat == null) {
			return false;
		}
		Auto auto = (Auto) o;
		return Objects.equals(nummerplaat, auto.getNummerplaat());
	}

	@Override
	public int compareTo(Object o) {
		return nummerplaat.compareTo(((Auto) o).getNummerplaat());
	}
}
