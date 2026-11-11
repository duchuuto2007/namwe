package tuan1_huuduc;

public class HinhTron {
	private double banKinh;
	private ToaDo tam;

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	public ToaDo getTam() {
		return tam;
	}

	public void setTam(ToaDo tam) {
		this.tam = tam;
	}

	// Constructor
	public HinhTron(double banKinh, ToaDo tam) {
		this.banKinh = banKinh;
		this.tam = tam;
	}

	// Tinh chu vi
	public double getChuVi() {
		return 2 * Math.PI * banKinh;
	}

	// Tinh dien tich
	public double getDienTich() {
		return Math.PI * banKinh * banKinh;
	}

	public static void main(String[] args) {

		ToaDo td = new ToaDo(2, 3);

		HinhTron ht = new HinhTron(5, td);

		System.out.println("Toa do tam:");
		System.out.println("x = " + ht.getTam().getX());
		System.out.println("y = " + ht.getTam().getY());

		System.out.println("Ban kinh: " + ht.getBanKinh());
		System.out.println("Chu vi: " + ht.getChuVi());
		System.out.println("Dien tich: " + ht.getDienTich());
	}
}
