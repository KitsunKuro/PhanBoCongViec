import java.util.ArrayList;
import java.util.Random;

public class CacHamLienQuan {
	public static final float tiLeDotBien = 0.2f;
	public static final int soLuongCaThe = 100;
	public static final int soTheHe = 10000;
	
	public static ArrayList<String> KiemTraGVThoaMan(ArrayList<GiaoVien> giaoVien, CongViec congViec) {
		ArrayList<String> gvtm = new ArrayList<>();
		for (int i = 0; i < giaoVien.size(); i++) {
			boolean check = true;
			if (congViec.getYeuCauChuyenMon().length() != 1) {
				if (!congViec.getYeuCauChuyenMon().equals(giaoVien.get(i).getChuyenMon())) {
					check = false;
				}
			}
			
			if (congViec.getYeuCauChuNhiem() != 0) {
				if (congViec.getYeuCauChuNhiem() != giaoVien.get(i).getChuNhiemKhoi()) {
					check = false;
				}
			}
			
			for (int j = 0; j < congViec.getSoTiet().size(); j++) {
				for (int k = 0; k < giaoVien.get(i).getTietDay().size(); k++) {
					if (giaoVien.get(i).getTietDay().get(k).getNgay() == congViec.getSoTiet().get(j).getNgay()) {
						if (giaoVien.get(i).getTietDay().get(k).getTiet() == congViec.getSoTiet().get(j).getTiet()) {
							check = false;
							break;
						}
					}
				}
			}
			if (check == true) gvtm.add(giaoVien.get(i).getMaGV());
		}
		return gvtm;
	}
	
	public static void forceCongViec(CongViec cv,ArrayList<GiaoVien> gv) {
		cv.getSoTiet().clear();
		boolean check = false;
		for (int i = 2; i <= 6; i++) {
			if (check) break;
			for (int j = 1; j<= 9; j++) {
				cv.getSoTiet().clear();
				if (check) break;
				SoTiet a = new SoTiet();
				int tiet = j;
				int thu = i;
				switch (cv.getThoiGian()) {
				case 1:
					a = new SoTiet(thu,tiet,cv.getTenCV());
					cv.getSoTiet().add(a);
					cv.setTiet(tiet);
					cv.setThu(thu);
					ArrayList<String> gvtm1 = new ArrayList<>();
					gvtm1 = CacHamLienQuan.KiemTraGVThoaMan(gv, cv);
					if (gvtm1.size() < cv.getSoNguoiToiThieu()) {
						break;
					} else {
						check = true;
					}
					break;
					
				case 2:
					switch (j) {
					case 1:case 2: case 3: case 4: case 6: case 7: case 8:
						ArrayList<String> gvtm = new ArrayList<>();
						for (int k = 0; k < 2; k++) {
							a = new SoTiet(thu,tiet+k,cv.getTenCV());
						}
						cv.setTiet(tiet);
						cv.setThu(thu);
						gvtm = CacHamLienQuan.KiemTraGVThoaMan(gv, cv);
						if (gvtm.size() < cv.getSoNguoiToiThieu()) {
							break;
						} else {
							check = true;
						}
						break;

					default:
						break;
					}
					break;
					
				case 3:
					switch (j) {
					case 1:case 2: case 3: case 6: case 7:
						ArrayList<String> gvtm = new ArrayList<>();
						for (int k = 0; k < 3; k++) {
							a = new SoTiet(thu,tiet+k,cv.getTenCV());
						}
						cv.setTiet(tiet);
						cv.setThu(thu);
						gvtm = CacHamLienQuan.KiemTraGVThoaMan(gv, cv);
						if (gvtm.size() < cv.getSoNguoiToiThieu()) {
							break;
						} else {
							check = true;
						}
						break;

					default:
						break;
					}
					break;
					
				case 4:
					switch (j) {
					case 1:case 2: case 6: 
						ArrayList<String> gvtm = new ArrayList<>();
						for (int k = 0; k < 4; k++) {
							a = new SoTiet(thu,tiet+k,cv.getTenCV());
						}
						cv.setTiet(tiet);
						cv.setThu(thu);
						gvtm = CacHamLienQuan.KiemTraGVThoaMan(gv, cv);
						if (gvtm.size() < cv.getSoNguoiToiThieu()) {
							break;
						} else {
							check = true;
						}
						break;

					default:
						break;
					}
					break;
					
				case 5:
					switch (j) {
					case 1:
						ArrayList<String> gvtm = new ArrayList<>();
						for (int k = 0; k < 5; k++) {
							a = new SoTiet(thu,tiet+k,cv.getTenCV());
						}
						cv.setTiet(tiet);
						cv.setThu(thu);
						gvtm = CacHamLienQuan.KiemTraGVThoaMan(gv, cv);
						if (gvtm.size() < cv.getSoNguoiToiThieu()) {
							break;
						} else {
							check = true;
						}
						break;

					default:
						break;
					}
					break;
					
				default:
					break;
				}
			}
		}
	}
	
