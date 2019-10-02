package hkv.giaodien_khachhang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import hkv.entities.Tour;

public class pnl_MoTaNganDatTour extends JPanel  implements ListCellRenderer<Tour>{
	private JSeparator jSeparator1;
	private JLabel lblGheTrong = new JLabel();
	private JLabel lblGheTrong1 = new JLabel();
	private JLabel lbltenTour = new JLabel();
	private JLabel lblmaTour = new JLabel();
	private JLabel lblGia = new JLabel();
	private JLabel lblGia1 = new JLabel();
	private JLabel lblLoaiXe = new JLabel();
	private JLabel lblngayKhoiHanh = new JLabel();
	private JLabel lblNgayKetThuc = new JLabel();
	private JLabel lblimage= new JLabel();
	private JPanel panelText;
	private JPanel panelIcon;
	private JButton btnXemChiTiet,btnDatTour;
	public pnl_MoTaNganDatTour() {
//		boxMoTa();
		UI_MoTa();
	}
	
	public void UI_MoTa() {

		setLayout(new BorderLayout(5,5));

		panelText =  new JPanel();
		panelText.setLayout(new GridLayout(4,2));
		panelIcon = new JPanel();
		panelIcon.setLayout(new GridLayout());
		panelIcon.setBorder(new EmptyBorder(5, 5, 5, 5));


		ImageIcon aboutIcon = new ImageIcon("img/hinh1.jfif");
		Image image1 = aboutIcon.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(20, 20,Image.SCALE_SMOOTH); // scale it the smooth way  
		aboutIcon = new ImageIcon(newimg1);  // transform it back
		lblimage.setIcon(aboutIcon);
		panelIcon.add(lblimage);

		// ma tour
		lblmaTour.setFont(new Font("Arial",1,14));
		lblmaTour.setForeground(new Color(51,51	,51));
		panelText.add(lblmaTour);

		// tên tour
		lbltenTour.setFont(new Font("Arial",1,14));
		lbltenTour.setForeground(new Color(51,51,51));

		panelText.add(lbltenTour);


		// ngày khỏi hành

	//	lblngayKhoiHanh = new JLabel();
		lblngayKhoiHanh.setIcon(new ImageIcon("img/icon/calendar.png"));
		panelText.add(lblngayKhoiHanh );

		// ngày kết thúc

		lblNgayKetThuc.setIcon(new ImageIcon("img/icon/calendar.png"));
		panelText.add(lblNgayKetThuc);
		


		// số lượng đặt
//		lblGheTrong.setFont(new Font("Arial",1,14));
//		lblGheTrong.setForeground(new Color(51,51,51));
		lblGheTrong.setIcon(new ImageIcon("img/icon/user_info.png"));
		panelText.add(lblGheTrong);
		// giá
	
//		lblGia.setFont(new Font("Arial",1,14));
//		lblGia.setForeground(new Color(51,51,51));
//		lblGia.setBounds(40, 20,40,10);
		lblGia.setIcon(new ImageIcon("img/icon/money-bag.png"));
		panelText.add(lblGia);

			
		add(panelIcon,BorderLayout.WEST);
		add(panelText,BorderLayout.CENTER);
//
//		GroupLayout layout = new GroupLayout(this);n
//		this.setLayout(layout);
//		layout.setHorizontalGroup(
//				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//				.addComponent(panelText, GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
//				);
//		layout.setVerticalGroup(
//				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//				.addComponent(panelText,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//				);

	}
	
	
	
	Format ft_ngay = new SimpleDateFormat("dd-MM-yyyy");
	DecimalFormat ft_tien = new DecimalFormat("###,###,###" +" VNĐ");

	public Component getListCellRendererComponent(JList<? extends Tour> list, Tour value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		this.lblmaTour.setText(" "+ value.getMaTour( )+"       " +value.getTenTour());
		//this.lbltenTour.setText("Tên Tour :"+value.getTenTour());
		this.lblGia1.setText(value.getTenTour());
		this.lblngayKhoiHanh.setText("Ngày Khởi Hành:   "+value.getNgayKhoiHanh());
		this.lblNgayKetThuc.setText("Ngày Kết Thúc:  "+ value.getNgayKetThuc());
		float gia = value.getGiaTour();
		String gia1 = String.valueOf(gia);
		this.lblGia.setText("Giá:  "+ gia1+ " VND");
		this.lblGheTrong.setText("Đã đặt:  "+value.getSoTrong());
		this.lblLoaiXe.setText("Loại Xe:  " +value.getLoaiXe());
		ImageIcon aboutIcon = new ImageIcon(value.getImage());
		Image image1 = aboutIcon.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		aboutIcon = new ImageIcon(newimg1);  // transform it back		lblimage.setIcon(aboutIcon);
		panelIcon.add(lblimage);
		
		
		this.lblimage.setIcon(aboutIcon);
		this.lblmaTour.setOpaque(true);
		this.lbltenTour.setOpaque(true);
		//		this.lblimage.setOpaque(true);

		if (isSelected) {
			lblmaTour.setBackground(new Color(204,204,204));//màu xám
			lbltenTour.setBackground(new Color(204,204,204));
			panelIcon.setBackground(new Color(204,204,204));
			panelText.setBackground(new Color(204,204,204));
		}else{
			lblmaTour.setBackground(Color.WHITE);
			lbltenTour.setBackground(Color.WHITE);
			panelText.setBackground(Color.WHITE);
			panelIcon.setBackground(Color.WHITE);
		}
		return this;
	}

}
