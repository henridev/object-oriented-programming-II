package domein;

public class Kluis implements BeheerKost{
    final private int JAARLIJKSE_KOST = 29;
    final private int kluisNummer;
    final private String houder;

    public Kluis(int kluisNummer, String houder) {
        this.kluisNummer = kluisNummer;
        this.houder = houder;
    }

    public int getKluisNummer() {
        return kluisNummer;
    }

    public String getHouder() {
        return houder;
    }


    @Override
    public String toString() {
        return String.format("kluisnr = %d, houder = %s", this.getKluisNummer(), this.getHouder()) ;
    }

    @Override
    public double geefJaarlijkseKost() {
        return this.JAARLIJKSE_KOST;
    }
}
