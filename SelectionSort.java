import javax.swing.JFrame;

public class SelectionSort extends Sort
{
	
	private int nums[];
	private SortingCanvas myCanvas;
	private volatile boolean running= true;
	
	SelectionSort(int[] nums, SortingCanvas canvas)
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
		int temp;
		int min;
		for(int i = 0; (i < nums.length) && running; i++)
		{
			min = i;
			
			for(int j = i; (j < nums.length) && running; j++)
			{
				
				if(nums[min] > nums[j])
					min = j;
					
				myCanvas.redraw();
			}
			
			temp = nums[i];
			nums[i] = nums[min];
			nums[min] = temp;
			myCanvas.redraw();
		}
		
	}
	
}