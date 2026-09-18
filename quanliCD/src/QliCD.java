import dataCD_25644801_huuduc.CD;
import dataCD_25644801_huuduc.CDList;
import java.util.Scanner;

public class QliCD {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CDList ql = new CDList();
        int luaChon = -1;

        do {
            System.out.println("\n_______________ MENU QUẢN LÝ CD _______________");
            System.out.println("||  1. Thêm CD (tự mở rộng mảng khi đầy)   ||");
            System.out.println("||  2. Xóa CD theo mã                      ||");
            System.out.println("||  3. Sửa / Cập nhật CD theo mã           ||");
            System.out.println("||  4. Tìm kiếm theo mã                    ||");
            System.out.println("||  5. Tìm theo tựa - TIỀN TỐ (bên trái)   ||");
            System.out.println("||  6. Tìm theo tựa - HẬU TỐ (bên phải)    ||");
            System.out.println("||  7. Tìm theo tựa - GẦN GIỐNG (chứa)     ||");
            System.out.println("||  8. Hiển thị danh sách                  ||");
            System.out.println("||  9. Thống kê                            ||");
            System.out.println("|| 10. Sắp xếp danh sách                   ||");
            System.out.println("||  0. Thoát                               ||");
            System.out.println("=============================================");
            System.out.print("Nhập lựa chọn của bạn: ");
            
            try {
                luaChon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui lòng nhập vào một số nguyên hợp lệ!");
                continue;
            }

            switch (luaChon) {
                case 1:
                    try {
                        System.out.print("Nhập mã CD: ");
                        int ma = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập tựa CD: ");
                        String tua = sc.nextLine();
                        System.out.print("Nhập số bài hát: ");
                        int soBai = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập giá thành: ");
                        double gia = Double.parseDouble(sc.nextLine());

                        CD cd = new CD(ma, tua, soBai, gia);
                        if (ql.themCD(cd)) {
                            System.out.println("✅ Thêm CD thành công!");
                        }
                    } catch (Exception e) {
                        System.out.println("❌ Lỗi: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Nhập mã CD cần xóa: ");
                    int maXoa = Integer.parseInt(sc.nextLine());
                    if (ql.xoaCD(maXoa)) {
                        System.out.println("✅ Xóa CD thành công!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã CD cần sửa: ");
                    int maSua = Integer.parseInt(sc.nextLine());
                    if (ql.timTheoMa(maSua) == null) {
                        System.out.println("❌ Không tìm thấy CD có mã này!");
                        break;
                    }
                    try {
                        System.out.print("Nhập tựa CD mới: ");
                        String tuaMoi = sc.nextLine();
                        System.out.print("Nhập số bài hát mới: ");
                        int soBaiMoi = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập giá thành mới: ");
                        double giaMoi = Double.parseDouble(sc.nextLine());

                        if (ql.capNhatCD(maSua, tuaMoi, soBaiMoi, giaMoi)) {
                            System.out.println("✅ Cập nhật thành công!");
                        }
                    } catch (Exception e) {
                        System.out.println("❌ Lỗi: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã CD cần tìm: ");
                    int maTim = Integer.parseInt(sc.nextLine());
                    CD kqTim = ql.timTheoMa(maTim);
                    if (kqTim != null) {
                        System.out.println("✅ Đã tìm thấy:");
                        System.out.println(kqTim);
                    } else {
                        System.out.println("❌ Không tìm thấy CD.");
                    }
                    break;

                case 5:
                    System.out.print("Nhập tiền tố tựa CD cần tìm: ");
                    String tienTo = sc.nextLine();
                    CDList kqTT = ql.timTheoTienTo(tienTo);
                    kqTT.hienThiDanhSach();
                    break;

                case 6:
                    System.out.print("Nhập hậu tố tựa CD cần tìm: ");
                    String hauTo = sc.nextLine();
                    CDList kqHT = ql.timTheoHauTo(hauTo);
                    kqHT.hienThiDanhSach();
                    break;

                case 7:
                    System.out.print("Nhập từ khóa gần giống cần tìm: ");
                    String ganGiong = sc.nextLine();
                    CDList kqGG = ql.timGanGiong(ganGiong);
                    kqGG.hienThiDanhSach();
                    break;

                case 8:
                    ql.hienThiDanhSach();
                    break;

                case 9:
                    System.out.println("\n--- THÔNG KÊ ---");
                    System.out.println("Tổng số lượng CD: " + ql.tinhSoLuongCD());
                    System.out.println("Tổng giá thành: " + ql.tinhTongGiaThanh());
                    System.out.println("Giá trung bình: " + ql.tinhGiaTrungBinh());
                    CD datNhat = ql.timCDDatNhat();
                    if (datNhat != null) System.out.println("CD đắt nhất: " + datNhat);
                    CD reNhat = ql.timCDREnhat();
                    if (reNhat != null) System.out.println("CD rẻ nhất: " + reNhat);
                    break;

                case 10:
                    System.out.println("1. Sắp xếp giảm dần theo giá");
                    System.out.println("2. Sắp xếp tăng dần theo tựa");
                    System.out.print("Chọn kiểu sắp xếp: ");
                    int chonSapXep = Integer.parseInt(sc.nextLine());
                    if (chonSapXep == 1) {
                        ql.sapXepGiamDanTheoGia();
                    } else if (chonSapXep == 2) {
                        ql.sapXepTangDanTheoTua();
                    } else {
                        System.out.println("❌ Lựa chọn không hợp lệ!");
                    }
                    break;

                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;

                default:
                    System.out.println("❌ Lựa chọn không hợp lệ, vui lòng chọn từ 0 đến 10!");
            }
        } while (luaChon != 0);
    }
}