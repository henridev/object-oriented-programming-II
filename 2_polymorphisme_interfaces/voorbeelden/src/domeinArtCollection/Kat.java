package domeinArtCollection;

import java.math.BigDecimal;

public final class Kat extends Huisdier {
    private int aantalLevens;

    public Kat(String naam, int aantalLevens) {
        super(naam);
        setAantalLevens(aantalLevens);
    }

    public int getAantalLevens() {
        return aantalLevens;
    }

    private void setAantalLevens(int aantalLevens) {
        this.aantalLevens = aantalLevens;
    }
    
    @Override
    public String maakGeluid(){
    	return "Miauw";
    }
    
    public String spin(){
        return "Spin, spin...";
    }
    
    @Override
    public void draw() {
        System.out.printf("Tekening van kat.%n");
    }
    
    @Override
    public BigDecimal cost() {
        System.out.printf("Een kat is onbetaalbaar.%n");
        return BigDecimal.valueOf(1000000);
    }
}
