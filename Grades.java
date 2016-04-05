import java.util.Scanner;
public class Grades {
	public static int qs, as;
	public static boolean done = false, complete = false;
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("How many questions are on the quiz?");
		qs = scan.nextInt();
		int[] answers = new int[qs];
		int[] inputs = new int[qs];
		System.out.println("Insert each key answer, followed by a space. Ex: 13 15 72");
		for (int i = 0; i < answers.length; i++) {
			as = scan.nextInt();
			answers[i] = as;
		}//end of for-loop answers
		while(!done) {
		System.out.println("Enter each answer to be graded.");
		for (int i = 0; i < inputs.length; i++) {
			as = scan.nextInt();
			inputs[i] = as;
		}//end of for-loop inputs
		compareArray(answers, inputs);
		while(!complete) {
		System.out.println("Do you wish to score another quiz with the same key? (Y/n)");
		String resp = scan.next();
		if (resp.equalsIgnoreCase("N")) {
			done = true;
			complete = true;
		} else if (resp.equalsIgnoreCase("Y")) {
			complete = true;
		} else {
			System.out.println("Please enter a valid response.");
		}//end of if-else to loop the program
		}//end of while-loop complete
		}//end of while-loop done
	}//end of main
/* public static void printArray(int[] array) {
	for (int i = 0; i < array.length; i++) {
		System.out.print(array[i] + " ");
	}//end of for-loop answers
}//end of printArray */ // IMPLEMENTED AS A DEBUG METHOD

public static void compareArray(int[] list1, int[] list2) {
	int correct = 0;
	for (int i = 0; i < list1.length; i++) {
		if (list1[i] == list2[i]) {
			correct++;
		}//end of if correct
	}//end of for-loop compare
	System.out.println("Those answers were correct for " + correct + " out of " + qs + " questions.");
	double score = ((double) correct / (double) qs) * 100;
	System.out.println("Percentage score = " + score + ".");
}//end of compareArray
}//end of Grades
