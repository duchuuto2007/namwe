package thuchanh;

//File: QuanLyGiaoDich.java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//==========================================
//(1) LỚP TRỪU TƯỢNG GiaoDich
//==========================================
abstract class GiaoDich {
 protected String maGiaoDich;    
 protected LocalDate ngayGiaoDich;   
 protected double donGia;
 protected double dienTich;

 // Constructor nhận đủ tham số
 public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich,
                 double donGia, double dienTich) {
     this.maGiaoDich = maGiaoDich;
     this.ngayGiaoDich = ngayGiaoDich;
     this.donGia = donGia;
     this.dienTich = dienTich;
 }

 // Phương thức trừu tượng – lớp con bắt buộc override
 public abstract double thanhTien();

 // Getter cần thiết để truy xuất từ bên ngoài
 public String getMaGiaoDich() { return maGiaoDich; }
 public LocalDate getNgayGiaoDich() { return ngayGiaoDich; }

 // Ghi đè toString() để in ra dễ đọc
 @Override
 public String toString() {
     return String.format(
         "Mã: %-6s | Ngày: %s | Đơn giá: %,.0f | DT: %.1f | Thành tiền: %,.0f",
         maGiaoDich,
         ngayGiaoDich.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
         donGia, dienTich, thanhTien());
 }
}

//==========================================
//(2) LỚP GiaoDichDat kế thừa GiaoDich
//==========================================
class GiaoDichDat extends GiaoDich {
 private String loaiDat; // "A", "B", "C"

 public GiaoDichDat(String ma, LocalDate ngay, double donGia,
                    double dienTich, String loaiDat) {
     super(ma, ngay, donGia, dienTich);
     this.loaiDat = loaiDat;
 }

 // OVERRIDE: tính thành tiền theo loại đất
 @Override
 public double thanhTien() {
     if (loaiDat.equalsIgnoreCase("A")) {
         return dienTich * donGia * 1.5;
     }
     // Loại B và C: công thức thường
     return dienTich * donGia;
 }

 @Override
 public String toString() {
     return "[ĐẤT] " + super.toString() + " | Loại: " + loaiDat;
 }
}

//==========================================
//(3) LỚP GiaoDichNha kế thừa GiaoDich
//==========================================
class GiaoDichNha extends GiaoDich {
 private String loaiNha; // "cao cấp", "thường"
 private String diachi;

 public GiaoDichNha(String ma, LocalDate ngay, double donGia,
                    double dienTich, String loaiNha, String diachi) {
     super(ma, ngay, donGia, dienTich);
     this.loaiNha = loaiNha;
     this.diachi = diachi;
 }

 @Override
 public double thanhTien() {
     if (loaiNha.equalsIgnoreCase("cao cấp")) {
         return dienTich * donGia;
     }
     // Loại thường: giảm còn 90%
     return dienTich * donGia * 0.9;
 }

 @Override
 public String toString() {
     return "[NHÀ] " + super.toString()
             + " | Loại: " + loaiNha + " | ĐC: " + diachi;
 }
}

//==========================================
//(4) HÀM MAIN – Chạy chương trình
//==========================================
public class QuanLyGiaoDich {
 public static void main(String[] args) {

     // ----- TẠO DANH SÁCH ĐA HÌNH -----
     // Kiểu List<GiaoDich> có thể chứa cả GiaoDichDat lẫn GiaoDichNha
     List<GiaoDich> danhSach = new ArrayList<>();

     // Thêm 3 giao dịch đất
     danhSach.add(new GiaoDichDat("GDD01", LocalDate.of(2013, 9, 15),
                                  10_000_000, 100, "A"));
     danhSach.add(new GiaoDichDat("GDD02", LocalDate.of(2013, 10, 20),
                                  8_000_000, 200, "B"));
     danhSach.add(new GiaoDichDat("GDD03", LocalDate.of(2014, 1, 10),
                                  12_000_000, 150, "C"));

     // Thêm 3 giao dịch nhà
     danhSach.add(new GiaoDichNha("GDN01", LocalDate.of(2013, 9, 25),
                                  15_000_000, 80, "cao cấp", "Quận 1"));
     danhSach.add(new GiaoDichNha("GDN02", LocalDate.of(2013, 8, 5),
                                  10_000_000, 120, "thường", "Quận 3"));
     danhSach.add(new GiaoDichNha("GDN03", LocalDate.of(2014, 2, 14),
                                  20_000_000, 60, "cao cấp", "Quận 7"));

     // ==========================================
     // CÂU a: ĐẾM SỐ LƯỢNG TỪNG LOẠI
     // Dùng instanceof để kiểm tra kiểu thực tế của từng phần tử
     // ==========================================
     int soLuongDat = 0, soLuongNha = 0;
     for (GiaoDich gd : danhSach) {
         if (gd instanceof GiaoDichDat) {
             soLuongDat++;
         } else if (gd instanceof GiaoDichNha) {
             soLuongNha++;
         }
     }
     System.out.println("Số giao dịch đất: " + soLuongDat);
     System.out.println("Số giao dịch nhà: " + soLuongNha);

     // ==========================================
     // CÂU b: TRUNG BÌNH THÀNH TIỀN GIAO DỊCH ĐẤT
     // ==========================================
     double tongTienDat = 0;
     for (GiaoDich gd : danhSach) {
         if (gd instanceof GiaoDichDat) {
             // Gọi thanhTien() -> đa hình chạy đúng công thức của GiaoDichDat
             tongTienDat += gd.thanhTien();
         }
     }
     double trungBinh = (soLuongDat > 0) ? tongTienDat / soLuongDat : 0;
     System.out.printf("Trung bình thành tiền đất: %,.0fn", trungBinh);

     // ==========================================
     // CÂU c: XUẤT GIAO DỊCH THÁNG 9 NĂM 2013
     // ==========================================
     System.out.println("\n=== Giao dịch tháng 9/2013 ===");
     for (GiaoDich gd : danhSach) {
         if (gd.getNgayGiaoDich().getMonthValue() == 9
                 && gd.getNgayGiaoDich().getYear() == 2013) {
             System.out.println(gd); // gọi toString()
         }
     }
 }
}