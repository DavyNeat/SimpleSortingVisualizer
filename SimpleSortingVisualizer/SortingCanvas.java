import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class SortingCanvas extends JPanel
{
	
	private int nums[];
	
	SortingCanvas()
	{
		setPreferredSize(new Dimension(600, 600));
	}
	
	public void setNums(int x[])
	{
		nums = x;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		Dimension d = getSize();
		int rectWidth = d.width / 100;
		
		for(int i = 0; i < nums.length; i++)
		{
			g2.setPaint(Color.blue);
			g2.fill(new Rectangle(i * rectWidth, (600 - nums[i]), rectWidth, nums[i]));
			g2.setPaint(Color.white);
			g2.fill(new Rectangle(i * rectWidth, (600 - nums[i]), 1, nums[i]));
		}		
	}
	
	public void redraw() 
	{
		repaint();
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted");
        }   
    }
}