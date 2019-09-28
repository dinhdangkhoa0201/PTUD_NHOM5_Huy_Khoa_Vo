package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Component;

public class GUI_Starting extends JFrame{
	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private JLabel lblTenNhom;
	private JTextArea txtTextIntr;
	public GUI_Starting() {
		// TODO Auto-generated constructor stub
		display();
		detailDisplay();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
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
				
				new GUI_Starting().setVisible(true);
			}
		});
		
	}
	
	public void display() {
		String title = "PHẦN MỀM QUẢN LÝ THÔNG TIN DU LỊCH";
		
		setTitle(title);
		ImageIcon img = new ImageIcon("img\\icon\\icon_du_lich.png");
		setIconImage(img.getImage());
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		int width = (int) screen.getWidth();
//		int height = (int) screen.getHeight();
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
//		setUndecorated(true);
	}
	
	public void detailDisplay() {
		add(box());
	}
	
	public Box box() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(B);
		B.add(lblTenNhom = new JLabel("NHOM5_DHKTPM13B_Quản Lý Thông Tin Công Ty Du Lịch"));
//		lblTenNhom.setForeground(new Color(242, 242, 242));
		lblTenNhom.setFont(new Font("Arial", Font.BOLD, 15));
		lblTenNhom.setBackground(Color.BLACK);
		
		return box;
	}
}
