package ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//tag::else[]
public class VbOrElse {
	public static void main(String[] args)
    {
        List<String> names = Arrays.asList("Brad" , "Kate" , "Kimmy", "Jack" , "Joey");
        
        String eersteNaamMet3Letters = 
                names.stream()
                     .filter(name -> name.length()==3)
                     .findFirst()
                     .get(); // <1>
        System.out.println(eersteNaamMet3Letters);
        
        String eersteNaamMet3Letters2 = 
                names.stream()
                     .filter(name -> name.length()==3)
                     .findFirst()
                     .orElse("Geen naam met 3 letters"); // <2>
              
        System.out.println(eersteNaamMet3Letters2);
    }
}
//end::else[]
