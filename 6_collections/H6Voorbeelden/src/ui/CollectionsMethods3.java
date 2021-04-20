package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsMethods3 {
//tag::coll3[]
	private static final String COLORS[] = { "red", "white", "yellow", "green", "pink" };
	private List<String> list;

	public CollectionsMethods3() {
		list = new ArrayList<>(Arrays.asList(COLORS));
		Collections.sort(list); // sort the ArrayList
		System.out.printf("Sorted ArrayList: %s%n", list);

		int result = Collections.binarySearch(list, "yellow"); // <1>
		System.out.printf("yellow: %d%n", result);

		result = Collections.binarySearch(list, "purple"); // <2>
		System.out.printf("purple: %d%n", result);
		
		String[] colors = { "red", "white", "yellow"};
		List< String > list = Arrays.asList( colors );

		List< String> arrayList = new ArrayList<>(); 
		arrayList.add( "red" );
		arrayList.add( "green" );

		arrayList.addAll(list);
		
		int frequency = Collections.frequency( arrayList, "red" ); // <3>
		System.out.printf("%n%nFrequency of red in arrayList: %d%n",frequency);
		                                          			    
		                                           							      		             
		// hebben list en arrayList al dan niet gemeenschappelijke
		// elementen:
		boolean disjoint = Collections.disjoint( list, arrayList); // <4>
		System.out.printf( "%nlist and arrayList %s elements in common%n", 
		         ( disjoint ? "do not have" : "have"  ) );
//end::coll3[]
	}
	
}
