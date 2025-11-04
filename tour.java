
import java.util.Scanner;

interface ITour {
    void nhap();
    void xuat();
}

abstract class tour implements ITour {
    private String matour;
    private String tentour;
    private int dongia;
    private String thutuc;
    private String diadiemKH;
    protected Scanner sc = new Scanner(System.in);

    public tour() {
    }

    public tour(String matour, String tentour, int dongia, String thutuc, String diadiemKH) {
        this.matour = matour;
        this.tentour = tentour;
        this.dongia = dongia;
        this.thutuc = thutuc;
        this.diadiemKH = diadiemKH;
    }

    public tour(tour t) {
        this.matour = t.matour;
        this.tentour = t.tentour;
        this.dongia = t.dongia;
        this.thutuc = t.thutuc;
        this.diadiemKH = t.diadiemKH;
    }

    public String getMatour() {
        return matour;
    }

    public String getTentour() {
        return tentour;
    }

    public int getDongia() {
        return dongia;
    }

    public String getThutuc() {
        return thutuc;
    }

    public String getDiadiemKH() {
        return diadiemKH;
    }

    public void setMatour(String matour) {
        this.matour = matour;
    }

    public void setTentour(String tentour) {
        this.tentour = tentour;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public void setThutuc(String thutuc) {
        this.thutuc = thutuc;
    }

    public void setDiadiemKH(String diadiemKH) {
        this.diadiemKH = diadiemKH;
    }

    public void nhap() {
        System.out.println("Nhap ma tour: ");
        matour = sc.nextLine();
        System.out.println("Nhap ten tour: ");
        tentour = sc.nextLine();
        System.out.println("Nhap don gia: ");
        dongia = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap thu tuc: ");
        thutuc = sc.nextLine();
        System.out.println("Nhap dia diem KH: ");
        diadiemKH = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s %-10s %-10s %-15s %-10s\n",
                matour, tentour, dongia, thutuc, diadiemKH);
    }
}

class tournuocngoai extends tour {
    private String quocgia;
    private String ngoaite;

    public tournuocngoai() {
    }

    public tournuocngoai(tour t, String quocgia, String ngoaite) {
        super(t);
        this.quocgia = quocgia;
        this.ngoaite = ngoaite;
    }

    public tournuocngoai(tournuocngoai tnnn) {
        super(tnnn);
        this.quocgia = tnnn.quocgia;
        this.ngoaite = tnnn.ngoaite;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public String getNgoaite() {
        return ngoaite;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }

    public void setNgoaite(String ngoaite) {
        this.ngoaite = ngoaite;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.println("Nhap quoc gia: ");
        quocgia = sc.nextLine();
        System.out.println("Nhap ngoai te: ");
        ngoaite = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-15s %-15s\n", quocgia, ngoaite);
    }
}

class tourtrongnuoc extends tour {
    private String tinhthanh;
    private String dacsan;

    public tourtrongnuoc() {
    }

    public tourtrongnuoc(tour t, String tinhthanh, String dacsan) {
        super(t);
        this.tinhthanh = tinhthanh;
        this.dacsan = dacsan;
    }

    public tourtrongnuoc(tourtrongnuoc ttnn) {
        super(ttnn);
        this.tinhthanh = ttnn.tinhthanh;
        this.dacsan = ttnn.dacsan;
    }

    public String getTinhthanh() {
        return tinhthanh;
    }

    public String getDacsan() {
        return dacsan;
    }

    public void setTinhthanh(String tinhthanh) {
        this.tinhthanh = tinhthanh;
    }

    public void setDacsan(String dacsan) {
        this.dacsan = dacsan;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.println("Nhap tinh thanh: ");
        tinhthanh = sc.nextLine();
        System.out.println("Nhap dac san: ");
        dacsan = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-15s %-15s\n", tinhthanh, dacsan);
    }
}