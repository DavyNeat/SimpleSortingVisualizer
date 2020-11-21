import javax.swing.JFrame;

public class Main{
	public static void main(String args[])
	{
		Visualizer sorter = new Visualizer();
		sorter.setSize(1000, 1000);
		sorter.setVisible(true);
		sorter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}