package ui;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// tag::flat[]
public class VbFlatmap {
	public static void main(String[] args) {

		List<List<String>> namesNested = 
				Arrays.asList(Arrays.asList("Jeff", "Bezos"), Arrays.asList("Bill", "Gates"),Arrays.asList("Mark", "Zuckerberg"));
		System.out.println(namesNested);

		List<String> namesFlatStream = 
				namesNested.stream()
						   .flatMap(Collection::stream) // <1>
						   .collect(Collectors.toList());
		System.out.println(namesFlatStream);
	}
}
// end::flat[]
