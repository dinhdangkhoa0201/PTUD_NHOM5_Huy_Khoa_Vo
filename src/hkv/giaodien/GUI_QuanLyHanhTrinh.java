package hkv.giaodien;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import main.GUI_Main;

public class GUI_QuanLyHanhTrinh extends JFrame{
	/**
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSplitPane splitPane;
	public GUI_QuanLyHanhTrinh() {
		// TODO Auto-generated constructor stub
		setSize(400, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				new GUI_Main().setVisible(true);
			}
		});
	}
	
	public Box boxQuanLyHanhTrinh() {
		Box box = Box.createVerticalBox();
		box.add(splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT));
		splitPane.setResizeWeight(0.3);
		splitPane.setOneTouchExpandable(true);
		
		
		return box;
	}
	
	
}
