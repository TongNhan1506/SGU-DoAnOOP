import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDate;
class dsHDV {
    private HDV[] ds;
    private int n;
    Scanner sc = new Scanner(System.in);

    // ======== HÀM KHỞI TẠO ========
    public dsHDV() {
        ds = new HDV[100];
        n = 0;
    }

    public dsHDV(HDV[] ds, int n) {
        this.ds = ds;
        this.n = n;
    }

    public dsHDV(dsHDV dshdv) {
        this.ds = dshdv.ds;
        this.n = dshdv.n;
    }

    // ======== GET - SET ========
    public HDV[] getDs() {
        return ds;
    }

    public int getN() {
        return n;
    }

    public void setDs(HDV[] ds) {
        this.ds = ds;
    }

    public void setN(int n) {
        this.n = n;
    }

    // ======== NHẬP / XUẤT ========
    public void nhapDshdv() {
        System.out.print("Nhap so luong HDV: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new HDV[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin HDV thu " + (i + 1) + ": ");
            ds[i] = new HDV();
            ds[i].nhap();
        }
    }

    public void xuatDshdv() {
        System.out.printf("%-10s %-10s %-10s %-10s %-15s %-15s %-10s %-15s%n",
                "MaHDV", "MaTour", "Ho", "Ten", "NgaySinh", "SoDT", "GioiTinh", "DiaChi");
        for (int i = 0; i < n; i++) {
            ds[i].xuat();
        }
    }

    // ======== HÀM THÊM ========
    public void themKots() {
        System.out.println("Nhap thong tin HDV moi:");
        HDV h = new HDV();
        h.nhap();
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = h;
        n++;
        System.out.println("✅ Da them HDV moi thanh cong!");
    }

    public void themCots(HDV h) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new HDV(h);
        n++;
        System.out.println("✅ Da them HDV moi (co tham so).");
    }

    // ======== HÀM TÌM KIẾM ========
    public int timTheoMa(String maHDV) {
        for (int i = 0; i < n; i++) {
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

    public void timKots() {
        System.out.print("Nhap ma HDV can tim: ");
        String ma = sc.nextLine();
        int idx = timTheoMa(ma);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay HDV co ma: " + ma);
            return;
        }
        System.out.println("✅ Thong tin HDV tim thay:");
        ds[idx].xuat();
    }

    // ======== HÀM XÓA ========
    public void xoaKots() {
        System.out.print("Nhap ma HDV can xoa: ");
        String ma = sc.nextLine();
        xoaCots(ma);
    }

    public void xoaCots(String maHDV) {
        int idx = timTheoMa(maHDV);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay HDV co ma: " + maHDV);
            return;
        }
        for (int i = idx; i < n - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, n - 1);
        n--;
        System.out.println("✅ Da xoa HDV co ma: " + maHDV);
    }

    // ======== HÀM SỬA ========
    public void suaHDV() {
        System.out.print("Nhap ma HDV can sua: ");
        String maHDV = sc.nextLine();
        int idx = timTheoMa(maHDV);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay HDV co ma: " + maHDV);
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
                    System.out.println("⬅ Thoat sua thong tin.");
                    break;
                default:
                    System.out.println("❌ Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = h;
        System.out.println("✅ Da cap nhat thong tin HDV co ma: " + maHDV);
    }
}
