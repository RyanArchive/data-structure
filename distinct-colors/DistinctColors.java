// Getting the number of distinct colors of Saypa Ades plants

import java.util.*;

public class DistinctColors {
	private static Map<String, String> colorMap = new HashMap<>();
	
	public static void main(String[] args) {		
		inputColor();
		
		System.out.println("\nTotal Saypa Ades plant counted: " + countPlant());			
	}
	
	public static void inputColor() {
		Scanner sc = new Scanner(System.in);
		String color;
		
		System.out.println("\nEnter color of flowers (enter -1 to stop):");
		
		do {	
			color = sc.nextLine();	
		
			if (!(color.equals("-1")))
				colorMap.put(color.toLowerCase(), color);
		} while (!(color.equals("-1")));						// Use -1 to stop input
	}
	
	public static int countPlant() {
		int nCount = 0;
		
		for (Map.Entry e: colorMap.entrySet())
			nCount++;
		
		return nCount;
	}
}