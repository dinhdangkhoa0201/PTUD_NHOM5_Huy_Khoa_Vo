package hkv.giaodien.taikhoan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class GUI_ForgetPassword extends JFrame {
	private JLabel lblTitle, lblEmail, lblUserName, lblRePass, lblPwd, lblForget, lblRegister, lblPhone;
	private JTextField txtUserName, txtEmail, txtPhone;
	private JPasswordField pwdPass, pwdRePass;
	private JButton btnCheck, btnCancel;
	private JCheckBox chkRemeber;
	public GUI_ForgetPassword() {
		// TODO Auto-generated constructor stub
		disPlay();
		detailDisPlay();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				try {
					//here you can put the selected theme class name in JTattoo
					UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

				} catch (ClassNotFoundException ex) {
					java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				}
				new GUI_ForgetPassword().setVisible(true);
			}
		});
	}

	public void disPlay(){
//		setTitle("- Login -");
		setSize(600, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void detailDisPlay(){
		Box box = Box.createVerticalBox();
		Box B = Box.createVerticalBox();
		Box b = Box.createHorizontalBox();
		add(box, BorderLayout.NORTH);
		box.add(B = Box.createVerticalBox());
		B.add(Box.createVerticalStrut(10));
		B.add(b = Box.createHorizontalBox());

		
//		Icon icon = new ImageIcon("img//logos-hkv.png");
		b.add(lblTitle = new JLabel("Forget Password"));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setForeground(Color.GREEN);
		B.add(Box.createVerticalStrut(10));
		B.add(b = Box.createHorizontalBox());

		b.add(Box.createHorizontalStrut(10));
		b.add(lblEmail = new JLabel("Email"));
		b.add(Box.createHorizontalStrut(10));
		b.add(txtEmail = new JTextField());
		b.add(Box.createHorizontalStrut(10));
		B.add(Box.createVerticalStrut(10));
		B.add(b = Box.createHorizontalBox());
		
		
		b.add(Box.createHorizontalStrut(10));
		b.add(lblPhone = new JLabel("Phone"));
		b.add(Box.createHorizontalStrut(10));
		b.add(txtPhone = new JTextField());
		b.add(Box.createHorizontalStrut(10));
		B.add(Box.createVerticalStrut(10));
		B.add(b = Box.createHorizontalBox());


		b.add(btnCheck = new JButton("Check"));
		b.add(Box.createHorizontalStrut(20));
		b.add(btnCancel = new JButton("Cancel"));
		B.add(Box.createVerticalStrut(30));
		B.add(b = Box.createHorizontalBox());
		
		b.add(lblRegister = new JLabel("Register"));

		
		lblRegister.setFont(new Font("Arial", Font.ITALIC, 15));
		lblRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		

		btnCheck.setMaximumSize(new Dimension(200, 100));
		btnCancel.setMaximumSize(new Dimension(200, 100));
		btnCheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));

		lblEmail.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 25));
		
		lblEmail.setPreferredSize(new Dimension(lblPhone.getMaximumSize().width, 0));
		
		txtEmail.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.WHITE));
		txtPhone.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.WHITE));
		
		txtEmail.setFont(new Font("Arial", Font.ITALIC, 30));
		txtPhone.setFont(new Font("Arial", Font.ITALIC, 30));
		
		
		btnCheck.setFont(new Font("Arial", Font.BOLD, 20));
		btnCancel.setFont(new Font("Arial", Font.BOLD, 20));

		Color colorLogin = new Color(51, 153, 255);
		btnCheck.setBackground(colorLogin);
		Color colorCancel = new Color(255, 0, 0);
		btnCancel.setBackground(colorCancel);
	}
}
