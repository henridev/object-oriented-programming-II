package ui;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {
//tag::sorted[]
	private static final String NAMES[] = { "yellow", "green", "black", "tan", "grey", "white", "orange", "red","green" };

	public SortedSetTest() {
		SortedSet<String> tree = new TreeSet<>(Arrays.asList(NAMES));
		System.out.println("sorted set: ");
		printSet(tree);

		// alle elementen die < zijn dan element "orange"
		System.out.print("\nheadSet (\"orange\"):  ");
		printSet(tree.headSet("orange"));

		// alle elementen die >= zijn dan element "orange"
		System.out.print("tailSet (\"orange\"):  ");
		printSet(tree.tailSet("orange"));

		// het eerste en het laatste element
		System.out.printf("first: %s%n", tree.first());
		System.out.printf("last : %s%n", tree.last());
	}


	private void printSet(SortedSet<String> set) {
		for (String s : set)
			System.out.printf("%s ", s);
		System.out.println();
	}
	
//end::sorted[]
	public static void main(String args[]) {
		new SortedSetTest();
	}

}
