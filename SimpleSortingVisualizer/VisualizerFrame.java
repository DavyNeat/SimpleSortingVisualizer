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

public class VisualizerFrame extends JFrame implements ActionListener{
	
	public static void main(String args[])
	{
		VisualizerFrame sorter = new VisualizerFrame();
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
	private int sortSelection, maxSorts;
	Random rand = new Random();
	Thread mySort = null;
	Sort test = null;
	
	VisualizerFrame()
	{
			setTitle("Sorting Visualizer");
			GridBagConstraints layoutConst = new GridBagConstraints();
			setLayout(new GridBagLayout());
			
			layoutConst.insets = new Insets(10, 10, 0, 0);
			layoutConst.gridx = 0;
			layoutConst.gridy = 0;
			currentSort = new JLabel("Insertion Sort");
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
			
			sortSelection = 1;
			maxSorts = 2;
			for(int i = 0; i < nums.length; i++)
			{
				nums[i] = rand.nextInt(549) + 1;
			}
			
			sortVisual.setNums(nums);
			layoutConst.insets = new Insets(25, 25, 25, 25);
			layoutConst.gridheight = 4;
			layoutConst.gridwidth = 4;
			add(sortVisual, layoutConst);
			
			test = new InsertionSort(nums, sortVisual);
			mySort = new Thread(test);
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			
			if((event.getSource() == beginSort) && !(mySort.isAlive()))
			{
				switch(sortSelection)
				{
					case 1:
						test = new InsertionSort(nums, sortVisual);
						mySort = new Thread(test);
						break;
					case 2:
						test = new SelectionSort(nums, sortVisual);
						mySort = new Thread(test);
						break;
					case 3:
						test = new MergeSort(nums, sortVisual);
						mySort = new Thread(test);
						break;
					case 4:
						test = new ShellSort(nums, sortVisual);
						mySort = new Thread(test);
						break;
					case 5:
						test = new QuickSort(nums, sortVisual);
						mySort = new Thread(test);
						break;
					default:
						break;
				}
				mySort.start();
			}
			else if(event.getSource() == nextSort)
			{
				System.out.println("Is alive?" + mySort.isAlive());
				
				sortSelection++;
				if(sortSelection > 5)
					sortSelection = 1;
				switch(sortSelection)
				{
					case 1:
						currentSort.setText("Insertion Sort");
						break;
					case 2:
						currentSort.setText("Selection Sort");
						break;
					case 3:
						currentSort.setText("Merge Sort");
						break;
					case 4:
						currentSort.setText("Shell Sort");
						break;
					case 5:
						currentSort.setText("Quick Sort");
						break;
					default:
						break;
				}
			}
			else if(event.getSource() == randomizeNums)
			{
				if(mySort != null)
				{
					test.terminate();
					mySort.join();
					mySort = null;
				}
				
				for(int i = 0; i < nums.length; i++)
				{
					nums[i] = rand.nextInt(549) + 1;
				}
				
				sortVisual.redraw();
				
				switch(sortSelection)
				{
					case 1:
						test = new InsertionSort(nums, sortVisual);
						mySort = new Thread(test);
						break;
					case 2:
						test = new SelectionSort(nums, sortVisual);
						mySort = new Thread(test);
						break;
					case 3:
						test = new MergeSort(nums, sortVisual);
						mySort = new Thread(test);
						break;
					case 4:
						test = new ShellSort(nums, sortVisual);
						mySort = new Thread(test);
						break;
					case 5:
						test = new QuickSort(nums, sortVisual);
						mySort = new Thread(test);
						break;
					default:
						break;
				}
			}
		}
		catch(NullPointerException | InterruptedException except)
        {
            JOptionPane.showMessageDialog(this, 
                        "Error", 
                        "Error", 
                        JOptionPane.WARNING_MESSAGE);
        }
	}
	
	public void redraw()
	{
		sortVisual.redraw();
	}
}