package tuan6_huuduc;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

		try {

			// Tao 3 doi tuong voi UUID tu dong
			HangThucPham hang1 = new HangThucPham("Gao", 100000.0, LocalDate.of(2018, 7, 10), LocalDate.of(2018, 3, 1));

			HangThucPham hang2 = new HangThucPham("Duong", 25000.0, LocalDate.of(2024, 1, 15),
					LocalDate.of(2025, 1, 15));

			HangThucPham hang3 = new HangThucPham("Sua", 45000.0, LocalDate.of(2024, 8, 1), LocalDate.of(2024, 9, 1));

			// Xuat bang thong tin
			System.out.println(
					"==============================================================================================");

			System.out.printf("| %-10s | %-10s | %15s | %12s | %12s | %-15s |\n", "Ma", "Hang", "Don Gia", "Ngay SX",
					"Ngay HH", "Ghi Chu");

			System.out.println(
					"----------------------------------------------------------------------------------------------");

			System.out.println(hang1);
			System.out.println(hang2);
			System.out.println(hang3);

			System.out.println(
					"==============================================================================================");

			// Kiem thu cac rang buoc
			System.out.println("\n=== KIEM THU CAC RANG BUOC ===");

			// 1. Kiem tra ma hang rong
			try {
				HangThucPham hang4 = new HangThucPham("", "Test", 1000.0, LocalDate.now().minusDays(1),
						LocalDate.now().plusDays(1));

				System.out.println("Test ma rong: Khong nem ngoai le (Sai!)");

			} catch (Exception e) {
				System.out.println("Test ma rong: " + e.getMessage() + " (Dung!)");
			}

			// 2. Kiem tra ten hang rong
			HangThucPham hang5 = new HangThucPham("004", "", 1000.0, LocalDate.now().minusDays(1),
					LocalDate.now().plusDays(1));

			System.out.println("Test ten rong: Ten mac dinh = " + hang5.getTenHang());

			// 3. Kiem tra don gia <= 0
			HangThucPham hang6 = new HangThucPham("005", "Test", -1000.0, LocalDate.now().minusDays(1),
					LocalDate.now().plusDays(1));

			System.out.println("Test don gia <= 0: " + hang6.getDonGia());

			// 4. Kiem tra ngay san xuat sau ngay hien tai
			HangThucPham hang7 = new HangThucPham("006", "Test", 1000.0, LocalDate.now().plusDays(1),
					LocalDate.now().plusDays(5));

			System.out.println("Test ngay SX sau hien tai: " + hang7.getNgaySanXuat());

			// 5. Kiem tra ngay het han truoc ngay san xuat
			HangThucPham hang8 = new HangThucPham("007", "Test", 1000.0, LocalDate.now().minusDays(1),
					LocalDate.now().minusDays(10));

			System.out.println("Test ngay HH truoc ngay SX: " + hang8.getNgayHetHan());

			System.out.println("\n=== KET THUC KIEM THU ===");

		} catch (Exception e) {
			System.out.println("Loi: " + e.getMessage());
		}
	}
}
