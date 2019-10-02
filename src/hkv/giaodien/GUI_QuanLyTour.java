package hkv.giaodien;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JDateChooser;

public class GUI_QuanLyTour extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tblModel, tableModelModal;
	private JTable table, tableModal;
	private JSplitPane split, splitModal;
	private JScrollPane scroll, scrollModal;
	private JLabel lblTitle, lblMaTour, lblTenTour, lblMaHanhTrinh, lblNgayKhoiHanh, lblNgayKetThuc, lblHuongDanVien, lblPhuongTien, lblGiaTour, lblTinhTrang, lblSoLuongKH;
	private JTextField txtMaTour, txtTenTour, txtGiaTour;
	private JRadioButton rdbMo, rdbChuaMo;
	private JButton btnThem, btnXoa, btnSua, btnLuu;
	private JDateChooser chooserNgayKhoiHanh, chooserNgayKetThuc;
	private JComboBox<String> cbxHuongDanVien, cbxPhuongTien, cbxMaHanhTrinh, cbxSoLuongKH;
	private String[] PhuongTien = {"Xe", "Máy bay"};
	private String[] SoLuong = {"10", "20", "30", "40", "50", "60", "70", "80", "90", "100"};
	private String [] columnNames = {"STT", "Mã Tour", "Tên Tour", "Mã Hành Trình", "Ngày Khởi Hành", "Ngày Kết Thúc", "Hướng Dẫn Viên", "Phương Tiện", "Giá Tour", "Tình Trạng", "Số Lượng Khách Hàng"};
	private String[] columnModal = {"Họ và Tên", "Ngày Sinh", "Giới Tính", "Loại Hành Khách"};
	private JTableHeader theader;
	
	public GUI_QuanLyTour() {
		// TODO Auto-generated constructor stub
		setSize(400, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		add(boxTour());
	}

	public Box boxQuanLyTour() {
		Box box = Box.createVerticalBox();
		Box.createHorizontalBox();
		box.add(split = new JSplitPane(JSplitPane.VERTICAL_SPLIT));

		split.setResizeWeight(0.03);

		split.setTopComponent(boxTop());
		split.setBottomComponent(boxTable());
		return box;
	}

	public Box boxTour() {
		int fontsize = 15;
		int fontsizetxt = 20;
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(Box.createVerticalStrut(20));
		box.add(B);
		B.add(lblMaTour = new JLabel("Mã Tour : "));
		lblMaTour.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(txtMaTour = new JTextField());

		txtMaTour.setEditable(false);
		box.add(Box.createVerticalStrut(30));

		box.add(B = Box.createHorizontalBox());
		B.add(lblTenTour = new JLabel("Tên Tour : "));
		lblTenTour.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(txtTenTour = new JTextField());
		lblTenTour.setLabelFor(txtTenTour);

		box.add(Box.createVerticalStrut(30));

		box.add(B = Box.createHorizontalBox());
		B.add(lblMaHanhTrinh = new JLabel("Mã Hành Trình : "));
		lblMaHanhTrinh.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(cbxMaHanhTrinh = new JComboBox<>());
		lblMaHanhTrinh.setLabelFor(cbxHuongDanVien);
		cbxMaHanhTrinh.setFont(new Font("Times New Roman", Font.PLAIN, fontsize));
		box.add(Box.createVerticalStrut(30));

		box.add(B = Box.createHorizontalBox());
		B.add(lblNgayKhoiHanh = new JLabel("Ngày Khởi Hành : "));
		lblNgayKhoiHanh.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(chooserNgayKhoiHanh = new JDateChooser());
		lblNgayKhoiHanh.setLabelFor(chooserNgayKhoiHanh);

		box.add(Box.createVerticalStrut(30));

		box.add(B = Box.createHorizontalBox());
		B.add(lblNgayKetThuc = new JLabel("Ngày Kết Thúc : "));
		lblNgayKetThuc.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(chooserNgayKetThuc = new JDateChooser());
		lblNgayKetThuc.setLabelFor(chooserNgayKetThuc);

		box.add(Box.createVerticalStrut(30));

		box.add(B = Box.createHorizontalBox());
		B.add(lblHuongDanVien = new JLabel("Hướng Dẫn Viên : "));
		lblHuongDanVien.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(cbxHuongDanVien = new JComboBox<>());
		lblHuongDanVien.setLabelFor(cbxHuongDanVien);
		cbxHuongDanVien.setFont(new Font("Times New Roman", Font.PLAIN, fontsize));
		box.add(Box.createVerticalStrut(30));

		box.add(B = Box.createHorizontalBox());
		B.add(lblPhuongTien = new JLabel("Phương Tiện : "));
		lblPhuongTien.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(cbxPhuongTien = new JComboBox<>(PhuongTien));
		lblPhuongTien.setLabelFor(cbxPhuongTien);
		cbxPhuongTien.setFont(new Font("Times New Roman", Font.PLAIN, fontsize));
		box.add(Box.createVerticalStrut(30));

		box.add(B = Box.createHorizontalBox());
		B.add(lblGiaTour = new JLabel("Giá Tour : "));
		lblGiaTour.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(txtGiaTour = new JTextField());
		lblGiaTour.setLabelFor(txtGiaTour);

		box.add(Box.createVerticalStrut(30));

		box.add(B = Box.createHorizontalBox());
		B.add(lblTinhTrang = new JLabel("Tình Trạng : "));
		lblTinhTrang.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		ButtonGroup group = new ButtonGroup();
		group.add(rdbMo = new JRadioButton("Mở"));
		group.add(rdbChuaMo = new JRadioButton("Chưa Mở"));
		B.add(Box.createHorizontalStrut(20));		
		B.add(rdbMo);
		B.add(Box.createHorizontalStrut(20));
		B.add(rdbChuaMo);
		B.add(Box.createHorizontalStrut(20));

		box.add(Box.createVerticalStrut(30));

		box.add(B = Box.createHorizontalBox());
		B.add(lblSoLuongKH = new JLabel("Số Lượng KH : "));
		lblSoLuongKH.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
		B.add(cbxSoLuongKH = new JComboBox<>(SoLuong));
		lblSoLuongKH.setLabelFor(cbxSoLuongKH);
		cbxSoLuongKH.setFont(new Font("Times New Roman", Font.PLAIN, fontsize));
		box.add(Box.createVerticalStrut(30));

		box.add(B = Box.createHorizontalBox());
		B.add(btnThem = new JButton("Thêm"));
		B.add(Box.createHorizontalStrut(5));
		B.add(btnXoa = new JButton("Xoá"));
		B.add(Box.createHorizontalStrut(5));
		B.add(btnSua = new JButton("Cập nhật")); 

		box.add(B = Box.createHorizontalBox());
		B.add(btnLuu = new JButton("Lưu"));

		btnThem.setMaximumSize(new Dimension(120, 40));
		btnXoa.setMaximumSize(new Dimension(120, 40));
		btnSua.setMaximumSize(new Dimension(120, 40));
		btnLuu.setMaximumSize(new Dimension(370, 40));
		btnThem.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSua.setFont(new Font("Arial", Font.PLAIN, 20));
		btnXoa.setFont(new Font("Arial", Font.PLAIN, 20));
		btnLuu.setFont(new Font("Arial", Font.PLAIN, 20));

		btnThem.setBackground(Color.GREEN);
		btnXoa.setBackground(Color.RED);
		btnSua.setBackground(Color.GRAY);
		btnLuu.setBackground(Color.ORANGE);

		txtMaTour.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtTenTour.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		chooserNgayKhoiHanh.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		chooserNgayKetThuc.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtGiaTour.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		lblMaTour.setPreferredSize(new Dimension(lblHuongDanVien.getPreferredSize().width, 20));
		lblTenTour.setPreferredSize(new Dimension(lblHuongDanVien.getPreferredSize().width, 20));
		lblMaHanhTrinh.setPreferredSize(new Dimension(lblHuongDanVien.getPreferredSize().width, 20));
		lblGiaTour.setPreferredSize(new Dimension(lblHuongDanVien.getPreferredSize().width, 20));
		lblNgayKhoiHanh.setPreferredSize(new Dimension(lblHuongDanVien.getPreferredSize().width, 20));
		lblNgayKetThuc.setPreferredSize(new Dimension(lblHuongDanVien.getPreferredSize().width, 20));
		lblPhuongTien.setPreferredSize(new Dimension(lblHuongDanVien.getPreferredSize().width, 20));
		lblSoLuongKH.setPreferredSize(new Dimension(lblHuongDanVien.getPreferredSize().width, 20));
		lblTinhTrang.setPreferredSize(new Dimension(lblHuongDanVien.getPreferredSize().width, 20));

		txtGiaTour.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtMaTour.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtTenTour.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));

		return box;
	}

	private Box boxTop() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(Box.createVerticalStrut(20));
		box.add(B);
		B.add(lblTitle = new JLabel("Danh Sách Tour"));
		lblTitle.setFont(new Font("Arial", Font.ITALIC, 30));
		return box;
	}

	private Box boxTable() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(B);
		tblModel = new DefaultTableModel(columnNames, 0);
		scroll = new JScrollPane(table = new JTable(tblModel), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
		B.add(scroll);
		table.setRowHeight(40);
		
		TableColumnModel column = table.getColumnModel();
		column.getColumn(0).setPreferredWidth(5);
		column.getColumn(1).setPreferredWidth(10);
		column.getColumn(2).setPreferredWidth(300);
		column.getColumn(3).setPreferredWidth(15);
		column.getColumn(4).setPreferredWidth(15);
		column.getColumn(5).setPreferredWidth(15);
		column.getColumn(7).setPreferredWidth(15);
		
		column.getColumn(9).setPreferredWidth(10);
		column.getColumn(10).setPreferredWidth(10);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		
		theader = table.getTableHeader();
//		theader.setBackground(new Color(153, 102, 255)); // Change background header
		theader.setFont(new Font("Arial", Font.BOLD, 40)); // Change Header Font
//		theader.setForeground(Color.GREEN);
		table.setFont(new Font("Arial", Font.PLAIN, 20));
		
		table.setDefaultEditor(Object.class, null);
		tblModel.addRow(new Object[] {"1", "T001", "SG-HN", "HT001", "6-6-2019", "6-6-9999", "Zoro", "Xe", "12312321", "Mo", "7"});
		tblModel.addRow(new Object[] {"1", "T001", "SG-HN", "HT001", "6-6-2019", "6-6-9999", "Zoro", "Xe", "12312321", "Mo", "7"});
//		sroll.setPreferredSize(new Dimension(0, 350));
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 && table.getSelectedRow() != -1)
					modalChiTietHoaDon().setVisible(true);
			}
		});
		return box;
	}
	
	private JDialog modalChiTietHoaDon() {
		Frame frame = null;
		JDialog dialogChiTietHoaDon = new JDialog(frame, "Thông Tin Chi Tiết", true);
		dialogChiTietHoaDon.add(boxChiTiet());
		dialogChiTietHoaDon.setSize(800, 700);
		dialogChiTietHoaDon.setLocationRelativeTo(null);

		return dialogChiTietHoaDon;
	}
	
	private Box boxChiTiet() {
		Box box = Box.createVerticalBox();
		splitModal = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		box.add(splitModal);
		splitModal.setResizeWeight(0.5);
		splitModal.setEnabled(false);
		splitModal.setTopComponent(boxChiTietTop());
		splitModal.setBottomComponent(boxChiTietTable());
		return box;
	}
	
	private Box boxChiTietTop() {
		Box box = Box.createVerticalBox();
		
		return box;		
	}
	
	private Box boxChiTietTable() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(B);
		tableModelModal = new DefaultTableModel(columnModal, 2);
		scrollModal = new JScrollPane(tableModal = new JTable(tableModelModal), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		B.add(scrollModal);
		return box;
	}
	
}
