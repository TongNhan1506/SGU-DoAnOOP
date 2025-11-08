
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
    private String diadiemden;
    protected Scanner sc = new Scanner(System.in);

    public tour() {
    }

    public tour(String matour, String tentour, int dongia, String thutuc, String diadiemKH,String diadiemden) {
        this.matour = matour;
        this.tentour = tentour;
        this.dongia = dongia;
        this.thutuc = thutuc;
        this.diadiemKH = diadiemKH;
        this.diadiemden=diadiemden;
    }

    public tour(tour t) {
        this.matour = t.matour;
        this.tentour = t.tentour;
        this.dongia = t.dongia;
        this.thutuc = t.thutuc;
        this.diadiemKH = t.diadiemKH;
        this.diadiemden=t.diadiemden;
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
    public String getDiadiemden(){
        return diadiemden;
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
    public void setDiadiemden(String diadiemden){
        this.diadiemden=diadiemden;
    }
    public void nhap() {
        final String t="^T[0-9]{3}$";
        while(true){
            System.out.println("Nhap ma tour (co dinh dang TXXX, VD: T000)");
            matour=sc.nextLine();
            if(matour.matches(t)){break;}
            System.out.println("Loi dinh dang, vui long nhap lai.");
        }
        System.out.println("Nhap ten tour: ");
        tentour = sc.nextLine();
        while(true){
            System.out.println("Nhap don gia: ");
            String gia=sc.nextLine();
            try{
                dongia=Integer.parseInt(gia);
                if(dongia<0){
                    System.out.println("Don gia phai lon hon 0, vui long nhap lai.");
                    continue;
                }
                break;
            }catch(NumberFormatException e){
                System.out.println("Loi don gia ko phai so nguyen.");
            }
        }
        System.out.println("Nhap thu tuc: ");
        thutuc = sc.nextLine();
        System.out.println("Nhap dia diem KH: ");
        diadiemKH = sc.nextLine();
        System.out.println("Nhap dia diem den ");
        diadiemden=sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-10s",
                matour, tentour, dongia, thutuc, diadiemKH,diadiemden);
    }
}

