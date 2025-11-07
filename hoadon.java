
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
class hoadon {
    private String mahoadon;
    private String makh;
    private String makhtour;
    private LocalDate ngaylap;
    private int sove;
    private int tongtien;
    private Scanner sc = new Scanner(System.in);

    public hoadon(){}
    public hoadon(String mahoadon,String makh,String makhtour,LocalDate ngaylap,int sove,int tongtien){
        this.mahoadon=mahoadon;
        this.makh=makh;
        this.makhtour=makhtour;
        this.ngaylap=ngaylap;
        this.sove=sove;
        this.tongtien = tongtien;
    }
    public hoadon(hoadon hd) {
        this.mahoadon = hd.mahoadon;
        this.makh = hd.makh;
        this.makhtour = hd.makhtour;
        this.ngaylap = hd.ngaylap;
        this.tongtien = hd.tongtien;
        this.sove = hd.sove;
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
    
    public LocalDate getNgaylap() {
        return ngaylap;
    }

    public int getTongtien() {
        return tongtien;
    }
    public int getSove(){
        return sove;
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

    public void setNgaylap(LocalDate ngaylap) {
        this.ngaylap = ngaylap;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public void setSove(int sove) {
        this.sove = sove;
    }


    public void nhap() {
        System.out.println("Nhap ma hoa don: ");
        mahoadon = sc.nextLine();
        System.out.println("Nhap ma khach hang: ");
        makh = sc.nextLine();
        System.out.println("Nhap ma ke hoach tour: ");
        makhtour = sc.nextLine();
        System.out.println("Nhap ngay lap (dd/MM/yyyy): ");
        String dateInput = sc.nextLine();
        try {
            ngaylap=LocalDate.parse(dateInput,kehoachtour.df);
        }
        catch(DateTimeParseException e){    
            System.out.println("Loi dinh dang ngay khong dung "+e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Nhap so ve: ");
        sove = sc.nextInt();
        System.out.println("Nhap tong tien: ");
        tongtien = sc.nextInt();
        sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s %-10s %-10s %-10s %-10d %-15d\n", mahoadon, makh, makhtour, ngaylap, sove, tongtien);
    }
}