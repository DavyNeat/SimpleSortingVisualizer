//import java.util.Thread;
import javax.swing.JFrame;

public class InsertionSort implements Runnable, Sort{
	
	private int nums[];
	private SortingCanvas myCanvas;
	private volatile boolean running= true;
	
	InsertionSort(int[] nums, SortingCanvas canvas)
	{
		this.nums = nums;
		myCanvas = canvas;
	}
	
	public void terminate()
	{
		running = false;
	}
	
	public void run()
	{
		for(int i = 1; (i < nums.length) && running; i++)
		{
			int key = nums[i];
			int j = i - 1;
			
			for(; j >= 0 && (nums[j] > key) && running; j--)
			{
				nums[j + 1] = nums[j];
				nums[j] = key;
				myCanvas.redraw();
			}
			nums[j + 1] = key;
			myCanvas.redraw();
		}
		
	}
	
}