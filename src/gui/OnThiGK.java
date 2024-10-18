package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bus.LopBUS;
import bus.SinhVienBUS;
import model.Lop;
import model.SinhVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OnThiGK extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHoTen;
	private JTextField txtDiemTrungBinh;
	private JTable table;
	
	private ArrayList<Lop> dsLop = new ArrayList<Lop>();
	private ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	private LopBUS lopBus = new LopBUS ();
	private SinhVienBUS sinhVienBus = new SinhVienBUS();
	private int index = -1;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OnThiGK frame = new OnThiGK();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OnThiGK() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ho Ten");
		lblNewLabel.setBounds(24, 10, 68, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblDtb = new JLabel("DTB");
		lblDtb.setBounds(24, 41, 57, 19);
		contentPane.add(lblDtb);
		
		JLabel lblLop = new JLabel("Lop");
		lblLop.setBounds(24, 70, 68, 29);
		contentPane.add(lblLop);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(173, 15, 96, 19);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		txtDiemTrungBinh = new JTextField();
		txtDiemTrungBinh.setColumns(10);
		txtDiemTrungBinh.setBounds(173, 41, 96, 19);
		contentPane.add(txtDiemTrungBinh);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(173, 74, 96, 21);
		contentPane.add(comboBox);
		
		JButton btnThem = new JButton("Them");
		btnThem.setBounds(24, 146, 85, 21);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index < 0) 
				{
					JOptionPane.showMessageDialog(btnXoa, "Ban Phai Chon Sinh Vien");
					return ;
				}
				sinhVienBus.deleteSinhVien(dsSinhVien.get(index).getId());
			}
		});
		btnXoa.setBounds(145, 144, 85, 21);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("Sua");
		btnSua.setBounds(264, 146, 85, 21);
		contentPane.add(btnSua);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 177, 325, 98);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = table.getSelectedRow();
				
				SinhVien sv = dsSinhVien.get(index);
				
				txtHoTen.setText(sv.getHoten());
				txtDiemTrungBinh.setText(sv.getDtb()+"");
				
				int idLop = sv.getIdLop();
				for ( int i =0 ;i<dsLop.size();i++)
				{
					if(idLop == dsLop.get(i).getId())
					{
						comboBox.setSelectedIndex(i);
					}
				}
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ho Ten", "DTB", "Lop"
			}
		));
		scrollPane.setViewportView(table);
		
		
		//load du lieu sinh vien va lop
		
		
		//load du lieu tu lop -> combobox
		dsLop = lopBus.getAllLop();
		loadDataComboBox();
		
		
		//load du lieu sinh vien -> table
		dsSinhVien = sinhVienBus.getAllSinhVien();
		loadDataTable();
		
		
	}

	private void loadDataTable() {
		// TODO Auto-generated method stub
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.setNumRows(0);
		
		for (SinhVien sv : dsSinhVien)
		{
			defaultTableModel.addRow(new Object[] {sv.getId(),sv.getHoten(),sv.getDtb(),getTenLopFromId(sv.getId())});
		}
		table.setModel(defaultTableModel);
	}

	private String getTenLopFromId(int id) {
		// TODO Auto-generated method stub
		for (Lop lop : dsLop)
		{
			if(id == lop.getId())
			{
				return lop.getTenLop();
			}
		}
		return "";
	}

	private void loadDataComboBox() {
		// TODO Auto-generated method stub
		DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<String>();
		for(Lop l : dsLop)
		{
			boxModel.addElement(l.toString());
		}
		comboBox.setModel(boxModel);
	}
}
