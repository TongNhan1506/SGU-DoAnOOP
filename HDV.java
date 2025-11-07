import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Scanner;

class HDV {
    private String mahdv;
    private String makhtour;
    private String ho;
    private String ten;
    private LocalDate ngaysinh;
    private String gioitinh;
    private String diachi;
    private String sdt;
    private Scanner sc = new Scanner(System.in);

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public HDV() {
    }

    public HDV(kehoachtour khtour, String mahdv, String makhtour, String ho, String ten, 
            LocalDate ngaysinh, String gioitinh, String diachi, String sdt) {
        this.mahdv = mahdv;
        this.makhtour = khtour.getMakhtour();
        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
    }
    public HDV(String mahdv,String makhtour,String ho,String ten,LocalDate ngaysinh,String gioitinh,String diachi,String sdt){
        this.mahdv=mahdv;
        this.makhtour=makhtour;
        this.ho=ho;
        this.ten=ten;
        this.ngaysinh=ngaysinh;
        this.gioitinh=gioitinh;
        this.diachi=diachi;
        this.sdt=sdt;
    }
    public HDV(HDV h) {
        this.mahdv = h.mahdv;
        this.makhtour = h.makhtour;
        this.ho = h.ho;
        this.ten = h.ten;
        this.ngaysinh = h.ngaysinh;
        this.gioitinh = h.gioitinh;
        this.diachi = h.diachi;
        this.sdt = h.sdt;
    }

    public String getMahdv() {
        return mahdv;
    }

    public String getMakhtour() {
        return makhtour;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setMahdv(String mahdv) {
        this.mahdv = mahdv;
    }

    public void setMakhtour(String makhtour) {
        this.makhtour = makhtour;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void nhap() {
        System.out.println("Nhap ma HDV: ");
        mahdv = sc.nextLine();
        System.out.println("Nhap ma ke hoach tour: ");
        makhtour = sc.nextLine();
        System.out.println("Nhap ho: ");
        ho = sc.nextLine();
        System.out.println("Nhap ten: ");
        ten = sc.nextLine();
        System.out.println("Nhap ngay sinh (dd/mm/yyyy): ");
        ngaysinh = LocalDate.parse(sc.nextLine(),dtf);
        System.out.println("Nhap gioi tinh: ");
        gioitinh = sc.nextLine();
        System.out.println("Nhap dia chi: ");
        diachi = sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        sdt = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s %-10s %-10s %-10s %-15s %-10s %-20s %-15s\n",
                mahdv, makhtour, ho, ten, ngaysinh.format(dtf), gioitinh, diachi, sdt);
    }
}
