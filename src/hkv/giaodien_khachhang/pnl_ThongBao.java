package hkv.giaodien_khachhang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

public class pnl_ThongBao extends JPanel  implements ListCellRenderer<Tour>{
	private JSeparator jSeparator1;
	private JLabel lblThongBao = new JLabel();

	private JLabel lblimage= new JLabel();
	private JPanel panelText;
	private JPanel panelIcon;
	private JButton btnXemChiTiet;
	public pnl_ThongBao() {
//		boxMoTa();
		UI_MoTa();
	}
	
	public void UI_MoTa() {

		setLayout(new BorderLayout(5,5));

		panelText =  new JPanel();
		panelText.setLayout(new GridLayout(4,4));
		panelIcon = new JPanel();
		panelIcon.setLayout(new GridLayout());
		panelIcon.setBorder(new EmptyBorder(5, 5, 5, 5));

		panelText.add(lblThongBao);
		
		add(panelIcon,BorderLayout.WEST);
		add(panelText,BorderLayout.CENTER);

	}
	
	

	public Component getListCellRendererComponent(JList<? extends Tour> list, Tour value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		this.lblThongBao.setText(" THÔNG BÁO CHO KHÁCH HÀNH  ");

		

		this.lblThongBao.setOpaque(true);

		//		this.lblimage.setOpaque(true);

		if (isSelected) {
			lblThongBao.setBackground(new Color(204,204,204));//màu xám));

			panelText.setBackground(new Color(204,204,204));
		}else{
			lblThongBao.setBackground(Color.WHITE);

			panelText.setBackground(Color.WHITE);
	
		}
		return this;
	}

}
