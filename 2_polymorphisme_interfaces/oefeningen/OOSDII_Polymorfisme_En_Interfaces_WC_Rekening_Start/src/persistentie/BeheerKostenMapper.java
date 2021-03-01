package persistentie;

import java.util.*;
import domein.*;

public class BeheerKostenMapper {

	public List<BeheerKost> geefRekeningen(){
		List<BeheerKost> beheerskosten = new ArrayList<>();

		Kluis k1, k2;
		SpaarRekening s1;
		ZichtRekening z1;

		k1 = new Kluis(1, "Piet");
		k2 = new Kluis(2, "Dominique");
		s1 = new SpaarRekening(202L, "Louis");
		z1 = new ZichtRekening(303L, "Henri", -50);

		beheerskosten.add(k1);
		beheerskosten.add(k2);
		beheerskosten.add(s1);
		beheerskosten.add(z1);

		return beheerskosten;
	}
}
