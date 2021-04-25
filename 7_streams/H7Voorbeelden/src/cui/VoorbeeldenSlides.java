package cui;

public class VoorbeeldenSlides {
	public static void main(String[] args) 
	{
//tag::lus[]
		int sum = 0, values[] = {1,2,3,4,5};
		for (int counter = 0; counter < values.length; counter++)
			sum += values[counter];
//end::lus[]
		
		System.out.println(sum);
	}

}
