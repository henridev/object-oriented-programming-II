package domein;

import java.util.ArrayList;
import java.util.List;

public class DomeinController {
	private final RekeningRepository rr;
	private final KostenRepository kr;
	
	public DomeinController(KostenRepository kr){
		this.kr = kr;
		rr = new RekeningRepository();
	}

	public String geefRekeningen(){
		List<Rekening> lijst = rr.geefGewijzigdeRekeningen();
		String uitvoer = "";
		for (Rekening r : lijst) uitvoer += String.format("%s%n", r/*.toString()*/);
		return uitvoer;
	}
	
	public String geefCodes(){
		List<Rekening> lijst = rr.geefGewijzigdeRekeningen();
		String uitvoer = "";
		for (Rekening r : lijst) uitvoer += String.format("%s%n", r.geefCode());
		return uitvoer;
	}

	public List<String> geefTitelsSBeheersKosten(){
		List<BeheerKost> beheerskosten = kr.getKostenLijst();
		List<String> titelLijst = new ArrayList<String>();
		for (BeheerKost k: beheerskosten){
			String houder = k.getHouder();
			titelLijst.add(k instanceof Kluis ?
					k.toString() :
					String.format("%s, houder = %s", k instanceof ZichtRekening ? "zichtrekening" : "spaarrekening", houder)
			);
		}
		return titelLijst;
	}

	public String geefDetailsBeheersKost(int i){
		BeheerKost beheerskost = kr.geefBeheerKost(i);
		return beheerskost.toString();
	}

	public double geefBeheersKostenWaarde(int i){
		BeheerKost beheerskost = kr.geefBeheerKost(i);
		return beheerskost.geefJaarlijkseKost();
	}
	
}
