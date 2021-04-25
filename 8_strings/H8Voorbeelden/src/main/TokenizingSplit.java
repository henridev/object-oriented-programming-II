package main;

import java.util.Scanner;


public class TokenizingSplit {

	public static void main(String[] args) 
	{
		// tag::split[]
		Scanner scanner = new Scanner(System.in);
		System.out.println("Geef een zin en Enter");
		String zin = scanner.nextLine();
		
		String[] tokens = zin.split(" ");
		
		System.out.printf("Aantal elementen: %d%nTokens:%n", tokens.length);
		for(String token : tokens)
			System.out.println(token);
		// end::split[]

	}

}
