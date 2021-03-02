package domein;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//tag::codeExample[]
public class ConsumerAccept { 
    public static void main(String args[]) 
    { 
    	// Consumer to display a number 
        Consumer<Integer> display = a -> System.out.println(a); // <1>
  
        // Implement display using accept() 
        display.accept(10); 
        
    	List<Integer> list = new ArrayList<Integer>(); 
        list.add(2); 
        list.add(1); 
        list.add(3); 
              
        // Consumer to display a number 
        Consumer<List<Integer>> displayList = a -> System.out.println(a); 
  
        // Implement display using accept() 
        displayList.accept(list); 
  
        // Consumer die elk element in een lijst verdubbelt
        Consumer<List<Integer>> addTen = a -> { 
            for (int i = 0; i < list.size(); i++) 
                list.set(i, 2 * list.get(i)); 
        }; 
        
        // Samengestelde Consumer: verdubbel elk element in de lijst en 
        // druk elk element af op het scherm
        addTen.andThen(displayList).accept(list); // <2>
    } 
} 
//end::codeExample[]