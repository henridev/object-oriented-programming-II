package domein;

//tag::codeExample[]
public class HelloWorldMethodReference {
  
	@FunctionalInterface
    interface HelloWorld {
		public void greetSomeone(String someone);
    }
  
    public void sayHello() {
    	HelloWorld dutchGreeting = HelloWorldMethodReference::printGreeting; // <1>          
    	dutchGreeting.greetSomeone("Pete");
    }
    
    private static void printGreeting(String name) { // <2>
    	System.out.println("Hello " + name);
    }

    public static void main(String[] args) {
        HelloWorldMethodReference myApp =
            new HelloWorldMethodReference();
        myApp.sayHello();
    }   
}
//end::codeExample[]
