// Hashing of names

import java.util.*;

public class NameHashing {
	private static String[] names;
	private static String[] data = {"", "", "", "", "", "", "", "", "", "", ""};
	private static int[] arrayArrange;
	
	public static void main(String[] args) {
		inputName();
		compute();
		display();
	}
	
	public static void inputName() {
		System.out.print("\nEnter names separated by space: ");
		Scanner sc = new Scanner(System.in);		
		String input = sc.nextLine();
		
		names = input.split(" ");
		arrayArrange = new int[names.length];
	}
	
	// Use ASCII to get the names' values
	public static void compute() {		
		for (int x = 0; x < names.length; x++) {
			int totalASCII = 0;
			
			for (int y = 0; y < names[x].length(); y++) {
				totalASCII += (int) names[x].charAt(y);
			}
			
			arrayArrange[x] = totalASCII % data.length;			
		}
	}
	
	public static void display() {
		for (int x = 0; x < arrayArrange.length; x++) {
			if (data[arrayArrange[x]].equals("")) {
				data[arrayArrange[x]] += names[x];
			} else {
				data[arrayArrange[x]] = data[arrayArrange[x]] + ", " + names[x];
			}
		}
		
		for (int x = 0; x < data.length; x++) {
			System.out.println(x + " - " + data[x]);
		}
	}
}