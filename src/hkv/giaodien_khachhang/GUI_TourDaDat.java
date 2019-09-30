package hkv.giaodien_khachhang;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import hkv.entities.Tour;


public class GUI_TourDaDat extends JFrame implements TableCellRenderer{
	private JLabel lblTimKiem,lblDanhSach,lblchonnoiden,lblNoiKhoiHanh,lblGia,lblLoaiXe;
	private JLabel lblTieuDe;
	private JButton btnDatTour,btnTimKiem;
	private JComboBox cbNoiKhoiHanh, cbNoiDen, cbChonXe,cbNgay,cbGia;
	private DefaultTableModel tblDs;
	private JTable table;
	private JSplitPane split;
	private JLabel lblTitle;
	public GUI_TourDaDat() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public Box BoxMainTourDaDat() {
		JSplitPane split1;
		Box box= Box.createVerticalBox();
		add(box);
		box.add(split1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT));
		box.add(split1);
		split1.setTopComponent(BopTop());
		split1.setRightComponent(ListTourDaDat());
		split1.setResizeWeight(0.03);
		split1.setEnabled(false);
		return box;
	}
	public Box BopTop() {
		Box box = Box.createVerticalBox();	
		box.setOpaque(true);
		box.setBackground(Color.WHITE);
		box.setBackground(Color.WHITE);
		Box B1;
		box.add(B1 =  Box.createVerticalBox());
		Box b1;
		B1.add(Box.createVerticalStrut(5));
		B1.add(b1 = Box.createHorizontalBox());
		b1.add(lblTitle = new JLabel("TOUR BẠN ĐÃ ĐẶT"));

		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitle.setForeground(Color.GRAY);
		B1.add(Box.createVerticalStrut(2));
		B1.add(b1 = Box.createHorizontalBox());

	

		Dimension dim = new Dimension(80, 20);
		return box;
	}

	public JList<Tour> ListTourDaDat() {
		Icon image;

		DefaultListModel<Tour> defaultListModel = new DefaultListModel<Tour>();
		defaultListModel.addElement(new Tour("HCM-HN_001", "Hồ Chí Minh - Hà Nội","21-9-2019","30-9-2019","Ô Tô", 200000, "img/hinh1.jfif", "5"));
		defaultListModel.addElement(new Tour("HCM_DN_001", "Hồ Chí Minh - Đà Nẵng","21-9-2019","30-9-2019","Ô Tô", 9800000, "img/hinh1.jfif", "4"));
		JList<Tour> list = new JList<Tour>(defaultListModel);  
		
		// LẤY DỮ LIỆU Ở pnl_MoTaNgan
		list.setCellRenderer(new pnl_MoTaNganTourDaDat());
		JScrollPane scroll = new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


		add(btnDatTour =  new JButton("Đặt Tour"));
		return list;
	}


	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		TableColumn tc = table.getColumn("");
		tc.setCellRenderer(null);
		   if (isSelected) {
			      setForeground(table.getSelectionForeground());
			      setBackground(table.getSelectionBackground());
			    } else{
			      setForeground(table.getForeground());
			     // setBackground(UIManager.getColor("Button.background"));
			    }
			   // setText( (value ==null) ? "" : value.toString() );
		return this;
	}

}
