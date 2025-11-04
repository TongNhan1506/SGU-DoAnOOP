import java.util.Scanner;
class cthd{
    private String mahd;
    private String makh;
    private String makhtour;
    public cthd(){
    }
    public cthd(hopdong h,khachhang kh,kehoachtour kht,String mahd, String makh, String makhtour) {
        this.mahd = h.getMahd();
        this.makh = kh.getMakh();
        this.makhtour = kht.getMakhtour();
    }
    public cthd(cthd ct){
        this.mahd = ct.mahd;
        this.makh = ct.makh;
        this.makhtour = ct.makhtour;
    }
    public String getMahd() {
        return mahd;
    }
    public String getMakh() {
        return makh;
    }
    public String getMakhtour() {
        return makhtour;
    }
    public void setMahd(String mahd) {
        this.mahd = mahd;
    }
    public void setMakh(String makh) {
        this.makh = makh;
    }
    public void setMakhtour(String makhtour) {
        this.makhtour = makhtour;
    }
    Scanner sc = new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap ma hop dong: ");
        mahd = sc.nextLine();
        System.out.println("Nhap ma khach hang: ");
        makh = sc.nextLine();
        System.out.println("Nhap ma ke hoach tour: ");
        makhtour = sc.nextLine();
    }
    public void xuat(){
        System.out.printf("%-15s %-15s %-15s\n",mahd,makh,makhtour);
    }
}