package domein;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import persistentie.VliegmaatschappijMapper;

public class DomeinController {
	private final VliegmaatschappijRepository vliegmijRepository;

	public DomeinController() {
		this.vliegmijRepository = new VliegmaatschappijRepository();
	}

	public String geefAirlines() {
		
		return null;

	}

	private String zetLijstOmNaarString(List<Vliegmaatschappij> lijst) {
		return null;
		}

	public List<String> geefAlleAirlinesMetMinstensAantalPartners(int aantal) {
		return null;	}

	public String geefAirlinesAlfabetischGesorteerd() {
		return null;}

	public String geefAirlinesGesorteerdVolgensAantalPartners() {
		return null;}

	public String geefAirlinesAantalKeerPartner() {
		return null;
	}
	
	public String geefEersteAirlineStartendMet(String woord) {
		return null;	}
	
	public Vliegmaatschappij geefEenAirlineMetPartner(String partner) {
		return null;}
	
	
}
