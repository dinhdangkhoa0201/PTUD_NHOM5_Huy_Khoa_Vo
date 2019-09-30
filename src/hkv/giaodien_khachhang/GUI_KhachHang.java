package hkv.giaodien_khachhang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
//from  ww  w  . j  ava  2 s. co  m
public class GUI_KhachHang extends JFrame implements ActionListener, MouseListener {
	private JLabel lblMaKH, lblTenKH, lblGioiTinh,lblNamSinh,lbl,DiaChi,lblSDT,lblEmail,lblCMND,lblTimKiem,lblKhachHang,lblTenKhachHag;
	private JLabel lblDanhSach;
	private JTextField txtMaKH,txtTenKH, txtGioiTinh, txtNamSinh,txtDiaChi,txtSDT,txtEmail,txtCMND;
	private DefaultTableModel tblModel =  new DefaultTableModel();
	private JTable tblDs;
	private JMenuBar mbTenKH;
	private JTable table;
	private JButton btnDatTour,btnTourDaDat,btnThongBao,btnDangXuat;
	private JSplitPane split1;
	private JSplitPane split;
	JTabbedPane tab;
	public GUI_KhachHang() {
		//	setExtendedState(JFrame.MAXIMIZED_BOTH);
		String title = "ĐẶT TOUR ";
		setTitle(title);;
		setBackground(Color.WHITE);
		setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		setLocationRelativeTo(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(true);
		add(Main());

	}
//	public static void main(String[] args) {
//		new GUI_KhachHang().setVisible(true);
//	}
	
	
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

				new GUI_KhachHang().setVisible(true);
			}
		});
	}
	

	public void disPlay(){
		String title = "ĐẶT TOUR ";
		setTitle(title);;

		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		//				setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
	}
	public Box Main() {

		Box box= Box.createVerticalBox();
		add(box);
		box.add(split =  new JSplitPane(JSplitPane.VERTICAL_SPLIT));
		split.setLeftComponent(BoxTop());
		split.setBottomComponent(BoxMain());
		split.setResizeWeight(0.02);
		split.setEnabled(false);
		return box;  
	}


	public Box BoxTop() {
		Box box = Box.createVerticalBox();
		box.setOpaque(true);
		box.setBackground(Color.WHITE);
		Box b1;
		JMenu menuKH ;


		box.add(b1 = Box.createVerticalBox());
		
//		b1.add(menuKH = new JMenu("Lê Đình Huy"));
//		JMenuItem jmiDangXuat,jmiThongtincanhan;
//		jmiDangXuat=  new JMenuItem("Đăng Xuất");
//		jmiThongtincanhan = new JMenuItem("Thông Tin Cá Nhân");
//		menuKH.add(jmiDangXuat);
//		menuKH.add(jmiThongtincanhan);
//		JMenuBar mnb = new JMenuBar();
//		mnb.add(menuKH).setSize(50,20);;
//		box.add(Box.createVerticalStrut(20));
//
//
		box.add(b1 = Box.createVerticalBox());
		b1.add(lblKhachHang = new JLabel(" Lê Đình Huy"));
		ImageIcon iconkhachhang =  new ImageIcon("icon/round-account-button-with-user-inside.png");
		Image image = iconkhachhang.getImage(); // transform it 
		Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		iconkhachhang = new ImageIcon(newimg);  // transform it back
		lblKhachHang.setIcon(iconkhachhang);
//		menuKH.setIcon(iconkhachhang);
		
		
		
		JMenuBar mb;    
		JMenu khachhang;    
		JMenuItem dangxuat,thongtincanhan;           
			dangxuat=new JMenuItem("Đăng Xuất");    
			thongtincanhan=new JMenuItem("Thông Tin Cá Nhân");    
			mb=new JMenuBar();        
			khachhang=new JMenu("                                  ");
			khachhang.setIcon(new ImageIcon("/icon/arrow-point-to-right.png"));
			khachhang.add(dangxuat);khachhang.add(thongtincanhan);
			mb.add(khachhang);
			//f.add(mb);f.add(ta);  
			b1.add(mb);
					
		return box;
	}
	public class Gui_DatTour extends JFrame{

	}
	public class GUI_ThongBao extends JFrame{

	}
	//	public Box boxQuanLyNhanVien() {
	//		Box box = Box.createVerticalBox();
	//		Box B = Box.createHorizontalBox();
	//		box.add(split = new JSplitPane(JSplitPane.VERTICAL_SPLIT));
	//		
	//		split.setResizeWeight(0.03);
	//		
	//		split.setTopComponent(boxTop());
	//		split.setBottomComponent(boxTable());
	//		return box;
	//	}
	public Box BoxMain() {
		
		Box box= Box.createVerticalBox();
		add(box);
		box.add(split1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT));
		box.add(split1);

		GUI_DanhSachTour guidattour =  new GUI_DanhSachTour();
		split1.setLeftComponent(BoxMainLeft());
		split1.setRightComponent(guidattour.BoxMainDatTour());
	
		
		// tạo sự kiện khi bấm tour đã đặt
		btnTourDaDat.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object obj = e.getSource();
				if(obj.equals(btnTourDaDat))
				{
					
					GUI_TourDaDat gui_tourdadat = new GUI_TourDaDat();
					split1.setRightComponent(gui_tourdadat.BoxMainTourDaDat());
					
					btnTourDaDat.setForeground(new Color(51,153,255));
					btnDatTour.setForeground(Color.black);
					btnThongBao.setForeground(Color.black);
					btnTourDaDat.setBackground(new Color(204,204,204));
					btnDatTour.setBackground(Color.WHITE);
					btnThongBao.setBackground(Color.WHITE);
					//split1.setResizeWeight(0.1);
					split1.setEnabled(false);
				}
			}
		});
		// tạo sự kiện khi bấm đặt tour 
		btnDatTour.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object obj = e.getSource();
				if(obj.equals(btnDatTour))
				{
					GUI_DanhSachTour guidattour =  new GUI_DanhSachTour();
					split1.setRightComponent(guidattour.BoxMainDatTour());
					btnDatTour.setForeground(new Color(51,153,255));
					btnTourDaDat.setForeground(Color.BLACK);
					btnThongBao.setForeground(Color.black);
					btnTourDaDat.setBackground(Color.WHITE);
					btnDatTour.setBackground(Color.LIGHT_GRAY);
					btnThongBao.setBackground(Color.WHITE);
					//split1.setResizeWeight(0.1);
					split1.setEnabled(false);
				}
			}
		});
		// tạo sự kiện khi bấm thông báo
		btnThongBao.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object obj = e.getSource();
				if(obj.equals(btnThongBao))
				{
					 GUI_ThongBaoKhachHang gui =  new GUI_ThongBaoKhachHang();
					split1.setRightComponent(gui.BoxMainThongBao());
					btnTourDaDat.setForeground(Color.BLACK);
					btnDatTour.setForeground(Color.black);
					btnThongBao.setForeground(new Color(51,153,255));
					btnDatTour.setForeground(Color.black);
					btnThongBao.setBackground(Color.LIGHT_GRAY);
					btnDatTour.setBackground(Color.WHITE);
					btnTourDaDat.setBackground(Color.WHITE);
					//split1.setResizeWeight(0.1);
					split1.setEnabled(false);
				}
			}
		});
		
		//split1.setResizeWeight(0.1);
		split1.setEnabled(false);
		return box;
	}


	public Box BoxMainLeft() {
		Box box = Box.createVerticalBox();
		// set màu cho box
		box.setOpaque(true);
		box.setBackground(Color.WHITE);
		Box b1;


		box.add(Box.createVerticalStrut(20));


		box.add(b1 = Box.createVerticalBox());
		box.add(Box.createVerticalStrut(15));
		b1.add(btnDatTour = new JButton("  Đặt Tour         "));
		ImageIcon icondattour =  new ImageIcon("icon/earth-pictures.png");
		Image image = icondattour.getImage(); // transform it 
		Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icondattour = new ImageIcon(newimg);  // transform it back
		btnDatTour.setIcon(icondattour);
		btnDatTour.setBackground(Color.WHITE);
	
		btnDatTour.setBorder(new LineBorder(Color.WHITE));
		btnDatTour.setMaximumSize(new Dimension(Short.MAX_VALUE,45));

		box.add(b1= Box.createVerticalBox());
		b1.add(btnTourDaDat = new JButton("  Tour Đã Đặt       "));
		ImageIcon iconTourDaDat =  new ImageIcon("icon/shopping-list.png");
		Image image1 = iconTourDaDat.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		iconTourDaDat = new ImageIcon(newimg1);  // transform it back
		btnTourDaDat.setIcon(iconTourDaDat);
		btnTourDaDat.setMaximumSize(new Dimension(Short.MAX_VALUE, 45));
		btnTourDaDat.setBackground(Color.WHITE);
		btnTourDaDat.setBorder(new LineBorder(Color.WHITE));
		b1.add(Box.createVerticalStrut(15));

		box.add(Box.createVerticalBox());
		b1.add(btnThongBao = new JButton("  Thông Báo        "));
		ImageIcon iconThongBao =  new ImageIcon("icon/notification.png");
		Image image2 = iconThongBao.getImage(); // transform it 
		Image newimg2 = image2.getScaledInstance(30, 30,  java.awt.Image.SCALE_REPLICATE); // scale it the smooth way  
		iconThongBao = new ImageIcon(newimg2);  // transform it back
		btnThongBao.setIcon(iconThongBao);
		btnThongBao.setMaximumSize(new Dimension(Short.MAX_VALUE, 45));
		btnThongBao.setBackground(Color.WHITE);
		btnThongBao.setBorder(new LineBorder(Color.WHITE));


		return box;
	}
	public Box BoxMainCenter() {
		Box box = Box.createVerticalBox();
		Box b1;
		box.add(Box.createVerticalStrut(10));
		box.add(b1 = Box.createHorizontalBox());
		box.add(lblDanhSach = new JLabel("CHỌN CÁC TOUR BẠN MUỐN ĐẶT"));
		box.add(Box.createVerticalStrut(20));
		ImageIcon aboutIcon = new ImageIcon("img/hinh1.jfif");
		Box  b2= Box.createHorizontalBox();
		box.add(b2);

		JLabel label  = new JLabel();
		label.setIcon(new ImageIcon("img/hinh1.jfif"));
		Object[] columnNames = { "", "description"};

		Object[][] data = { {  aboutIcon,"Mô TẢ "} };
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable(model){
			public Class getColumnClass(int column) {
				TableColumn tc = table.getColumn("");
				tc.setMinWidth(100);
				tc.setMaxWidth(100);
				table.setRowHeight(100);
				return (column == 0) ? Icon.class : Object.class;
			}
		};


		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane);

		// JScrollPane scroll = new JScrollPane(tblDs,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		b2.add(scrollPane);
		Box b3;
		box.add(b3 = Box.createVerticalBox());
		b3.add(Box.createVerticalStrut(10));
		b3.add(btnDatTour = new JButton("Đặt Tour"));
		b3.add(btnDatTour,BorderLayout.EAST);
		b3.add(Box.createVerticalStrut(10));
		return box;
	}


	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnDatTour)) {
			GUI_DanhSachTour guidattour =  new GUI_DanhSachTour();
			//	split1.setRightComponent(BoxMainCenter());
			split1.setRightComponent(guidattour.BoxMainDatTour());
		}
	}

}