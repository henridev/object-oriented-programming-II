package ui;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest {
	public static void main(String args[]) {
//tag::queue[]
		Queue<Double> queue = new ArrayDeque<>();

		// insert elements to queue
		queue.offer(3.2);
		queue.offer(9.8);
		queue.offer(5.4);

		System.out.print("Polling from queue: ");
		// display elements in queue
		while (queue.size() > 0) {
			System.out.printf("%.1f ", queue.peek());// geeft het top-element weer
			queue.poll(); // verwijdert het top element
		} // end while
//end::queue[]
	} // end main
} // end class
