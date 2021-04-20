package ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsMethods2 {
//tag::coll2[]
	private Character[] LETTERS = { 'P', 'C', 'M' }, lettersCopy;
	private List<Character> copyList;

	public void start() {
		List<Character> list2 = Arrays.asList(LETTERS); 

		lettersCopy = new Character[3];
		copyList = Arrays.asList(lettersCopy);

		System.out.println("Initial list: ");
		output(list2);

		Collections.reverse(list2); // reverse order // <1>
		System.out.println("\nAfter calling reverse: ");
		output(list2);
		Collections.copy(copyList, list2); // copy List //<2>
		Collections.fill(list2, 'R'); // fill list with R’s // <3>
	}

	private void output(List<Character> listRef) {
		System.out.print("The list is: ");
		for (Character elem : listRef)
			System.out.printf("%s ", elem);

		System.out.printf("%nMax: %s", Collections.max(listRef)); //<4>
		System.out.printf("  Min: %s%n", Collections.min(listRef)); // <5>
	} 
//end::coll2[]
}
