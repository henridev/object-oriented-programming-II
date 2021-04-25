package domein;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DomeinController {
	private final Repository repo;

	public DomeinController() {
		this.repo = new Repository();
	}
	
	public <E> String[] geefLijstTerugArrayVanString (List<E> lijst) {
		return lijst.stream()
					.map(element -> element.toString())
					.toArray(String[]::new);
	}
	
	public <E> List<String> geefCollectieTerugAlsLijstVanString (Collection<E> lijst) {
		return lijst.stream()
					.map(element -> element.toString())
					.collect(Collectors.toList());
	}
	
	public List<String> geefOverzicht() {
		return geefCollectieTerugAlsLijstVanString(repo.getLijstStripFiguren());
	}

	public List<String> geefOverzichtGesorteerdOpNaam() {
		return geefCollectieTerugAlsLijstVanString(repo.getLijstStripFigurenGesorteerdOpNaam());
	}

	public List<String> geefOverzichtGesorteerdOpAflopendeGrootte() {
		return geefCollectieTerugAlsLijstVanString(repo.getLijstStripFigurenGesorteerdOpAflopendeGrootte());
	}

	public List<String> haalDubbelsEruit() {
		return geefCollectieTerugAlsLijstVanString(repo.haalDubbelsEruit());
	}

	public void voegStripFiguurToe(String naam, double grootte) {
		repo.voegStripFiguurToe(naam,grootte);		
	}
	
	public void voegExtraStripfigurenToe() {
		repo.voegExtraStripfigurenToe();
		
	}

	public List<String> pick3() {
		return geefCollectieTerugAlsLijstVanString(repo.pick3());
	}




	

}
