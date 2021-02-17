
package domein;

import java.util.Comparator;


public class ContainerByOwnerSorter implements Comparator<Container> {
    public int compare(Container c1, Container c2) {
    	String eigenaar1 = c1.getEigenaar();
		String eigenaar2 = c2.getEigenaar();
        return eigenaar1.compareTo(eigenaar2);
    }
}