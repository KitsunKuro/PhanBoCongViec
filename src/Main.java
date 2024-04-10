import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<GiaoVien> giaoVien = new ArrayList<>();
		ArrayList<CongViec> congViec = new ArrayList<>();
		long startTime = System.currentTimeMillis();
		try {
			File file = new File("TKBRIU.txt");
			Scanner sc = new Scanner(file);
			sc.nextLine();
			String line = sc.nextLine();
			line = sc.nextLine();
			while (line != null) {
				GiaoVien gv = new GiaoVien();
				int chan1 = 0, chan2 = 0, chan3 = 0;
				
				for (int i = 0; i < line.length();i++) {
					if (line.charAt(i) == '\t') {
						gv.setMaGV(line.substring(0,i));
						chan1 = i;
						break;
					}
				}
				
				for (int i = chan1+1; i < line.length();i++) {
					if (line.charAt(i) == '\t') {
						chan2 = i;
						gv.setTenGV(line.substring(chan1+1,chan2));
//						System.out.println(line.substring(chan1+1,chan2));
						break;
					}
				}
				
				for (int i = chan2+1; i < line.length();i++) {
					if (line.charAt(i) == '\t') {
						chan1 = i;
						gv.setChuyenMon(line.substring(chan2+1,i));
//						System.out.println(line.substring(chan2+1,i));
						break;
					}
				}
				
				for (int i = chan1+1; i < line.length();i++) {
					if (line.charAt(i) =='\t') {
						chan2 = i;
						gv.setChuNhiemKhoi(Integer.valueOf(line.substring(chan1+1,i)));
//						System.out.println(line.substring(chan1+1,i));
						break;
					}
				}
				
				for (int i = chan2+1; i < line.length();i++) {
					if (line.charAt(i) == '\t') {
						chan1 = i;
						gv.setDiemSoCongViec(Integer.valueOf(line.substring(chan2+1,i)));
//						System.out.println(line.substring(chan2+1,i));
						break;
					}
				}
				
				// ===============================================================================
				
				for (int i = chan2+1; i < line.length(); i++) {
					if (line.charAt(i) == '\t') {
						chan2 = i;
						break;
					}
				}
				
				for (int i = chan1+1; i<line.length();i++) {
					if (line.charAt(i) == '\t') {
						chan1 = i;
						break;
					}
				}
				
				int tmp = chan2;
				chan2 = chan1;
				chan1 = tmp;
				int dem = 1;
				String lopHoc = "";
				SoTiet a = new SoTiet();
				lopHoc = line.substring(chan1+1,chan2);
				if (lopHoc.equals("x")) {
					dem++;
				} else {
					a = new SoTiet();
					if (dem%9 == 0) {
						a.setTiet(9);
						a.setNgay(dem/9 +1);
					} else {
						a.setTiet(dem%9);
						a.setNgay(dem/9 + 2);
					}
					a.setLopHoc(line.substring(chan1+1,chan2));
					dem++;
					gv.getTietDay().add(a);
				}
				
				for (int i = chan2+1; i < line.length(); i++) {
					if (i == line.length()-1) {
						lopHoc = "";
						lopHoc = line.substring(chan2+1,line.length());
						if (lopHoc.equals("x")) {
							dem++;
						} else {
							a = new SoTiet();
							if (dem%9 == 0) {
								a.setTiet(9);
								a.setNgay(dem/9 +1);
							} else {
								a.setTiet(dem%9);
								a.setNgay(dem/9 +2);
							}
							a.setLopHoc(line.substring(chan1+1,chan2));
							dem++;
							gv.getTietDay().add(a);
						}
						//System.out.print(line.substring(chan2+1,line.length()));
					} else {
						if (line.charAt(i) == '\t') {
							chan1 = chan2;
							chan2 = i;
							lopHoc = "";
							lopHoc = line.substring(chan1+1,chan2);
							if (lopHoc.equals("x")) {
								dem++;
							} else {
								a = new SoTiet();
								if (dem%9 == 0) {
									a.setTiet(9);
									a.setNgay(dem/9 +1);
								} else {
									a.setTiet(dem%9);
									a.setNgay(dem/9 +2);
								}
								a.setLopHoc(line.substring(chan1+1,chan2));
								dem++;
								gv.getTietDay().add(a);
							}
							//System.out.print(line.substring(chan1+1,chan2));
						}
					}
				}
				gv.setDiemSoCongViec(gv.getDiemSoCongViec() + gv.getTietDay().size());
				giaoVien.add(gv);
//				System.out.println(gv.toString());
				
				try {
					line = sc.nextLine();
				} catch (Exception e) {
					line = null;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ========================================================================================================================================= //
		try {
			File file = new File("CongViec.txt");
			Scanner sc = new Scanner(file);
			sc.nextLine();
			String line = sc.nextLine();
			while (line!= null) {
				CongViec cv = new CongViec();
				int chan1 = 0, chan2 = 0;
				int stt = 0;
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == '\t') {
						chan2 = i;
						cv.setMaCV(line.substring(0,i));
						break;
					}
				}
				
				for (int i = chan2+1; i < line.length(); i++) {
					if (line.charAt(i) == '\t') {
						chan1 = chan2;
						chan2 = i;
						cv.setTenCV(line.substring(chan1+1,chan2));
						break;
					}
				}
				
				for (int i = chan2+1; i < line.length(); i++) {
					if (line.charAt(i) == '\t') {
						chan1 = chan2;
						chan2 = i;
						cv.setSoNguoiToiThieu(Integer.valueOf(line.substring(chan1+1,chan2)));
						break;
					}
				}

				for (int i = chan2+1; i < line.length(); i++) {
					if (line.charAt(i) == '\t') {
						chan1 = chan2;
						chan2 = i;
						cv.setSoNguoiToiDa(Integer.valueOf(line.substring(chan1+1,chan2)));
						break;
					}
				}
				
				for (int i = chan2+1; i < line.length(); i++) {
					if (line.charAt(i) == '\t') {
						chan1 = chan2;
						chan2 = i;
						cv.setYeuCauChuNhiem(Integer.valueOf(line.substring(chan1+1,chan2)));
						break;
					}
				}
				
				for (int i = chan2+1; i < line.length(); i++) {
					if (line.charAt(i) == '\t') {
						chan1 = chan2;
						chan2 = i;
						cv.setYeuCauChuyenMon(line.substring(chan1+1,chan2));
						break;
					}
				}
				
				for (int i = chan2+1; i < line.length(); i++) {
					if (line.charAt(i) == '\t') {
						chan1 = chan2;
						chan2 = i;
						cv.setThu(Integer.valueOf(line.substring(chan1+1,chan2)));
						break;
					}
				}
				
				for (int i = chan2+1; i < line.length(); i++) {
					if (line.charAt(i) == '\t') {
						chan1 = chan2;
						chan2 = i;
						cv.setTiet(Integer.valueOf(line.substring(chan1+1,chan2)));
						break;
					}
				}
				
				for (int i = chan2+1; i < line.length(); i++) {
					if (line.charAt(i) == '\t') {
						chan1 = chan2;
						chan2 = i;
						cv.setThoiGian(Integer.valueOf(line.substring(chan1+1,chan2)));
						break;
					}
				}
				
				for (int i = chan2+1; i < line.length(); i++) {
					if (line.charAt(i) == '\t') {
						chan1 = chan2;
						chan2 = i;
						cv.setTrongSo(Integer.valueOf(line.substring(chan1+1,chan2)));

						break;
					}
				}
				
				ArrayList<String> nguoiLam = new ArrayList<>();
				String nguoilam = line.substring(chan2+1,line.length());
				int dem = 0;
				int chan = 0;
				for (int i = 0; i < nguoilam.length(); i++) {
					if (nguoilam.charAt(i) == ',') {
						if (dem == 0) {
							nguoiLam.add(nguoilam.substring(0,i));
							chan = i;
							dem++;
						} else {
							nguoiLam.add(nguoilam.substring(chan+1,i));
							dem++;
						}
					}
					
					if (i == nguoilam.length()-1) {
						nguoiLam.add(nguoilam.substring(chan+1,nguoilam.length()));
					}
				}
				
				if (dem == 0 && nguoilam != "x") {
					nguoiLam = new ArrayList<>();
					nguoiLam.add(nguoilam.substring(0,nguoilam.length()));
				} else if (dem == 0 && nguoilam == "x") {
					nguoiLam = new ArrayList<>();
				}
				
				cv.setNguoiLam(nguoiLam);
				congViec.add(cv);
				
				try {
					line = sc.nextLine();
				} catch (Exception e) {
					line = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		QuanThe qt = new QuanThe();
		for (int i = 0; i < CacHamLienQuan.soLuongCaThe; i ++) {
			ArrayList<GiaoVien> gvm = CacHamLienQuan.cloneListGV(giaoVien);
			ArrayList<CongViec> cvm = CacHamLienQuan.cloneListCV(congViec);
			CaThe a = new CaThe();
			a = CacHamLienQuan.KhoiTaoCaThe(gvm, cvm);
			qt.getQt().add(a);
		}
		CacHamLienQuan.SapXepQT(qt.getQt());
		for (int i = 0; i < qt.getQt().size(); i++) {
			System.out.println(qt.getQt().get(i).getPs());
		}
		
		// Doan thuc hien dot bien ca the 
		
		for (int i = 0; i < CacHamLienQuan.soTheHe; i++) {
			qt.LaiGhep();
			qt.DotBienQuanThe();
			qt.ChonLocCaThe();
		}
		
		System.out.println("======================================================");
		
		CacHamLienQuan.SapXepQT(qt.getQt());
		for (int i = 0; i < qt.getQt().size(); i++) {
			System.out.println(qt.getQt().get(i).getPs());
		}
		
		long endTime = System.currentTimeMillis();
		float time = (endTime-startTime)/1000f;
		System.out.println("Thời gian là : " + time);
		
		// Ghi file
		try {
			File file = new File("CongViecOut.txt");
			FileWriter fout = new FileWriter(file);
			fout.write("Mã CV\tTên CV\tSố người tối thiểu\tSố người tối đa\tYc chủ nhiệm\tYc chuyên môn\tThứ\tTiết\tThời gian\tTrọng số điểm\tNgười làm\n");
			CaThe a = qt.getQt().get(0);
			for (int i = 0; i < a.getCv().size(); i++) {
				CongViec cv = a.getCv().get(i);
				fout.write(cv.getMaCV() + "\t"+ cv.getTenCV() + "\t" + cv.getSoNguoiToiThieu() + "\t" + cv.getSoNguoiToiDa() + "\t" + cv.getYeuCauChuNhiem()
				+ "\t" + cv.getYeuCauChuyenMon() + "\t" + cv.getThu() + "\t" + cv.getTiet()+ "\t" + cv.getThoiGian() + "\t");
				for (int j = 0; j < cv.getNguoiLam().size(); j++) {
					if (j == cv.getNguoiLam().size()-1) fout.write(cv.getNguoiLam().get(j));
					else fout.write(cv.getNguoiLam().get(j)+",");
				}
				if (i != a.getCv().size()-1) fout.write("\n"); 
			}
			fout.write("\nPhương sai ban đầu là : " + CacHamLienQuan.tinhPhuongSai(giaoVien));
			fout.write("\nPhương sai là : " + a.getPs());
			System.out.println(a.getPs());
			fout.close();
			
			file = new File("TKB_out.txt");
			fout = new FileWriter(file);
			fout.write("\t\t\t\t\t\t\t\t\tThứ 2\t\t\t\t\t\t\t\t\tThứ 3\t\t\t\t\t\t\t\t\tThứ 4\t\t\t\t\t\t\t\t\tThứ 5\t\t\t\t\t\t\t\t\tThứ 6\n");
			fout.write("Mã GV\tTên GV\t\tCmôn\tCNhiệm\tĐiểmTL");
			for (int i = 0; i <=4; i++) {
				fout.write("\t1\t2\t3\t4\t5\t6\t7\t8\t9");
			}
			fout.write("\n");
			for (int i = 0; i < a.getGv().size(); i++) {
				GiaoVien gv = a.getGv().get(i);
				fout.write(gv.getMaGV() + "\t" + gv.getTenGV() + "\t" + gv.getChuyenMon() + "\t" + gv.getChuNhiemKhoi() + "\t" + gv.getDiemSoCongViec() +"\t");
				gv.SapXep();
				
				for (int j = 2; j <= 6; j++) {
					for (int k = 1; k <= 9; k++) {
						boolean check = true;
						for (SoTiet st : a.getGv().get(i).getTietDay()) {
							if (st.getNgay() == j && st.getTiet() == k) {
								fout.write(st.getLopHoc() + "\t");
								check = false;
								break;
							}
							if (st.getNgay() > j || st.getTiet() > k) {
								check = false;
								break;
							}
						}
						if (check == false) fout.write("x\t");
					}
				}
				
				if (i != a.getGv().size()-1) fout.write("\n");
			}
			fout.write("\nPhương sai ban đầu là : " + CacHamLienQuan.tinhPhuongSai(giaoVien));
			fout.write("\nPhương sai là : " + a.getPs());
			fout.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
