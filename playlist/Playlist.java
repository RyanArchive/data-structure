// Connecting data (songs and artists) through LinkedList

import java.util.*;

public class Playlist {
	public static void main(String[] args) {
		String[] choices = {"Enter Songs", "Enter Artist", "Display Songs", "Display Artists", "Display Playlist",  "Exit"};
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		LinkedList<String> songs = new LinkedList<String>();
		LinkedList<String> artists = new LinkedList<String>();		
		LinkedList<String> playlist = new LinkedList<String>();
		String[] container = new String[5];

		while (true) {
			System.out.println();

			for (int x = 1; x <= choices.length; x++)
				System.out.print(x + ". " + choices[x - 1] + "\n");

			System.out.print("\nChoose: ");
			int choice = sc1.nextInt();

			if (choice == 1) {
				System.out.println("\nEnter Songs: ");

				for (int x = 0; x < 5; x++)
					songs.add(x, sc2.nextLine());
			} else if (choice == 2) {
				System.out.println("\nEnter Artists: ");

				for (int x = 0; x < 5; x++)
					artists.add(x, sc2.nextLine());
			} else if (choice == 3) {
				System.out.println("\nDisplay Songs: ");
				System.out.println(songs);
			} else if (choice == 4) {
				System.out.println("\nDisplay Artists: ");
				System.out.println(artists);
			} else if (choice == 5) {		
				int x = 0;

				System.out.println("\nDisplay Playlist: ");

				for (String s: songs) {
					container[x] = s;
					x++;
				}
				x = 0;

				for (String a: artists) {
					playlist.add(container[x] + " - " + a);
					x++;
				}
				
				Collections.sort(playlist);
				for (String p: playlist)
					System.out.println(p);
			} else if (choice == 6) {
				System.exit(0);
			}
		}
	}
}