
import java.util.Scanner;
class hopdong{
    private String mahd;
    private String matour;
    private String makh;
    private String dieukhoan;
    public hopdong(){
    }
    public hopdong(khachhang kh,tour t,String mahd, String matour, String makh, String dieukhoan) {
        this.mahd = mahd;
        this.matour = t.getMatour();
        this.makh = kh.getMakh();
        this.dieukhoan = dieukhoan;
    }
    public hopdong(String mahd,String matour,String makh,String dieukhoan){
        this.mahd=mahd;
        this.matour=matour;
        this.makh=makh;
        this.dieukhoan=dieukhoan;
    }
    public hopdong(hopdong h){
        this.mahd = h.mahd;
        this.matour = h.matour;
        this.makh = h.makh;
        this.dieukhoan = h.dieukhoan;
    }
    public String getMahd() {
        return mahd;
    }
    public String getMatour() {
        return matour;
    }
    public String getMakh() {
        return makh;
    }
    public String getDieukhoan() {
        return dieukhoan;
    }
    public void setMahd(String mahd) {
        this.mahd = mahd;
    }
    public void setMatour(String matour) {
        this.matour = matour;
    }
    public void setMakh(String makh) {
        this.makh = makh;
    }
    public void setDieukhoan(String dieukhoan) {
        this.dieukhoan = dieukhoan;
    }
    Scanner sc = new Scanner(System.in);
    public void nhap(){
         System.out.println("Nhap ma hop dong: ");
        mahd = sc.nextLine();
        System.out.println("Nhap ma tour: ");
        matour = sc.nextLine();
        System.out.println("Nhap ma khach hang: ");
        makh = sc.nextLine();
        System.out.println("Nhap dieu khoan: ");
        dieukhoan = sc.nextLine();
    }
    public void xuat(){
        System.out.printf("%-15s %-15s %-15s %-15s\n", mahd, matour, makh, dieukhoan);
    }
}
