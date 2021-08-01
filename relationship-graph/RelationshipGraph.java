// Getting mutual, polygon and lonely persons by the factor of 'crush'

import java.util.*;

public class RelationshipGraph {
	private static ArrayList<String> persons = new ArrayList<String>();
	private static ArrayList<String> crushes = new ArrayList<String>();
	private static String[][] representation;	
	private static ArrayList<String> mutual = new ArrayList<String>();
	private static ArrayList<String> polygon = new ArrayList<String>();
	private static ArrayList<String> lonely = new ArrayList<String>();

	public static void main(String[] args) {
		input();
		represent();
		checkRelationship();
		display();
	}

	public static void input() {
		Scanner sc = new Scanner(System.in);
		String input;

		do {
			System.out.println("\nEnter persons and their crushes separated by spaces (type END to stop the input):");
			do {
				input = sc.nextLine();

				if (input.equalsIgnoreCase("end"))
					break;

				String[] contSplit = input.split(" ");

				if (contSplit.length == 2 && (!contSplit[0].equalsIgnoreCase("") && !contSplit[1].equalsIgnoreCase(""))) {
					persons.add(contSplit[0]);
					crushes.add(contSplit[1]);
				} else {
					System.out.println("Invalid input. Again.");
					persons.clear();
					crushes.clear();
					break;
				}
			} while (true);
		} while (!input.equalsIgnoreCase("end"));
	}

	public static void represent() {
		representation = new String[persons.size()][2];

		for (int x = 0; x < representation.length; x++) {
			for (int y = 0; y < representation[x].length; y++) {
				if (y == 0)
					representation[x][y] = persons.get(x);
				else
					representation[x][y] = crushes.get(x);
			}
		}
	}

	public static void checkRelationship() {
		ArrayList<String> container1 = new ArrayList<String>();
		ArrayList<String> container2 = new ArrayList<String>();
		String first;
		
		// Mutual and lonely
		for (int x = 0; x < representation.length; x++) {
			String crushMutual = representation[x][1] + " " + representation[x][0];
			boolean notCrush = true;

			for (int y = 0; y < representation.length; y++) {
				String crushBack = representation[y][0] + " " + representation[y][1];

				if (crushMutual.equalsIgnoreCase(crushBack)) {
					if (!mutual.contains(representation[x][0]) && !mutual.contains(representation[x][1])) {
						mutual.add(representation[x][0]);
						mutual.add(representation[x][1]);
					}
				}

				if (representation[x][0].equalsIgnoreCase(representation[y][1])) {
					notCrush = false;
					break;
				}
			}

			if (notCrush == true)
				lonely.add(representation[x][0]);
		}
		
		// Polygon
		for (int x = 0; x < representation.length; x++) {
			if (!mutual.contains(representation[x][0]) && !lonely.contains(representation[x][0])) {
				polygon.add(representation[x][0]);
				container1.add(representation[x][1]);
			}
		}
		
		polygon.retainAll(container1);
		
		for (int x = 0; x < polygon.size(); x++)
			for (int y = 0; y < representation.length; y++)
				if (polygon.get(x).equalsIgnoreCase(representation[y][0]))
					container2.add(representation[y][1]);
		
		polygon.retainAll(container2);
		
		if (polygon.size() < 3)
			polygon.clear();
	}

	public static void display() {
		System.out.print("\nMutual Relationship:\t");
		for (int x = 0; x < mutual.size(); x++)
			System.out.print(mutual.get(x) + " ");

		System.out.print("\nPolygon Relationship:\t");
		for (int x = 0; x < polygon.size(); x++)
			System.out.print(polygon.get(x) + " ");

		System.out.print("\nLonely heart:\t\t");
		for (int x = 0; x < lonely.size(); x++)
			System.out.print(lonely.get(x) + " ");
	}
}

/*
	Sample input:

	Ryan Julie
	Edward Ryan
	Julie Ryan
*/