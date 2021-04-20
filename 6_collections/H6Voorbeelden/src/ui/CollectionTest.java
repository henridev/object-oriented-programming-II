package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollectionTest 
{
	private static final String[] COLORS = { "MAGENTA", "RED", "WHITE", "BLUE", "CYAN" };
	private static final String[] REMOVECOLORS = { "RED", "WHITE", "BLUE" };

	public void start() 
	{
		List<String> list = new ArrayList<>(Arrays.asList(COLORS));

		List<String> removeList = new ArrayList<>(Arrays.asList(REMOVECOLORS));

		// afdrukken
		// ----------
		System.out.println("ArrayList volledig vanaf begin: ");
		printListVanafBegin(list);
		System.out.println("ArrayList volledig vanaf einde: ");
		printListVanafEinde(list);
		
		
		// verwijder alle strings uit "list" die in "removeList" voorkomen
		removeColors(list, removeList);

		// opnieuw afdrukken
		System.out.println("\n\nArrayList na removeColors: ");
		printListVanafBegin(list);
		
		voegToeColors(list);
		printListVanafBegin(list);

	} // end CollectionTest constructor

	private void voegToeColors(List<String> lijst) {
//tag::listiterator_add[]
		ListIterator< String > iterator = lijst.listIterator();
		 while ( iterator.hasNext()) 
		 {
			 String huidig = iterator.next();
			 if(huidig.startsWith("M"))
			 	iterator.add(huidig);
		 }
//end::listiterator_add[]
	
	}

	private void printListVanafBegin(Collection<String> collection) 
	{
		//1. met enhanced for
//tag::enhanced[]
		// <1>
		for (String color : collection) 
			System.out.printf("%s ", color);
		System.out.println();
//end::enhanced[]

		// OF
		//2. met iterator
//tag::iterator[]
		// <2>
		 Iterator< String > iterator = collection.iterator();
		 while ( iterator.hasNext() )
			 System.out.printf( "%s ", iterator.next() );
		 System.out.println();
//end::iterator[]
	}//einde print
	
	
	private void printListVanafEinde(List<String> lijst) 
	{
//tag::vanafEinde[]
		ListIterator< String > iterator = lijst.listIterator(lijst.size());
		 while ( iterator.hasPrevious() )
			 System.out.printf( "%s ", iterator.previous());
		 System.out.println();
//end::vanafEinde[]
	}



	// verwijder alle strings uit "collection1" die in
	// "collection2" voorkomen
//tag::iterator_remove[]
	private void removeColors(Collection<String> collection1, Collection<String> collection2) {
		// 1. met iterator
		Iterator<String> iterator = collection1.iterator();
		while (iterator.hasNext())
			if (collection2.contains(iterator.next()))
				iterator.remove(); 
//end::iterator_remove[]
		//OF
		//collection1.removeAll(collection2);
	} // end method removeColors


} // end class CollectionTest
