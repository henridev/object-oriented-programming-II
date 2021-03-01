package domein;

public class DomeinController {
	private KostenRepository kr;

	public DomeinController(KostenRepository kr) {
		this.kr = kr;
	}
	
	public String geefOverzichtAantalDocumenten() {return kr.geefOverzichtAantalDocumenten();}
		
	public String geefKostenLijst() {return kr.geefKostenLijst();}
	
}
