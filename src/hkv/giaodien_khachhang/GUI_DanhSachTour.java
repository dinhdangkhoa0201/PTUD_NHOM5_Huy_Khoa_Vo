package hkv.giaodien_khachhang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import hkv.entities.Tour;




public class GUI_DanhSachTour extends JFrame implements ActionListener{
	private JLabel lblTimKiem,lblDanhSach,lblchonnoiden,lblNoiKhoiHanh,lblGia,lblLoaiXe,lblChonNgay;
	private JButton btnDatTour,btnDatTour1,btnTimKiem,btnDatLai,btnTimKiemnhanh,btnXemChiTiet,btnBoLocTimKiem;
	private JComboBox cbNoiKhoiHanh, cbNoiDen, cbChonXe,cbNgay,cbGia;
	private JTextField txtTimKiem;
	private DefaultTableModel tblDs;
	private JTable table;
	private JSplitPane split;

	private JSplitPane split1 =  new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	private JLabel lblTitle;
	private Dimension dim;
	private JList<Tour> listTour;
	public GUI_DanhSachTour() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public Box BoxMainDatTour() {
		Box box= Box.createVerticalBox();
		add(box);
		box.add(split = new JSplitPane(JSplitPane.VERTICAL_SPLIT));
		box.add(split);

		split.setTopComponent(BoxMain());
		//split.setBottomComponent(createMainPanel());



		split.setEnabled(false);
		return box;
	}

