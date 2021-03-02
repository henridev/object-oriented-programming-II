package ui;
import java.util.Scanner;

//tag::codeExample[]
public class DivideByZeroNoExceptionHandling {

	   public static int berekenQuotient(int teller, int noemer)
	   {
	      return teller / noemer; 
	   }

	   public static void main(String[] args)
	   {
	      Scanner scanner = new Scanner(System.in); 

	      System.out.print("Geef een integere waarde voor de teller: ");
	      int teller = scanner.nextInt();
	      System.out.print("Geef een integere waarde voor de noemer: ");
	      int noemer = scanner.nextInt();

	      int quotient = berekenQuotient(teller, noemer);
	      System.out.printf(
	         "%nResultaat: %d / %d = %d%n", teller, noemer, quotient);
	      
	      scanner.close();
	   }

	}
//end::codeExample[]
