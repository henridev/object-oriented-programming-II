package domein;

//tag::codeExample[]
public class HelloWorldLocalClass {
  
	@FunctionalInterface
    private interface HelloWorld { // <1>
        public void greetSomeone(String someone);
    }
  
    public void sayHello() {
        // Local class
        class EnglishGreeting implements HelloWorld { // <2>
            public void greetSomeone(String someone) {
                System.out.println("Hello " + someone);
            }
        }
      
        HelloWorld englishGreeting = new EnglishGreeting(); // <3>

        // Anonymous class
        //tag::codeExampleFrenchGreeting[]
        HelloWorld frenchGreeting = new HelloWorld() { // <4>          
            public void greetSomeone(String someone) {
                System.out.println("Salut " + someone);
            }
        };
        //end::codeExampleFrenchGreeting[]

        englishGreeting.greetSomeone("world"); // <5>
        frenchGreeting.greetSomeone("Fred");
    }

    public static void main(String[] args) {
        HelloWorldLocalClass myApp =
            new HelloWorldLocalClass();
        myApp.sayHello();
    }            
}
//end::codeExample[]
