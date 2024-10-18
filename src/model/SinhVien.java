package model;

public class SinhVien {
	private int id;
	private float dtb;
	private String hoten;
	private int idLop;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getDtb() {
		return dtb;
	}
	public void setDtb(float dtb) {
		this.dtb = dtb;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getIdLop() {
		return idLop;
	}
	public void setIdLop(int idLop) {
		this.idLop = idLop;
	}
	public SinhVien(int id, float dtb, String hoten, int idLop) {
		super();
		this.id = id;
		this.dtb = dtb;
		this.hoten = hoten;
		this.idLop = idLop;
	}
	
	
	
}
