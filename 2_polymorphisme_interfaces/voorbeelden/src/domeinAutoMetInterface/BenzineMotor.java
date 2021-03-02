package domeinAutoMetInterface;

//tag::codeExample[]
public class BenzineMotor implements Motor {

	@Override
	public void start() {
		System.out.println("Gedrag van een benzine motor");
	}
}
//end::codeExample[]
