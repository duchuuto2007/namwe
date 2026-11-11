package quanlidatdai_tuan8;

import java.time.LocalDate;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		QuanLiGiaoDich ql = new QuanLiGiaoDich();

		// ===== Tạo 3 giao dịch ĐẤT =====
		ql.themGiaoDich(new GiaoDichDat("D01", LocalDate.of(2013, 9, 5), 10_000_000, 100, "A"));
		ql.themGiaoDich(new GiaoDichDat("D02", LocalDate.of(2013, 10, 12), 8_000_000, 200, "B"));
		ql.themGiaoDich(new GiaoDichDat("D03", LocalDate.of(2013, 9, 25), 6_000_000, 150, "C"));

		// ===== Tạo 3 giao dịch NHÀ =====
		ql.themGiaoDich(new GiaoDichNha("N01", LocalDate.of(2013, 9, 15), 12_000_000, 80, "Cao Cap", "123 Lê Lợi, Q1"));
		ql.themGiaoDich(new GiaoDichNha("N02", LocalDate.of(2013, 11, 3), 9_000_000, 120, "Binh Thuong",
				"456 Nguyễn Trãi, Q5"));
		ql.themGiaoDich(new GiaoDichNha("N03", LocalDate.of(2013, 9, 20), 7_500_000, 90, "Binh Thuong",
				"789 Cách Mạng Tháng 8, Q10"));
		System.out.println("=== TỔNG SỐ LƯỢNG ===");
		System.out.println("Số giao dịch đất: " + ql.demSoLuongDat());
		System.out.println("Số giao dịch nhà: " + ql.demSoLuongNha());

		// ===== 2. Trung bình thành tiền đất =====
		System.out.printf("%n=== TRUNG BÌNH THÀNH TIỀN ĐẤT: %,.0f ===%n", ql.trungBinhThanhTienDat());

		// ===== 3. Giao dịch tháng 9/2013 =====
		System.out.println("\n=== GIAO DỊCH THÁNG 9/2013 ===");
		List<GiaoDich> dsThang9 = ql.xuatVaoThang9Nam2013();
		if (dsThang9.isEmpty()) {
			System.out.println("Không có giao dịch nào!");
		} else {
			for (GiaoDich gd : dsThang9) {
				System.out.println(gd);
			}
		}
	}

}
