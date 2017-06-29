
import java.awt.Color;
import java.awt.Graphics;

public class BBModel {

	double height, velocity;
//  double thrust;
	final static double g = 9.81;
	
	public void reset(double height)
	{
		this.height = height;
		this.velocity = 0;
	//  this.thrust = 0;		
	}
	
	public boolean tick(double dt)
	{
		height += dt * velocity;
	//	double acceleration = thrust - g;
	//	velocity += dt * acceleration;
		
		if(height < 0)
		{
			height = 0;
			return false;
		}
		else
			return true;
	}
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		
		int w = getWidth();
		int h = getHeight();
		
		g.setColor(Color.blue);
		g.fillOval(1, 1, 1, 1); // mit koordinaten schreiben (height, width, radius)
		
	}
	
}
