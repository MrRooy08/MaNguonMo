package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Lop;
import model.SinhVien;
import utils.Utils;;

public class SinhVienDAO {

	public ArrayList<SinhVien> getAllSinhVien() {
		// TODO Auto-generated method stub
		//truy van csdl bang sinh vien
		ArrayList<SinhVien> sinhViens = new ArrayList<>();
		String query = "SELECT * FROM tb_SinhVien";
		
		
		try(Connection con = DriverManager.getConnection(Utils.DB_URL,Utils.USER,Utils.PASS);
				PreparedStatement pstmt = con.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery())
		{
			while (rs.next())
			{
				int id = rs.getInt("id");
				String tenSV = rs.getString("hoten");
				float dtb = rs.getFloat("dtb");
				int idLop = rs.getInt("id_lop");
				SinhVien sv = new SinhVien ( id,dtb,tenSV,idLop);
				sinhViens.add(sv);
			}
		}
		catch (SQLException e )
		{
			e.printStackTrace();
			return null;
		}
		return sinhViens;
	}

	public int deleteSinhVien(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
