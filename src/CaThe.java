import java.util.ArrayList;

public class CaThe {
	private ArrayList<GiaoVien> gv;
	private ArrayList<CongViec> cv;
	private ArrayList<ArrayList<String>> nguoiLam;
	private float ps;
	
	CaThe(){
		gv = new ArrayList<>();
		cv = new ArrayList<>();
		nguoiLam = new ArrayList<>();
		ps = 0;
	}
	
	public CaThe(ArrayList<GiaoVien> gv, ArrayList<CongViec> cv, float ps) {
		super();
		this.gv = gv;
		this.cv = cv;
		this.ps = ps;
	}



	public ArrayList<GiaoVien> getGv() {
		return gv;
	}

	public void setGv(ArrayList<GiaoVien> gv) {
		this.gv = gv;
	}

	public ArrayList<CongViec> getCv() {
		return cv;
	}

	public void setCv(ArrayList<CongViec> cv) {
		this.cv = cv;
	}

	public float getPs() {
		return ps;
	}

	public void setPs(float ps) {
		this.ps = ps;
	}
	
	public ArrayList<ArrayList<String>> getNguoiLam() {
		return nguoiLam;
	}

	public void setNguoiLam(ArrayList<ArrayList<String>> nguoiLam) {
		this.nguoiLam = nguoiLam;
	}

	@Override
	public String toString() {
		return "CaThe [gv=" + gv + ", cv=" + cv + ", ps=" + ps + "]";
	}
	
}
