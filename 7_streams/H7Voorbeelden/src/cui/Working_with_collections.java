package cui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class Working_with_collections {

    public static void main(String[] args) 
    {
//tag::for[]
        String[] friendsArray = {"Brian","Nate","Neal","Sara","Betty"};
        List<String> friends = new ArrayList<>(Arrays.asList(friendsArray));
        
        for(String name : friends)
            System.out.println(name);
        System.out.println();
        
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(String t)
            {
                System.out.println(t);
            }
        });
        System.out.println();
//end::for[]
        
        
        for(int index=0 ; index < friends.size() ; index++)
            System.out.println(friends.get(index));
        System.out.println();
        
//tag::forLambda[]       
        friends.forEach((String t) -> { System.out.println(t);});
        System.out.println();

        friends.forEach( t -> System.out.println(t));
        System.out.println();
        
        friends.forEach( System.out::println);
        System.out.println();
//end::forLambda[]
    }

}
//gebruikt Iterator-interface, en roept zijn hasNext() en next() methodes

//in JDK8 werd Iterator-interface uitgebreid met forEach(), 
//die een parameter van het type Consumer krijgt
