
import java.awt.Color;
import java.awt.Graphics;

public class BBModel {

	double height, velocity;
//  double thrust;
	final static double g = 9.81;
	
	private float ballRadius = 200; // Ball's radius
	private float ballX = ballRadius + 50; // Ball's center (x, y)
 	private float ballY = ballRadius + 20; 
 	private float ballSpeedX = 3;   // Ball's speed for x and y
 	private float ballSpeedY = 2;
	
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
		g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
	            (int)(2 * ballRadius), (int)(2 * ballRadius));
		
	}
	
}
