

/**
 * Sequencer allows to calculate numbers and their positions depending on what is processed.
 * It can tell the number in a Fibonaci sequence, or in Prime Numbers.
 * @author Si-ja
 *
 */

public class Sequencer {
	/**
	 * Sequncer has only some attributes it initializes in the beginning - that being the starting position
	 * of any value. That is 0. Negatives cannot be calculated and are reversed back to positive values. Storage
	 * just stores information accumulating. Answer is the value that will be provided to the user. All of this could
	 * be done through a recursion...buuuuuuuuuuuuuuut. We have a different goal. And that is to implement the visual loader.
	 */
	
	//Keep track of few variables that could be re-used for future methods
	private final Integer start = 0;
	private final double storage1 = 0;
	private final double storage2 = 1;
	private final double answer = 0;
	
	//Load the class that essentially allows for calculating the progression in our sequences
	private LoaderHelper loader = new LoaderHelper();
	
	//=================================================================================================================
	/**
	 * 
	 * @param end is the positional number in the Fibonacci sequence, not the value itself. It can be pasted as a float
		 * but that is converted into an integer in any case.
	 */
	public double calculateFibonacci(int end) 
	{		
		//Load all the needed variables
		Integer start = this.start;
		double storage1 = this.storage1;
		double storage2 = this.storage2;
		double answer = this.answer;
		
		storage1 = 0;  //Represents the F(n-2) value in the Fibonacci sequence
		storage2 = 1;  //Represents the F(n-1) value in the Fibonacci sequence
		answer = 0; //Represents the F(n) value in the Fibonacci sequence
		
		//Make few conditions, as we cannot start from the value in sequence 1 or 2, with a repeating eas
		if (end == 0) 
		{
			answer = storage1;
			return answer;
		} else if (end == 1)
		{
			answer = storage2;
			return answer;
		}
		
		//If the value passed by the user is 2 or higher, we will always start here.
		//Start the execution process of where the number needs to accumulate and calculated
		for (int i = start; i <= end - 2; i++) 
		{
			answer = storage1 + storage2;
			storage1 = storage2;
			storage2 = answer;
			loader.EvaluatorApplicable(i, end - 2); //Loader evaluates how far are we in our calculations process
			                                        //And prints (updates) the progression bar
		}
		return answer; //Give the users the answer
	}

}
