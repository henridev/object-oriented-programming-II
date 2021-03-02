package domeinArtCollection;

import java.math.BigDecimal;

public class Boot extends Voertuig {
	@Override
    public void draw() {
        System.out.printf("Tekening van Boot.%n");
    }
	
	@Override
    public BigDecimal cost() {
        System.out.printf("Een boot is maar een voorwerp.%n");
        return BigDecimal.valueOf(100);
    }
}
