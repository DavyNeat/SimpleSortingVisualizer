import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Visualizer extends JFrame implements ActionListener{
	
	public static void main(String args[])
	{
		Visualizer sorter = new Visualizer();
		sorter.setSize(1000, 1000);
		sorter.setVisible(true);
		sorter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private JLabel currentSort;
	private JButton nextSort;
	private JButton beginSort;
	private JButton randomizeNums;
	private SortingCanvas sortVisual;
	private int nums[] = new int[100];
	Random rand = new Random();
	
	Visualizer()
	{
			setTitle("Sorting Visualizer");
			GridBagConstraints layoutConst = new GridBagConstraints();
			setLayout(new GridBagLayout());
			
			layoutConst.insets = new Insets(10, 10, 0, 0);
			layoutConst.gridx = 0;
			layoutConst.gridy = 0;
			currentSort = new JLabel("-NULL-");
			add(currentSort, layoutConst);
			
			layoutConst.gridx = 0;
			layoutConst.gridy = 1;
			randomizeNums = new JButton("Randomize");
			randomizeNums.addActionListener(this);
			add(randomizeNums, layoutConst);
			
			layoutConst.gridx = 0;
			layoutConst.gridy = 2;
			nextSort = new JButton("Next");
			nextSort.addActionListener(this);
			add(nextSort, layoutConst);
			
			layoutConst.gridx = 0;
			layoutConst.gridy = 3;
			beginSort = new JButton("Begin");
			beginSort.addActionListener(this);
			add(beginSort, layoutConst);
			
			layoutConst.gridy = 0;
			layoutConst.gridx = 1;
			sortVisual = new SortingCanvas();
			
			for(int i = 0; i < nums.length; i++)
			{
				nums[i] = rand.nextInt(549) + 1;
			}
			
			sortVisual.setNums(nums);
			layoutConst.insets = new Insets(25, 25, 25, 25);
			layoutConst.gridheight = 4;
			layoutConst.gridwidth = 4;
			add(sortVisual, layoutConst);
			
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			if(event.getSource() == beginSort)
			{
				//insertionSort();
				
				
				Timer timer = new Timer();
				
				for(int i = 1; i < nums.length; i++)
				{
					int key = nums[i];
					int j = i - 1;
					
					for(; j >= 0 && nums[j] > key; j--)
					{
						nums[j + 1] = nums[j];
						
						timer.schedule(new TimerTask()
						{
						
							@Override
							public void run()
							{
								sortVisual.repaint();
							}
						
						
						}, 1000);
						
					}
					
					nums[j + 1] = key;
					
					
				}				
				
				
				System.out.println("beginSort");
			}
			else if(event.getSource() == nextSort)
				System.out.println("nextSort");
			else if(event.getSource() == randomizeNums)
				System.out.println("randomizeNums");
		}
		catch(NullPointerException except)
        {
            JOptionPane.showMessageDialog(this, 
                        "Error", 
                        "Error", 
                        JOptionPane.WARNING_MESSAGE);
        }
	}
	
	public void insertionSort()
	{
		//new Thread()
		//{
			//public void run()
			//{
				Timer timer = new Timer();
				
				for(int i = 1; i < nums.length; i++)
				{
					int key = nums[i];
					int j = i - 1;
					
					for(; j >= 0 && nums[j] > key; j--)
					{
						nums[j + 1] = nums[j];
						//SwingUtilities.invokeLater(new Runnable(){
							//sortVisual.repaint();
						timer.schedule(new TimerTask()
						{
						
							@Override
							public void run()
							{
								sortVisual.repaint();
							}
						
						
						}, 1000);
						//}
						//Thread.sleep(1000);

						//sortVisual.redraw();
						//sleep(10);
					}
					
					nums[j + 1] = key;
					//SwingUtilities.invokeLater(new Runnable(){
						//sortVisual.repaint();
					//}
					//Thread.sleep(1000);
					//sortVisual.repaint();
					//sleepy();
					
				}
				//SwingUtilities.invokeLater(new Runnable(){
					//sortVisual.repaint();
				//}
				//sortVisual.redraw();
			//}
		//}.run();
	}
	
	private static void sleep(long millies) {
		try {
			Thread.sleep(millies);
		} catch (InterruptedException e) {
			System.out.println("Thread is interrupted");
			Thread.currentThread().interrupt();
		}
	}
	
	public static void sleepy()
	{
		try
		{
			TimeUnit.SECONDS.sleep(1);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}
	
}