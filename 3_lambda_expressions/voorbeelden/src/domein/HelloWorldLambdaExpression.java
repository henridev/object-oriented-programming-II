package domein;

import java.util.function.Function;

//tag::codeExample[]
public class HelloWorldLambdaExpression {
  
	@FunctionalInterface // <1>
    interface HelloWorld {
		public void greetSomeone(String someone);
    }
  
    public void sayHello() {
        
//tag::codeExampleDutchGreeting[]
        HelloWorld dutchGreeting = (String someone) -> { // <2>
        	String name = someone;
        	System.out.println("Hello " + name); 
        };
//end::codeExampleDutchGreeting[]
        
        dutchGreeting.greetSomeone("Pete");
    }

    public static void main(String[] args) {
        HelloWorldLambdaExpression myApp =
            new HelloWorldLambdaExpression();
        myApp.sayHello();
    }            
}
//end::codeExample[]
