package ui;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {
	private static final String COLORS[] = { "red", "white", "blue", "green", "gray", "orange", "tan", "white", "cyan",
			"peach", "gray", "orange" };

	public SetTest() {
		List<String> list = Arrays.asList(COLORS);
		System.out.printf("ArrayList: %s%n", list);
		printNonDuplicates(list);
	}
//tag::set[]
	private void printNonDuplicates(Collection<String> collection) {
		// een HashSet creëren
		Set<String> set = new HashSet<>(collection);

		System.out.println("\nNonduplicates are: ");
		for (String s : set)
			System.out.printf("%s ", s);
		System.out.println();
	}
//end::set[]

	public static void main(String args[]) {
		new SetTest();
	}
}
