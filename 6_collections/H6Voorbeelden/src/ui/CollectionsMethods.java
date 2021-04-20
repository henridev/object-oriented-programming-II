package ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsMethods {
//tag::coll[]
	private static final String SUITS[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
	
	public void start() {
		List<String> list = Arrays.asList(SUITS);
		
		Collections.sort(list); // <1>
		System.out.printf("Sorted array elements:%n%s%n", list);
		for (String i : SUITS)
			System.out.printf("%s%n", i);

		Collections.sort(list, Collections.reverseOrder()); // <2>

		Collections.shuffle(list); // schud door elkaar		// <3>
	}
//end::coll[]
}
