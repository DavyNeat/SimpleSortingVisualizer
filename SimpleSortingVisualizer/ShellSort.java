import javax.swing.JFrame;

public class ShellSort extends Sort
{
	
	private int nums[];
	private SortingCanvas myCanvas;
	private volatile boolean running= true;
	
	ShellSort(int[] nums, SortingCanvas canvas)
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
		for(int gap = nums.length/2; gap >= 1; gap = gap/2)
		{
			for(int i = gap; (i < nums.length) && running; i++)
			{
				int key = nums[i];
				int j = i - gap;
				
				for(; j >= 0 && (nums[j] > key) && running; j -= gap)
				{
					nums[j + gap] = nums[j];
					nums[j] = key;
					myCanvas.redraw();
				}
				nums[j + gap] = key;
				myCanvas.redraw();
			}
		}
	}
}