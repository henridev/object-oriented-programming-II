package domeinArtCollection;

import java.math.BigDecimal;

//tag::codeExample[]
public class Auto extends Voertuig {
	@Override
    public void draw() {
        System.out.printf("Tekening van Auto.%n");
    }
	
	@Override
    public BigDecimal cost() {
        System.out.printf("Een auto is maar een voorwerp.%n");
        return BigDecimal.valueOf(100);
    }
}
//end::codeExample[]
