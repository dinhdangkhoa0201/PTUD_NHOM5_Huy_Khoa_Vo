package hkv.giaodien_khachhang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class UI_DatTour  extends JFrame{
	private JLabel lblSoLuongKH,lblNguoiLon,lblTreEm,lblThongTinLienHe,lblDIichVu,lblThanhToan,lblXacNhan,lblNhapThongTinKhachHang;
	private JLabel lbltenKH,lblSDT,lblEmail,lblDiaChi,lblNamSinh,lblGioiTinh;
	private JTextField txtNguoiLon,txtTreEm,txtTenKH,txtSDT,txtEmail,txtDiaChi,txtNamSinh;
	private JButton btnTroVe,btnTiepTheo,btnThanhToan,btnQuayLai,btnXacNhan;
	private JSplitPane split;
	private JList listTour;
	private 	JScrollPane scroll;
	private JTable table;
	private  JSpinner spSoNguoiLon,spSoTreEm;
	private JCheckBox checkDieuKhoan,ckNam,ckNu;
	private DefaultTableModel tableModel;

	public UI_DatTour() {


	}
	public Box BoxMain() {
		Box box= Box.createVerticalBox();
		add(box);
		box.add(split =  new JSplitPane(JSplitPane.VERTICAL_SPLIT));
		split.setTopComponent(BoxTop());
		split.setBottomComponent(BoxDienThongTin1());
		split.setResizeWeight(0.02);

		// Sự kiện khi bấm quay lại để chọn lại  tour
		btnQuayLai.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//				Box box= Box.createVerticalBox();
				//				add(box);
				//				box.add(split =  new JSplitPane(JSplitPane.VERTICAL_SPLIT));
				GUI_DanhSachTour gui = new GUI_DanhSachTour();
				//								split.setTopComponent(gui.BoxTopTimKiem());
				//								split.setBottomComponent(gui.createMainPanel());
				split.removeAll();
				//				split.setBottomComponent(null);
				split.setTopComponent(gui.BoxMainDatTour());
				//				
				//				split.setResizeWeight(0);
				split.setEnabled(false);

			}
		});
		split.setEnabled(false);
		return box;
	}
	public Box BoxTop() {
		Box box = Box.createVerticalBox();
		box.setOpaque(true);
		box.setBackground(Color.WHITE);
		Box b1;
		box.add(b1 = Box.createHorizontalBox());
		b1.add(btnQuayLai = new JButton("Trở về đặt Tour"));
		ImageIcon iconTourDaDat =  new ImageIcon("img/icon/Backicon.png");
		Image image1 = iconTourDaDat.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		iconTourDaDat = new ImageIcon(newimg1);  // transform it back
		btnQuayLai.setIcon(iconTourDaDat);
		btnQuayLai.setBackground(Color.WHITE);
		btnQuayLai.setBorder(new LineBorder(Color.WHITE));
		b1.add(Box.createHorizontalStrut(320));


		b1.add(lblThongTinLienHe = new JLabel("1. NHẬP THÔNG TIN KHÁCH HÀNG"));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblThanhToan =new JLabel("2. THANH TOÁN"));
		b1.add(Box.createHorizontalStrut(20));
