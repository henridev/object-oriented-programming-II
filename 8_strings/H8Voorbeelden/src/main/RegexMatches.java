package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
	
	
	// tag::re[]
	public static void main(String args[]) {
		String REGEX = "a*b";
		String INPUT = "aabfooaabfooabfoob";
		
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(INPUT); // get a matcher object
		int count = 0;

		while (m.find()) {
			System.out.println("Match " + ++count);
			System.out.println(m.group());

		}
	}	
	// end::re[]
	
}
