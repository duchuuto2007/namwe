package tuan6_huuduc;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class HangThucPham {

	private String maHang;
	private String tenHang;
	private double donGia;
	private LocalDate ngaySanXuat;
	private LocalDate ngayHetHan;

	private static final String TEN_HANG_DEFAULT = "xxx";
	private static final LocalDate NGAY_SAN_XUAT_DEFAULT = LocalDate.now();

	// Constructor 4 tham so
	public HangThucPham(String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) throws Exception {

		this.maHang = generateMaHang();
		setTenHang(tenHang);
		setDonGia(donGia);
		setNgaySanXuat(ngaySanXuat);
		setNgayHetHan(ngayHetHan);
	}

	// Constructor 5 tham so
	public HangThucPham(String maHang, String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan)
			throws Exception {

		setMaHang(maHang);
		setTenHang(tenHang);
		setDonGia(donGia);
		setNgaySanXuat(ngaySanXuat);
		setNgayHetHan(ngayHetHan);
	}

	// Tao ma hang tu dong
	private String generateMaHang() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().substring(0, 8).toUpperCase();
	}

	// Getter va Setter maHang
	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) throws Exception {
		if (maHang != null && !maHang.trim().isEmpty()) {
			this.maHang = maHang;
		} else {
			throw new Exception("Loi khong co ma don hang!");
		}
	}

	// Getter va Setter tenHang
	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		if (tenHang != null && !tenHang.trim().isEmpty()) {
			this.tenHang = tenHang;
		} else {
			this.tenHang = TEN_HANG_DEFAULT;
		}
	}

	// Getter va Setter donGia
	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		if (donGia > 0) {
			this.donGia = donGia;
		} else {
			this.donGia = 1.0;
		}
	}

	// Getter va Setter ngaySanXuat
	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if (ngaySanXuat != null && ngaySanXuat.isBefore(LocalDate.now())) {
			this.ngaySanXuat = ngaySanXuat;
		} else {
			this.ngaySanXuat = NGAY_SAN_XUAT_DEFAULT;
		}
	}

	// Getter va Setter ngayHetHan
	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		if (ngayHetHan != null && ngayHetHan.isAfter(this.ngaySanXuat)) {
			this.ngayHetHan = ngayHetHan;
		} else {
			this.ngayHetHan = this.ngaySanXuat;
		}
	}

	// Kiem tra hang het han
	public boolean kiemTraHetHan() {
		if (ngayHetHan == null) {
			return false;
		}

		return LocalDate.now().isAfter(ngayHetHan) || LocalDate.now().isEqual(ngayHetHan);
	}

	// Xuat thong tin
	@Override
	public String toString() {
		DecimalFormat dfDonGia = new DecimalFormat("###,###.00");
		DateTimeFormatter dfNgay = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String trangThai = kiemTraHetHan() ? "Hang het han" : "Hang con han";

		return String.format("| %-10s | %-10s | %15s | %12s | %12s | %-15s |", maHang, tenHang, dfDonGia.format(donGia),
				dfNgay.format(ngaySanXuat), dfNgay.format(ngayHetHan), trangThai);
	}
}