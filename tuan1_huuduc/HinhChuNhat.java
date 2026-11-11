package tuan1_huuduc;

public class HinhChuNhat {
	// Khai bao thuoc tinh
	private double chieuDai;
	private double chieuRong;

	// Getter chieuDai
	public double getChieuDai() {
		return chieuDai;
	}

	// Setter chieuDai
	public void setChieuDai(double cD) {
		if (cD > 0) {
			this.chieuDai = cD;
		} else {
			throw new IllegalArgumentException("Chieu dai phai > 0");
		}
	}

	// Getter chieuRong
	public double getChieuRong() {
		return chieuRong;
	}

	// Setter chieuRong
	public void setChieuRong(double cR) {
		if (cR > 0) {
			this.chieuRong = cR;
		} else {
			throw new IllegalArgumentException("Chieu rong phai > 0");
		}
	}

	// Ham khoi tao doi tuong
	public HinhChuNhat(double chieuDai, double chieuRong) {
		setChieuDai(chieuDai);
		setChieuRong(chieuRong);
	}

	// Phuong thuc tinh dien tich
	public double getDT() {
		return this.chieuDai * this.chieuRong;
	}

	// Phuong thuc tinh chu vi
	public double getCV() {
		return (this.chieuDai + this.chieuRong) * 2;
	}

	// Ham main de chay chuong trinh
	public static void main(String[] args) {

		// Tao doi tuong hinh chu nhat
		HinhChuNhat h1 = new HinhChuNhat(7, 5);

		// Xem gia tri chieu dai va chieu rong
		System.out.println("Chieu dai: " + h1.getChieuDai());
		System.out.println("Chieu rong: " + h1.getChieuRong());

		// Tinh chu vi
		System.out.println("Chu vi hinh chu nhat: " + h1.getCV());

		// Tinh dien tich
		System.out.println("Dien tich hinh chu nhat: " + h1.getDT());
	}
}
