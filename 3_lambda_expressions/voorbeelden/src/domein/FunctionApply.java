package domein;

import java.util.function.Function;

//tag::codeExample[]
public class FunctionApply {
	public static void main(String args[]) {

		// Function met een Integer als argument en
		// en Double als return type
		Function<Integer, Double> half = a -> a / 2.0;	// <1>

		// Voer de Function methode apply uit met argument 10.
		System.out.println(half.apply(10));
				
		// Maak een samengestelde Function die eerst halveert 
		// en dan verdriedubbelt.
		half = half.andThen(a -> 3 * a);	// <2>

		// Voer de samengestelde Function uit met argument 10
		System.out.println(half.apply(10));		
	}
}
//end::codeExample[]