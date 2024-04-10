import java.util.ArrayList;

public class QuanThe {
	private ArrayList<CaThe> qt;
	
	QuanThe(){
		qt = new ArrayList<>();
	}

	public ArrayList<CaThe> getQt() {
		return qt;
	}

	public void setQt(ArrayList<CaThe> qt) {
		this.qt = qt;
	}
	
	public void LaiTaoQuanThe() {
		
	}
	
	public void LaiGhep() {
		CaThe cha = qt.get((int)(Math.random()*qt.size()));
		CaThe me = qt.get((int)(Math.random()*qt.size()));
		while (cha == me) {
			me = qt.get((int)(Math.random()*qt.size()));
		}
		int random = (int)(Math.random()*cha.getCv().size());
		while (!cha.getCv().get(random).equals(me.getCv().get(random))){
			random = (int)(Math.random()*cha.getCv().size());
		}
		CongViec cv = cha.getCv().get(random);
		
		ArrayList<String> nltm = new ArrayList<>();
		CaThe con = new CaThe();
		con.setCv(CacHamLienQuan.cloneListCV(cha.getCv()));
		con.setGv(CacHamLienQuan.cloneListGV(cha.getGv()));
		
		for (GiaoVien gv : con.getGv()) {
			for (int i = 0; i < gv.getTietDay().size(); i++) {
				if (cv.getTenCV().equals(gv.getTietDay().get(i).getLopHoc())) {
					gv.getTietDay().remove(i);
					i--;
				}
			}
		}
		
		for (String nl : me.getCv().get(random).getNguoiLam()) {
			nltm.add(nl);
		}		
		con.getCv().get(random).setNguoiLam(nltm);
		CacHamLienQuan.khoiTaoNguoiLam(nltm, con.getCv().get(random), con.getGv());
		
		con.setPs(CacHamLienQuan.tinhPhuongSai(con.getGv()));
		
		qt.add(con);
		
	}
	
	public void ChonLocCaThe() {
		// Tournament 
		CaThe cha = qt.get((int)(Math.random()*qt.size()));
		CaThe me = qt.get((int)(Math.random()*qt.size()));
		while (cha == me) {
			me = qt.get((int)(Math.random()*qt.size()));
		}
		if (cha.getPs() > me.getPs()) {
			qt.remove(cha);
		} else {
			qt.remove(me);
		}
	}
	
	public void DotBienQuanThe() {
		for (int i = 0; i < qt.size(); i++) {
			CaThe dotBien = new CaThe();
			dotBien = CacHamLienQuan.DotBienCaThe(qt.get(i));
			float khaNang = (float)Math.random();
			if (khaNang <= CacHamLienQuan.tiLeDotBien) {
				qt.set(i, dotBien);
			}
		}
	}
}
