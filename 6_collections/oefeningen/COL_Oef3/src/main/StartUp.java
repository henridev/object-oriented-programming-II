package main;

import domein.DomeinController;
import ui.CryptoGraphieApplicatie;

import java.util.*;

public class StartUp {
	public static void main(String[] args) {
		new CryptoGraphieApplicatie(new DomeinController()).start();
	}	
}


