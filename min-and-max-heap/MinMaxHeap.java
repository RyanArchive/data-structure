// Getting Min/Max Heap

import java.util.*;

public class MinMaxHeap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Heap heap = new Heap();
				
		do {
			System.out.print("\nEnter type [Max/Min]: ");
			heap.setHeapType(sc.nextLine());
			
			if (heap.getHeapType().equalsIgnoreCase("Max") || heap.getHeapType().equalsIgnoreCase("Min"))
				break;
		} while (true);
		
		System.out.print("Enter numbers: ");
		String data = sc.nextLine();
		
		heap.setdataContainer(data);
		heap.split();
		heap.heap();
		heap.display();
	}
}

class Heap {
	private String heapType, dataContainer;
	private String[] splittedData;
	private int[] convertedData;
	
	public void setHeapType(String type) {
		heapType = type;
	}	
	public void setdataContainer(String data) {
		dataContainer = data;
	}
	
	public String getHeapType() {
		return heapType;
	}
	
	public void split() {
		splittedData = dataContainer.split(" ");
		convertedData = new int[splittedData.length];
		
		for (int x = 0; x < convertedData.length; x++)
			convertedData[x] = Integer.parseInt(splittedData[x]);
	}
	
	public void heap() {
		int container = 0, child = 0, parent = 0;
		
		for (int x = 1; x < convertedData.length; x++) {
			for (int y = x; y > 0; y--) {
				child = convertedData[y];
				parent = convertedData[(y - 1) / 2];

				if (heapType.equalsIgnoreCase("Min")) {
					if (child < parent) {
						container = parent;
						parent = child;
						child = container;
					}
				} else if (heapType.equalsIgnoreCase("Max")) {
					if (child > parent) {
						container = parent;
						parent = child;
						child = container;
					}
				}

				convertedData[y] = child;
				convertedData[(y - 1) / 2] = parent;
			}
		}
	}

	public void display() {
		System.out.print("Output: ");

		for (int x = 0; x < convertedData.length; x++)
			System.out.print(convertedData[x] + " ");
	}
}