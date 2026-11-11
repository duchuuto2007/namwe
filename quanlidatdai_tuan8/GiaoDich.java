package quanlidatdai_tuan8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class GiaoDich {
	protected String maGiaoDich;
	protected LocalDate ngayGiaoDich;
	protected double donGia;
	protected double dienTich;

	public GiaoDich() {

	}

	public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich) {
		setMaGiaoDich(maGiaoDich);
		setNgayGiaoDich(ngayGiaoDich);
		setDonGia(donGia);
		setDienTich(dienTich);
	}

	public void setMaGiaoDich(String maGiaoDich) {
		if (maGiaoDich == null || maGiaoDich.trim().isEmpty()) {
			throw new IllegalArgumentException("Ma giao dich khong duoc rong!!");
		}
		this.maGiaoDich = maGiaoDich;
	}

	public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
		if (ngayGiaoDich == null) {
			throw new IllegalArgumentException("Ngay giao dich khong duoc rong");
		}
		if (ngayGiaoDich.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Ngay giao dich khong phai la ngay trong tuong lai");
		}
		this.ngayGiaoDich = ngayGiaoDich;
	}

	public void setDonGia(double donGia) {
		if (donGia <= 0) {
			throw new IllegalArgumentException("Don gia phai > 0");
		}
		this.donGia = donGia;
	}

	public void setDienTich(double dienTich) {
		if (dienTich <= 0) {
			throw new IllegalArgumentException("Dien tich phai > 0");
		}
		this.dienTich = dienTich;
	}

	public String getMaGiaoDich() {
		return maGiaoDich;
	}

	public LocalDate getNgayGiaoDich() {
		return ngayGiaoDich;
	}

	public double getDonGia() {
		return donGia;
	}

	public double getDienTich() {
		return dienTich;
	}

	public abstract double thanhTien();

	@Override
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd//MM/yyyy");
		return String.format("Ma: %s | Ngay: %s |  Don gia: %,.0f | Dien tich: %.1f | Thanh tien: %,.0f", maGiaoDich,
				ngayGiaoDich.format(fmt), donGia, dienTich, thanhTien());
	}
}
