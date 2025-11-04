
import java.util.Scanner;
class ctkhtour{
    private String makhtour;
    private String ngaychi;
    private String tienan;
    private String tieno;
    public ctkhtour(){
    }
    public ctkhtour(kehoachtour kht,String makhtour, String ngaychi, String tienan, String tieno) {
        this.makhtour = kht.getMakhtour();
        this.ngaychi = ngaychi;
        this.tienan = tienan;
        this.tieno = tieno;
    }
    public ctkhtour(ctkhtour ct){
        this.makhtour = ct.makhtour;
        this.ngaychi = ct.ngaychi;
        this.tienan = ct.tienan;
        this.tieno = ct.tieno;
    }
    public String getMakhtour() {
        return makhtour;
    }
    public String getNgaychi() {
        return ngaychi;
    }
    public void setNgaychi(String ngaychi) {
        this.ngaychi = ngaychi;
    }
    public String getTienan() {
        return tienan;
    }
    public void setTienan(String tienan) {
        this.tienan = tienan;
    }
    public String getTieno() {
        return tieno;
    }
    public void setTieno(String tieno) {
        this.tieno = tieno;
    }
    public void setMakhtour(String makhtour) {
        this.makhtour = makhtour;
    }
    Scanner sc = new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap ma ke hoach tour: ");
        makhtour = sc.nextLine();
        System.out.println("Nhap ngay chi: ");
        ngaychi = sc.nextLine();
        System.out.println("Nhap tien an: ");
        tienan = sc.nextLine();
        System.out.println("Nhap tien o: ");
        tieno = sc.nextLine();
    }
    public void xuat(){
        System.out.printf("%-15s %-15s %-15s %-15s\n",makhtour,ngaychi,tienan,tieno);
    }
}