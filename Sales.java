// ****************************************************************
// Sales.java
//
// Reads in and stores sales for each of 5 salespeople.  Displays
// sales entered by salesperson id and total sales for all salespeople.
//
// ****************************************************************
import java.util.Scanner;

public class Sales
{
    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("How many salespeople are there? ");
    int SALESPEOPLE = scan.nextInt();
	int[] sales = new int[SALESPEOPLE];
	int sum;


	for (int i=0; i<sales.length; i++)
	    {
		System.out.print("Enter sales for salesperson " + (i + 1) + ": ");
		sales[i] = scan.nextInt();
	    }
	System.out.println("\nSalesperson   Sales");
	System.out.println("--------------------");
	sum = 0;
	for (int i=0; i<sales.length; i++)
	    {
		System.out.println("     " + (i + 1) + "         " + sales[i]);
		sum += sales[i];
	    }
	int average = sum / SALESPEOPLE;
	System.out.println("\nTotal sales: " + sum);
	System.out.println("\nAverage sales: " + average);
	int great = 0, sell = 0, least = 999999999, selll = 0;
	for (int i = 0; i < sales.length; i++) {
		if (sales[i] > great) {
			great = sales[i];
			sell = i + 1;
		} else if (sales[i] < least) {
			least = sales[i];
			selll = i + 1;
		}//end of if-else statements
	}//end of for-loop find greatest value
	System.out.println("\nGreatest value: " + great + " sold by salesperson " + sell);
	System.out.println("Lowest value: " + least + " sold by salesperson " + selll);
	
	System.out.println("Input an int value to find all people who sold more: ");
	int resp = scan.nextInt();
	
	for (int i = 0; i < sales.length; i++) {
		if (sales[i] > resp) {
			System.out.println("Salesperson " + (i+1) + " sold more than the given value - they sold " + sales[i]);
		}//end of if higher than response
	}//end of for-loop
    }
}
