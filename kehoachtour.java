
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class kehoachtour {
    private String makhtour;
    private String matour;
    private LocalDate ngaydi;
    private LocalDate ngayve;
    private int dongia;
    private int tongsove;
    private int soveconlai;
    private int tongchi;
    private int tongan;
    private int tongo;
    private int tongdilai;
    private String mahdv;
    private int tongtienve;
    private Scanner sc = new Scanner(System.in);

    public int getTongTienTheoCacKhoan() {
        return tongchi + tongan + tongo + tongdilai + tongtienve;
    }

    public int getTongTienTheoNgay() {
        return tongchi + tongan + tongo + tongdilai;
    }

    public long getSoNgay() {
        return ChronoUnit.DAYS.between(ngaydi, ngayve) + 1;
    }

    public kehoachtour() {
    }

    public kehoachtour(tour t, String makhtour, LocalDate ngaydi, LocalDate ngayve, int dongia, int tongsove,
            int soveconlai, int tongchi, int tongan, int tongo, int tongdilai, String mahdv, int tongtienve) {
        this.makhtour = makhtour;
        this.matour = t.getMatour();
        this.ngaydi = ngaydi;
        this.ngayve = ngayve;
        this.dongia = dongia;
        this.tongsove = tongsove;
        this.soveconlai = soveconlai;
        this.tongchi = tongchi;
        this.tongan = tongan;
        this.tongo = tongo;
        this.tongdilai = tongdilai;
        this.mahdv = mahdv;
        this.tongtienve = tongtienve;
    }

    public kehoachtour(kehoachtour kht) {
        this.makhtour = kht.makhtour;
        this.matour = kht.matour;
        this.ngaydi = kht.ngaydi;
        this.ngayve = kht.ngayve;
        this.dongia = kht.dongia;
        this.tongsove = kht.tongsove;
        this.soveconlai = kht.soveconlai;
        this.tongchi = kht.tongchi;
        this.tongan = kht.tongan;
        this.tongo = kht.tongo;
        this.tongdilai = kht.tongdilai;
        this.mahdv = kht.mahdv;
        this.tongtienve = kht.tongtienve;
    }

    public int tinhTongChiPhi() {
        return tongan + tongo + tongdilai + tongchi + tongtienve;
    }

    public String getMakhtour() {
        return makhtour;
    }

    public String getMatour() {
        return matour;
    }

    public LocalDate getNgaydi() {
        return ngaydi;
    }

    public LocalDate getNgayve() {
        return ngayve;
    }

    public int getDongia() {
        return dongia;
    }

    public int getTongsove() {
        return tongsove;
    }

    public int getSoveconlai() {
        return soveconlai;
    }

    public int getTongchi() {
        return tongchi;
    }

    public int getTongan() {
        return tongan;
    }

    public int getTongo() {
        return tongo;
    }

    public int getTongdilai() {
        return tongdilai;
    }

    public String getMahdv() {
        return mahdv;
    }

    public int getTongtienve() {
        return tongtienve;
    }

    public void setMakhtour(String makhtour) {
        this.makhtour = makhtour;
    }

    public void setMatour(String matour) {
        this.matour = matour;
    }

    public void setNgaydi(LocalDate ngaydi) {
        this.ngaydi = ngaydi;
    }

    public void setNgayve(LocalDate ngayve) {
        this.ngayve = ngayve;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public void setTongsove(int tongsove) {
        this.tongsove = tongsove;
    }

    public void setSoveconlai(int soveconlai) {
        this.soveconlai = soveconlai;
    }

    public void setTongchi(int tongchi) {
        this.tongchi = tongchi;
    }

    public void setTongan(int tongan) {
        this.tongan = tongan;
    }

    public void setTongo(int tongo) {
        this.tongo = tongo;
    }

    public void setTongdilai(int tongdilai) {
        this.tongdilai = tongdilai;
    }

    public void setMahdv(String mahdv) {
        this.mahdv = mahdv;
    }

    public void setTongtienve(int tongtienve) {
        this.tongtienve = tongtienve;
    }

    public void nhap() {
        System.out.println("Nhap ma ke hoach tour: ");
        makhtour = sc.nextLine();
        System.out.println("Nhap ma tour: ");
        matour = sc.nextLine();
        System.out.println("Nhap ngay di (yyyy-mm-dd): ");
        ngaydi = LocalDate.parse(sc.nextLine());
        System.out.println("Nhap ngay ve (yyyy-mm-dd): ");
        ngayve = LocalDate.parse(sc.nextLine());
        System.out.println("Nhap don gia: ");
        dongia = sc.nextInt();
        System.out.println("Nhap tong so ve: ");
        tongsove = sc.nextInt();
        System.out.println("Nhap so ve con lai: ");
        soveconlai = sc.nextInt();
        System.out.println("Nhap tong chi 1 ngay: ");
        tongchi = sc.nextInt();
        System.out.println("Nhap tong an 1 ngay: ");
        tongan = sc.nextInt();
        System.out.println("Nhap tong o 1 ngay: ");
        tongo = sc.nextInt();
        System.out.println("Nhap tong di lai 1 ngay: ");
        tongdilai = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ma HDV: ");
        mahdv = sc.nextLine();
        System.out.println("Nhap tong tien ve: ");
        tongtienve = sc.nextInt();
        sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-15s %-10s %-12s %-12s %-10d %-10d %-10d %-10d %-10d %-10d %-10d %-10s %-10d\n",
                makhtour, matour, ngaydi, ngayve, dongia, tongsove, soveconlai, tongchi, tongan, tongo,
                tongdilai, mahdv, tongtienve);
    }
    

    public void thongKeTienTheoNgay() {
        long songay = getSoNgay();
        int tongTienMotNgay = getTongTienTheoNgay();
        long tongTienToanTour = tongTienMotNgay * songay;
        int tongTienCacKhoan = getTongTienTheoCacKhoan();

        System.out.println("\n==== THONG KE TONG TIEN SU DUNG THEO NGAY ====");
        System.out.println("Ma ke hoach tour: " + makhtour);
        System.out.println("So ngay tour: " + songay);
        System.out.println("\nChi phi hang ngay:");
        System.out.println("- Chi phi an: " + tongan);
        System.out.println("- Chi phi o: " + tongo);
        System.out.println("- Chi phi di lai: " + tongdilai);
        System.out.println("- Chi phi khac: " + tongchi);
        System.out.println("=> Tong chi phi 1 ngay: " + tongTienMotNgay);
        System.out.println("\nTong chi phi:");
        System.out.println("- Chi phi cho toan tour: " + tongTienToanTour);
        System.out.println("- Tong tien ve: " + tongtienve);
        System.out.println("=> Tong chi phi toan bo: " + tongTienCacKhoan);
    }
}