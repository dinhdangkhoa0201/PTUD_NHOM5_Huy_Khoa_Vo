package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import hkv.giaodien.GUI_QuanLyKhachHang;
import hkv.giaodien.GUI_QuanLyNhanVien;
import hkv.giaodien.GUI_QuanLyTour;
import hkv.giaodien.GUI_ThongKe;
import hkv.giaodien.Gui_QuanLyHoaDon;

import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;


public class GUI_Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSplitPane split, splitLeft;
	private JLabel lblTitle, lblUserName;
	private JButton btnDangXuat, btnDoiMatKhau;
	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private JTabbedPane tab;
	
	public GUI_Main() {
		// TODO Auto-generated construtor stub
		disPlay();
		detailDisPlay();
//		Database database = new Database("QuanLyDuLich", "sa", "025825273a");
//		
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

	public void disPlay(){
		String title = "PHẦN MỀM QUẢN LÝ THÔNG TIN DU LỊCH";
		
		setTitle(title);
		ImageIcon img = new ImageIcon("img\\icon\\icon_du_lich.png");
		setIconImage(img.getImage());
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		int width = (int) screen.getWidth();
		int height = (int) screen.getHeight();
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
	}

	public void detailDisPlay(){


		Box box = Box.createVerticalBox();

		add(box);
		box.add(split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT));

		split.setLeftComponent(boxLeft());
		split.setRightComponent(boxRight());
		split.setResizeWeight(0.2);
		split.setEnabled(false);
		split.setOneTouchExpandable(true);
	}

	public Box boxLeft() {
		Box box = Box.createVerticalBox();
		box.add(splitLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT));
		new GUI_QuanLyNhanVien();
		splitLeft.setTopComponent(boxLeftTop());
		splitLeft.setBottomComponent(null);
		splitLeft.setResizeWeight(0.1);
		splitLeft.setEnabled(false);
		return box;
	}

	public Box boxLeftTop() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(Box.createVerticalStrut(10));
		box.add(B);
		B.add(lblTitle = new JLabel());
		lblTitle.setSize(150, 150);
		setPicture(lblTitle, "img\\khoa.jpg");
		box.add(Box.createVerticalStrut(5));
		box.add(B = Box.createHorizontalBox());
		B.add(lblUserName = new JLabel("Hello Khoa Cyruss"));
		box.add(Box.createVerticalStrut(5));
		box.add(B = Box.createHorizontalBox());
		B.add(btnDangXuat = new JButton("Đăng Xuất"));
		B.add(btnDoiMatKhau = new JButton("Đổi mật khẩu"));

		btnDangXuat.setFont(new Font("Arial", Font.ITALIC, 20));
		btnDoiMatKhau.setFont(new Font("Arial", Font.ITALIC, 20));

		btnDangXuat.setMaximumSize(new Dimension(200, 40));	
		btnDoiMatKhau.setMaximumSize(new Dimension(200, 40));
		lblUserName.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 25));

		btnDangXuat.setBackground(Color.RED);
		btnDoiMatKhau.setBackground(Color.GREEN);
		return box;
	}

	public Box boxLeftBottom() {
		screen.getWidth();
		screen.getHeight();
		Box box = Box.createVerticalBox();
		new GUI_QuanLyNhanVien();
		return box;
	}

	public Box boxRight(){ // Giao diện chính
		Box box = Box.createVerticalBox();
		box.add(tab = new JTabbedPane());
//		tab.setBackground(Color.RED);
		
//		tab.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		tab.setFont(new Font("Arial", Font.ITALIC, 25));
		
		GUI_QuanLyNhanVien gui_QuanLyNhanVien = new GUI_QuanLyNhanVien();
		tab.add("Quản Lý Nhân Viên", gui_QuanLyNhanVien.boxQuanLyNhanVien());
		
		splitLeft.setBottomComponent(gui_QuanLyNhanVien.boxNhanVien());
		
		GUI_QuanLyKhachHang gui_QuanLyKhachHang = new GUI_QuanLyKhachHang();
		tab.add("Quản Lý Khách Hàng", gui_QuanLyKhachHang.boxQuanLyKhachHang());
		
		GUI_ThongKe gui_ThongKe = new GUI_ThongKe();
		tab.add("Thống Kê", gui_ThongKe.boxThongKe());
		
		
		GUI_QuanLyTour gui_QuanLyTour = new GUI_QuanLyTour();
		tab.add("Quản Lý Tour", gui_QuanLyTour.boxQuanLyTour());

		Gui_QuanLyHoaDon gui_QuanLyHoaDon = new Gui_QuanLyHoaDon();
		tab.add("Quản Lý Hoá Đơn", gui_QuanLyHoaDon.boxQuanLyHoaDon());
		
		tab.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JTabbedPane source = (JTabbedPane) e.getSource();
				int index = source.getSelectedIndex();
				String nameTab = source.getTitleAt(index);
				
				if(nameTab.equalsIgnoreCase("Quản Lý Nhân Viên")) {
					splitLeft.setBottomComponent(null);
					GUI_QuanLyNhanVien gui_QuanLyNhanVien = new GUI_QuanLyNhanVien();
					splitLeft.setBottomComponent(gui_QuanLyNhanVien.boxNhanVien());
				}
				else if(nameTab.equalsIgnoreCase("Quản Lý Khách Hàng")) {
					splitLeft.setBottomComponent(null);
					GUI_QuanLyKhachHang gui_QuanLyKhachHang = new GUI_QuanLyKhachHang();
					splitLeft.setBottomComponent(gui_QuanLyKhachHang.boxKhachHang());
				}
				else if(nameTab.equalsIgnoreCase("Quản Lý Tour")) {
					splitLeft.setBottomComponent(null);
					GUI_QuanLyTour gui_QuanLyTour = new GUI_QuanLyTour();
					splitLeft.setBottomComponent(gui_QuanLyTour.boxTour());
				}
				else if(nameTab.equalsIgnoreCase("Quản Lý Hoá Đơn")) {
					splitLeft.setBottomComponent(null);
					Gui_QuanLyHoaDon gui_QuanLyHoaDon = new Gui_QuanLyHoaDon();
					splitLeft.setBottomComponent(gui_QuanLyHoaDon.boxHoaDon());
				}
				
			}
		});
		return box;
	}
	

	public  void setPicture(  JLabel label ,String filename ){
		try {
			BufferedImage image = ImageIO.read(new File(filename));
			int x =label.getSize().width;
			int y =label.getSize().height;
			int ix =image.getWidth();
			int iy =image.getHeight();

			int dx=0;
			int dy=0;
			if(x /y > ix/iy){
				dy=y;
				dx=dy*ix /iy;
			}else{
				dx=x;
				dy=dx*iy/ix;
			}

			ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, BufferedImage.SCALE_SMOOTH));
			label.setIcon(icon);
		} catch (IOException ex) {
			Logger.getLogger(GUI_Main.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
