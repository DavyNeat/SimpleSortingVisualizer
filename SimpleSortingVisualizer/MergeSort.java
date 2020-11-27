import javax.swing.JFrame;

public class MergeSort extends Sort
{
	
	private int nums[];
	private SortingCanvas myCanvas;
	private volatile boolean running= true;
	
	MergeSort(int[] nums, SortingCanvas canvas)
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
			int temp[] = new int[nums.length];
			sort(0, nums.length - 1, temp);
	}
	
	private void sort(int low, int high, int temp[])
	{
		if(low < high)
		{
			int half = (low + high)/2;
			sort(low, half, temp);
			sort(half + 1, high, temp);
			merge(low, half + 1, high, temp);
			return;
		}
	}
	
	private void merge(int low, int rightPos, int high, int temp[])
	{
		int leftInd = low;
		int rightInd = rightPos;
		int mainInd = low;
		
		while(leftInd < rightPos && rightInd <= high)
		{
			if(nums[leftInd] <= nums[rightInd])
			{
				temp[mainInd] = nums[leftInd];
				leftInd++;
			}
			else if(nums[rightInd] < nums[leftInd])
			{
				temp[mainInd] = nums[rightInd];
				rightInd++;
			}
			mainInd++;
		}
		
		while(leftInd < rightPos)
		{
			temp[mainInd] = nums[leftInd];
			leftInd++;
			mainInd++;
		}
		
		while(rightInd <= high)
		{
			temp[mainInd] = nums[rightInd];
			mainInd++;
			rightInd++;
		}
		
		for(int i = low; i < (high + 1); i++)
		{
			nums[i] = temp[i];
			myCanvas.redraw();
		}
	}
	
}