//		b1.add(lblXacNhan = new JLabel("3. XÁC NHẬN"));
		b1.add(Box.createVerticalStrut(20));


		return box;
	}
	public Box BoxDienThongTin1() {
		Box box = Box.createVerticalBox();
		box.setOpaque(true);
		box.setBackground(Color.WHITE);
		Box B1;
		Box b1;
		SpinnerModel value =  new SpinnerNumberModel(0, //initial value  
				0, //minimum value  
				10, //maximum value  
				1); //step 
		SpinnerModel value1 =  new SpinnerNumberModel(0, //initial value  
				0, //minimum value  
				10, //maximum value  
				1); //step 
		box.add(b1=Box.createVerticalBox());
		b1.add(lblNhapThongTinKhachHang= new JLabel("NHẬP THÔNG TIN LIÊN HỆ:"));

		box.add(b1=Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblNguoiLon = new JLabel("Người Lớn (Trên 13 tuổi )"));
		b1.add(Box.createHorizontalStrut(100));
		b1.add(spSoNguoiLon = new JSpinner(value));
		spSoNguoiLon.setMaximumSize(new Dimension(100, 20));
		b1.add(Box.createHorizontalStrut(30));


		b1.add(lblTreEm = new JLabel("Trẻ Em (Từ 3 đến 13 tuổi)"));
		b1.add(Box.createHorizontalStrut(100));
		b1.add(spSoTreEm = new JSpinner(value1));
		spSoTreEm.setMaximumSize(new Dimension(100, 20));
		box.add(Box.createVerticalStrut(20));

		box.add( Box.createVerticalBox());
		box.add(b1=Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lbltenKH = new JLabel("Tên Khách Hàng (*)"));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtTenKH= new JTextField());
		b1.add(Box.createHorizontalStrut(40));
		b1.add(lblSDT =  new JLabel("Số điện thoại"));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtSDT= new JTextField());
		b1.add(Box.createHorizontalStrut(40));
		b1.add(lblEmail = new JLabel("Email "));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtEmail= new JTextField(""));
		b1.add(Box.createHorizontalStrut(40));
		box.add(Box.createVerticalStrut(20));

		box.add( Box.createVerticalBox());
		box.add(b1=Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblDiaChi = new JLabel("Địa Chỉ :"));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtDiaChi= new JTextField());
		b1.add(Box.createHorizontalStrut(78));
		b1.add(lblGioiTinh = new JLabel("Giới Tính"));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(ckNam = new JCheckBox("Nam"));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(ckNu= new JCheckBox("Nũ"));
		b1.add(Box.createHorizontalStrut(120));
		b1.add(lblNamSinh = new JLabel("Năm Sinh :"));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtNamSinh= new JTextField());
		b1.add(Box.createHorizontalStrut(40));
		box.add( Box.createVerticalBox());
		box.add(b1=Box.createHorizontalBox());

		box.add( Box.createVerticalBox());
		box.add(b1=Box.createHorizontalBox());
		b1.add(btnXacNhan = new JButton("Thêm Khách Hàng"));

		Dimension dim = new Dimension(110,20);
		Dimension dim1 = new Dimension(110,20);
		txtEmail.setPreferredSize(dim1);
		txtDiaChi.setPreferredSize(dim1);
		txtNamSinh.setPreferredSize(dim1);
		txtSDT.setPreferredSize(dim1);
		txtTenKH.setPreferredSize(dim1);
		lbltenKH.setPreferredSize(dim);
		lblSDT.setPreferredSize(dim);
		lblEmail.setPreferredSize(dim);
		lblDiaChi.setPreferredSize(dim);
		lblGioiTinh.setPreferredSize(dim);
		lblNamSinh.setPreferredSize(dim);
		box.add( Box.createVerticalBox());
		box.add(b1=Box.createHorizontalBox());

		// tạo bảng lưu thông tin khách hàng

		String [] headers = {"STT","Tên Khách Hàng","Số điện thoại ","Email","Địa chỉ ","Giới Tính","Tuổi","Ghi Chú"};
		tableModel = new DefaultTableModel(headers, 0);


		b1.add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.CENTER);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh Sách "));
		int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()-120; 
		int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()*12/17;
		scroll.setPreferredSize(new Dimension(width, height));

		box.add(b1 = Box.createHorizontalBox());

		b1.add(btnTroVe = new JButton("Trở Về"));
		b1.add(Box.createHorizontalStrut(300));
		b1.add(btnTiepTheo = new JButton("Tiếp Theo"));
		box.add(b1= Box.createVerticalBox());
		b1.add(Box.createVerticalStrut(10));
		// Sự kiện khi bấm nút tiếp theo -> NhapThongTinKhachHang
		btnTiepTheo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				split.setBottomComponent(BoxThanhToan());

			}
		});
		lblThongTinLienHe.setForeground(new Color(255,153,0));
		lblThanhToan.setForeground(Color.black);
		//lblXacNhan.setForeground(Color.black);
		return box;
	}
	private JLabel lblTenTourThanhToan,lblMaTourThanhToan,lblNgayKhoiHanh,lblNgayKetThuc,lblThoiGian,lblGiaNguoiLon,lblGiaTreEm,lblPhuongTHucThanhToan,lblTongGia,lblTongNguoi;
	private JButton btnThanhToanTour;
	public Box BoxThanhToan() {
		Box box = Box.createVerticalBox();
		box.setOpaque(true);
		box.setBackground(Color.WHITE);
		Box b1;
		box.add(b1=Box.createVerticalBox());
		b1.add(lblNhapThongTinKhachHang= new JLabel("THANH TOÁN "));

		box.add(b1=Box.createHorizontalBox());
		b1.add(lblMaTourThanhToan = new JLabel("  Mã Tour: "));
		ImageIcon iconMaTourThanhToan =  new ImageIcon("img/icon/Bar-Code-icon.png");
		Image image1 = iconMaTourThanhToan.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		iconMaTourThanhToan = new ImageIcon(newimg1);  // transform it back
		lblMaTourThanhToan.setIcon(iconMaTourThanhToan);
		//lblMaTourThanhToan.setIcon(new ImageIcon("/img/icon/Bar-Code-icon.png"));
		b1.add(Box.createHorizontalStrut(200));
		b1.add(lblTenTourThanhToan = new JLabel("Tên Tour: "));
		ImageIcon iconTenTourThanhToan =  new ImageIcon("img/icon/email-send-icon.png");
		Image image2 = iconTenTourThanhToan.getImage(); // transform it 
		Image newimg2 = image2.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		iconTenTourThanhToan = new ImageIcon(newimg2);  // transform it back
		lblTenTourThanhToan.setIcon(iconTenTourThanhToan);

		box.add(b1=Box.createHorizontalBox());
		b1.add(lblNgayKhoiHanh = new JLabel("Ngày Khởi Hành: "));
		lblNgayKhoiHanh.setIcon(new ImageIcon("img/icon/calendar.png"));
		b1.add(Box.createHorizontalStrut(200));
		b1.add(lblNgayKetThuc =new JLabel("Ngày Kết Thúc: "));
		lblNgayKetThuc.setIcon(new ImageIcon("img/icon/calendar.png"));
		//	b1.add(Box.createVerticalStrut(20));


		box.add(b1 = Box.createHorizontalBox());
		b1.add(lblGiaNguoiLon = new JLabel("Giá Người Lớn :"));
		lblGiaNguoiLon.setIcon(new ImageIcon("img/icon/money-bag.png"));
		b1.add(Box.createHorizontalStrut(200));
		b1.add(lblGiaTreEm = new JLabel("Giá Trẻ Em: "));	
		lblGiaTreEm.setIcon(new ImageIcon("img/icon/money-bag.png"));

		box.add(b1 = Box.createHorizontalBox());
		b1.add(lblTongNguoi = new JLabel("Tổng Người: "));
		lblTongNguoi.setIcon(new ImageIcon("img/icon/user_info.png"));
		b1.add(Box.createHorizontalStrut(200));
		b1.add(lblTongGia = new JLabel("TỔNG GIÁ: "));
		lblTongGia.setIcon(new ImageIcon("img/icon/money-bag.png"));
		box.add(b1= Box.createVerticalBox());

		b1.add(Box.createVerticalStrut(100));
		b1.add(checkDieuKhoan = new JCheckBox("Tôi đã đọc và đồng ý điều khoản"));
		checkDieuKhoan.setForeground(Color.RED);
		box.add(b1 = Box.createHorizontalBox());
		box.add(b1= Box.createVerticalBox());
		DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
		defaultListModel.addElement("Các Điều Khoản");
		JList<String> list = new JList<String>(defaultListModel);  
		//list.setCellRenderer(new pnl_MoTaNganDatTour());
		JScrollPane scroll = new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		b1.add(scroll);
		box.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnThanhToanTour = new JButton("   Thanh Toán   "));
		
		// Sự kiện khi bấm thanh toán
		btnThanhToanTour.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showOptionDialog(this,"Bạn có chắc thanh toán","Thanh Toán",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,"Có", "");
			}
		});
		
		box.add(b1 = Box.createHorizontalBox());
		b1.add(btnTroVe = new JButton("Trở Về"));
		b1.add(Box.createHorizontalStrut(300));
	//	b1.add(btnTiepTheo = new JButton("Tiếp Theo"));
		box.add(b1= Box.createVerticalBox());
		b1.add(Box.createVerticalStrut(10));


		// Sự Kiện khi bấm nút trở về -> BoxDienThongTin1
		btnTroVe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				split.setBottomComponent(BoxDienThongTin1());
			}
		});

		// sự kiện khi bấm nút tiếp theo -> BoxThanhToan
