package ui;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class StackTest 
{
//tag::stack[]
	public StackTest() 
	{
		Deque<Number> stack = new ArrayDeque<>();
		Long longNumber = 12L;
		Integer intNumber = 34567;
		Float floatNumber = 1.0F;
		Double doubleNumber = 1234.5678;

		stack.push(longNumber);
		printStack(stack);
		stack.push(intNumber);
		printStack(stack);
		stack.push(floatNumber);
		printStack(stack);
		stack.push(doubleNumber);
		printStack(stack);

		try {
			Number removedObject = null;
			while (true) 
			{
				removedObject = stack.pop();
				System.out.printf("%s popped%n", removedObject);
				printStack(stack);
			} // end while
		} // end try
		catch (NoSuchElementException noSuchElementException) {
			noSuchElementException.printStackTrace();
		} // end catch
	} // end StackTest constructor

	private void printStack(Deque<Number> stack) 
	{
		if (stack.isEmpty())
			System.out.print("stack is empty\n\n"); // de stack is leeg
		else // de stack is niet leeg
		{
			System.out.print("stack contains: ");
			for (Number number : stack)
				System.out.printf("%s ", number);

			System.out.print("(top) \n\n");
		} // end else
	} // end method printStack
//end::stack[]
}
