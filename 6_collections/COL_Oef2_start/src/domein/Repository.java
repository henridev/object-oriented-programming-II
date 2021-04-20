package domein;

import java.util.*;
import java.util.stream.Collectors;

import persistentie.StripFiguurMapper;

public class Repository {
	private final List<StripFiguur> lijstStripFiguren;
	private final StripFiguurMapper mapper;

	public Repository() {
		this.mapper = new StripFiguurMapper();
		this.lijstStripFiguren = new ArrayList(Arrays.asList(this.mapper.geefStripfiguren()));
	}
	
	public List<StripFiguur> getLijstStripFiguren() {
		return lijstStripFiguren;
	}
	
	public List<StripFiguur> getLijstStripFigurenGesorteerdOpNaam() {
		return  lijstStripFiguren;
	}


	public List<StripFiguur> getLijstStripFigurenGesorteerdOpAflopendeGrootte() {
		lijstStripFiguren.sort((Comparator.comparingDouble(StripFiguur::getGrootte)));
		return lijstStripFiguren;
	}

	public Set<StripFiguur> haalDubbelsEruit() {
		return new HashSet<>(lijstStripFiguren);
	}
	
	public List<StripFiguur> pick3() {
		List<StripFiguur> copy = new ArrayList<StripFiguur>(lijstStripFiguren);
		Collections.shuffle(copy);
		return copy.subList(0,3);
	}

	public void voegStripFiguurToe(String naam, double grootte) {
		this.lijstStripFiguren.add(new StripFiguur(naam, grootte));
	}
	
	public void voegExtraStripfigurenToe() {
		List<StripFiguur> extraStripFiguren = new ArrayList(Arrays.asList(this.mapper.geefExtraStripfiguren()));
		this.lijstStripFiguren.addAll(extraStripFiguren);

	}
}
