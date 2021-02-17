package domein;

import java.util.Comparator;


public class ContainerByMassSorter implements Comparator<Container> {
    public int compare(Container c1, Container c2) {
    	int mas1 = c1.getMassa();
		int mas2 = c2.getMassa();
        return mas1 == mas2 ? 0 : mas1 < mas2 ? -1 : 1;
    }
}