	public static void khoiTaoCongViec(CongViec cv) {
		cv.getSoTiet().clear();
		int thu = (int) (Math.random()*5) + 2;
		if (cv.getThu() == 0) {
			SoTiet a = new SoTiet();
			int tiet = 0;
			int thutu = 0;
			switch (cv.getThoiGian()) {
			case 1:
				tiet = (int) (Math.random()*9) + 1;
				a = new SoTiet(thu,tiet,cv.getTenCV());
				cv.getSoTiet().add(a);
				cv.setTiet(tiet);
				cv.setThu(thu);
				break;
				
			case 2:
				int[] dayso2 = {1,2,3,4,6,7,8};
				thutu = dayso2[(int) (Math.random()*dayso2.length)];
				cv.setTiet(thutu);
				cv.setThu(thu);
				for (int i = 0; i < 2; i++) {
					a = new SoTiet(thu,thutu+i,cv.getTenCV());
					cv.getSoTiet().add(a);
				}
				break;
				
			case 3:
				int[] dayso3 = {1,2,3,6,7};
				thutu = dayso3[(int)(Math.random()* dayso3.length)];
				cv.setTiet(thutu);
				cv.setThu(thu);
				for (int i = 0; i < 3; i++) {
					a = new SoTiet(thu,thutu+i,cv.getTenCV());
					cv.getSoTiet().add(a);
				}
				break;
				
			case 4:
				int[] dayso4 = {1,2,6};
				thutu = dayso4[(int)(Math.random()* dayso4.length)];
				cv.setTiet(thutu);
				cv.setThu(thu);
				for (int i = 0; i < 4; i++) {
					a = new SoTiet(thu,thutu+i,cv.getTenCV());
					cv.getSoTiet().add(a);
				}
				break;
				
			case 5:
				a = new SoTiet(thu,1,cv.getTenCV());
				cv.getSoTiet().add(a);
				cv.setTiet(1);
				cv.setThu(thu);
				break;	
			default:
				break;
			}
		} else {
			for (int i = 0; i < cv.getThoiGian(); i++) {
				SoTiet a = new SoTiet(cv.getThu(),cv.getTiet()+i,cv.getTenCV());
				cv.getSoTiet().add(a);
			}
		}
	}