	public Box BoxMain() {
		Box box= Box.createVerticalBox();
		add(box);
		//		box.add(split1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT));
		box.add(split1);
		split1.setTopComponent(BoxTopTimKiem());
		split1.setBottomComponent(createMainPanel());
		//		 tạo sự kiện khi bấm đặt tour 
		btnDatTour.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UI_DatTour gui = new UI_DatTour(); 
				split1.setTopComponent(gui.BoxMain());
				split1.setBottomComponent(null);
			}
		});



		// tạo sự kiện khi bấm xem chi tiết
		btnXemChiTiet.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				split1.setTopComponent(BoxMoTaTour());
				split1.setBottomComponent(null);
			}
		});

		// sự kiện khi bấm vào bộ lọc tìm kiếm
		btnBoLocTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				split1.setTopComponent(null);
				//				split1.removeAll();
				split1.setTopComponent(BoxTopTimKiemBoLoc());
				//				split1.setBottomComponent(createMainPanel());

			}
		});
		split1.setResizeWeight(0.003);
		split1.setEnabled(false);


		return box;
	}

	public JPanel createMainPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		// create list book and set to scrollpane and add to panel
		panel.add(new JScrollPane(listTour = ListTour()),
				BorderLayout.CENTER);		

		return panel;
	}


	public Box BoxTopTimKiem() {
		Box boxtimkiem = Box.createVerticalBox();
		Box B1timkiem;

		boxtimkiem.setOpaque(true);
		boxtimkiem.setBackground(Color.WHITE);
		boxtimkiem.setBackground(Color.WHITE);

		boxtimkiem.add(B1timkiem =  Box.createVerticalBox());
		Box b1,b2,b3,b4,b5,b6;
		B1timkiem.add(Box.createVerticalStrut(5));
		B1timkiem.add(b1 = Box.createHorizontalBox());
		b1.add(lblTitle = new JLabel("Tìm Kiếm Nhanh"));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitle.setForeground(Color.GRAY);


		B1timkiem.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createVerticalStrut(5));
		b1.add(Box.createHorizontalStrut(100));
		b1.add(txtTimKiem =  new JTextField(""));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnTimKiem =  new JButton("Tìm Kiếm"));
		ImageIcon icontimkiem =  new ImageIcon("img/icon/search.png");
		Image image1 = icontimkiem.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icontimkiem = new ImageIcon(newimg1);  // transform it back
		btnTimKiem.setIcon(icontimkiem);
		btnTimKiem.setBackground(Color.WHITE);
		//		btnTimKiemnhanh.setBorder(new LineBorder(Color.WHITE));
		//btnTimKiemnhanh.setBackground(new Color(0,0,0,0));
		// btnTimKiemnhanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/searcher.png"))); // NOI18N
		btnTimKiem.setBorder(null);
		b1.add(Box.createHorizontalStrut(100));
		b1.add(btnBoLocTimKiem = new JButton("Bộ Lọc Tìm Kiếm"));
		B1timkiem.add(Box.createVerticalStrut(20));








		B1timkiem.add(b1 = Box.createVerticalBox());
		B1timkiem.add(b1 = Box.createHorizontalBox());
		b1.add(lblDanhSach = new JLabel("CHỌN CÁC TOUR BẠN MUỐN ĐẶT"));
		B1timkiem.add(Box.createVerticalStrut(20));

		B1timkiem.add(b1 = Box.createVerticalBox());
		B1timkiem.add(b1 = Box.createHorizontalBox());
		b1.add(btnXemChiTiet = new JButton("Xem chi tiết"));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnDatTour =  new JButton("Đặt Tour"));

		return boxtimkiem;
	}

	public Box BoxTopTimKiemBoLoc() {
		Box boxtimkiem = Box.createVerticalBox();
		Box B1timkiem;
		boxtimkiem.setOpaque(true);
		boxtimkiem.setBackground(Color.WHITE);
		boxtimkiem.setBackground(Color.WHITE);

		boxtimkiem.add(B1timkiem =  Box.createVerticalBox());
		Box b1,b2,b3,b4,b5,b6;
		B1timkiem.add(Box.createVerticalStrut(5));
		B1timkiem.add(b1 = Box.createHorizontalBox());
		b1.add(lblTitle = new JLabel("Bộ lọc tìm kiếm"));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitle.setForeground(Color.GRAY);


		b1.add(Box.createHorizontalStrut(100));
		//		b1.add(btnBoLocTimKiem = new JButton("Bộ lọc tìm kiếm"));
		b1.add(Box.createHorizontalStrut(10));
		boxtimkiem.add(B1timkiem =  Box.createVerticalBox());

		B1timkiem.add(Box.createVerticalStrut(2));
		B1timkiem.add(b1 = Box.createHorizontalBox());
		B1timkiem.add(Box.createHorizontalStrut(10));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblNoiKhoiHanh = new JLabel("Nơi Khởi Hành"));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(cbNoiKhoiHanh = new JComboBox());
		cbNoiKhoiHanh.setBackground(Color.WHITE);
		b1.add(Box.createHorizontalStrut(10));	
		b1.add(lblchonnoiden = new JLabel("Chọn Nơi Đến"));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(cbNoiDen = new JComboBox());
		cbNoiDen.setBackground(Color.WHITE);




		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnDatLai = new JButton());
		ImageIcon icon =  new ImageIcon("img/icon/refresh-button.png");
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon = new ImageIcon(newimg);  // transform it back
		btnDatLai.setIcon(icon);
		btnDatLai.setBackground(Color.WHITE);
		btnDatLai.setBorder(new LineBorder(Color.WHITE));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(Box.createHorizontalStrut(10));
		B1timkiem.add(Box.createVerticalStrut(10));


		B1timkiem.add(b1 = Box.createHorizontalBox());
		//B1.add(Box.createVerticalStrut(2));
		//	B1.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblLoaiXe = new JLabel("Chọn Loại Xe"));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(cbChonXe = new JComboBox());
		cbChonXe.setBackground(Color.WHITE);


		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblChonNgay = new JLabel("Chọn Ngày Đi"));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(cbNgay = new JComboBox());
		cbNgay.setBackground(Color.WHITE);

		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblGia= new JLabel("Giá"));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(cbGia = new JComboBox());
		cbGia.setBackground(Color.WHITE);
		b1.add(Box.createHorizontalStrut(10));







		B1timkiem.add(b1 = Box.createVerticalBox());
		B1timkiem.add(b1 = Box.createHorizontalBox());
		b1.add(lblDanhSach = new JLabel("CHỌN CÁC TOUR BẠN MUỐN ĐẶT"));
		B1timkiem.add(Box.createVerticalStrut(20));

		B1timkiem.add(b1 = Box.createVerticalBox());
		B1timkiem.add(b1 = Box.createHorizontalBox());
		b1.add(btnXemChiTiet = new JButton("Xem chi tiết"));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(btnDatTour1 =  new JButton("Đặt Tour"));

		
		//		 tạo sự kiện khi bấm đặt tour bộ lọc tìm kiếm
		btnDatTour1.addActionListener(new ActionListener() {

			@Override 
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				UI_DatTour gui = new UI_DatTour(); 
				split1.setTopComponent(gui.BoxMain());
				split1.setBottomComponent(null);
			}
		});


				Dimension dim = new Dimension(80, 20);
				lblchonnoiden.setPreferredSize(dim);;
				lblNoiKhoiHanh.setPreferredSize(new Dimension(100, 20));
				lblChonNgay.setPreferredSize(dim);
				lblLoaiXe.setPreferredSize(dim);
				cbGia.setPreferredSize(new Dimension(80,20));



		return boxtimkiem;
	}
	public JList<Tour>  ListTour() {
		Box box = Box.createVerticalBox();	
		Box B1;
		box.add(B1 =  Box.createVerticalBox());
		Box b1,b2,b3,b4,b5,b6;
		B1.add(Box.createVerticalStrut(5));
		B1.add(b1 = Box.createHorizontalBox());



		box.add(Box.createVerticalStrut(10));
		box.add(b1 = Box.createHorizontalBox());
		box.add(lblDanhSach = new JLabel("CHỌN CÁC TOUR BẠN MUỐN ĐẶT"));
		box.add(Box.createVerticalStrut(20));
		ImageIcon aboutIcon = new ImageIcon("img/hinh1.jfif");
		b2= Box.createHorizontalBox();
		box.add(b2);


		Icon image;

		DefaultListModel<Tour> defaultListModel = new DefaultListModel<Tour>();
		defaultListModel.addElement(new Tour("HCM-HN_001", "Hồ Chí Minh - Hà Nội","21-9-2019","30-9-2019","Ô Tô", 200000, "img/hinh1.jfif", "5/30"));
		defaultListModel.addElement(new Tour("NT-DL_001", "Nha Trang - Đà Lạt","21-9-2019","30-9-2019","Ô Tô", 5600000, "img/hinh1.jfif", "2/40"));
		defaultListModel.addElement(new Tour("HCM-TH_001", "Hồ Chí Minh - Thanh Hóa","21-9-2019","30-9-2019","Ô Tô", 5100000, "img/hinh1.jfif", "3/30"));
		defaultListModel.addElement(new Tour("HCM_DN_001", "Hồ Chí Minh - Đà Nẵng","21-9-2019","30-9-2019","Ô Tô", 9800000, "img/hinh1.jfif", "4/45"));
		defaultListModel.addElement(new Tour("HCM-HN_001", "Hồ Chí Minh - Hà Nội","21-9-2019","30-9-2019","Ô Tô", 200000, "img/hinh1.jfif", "5/30"));
		defaultListModel.addElement(new Tour("NT-DL_001", "Nha Trang - Đà Lạt","21-9-2019","30-9-2019","Ô Tô", 5600000, "img/hinh1.jfif", "2/40"));
		defaultListModel.addElement(new Tour("HCM-TH_001", "Hồ Chí Minh - Thanh Hóa","21-9-2019","30-9-2019","Ô Tô", 5100000, "img/hinh1.jfif", "3/30"));
		defaultListModel.addElement(new Tour("HCM_DN_001", "Hồ Chí Minh - Đà Nẵng","21-9-2019","30-9-2019","Ô Tô", 9800000, "img/hinh1.jfif", "4/45"));
		JList<Tour> list = new JList<Tour>(defaultListModel);  
		list.setCellRenderer(new pnl_MoTaNganDatTour());
		JScrollPane scroll = new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		return list;
	}


	private JLabel lblSoLuongKH,lblNguoiLon,lblTreEm,lblThongTinLienHe,lblTieuDe,lblThanhToan,lblXacNhan;
	private JLabel lbltenKH,lblSDT,lblEmail,lblDiaChi,lblgioiTinh,lblTuoi;
	private JTextField txtNguoiLon,txtTreEm;
	private JButton btnTroVe,btnTiepTheo,btnThanhToan;

	/////////////////////////////////////////////////////////////////////////////////////////////////////

	private JButton btnQuayLai;
	private JSplitPane splitmoTaTour;
	private JLabel lblTenTour,lblhoatDong,lblChoTong,lblNgaykh,lblNgayKT;


	private Box BoxMoTaTour() {
		Box box= Box.createVerticalBox();
		add(box);
		box.add(splitmoTaTour =  new JSplitPane(JSplitPane.VERTICAL_SPLIT));
		splitmoTaTour.setTopComponent(BoxTopMoTaTour());
		splitmoTaTour.setBottomComponent(BoxMainMoTaTour());
		splitmoTaTour.setResizeWeight(0.02);
		splitmoTaTour.setEnabled(false);
		return box;
	}

	private Box BoxTopMoTaTour() {
		Box box = Box.createVerticalBox();
		box.setOpaque(true);
		box.setBackground(Color.WHITE);
		Box b1;
		box.add(b1 = Box.createHorizontalBox());
		b1.add(btnQuayLai = new JButton());
		ImageIcon iconQuayLait =  new ImageIcon("img/icon/iconsback.png");
		Image image1 = iconQuayLait.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		iconQuayLait = new ImageIcon(newimg1);  // transform it back
		btnQuayLai.setIcon(iconQuayLait);
		btnQuayLai.setBackground(Color.WHITE);
		btnQuayLai.setBorder(new LineBorder(Color.WHITE));

		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblTenTour= new JLabel("Cố Đô Huế"));
		b1.add(Box.createHorizontalStrut(600));

		box.add(b1 =Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblhoatDong = new JLabel("Chuỗi Hoạt Động"));
		ImageIcon iconHoatDong =  new ImageIcon("img/icon/iconsback.png");
		Image image2 = iconHoatDong.getImage(); // transform it 
		Image newimg2 = image2.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		iconHoatDong = new ImageIcon(newimg2);  // transform it back
		lblhoatDong.setIcon(iconHoatDong);
		btnQuayLai.setIcon(iconQuayLait);
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblChoTong = new JLabel("Còn Trống"));
		lblChoTong.setIcon(new ImageIcon("/img/icon/event.png"));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblNgaykh = new JLabel("Ngày Khởi Hành"));
		lblNgaykh.setIcon(new ImageIcon());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblNgayKT= new JLabel("Ngày kết thúc"));
		lblNgaykh.setIcon(new ImageIcon());
		b1.add(Box.createVerticalStrut(20));
		return box;
	}

	private Box BoxMainMoTaTour() {
		Box box = Box.createVerticalBox();
		box.setOpaque(true);
		box.setBackground(Color.WHITE);


		return box;
	}



	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//		Object obj = e.getSource();
		//		if(obj.equals(btnDatTour))
		//		{
		//			UI_DatTour gui = new UI_DatTour(); 
		//			split.setTopComponent(gui.BoxMain());
		//		}

	}


}
