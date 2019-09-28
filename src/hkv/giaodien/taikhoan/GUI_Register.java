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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class GUI_Register extends JFrame{
	private JLabel lblTitle, lblEmail, lblUserName, lblRePass, lblPwd, lblDangNhap, lblPhone, lblHoTenLot, lblTen;
	private JTextField txtUserName, txtEmail, txtPhone, txtHoTenLot, txtTen;
	private JPasswordField pwdPass, pwdRePass;
	private JButton btnRegister, btnCancel;
	private JCheckBox chkRemeber;
	public GUI_Register() {
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
				new GUI_Register().setVisible(true);
			}
		});
	}

	public void disPlay(){
//		setTitle("- Login -");
		setSize(700, 700);
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

		
//		Icon icon = new ImageIcon("img//logos-hkv.png");
		b.add(lblTitle = new JLabel("Register"));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setForeground(Color.GREEN);
		B.add(Box.createVerticalStrut(10));
		B.add(b = Box.createHorizontalBox());

		b.add(Box.createHorizontalStrut(10));
		b.add(lblHoTenLot = new JLabel("Họ và Tên Đệm"));
		b.add(Box.createHorizontalStrut(10));
		b.add(txtHoTenLot = new JTextField());
		b.add(Box.createHorizontalStrut(10));
		b.add(lblTen = new JLabel("Tên"));
		b.add(Box.createHorizontalStrut(10));
		b.add(txtTen = new JTextField());
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
		b.add(lblUserName = new JLabel("User Name"));
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
		B.add(Box.createVerticalStrut(10));
		B.add(b = Box.createHorizontalBox());
		
		b.add(Box.createHorizontalStrut(10));
		b.add(lblRePass = new JLabel("Re-Password"));
		b.add(Box.createHorizontalStrut(10));
		b.add(pwdRePass = new JPasswordField());
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

		b.add(chkRemeber = new JCheckBox("Remember me"));
		b.add(Box.createHorizontalStrut(220));
		B.add(Box.createVerticalStrut(10));
		B.add(b = Box.createHorizontalBox());

		b.add(btnRegister = new JButton("Register"));
		b.add(Box.createHorizontalStrut(20));
		b.add(btnCancel = new JButton("Cancel"));
		B.add(Box.createVerticalStrut(30));
		B.add(b = Box.createHorizontalBox());
		
		b.add(lblDangNhap = new JLabel("Bạn đã có mật khẩu"));
		
//		b.add(Box.createHorizontalStrut(200));
//		b.add(lblRegister = new JLabel("Register"));

		lblDangNhap.setFont(new Font("Arial", Font.ITALIC, 15));
		lblDangNhap.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		
//		lblRegister.setFont(new Font("Arial", Font.ITALIC, 15));
//		lblRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		txtUserName.setToolTipText("User");
		pwdPass.setToolTipText("Password");

		btnRegister.setMaximumSize(new Dimension(200, 100));
		btnCancel.setMaximumSize(new Dimension(200, 100));
		btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 25));
		lblHoTenLot.setFont(new Font("Arial", Font.PLAIN, 25));
		lblTen.setFont(new Font("Arial", Font.PLAIN, 25));
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPwd.setFont(new Font("Arial", Font.PLAIN, 25));
		lblRePass.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 25));
		
		lblEmail.setPreferredSize(new Dimension(lblHoTenLot.getMaximumSize().width, 0));
		lblUserName.setPreferredSize(new Dimension(lblHoTenLot.getMaximumSize().width, 0));
		lblPwd.setPreferredSize(new Dimension(lblHoTenLot.getPreferredSize().width, 0));
		lblRePass.setPreferredSize(new Dimension(lblHoTenLot.getPreferredSize().width, 0));
		lblPhone.setPreferredSize(new Dimension(lblHoTenLot.getMaximumSize().width, 0));
		
		txtEmail.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.WHITE));
		txtHoTenLot.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.WHITE));
		txtTen.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.WHITE));
		txtUserName.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.WHITE));
		pwdPass.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.WHITE));
		pwdRePass.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.WHITE));
		txtPhone.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.WHITE));
		
		
		txtEmail.setFont(new Font("Arial", Font.ITALIC, 30));
		txtHoTenLot.setFont(new Font("Arial", Font.ITALIC, 30));
		txtTen.setFont(new Font("Arial", Font.ITALIC, 30));
		txtUserName.setFont(new Font("Arial", Font.ITALIC, 30));
		pwdPass.setFont(new Font("Arial", Font.BOLD, 30));
		pwdRePass.setFont(new Font("Arial", Font.ITALIC, 30));
		txtPhone.setFont(new Font("Arial", Font.ITALIC, 30));
		
		
		chkRemeber.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		btnRegister.setFont(new Font("Arial", Font.BOLD, 20));
		btnCancel.setFont(new Font("Arial", Font.BOLD, 20));

		Color colorLogin = new Color(51, 153, 255);
		btnRegister.setBackground(colorLogin);
		Color colorCancel = new Color(255, 0, 0);
		btnCancel.setBackground(colorCancel);
	}
}	