//		btnTiepTheo.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				split.setBottomComponent(XacNhan());
//			}
//		});

		lblThongTinLienHe.setForeground(Color.black);
		lblThanhToan.setForeground(new Color(255,153,0));
		//lblXacNhan.setForeground(Color.black);
		return box;
	}


//	public Box XacNhan() {
//		Box box = Box.createVerticalBox();
//		box.setOpaque(true);
//		box.setBackground(Color.WHITE);
//		Box b1;
//		box.add(b1=Box.createVerticalBox());
//		b1.add(lblNhapThongTinKhachHang= new JLabel("XÁC NHẬN THÔNG TIN KHÁCH HÀNG"));
//
//		box.add(b1=Box.createVerticalBox());
//		b1.add(lblNguoiLon = new JLabel("Người Lớn (Trên 13 tuổi )"));
//		b1.add(Box.createHorizontalStrut(20));
//		b1.add(txtNguoiLon = new JTextField());
//		txtNguoiLon.setBounds(40, 80, 40, 20);
//
//		box.add(b1= Box.createVerticalBox());
//		b1.add(lblTreEm = new JLabel("Trẻ Em (Từ 3 đến 13 tuổi)"));
//		b1.add(Box.createHorizontalStrut(20));
//		b1.add(Box.createHorizontalStrut(20));
//		b1.add(txtTreEm = new JTextField());
//		b1.add(Box.createVerticalStrut(20));
//		box.add(b1 = Box.createHorizontalBox());
//
//		b1.add(btnTroVe = new JButton("Trở Về"));
//		b1.add(Box.createHorizontalStrut(300));
//		b1.add(btnTiepTheo = new JButton("Tiếp Theo"));
//		box.add(b1= Box.createVerticalBox());
//		b1.add(Box.createVerticalStrut(10));
//
//
//		// Sự Kiện khi bấm nút trở về -> BoxDienThongTin1
//		btnTroVe.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				split.setBottomComponent(BoxThanhToan());
//			}
//		});
//
//		lblThongTinLienHe.setForeground(Color.black);
//		lblThanhToan.setForeground(Color.black);
//		lblXacNhan.setForeground(new Color(255,153,0));
//
//		return box;
//	}
}
