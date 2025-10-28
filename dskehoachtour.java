import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDate;
public class dskehoachtour {
    private kehoachtour[] ds;
    private int soKHT;
    Scanner sc = new Scanner(System.in);

    public dskehoachtour() {
        soKHT = 0;
        ds = new kehoachtour[0];
    }

    public dskehoachtour(kehoachtour[] ds, int soKHT) {
        this.ds = ds;
        this.soKHT = soKHT;
    }

    public dskehoachtour(dskehoachtour dskht) {
        this.ds = dskht.ds;
        this.soKHT = dskht.soKHT;
    }

    public kehoachtour[] getDs() {
        return ds;
    }

    public int getSoKHT() {
        return soKHT;
    }

    public void setDs(kehoachtour[] ds) {
        this.ds = ds;
    }

    public void setSoKHT(int soKHT) {
        this.soKHT = soKHT;
    }

   
    public void nhapDsKHT() {
        System.out.print("Nhap so luong ke hoach tour: ");
        soKHT = Integer.parseInt(sc.nextLine());
        ds = new kehoachtour[soKHT];
        for (int i = 0; i < soKHT; i++) {
            System.out.println("Nhap ke hoach tour thu " + (i + 1) + ": ");
            ds[i] = new kehoachtour();
            ds[i].nhap();
        }
        soKHT = ds.length;
    }

    
    public void xuatDsKHT() {
        System.out.printf("%-10s %-10s %-12s %-12s %-8s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "MaKHT", "MaTour", "Ngay di", "Ngay ve", "Don gia", "Tong ve",
                "Ve con", "Tong chi", "An", "O", "Di lai", "MaHDV");
        for (int i = 0; i < soKHT; i++) {
            ds[i].xuat();
        }
    }

    public int timTheoMa(String makhtour) {
        for (int i = 0; i < soKHT; i++) {
            if (ds[i].getMakhtour().equalsIgnoreCase(makhtour)) {
                return i;
            }
        }
        return -1;
    }

    public kehoachtour timKHT(String makhtour) {
        int vt = timTheoMa(makhtour);
        if (vt == -1) return null;
        return ds[vt];
    }

    public void timKHTKhongTs() {
        System.out.print("Nhap ma ke hoach tour can tim: ");
        String makhtour = sc.nextLine();
        kehoachtour k = timKHT(makhtour);
        if (k == null) {
            System.out.println("❌ Khong tim thay ke hoach tour co ma: " + makhtour);
            return;
        }
        System.out.printf("%-10s %-10s %-12s %-12s %-8s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "MaKHT", "MaTour", "Ngay di", "Ngay ve", "Don gia", "Tong ve",
                "Ve con", "Tong chi", "An", "O", "Di lai", "MaHDV");
        k.xuat();
    }

   
    public void themKHTKhongTs() {
        kehoachtour k = new kehoachtour();
        k.nhap();
        ds = Arrays.copyOf(ds, soKHT + 1);
        ds[soKHT] = k;
        soKHT++;
        System.out.println("✅ Da them ke hoach tour moi!");
    }

    public void themKHTCoTs(kehoachtour k) {
        ds = Arrays.copyOf(ds, soKHT + 1);
        ds[soKHT] = new kehoachtour(k);
        soKHT++;
        System.out.println("✅ Da them ke hoach tour (tham so) thanh cong!");
    }

    // ====== XÓA ======
    public void xoaKHTCoTs(String makhtour) {
        int idx = timTheoMa(makhtour);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay ke hoach tour co ma: " + makhtour);
            return;
        }
        for (int i = idx; i < soKHT - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, soKHT - 1);
        soKHT--;
        System.out.println("✅ Da xoa ke hoach tour co ma: " + makhtour);
    }

    public void xoaKHTKhongTs() {
        System.out.print("Nhap ma ke hoach tour can xoa: ");
        String makhtour = sc.nextLine();
        xoaKHTCoTs(makhtour);
    }

    // ====== SỬA ======
    public void suaKHT() {
        System.out.print("Nhap ma ke hoach tour can sua: ");
        String makhtour = sc.nextLine();
        int idx = timTheoMa(makhtour);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay ke hoach tour co ma: " + makhtour);
            return;
        }

        kehoachtour k = ds[idx];
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN KE HOACH TOUR =====");
            System.out.println("1. Sua ma tour");
            System.out.println("2. Sua ngay di / ngay ve");
            System.out.println("3. Sua don gia");
            System.out.println("4. Sua tong ve, ve con");
            System.out.println("5. Sua tong chi / an / o / di lai / tien ve");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma tour moi: ");
                    k.setMatour(sc.nextLine());
                    break;
                case 2:
                 System.out.print("Nhap ngay di moi: ");
                k.setNgaydi(LocalDate.parse(sc.nextLine()));
                 System.out.print("Nhap ngay ve moi: ");
                k.setNgayve(LocalDate.parse(sc.nextLine()));
                break;

                case 3:
                    System.out.print("Nhap don gia moi: ");
                    k.setDongia(Integer.parseInt(sc.nextLine()));
                    break;
                case 4:
                    System.out.print("Nhap tong so ve moi: ");
                    k.setTongsove(Integer.parseInt(sc.nextLine()));
                    System.out.print("Nhap so ve con lai moi: ");
                    k.setSoveconlai(Integer.parseInt(sc.nextLine()));
                    break;
                case 5:
                    System.out.print("Nhap tong chi moi: ");
                    k.setTongchi(Integer.parseInt(sc.nextLine()));
                    System.out.print("Nhap tong an moi: ");
                    k.setTongan(Integer.parseInt(sc.nextLine()));
                    System.out.print("Nhap tong o moi: ");
                    k.setTongo(Integer.parseInt(sc.nextLine()));
                    System.out.print("Nhap tong di lai moi: ");
                    k.setTongdilai(Integer.parseInt(sc.nextLine()));
                    System.out.print("Nhap tong tien ve moi: ");
                    k.setTongtienve(Integer.parseInt(sc.nextLine()));
                    break;
                case 0:
                    System.out.println("⬅ Thoat sua thong tin.");
                    break;
                default:
                    System.out.println("❌ Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = k;
        System.out.println("✅ Da cap nhat thong tin ke hoach tour co ma: " + makhtour);
    }
}
