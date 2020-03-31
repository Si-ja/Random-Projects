

/**
 * Sequencer allows to calculate numbers and their positions depending on what is processed.
 * It can tell the number in a Fibonaci sequence, or in Prime Numbers.
 * @author Nikita
 *
 */

public class Sequencer {
	/**
	 * Sequncer has only some attributes it initializes in the beginning - that being the starting position
	 * of any value. That is 0. Negatives cannot be calculated and are reversed back to positive values. Storage
	 * just stores information accumulating. Answer is the value that will be provided to the user. All of this could
	 * be done through a recursion...buuuuuuuuuuuuuuut. We have a different goal. And that is to implement the visual loader.
	 */
	
	private final Integer start = 0;
	private final Integer storage1 = 0;
	private final Integer storage2 = 0;
	private final Integer answer = 0;
	
	private LoaderHelper loader = new LoaderHelper();
	
	//=================================================================================================================
	/**
	 * 
	 * @param end is the positional number in the Fibonacci sequence, not the value itself. It can be pasted as a float
		 * but that is converted into an integer in any case.
	 */
	public Integer calculateFibonacci(int end) 
	{		
		Integer start = this.start;
		Integer storage1 = this.storage1;
		Integer storage2 = this.storage2;
		Integer answer = this.answer;
		
		storage1 = 0;
		storage2 = 1;
		answer = null;
		
		if (end == 0) 
		{
			answer = storage1;
			return answer;
		} else if (end == 1)
		{
			answer = storage2;
			return answer;
		}
		
		//Start the execution process of where the number needs to accumulate and calculated
		for (int i = start; i <= end - 1; i++) 
		{
			answer = storage1 + storage2;
			storage1 = storage2;
			storage2 = answer;
			loader.EvaluatorApplicable(i, end - 1);
		}
		return answer;
	}

}
