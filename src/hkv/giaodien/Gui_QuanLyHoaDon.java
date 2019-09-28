package hkv.giaodien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Gui_QuanLyHoaDon extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tblModel, tblModelChiTiet;
	private JTable table, tableChiTiet;
	private JScrollPane sroll, scrollChiTiet;
	private JSplitPane split, splitChiTiet;
	private JLabel lblTitle, lblMaHoaDon, lblMaNhanVien, lblMaKhachHang, lblMaTour, lblNgayLapHoaDon;
	private JLabel lblMaKH, lblTenKH, lblSoDienThoai, lblEmail, lblDiaChi, lblSoNguoiLon, lblSoTreEm, lblSoTreNho, lblSoKhach; 
	private JTextField txtMaKH, txtTenKH, txtSoDienThoai, txtEmail, txtDiaChi, txtSoNguoiLon, txtSoTreEm, txtSoKhach;
	private JTextField txtMaHoaDon, txtMaNhanVien, txtMaKhachHang, txtMaTour, txtNgayLapHoaDon;
	private JButton btnThem, btnXoa, btnLuu, btnXuLy;
	private JDialog dialogChiTietHoaDon;
	private JFrame frame;
	public Gui_QuanLyHoaDon() {
		// TODO Auto-generated constructor stub
		setSize(400, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		add(boxQuanLyHoaDon());
	}

//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				new Gui_QuanLyHoaDon().setVisible(true);
//			}
//		});
//	}
	
	public Box boxQuanLyHoaDon() {
		Box box = Box.createVerticalBox();
		Box.createHorizontalBox();
		box.add(split = new JSplitPane(JSplitPane.VERTICAL_SPLIT));

		split.setResizeWeight(0.03);

		split.setTopComponent(boxTop());
		split.setBottomComponent(boxTable());
		return box;
	}

	public Box boxHoaDon() {
		int fontsize = 15;
		int fontsizetxt = 20;
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(Box.createVerticalStrut(20));
		box.add(B);
		B.add(lblMaHoaDon = new JLabel("Mã Hóa Đơn : "));
		lblMaHoaDon.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(txtMaHoaDon = new JTextField());
		txtMaHoaDon.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtMaHoaDon.setEditable(false);
		lblMaHoaDon.setLabelFor(txtMaHoaDon);
		box.add(Box.createVerticalStrut(30));

		box.add(B = Box.createHorizontalBox());
		B.add(lblMaNhanVien= new JLabel("Mã Nhân Viên : "));
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(txtMaNhanVien = new JTextField());
		lblMaNhanVien.setLabelFor(txtMaNhanVien);
		txtMaNhanVien.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtMaNhanVien.setEditable(false);
		box.add(Box.createVerticalStrut(30));

		box.add(B = Box.createHorizontalBox());
		B.add(lblMaKhachHang= new JLabel("Mã Khách Hàng : "));
		lblMaKhachHang.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(txtMaKhachHang = new JTextField());
		lblMaKhachHang.setLabelFor(txtMaKhachHang);
		txtMaKhachHang.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtMaKhachHang.setEditable(false);
		box.add(Box.createVerticalStrut(30));

		box.add(B = Box.createHorizontalBox());
		B.add(lblMaTour= new JLabel("Mã Tour : "));
		lblMaTour.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(txtMaTour = new JTextField());
		lblMaTour.setLabelFor(txtMaTour);
		txtMaTour.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtMaTour.setEditable(false);
		box.add(Box.createVerticalStrut(30));

//		box.add(B = Box.createHorizontalBox());
//		B.add(lblSoNguoi= new JLabel("Số Người : "));
//		lblSoNguoi.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
//		B.add(txtSoNguoi = new JTextField());
//		lblSoNguoi.setLabelFor(txtSoNguoi);
//		txtSoNguoi.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
//		txtSoNguoi.setEditable(false);
//		box.add(Box.createVerticalStrut(30));

//		box.add(B = Box.createHorizontalBox());
//		B.add(lblTongTien= new JLabel("Tổng Tiền : "));
//		lblTongTien.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
//		B.add(txtTongTien = new JTextField());
//		lblTongTien.setLabelFor(txtTongTien);
//		txtTongTien.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
//		txtTongTien.setEditable(false);
//		box.add(Box.createVerticalStrut(30));		

		box.add(B = Box.createHorizontalBox());
		B.add(lblNgayLapHoaDon= new JLabel("Ngày Lập Hóa Đơn : "));
		lblNgayLapHoaDon.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(txtNgayLapHoaDon = new JTextField());
		lblNgayLapHoaDon.setLabelFor(txtNgayLapHoaDon);
		txtNgayLapHoaDon.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtNgayLapHoaDon.setEditable(false);
		box.add(Box.createVerticalStrut(400));

		box.add(Box.createVerticalStrut(30));
		box.add(B = Box.createHorizontalBox());
		B.add(btnThem = new JButton("Thêm"));
		B.add(Box.createHorizontalStrut(5));
		B.add(btnXoa = new JButton("Xoá"));


		box.add(B = Box.createHorizontalBox());
		B.add(btnLuu = new JButton("Lưu"));
		box.add(Box.createVerticalStrut(50));

		btnThem.setMaximumSize(new Dimension(150, 40));
		btnXoa.setMaximumSize(new Dimension(150, 40));
		btnLuu.setMaximumSize(new Dimension(305, 40));
		btnThem.setFont(new Font("Arial", Font.PLAIN, 20));
		btnXoa.setFont(new Font("Arial", Font.PLAIN, 20));
		btnLuu.setFont(new Font("Arial", Font.PLAIN, 20));


		btnThem.setBackground(Color.GREEN);
		btnXoa.setBackground(Color.RED);
		btnLuu.setBackground(Color.ORANGE);

		lblMaHoaDon.setPreferredSize(new Dimension(lblNgayLapHoaDon.getPreferredSize().width, 20));
		lblMaKhachHang.setPreferredSize(new Dimension(lblNgayLapHoaDon.getPreferredSize().width, 20));
		lblMaNhanVien.setPreferredSize(new Dimension(lblNgayLapHoaDon.getPreferredSize().width, 20));
		lblMaTour.setPreferredSize(new Dimension(lblNgayLapHoaDon.getPreferredSize().width, 20));
//		lblSoNguoi.setPreferredSize(new Dimension(lblNgayLapHoaDon.getPreferredSize().width, 20));
//		lblTongTien.setPreferredSize(new Dimension(lblNgayLapHoaDon.getPreferredSize().width, 20));

		txtMaHoaDon.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtMaKhachHang.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtMaNhanVien.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtMaTour.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtNgayLapHoaDon.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
//		txtSoNguoi.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
//		txtTongTien.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));

		return box;
	}

	private Box boxTop() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();

		box.add(Box.createVerticalStrut(20));
		box.add(B);
		B.add(lblTitle = new JLabel("Danh Sách Hóa Đơn"));

		lblTitle.setFont(new Font("Arial", Font.ITALIC, 30));

		return box;
	}

	private Box boxTable() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(B);
		String [] columnNames = {"STT", "Mã Hóa Đơn", "Mã Khách Hàng", "Mã Nhân Viên", "Mã Tour", "Ngày Lập Hóa Đơn", "Số Người", "Tổng Tiền"};

		tblModel = new DefaultTableModel(columnNames, 1);
		B.add(sroll = new JScrollPane(table = new JTable(tblModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(20);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 && table.getSelectedRow() != -1)
					modalChiTietHoaDon().setVisible(true);
			}
		});

		sroll.setPreferredSize(new Dimension(0, 350));

		return box;
	}

	private JDialog modalChiTietHoaDon() {
		dialogChiTietHoaDon = new JDialog(frame, "Thông Tin Chi Tiết", true);
		dialogChiTietHoaDon.add(boxDanhSachChiTiet());
		dialogChiTietHoaDon.setSize(800, 700);
		dialogChiTietHoaDon.setLocationRelativeTo(null);

		return dialogChiTietHoaDon;
	}

	private Box boxDanhSachChiTiet() {
		Box box = Box.createVerticalBox();
		splitChiTiet = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitChiTiet.setTopComponent(boxChiTietTop());
		splitChiTiet.setBottomComponent(boxChiTietTable());
		splitChiTiet.setResizeWeight(0.49);
		splitChiTiet.setEnabled(false);
		box.add(splitChiTiet);
		return box;
	}

	private Box boxChiTietTop() {
		int ngang = 5;
		int khoangcach = 10;
		int sizelbl = 15;
		int sizetxt = 15;
		
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();

		box.add(Box.createVerticalStrut(khoangcach));
		box.add(B);
		B.add(Box.createHorizontalStrut(ngang));
		B.add(lblMaKH = new JLabel("Mã Khách Hàng"));
		B.add(Box.createHorizontalStrut(ngang));
		B.add(txtMaKH = new JTextField());
		
		B.add(Box.createHorizontalStrut(ngang));
		B.add(lblTenKH = new JLabel("Tên Khách Hàng"));
		B.add(Box.createHorizontalStrut(ngang));
		B.add(txtTenKH = new JTextField());
		
		box.add(Box.createVerticalStrut(khoangcach));
		box.add(B = Box.createHorizontalBox());
		B.add(Box.createHorizontalStrut(ngang));
		B.add(lblSoDienThoai = new JLabel("Số Điện Thoại"));
		B.add(Box.createHorizontalStrut(ngang));
		B.add(txtSoDienThoai = new JTextField());

		B.add(Box.createHorizontalStrut(ngang));
		B.add(lblEmail = new JLabel("Email"));
		B.add(Box.createHorizontalStrut(ngang));
		B.add(txtEmail = new JTextField());
		
		box.add(Box.createVerticalStrut(khoangcach));
		box.add(B = Box.createHorizontalBox());
		
		B.add(Box.createHorizontalStrut(ngang));
		B.add(lblDiaChi = new JLabel("Địa Chỉ"));
		B.add(Box.createHorizontalStrut(ngang));
		B.add(txtDiaChi = new JTextField());
		
		box.add(Box.createVerticalStrut(khoangcach));
		box.add(B = Box.createHorizontalBox());
		
		B.add(Box.createHorizontalStrut(ngang));
		B.add(lblSoNguoiLon = new JLabel("Số Người Lớn"));
		B.add(Box.createHorizontalStrut(ngang));
		B.add(txtSoNguoiLon = new JTextField());

		
		B.add(Box.createHorizontalStrut(ngang));
		B.add(lblSoTreEm = new JLabel("Số Trẻ Em"));
		B.add(Box.createHorizontalStrut(ngang));
		B.add(txtSoTreEm = new JTextField());
		
		B.add(Box.createHorizontalStrut(ngang));
		B.add(lblSoKhach = new JLabel("Số Khách"));
		B.add(Box.createHorizontalStrut(ngang));
		B.add(txtSoKhach = new JTextField());
		
		lblMaKH.setFont(new Font("Times New Roman", Font.PLAIN, sizelbl));
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, sizelbl));
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, sizelbl));
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, sizelbl));
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, sizelbl));
		lblSoNguoiLon.setFont(new Font("Times New Roman", Font.PLAIN, sizelbl));
		lblSoTreEm.setFont(new Font("Times New Roman", Font.PLAIN, sizelbl));
		lblSoKhach.setFont(new Font("Times New Roman", Font.PLAIN, sizelbl));
		lblMaKH.setFont(new Font("Times New Roman", Font.PLAIN, sizelbl));
		
		
		lblSoDienThoai.setPreferredSize(new Dimension(lblMaKH.getPreferredSize().width, lblMaKH.getPreferredSize().height));
		lblDiaChi.setPreferredSize(new Dimension(lblMaKH.getPreferredSize().width, lblMaKH.getPreferredSize().height));
		lblSoNguoiLon.setPreferredSize(new Dimension(lblMaKH.getPreferredSize().width, lblMaKH.getPreferredSize().height));
		lblEmail.setPreferredSize(new Dimension(lblTenKH.getPreferredSize().width, lblTenKH.getPreferredSize().height));
		
		
		
		return box;
	}

	private Box boxChiTietTable() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(B);
		String[] header = {"STT", "Họ và Tên", "Giới Tính", "Ngày Sinh", "Loại Khách", "Giá"};
		tblModelChiTiet = new DefaultTableModel(header, 200);
		scrollChiTiet = new JScrollPane(tableChiTiet = new JTable(tblModelChiTiet), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		B.add(scrollChiTiet);
		
		box.add(B = Box.createHorizontalBox());
		B.add(btnXuLy = new JButton("Xử Lý"));
		btnXuLy.setPreferredSize(new Dimension(200, 30));
		btnXuLy.setFont(new Font("Arial", Font.BOLD, 20));
		return box;
	}

}
