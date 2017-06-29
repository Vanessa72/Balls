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
	
	
		public static void main(String[] args) {
			new BBControl();
		}
		
		public BBControl()
		{
		
			model = new BBModel();
		
			view = new BBView(200);
			view.setPreferredSize(new Dimension(400, 400));
			
	
			
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