	public static void khoiTaoNguoiLam(ArrayList<String> gvtm, CongViec cv, ArrayList<GiaoVien> giaoVien) {
		if (!gvtm.isEmpty()) {
		if (gvtm.size() < cv.getSoNguoiToiThieu()) {
//			System.out.println("Công việc " + cv.getMaCV() + " không có đủ người làm !");
		} else {
			int random = 0;
			ArrayList<String> nl = new ArrayList<>();
			if (cv.getSoNguoiToiDa() == cv.getSoNguoiToiThieu()) {
				random = cv.getSoNguoiToiThieu();
			} else {
				random = (int)((Math.random()*(cv.getSoNguoiToiThieu()+1)) + (cv.getSoNguoiToiDa()-cv.getSoNguoiToiThieu()));	
			}
			if (random > gvtm.size()) random = gvtm.size();
			// Ép người làm làm việc
			int dem = 0;
			int solanchan = (int)(random - cv.getSoNguoiToiThieu() / 2);
			if (solanchan < 0) solanchan = 0;
			for (int i = 0; i < cv.getNguoiLam().size(); i++) {
				for (GiaoVien gv : giaoVien) {
					if (gv.getMaGV().equals(cv.getNguoiLam().get(i))) {
						dem++;
						int chan = cv.getSoTiet().size() - solanchan;
						if (chan <= 0) chan = 1;
//						System.out.print(cv.getNguoiLam().get(i) + " -- ");
						for (int j = 0; j < chan; j++) {
							gv.getTietDay().add(cv.getSoTiet().get(j));
						}
						nl.add(cv.getNguoiLam().get(i));
						gv.setDiemSoCongViec(gv.getDiemSoCongViec() + cv.getTrongSo());
						break;
					}
				}
				gvtm.remove(cv.getNguoiLam().get(i));
			}
			
			// Phan chia cong viec binh thuong ~
			for (int i = 0; i < random-dem; i++) {
				String rd = gvtm.get((int)(Math.random()*gvtm.size()));
				for (GiaoVien gv : giaoVien) {
					if (gv.getMaGV().equals(rd)) {
//						System.out.print(rd + " -- ");
						int chan = cv.getSoTiet().size() - solanchan;
						if (chan <= 0) chan = 1;
						for (int j = 0; j < chan; j++) {
							gv.getTietDay().add(cv.getSoTiet().get(j));
						}
						nl.add(rd);
						gv.setDiemSoCongViec(gv.getDiemSoCongViec() + cv.getTrongSo());
						break;
					}
				}
				gvtm.remove(rd);
			}
			cv.setNguoiLam(nl);
		}} else {
//			System.out.println("Công việc " + cv.getMaCV() + " không có đủ người làm !");
		}
	}

	public static float tinhPhuongSai(ArrayList<GiaoVien> giaoVien) {
		float ps = 0;
		float tb = 0;
		for (int i = 0; i < giaoVien.size(); i++) {
			tb += giaoVien.get(i).getDiemSoCongViec();
		}
		tb /= giaoVien.size();
		for (int i = 0; i < giaoVien.size(); i++) {
			ps += Math.pow(2, (tb-giaoVien.get(i).getDiemSoCongViec()));
		}
		ps /= giaoVien.size();
		ps = (float)Math.sqrt(ps);
		return ps;
	}
	
	public static CaThe KhoiTaoCaThe(ArrayList<GiaoVien> gv, ArrayList<CongViec> cv) {
		CaThe b = new CaThe();
		for (int i = 0; i < cv.size(); i++) {
			ArrayList<String> gvtm = new ArrayList<>();
			CacHamLienQuan.khoiTaoCongViec(cv.get(i));
			gvtm = CacHamLienQuan.KiemTraGVThoaMan(gv, cv.get(i));
			int dem = 0;
			while (gvtm.isEmpty()) {
				CacHamLienQuan.khoiTaoCongViec(cv.get(i));
				gvtm = CacHamLienQuan.KiemTraGVThoaMan(gv, cv.get(i));
				if (dem == 100) {
//					System.out.println("Công việc " + cv.get(i).getTenCV()+ " không đủ người làm !");
					forceCongViec(cv.get(i), gv);
					break;
				}
				dem++;
			}
			CacHamLienQuan.khoiTaoNguoiLam(gvtm, cv.get(i), gv);
		}
		for (int i = 0 ; i < gv.size(); i++) {
			gv.get(i).SapXep();
		}
		float ps = CacHamLienQuan.tinhPhuongSai(gv);
		b = new CaThe(gv,cv,ps);
		return b;
	}
	
