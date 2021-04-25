package domein;

import java.util.*;

public class CryptoGraphie {
	private Deque<Character> stack;
	private Queue<Character> queue;
	private Character[] KLINKER_ARR = {'a','e','i','o','u','y'};
	private HashSet<Character> KLINKER_SET = new HashSet(Arrays.asList(KLINKER_ARR));

	// eigen oplossing
	public String codeerBericht(String origineel) {
		stack = new ArrayDeque<>();
		queue = new LinkedList<>();

		for (char c : origineel.toCharArray()) {
			boolean isHuidigeCharacterKlinker = KLINKER_SET.contains(c);

			if(isHuidigeCharacterKlinker){
				// haal alle medeklinkers uit alvorens klinker in te zetten
				while(!stack.isEmpty()
						&& !KLINKER_SET.contains(Character.toLowerCase(stack.peekFirst()))){
					queue.offer(stack.pop());
				}
			}

			// klinkers zo snel mogelijk eruit
			while(!stack.isEmpty() &&
					KLINKER_SET.contains(Character.toLowerCase(stack.peekFirst()))){
				queue.offer(stack.pop());
			}

			// medeklinkers kunnen accumuleren
			stack.push(c);
		}

		// laatste letters uithalen
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()){
			sb.append(queue.poll());
		}

		return sb.toString();
	}

	public String codeerBerichtModelOplossing(String origineel)
	{
		stack = new ArrayDeque<>();
		queue = new ArrayDeque<>();

		//Stap 1
		int index = 0 ;
		while(index < origineel.length())
		{
			Character ch = null;
			while(index < origineel.length())
			{
				ch = origineel.charAt(index++);
				if(KLINKER_SET.contains(Character.toLowerCase(ch)))
					break;
				stack.push(ch);
			}
			while(!stack.isEmpty())
			{
				queue.offer(stack.pop());
			}
			if(KLINKER_SET.contains(Character.toLowerCase(ch)))
				queue.offer(ch);
		}
		//Stap 2
		String gecodeerd = "";
		while(!queue.isEmpty())
		{
			gecodeerd += queue.poll();
		}
		return gecodeerd;
	}//codeer
}
