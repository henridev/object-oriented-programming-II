package ui;

//tag::codeExample[]
public class DynamicBindingTest {
    public static void main(String args[]) {
        Voertuig voertuig;
                
        voertuig = new Voertuig(); 
        voertuig.start();
        
        voertuig = new Auto(); 
        voertuig.start(); 
    }
}

class Voertuig {
	public void start() {
        System.out.println("Inside start method of Vehicle");
    }
}

class Auto extends Voertuig {
    @Override
    public void start() {
        System.out.println("Inside start method of Car");
    }
}
//end::codeExample[]