	public static ArrayList<GiaoVien> cloneListGV (ArrayList<GiaoVien> giaoVien){
		ArrayList<GiaoVien> gv = new ArrayList<>();
		for (GiaoVien gvm : giaoVien) {
			GiaoVien gvsm = new GiaoVien();
			ArrayList<SoTiet> st = new ArrayList<>();
			for (int i = 0; i < gvm.getTietDay().size(); i++) {
				SoTiet a = new SoTiet();
				a.setLopHoc(gvm.getTietDay().get(i).getLopHoc());
				a.setNgay(gvm.getTietDay().get(i).getNgay());
				a.setTiet(gvm.getTietDay().get(i).getTiet());
				st.add(a);
			}
			gvsm = new GiaoVien(gvm.getMaGV(),gvm.getChuyenMon(),gvm.getTenGV(),gvm.getChuNhiemKhoi(),gvm.getDiemSoCongViec(),st);
			gv.add(gvsm);
		}
		return gv;
	}
	
	public static ArrayList<CongViec> cloneListCV (ArrayList<CongViec> congViec){
		ArrayList<CongViec> cv = new ArrayList<>();
		for (CongViec cvm : congViec) {
			CongViec cvsm = new CongViec();
			ArrayList<String> nl = new ArrayList<>();
			ArrayList<SoTiet> st = new ArrayList<>();
			for (int i = 0; i < cvm.getSoTiet().size(); i++) {
				SoTiet stm = new SoTiet();
				stm.setTiet(cvm.getSoTiet().get(i).getTiet());
				stm.setNgay(cvm.getSoTiet().get(i).getNgay());
				stm.setLopHoc(cvm.getSoTiet().get(i).getLopHoc());
				st.add(stm);
			}
			for (int i = 0; i < cvm.getNguoiLam().size(); i++) {
				nl.add(cvm.getNguoiLam().get(i));
			}
			cvsm = new CongViec(cvm.getMaCV(),cvm.getTenCV(),cvm.getSoNguoiToiThieu(),cvm.getSoNguoiToiDa(),
					cvm.getYeuCauChuNhiem(),cvm.getYeuCauChuyenMon(),cvm.getThu(),cvm.getTiet(),cvm.getThoiGian(),
					cvm.getTrongSo(),nl,st);
			cv.add(cvsm);
		}
		return cv;
	}
	
	public static void SapXepQT(ArrayList<CaThe> qt) {
		for (int i = 0; i < qt.size()-1; i++) {
			for (int j = i+1; j < qt.size(); j++) {
				if (qt.get(i).getPs() > qt.get(j).getPs()) {
					CaThe a = new CaThe(qt.get(i).getGv(),qt.get(i).getCv(),qt.get(i).getPs());
					qt.get(i).setCv(qt.get(j).getCv());
					qt.get(i).setGv(qt.get(j).getGv());
					qt.get(i).setPs(qt.get(j).getPs());
					qt.get(j).setCv(a.getCv());
					qt.get(j).setGv(a.getGv());
					qt.get(j).setPs(a.getPs());
				}
			}
		}
	}
	
	public static CaThe DotBienCaThe(CaThe a) {
		int random = (int)(Math.random()*a.getCv().size());
		random = 1;
		ArrayList<GiaoVien> gvm = a.getGv();
		CongViec cv = a.getCv().get(random);
		boolean check = true;
		for (GiaoVien gv : gvm) {
			check = true;
			for (int i = 0; i < gv.getTietDay().size(); i++) {
				if (cv.getTenCV().equals(gv.getTietDay().get(i).getLopHoc())) {
					gv.getTietDay().remove(i);
					i--;
					check = false;
				}
			}
			if (!check) gv.setDiemSoCongViec(gv.getDiemSoCongViec() - cv.getTrongSo());
		}
		CacHamLienQuan.khoiTaoCongViec(cv);
		ArrayList<String> gvtm = CacHamLienQuan.KiemTraGVThoaMan(gvm, cv);
		CacHamLienQuan.khoiTaoNguoiLam(gvtm, cv, gvm);
		float ps = CacHamLienQuan.tinhPhuongSai(gvm);
		a.getCv().set(random, cv);
		CaThe b = new CaThe(gvm,a.getCv(),ps);
		return b;
	}
}
