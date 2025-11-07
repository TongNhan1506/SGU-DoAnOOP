import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.time.format.DateTimeParseException;
class kehoachtour {
    private String makhtour;
    private String matour;
    private LocalDate ngaydi;
    private LocalDate ngayve;
    private int tongsove;
    public  int soveconlai;
    private int tongchi;
    private int tongan;
    private int tongo;
    private int tongdilai;
    private String mahdv;
    private int tongtienve;
    private tour t;
    public static final DateTimeFormatter df =DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Scanner sc = new Scanner(System.in);

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");


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

    public kehoachtour( String makhtour, LocalDate ngaydi, LocalDate ngayve, int tongsove,
            int soveconlai, int tongchi, int tongan, int tongo, int tongdilai, int tongtienve, String mahdv) {
        this.makhtour = makhtour;
        this.matour = t.getMatour();
        this.ngaydi = ngaydi;
        this.ngayve = ngayve;
        this.tongsove = tongsove;
        this.soveconlai = soveconlai;
        this.tongchi = tongchi;
        this.tongan = tongan;
        this.tongo = tongo;
        this.tongdilai = tongdilai;
        this.tongtienve = tongtienve;
        this.mahdv = mahdv;
    }

    public kehoachtour( String makhtour,String matour, LocalDate ngaydi, LocalDate ngayve, int tongsove,
            int soveconlai, int tongchi, int tongan, int tongo, int tongdilai, int tongtienve,String mahdv) {
        this.makhtour = makhtour;
        this.matour = matour;
        this.ngaydi = ngaydi;
        this.ngayve = ngayve;
        this.tongsove = tongsove;
        this.soveconlai = soveconlai;
        this.tongchi = tongchi;
        this.tongan = tongan;
        this.tongo = tongo;
        this.tongdilai = tongdilai;
        this.tongtienve = tongtienve;
        this.mahdv = mahdv;  
    }
    public kehoachtour(kehoachtour kht) {
        this.makhtour = kht.makhtour;
        this.matour = kht.matour;
        this.ngaydi = kht.ngaydi;
        this.ngayve = kht.ngayve;
        this.tongsove = kht.tongsove;
        this.soveconlai = kht.soveconlai;
        this.tongchi = kht.tongchi;
        this.tongan = kht.tongan;
        this.tongo = kht.tongo;
        this.tongdilai = kht.tongdilai;
        this.tongtienve = kht.tongtienve;
        this.mahdv = kht.mahdv;
        
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
        final String mt="^KHT[0-9]{3}$";
        while(true){
            System.out.println("Nhap ma ke hoach tour (co dinh dang KHTXXX, VD: KHT001)");
            makhtour=sc.nextLine();
            if(makhtour.matches(mt)){break;}
            System.out.println("Loi dinh dang, vui long nhap lai.");
        }
        final String t="^T[0-9]{3}$";
        while(true){
            System.out.println("Nhap ma tour (co dinh dang TXXX, VD: T001)");
            matour=sc.nextLine();
            if(matour.matches(t)){break;}
            System.out.println("Loi dinh dang, vui long nhap lai.");
        }
        while(true){
        System.out.println("Nhap ngay di (dd/MM/yyyy): ");
        String ndi=sc.nextLine();
        try{
            ngaydi=LocalDate.parse(ndi, df);
            break;
        }catch(DateTimeParseException e){
            System.out.println("Loi dinh dang ngay, vui long nhap lai "+e.getMessage());
        }}
        while(true){
        System.out.println("Nhap ngay ve (dd/mm/yyyy): ");
        String nve=sc.nextLine();
        try{
            ngayve=LocalDate.parse(nve,df);
            if(ngayve.isBefore(ngaydi)){
                System.out.println("Ngay ve phai sau hoac bang ngay di, vui long nhap lai.");
                continue;
            }
            break;
        }catch(DateTimeParseException e)
        {
            System.out.println("Loi dinh dang ngay, vui long nhap lai "+e.getMessage());
        }
        }
        tongsove=nhapsonguyen("Nhap tong so ve: ");
        soveconlai = nhapsonguyen("Nhap so ve: ");
        tongchi = nhapsonguyen("Nhap tong chi: ");
        tongan = nhapsonguyen("Nhap tong an: ");
        tongo=nhapsonguyen("Nhap tong o: ");
        tongdilai=nhapsonguyen("Nhap tong di lai: ");
        sc.nextLine();
        System.out.println("Nhap ma HDV: ");
        mahdv = sc.nextLine();
        tongtienve=nhapsonguyen("Nhap tong tien ve: ");
        sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-15s %-10s %-12s %-12s %-10d %-10d %-10d %-10d %-10d %-10d %-10s %-10d\n",
                makhtour, matour, ngaydi.format(dtf), ngayve.format(dtf), tongsove, soveconlai, tongchi, tongan, tongo,
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
    private int nhapsonguyen(String message){
        while(true){
            System.out.println(message);
            String input=sc.nextLine();
            try{
                int num=Integer.parseInt(input);
                if(num < 0){
                    System.out.println("Phai nhap gia tri lon hon 0, vui long nhap lai.");
                    continue;
                }
                return num;
            }catch(NumberFormatException e){
                System.out.println("Dinh dang khong hop le, vui long nhap lai.");
            }
        }
    }
}