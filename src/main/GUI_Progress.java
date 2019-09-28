package main;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.UIManager;

public class GUI_Progress extends JFrame{
	JProgressBar bar;
	Timer timer;
	int i = 0;

	public GUI_Progress() {
		// TODO Auto-generated constructor stub
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e){}
		setVisible(true);
		
		
		// Create a progress bar
		bar =new JProgressBar();
		// Paint the percent complete on progress bar
		bar.setStringPainted(true);
		// Set a size (optional)
		bar.setPreferredSize(new Dimension(500,30));
		// Start at 0
		bar.setMinimum(0);
		// End at 1000
		bar.setMaximum(1000);
		// Create a timer that executes for every 2 millisec
		timer = new Timer(2,new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				if(i>=1001) {
					timer.stop();
					cls();
				}
				bar.setValue(i++);
			}
		});
		// Start the timer
		timer.start();
		add(bar);
		pack();
	}
	
	public void cls() {
		this.dispose();
		GUI_Starting gui_Starting = new GUI_Starting();
		gui_Starting.show();
	}
	
	public static void main(String args[])
	{
		new GUI_Progress();
	}


}
