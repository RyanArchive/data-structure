// Reversing a word using Stack

import java.util.*;

public class ReverseWord {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in)	;
		
		System.out.print("\nEnter a word: ");
		String word = sc.nextLine();
		
		String reversed = reverse(word);
		
		System.out.println("\nWord: " + word + "\nReversed: " + reversed);
	}
	
	// Last in first out of letters to produce reversed word
	public static String reverse(String word) {
		Stack<String> stack = new Stack<String>();
		String popping = "";
				
		for (int x = 0; x < word.length(); x++)
			stack.push(word.charAt(x) + "");
		
		for (int x = 0 ; x < word.length(); x++)
			popping += stack.pop();
		
		return popping;
	}
}