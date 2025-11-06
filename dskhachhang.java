import java.util.Scanner;
import java.util.Arrays;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class dskhachhang {
    private khachhang[] ds;
    private int N;
    Scanner sc = new Scanner(System.in);

    public dskhachhang() {
        ds = new khachhang[100];
        N = 0;
    }
    public dskhachhang(khachhang[] ds, int N) {
        this.ds = ds;
        this.N = N;
    }
    public dskhachhang(dskhachhang dskh) {
        this.ds = dskh.ds;
        this.N = dskh.N;
    }
    public khachhang[] getDs() {
        return ds;
    }
    public int getN() {
        return N;
    }
    public void setDs(khachhang[] ds) {
        this.ds = ds;
    }
    public void setN(int N) {
        this.N = N;
    }
    
    public void nhapds() {
        System.out.print("Nhap so luong khach hang: ");
        N = Integer.parseInt(sc.nextLine());
        ds = new khachhang[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Nhap khach hang thu " + (i + 1) + ":");
            ds[i] = new khachhang();
            ds[i].nhap();
        }
    }

    public void xuatds() {
        if (N == 0) {
            System.out.println("Danh sach rong.");
            return;
        }
        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-20s %-15s\n",
                "MaKH", "Ho", "Ten", "NgaySinh", "GioiTinh", "DiaChi", "SDT");
        for (int i = 0; i < N; i++) {
            ds[i].xuat();
        }
    }

    
    public void themKhachCoTs(khachhang k) {
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = new khachhang(k);
        N++;
        System.out.println(" Da them khach hang (tham so) thanh cong!");
    }

   
    public int timTheoMakh(String makh) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) return i;
        }
        return -1;
    }

   
    public khachhang timKhachTheoMakh(String makh) {
        int idx = timTheoMakh(makh);
        if (idx == -1) return null;
        return ds[idx];
    }
    public void timKhachTheoTen(String ten) {
    boolean found = false;
    System.out.println("\n=== KET QUA TIM KIEM THEO TEN: " + ten + " ===");
    System.out.printf("%-10s %-10s %-10s %-15s %-10s %-20s %-15s\n",
            "MaKH", "Ho", "Ten", "NgaySinh", "GioiTinh", "DiaChi", "SDT");
    for (int i = 0; i < N; i++) {
        if (ds[i].getTen().equalsIgnoreCase(ten)) {
            ds[i].xuat();
            found = true;
        }
    }
    if (!found) {
        System.out.println(" Khong tim thay khach hang nao co ten: " + ten);
    }
}

    
    public void xoaKhach(String makh) {
        int idx = timTheoMakh(makh);
        if (idx == -1) {
            System.out.println(" Khong tim thay khach hang voi ma: " + makh);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println(" Da xoa khach hang bang tham so: " + makh);
    }

    public khachhang timKhachHang(String makh) {
        return timKhachTheoMakh(makh);
    }

    public void themKhachHang(khachhang k) {
        themKhachCoTs(k);
    }

    public void xoaKhachHang(String makh) {
        xoaKhach(makh);
    }

    public void suaKhachHang() {
        suaKhach();
    }

    
public void thongKeMaKH() {
    if (N == 0) {
        System.out.println(" Danh sach khach hang rong!");
        return;
    }

    System.out.print("Nhap ma khach hang can thong ke: ");
    String makh = sc.nextLine();

    int count = 0;
    for (int i = 0; i < N; i++) {
        if (ds[i].getMakh().equalsIgnoreCase(makh)) {
            count++;
        }
    }

    if (count == 0)
        System.out.println(" Khong tim thay khach hang co ma: " + makh);
    else
        System.out.println(" Ma khach hang '" + makh + "' xuat hien " + count + " lan trong danh sach.");
}


   
    public void suaKhach() {
        System.out.print("Nhap ma khach hang can sua: ");
        String makh = sc.nextLine();
        int idx = timTheoMakh(makh);
        if (idx == -1) {
            System.out.println("Khong tim thay khach hang voi ma: " + makh);
            return;
        }

        khachhang k = ds[idx];
        System.out.println("\n=== THONG TIN HIEN TAI ===");
        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-20s %-15s\n",
                "MaKH", "Ho", "Ten", "NgaySinh", "GioiTinh", "DiaChi", "SDT");
        k.xuat();

        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN KHACH HANG =====");
            System.out.println("1. Sua ho");
            System.out.println("2. Sua ten");
            System.out.println("3. Sua ngay sinh");
            System.out.println("4. Sua gioi tinh");
            System.out.println("5. Sua dia chi");
            System.out.println("6. Sua so dien thoai");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ho moi: ");
                    k.setHo(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap ten moi: ");
                    k.setTen(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap ngay sinh moi (yyyy-mm-dd): ");
                    try {
                        k.setNgaysinh(LocalDate.parse(sc.nextLine()));
                    } catch (Exception e) {
                        System.out.println("Dinh dang ngay khong hop le!");
                    }
                    break;
                case 4:
                    System.out.print("Nhap gioi tinh moi: ");
                    k.setGioitinh(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Nhap dia chi moi: ");
                    k.setDiachi(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Nhap so dien thoai moi: ");
                    k.setSdt(sc.nextLine());
                    break;
                case 0:
                    System.out.println("Da thoat sua thong tin.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = k;
        System.out.println("Da cap nhat thong tin khach hang.");
    }
    public void docFile(String file){
        try {
            FileInputStream fis=new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            int n=0;
            ds=new khachhang[100];
            String line="";
            while((line=br.readLine())!=null){
                String[] part=line.split("\\|");
                if(part.length>=7){
                    String ma=part[0];
                    String ho=part[1];
                    String ten=part[2];
                    LocalDate ngaysinh=LocalDate.parse(part[3]);
                    String gioitinh=part[4];
                    String diachi=part[5];
                    String sdt=part[6];

                    ds[n++]=new khachhang(ma, ho, ten, ngaysinh, gioitinh, diachi, sdt);
                }
            }
            br.close();
            N=n;
            ds=Arrays.copyOf(ds, N);
            System.out.println("Da doc "+N+" khach hang tu file "+file);
        }catch(Exception e){
            System.out.println("Loi doc file "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void ghiFile(String file){
        try{
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for(int i=0;i<N;i++){
                khachhang k=ds[i];
                String line="";

                line=String.join("|",
                k.getMakh(),
                k.getHo(),
                k.getTen(),
                String.valueOf(k.getNgaysinh()),
                k.getGioitinh(),
                k.getDiachi(),
                k.getSdt());
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Da ghi "+N+" khach hang vao file "+file);
        }
        catch(Exception e){
            System.out.println("Loi ghi file "+e.getMessage());
            e.printStackTrace();
        }
    }
}