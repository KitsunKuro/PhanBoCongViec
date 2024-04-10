
public class SoTiet {
	private int ngay;
	private int tiet;
	private String lopHoc;
	
	SoTiet(){
		ngay = 0;
		tiet = 0;
		lopHoc = "";
	}
	
	public SoTiet(int ngay, int tiet, String lopHoc) {
		super();
		this.ngay = ngay;
		this.tiet = tiet;
		this.lopHoc = lopHoc;
	}



	public int getNgay() {
		return ngay;
	}

	public void setNgay(int ngay) {
		this.ngay = ngay;
	}

	public int getTiet() {
		return tiet;
	}

	public void setTiet(int tiet) {
		this.tiet = tiet;
	}

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}

	@Override
	public String toString() {
		return "SoTiet [ngay=" + ngay + ", tiet=" + tiet + ", lopHoc=" + lopHoc + "]";
	}
	
}
