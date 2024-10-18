package bus;
import java.util.ArrayList;

import model.*;
import dao.LopDAO;

public class LopBUS {
	
	LopDAO lopDao = new LopDAO();
	
	public ArrayList<Lop> getAllLop ()
	{
		return lopDao.getAllLop();
	}
}
