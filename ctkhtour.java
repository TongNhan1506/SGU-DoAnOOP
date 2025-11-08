import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

class ctkhtour{
    private String mact;
    private String makhtour;
    private LocalDate ngaychi;
    private int tienan;
    private int tieno;
    private int tiendilai;
    private Scanner sc = new Scanner(System.in);
    public ctkhtour(){
    }
    
    public ctkhtour(kehoachtour kht, String mact, LocalDate ngaychi, int tienan, int tieno, int tiendilai) {
        this.mact = mact;
        this.makhtour = kht.getMakhtour();
        this.ngaychi = ngaychi; 
        this.tienan = tienan;
        this.tieno = tieno;
        this.tiendilai = tiendilai;
    }
    
    public ctkhtour(String mact,String makhtour,LocalDate ngaychi,int tienan,int tieno, int tiendilai){
        this.mact=mact;
        this.makhtour=makhtour;
        this.ngaychi=ngaychi;
        this.tienan=tienan;
        this.tieno=tieno;
        this.tiendilai = tiendilai;
    }
    
    public ctkhtour(ctkhtour ct){
        this.mact=ct.mact;
        this.makhtour = ct.makhtour;
        this.ngaychi = ct.ngaychi; 
        this.tienan = ct.tienan;
        this.tieno = ct.tieno;
        this.tiendilai = ct.tiendilai;
    }
    
    public String getMact(){ return mact; }
    public String getMakhtour() { return makhtour; }
    public LocalDate getNgaychi() { return ngaychi; }
    public int getTienan() { return tienan; }
    public int getTieno() { return tieno; }
    public int getTiendilai() { return tiendilai; }
    public int getTongtienchi1ngay(){return tienan+tieno+tiendilai;}
    
    public void setNgaychi(LocalDate ngaychi) { this.ngaychi = ngaychi; }
    public void setTienan(int tienan) { this.tienan = tienan; }
    public void setTieno(int tieno) { this.tieno = tieno; }
    public void setTiendilai(int tiendilai) { this.tiendilai = tiendilai; }
    public void setMakhtour(String makhtour) { this.makhtour = makhtour; }
    
    
    private int nhapSoNguyen(String message) {
        while(true){
            System.out.println(message);
            try {
                int num = Integer.parseInt(sc.nextLine());
                 if(num < 0){
                    System.out.println("Phai nhap gia tri lon hon 0, vui long nhap lai.");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le.");
            }
        }
    }
    
    public void nhap(){
        String ct="^CT[0-9]$";
        while(true)
        {
        System.out.println("Nhap ma chi tiet ke hoach tour ");
        mact = sc.nextLine();
        if(mact.matches(ct)){break;}
        }

        while(true){
        System.out.println("Nhap ma ke hoach tour: ");
        makhtour = sc.nextLine();
        if(makhtour.matches(ct)){break;}
        }

        while(true) {
            System.out.println("Nhap ngay chi (dd/MM/yyyy): ");
            try {
                ngaychi = LocalDate.parse(sc.nextLine(), kehoachtour.df);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Loi dinh dang ngay. Vui long nhap lai.");
            }
        }
        
        tienan = nhapSoNguyen("Nhap tien an: ");
        tieno = nhapSoNguyen("Nhap tien o: ");
        tiendilai = nhapSoNguyen("Nhap tien di lai: ");
    }
    
    public void xuat(){
        System.out.printf("%-15s %-15s %-15s %-15d %-15d %-15d\n",
            mact,
            makhtour,
            ngaychi.format(kehoachtour.df),
            tienan,
            tieno,
            tiendilai);
    }
}