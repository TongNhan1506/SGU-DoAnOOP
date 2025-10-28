import java.util.Scanner;
import java.util.Arrays;
 class dscthd{
    private cthd[] ds;
    private int n;
    public dscthd(){
        ds = new cthd[100];
        n=0;
    }
    public dscthd(cthd[] ds,int n){
        this.ds=ds;
        this.n=n;
    }
    public dscthd(dscthd dsct){
        this.ds=dsct.ds;
        this.n=dsct.n;
    }
    public cthd[] getDs() {
        return ds;
    }
    public int getN() {
        return n;
    }
    public void setDs(cthd[] ds) {
        this.ds = ds;
    }
    public void setN(int n) {
        this.n = n;
    }
    Scanner sc = new Scanner(System.in);


    public void nhapDsCTHD(){
        System.out.println("Nhap so luong chi tiet hop dong: ");
        n = Integer.parseInt(sc.nextLine());
        ds=new cthd[n];
        for(int i=0;i<n;i++){
            System.out.println("Nhap thong tin chi tiet hop dong thu "+(i+1)+": ");
            ds[i]=new cthd();
            ds[i].nhap();
        }
        n=ds.length;
    }



    public void xuatDsCTHD(){
        System.out.printf("%-15s %-15s %-15s\n","Ma HD","Ma KH","Ma Ke Hoach Tour");
        for(int i=0;i<n;i++){
            ds[i].xuat();
        }
    }



    public int timtheoma(String mahd){
        for(int i=0;i<n;i++){
            if(ds[i].getMahd().equals(mahd)){
            return i;}
        }
        return -1;
    }



    public cthd timts(String mahd){
        int k=timtheoma(mahd);
        if(k==-1){
        return null;}
        return ds[k];
    }



    public void timkots(){
        System.out.println("nhap ma hoa don de tim");
        String ma=sc.nextLine();
        int ind=timtheoma(ma);
        if(ind==-1){
            System.out.println("khong tim thay "+ma);
            return;
        }
        System.out.printf("%-15s %-10s %-10s\n","mahd","makhachhang","makhtour");
        ds[ind].xuat();
    }




    public void themcthdkots(){
        System.out.println("nhap thong tin chi tiet hoa don can them");
        cthd k=new cthd();
        k.nhap();
        ds=Arrays.copyOf(ds,n+1);
        ds[n]=k;
        n++;
        System.out.println("Da them xong");
    }




    public void themcthdcots(cthd k){
        ds=Arrays.copyOf(ds,n+1);
        ds[n]=new cthd(k);
        n++;
        System.out.println("Da them xong");
    }




    public void xoaCTHDkots() {
    System.out.print("Nhap ma hop dong can xoa: ");
    String mahd = sc.nextLine();

    int idx = timtheoma(mahd);
    if (idx == -1) {
        System.out.println("❌ Khong tim thay chi tiet hop dong voi ma: " + mahd);
        return;
    }
    for (int i = idx; i < n - 1; i++) {
        ds[i] = ds[i + 1];
    }
    ds = Arrays.copyOf(ds, n - 1);
    n--;
    System.out.println("✅ Da xoa chi tiet hop dong co ma: " + mahd);
}



public void xoaCTHDcots(String mahd) {
    int idx = timtheoma(mahd);
    if (idx == -1) {
        System.out.println("❌ Khong tim thay chi tiet hop dong voi ma: " + mahd);
        return;
    }

    for (int i = idx; i < n - 1; i++) {
        ds[i] = ds[i + 1];
    }

    ds = Arrays.copyOf(ds, n - 1);
    n--;

    System.out.println("✅ Da xoa chi tiet hop dong (tham so) co ma: " + mahd);
}



public void suaCTHDkots() {
    System.out.print("Nhap ma hop dong can sua: ");
    String mahd = sc.nextLine();
    int idx = timtheoma(mahd);

    if (idx == -1) {
        System.out.println("❌ Khong tim thay chi tiet hop dong voi ma: " + mahd);
        return;
    }

    cthd ct = ds[idx];
    int chon;
    do {
        System.out.println("\n===== SUA CHI TIET HOP DONG =====");
        System.out.println("1. Sua ma khach hang");
        System.out.println("2. Sua ma ke hoach tour");
        System.out.println("0. Thoat");
        System.out.print("Nhap lua chon: ");
        chon = Integer.parseInt(sc.nextLine());

        switch (chon) {
            case 1:
                System.out.print("Nhap ma khach hang moi: ");
                ct.setMakh(sc.nextLine());
                break;
            case 2:
                System.out.print("Nhap ma ke hoach tour moi: ");
                ct.setMakhtour(sc.nextLine());
                break;
            case 0:
                System.out.println("⬅ Da thoat sua thong tin.");
                break;
            default:
                System.out.println("❌ Lua chon khong hop le!");
        }
    } while (chon != 0);

    ds[idx] = ct;
    System.out.println("✅ Da cap nhat chi tiet hop dong co ma: " + mahd);
}


public void suaCTHDcots(String mahd) {
    int idx = timtheoma(mahd);

    if (idx == -1) {
        System.out.println("❌ Khong tim thay chi tiet hop dong voi ma: " + mahd);
        return;
    }

    cthd ct = ds[idx];
    int chon;
    do {
        System.out.println("\n===== SUA CHI TIET HOP DONG (THAM SO) =====");
        System.out.println("1. Sua ma khach hang");
        System.out.println("2. Sua ma ke hoach tour");
        System.out.println("0. Thoat");
        System.out.print("Nhap lua chon: ");
        chon = Integer.parseInt(sc.nextLine());

        switch (chon) {
            case 1:
                System.out.print("Nhap ma khach hang moi: ");
                ct.setMakh(sc.nextLine());
                break;
            case 2:
                System.out.print("Nhap ma ke hoach tour moi: ");
                ct.setMakhtour(sc.nextLine());
                break;
            case 0:
                System.out.println("⬅ Da thoat sua thong tin.");
                break;
            default:
                System.out.println("❌ Lua chon khong hop le!");
        }
    } while (chon != 0);

    ds[idx] = ct;
    System.out.println("✅ Da cap nhat chi tiet hop dong (tham so) co ma: " + mahd);
}


}