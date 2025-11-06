import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class dsnhahang {
    private nhahang[] ds;
    private int N;
    Scanner sc = new Scanner(System.in);

    public dsnhahang() {
        N = 0;
        ds = new nhahang[0];
    }

    public dsnhahang(nhahang[] ds, int N) {
        this.ds = ds;
        this.N = N;
    }

    public dsnhahang(dsnhahang dsn) {
        this.ds = dsn.ds;
        this.N = dsn.N;
    }

    public nhahang[] getDs() {
        return ds;
    }

    public int getN() {
        return N;
    }

    public void setDs(nhahang[] ds) {
        this.ds = ds;
    }

    public void setN(int N) {
        this.N = N;
    }

    
    public void nhapDsNH() {
        System.out.print("Nhap so luong nha hang: ");
        N = Integer.parseInt(sc.nextLine());
        ds = new nhahang[N];
        for (int i = 0; i < N; i++) {
            System.out.println("\nNhap thong tin nha hang thu " + (i + 1) + ": ");
            ds[i] = new nhahang();
            ds[i].nhap();
        }
        N = ds.length;
    }

   
    public void xuatDsNH() {
        System.out.printf("%-15s %-20s %-25s %-15s %-15s\n",
                "MaNH", "TenNhaHang", "DiaChi", "SoDT", "MaKHTour");
        for (int i = 0; i < N; i++) {
            ds[i].xuat();
        }
    }

  
    public int timTheoMa(String manh) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getManh().equalsIgnoreCase(manh)) {
                return i;
            }
        }
        return -1;
    }

    public nhahang timNH(String manh) {
        int vt = timTheoMa(manh);
        if (vt == -1) return null;
        return ds[vt];
    }

   
    public void timTheoMaKHTour(String makhtour) {
        boolean found = false;
        System.out.printf("%-15s %-20s %-25s %-15s %-15s\n",
                "MaNH", "TenNhaHang", "DiaChi", "SoDT", "MaKHTour");
        for (int i = 0; i < N; i++) {
            if (ds[i].getMakhtour().equalsIgnoreCase(makhtour)) {
                ds[i].xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Khong co nha hang nao thuoc ma ke hoach tour: " + makhtour);
        }
    }
   

   
    public void thongKeTheoMa() {
        System.out.print("Nhap prefix ma ke hoach tour can thong ke: ");
        String prefix = sc.nextLine();

        int count = 0;
        System.out.println("\n=== THONG KE NHA HANG THEO PREFIX MA KE HOACH TOUR ===");
        System.out.println("- Prefix ma ke hoach tour: '" + prefix + "'");
        System.out.printf("%-15s %-20s %-25s %-15s %-15s\n",
                "MaNH", "TenNhaHang", "DiaChi", "SoDT", "MaKHTour");
        for (int i = 0; i < N; i++) {
            if (ds[i].getMakhtour().toLowerCase().startsWith(prefix.toLowerCase())) {
                ds[i].xuat();
                count++;
            }
        }

        if (count == 0) {
            System.out.println("❌ Khong co nha hang nao thuoc prefix ma ke hoach tour: " + prefix);
        } else {
            System.out.println("\n- Tong so nha hang thuoc prefix ma ke hoach tour '" + prefix + "': " + count);
        }
    }


   
    public void themNHKhongTs() {
        nhahang n = new nhahang();
        n.nhap();
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = n;
        N++;
        System.out.println("✅ Da them nha hang moi!");
    }

    public void themNHCoTs(nhahang n) {
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = new nhahang(n);
        N++;
        System.out.println("✅ Da them nha hang (tham so) thanh cong!");
    }

  
    public void xoaNHCoTs(String manh) {
        int idx = timTheoMa(manh);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay nha hang co ma: " + manh);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println("✅ Da xoa nha hang co ma: " + manh);
    }

    public void xoaNHKhongTs() {
        System.out.print("Nhap ma nha hang can xoa: ");
        String manh = sc.nextLine();
        xoaNHCoTs(manh);
    }


    public int thongKeTheoMaKHTour(String makhtour) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (ds[i].getMakhtour().equalsIgnoreCase(makhtour)) {
                count++;
            }
        }
        return count;
    }
