module FXRodeDraadDeel1Startversie {
	exports persistentie;
	exports main;
	exports domein;

	requires javafx.base;
	requires javafx.graphics;
	
	opens gui to javafx.graphics;
}