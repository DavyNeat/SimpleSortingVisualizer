abstract class Sort implements Runnable
{
	private int nums[];
	private SortingCanvas myCanvas;
	private volatile boolean running= true;
	
	public void terminate()
	{
		running = false;
	}
	
	abstract public void run();
}