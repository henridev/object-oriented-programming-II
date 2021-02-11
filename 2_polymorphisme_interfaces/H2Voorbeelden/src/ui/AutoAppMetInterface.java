package ui;

import domeinAuto.Auto;
import domeinAuto.BenzineMotor;
import domeinAuto.ElektrischeMotor;

//tag::codeExample[]
public class AutoAppMetInterface {
	public static void main(String[] args) {
		Auto mijnElektrischeAuto = new Auto(new ElektrischeMotor());
		mijnElektrischeAuto.start();
		
		Auto mijnBenzineAuto = new Auto(new BenzineMotor());
		mijnBenzineAuto.start();
		
		// Verbouwing aan mijn benzine auto
		mijnBenzineAuto.setMotor(new ElektrischeMotor());
		mijnBenzineAuto.start();
	}
}
//end::codeExample[]
