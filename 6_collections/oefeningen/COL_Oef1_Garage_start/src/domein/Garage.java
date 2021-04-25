package domein;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Garage {
	private List<Onderhoud> onderhoudLijst;

	// implementeer:
	// stop alle onderhouden (~parameter) in het attribuut onderhoudLijst
	public Garage(Collection<Onderhoud> onderhouden) {
		// FIXME onderhouden direct in constructor
		onderhoudLijst = new ArrayList<Onderhoud>(onderhouden);
	}

	public Collection<Auto> geefAutosVoorOnderhoud() {
		/* modeloplossing
		Set<Auto> result = new TreeSet<>();
		for (Onderhoud onderhoud : onderhoudLijst) {
			result.add(onderhoud.getAuto());
		}
		*/
		return onderhoudLijst
				.stream()
				.map(Onderhoud::getAuto)
				.collect(Collectors.toSet());
	}

	public Collection<Onderhoud> getOnderhoudLijst() {
		return onderhoudLijst;
	}

	// implementeer:
	// sorteer de onderhoudLijst op Auto (natuurlijk ordening op nummerplaat)
	// vervolgens sorteer je voor gelijke auto's op begindatum van het onderhoud
	public void sorteerOnderhoudLijst() {
		// FIXME then comparing with immediate method reference not working
		Collections.sort(onderhoudLijst, Comparator.comparing(Onderhoud::getAuto).thenComparing(Comparator.comparing(Onderhoud::getBegindatum)));
	}

	// implementeer:
	// - indien je dit nog niet deed, implementeer dan eerst de methode
	// isAangrenzendMet in de klasse Onderhoud
	// - roep de hulpmethode sorteerOnderhoudLijst aan om de onderhoudLijst
	// eerst te sorteren, en
	// - voeg dan alle aangrenzende onderhouden samen tot 1 onderhoud
	public void voegAangrenzendeOnderhoudenSamen() {
		sorteerOnderhoudLijst();
		/* modeloplossing
		for (int index = 0; index < onderhoudLijst.size() - 1; index++) {
			if (onderhoudLijst.get(index).isAangrenzendMet(onderhoudLijst.get(index + 1))) {
				onderhoudLijst.get(index).setEinddatum(onderhoudLijst.get(index + 1).getEinddatum());
				onderhoudLijst.remove(index + 1);
				index--;
			}
		}
		*/

		ListIterator onderhoudsIterator = onderhoudLijst.listIterator();
		ArrayList newOnderhoudsList = new ArrayList();
		Onderhoud previousOnderhoud;
		Onderhoud nextOnderhoud;
		LocalDate start;
		LocalDate end;

		if (onderhoudsIterator.hasNext()) {
			previousOnderhoud = (Onderhoud) onderhoudsIterator.next();
			start = previousOnderhoud.getBegindatum();
			end = previousOnderhoud.getEinddatum();
			while (onderhoudsIterator.hasNext()) {
				nextOnderhoud = (Onderhoud) onderhoudsIterator.next();
				if(previousOnderhoud.isAangrenzendMet(nextOnderhoud)){
					end = nextOnderhoud.getEinddatum();
				} else {
					newOnderhoudsList.add(new Onderhoud(start,end,previousOnderhoud.getAuto()));
					previousOnderhoud = nextOnderhoud;
					start = previousOnderhoud.getBegindatum();
					end = previousOnderhoud.getEinddatum();
				}
			}
		}




		onderhoudLijst = newOnderhoudsList;
	}
}
