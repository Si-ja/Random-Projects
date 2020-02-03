public class FizzBuzz {
	public static void main(String[] args) {
		FizzBuzz task = new FizzBuzz();
		for (int idx = 1; idx <= 15; idx++) {
			task.fizz_or_buzz(idx);
		}
	}
	public void fizz_or_buzz(int idx) {
		String answer = null;
		if (idx % 3 == 0 && idx % 5 == 0) {
			answer = "FizzBuzz";
		} else if (idx % 3 == 0 && idx % 5 != 0) {
			answer = "Fizz";
		} else if (idx % 3 != 0 && idx % 5 == 0) {
			answer = "Buzz";
		}
		if (answer == null) {
			System.out.println(idx);
		} else {
			System.out.println(answer);
		} 
	}
}