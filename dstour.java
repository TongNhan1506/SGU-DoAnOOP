import java.util.Arrays;
import java.util.Scanner;

abstract class dstour {
    private tour[] ds;
    private int N;
    Scanner sc = new Scanner(System.in);

    public dstour() {
        N = 0;
        ds = new tour[0];
    }

    // ===== NHẬP DANH SÁCH =====
    public void nhapDstour() {
        System.out.print("Nhap so luong tour: ");
        N = Integer.parseInt(sc.nextLine());
        ds = new tour[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Nhap tour thu " + (i + 1) + ": ");
            System.out.println("Chon loai tour: 1 - Trong nuoc, 2 - Nuoc ngoai");
            int loai = Integer.parseInt(sc.nextLine());
            if (loai == 1) {
                ds[i] = new tourtrongnuoc();
            } else {
                ds[i] = new tournuocngoai();
            }
            ds[i].nhap();
        }
    }

    // ===== XUẤT DANH SÁCH =====
    public void xuatDstour() {
        for (int i = 0; i < N; i++) {
            System.out.println("Tour thu " + (i + 1) + ": ");
            ds[i].xuat();
            System.out.println("---------------------");
        }
    }

    // ===== TÌM TOUR =====
    public int timTheoMa(String matour) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getMatour().equalsIgnoreCase(matour)) return i;
        }
        return -1;
    }

    public tour timTour(String matour) {
        int idx = timTheoMa(matour);
        if (idx == -1) return null;
        return ds[idx];
    }

    // ===== THÊM TOUR =====
    public void themTourKhongTs() {
        System.out.println("Nhap thong tin tour moi: ");
        System.out.println("Chon loai tour: 1 - Trong nuoc, 2 - Nuoc ngoai");
        int loai = Integer.parseInt(sc.nextLine());
        tour t = (loai == 1) ? new tourtrongnuoc() : new tournuocngoai();
        t.nhap();
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = t;
        N++;
        System.out.println("✅ Da them tour moi!");
    }

    public void themTourCoTs(tour t) {
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = t;
        N++;
        System.out.println("✅ Da them tour (tham so) thanh cong!");
    }

    // ===== XÓA TOUR =====
    public void xoaTourKhongTs() {
        System.out.print("Nhap ma tour can xoa: ");
        String matour = sc.nextLine();
        int idx = timTheoMa(matour);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay tour co ma: " + matour);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println("✅ Da xoa tour co ma: " + matour);
    }

    // Xóa có tham số
    public void xoaTourCoTs(String matour) {
        int idx = timTheoMa(matour);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay tour co ma: " + matour);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println("✅ Da xoa tour co ma: " + matour);
    }

    // ===== SỬA TOUR =====
    public void suaTour() {
        System.out.print("Nhap ma tour can sua: ");
        String matour = sc.nextLine();
        int idx = timTheoMa(matour);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay tour co ma: " + matour);
            return;
        }

        tour t = ds[idx];
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN TOUR =====");
            System.out.println("1. Sua ma tour");
            System.out.println("2. Sua ten tour");
            System.out.println("3. Sua don gia");
            System.out.println("4. Sua thu tuc va dia diem KH");
            if (t instanceof tourtrongnuoc) System.out.println("5. Sua tinh thanh & dac san");
            if (t instanceof tournuocngoai) System.out.println("5. Sua quoc gia & ngoai te");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma tour moi: ");
                    t.setMatour(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap ten tour moi: ");
                    t.setTentour(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap don gia moi: ");
                    t.setDongia(Integer.parseInt(sc.nextLine()));
                    break;
                case 4:
                    System.out.print("Nhap thu tuc moi: ");
                    t.setThutuc(sc.nextLine());
                    System.out.print("Nhap dia diem KH moi: ");
                    t.setDiadiemKH(sc.nextLine());
                    break;
                case 5:
                    if (t instanceof tourtrongnuoc) {
                        tourtrongnuoc tn = (tourtrongnuoc) t;
                        System.out.print("Nhap tinh thanh moi: ");
                        tn.setTinhthanh(sc.nextLine());
                        System.out.print("Nhap dac san moi: ");
                        tn.setDacsan(sc.nextLine());
                    } else if (t instanceof tournuocngoai) {
                        tournuocngoai tq = (tournuocngoai) t;
                        System.out.print("Nhap quoc gia moi: ");
                        tq.setQuocgia(sc.nextLine());
                        System.out.print("Nhap ngoai te moi: ");
                        tq.setNgoaite(sc.nextLine());
                    }
                    break;
                case 0:
                    System.out.println("⬅ Thoat sua thong tin tour.");
                    break;
                default:
                    System.out.println("❌ Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = t;
        System.out.println("✅ Da cap nhat tour co ma: " + matour);
    }
}
