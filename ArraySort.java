/* Program: ArraySort.java
 * 
 * Programmer: "Trapmaster" Pat Wooden
 * 
 * Description: Can create an array of a given number of integers. Also can sort the array from least to
 * greatest, give the results printed, and search for a given value linearly.
 * 
 * Revision 0: Program state as first pushed.
 * Revision 1: Fixed a loop that results when searching for a value that is not present in
 * the array.
 * Revision 2: Added a searchArrayBinary() method -- needs work to be fully functional.
 * Revision 3: Fixed an infinite loop that resulted when the given value for searchArrayBinary() was greater than the middle
 * value of the array.
 * Revision 4: Fixed an arrayIndexOutOfBounds error that resulted when the given value of searchArrayBinary() is lower than the
 * middle value of the array.
 */

import java.util.*;
public class ArraySort {
	
public static int choice, array[], lowest, linearcount = 0, binarycount = 0;
public static boolean done = false, found = false, finished = false;
public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		while(!done) {
		System.out.println("\nOPTION\t\t\t\tNUMBER");
		System.out.println("--------------------------------------");
		System.out.println("Create An Array\t\t\t1");
		System.out.println("Sort The Array\t\t\t2");
		System.out.println("Print The Array\t\t\t3");
		System.out.println("Search The Array (Linear)\t4");
		System.out.println("Search The Array (Binary)\t5");
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
			case 5:
				sortArray(array);
				searchArrayBinary();
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
	
	public static void searchArrayBinary() {
		System.out.println("What value do you want to search for?");
		int value = scan.nextInt();
		int lower = 0;
		int middle = array.length / 2;
		int upper = array.length;
		while(!finished) {
			if (value > array[middle]) {
				lower = middle + 1;
				middle = upper - ((upper - middle) / 2);
				binarycount++;
				// System.out.println("Debug statement = value > array[middle]");
			} else if (value < array[middle]) {
				upper = middle - 1;
				middle = (middle - 1) / 2;
				binarycount++;
				// System.out.println("Debug statement = value < array[middle]");
			} else if (value == array[middle]) {
				System.out.println("Value " + value + " was found at " + middle + " out of " + array.length);
				System.out.println("Actions taken: " + binarycount);
				finished = true;
			}//end of if-else statements to find value
		if (lower == middle && middle == upper) {
			System.out.println("Given value was not found in the array");
		}//end of if value is never found
	}//end of while-loop finished
	}//end of searchArrayBinary
}//end of ArraySort



