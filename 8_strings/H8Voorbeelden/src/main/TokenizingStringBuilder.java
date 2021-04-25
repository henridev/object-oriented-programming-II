package main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenizingStringBuilder {

	public static void main(String[] args) 
	{
		// tag::sb[]
		Scanner scanner = new Scanner(System.in);
		System.out.println("Geef een zin en Enter");
		String zin = scanner.nextLine();
		
		StringTokenizer tokens = new StringTokenizer(zin);
		
		System.out.printf("Aantal elementen: %d%nTokens:%n", tokens.countTokens());
		while (tokens.hasMoreTokens())
			System.out.println(tokens.nextToken());
		// end::sb[]
	}

}
