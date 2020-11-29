import javax.swing.JFrame;

public class QuickSort extends Sort
{
	
	private int nums[];
	private SortingCanvas myCanvas;
	private volatile boolean running= true;
	
	QuickSort(int[] nums, SortingCanvas canvas)
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
			sort(0, nums.length-1);
	}
	
	int partition(int low, int high) 
    { 
        int pivot = nums[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (nums[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = nums[i]; 
                nums[i] = nums[j];
                nums[j] = temp; 
				myCanvas.redraw();
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = nums[i+1]; 
        nums[i+1] = nums[high];
        nums[high] = temp;
		myCanvas.redraw();
				
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void sort(int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(low, pi-1); 
            sort(pi+1, high); 
        } 
    } 
}