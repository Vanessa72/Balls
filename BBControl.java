import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Dimension;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class BBControl implements MouseListener, Runnable, ActionListener {

	BBModel model;
	BBView view;
		
	boolean isRunning;
	long starttime = 0;
	long lasttime = 0;
	private static final int BOX_WIDTH = 640;
	private static final int BOX_HEIGHT = 480;
	
	public static void main(String[] args) {
		new BBControl();
	}
		
	public BBControl()
	{
		
		model = new BBModel();
		
		view = new BBView(200);
		view.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
			
	
			
		JPanel viewPanel = new JPanel();
		viewPanel.add(BBView);

		JFrame frame = new JFrame("BallBounce");
			
		frame.add(viewPanel);
		frame.pack();
	
		frame.addMouseListener(this);
		frame.setVisible(true);
				
		resetModel();
		isRunning = true;
			

		Thread t = new Thread(this);
		t.start();
	}
		
	/** public void  run(), model {
	           while (true) { // Execute one update step
	              
	              ballX += ballSpeedX;
	              ballY += ballSpeedY;
	               
	              if (ballX - ballRadius < 0) {
	                 ballSpeedX = -ballSpeedX; // Reflect along normal
	                 ballX = ballRadius; // Re-position the ball at the edge
	              } else if (ballX + ballRadius > BOX_WIDTH) {
	                 ballSpeedX = -ballSpeedX;
	                 ballX = BOX_WIDTH - ballRadius;
	              }
	              // May cross both x and y bounds
	              if (ballY - ballRadius < 0) {
	                 ballSpeedY = -ballSpeedY;
	                 ballY = ballRadius;
	              } else if (ballY + ballRadius > BOX_HEIGHT) {
	                 ballSpeedY = -ballSpeedY;
	                 ballY = BOX_HEIGHT - ballRadius;
	              }
	              
	              repaint(); 
	              
	              try {
	                 Thread.sleep(1000 / UPDATE_RATE);  
	              } catch (Exception e) {
	   			System.out.print("\nError");
	              }
	   		}*/
	           }
		
	private void resetModel() {
		model.reset(160);
		starttime = System.currentTimeMillis();
		lasttime = System.currentTimeMillis();
		updateBBView();
}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//	model.thrust = 2.5 * BBModel.g;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//	model.thrust = 0;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//	model.thrust = 0;
	}
		
	public void run()
	{
		while (true) 
		{
			if(isRunning)
			{
				if(lasttime != 0)
				{
					double dt = (System.currentTimeMillis() - lasttime) / 1000.0;
					isRunning = model.tick(dt);
	
					updateBBView();
				
				}
				lasttime = System.currentTimeMillis();
			}
			
			try { Thread.sleep(10);} 
			catch (Exception e) {
				/* ignore exception */ }
		}
		// System.out.println("Geschwindigkeit: " + model.velocity);
		// System.out.println("Zeit: " + (lasttime - starttime));
	}
	
	private void updateBBView() {
		view.height = model.height;
		view.velocity = model.velocity;
		view.repaint();		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.reset(160);
		starttime = System.currentTimeMillis();
		lasttime = starttime;
		isRunning = true;
	}
}
