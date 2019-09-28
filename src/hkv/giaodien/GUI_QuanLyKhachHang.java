package hkv.giaodien;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class GUI_QuanLyKhachHang extends JFrame {
	private DefaultTableModel tblModel;
	private JTable table;
	private JSplitPane split;
	private JScrollPane scrollPane;
	private JLabel lblTitle, lblMaNV, lblHo, lblTen, lblGioiTinh, lblNgaySinh, lblTinh, lblSoDienThoai, lblEmail, lblMatKhau, lblGhiChu, lblCMND, lblAnh;
	private JTextField txtMaNV, txtHo, txtTen, txtTinh, txtSoDienThoai, txtEmail, txtMatKhau, txtCMND;
	private JTextArea txtGhiChu;
	private JRadioButton rdbNam, rdbNu;
	private JButton btnTimKiem, btnThem, btnXoa, btnSua, btnFile, btnLuu;
	private JCalendar calendar;
	private JDateChooser ngaySinh;
	private JComboBox<String> cbxTinh;
	private JFileChooser avatar;
	private String[] tinh = {"Thành Phố Hồ Chí Minh", "Hà Nội"};
	public GUI_QuanLyKhachHang() {
		// TODO Auto-generated constructor stub
		setSize(400, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		add(boxKhachHang());
	}
	
	public Box boxQuanLyKhachHang() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(split = new JSplitPane(JSplitPane.VERTICAL_SPLIT));
		split.setResizeWeight(0.03);
		split.setTopComponent(boxTop());
		split.setBottomComponent(boxTable());
		split.setOneTouchExpandable(true);
		return box;
	}
	
	public Box boxKhachHang() {
		int fontsizetxt = 20;
		int fontsizelbl = 15;
		int khoangcach = 20;
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(Box.createVerticalStrut(20));
		/*ADD MaVN*/
		box.add(B);
		B.add(lblMaNV = new JLabel("Mã Khách Hàng : "));
		lblMaNV.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(txtMaNV = new JTextField());
		box.add(Box.createVerticalStrut(khoangcach));
		
		/**/
		box.add(B = Box.createHorizontalBox());
		B.add(lblHo = new JLabel("Họ và Tên Đệm : "));
		lblHo.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(txtHo = new JTextField());
		lblHo.setLabelFor(txtHo);
		box.add(Box.createVerticalStrut(khoangcach));
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblTen = new JLabel("Tên : "));
		lblTen.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(txtTen = new JTextField());
		lblTen.setLabelFor(txtTen);
		box.add(Box.createVerticalStrut(khoangcach));
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblGioiTinh = new JLabel("Giới tính : "));
		lblGioiTinh.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		ButtonGroup group = new ButtonGroup();
		group.add(rdbNam = new JRadioButton("Nam"));
		group.add(rdbNu = new JRadioButton("Nữ"));
		B.add(Box.createHorizontalStrut(50));		
		B.add(rdbNam);
		B.add(Box.createHorizontalStrut(50));
		B.add(rdbNu);
		B.add(Box.createHorizontalStrut(50));
		
		box.add(Box.createVerticalStrut(khoangcach));
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblNgaySinh = new JLabel("Ngày Sinh : "));
		lblNgaySinh.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(ngaySinh = new JDateChooser());
		lblNgaySinh.setLabelFor(ngaySinh);
		box.add(Box.createVerticalStrut(khoangcach));
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblCMND = new JLabel("CMND / Thẻ CTCD : "));
		lblCMND.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(txtCMND = new JTextField());
		lblCMND.setLabelFor(txtCMND);
		box.add(Box.createVerticalStrut(khoangcach));
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblTinh = new JLabel("Tỉnh / Thành Phố : "));
		lblTinh.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(cbxTinh = new JComboBox<>(tinh));
		lblTinh.setLabelFor(cbxTinh);
		cbxTinh.setFont(new Font("Times New Roman", Font.PLAIN, fontsizetxt));
		box.add(Box.createVerticalStrut(khoangcach));
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblSoDienThoai = new JLabel("Số điện thoại : "));
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(txtSoDienThoai = new JTextField());
		lblSoDienThoai.setLabelFor(txtSoDienThoai);
		box.add(Box.createVerticalStrut(khoangcach));
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblEmail = new JLabel("Email : "));
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(txtEmail = new JTextField());
		lblEmail.setLabelFor(txtEmail);
		box.add(Box.createVerticalStrut(khoangcach));
		
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblMatKhau = new JLabel("Mật khẩu : "));
		lblMatKhau.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(txtMatKhau = new JTextField());
		lblMatKhau.setLabelFor(txtMatKhau);
		box.add(Box.createVerticalStrut(khoangcach));
		
		scrollPane = new JScrollPane(txtGhiChu, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		txtGhiChu = new JTextArea();
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblGhiChu = new JLabel("Ghi chú : "));
		lblGhiChu.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(scrollPane);
		B.add(Box.createHorizontalStrut(5));
		lblGhiChu.setLabelFor(scrollPane);
		box.add(Box.createVerticalStrut(khoangcach));
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblAnh = new JLabel("Ảnh : "));
		lblAnh.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(Box.createHorizontalStrut(85));
		B.add(btnFile = new JButton("Chọn Ảnh"));
		lblAnh.setLabelFor(btnFile);
		B.add(Box.createHorizontalStrut(300));
		box.add(Box.createVerticalStrut(khoangcach));

		
		box.add(B = Box.createHorizontalBox());
		B.add(btnThem = new JButton("Thêm"));
		B.add(Box.createHorizontalStrut(5));
		B.add(btnXoa = new JButton("Xoá"));
		B.add(Box.createHorizontalStrut(5));
		B.add(btnSua = new JButton("Cập nhật")); 
		
		box.add(B = Box.createHorizontalBox());
		B.add(btnLuu = new JButton("Lưu"));
		
		btnThem.setMaximumSize(new Dimension(120, 50));
		btnXoa.setMaximumSize(new Dimension(120, 50));
		btnSua.setMaximumSize(new Dimension(120, 50));
		btnLuu.setMaximumSize(new Dimension(370, 50));
		
		btnThem.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSua.setFont(new Font("Arial", Font.PLAIN, 20));
		btnXoa.setFont(new Font("Arial", Font.PLAIN, 20));
		btnLuu.setFont(new Font("Arial", Font.PLAIN, 20));
		
		txtMaNV.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtHo.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtTen.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtSoDienThoai.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtEmail.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtMatKhau.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtCMND.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtGhiChu.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		
		txtMaNV.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtHo.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtTen.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		ngaySinh.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtSoDienThoai.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtEmail.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtMatKhau.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtCMND.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		scrollPane.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		btnThem.setBackground(Color.GREEN);
		btnXoa.setBackground(Color.RED);
		btnSua.setBackground(Color.GRAY);
		btnLuu.setBackground(Color.ORANGE);
		
		lblMaNV.setPreferredSize(new Dimension(lblCMND.getPreferredSize().width, 20));
		lblHo.setPreferredSize(new Dimension(lblCMND.getPreferredSize().width, 20));
		lblTen.setPreferredSize(new Dimension(lblCMND.getPreferredSize().width, 20));
		lblGioiTinh.setPreferredSize(new Dimension(lblCMND.getPreferredSize().width, 20));
		lblNgaySinh.setPreferredSize(new Dimension(lblCMND.getPreferredSize().width, 20));
		lblSoDienThoai.setPreferredSize(new Dimension(lblCMND.getPreferredSize().width, 20));
		lblEmail.setPreferredSize(new Dimension(lblCMND.getPreferredSize().width, 20));
		lblMatKhau.setPreferredSize(new Dimension(lblCMND.getPreferredSize().width, 20));
		lblTinh.setPreferredSize(new Dimension(lblCMND.getPreferredSize().width, 20));
		lblGhiChu.setPreferredSize(new Dimension(lblCMND.getPreferredSize().width, 20));
		lblAnh.setPreferredSize(new Dimension(lblCMND.getPreferredSize().width, 20));
		
		txtGhiChu.setWrapStyleWord(true);
		txtGhiChu.setLineWrap(true);
		txtGhiChu.setRows(5);
		
		btnFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				avatar = new JFileChooser();
				int returnVal = avatar.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File selectedFile = avatar.getSelectedFile();
					System.out.println(selectedFile.getName());
				}
			}
		});
		
		return box;
	}
	
	private Box boxTop() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();

		box.add(Box.createVerticalStrut(20));
		box.add(B);
		B.add(lblTitle = new JLabel("Danh Sách Khách Hàng"));
		
		lblTitle.setFont(new Font("Arial", Font.ITALIC, 30));
		
		return box;
	}
	
	private Box boxTable() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		tblModel = new DefaultTableModel();
		table = new JTable(tblModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		B.add(table);
		
		return box;
	}
}
