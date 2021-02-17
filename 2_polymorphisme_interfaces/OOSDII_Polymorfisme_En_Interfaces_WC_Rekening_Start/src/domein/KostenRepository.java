package domein;

import persistentie.BeheerKostenMapper;

import java.util.List;

public class KostenRepository {
    private final BeheerKostenMapper bkm = new BeheerKostenMapper();
    private List<BeheerKost> kostenLijst;

    public KostenRepository() {
        setKostenLijst(bkm.geefRekeningen());
    }

    public BeheerKost geefBeheerKost(int i) {
        return kostenLijst.get(i);
    }

    public List<BeheerKost> getKostenLijst() {
        return kostenLijst;
    }

    public void setKostenLijst(List<BeheerKost> kostenLijst) {
        this.kostenLijst = kostenLijst;
    }
}
