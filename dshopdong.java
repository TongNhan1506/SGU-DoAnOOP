import java.util.Arrays;
import java.util.Scanner;

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

    
    public void timKhongTs() {
        System.out.print("Nhap ma hop dong can tim: ");
        String mahd = sc.nextLine();
        hopdong h = timHopDong(mahd);
        if (h == null) {
            System.out.println("❌ Khong tim thay hop dong co ma: " + mahd);
            return;
        }
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Ma HD", "Ma tour", "Ma KH", "Dieu khoan");
        h.xuat();
    }

   
    public void themHopDongKots() {
        hopdong h = new hopdong();
        h.nhap();
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = h;
        N++;
        System.out.println("✅ Da them hop dong moi thanh cong!");
    }

   
    public void themHopDongCots(hopdong h) {
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = new hopdong(h);
        N++;
        System.out.println("✅ Da them hop dong (tham so) thanh cong!");
    }

   
    public void xoaHopDongCots(String mahd) {
        int idx = timTheoMa(mahd);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay hop dong co ma: " + mahd);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println("✅ Da xoa hop dong (tham so) co ma: " + mahd);
    }

   
    public void xoaHopDongKots() {
        System.out.print("Nhap ma hop dong can xoa: ");
        String mahd = sc.nextLine();
        int idx = timTheoMa(mahd);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay hop dong co ma: " + mahd);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println("✅ Da xoa hop dong co ma: " + mahd);
    }

   
    public void suaHopDong() {
        System.out.print("Nhap ma hop dong can sua: ");
        String mahd = sc.nextLine();
        int idx = timTheoMa(mahd);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay hop dong co ma: " + mahd);
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
                    System.out.println("⬅ Da thoat sua thong tin.");
                    break;
                default:
                    System.out.println("❌ Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = h;
        System.out.println("✅ Da cap nhat thong tin hop dong co ma: " + mahd);
    }
}
