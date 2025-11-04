import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
 class dscthoadon{
    private cthd[] ds;
    private int N;
    public dscthoadon(){
        ds = new cthd[100];
        N=0;
    }
    public dscthoadon(cthd[] ds,int n){
        this.ds=ds;
        this.N=n;
    }
    public dscthoadon(dscthoadon dsct){
        this.ds=dsct.ds;
        this.N=dsct.N;
    }
    public cthd[] getDs() {
        return ds;
    }
    public int getN() {
        return N;
    }
    public void setDs(cthd[] ds) {
        this.ds = ds;
    }
    public void setN(int N) {
        this.N = N;
    }
    Scanner sc = new Scanner(System.in);


    public void nhapDsCTHD(){
        System.out.println("Nhap so luong chi tiet hoa don: ");
        N = Integer.parseInt(sc.nextLine());
        ds=new cthd[N];
        for(int i=0;i<N;i++){
            System.out.println("Nhap thong tin chi tiet hoa don thu "+(i+1)+": ");
            ds[i]=new cthd();
            ds[i].nhap();
        }
        N=ds.length;
    }



    public void xuatDsCTHD(){
        System.out.printf("%-15s %-15s %-15s\n","Ma HD","Ma KH","Ma Ke Hoach Tour");
        for(int i=0;i<N;i++){
            ds[i].xuat();
        }
    }



    public int timtheoma(String mahd){
        for(int i=0;i<N;i++){
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


public void timTheoMakh(String makh) {
    boolean found = false;
    System.out.println("\n=== KET QUA TIM KIEM THEO MA KHACH HANG: " + makh + " ===");
    System.out.printf("%-15s %-15s %-15s\n", "Ma HD", "Ma KH", "Ma Ke Hoach Tour");

    for (int i = 0; i < N; i++) {
        if (ds[i].getMakh().equalsIgnoreCase(makh)) {
            ds[i].xuat();
            found = true;
        }
    }

    if (!found) {
        System.out.println(" Khong tim thay chi tiet hoa don nao cua khach hang co ma: " + makh);
    }
}


    public void themcthdcots(cthd k){
        ds=Arrays.copyOf(ds,N+1);
        ds[N]=new cthd(k);
        N++;
        System.out.println("Da them xong");
    }

public void xoaCTHDcots(String mahd) {
    int idx = timtheoma(mahd);
    if (idx == -1) {
        System.out.println(" Khong tim thay chi tiet hoa don voi ma: " + mahd);
        return;
    }

    for (int i = idx; i < N - 1; i++) {
        ds[i] = ds[i + 1];
    }

    ds = Arrays.copyOf(ds, N - 1);
    N--;

    System.out.println(" Da xoa chi tiet hoa don (tham so) co ma: " + mahd);
}


public int thongKeMaHD(String mahd) {
    if (N == 0) {
        System.out.println(" Danh sach chi tiet hoa don rong!");
        return 0;
    }
    int count = 0;
    for (int i = 0; i < N; i++) {
        if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
            count++;
        }
    }
    if (count == 0) {
        System.out.println(" Khong tim thay chi tiet hoa don co ma: " + mahd);
    } else {
        System.out.println(" Ma hoa don '" + mahd + "' xuat hien " + count + " lan trong danh sach.");
    }
    return count;
}





public void suaCTHDkots() {
    System.out.print("Nhap ma hoa don can sua: ");
    String mahd = sc.nextLine();
    int idx = timtheoma(mahd);

    if (idx == -1) {
        System.out.println(" Khong tim thay chi tiet hoa don voi ma: " + mahd);
        return;
    }

    cthd ct = ds[idx];
    int chon;
    do {
        System.out.println("\n===== SUA CHI TIET hoa don =====");
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
                System.out.println(" Da thoat sua thong tin.");
                break;
            default:
                System.out.println(" Lua chon khong hop le!");
        }
    } while (chon != 0);

    ds[idx] = ct;
    System.out.println(" Da cap nhat chi tiet hoa don co ma: " + mahd);
}


public void suaCTHDcots(String mahd) {
    int idx = timtheoma(mahd);

    if (idx == -1) {
        System.out.println(" Khong tim thay chi tiet hoa don voi ma: " + mahd);
        return;
    }

    cthd ct = ds[idx];
    int chon;
    do {
        System.out.println("\n===== SUA CHI TIET hoa don (THAM SO) =====");
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
                System.out.println(" Da thoat sua thong tin.");
                break;
            default:
                System.out.println(" Lua chon khong hop le!");
        }
    } while (chon != 0);

    ds[idx] = ct;
    System.out.println(" Da cap nhat chi tiet hoa don (tham so) co ma: " + mahd);
}

    public void docFile(String file){
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br=new BufferedReader(new InputStreamReader(fis));
            int n=0;
            ds= new cthd[100];
            String line="";
            while((line=br.readLine())!=null){
                String[] part=line.split("\\|");
                
                if(part.length>=3){
                    String mahd=part[0];
                    String makh=part[1];
                    String makhtour=part[2];

                    ds[n++]=new cthd(mahd, makh, makhtour);
                }

            }
            br.close();
            N=n;
            ds=Arrays.copyOf(ds,N);
            System.out.println("Da doc "+N+" chi tiet hoa don tu file "+file);
        }catch(Exception e){
            System.out.println("Loi khong doc duoc file "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void ghiFile(String file){
        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for(int i=0;i<N;i++){
                cthd c=ds[i];
                String line="";

                line=String.join("\\|",
                c.getMahd(),
                c.getMakh(),
                c.getMakhtour());

                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Da ghi "+N+" chi tiet hoa don vao file "+file);
        }catch(Exception e){
            System.out.println("Loi ghi file "+e.getMessage());
            e.printStackTrace();
        }
    }
}