import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
class dsHDV {
    private HDV[] ds;
    private int N;
    Scanner sc = new Scanner(System.in);

   
    public dsHDV() {
        ds = new HDV[100];
        N = 0;
    }

    public dsHDV(HDV[] ds, int n) {
        this.ds = ds;
        this.N = n;
    }

    public dsHDV(dsHDV dshdv) {
        this.ds = dshdv.ds;
        this.N = dshdv.N;
    }

  
    public HDV[] getDs() {
        return ds;
    }

    public int getN() {
        return N;
    }

    public void setDs(HDV[] ds) {
        this.ds = ds;
    }

    public void setN(int n) {
        this.N = n;
    }

   
    public void nhapDshdv() {
        System.out.print("Nhap so luong HDV: ");
        N = Integer.parseInt(sc.nextLine());
        ds = new HDV[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Nhap thong tin HDV thu " + (i + 1) + ": ");
            ds[i] = new HDV();
            ds[i].nhap();
        }
    }

    public void xuatDshdv() {
        System.out.printf("%-10s %-10s %-10s %-10s %-15s %-15s %-10s %-15s%n",
                "MaHDV", "MaTour", "Ho", "Ten", "NgaySinh", "SoDT", "GioiTinh", "DiaChi");
        for (int i = 0; i < N; i++) {
            ds[i].xuat();
        }
    }
  
    public void themCots(HDV h) {
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = h;
        N++;
        System.out.println(" Da them HDV moi!");
    }

    public void themHDVCoTs(HDV h) {
        themCots(h);
    }

    public HDV timHDV(String mahdv) {
        return timCots(mahdv);
    }
   
    public int timTheoMa(String maHDV) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getMahdv().equals(maHDV)) {
                return i;
            }
        }
        return -1;
    }

    public HDV timCots(String maHDV) {
        int idx = timTheoMa(maHDV);
        if (idx != -1) return ds[idx];
        return null;
    }

    
public void timTheoTen(String ten) {
    boolean found = false;
    System.out.printf("%-10s %-10s %-10s %-10s %-15s %-15s %-10s %-15s%n",
            "MaHDV", "MaTour", "Ho", "Ten", "NgaySinh", "SoDT", "GioiTinh", "DiaChi");
    for (int i = 0; i < N; i++) {
        if (ds[i].getTen().equalsIgnoreCase(ten)) {
            ds[i].xuat();
            found = true;
        }
    }
    if (!found) {
        System.out.println(" Khong tim thay HDV co ten: " + ten);
    }
}


    public void xoaHDVCoTs(String mahdv) {
        int idx = timTheoMa(mahdv);
        if (idx == -1) {
            System.out.println(" Khong tim thay HDV co ma: " + mahdv);
            return;
        }

        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println(" Da xoa HDV co ma: " + mahdv);
    }


  
public void thongKeTheoMaTour() {
    if (N == 0) {
        System.out.println(" Danh sach HDV rong!");
        return;
    }

    System.out.print("Nhap ma tour can thong ke: ");
    String maTour = sc.nextLine();

    int count = 0;
    System.out.println("\n=== DANH SACH HDV THUOC TOUR: " + maTour + " ===");
    System.out.printf("%-10s %-10s %-10s %-10s %-15s %-15s %-10s %-15s%n",
            "MaHDV", "MaTour", "Ho", "Ten", "NgaySinh", "SoDT", "GioiTinh", "DiaChi");

    for (int i = 0; i < N; i++) {
        if (ds[i].getMakhtour().equalsIgnoreCase(maTour)) {
            ds[i].xuat();
            count++;
        }
    }

    if (count == 0) {
        System.out.println(" Khong co HDV nao thuoc tour co ma: " + maTour);
    } else {
        System.out.println(" Tong so HDV phu trach tour '" + maTour + "': " + count);
    }
}

  
    public void suaHDV() {
        System.out.print("Nhap ma HDV can sua: ");
        String maHDV = sc.nextLine();
        int idx = timTheoMa(maHDV);
        if (idx == -1) {
            System.out.println(" Khong tim thay HDV co ma: " + maHDV);
            return;
        }

        HDV h = ds[idx];
        int chon;
        do {
            System.out.println("\n===== MENU SUA THONG TIN HDV =====");
            System.out.println("1. Sua ma ke hoach tour");
            System.out.println("2. Sua ho ten");
            System.out.println("3. Sua ngay sinh");
            System.out.println("4. Sua so dien thoai");
            System.out.println("5. Sua gioi tinh");
            System.out.println("6. Sua dia chi");
            System.out.println("0. Thoat sua");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma ke hoach tour moi: ");
                    h.setMakhtour(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap ho moi: ");
                    h.setHo(sc.nextLine());
                    System.out.print("Nhap ten moi: ");
                    h.setTen(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap ngay sinh moi: ");
                    h.setNgaysinh(LocalDate.parse(sc.nextLine()));
                    break;
                case 4:
                    System.out.print("Nhap so dien thoai moi: ");
                    h.setSdt(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Nhap gioi tinh moi: ");
                    h.setGioitinh(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Nhap dia chi moi: ");
                    h.setDiachi(sc.nextLine());
                    break;
                case 0:
                    System.out.println(" Thoat sua thong tin.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = h;
        System.out.println(" Da cap nhat thong tin HDV co ma: " + maHDV);
    }
    public void docFile(String file){
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br=new BufferedReader(new InputStreamReader(fis));

            int n=0;
            ds=new HDV[100];

            String line="";
            while((line=br.readLine())!=null){
                String[] part=line.split("\\|");

                if(part.length>=7){
                    String mahdv=part[0];
                    String makhtour=part[1];
                    String ho=part[2];
                    String ten=part[3];
                    LocalDate ngaysinh=LocalDate.parse(part[4]);
                    String gioitinh=part[5];
                    String diachi=part[6];
                    String sdt=part[7];
                    
                    ds[n++]=new HDV(mahdv, makhtour, ho, ten, ngaysinh, gioitinh, diachi, sdt);
                }
            
            }
            N=n;
            ds=Arrays.copyOf(ds,N);
            br.close();
            System.out.println("Da doc "+N+" huong dan vien tu file "+file);
        }
        catch(Exception e){
            System.out.println("Loi khong doc duoc file "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void ghiFile(String file){
        try {   
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for(int i=0;i<N;i++){
                HDV h=ds[i];
                String line="";
                line=String.join("|",
                h.getMahdv(),
                h.getMakhtour(),
                h.getHo(),
                h.getTen(),
                String.valueOf(h.getNgaysinh()),
                h.getGioitinh(),
                h.getDiachi(),
                h.getSdt());
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Da ghi "+N+" huong dan vien vao file "+file);
        }
        catch(Exception e){
            System.out.println("Loi ghi file "+e.getMessage());
            e.printStackTrace();
        }
    }
}
