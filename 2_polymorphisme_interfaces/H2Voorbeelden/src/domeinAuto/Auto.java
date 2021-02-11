package domeinAuto;

//tag::codeExample[]
public class Auto {
	private Motor motor;
	
	public Auto(Motor motor) {
		setMotor(motor);
	}
	
	public void start() {
		motor.start();
	}
	
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
}
//end::codeExample[]
