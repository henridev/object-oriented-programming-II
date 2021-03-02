package domein;

import java.util.function.Supplier;

//tag::codeExample[]
public class SupplierGet { 
    public static void main(String args[]) 
    { 
  
        // This function returns a random value. 
        Supplier<Double> randomValue = () -> Math.random(); 
  
        // Print the random value using get() 
        System.out.println(randomValue.get()); 
    } 
} 
//end::codeExample[]