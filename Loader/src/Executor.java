import java.util.Scanner;

/**
 * Main Class that acts as a base executor in the domain of loader.io
 * @author Nikita
 *
 */

public class Executor {
	
	public static void main(String[] args) 
	{
		Sequencer seq = new Sequencer();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the value you want to know in the Fibonacci sequence: ");
		String forFibonacci = scanner.nextLine();
		Integer forFibonacci_int = Integer.parseInt(forFibonacci);
		Integer answer = seq.calculateFibonacci(forFibonacci_int);
		scanner.close();
		System.out.println("");
		System.out.println("Answer for the Fibonacci Problem: {" + answer + "}");
	}
}
