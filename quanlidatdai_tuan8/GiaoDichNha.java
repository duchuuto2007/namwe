package quanlidatdai_tuan8;

import java.time.LocalDate;

public class GiaoDichNha extends GiaoDich {
	private String loaiNha;
	private String diaChi;

	/**
	 * 
	 */
	public GiaoDichNha() {

	}

	/**
	 * @param loaiNha
	 * @param diaChi
	 */
	public GiaoDichNha(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, String loaiNha,
			String diaChi) {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
		setLoaiNha(loaiNha);
		setDiaChi(diaChi);
	}

//		-------------------------------------
	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		if (diaChi == null || diaChi.trim().isEmpty()) {
			throw new IllegalArgumentException("Dia chi khong duoc phep trong!!!");
		}
		this.diaChi = diaChi.trim();
	}

	/**
	 * @param loaiNha the loaiNha to set
	 */
	public void setLoaiNha(String loaiNha) {
		if (loaiNha == null || !(loaiNha.equalsIgnoreCase("cao cap") || loaiNha.equalsIgnoreCase("binh thuong"))) {
			throw new IllegalArgumentException("Loai nha chi duoc Cao Cap hoac Binh Thuong");
		}
		this.loaiNha = loaiNha.toLowerCase();
	}

	// ----------------------------------------
	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}

	/**
	 * @return the loaiNha
	 */
	public String getLoaiNha() {
		return loaiNha;
	}

	@Override
	public double thanhTien() {
		if ("cao cap".equalsIgnoreCase(loaiNha)) {
			return getDienTich() * getDonGia();
		}
		return getDienTich() * getDonGia() * 0.9;
	}

	@Override
	public String toString() {
		return "[Nha] " + super.toString() + "| Loai Nha: " + loaiNha + "| Dia Chi: " + diaChi;
	}

}
