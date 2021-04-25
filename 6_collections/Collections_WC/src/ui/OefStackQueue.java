package ui;
import java.util.*;
/*
Maak gebruik van Scanner om 10 woorden in te lezen
Plaats de woorden op een stack en een queue.
Druk dan de woorden in 2 kolommen (20 breed) af,
eerste kolom uit stack, tweede uit queue
VB:
invoer --> een twee drie vier vijf zes zeven acht negen tien

uitvoer -->
               Stack               Queue       

                tien                 een                
               negen                twee                
                acht                drie                 
               zeven                vier               
                 zes                vijf                
                vijf                 zes                
                vier               zeven                
                drie                acht                
                twee               negen                 
                 een                tien               


*/

public class OefStackQueue
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);

		//definieer stack en queue 
		Stack<String> stack = new Stack<>();
		Queue<String> queue = new ArrayDeque<>();


		//lees woord per woord en plaats in de 2 containers
		for (int i = 0; i < 10; i++) {
			String input = in.next();
			stack.push(input);
			queue.offer(input);
		}


	  	//druk hoofding
		System.out.printf("%20s%20s%n%n", "Stack", "Queue");
                
	  	//zolang containers niet leeg, druk een regel met betreffende woorden
		while (!stack.isEmpty()){
			System.out.printf("%20s%20s%n", stack.pop(), queue.poll());
		}
	}
}