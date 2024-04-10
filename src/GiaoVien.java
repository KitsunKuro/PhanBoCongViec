import java.util.ArrayList;

public class GiaoVien {
	private String maGV;
	private String chuyenMon;
	private String tenGV;
	private int chuNhiemKhoi;
	private int diemSoCongViec;
	private ArrayList<SoTiet> TietDay;
	
	public GiaoVien() {
		maGV = "";
		chuyenMon = "";
		tenGV = "";
		chuNhiemKhoi = 0;
		diemSoCongViec = 0;
		TietDay = new ArrayList<>();
	}
	
	public GiaoVien(String maGV, String chuyenMon, String tenGV, int chuNhiemKhoi, int diemSoCongViec,
			ArrayList<SoTiet> tietDay) {
		super();
		this.maGV = maGV;
		this.chuyenMon = chuyenMon;
		this.tenGV = tenGV;
		this.chuNhiemKhoi = chuNhiemKhoi;
		this.diemSoCongViec = diemSoCongViec;
		TietDay = tietDay;
	}



	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public String getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	public int getChuNhiemKhoi() {
		return chuNhiemKhoi;
	}

	public void setChuNhiemKhoi(int chuNhiemKhoi) {
		this.chuNhiemKhoi = chuNhiemKhoi;
	}

	public int getDiemSoCongViec() {
		return diemSoCongViec;
	}

	public void setDiemSoCongViec(int diemSoCongViec) {
		this.diemSoCongViec = diemSoCongViec;
	}

	public ArrayList<SoTiet> getTietDay() {
		return TietDay;
	}

	public void setTietDay(ArrayList<SoTiet> tietDay) {
		TietDay = tietDay;
	}

	public String getTenGV() {
		return tenGV;
	}

	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}

	@Override
	public String toString() {
		return "GiaoVien [maGV=" + maGV + ", chuyenMon=" + chuyenMon + ", tenGV=" + tenGV + ", chuNhiemKhoi="
				+ chuNhiemKhoi + ", diemSoCongViec=" + diemSoCongViec + ", TietDay=" + TietDay + "]";
	}
	
	@Override
	public GiaoVien clone() throws CloneNotSupportedException {
		return new GiaoVien(this.maGV, this.chuyenMon, this.tenGV, this.chuNhiemKhoi, this.diemSoCongViec, this.TietDay);
	}
	
	public void SapXep() {
		ArrayList<SoTiet> soTiet = new ArrayList<>();
		for (int i = 2; i <=6 ; i++) {
			for (int j = 1; j <= 9; j++) {
				for (SoTiet st : TietDay) {
					if (st.getNgay() == i && st.getTiet() == j) {
						SoTiet stm = new SoTiet(st.getNgay(),st.getTiet(),st.getLopHoc());
						soTiet.add(stm);
						break;
					}
				}
			}
		}
		setTietDay(soTiet);
	}
}
