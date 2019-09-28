package hkv.giaodien;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class GUI_ThongKe extends JFrame{
	private JSplitPane split;
	private JLabel lblTitle;
	private DefaultTableModel tblModel;
	private JTable table;
	private JScrollPane scrollPane;
 	public GUI_ThongKe() {
		// TODO Auto-generated constructor stub
		setSize(400, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		add(boxThongKe());
	}
//	
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				new GUI_ThongKe().setVisible(true);
//			}
//		});
//	}
//	
	public Box boxThongKe() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(split = new JSplitPane(JSplitPane.VERTICAL_SPLIT));
		
		split.setResizeWeight(0.2);
		split.setTopComponent(boxThongKeTop());
		
		scrollPane = new JScrollPane(boxThongKeTable(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		split.setBottomComponent(scrollPane);
		split.setEnabled(false);
		return box;
	}
	
	public Box boxThongKeTop() {
		int width = 5;
		int height = 10;
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		JPanel panelSoHoaDon = new JPanel();
		JPanel panelSoKhachHang = new JPanel();
		JPanel panelSoTour = new JPanel();
		box.add(Box.createVerticalStrut(height));
		box.add(B);
		B.add(panelSoHoaDon);
		B.add(Box.createHorizontalStrut(width));
		B.add(panelSoKhachHang);
		B.add(Box.createHorizontalStrut(width));
		B.add(panelSoTour);
		box.add(Box.createVerticalStrut(height));
		panelSoHoaDon.setBackground(new Color(255, 77, 77));
		panelSoKhachHang.setBackground(new Color(64, 191, 64));
		panelSoTour.setBackground(new Color(102, 179, 255));
		return box;
	}
	
	public Box boxThongKeTable() {
		Box box = Box.createVerticalBox();
		Box B = Box.createHorizontalBox();
		box.add(B);
		B.add(createPieChart());
		box.add(B = Box.createHorizontalBox());
		B.add(createPieChart());
		return box;
	}
	
	private PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Khoa", 20);
		dataset.setValue("Vô", 20);;
		dataset.setValue("Đạt", 20);
		dataset.setValue("Công", 20);
		dataset.setValue("Huy", 20);
		return dataset;
	}
	
	private JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart("404", dataset, true, true, false);
		return chart;
	}
	
	private JPanel createPieChart() {
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}
	
	
}
