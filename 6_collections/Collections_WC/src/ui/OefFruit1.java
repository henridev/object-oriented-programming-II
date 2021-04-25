package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OefFruit1 {
    public static void main(String args[]) {
        String arX[] = {"appel", "peer", "citroen", "kiwi"},
               arY[] = {"banaan", "mango", "citroen", "kiwi", "zespri"};

       /* Behandel arX en arY als collections en maak gebruik van de bulkoperaties (addAll, removeAll, ...) om volgende output te leveren:
			 Y - X = {e : e ∈ Y, and e ∉ X}
		In y zit extra [banaan, mango, zespri]
		In x zit extra [appel, peer]
		x en y hebben gemeenschappelijk [citroen, kiwi] */

        List<String> extraY = new ArrayList<>(Arrays.asList(Arrays.copyOf(arY, arY.length)));
        extraY.removeAll(Arrays.asList(arX));
        System.out.println(String.join(", ",extraY));


        List<String> extraX = new ArrayList<>(Arrays.asList(Arrays.copyOf(arX, arX.length)));
        extraX.removeAll(Arrays.asList(arY));
        System.out.println(String.join(", ",extraX));

        List<String> intersection = new ArrayList<>(Arrays.asList(Arrays.copyOf(arY, arY.length)));
        intersection.removeAll(extraX);
        intersection.removeAll(extraY);
        System.out.println(String.join(", ",intersection));
    }
}
