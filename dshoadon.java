import java.util.Arrays;
import java.util.Scanner;

public class dshoadon {
    private hoadon[] ds;
    private int n;
    private Scanner sc = new Scanner(System.in);

    public dshoadon() {
        n = 0;
        ds = new hoadon[0];
    }

    public dshoadon(hoadon[] ds, int n) {
        this.ds = ds;
        this.n = n;
    }

    public dshoadon(dshoadon dshd) {
        this.ds = dshd.ds;
        this.n = dshd.n;
    }

    public void nhapDsHD() {
        System.out.print("Nhap so luong hoa don: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new hoadon[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap hoa don thu " + (i + 1) + ":");
            ds[i] = new hoadon();
            ds[i].nhap();
        }
        n = ds.length;
    }

    public void xuatDsHD() {
        System.out.printf("%-10s %-10s %-12s %-10s\n", "MaHD", "MaKH", "MaKHTour", "TongTien");
        for (int i = 0; i < n; i++) {
            ds[i].xuat();
        }
    }

    public int timTheoMa(String mahoadon) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahoadon)) {
                return i;
            }
        }
        return -1;
    }

    public hoadon timHD(String mahoadon) {
        int idx = timTheoMa(mahoadon);
        if (idx == -1) {
            return null;
        }
        return ds[idx];
    }

    public void timTheoMaKH(String makh) {
        boolean found = false;
        System.out.printf("%-10s %-10s %-12s %-10s\n", "MaHD", "MaKH", "MaKHTour", "TongTien");
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) {
                ds[i].xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Khong co hoa don nao thuoc ve khach hang co ma: " + makh);
        }
    }

    public void themHDCoTs(hoadon h) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new hoadon(h);
        n++;
        System.out.println("✅ Da them hoa don (tham so) thanh cong!");
    }

    public void xoaHDCoTs(String mahoadon) {
        int idx = timTheoMa(mahoadon);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay hoa don co ma: " + mahoadon);
            return;
        }
        for (int i = idx; i < n - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, n - 1);
        n--;
        System.out.println("✅ Da xoa hoa don co ma: " + mahoadon);
    }

    public void thongKeTheoMaKH() {
        System.out.print("Nhap ma khach hang can thong ke: ");
        String makh = sc.nextLine();
        int dem = 0;
        int tongTien = 0;

        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) {
                dem++;
                tongTien += ds[i].getTongtien();
            }
        }

        if (dem == 0) {
            System.out.println("❌ Khong co hoa don nao thuoc ve khach hang co ma: " + makh);
        } else {
            System.out.println("✅ Khach hang co ma " + makh + " co " + dem + " hoa don.");
            System.out.println("💰 Tong tien cua khach hang nay: " + tongTien);
        }
    }

    public void suaHD() {
        System.out.print("Nhap ma hoa don can sua: ");
        String mahoadon = sc.nextLine();
        int idx = timTheoMa(mahoadon);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay hoa don co ma: " + mahoadon);
            return;
        }

        hoadon h = ds[idx];
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN HOA DON =====");
            System.out.println("1. Sua ma khach hang");
            System.out.println("2. Sua ma ke hoach tour");
            System.out.println("3. Sua tong tien");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma khach hang moi: ");
                    h.setMakh(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap ma ke hoach tour moi: ");
                    h.setMakhtour(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap tong tien moi: ");
                    h.setTongtien(Integer.parseInt(sc.nextLine()));
                    break;
                case 0:
                    System.out.println("⬅ Thoat sua thong tin.");
                    break;
                default:
                    System.out.println("❌ Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = h;
        System.out.println("✅ Da cap nhat thong tin hoa don co ma: " + mahoadon);
    }
}
