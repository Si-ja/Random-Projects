import java.io.IOException;

/**
 * Loader helps track information on how far we have something that has processed or not.
 * @author Si-ja
 *
 */
public class LoaderHelper {
	
	//Few variables are prepared that will help in the future, as they are reusable, and mostly used for the graphics
	private String beginning = "[";                                          //Very begininng of the progress bar
	private String middle = "........................................";      //An empty progress bar (40 dots)
	private String loadingPoint = "=";                                       //What will replace the dots in the progress bar
	private String loaderPath = new String("");                              //Empty, as this what will be printed out as it updates
	private String loadingPointer = ">";                                     //A head point in the loading bar
	private String ending = "]";                                             //Very end of the progress bar
	
	/**
	 * This function allows to evaluate the timing that happens with the executable functions it works with.
	 * @param finish - the parameter needs to be passed of a double time, of how many iterations something will run.
	 * So far this covers only the situation when for loops are ran, or when the final destination point is known.
	 */
	
	//This is pretty much a standalone function for experimenting with how the process functions in the first place
	public void EvaluatorBasic(double finish) 
	{
		String beginning = this.beginning;
		String middle = this.middle;
		String loadingPoint = this.loadingPoint;
		String loaderPath = this.loaderPath;
		String loadingPointer = this.loadingPointer;
		String ending = this.ending;
		
		//This loop runs through a generic sequnce of numbers from x to y. For which a progress bar can be simulated.
		for (double idx1 = 1; idx1 < finish + 1; idx1++) 
		{
			//First we want to know how far we are in the for loop (can be evaluated in percentages)
			float percentageDone = Math.round(((float) idx1 / finish) * 100);
			
			//Second - we want to know how far in the progress bar we would be in respect to how far we are in the for loop
			double loadingLength = (double) Math.round(middle.length() * ((percentageDone / 100)));
			
			//*For future reasons, here we need to cast the variable as an int. It should not be larger than 100, so it is ok
			int temp_length = (int) loadingLength;
			
			//Third - after we know where technically we need to be in the progress bar (e.g. in 25% of it if 25% of the loop has finished running)
			//And we get the empty fields of what is left (e.g. from the previous example - that would be 75% or 30dots).
			String oldLoader = middle.substring(temp_length, middle.length());
			
			//Reset the loader path (or what will be outputed to the screen)
			loaderPath = "";
			
			//Start a new loop, to populate the string with the values that represent that some part of the above for loop has finished
			for (double idx2 = 0; idx2 < loadingLength - 1; idx2++)
			{
				loaderPath += loadingPoint;
			}
			//Now prepare how the output loading string will look
			//If it's the first time it is outputed to the screen, then it should have a slightly different format
			if (idx1 == 1) 
			{
				//Essentially this string can be read like this:
				//String loaderPath = "[" + (some amount of) "=====" + ">" + (some amount of) "...." + "]" + " [" + (some value indicating how far we are in the loop) + "]%"
				loaderPath = beginning + loaderPath + loadingPointer + oldLoader + ending + " [" + percentageDone + "%]";
			} else 
			{
			loaderPath = "\r" + beginning + loaderPath + loadingPointer + oldLoader + ending + " [" + percentageDone + "%]";
			}
			
			//Output that progress bar
			try 
			{
				System.out.write(loaderPath.getBytes());
			} catch (IOException e) 
			{
				e.printStackTrace();
			}	
		}
		//Make one line so the new information if there is after running this method - does not overlap with the progress bar
		System.out.println("");
	}
	
	/**
	 * This function can integrated in the middle of the FOR LOOP and calculate where the calculations are in the process.
	 * @param beginningVal should be the value where the program is processing information (usually in a for loop that is a
	 * variable 'i' or 'idx' by conventional rules).
	 * @param endingVal should be the last value in the sequence that the FOR LOOP should hit. Essentially, it should be the
	 * second parameter that is indicated in the FOR structure (e.g.: (i = 0, i < x, i++) == (parameter1, parameter2, parameter3).
	 */
	
	/*
	This function essentially is almost what is presented above, but the above is a standalone method. It can be only
	* Used for examples. This one can be practically used in the for loop applications
	* Difference is that it generates a string though almost in the same fashion, but only once per execution. Meaning
	* It evaluates each time where we are in the loop. This is indicated calculated with beginningVal and endingVal.
	* The method from above, would run from 0% to 100% and is just used as an example
	*/
	public void EvaluatorApplicable(double beginningVal, double endingVal) 
	{

		String beginning = this.beginning;
		String middle = this.middle;
		String loadingPoint = this.loadingPoint;
		String loaderPath = this.loaderPath;
		String loadingPointer = this.loadingPointer;
		String ending = this.ending;
		
		float percentageDone = Math.round(((float) beginningVal / endingVal) * 100);
		double loadingLength = (double) Math.round(middle.length() * ((percentageDone / 100)));
		int temp_length = (int) loadingLength;
		String oldLoader = middle.substring(temp_length, middle.length());
		loaderPath = "";
		
		for (double idx2 = 0; idx2 < loadingLength - 1; idx2++)
		{
			loaderPath += loadingPoint;
		}
		
		loaderPath = "\r" + beginning + loaderPath + loadingPointer + oldLoader + ending + " [" + percentageDone + "%]";
		
		try 
		{
			System.out.write(loaderPath.getBytes());
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
