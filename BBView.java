import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BBView extends JPanel {

	double height;
	double velocity;
	double visibleHeight;
	
	public BBView(double visibleHeight)
	{
		
		this.visibleHeight = visibleHeight;
		
	}
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		
		
	}
	
}

