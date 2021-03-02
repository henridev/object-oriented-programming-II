package domeinAutoMetInterface;

//tag::codeExample[]
public class ElektrischeMotor implements Motor {

	@Override
	public void start() {
		System.out.println("Gedrag van een elektrische motor");
	}

}
//end::codeExample[]
