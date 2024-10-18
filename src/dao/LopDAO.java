package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Lop;
import utils.Utils;

public class LopDAO {

	public ArrayList<Lop> getAllLop() {
		// TODO Auto-generated method stub
		ArrayList<Lop> lops = new ArrayList<>();
		String query = "SELECT * FROM tb_lop";
		
		
		try(Connection con = DriverManager.getConnection(Utils.DB_URL,Utils.USER,Utils.PASS);
				PreparedStatement pstmt = con.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery())
		{
			while (rs.next())
			{
				int id = rs.getInt("id");
				String tenlop = rs.getString("tenlop");
				Lop lop = new Lop(id,tenlop);
				lops.add(lop);
			}
		}
		catch (SQLException e )
		{
			e.printStackTrace();
			return null;
		}
		return lops;
	}

}
