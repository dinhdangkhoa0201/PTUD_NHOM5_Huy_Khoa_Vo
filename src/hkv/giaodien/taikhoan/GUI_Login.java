package hkv.giaodien.taikhoan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

import com.jtattoo.plaf.JTattooUtilities;
import javax.swing.SwingConstants;
import java.awt.Component;

public class GUI_Login extends JFrame{
	private JLabel lblTitle, lblUser, lblPwd, lblForget, lblRegister;
	private JTextField txtUserName;
	private JPasswordField pwdPass;
	private JButton btnLogin, btnCancel;
	private JCheckBox chkRemeber;

	public GUI_Login() {
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
				new GUI_Login().setVisible(true);
			}
		});
	}

	public void disPlay(){
//		setTitle("- Login -");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void detailDisPlay(){
		Box box = Box.createVerticalBox();
		Box B = Box.createVerticalBox();
		Box b = Box.createHorizontalBox();
		getContentPane().add(box, BorderLayout.NORTH);
		box.add(B = Box.createVerticalBox());
		B.add(Box.createVerticalStrut(10));
		B.add(b = Box.createHorizontalBox());

		Icon icon = new ImageIcon("img//logos-hkv.png");
		b.add(lblTitle = new JLabel(icon));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setForeground(Color.GREEN);
		B.add(Box.createVerticalStrut(10));
		B.add(b = Box.createHorizontalBox());

		b.add(Box.createHorizontalStrut(10));
		b.add(lblUser = new JLabel("Email"));
		b.add(Box.createHorizontalStrut(10));
		b.add(txtUserName = new JTextField());
		b.add(Box.createHorizontalStrut(10));
		B.add(Box.createVerticalStrut(10));
		B.add(b = Box.createHorizontalBox());

		b.add(Box.createHorizontalStrut(10));
		b.add(lblPwd = new JLabel("Password"));
		b.add(Box.createHorizontalStrut(10));
		b.add(pwdPass = new JPasswordField());
		b.add(Box.createHorizontalStrut(10));
		B.add(Box.createVerticalStrut(15));
		B.add(b = Box.createHorizontalBox());

		b.add(chkRemeber = new JCheckBox("Remember me"));
		b.add(Box.createHorizontalStrut(220));
		Component verticalStrut = Box.createVerticalStrut(15);
		verticalStrut.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		B.add(verticalStrut);
		B.add(b = Box.createHorizontalBox());

		b.add(btnLogin = new JButton("Login"));
		b.add(Box.createHorizontalStrut(20));
		b.add(btnCancel = new JButton("Cancel"));
		B.add(Box.createVerticalStrut(30));
		B.add(b = Box.createHorizontalBox());
		
		b.add(lblForget = new JLabel("Forget password?"));
		
		b.add(Box.createHorizontalStrut(200));
		b.add(lblRegister = new JLabel("Register"));
		
		lblForget.setFont(new Font("Arial", Font.ITALIC, 15));
		lblForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lblRegister.setFont(new Font("Arial", Font.ITALIC, 15));
		lblRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		txtUserName.setToolTipText("User");
		pwdPass.setToolTipText("Password");

		btnLogin.setMaximumSize(new Dimension(200, 100));
		btnCancel.setMaximumSize(new Dimension(200, 100));
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lblUser.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPwd.setFont(new Font("Arial", Font.PLAIN, 25));
		lblUser.setPreferredSize(new Dimension(lblPwd.getMaximumSize().width, 0));

		txtUserName.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.WHITE));
		pwdPass.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.WHITE));

		txtUserName.setFont(new Font("Arial", Font.ITALIC, 30));
		pwdPass.setFont(new Font("Arial", Font.BOLD, 30));
		chkRemeber.setAlignmentX(LEFT_ALIGNMENT);
		chkRemeber.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
		btnCancel.setFont(new Font("Arial", Font.BOLD, 20));

		Color colorLogin = new Color(51, 153, 255);
		btnLogin.setBackground(colorLogin);
		Color colorCancel = new Color(255, 0, 0);
		btnCancel.setBackground(colorCancel);
		
	}
}
