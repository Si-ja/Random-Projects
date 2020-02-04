public class FizzBuzz {
	public static void main(String[] args) {
		//Main method that runns the process for 15 itterations
		FizzBuzz task = new FizzBuzz();
		for (int idx = 1; idx <= 15; idx++) {
			task.fizz_or_buzz(idx);
		}
	}
	public void fizz_or_buzz(int idx) {
		//Essentially a condition that checks what state the number passed to itterations
		//i.e. whether it qualifies to represent "Fizz", "Buzz", Both or none.
		String answer = new String(""); //The answer of whether something is "Fizz", "Buzz", Both or none is stored in this variable
		
		//Slight optimization happens as each condition is evaluated seperatelly and less computing is done
		//And also now everything can be brought to one line of conditioning
		if (idx % 3 == 0) answer = answer + "Fizz";
		if (idx % 5 == 0) answer = answer + "Buzz";
		
		//Deliver on FizzBuzz output
		System.out.println(answer.equals("") ? idx : answer);
	}
}