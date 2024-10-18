package model;

public class Lop {
	private int id;
	private String tenLop;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public Lop(int id, String tenLop) {
		super();
		this.id = id;
		this.tenLop = tenLop;
	}
	@Override
	public String toString() {
		return this.tenLop;
	}
	
	
}
