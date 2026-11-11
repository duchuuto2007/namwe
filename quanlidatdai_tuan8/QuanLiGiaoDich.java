package quanlidatdai_tuan8;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class QuanLiGiaoDich {

	private List<GiaoDich> danhSachGiaoDich;

	/**
	 * @param danhSachGiaoDich
	 */
	public QuanLiGiaoDich() {
		this.danhSachGiaoDich = new ArrayList<>();
	}

	public void themGiaoDich(GiaoDich gd) {
		if (gd == null) {
			throw new IllegalArgumentException("Giao dich khong duoc null");
		}
		danhSachGiaoDich.add(gd);
	}

	public int demSoLuongDat() {
		int count = 0;
		for (GiaoDich gd : danhSachGiaoDich) {
			if (gd instanceof GiaoDichDat) {
				count++;
			}
		}
		return count;
	}

	public int demSoLuongNha() {
		int count = 0;
		for (GiaoDich gd : danhSachGiaoDich) {
			if (gd instanceof GiaoDichNha) {
				count++;
			}
		}
		return count;
	}

	public double trungBinhThanhTienDat() {
		double tong = 0;
		int count = 0;
		for (GiaoDich gd : danhSachGiaoDich) {
			if (gd instanceof GiaoDichDat) {
				tong += gd.thanhTien();
				count++;
			}
		}
		if (count == 0) {
			throw new IllegalArgumentException("Chua co giao dich dat nao");
		}
		return tong / count;
	}

	public List<GiaoDich> xuatVaoThang9Nam2013() {
		List<GiaoDich> ketQua = new ArrayList<>();
		YearMonth target = YearMonth.of(2013, 9);
		for (GiaoDich gd : danhSachGiaoDich) {
			if (YearMonth.from(gd.getNgayGiaoDich()).equals(target)) {
				ketQua.add(gd);
			}
		}
		return ketQua;
	}

	public List<GiaoDich> getDanhSachGiaoDich() {
		return danhSachGiaoDich;
	}
}
