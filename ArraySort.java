import java.util.*;
public class ArraySort {
	
public static int choice, array[], lowest, linearcount, binarycount;
public static boolean done = false, found = false;
public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		while(!done) {
		System.out.println("\nOPTION\t\t\t\tNUMBER");
		System.out.println("--------------------------------------");
		System.out.println("Create An Array\t\t\t1");
		System.out.println("Sort The Array\t\t\t2");
		System.out.println("Print The Array\t\t\t3");
		System.out.println("Search The Array (Linear)\t4");
		System.out.println("Exit\t\t\t\t0");
		choice = scan.nextInt();
		
		switch(choice) {
			case 1:
				makeArray();
				break;
			case 2:
				sortArray(array);
				break;
			case 3:
				printArray();
				break;
			case 4:
				sortArray(array);
				searchArray();;
				break;
			case 0:
				done = true;
				break;
			default:
				System.out.println("Please choose a valid selection.");
				
		}//end of switch-case choice
		}// end of while-loop done
	}// end of main
	public static void makeArray() {
		System.out.print("How many integers do you want in the array?: ");
		int len = scan.nextInt();
		array = new int[len];
		for (int i = 0; i < array.length; i++) {
			Double y = Math.random() * 50000;
			int x = y.intValue();
			array[i] = x;
		}//end of for-loop i
	}//end of makeArray
	
	public static void printArray() {
		for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + ", ");
			if ((i % 10) == 0) {
				System.out.print(array[i] + "\n");
			}//end of if divisible by 10
		}// end of printing of array
	}// end of printArray
	
	public static void sortArray( int [ ] num)
	{
	int j;
	int key;
	int i; 

	for (j = 1; j < num.length; j++)
	{
	key = num[ j ];
	for(i = j - 1; (i >= 0) && (num[ i ] > key); i--)
	{
	num[ i+1 ] = num[ i ];
	}
	num[ i+1 ] = key;
	}//end of for-loop
	}//end of sortArray
	public static void searchArray() {
		System.out.println("What value do you want to search for?");
		int a = scan.nextInt();
		for (int i = 0; i < array.length; i++) {
			linearcount++;
			if (a == array[i]) {
				System.out.println("Your value, " + (a + 1) + ", was found at position: " + i + " out of " + array.length);
				System.out.println("Total searches = " + linearcount);
				found = true;
			} else if (a < array[i] && found == false && i == array.length - 1) {
				System.out.println("The given value is not present in the array.");
			}//end of if given value is found or not
		}//end of for-loop to search for given value
	}//end of searchArray
}//end of ArraySort



