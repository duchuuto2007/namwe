package dataCD_25644801_huuduc;

public class CD {

    private int maCD;
    private String tuaCD;
    private int soBaiHat;
    private double giaThanh;

   
    public static final int MA_CD_MAC_DINH = 999999;
    public static final String TUA_CD_MAC_DINH = "chua xac dinh";


    public CD() {
        this.maCD = MA_CD_MAC_DINH;
        this.tuaCD = TUA_CD_MAC_DINH;
        this.soBaiHat = 1;
        this.giaThanh = 1.0;
    }

    public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
        setMaCD(maCD);
        setTuaCD(tuaCD);
        setSoBaiHat(soBaiHat);
        setGiaThanh(giaThanh);
    }

    public int getMaCD() { return maCD; }
    public String getTuaCD() { return tuaCD; }
    public int getSoBaiHat() { return soBaiHat; }
    public double getGiaThanh() { return giaThanh; }

    public void setMaCD(int maCD) {
        if (maCD <= 0)
            throw new IllegalArgumentException("Lỗi: Mã CD phải > 0!");
        this.maCD = maCD;
    }

    public void setTuaCD(String tuaCD) {
        if (tuaCD == null || tuaCD.trim().isEmpty())
            throw new IllegalArgumentException("Lỗi: Tựa CD không được rỗng!");
        this.tuaCD = tuaCD;
    }

    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat <= 0)
            throw new IllegalArgumentException("Lỗi: Số bài hát phải > 0!");
        this.soBaiHat = soBaiHat;
    }

    public void setGiaThanh(double giaThanh) { //
        if (giaThanh <= 0)
            throw new IllegalArgumentException("Lỗi: Giá thành phải > 0!");
        this.giaThanh = giaThanh;
    }

    @Override
    public String toString() {
        return String.format(
            "| %-10d | %-25s | %-12d | %-15.2f |",
            maCD, tuaCD, soBaiHat, giaThanh);
    }
}
