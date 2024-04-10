import java.lang.reflect.Array;
import java.util.ArrayList;

public class CongViec {
	private String maCV;
	private String tenCV;
	private int soNguoiToiThieu;
	private int soNguoiToiDa;
	private int yeuCauChuNhiem;
	private String yeuCauChuyenMon;
	private int thu,tiet,thoiGian,trongSo;
	private ArrayList<String> nguoiLam;
	private ArrayList<SoTiet> soTiet;
	
	CongViec(){
		soTiet = new ArrayList<>();
		nguoiLam = new ArrayList<>();
	}

	public CongViec(String maCV, String tenCV, int soNguoiToiThieu, int soNguoiToiDa, int yeuCauChuNhiem,String yeuCauChuyenMon, int thu, int tiet, int thoiGian, int trongSo, ArrayList<String> nguoiLam, ArrayList<SoTiet> soTiet) {
		super();
		this.maCV = maCV;
		this.tenCV = tenCV;
		this.soNguoiToiThieu = soNguoiToiThieu;
		this.soNguoiToiDa = soNguoiToiDa;
		this.yeuCauChuNhiem = yeuCauChuNhiem;
		this.thu = thu;
		this.tiet = tiet;
		this.thoiGian = thoiGian;
		this.trongSo = trongSo;
		this.nguoiLam = nguoiLam;
		this.yeuCauChuyenMon = yeuCauChuyenMon;
		this.soTiet = soTiet;
	}
	
	@Override
	public CongViec clone() throws CloneNotSupportedException {
		return new CongViec(this.maCV, this.tenCV,this.soNguoiToiThieu,this.soNguoiToiDa,this.yeuCauChuNhiem,this.yeuCauChuyenMon,this.thu,
				this.tiet,this.thoiGian,this.trongSo,this.nguoiLam,this.soTiet);
	}

	public String getMaCV() {
		return maCV;
	}

	public void setMaCV(String maCV) {
		this.maCV = maCV;
	}

	public String getTenCV() {
		return tenCV;
	}

	public void setTenCV(String tenCV) {
		this.tenCV = tenCV;
	}

	public int getSoNguoiToiThieu() {
		return soNguoiToiThieu;
	}

	public void setSoNguoiToiThieu(int soNguoiToiThieu) {
		this.soNguoiToiThieu = soNguoiToiThieu;
	}

	public int getSoNguoiToiDa() {
		return soNguoiToiDa;
	}

	public void setSoNguoiToiDa(int soNguoiToiDa) {
		this.soNguoiToiDa = soNguoiToiDa;
	}

	public int getYeuCauChuNhiem() {
		return yeuCauChuNhiem;
	}

	public void setYeuCauChuNhiem(int yeuCauChuNhiem) {
		this.yeuCauChuNhiem = yeuCauChuNhiem;
	}

	public int getThu() {
		return thu;
	}

	public void setThu(int thu) {
		this.thu = thu;
	}

	public int getTiet() {
		return tiet;
	}

	public void setTiet(int tiet) {
		this.tiet = tiet;
	}

	public int getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(int thoiGian) {
		this.thoiGian = thoiGian;
	}

	public int getTrongSo() {
		return trongSo;
	}

	public void setTrongSo(int trongSo) {
		this.trongSo = trongSo;
	}

	public ArrayList<String> getNguoiLam() {
		return nguoiLam;
	}

	public void setNguoiLam(ArrayList<String> nguoiLam) {
		this.nguoiLam = nguoiLam;
	}

	public String getYeuCauChuyenMon() {
		return yeuCauChuyenMon;
	}

	public void setYeuCauChuyenMon(String yeuCauChuyenMon) {
		this.yeuCauChuyenMon = yeuCauChuyenMon;
	}


	@Override
	public String toString() {
		return "CongViec [maCV=" + maCV + ", tenCV=" + tenCV + ", soNguoiToiThieu=" + soNguoiToiThieu
				+ ", soNguoiToiDa=" + soNguoiToiDa + ", yeuCauChuNhiem=" + yeuCauChuNhiem + ", yeuCauChuyenMon="
				+ yeuCauChuyenMon + ", thu=" + thu + "," + "tiet=" + tiet + ", thoiGian=" + thoiGian
				+ ", trongSo=" + trongSo + ", nguoiLam=" + nguoiLam + ", soTiet=" + soTiet + "]";
	}

	public ArrayList<SoTiet> getSoTiet() {
		return soTiet;
	}

	public void setSoTiet(ArrayList<SoTiet> soTiet) {
		this.soTiet = soTiet;
	}
	
	@Override
	public boolean equals(Object obj) {
		CongViec cv = (CongViec) obj;
		if (cv.getMaCV().equals(this.maCV) && cv.getTenCV().equals(this.getTenCV()) && cv.getSoNguoiToiThieu() == this.getSoNguoiToiThieu()
				&& cv.getSoNguoiToiDa() == this.getSoNguoiToiDa() && cv.getYeuCauChuNhiem() == this.getYeuCauChuNhiem() && 
				cv.getYeuCauChuyenMon().equals(this.yeuCauChuyenMon) && cv.getTiet() == this.tiet && cv.getThoiGian() == this.thoiGian && 
				cv.getThu() == this.thu && cv.trongSo == this.trongSo) {
			return true;
		} else {
			return false;
		}
	}
}