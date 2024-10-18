package bus;

import java.util.ArrayList;

import dao.SinhVienDAO;
import model.SinhVien;

public class SinhVienBUS {
	SinhVienDAO sinhvien = new SinhVienDAO ();
	
	public ArrayList<SinhVien> getAllSinhVien()
	{
		return sinhvien.getAllSinhVien();
	}

	public int deleteSinhVien(int id) {
		// TODO Auto-generated method stub
		return sinhvien.deleteSinhVien(id);
		
	}
}