public void thongKeTheoMaKHTour() {
    System.out.print("Nhap ma ke hoach tour can thong ke: ");
    String makhtour = sc.nextLine();

    int count = thongKeTheoMaKHTour(makhtour);
    if (count == 0) {
        System.out.println("❌ Khong co nha hang nao thuoc ma ke hoach tour: " + makhtour);
        return;
    }

    System.out.println("\n=== THONG KE NHA HANG THEO MA KE HOACH TOUR ===");
    System.out.println("- So luong nha hang thuoc ke hoach tour '" + makhtour + "': " + count);
    System.out.println("\nDanh sach nha hang:");
    System.out.printf("%-15s %-20s %-25s %-15s %-15s\n",
            "MaNH", "TenNhaHang", "DiaChi", "SoDT", "MaKHTour");
    for (int i = 0; i < N; i++) {
        if (ds[i].getMakhtour().equalsIgnoreCase(makhtour)) {
            ds[i].xuat();
        }
    }
}


   
    public void suaNH() {
        System.out.print("Nhap ma nha hang can sua: ");
        String manh = sc.nextLine();
        int idx = timTheoMa(manh);
        if (idx == -1) {
            System.out.println(" Khong tim thay nha hang co ma: " + manh);
            return;
        }

        nhahang n = ds[idx];
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN NHA HANG =====");
            System.out.println("1. Sua ten nha hang");
            System.out.println("2. Sua dia chi");
            System.out.println("3. Sua so dien thoai");
            System.out.println("4. Sua ma ke hoach tour (khoa ngoai)");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ten nha hang moi: ");
                    n.setTennh(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap dia chi moi: ");
                    n.setDiachi(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap so dien thoai moi: ");
                    n.setSodt(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhap ma ke hoach tour moi: ");
                    n.setMakhtour(sc.nextLine());
                    break;
                case 0:
                    System.out.println(" Thoat sua thong tin.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = n;
        System.out.println(" Da cap nhat thong tin nha hang co ma: " + manh);
    }

    public void suaNH(String manh) {
        int idx = timTheoMa(manh);
        if (idx == -1) {
            System.out.println(" Khong tim thay nha hang co ma: " + manh);
            return;
        }

        nhahang n = ds[idx];
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN NHA HANG =====");
            System.out.println("1. Sua ten nha hang");
            System.out.println("2. Sua dia chi");
            System.out.println("3. Sua so dien thoai");
            System.out.println("4. Sua ma ke hoach tour (khoa ngoai)");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ten nha hang moi: ");
                    n.setTennh(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap dia chi moi: ");
                    n.setDiachi(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap so dien thoai moi: ");
                    n.setSodt(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhap ma ke hoach tour moi: ");
                    n.setMakhtour(sc.nextLine());
                    break;
                case 0:
                    System.out.println(" Thoat sua thong tin.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = n;
        System.out.println(" Da cap nhat thong tin nha hang co ma: " + manh);
    }

    public void docFile(String file){
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            
            int n=0;
            ds=new nhahang[n];
            String line;
            while((line = br.readLine())!=null){
                String[] part=line.split(",");

                if(part.length>=7){
                    String ma = part[0].trim();
                    String ten = part[1].trim();
                    String dc = part[2].trim();
                    String sdt = part[3].trim();
                    String makht=part[4].trim();
                    ds[n++]=new nhahang(ma, ten, dc, sdt, makht);
                }
            }
            N=n;
            ds=Arrays.copyOf(ds,N);
            br.close();
            System.out.println("Da doc "+N+" nha hang tu file"+file);
        } catch ( Exception e) {
            System.out.println("Loi khong doc duoc file "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void ghiFile(String file){
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for(int i=0;i<N;i++){
                nhahang n =ds[i];
                String line ="";
                
                line=String.join(",",
                n.getManh(),
                n.getTennh(),
                n.getDiachi(),
                n.getSodt(),
                n.getMakhtour());
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Da ghi "+N+" nha hang vao file");
        } catch(Exception e){
            System.out.println("Loi ghi file "+e.getMessage());
            e.printStackTrace();
        }
    }
}
