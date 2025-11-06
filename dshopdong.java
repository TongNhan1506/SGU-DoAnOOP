import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class dshopdong {
    private hopdong[] ds;
    private int N;
    Scanner sc = new Scanner(System.in);

    public dshopdong() {
        ds = new hopdong[0];
        N = 0;
    }

  
    public void nhapDshopdong() {
        System.out.print("Nhap so hop dong: ");
        N = Integer.parseInt(sc.nextLine());
        ds = new hopdong[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Nhap hop dong thu " + (i + 1) + ": ");
            ds[i] = new hopdong();
            ds[i].nhap();
        }
    }

   
    public void xuatDshopdong() {
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Ma HD", "Ma tour", "Ma KH", "Dieu khoan");
        for (int i = 0; i < N; i++) {
            ds[i].xuat();
        }
    }

   
    public int timTheoMa(String mahd) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
                return i;
            }
        }
        return -1;
    }

   
    public hopdong timHopDong(String mahd) {
        int vt = timTheoMa(mahd);
        if (vt == -1) return null;
        return ds[vt];
    }


 
    // ===== TÌM THEO MÃ TOUR (CÓ THAM SỐ) =====
public void timTheoMaTour(String matour) {
    boolean found = false;
    System.out.printf("%-15s %-15s %-15s %-15s\n", "Ma HD", "Ma tour", "Ma KH", "Dieu khoan");
    for (int i = 0; i < N; i++) {
        if (ds[i].getMatour().equalsIgnoreCase(matour)) {
            ds[i].xuat();
            found = true;
        }
    }
    if (!found) {
        System.out.println(" Khong co hop dong nao thuoc tour co ma: " + matour);
    }
}


   
    public void themHopDongCots(hopdong h) {
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = new hopdong(h);
        N++;
        System.out.println(" Da them hop dong (tham so) thanh cong!");
    }

   
    public void xoaHopDongCots(String mahd) {
        int idx = timTheoMa(mahd);
        if (idx == -1) {
            System.out.println(" Khong tim thay hop dong co ma: " + mahd);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println(" Da xoa hop dong (tham so) co ma: " + mahd);
    }


  
public void thongKeTheoMaTour() {
    System.out.print("Nhap ma tour can thong ke: ");
    String matour = sc.nextLine();
    int dem = 0;

    System.out.printf("%-15s %-15s %-15s %-15s\n", "Ma HD", "Ma tour", "Ma KH", "Dieu khoan");
    for (int i = 0; i < N; i++) {
        if (ds[i].getMatour().equalsIgnoreCase(matour)) {
            ds[i].xuat();
            dem++;
        }
    }

    if (dem == 0) {
        System.out.println(" Khong co hop dong nao thuoc tour co ma: " + matour);
    } else {
        System.out.println(" Tong so hop dong cua tour " + matour + " la: " + dem);
    }
}


   
    public void suaHopDong() {
        System.out.print("Nhap ma hop dong can sua: ");
        String mahd = sc.nextLine();
        int idx = timTheoMa(mahd);
        if (idx == -1) {
            System.out.println(" Khong tim thay hop dong co ma: " + mahd);
            return;
        }

        hopdong h = ds[idx];
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN HOP DONG =====");
            System.out.println("1. Sua ma tour");
            System.out.println("2. Sua ma khach hang");
            System.out.println("3. Sua dieu khoan");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma tour moi: ");
                    h.setMatour(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap ma khach hang moi: ");
                    h.setMakh(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap dieu khoan moi: ");
                    h.setDieukhoan(sc.nextLine());
                    break;
                case 0:
                    System.out.println(" Da thoat sua thong tin.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = h;
        System.out.println(" Da cap nhat thong tin hop dong co ma: " + mahd);
    }
    public void docFile(String file){
        try {
            FileInputStream fis =new FileInputStream(file);
            BufferedReader br=new BufferedReader(new InputStreamReader(fis));
            int n=0;
            ds=new hopdong[100];
            
            String line;
            while((line=br.readLine())!=null){
                String[] part=line.split("\\|");

                if(part.length>=4){
                    String mahd=part[0].trim();
                    String matour=part[1].trim();
                    String makh=part[2].trim();
                    String dieukhoan=part[3].trim();
                    
                     ds[n++]=new hopdong(mahd, matour, makh, dieukhoan);
                }
            }
            br.close();
            
            N=n;
            ds=Arrays.copyOf(ds,N);
            System.out.println("Da doc "+N+" hop dong tu file "+file);
        } catch(Exception e){
            System.out.println("Loi ko doc duoc file "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void ghiFile(String file){
        try {
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for(int i=0; i<N;i++){
                hopdong h=ds[i];

                String line="";
                line=String.join("|",
                h.getMahd(),
                h.getMatour(),
                h.getMakh(),
                h.getDieukhoan());
                bw.write(line);
                bw.newLine();
            }  
            bw.close();
            System.out.println("Da ghi "+N+" hop dong vao file "+file);
        }catch(Exception e){
            System.out.println("Loi ghi file: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
