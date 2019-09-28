package hkv.giaodien;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import main.GUI_Main;

public class GUI_QuanLyNhanVien extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2788527835229414597L;
	private DefaultTableModel tblModel;
	private JTable table;
	private JSplitPane split;
	private JPasswordField pwdNhanVien;
	private JScrollPane scrollPane, scrollPane1;
	private JLabel lblTitle, lblAnhDaiDien, lblMaNV, lblHo, lblTen, lblGioiTinh, lblNgaySinh, lblTinh, lblSoDienThoai, lblEmail, lblMatKhau, lblGhiChu, lblLuong, lblAnh;
	private JTextField txtMaNV, txtHo, txtTen, txtSoDienThoai, txtEmail, txtMatKhau, txtLuong;
	private JTextArea txtGhiChu;
	private JRadioButton rdbNam, rdbNu;
	private JButton btnThem, btnXoa, btnSua, btnFile, btnLuu, btnAnhDaiDien;
	private JDateChooser ngaySinh;
	private JComboBox<String> cbxTinh;
	private JFileChooser avatar, anhDaiDien;
	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private String[] tinh = {"Thành Phố Hồ Chí Minh", "Hà Nội"};
	private String[] header = {"STT", "Mã Nhân Viên", "Họ và Tên Đệm", "Tên", "Giới Tính", "Ngày Sinh", "Quê Quán", "Số Điện Thoại", "Email", "Mật Khẩu", "Lương"};
	public GUI_QuanLyNhanVien() {
		// TODO Auto-generated constructor stub
		setSize(400, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		add(boxNhanVien());
	}
	
	public Box boxQuanLyNhanVien() {
		Box box = Box.createVerticalBox();
		Box.createHorizontalBox();
		box.add(split = new JSplitPane(JSplitPane.VERTICAL_SPLIT));
		split.setResizeWeight(0.03);
		split.setTopComponent(boxTop());
		split.setBottomComponent(boxTable());
		split.setOneTouchExpandable(true);
		
		return box;
	}
	
	public Box boxNhanVien() {
		int fontsizetxt = 15;
		int fontsizelbl = 15;
		int khoangcach = 10;
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(Box.createVerticalStrut(20));
		
		box.add(B);
		B.add(lblAnhDaiDien = new JLabel());
		lblAnhDaiDien.setSize(125, 125);
		setPicture(lblAnhDaiDien, "img\\non-avatar.png");
		box.add(Box.createVerticalStrut(5));
		
		
		box.add(B = Box.createHorizontalBox());
		B.add(btnAnhDaiDien = new JButton("Thêm Ảnh"));
		box.add(Box.createVerticalStrut(5));
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblMaNV = new JLabel("Mã Nhân Viên : "));
		lblMaNV.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(txtMaNV = new JTextField());
		box.add(Box.createVerticalStrut(khoangcach));
		
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
		B.add(Box.createHorizontalStrut(20));
		B.add(rdbNu);
//		B.add(Box.createHorizontalStrut(50));
		
		box.add(Box.createVerticalStrut(khoangcach));
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblNgaySinh = new JLabel("Ngày Sinh : "));
		lblNgaySinh.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(ngaySinh = new JDateChooser());
		lblNgaySinh.setLabelFor(ngaySinh);
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
		
		txtGhiChu = new JTextArea();
		scrollPane = new JScrollPane(txtGhiChu, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblGhiChu = new JLabel("Ghi chú : "));
		lblGhiChu.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(scrollPane);
		B.add(Box.createHorizontalStrut(5));
		lblGhiChu.setLabelFor(scrollPane);
		box.add(Box.createVerticalStrut(khoangcach));
			
		box.add(B = Box.createHorizontalBox());
		B.add(lblLuong = new JLabel("Lương : "));
		lblLuong.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(txtLuong = new JTextField());
		lblLuong.setLabelFor(txtLuong);
		box.add(Box.createVerticalStrut(khoangcach));
		
		box.add(B = Box.createHorizontalBox());
		B.add(lblAnh = new JLabel("Ảnh : "));
		lblAnh.setFont(new Font("Times New Roman", Font.ITALIC, fontsizelbl));
		B.add(Box.createHorizontalStrut(85));
		B.add(btnFile = new JButton("Chọn Ảnh"));
		lblAnh.setLabelFor(btnFile);
		B.add(Box.createHorizontalStrut(50));
		box.add(Box.createVerticalStrut(khoangcach));

		
		box.add(B = Box.createHorizontalBox());
		B.add(btnThem = new JButton("Thêm"));
		B.add(Box.createHorizontalStrut(5));
		B.add(btnXoa = new JButton("Xoá"));
		B.add(Box.createHorizontalStrut(5));
		B.add(btnSua = new JButton("Cập nhật")); 
		box.add(Box.createVerticalStrut(10));
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
		txtLuong.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		txtGhiChu.setFont(new Font("Arial", Font.PLAIN, fontsizetxt));
		
		txtMaNV.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtHo.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtTen.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		ngaySinh.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtSoDienThoai.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtEmail.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtMatKhau.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtLuong.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		txtGhiChu.setMinimumSize(new Dimension(Short.MAX_VALUE,	Short.MAX_VALUE));
		
		btnThem.setBackground(Color.GREEN);
		btnXoa.setBackground(Color.RED);
		btnSua.setBackground(Color.GRAY);
		btnLuu.setBackground(Color.ORANGE);
		
		lblMaNV.setPreferredSize(new Dimension(lblTinh.getPreferredSize().width, 20));
		lblHo.setPreferredSize(new Dimension(lblTinh.getPreferredSize().width, 20));
		lblTen.setPreferredSize(new Dimension(lblTinh.getPreferredSize().width, 20));
		lblGioiTinh.setPreferredSize(new Dimension(lblTinh.getPreferredSize().width, 20));
		lblNgaySinh.setPreferredSize(new Dimension(lblTinh.getPreferredSize().width, 20));
		lblSoDienThoai.setPreferredSize(new Dimension(lblTinh.getPreferredSize().width, 20));
		lblEmail.setPreferredSize(new Dimension(lblTinh.getPreferredSize().width, 20));
		lblMatKhau.setPreferredSize(new Dimension(lblTinh.getPreferredSize().width, 20));
		lblGhiChu.setPreferredSize(new Dimension(lblTinh.getPreferredSize().width, 20));
		lblLuong.setPreferredSize(new Dimension(lblTinh.getPreferredSize().width, 20));
		lblAnh.setPreferredSize(new Dimension(lblTinh.getPreferredSize().width, 20));
		
		int width = (int) (screen.getWidth()/2);
		int height = (int) (screen.getHeight()/2);

		
		txtGhiChu.setLineWrap(true);
		txtGhiChu.setWrapStyleWord(true);
		txtGhiChu.setRows(5);
		
		btnAnhDaiDien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pathUser = System.getProperty("user.home");
				System.out.println(pathUser);
				anhDaiDien = new JFileChooser(pathUser + "\\Pictures");
				anhDaiDien = new JFileChooser();
				anhDaiDien.setFileSelectionMode(JFileChooser.FILES_ONLY);
				anhDaiDien.setPreferredSize(new Dimension(width, height));
				int returnVal = anhDaiDien.showSaveDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					anhDaiDien.getSelectedFile();
					System.out.println(anhDaiDien.getSelectedFile().toString());
					setPicture(lblAnhDaiDien, anhDaiDien.getSelectedFile().toString());
				}
			}
		});
		
		btnFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pathUser = System.getProperty("user.home");
				avatar = new JFileChooser(pathUser + "\\Pictures");
				int returnVal = avatar.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File selectedFile = avatar.getSelectedFile();
					System.out.println(selectedFile.getAbsolutePath());
					lblAnhDaiDien = new JLabel();
					setPicture(lblAnhDaiDien, selectedFile.getAbsolutePath());
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
		B.add(lblTitle = new JLabel("Danh Sách Nhân Viên"));
		
		lblTitle.setFont(new Font("Arial", Font.ITALIC, 30));
		
		return box;
	}
	
	private Box boxTable() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(B);
		tblModel = new DefaultTableModel(header, 0);
		scrollPane1 = new JScrollPane(table = new JTable(tblModel), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
		B.add(scrollPane1);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		
		pwdNhanVien = new JPasswordField();
		DefaultCellEditor editor = new DefaultCellEditor(pwdNhanVien);
		table.getColumnModel().getColumn(9).setCellEditor(editor);
		
		
		
		return box;
	}
	
	public  void setPicture(JLabel label ,String filename){
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
