
import java.time.LocalDate;
import java.util.Scanner;
class ctkhtour{
    private String mact;
    private String makhtour;
    private LocalDate ngaychi;
    private int tienan;
    private int tieno;
    public ctkhtour(){
    }
    public ctkhtour(kehoachtour kht,String mact,String makhtour, LocalDate ngaychi, int tienan, int tieno) {
        this.mact=mact;
        this.makhtour = kht.getMakhtour();
        this.ngaychi = ngaychi;
        this.tienan = tienan;
        this.tieno = tieno;
    }
    public ctkhtour(String mact,String makhtour,LocalDate ngaychi,int tienan,int tieno){
        this.mact=mact;
        this.makhtour=makhtour;
        this.ngaychi=ngaychi;
        this.tienan=tienan;
        this.tieno=tieno;
    }
    public ctkhtour(ctkhtour ct){
        this.mact=ct.mact;
        this.makhtour = ct.makhtour;
        this.ngaychi = ct.ngaychi;
        this.tienan = ct.tienan;
        this.tieno = ct.tieno;
    }
    public String getMact(){
        return mact;
    }
    public String getMakhtour() {
        return makhtour;
    }
    public LocalDate getNgaychi() {
        return ngaychi;
    }
    public void setNgaychi(LocalDate ngaychi) {
        this.ngaychi = ngaychi;
    }
    public int getTienan() {
        return tienan;
    }
    public void setTienan(int tienan) {
        this.tienan = tienan;
    }
    public int getTieno() {
        return tieno;
    }
    public void setTieno(int tieno) {
        this.tieno = tieno;
    }
    public void setMakhtour(String makhtour) {
        this.makhtour = makhtour;
    }
    Scanner sc = new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap ma chi tiet ke hoach tour ");
        mact = sc.nextLine();
        System.out.println("Nhap ma ke hoach tour: ");
        makhtour = sc.nextLine();
        System.out.println("Nhap ngay chi: ");
        ngaychi =LocalDate.parse( sc.nextLine());
        System.out.println("Nhap tien an: ");
        tienan = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap tien o: ");
        tieno = Integer.parseInt(sc.nextLine());
    }
    public void xuat(){
        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n",mact,makhtour,ngaychi,tienan,tieno);
    }
}