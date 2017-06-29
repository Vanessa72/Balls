import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BBView extends JPanel {

	BBModel model;
	
	double height;
	double velocity;
	double visibleHeight;
	
	public BBView(double visibleHeight)
	{
		model = new BBModel();
		
		this.visibleHeight = visibleHeight;
		
	}
	
	//public void paintComponent(Graphics g)
	//{
		
	//	super.paintComponent(g);
		
	//	int w = getWidth();
	//	int h = getHeight();
		
	//}
	
}
