import java.io.IOException;

/**
 * Loader helps track information on how far we have something that has processed or not.
 * @author Nikita
 *
 */
public class LoaderHelper {
	
	private String beginning = "[";
	private String middle = "........................................";
	private String loadingPoint = "=";
	private String loaderPath = new String("");
	private String loadingPointer = ">";
	private String ending = "]";
	
	/**
	 * This function allows to evaluate the timing that happens with the executable functions it works with.
	 * @param finish - the parameter needs to be passed of a double time, of how many iterations something will run.
	 * So far this covers only the situation when for loops are ran, or when the final destination point is known.
	 */
	public void EvaluatorBasic(double finish) 
	{
		
		String beginning = this.beginning;
		String middle = this.middle;
		String loadingPoint = this.loadingPoint;
		String loaderPath = this.loaderPath;
		String loadingPointer = this.loadingPointer;
		String ending = this.ending;
		
		for (double idx1 = 1; idx1 < finish + 1; idx1++) 
		{
			float percentageDone = Math.round(((float) idx1 / finish) * 100);
			double loadingLength = (double) Math.round(middle.length() * ((percentageDone / 100)));
			int temp_length = (int) loadingLength;
			String oldLoader = middle.substring(temp_length, middle.length());
			loaderPath = "";
			for (double idx2 = 0; idx2 < loadingLength - 1; idx2++)
			{
				loaderPath += loadingPoint;
			}
			if (idx1 == 1) 
			{
				loaderPath = beginning + loaderPath + loadingPointer + oldLoader + ending + " [" + percentageDone + "%]";
			} else 
			{
			loaderPath = "\r" + beginning + loaderPath + loadingPointer + oldLoader + ending + " [" + percentageDone + "%]";
			}
			
			try 
			{
				System.out.write(loaderPath.getBytes());
			} catch (IOException e) 
			{
				e.printStackTrace();
			}	
		}
		System.out.println("");
	}
	
	/**
	 * This function can integrated in the middle of the FOR LOOP and calculate where the calculations are in the process.
	 * @param beginningVal should be the value where the program is processing information (usually in a for loop that is a
	 * variable 'i' or 'idx' by conventional rules).
	 * @param endingVal should be the last value in the sequence that the FOR LOOP should hit. Essentially, it should be the
	 * second parameter that is indicated in the FOR structure (e.g.: (i = 0, i < x, i++) == (parameter1, parameter2, parameter3).
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
