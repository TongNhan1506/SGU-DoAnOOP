
import java.util.Scanner;

class hoadon {
    private String mahoadon;
    private String makh;
    private String makhtour;
    private int tongtien;
    private Scanner sc = new Scanner(System.in);

    public hoadon() {
    }

    public hoadon(String mahoadon, kehoachtour kht, String mahd, String makh, String makhtour, int tongtien, khachhang hdkh) {
        this.mahoadon = mahoadon;
        this.makh = hdkh.getMakh();
        this.makhtour = kht.getMakhtour();
        this.tongtien = tongtien;
    }

    public hoadon(hoadon hd) {
        this.mahoadon = hd.mahoadon;
        this.makh = hd.makh;
        this.makhtour = hd.makhtour;
        this.tongtien = hd.tongtien;
    }

    public String getMahd() {
        return mahoadon;
    }

    public String getMakh() {
        return makh;
    }

    public String getMakhtour() {
        return makhtour;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setMahd(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public void setMakhtour(String makhtour) {
        this.makhtour = makhtour;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public void nhap() {
        System.out.println("Nhap ma hoa don: ");
        mahoadon = sc.nextLine();
        System.out.println("Nhap ma khach hang: ");
        makh = sc.nextLine();
        System.out.println("Nhap ma ke hoach tour: ");
        makhtour = sc.nextLine();
        System.out.println("Nhap tong tien: ");
        tongtien = sc.nextInt();
        sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-15s %-15s %-15s %-15d\n", mahoadon, makh, makhtour, tongtien);
    }
}