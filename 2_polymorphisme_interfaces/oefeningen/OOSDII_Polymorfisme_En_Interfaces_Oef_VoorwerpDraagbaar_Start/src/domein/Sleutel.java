package domein;

public class Sleutel extends Voorwerp {

    private int deur;
    private static int aantalInOmloop;

    public Sleutel(String naam, double gewicht, int niveau, int deur) {
        super(naam, gewicht, niveau);
        setDeur(deur);
        aantalInOmloop++;
    }

    public final void setDeur(int deur) {
        if (deur < 0) {
            throw new IllegalArgumentException("Deur moet een positief getal zijn!");
        }

        this.deur = deur;
    }

    public int getDeur() {
        return deur;
    }

    public static int getAantalInOmloop() {
        return aantalInOmloop;
    }

    public static void setAantalInOmloop(int aantalInOmloop){
        Sleutel.aantalInOmloop = aantalInOmloop;
    }
    
    public boolean pastOp(int deur) {
        return this.deur == deur;
    }

    @Override
    public String toString() {
        return String.format("%s past op deur %d.%nEr zijn %d sleutel(s) in omloop.",
                super.toString(), deur, aantalInOmloop);
    }

}
