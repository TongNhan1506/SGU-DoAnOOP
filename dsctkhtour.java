import java.util.Scanner;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
class dsctkhtour {
    private ctkhtour[] ds;
    private int N = 0;
    Scanner sc = new Scanner(System.in);

    
    public dsctkhtour() {
        ds = new ctkhtour[100];
        N = 0;
    }

    public dsctkhtour(ctkhtour[] ds, int n) {
        this.ds = ds;
        this.N = n;
    }

    public dsctkhtour(dsctkhtour dsct) {
        this.ds = dsct.ds;
        this.N = dsct.N;
    }

  
    public ctkhtour[] getDs() {
        return ds;
    }

    public int getN() {
        return N;
    }

    public void setDs(ctkhtour[] ds) {
        this.ds = ds;
    }

    public void setN(int n) {
        this.N = n;
    }

   
    public void nhapds() {
        System.out.print("Nhap so luong chi tiet ke hoach tour: ");
        N = Integer.parseInt(sc.nextLine());
        ds = new ctkhtour[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Nhap chi tiet ke hoach tour thu " + (i + 1) + ":");
            ds[i] = new ctkhtour();
            ds[i].nhap();
        }
    }

    public void xuatds() {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s%n","Ma ctkh tour", "Ma KH Tour", "Ngay Chi", "Tien An", "Tien O");
        for (int i = 0; i < N; i++) {
            ds[i].xuat();
        }
    }

  
    public int timTheoMa(String mact) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getMact().equals(mact)) {
                return i;
            }
        }
        return -1;
    }

   
    public ctkhtour timCots(String mact) {
        int idx = timTheoMa(mact);
        if (idx != -1)
            return ds[idx];
        return null;
    }

 
public void timTheoNgayChi(LocalDate ngaychi) {
    boolean found = false;
    System.out.println("\n=== KET QUA TIM KIEM THEO NGAY CHI: " + ngaychi + " ===");
    System.out.printf("%-15s %-15s %-15s %-15s%n", "Ma KH Tour", "Ngay Chi", "Tien An", "Tien O");

    for (int i = 0; i < N; i++) {
        if (ds[i].getNgaychi().equals(ngaychi)) {
            ds[i].xuat();
            found = true;
        }
    }

    if (!found) {
        System.out.println(" Khong tim thay ke hoach tour nao co ngay chi: " + ngaychi);
    }
}


   
    public void themCots(ctkhtour k) {
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = new ctkhtour(k);
        N++;
        System.out.println(" Da them ke hoach tour moi (co tham so).");
    }


    
    public void xoaCots(String makhtour) {
        int idx = timTheoMa(makhtour);
        if (idx == -1) {
            System.out.println(" Khong tim thay ke hoach tour de xoa!");
            return;
        }

        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }

        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println(" Da xoa ke hoach tour co ma: " + makhtour);
    }



public void thongKeTheoMa() {
    if (N == 0) {
        System.out.println(" Danh sach ke hoach tour rong!");
        return;
    }

    System.out.print("Nhap ma ke hoach tour can thong ke: ");
    String makhtour = sc.nextLine();
    int count = 0;

    for (int i = 0; i < N; i++) {
        if (ds[i].getMakhtour().equalsIgnoreCase(makhtour)) {
            count++;
        }
    }

    if (count == 0) {
        System.out.println(" Khong tim thay ke hoach tour co ma: " + makhtour);
    } else {
        System.out.println(" Ma ke hoach tour '" + makhtour + "' xuat hien " + count + " lan trong danh sach.");
    }
}


   
    public void suaKhtour() {
        System.out.print("Nhap ma ke hoach tour can sua: ");
        String mact = sc.nextLine();
        int idx = timTheoMa(mact);

        if (idx == -1) {
            System.out.println(" Khong tim thay ke hoach tour co ma: " + mact);
            return;
        }


        

        ctkhtour k = ds[idx];
        int chon;
        do {
            System.out.println("\n=== CHON MUC CAN SUA ===");
            System.out.println("1. Ngay chi");
            System.out.println("2. Tien an");
            System.out.println("3. Tien o");
            System.out.println("0. Thoat sua");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ngay chi moi: ");
                    String ngay=sc.nextLine();
                    LocalDate ngaymoi=LocalDate.parse(ngay);
                    k.setNgaychi(ngaymoi);
                    System.out.println(" Da sua ngay chi!");
                    break;
                case 2:
                    System.out.print("Nhap tien an moi: ");
                    k.setTienan(sc.nextInt());
                    System.out.println(" Da sua tien an!");
                    break;
                case 3:
                    System.out.print("Nhap tien o moi: ");
                    k.setTieno(sc.nextInt());
                    System.out.println(" Da sua tien o!");
                    break;
                case 0:
                    System.out.println("Thoat sua thong tin.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
    public void docFile(String file){
        try {
            FileInputStream fis =new FileInputStream(file);
            BufferedReader br=new BufferedReader(new InputStreamReader(fis));
            int n=0;
            ds=new ctkhtour[100];
            String line="";

            while((line=br.readLine())!=null){
                String[] part=line.split("\\|");
                if(part.length>=4){
                String mact=part[0];
                String makhtour=part[1];
                LocalDate ngaychi=LocalDate.parse(part[2]);
                int tienan=Integer.parseInt(part[3]);
                int tieno=Integer.parseInt(part[4]);

                ds[n++]=new ctkhtour(mact,makhtour,ngaychi,tienan,tieno);
            }
        }
        N=n;
        ds=Arrays.copyOf(ds,N);
        br.close();
        System.out.println("Da doc "+N+" chi tiet ke hoach tour tu file "+file);
        }
        catch(Exception e){
            System.out.println("Loi ghi file "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void ghiFile(String file){
        try{
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for(int i=0;i<N;i++){
                ctkhtour c=ds[i];
                String line="";

                line=String.join("\\|",
                c.getMact(),
                c.getMakhtour(),
                String.valueOf(c.getNgaychi()),
                String.valueOf(c.getTienan()),
                String.valueOf(c.getTieno()));
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Da ghi "+N+" chi tiet ke hoach tour vao file"+file);
        }
        catch(Exception e){
            System.out.println("Loi ghi file "+e.getMessage());
            e.printStackTrace();
        }
    }
}
