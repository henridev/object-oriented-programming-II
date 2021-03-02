package domein;

import java.util.function.Predicate;

//tag::codeExample[]
public class PredicateTest { 
	public static void pred(int number, Predicate<Integer> predicate) 
    { 
		// Voer de Predicate uit op het eerste argument number
		if (predicate.test(number)) { 
			System.out.printf("De voorwaarde op nummer %d is waar.%n", number);
        } else {
        	System.out.printf("De voorwaarde op nummer %d is fout.%n", number);
        }
    } 
	
    public static void main(String[] args) 
    { 
        // Predicate met voorwaarde "< 18"
        Predicate<Integer> lessThen18 = i -> (i < 18);	// <1>
  
        // Test de voorwaarde  
        System.out.println(lessThen18.test(10));  
        
        // Predicate met voorwaarde "> 12"
        Predicate<Integer> greaterThen12 = (i) -> i > 5; 
        
        // Test de voorwaarde  
        System.out.println(greaterThen12.test(10));
        
        // Samengestelde predicate 
        Predicate<Integer> lessThen18AndGreaterThen12 = lessThen18.and(greaterThen12);  
       
        boolean result = lessThen18AndGreaterThen12.test(16); // <2> 
        System.out.println(result); 
  
        // Negatie van een Predicate
        boolean result2 = lessThen18AndGreaterThen12.negate().test(16); // <3> 
        System.out.println(result2); 
        
        //passing Predicate into function
        pred(10, (i) -> i > 7);
        
        // OR Predicate
        Predicate<String> hasLengthOf10 = t -> t.length() > 10;
        Predicate<String> containsLetterA = p -> p.contains("A"); 
        String containsA = "And"; 
        
        boolean outcome = hasLengthOf10.or(containsLetterA).test(containsA); // <4> 
        System.out.println(outcome); 
    } 
} 
//end::codeExample[]