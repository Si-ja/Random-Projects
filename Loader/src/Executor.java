import java.util.Scanner;

/**
 * Main Class that acts as a base executor in the domain of loader.io
 * @author Si-ja
 *
 */

public class Executor {
	
	public static void main(String[] args) 
	{
		//Create an instance where the Fibonacci sequence is calculated
		Sequencer seq = new Sequencer();
		
		//Prepare a scanner so that users could enter their own values and what sequential value to search for
		//In the Fibonacci sequence
		Scanner scanner = new Scanner(System.in);
		
		//Add a message to the user to inform them what to enter
		System.out.print("Enter the value you want to know in the Fibonacci sequence: ");
		
		//Take a note of the users' entry
		String forFibonacci = scanner.nextLine();
		
		//Parse the value and convert it into an integer
		Integer forFibonacci_int = Integer.parseInt(forFibonacci);
		
		//Pass the converted integer to the method that will find the sequential value in the Fibonnaci sequence
		Integer answer = seq.calculateFibonacci(forFibonacci_int);
		
		//Close the scanner
		scanner.close();
		
		//Make an empty string entry to not overlap the loading bar in the command prompt
		System.out.println("");
		
		//Give the users the answer to their question
		System.out.println("Answer for the Fibonacci Problem: {" + answer + "}");
	}
}
