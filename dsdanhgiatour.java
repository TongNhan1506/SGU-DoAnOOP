import java.util.Arrays;
import java.util.Scanner;

public class dsdanhgiatour {
    private danhgiatour[] ds;
    private int soDG;
    Scanner sc = new Scanner(System.in);

    public dsdanhgiatour() {
        soDG = 0;
        ds = new danhgiatour[0];
    }

    public dsdanhgiatour(dsdanhgiatour dsdg) {
        this.ds = dsdg.ds;
        this.soDG = dsdg.soDG;
    }

    public danhgiatour[] getDs() {
        return ds;
    }

    public int getSoDG() {
        return soDG;
    }

    public void setDs(danhgiatour[] ds) {
        this.ds = ds;
    }

    public void setSoDG(int soDG) {
        this.soDG = soDG;
    }

    // ====== NHẬP DANH SÁCH ======
    public void nhapDsDG() {
        System.out.print("Nhap so luong danh gia: ");
        soDG = Integer.parseInt(sc.nextLine());
        ds = new danhgiatour[soDG];
        for (int i = 0; i < soDG; i++) {
            System.out.println("\nNhap danh gia thu " + (i + 1) + ": ");
            ds[i] = new danhgiatour();
            ds[i].nhap();
        }
        soDG = ds.length;
    }

    // ====== XUẤT DANH SÁCH ======
    public void xuatDsDG() {
        System.out.printf("%-10s %-12s %-20s %-6s %-30s\n",
                "MaDG", "MaKHTour", "TenKH", "Sao", "NhanXet");
        for (int i = 0; i < soDG; i++) {
            ds[i].xuat();
        }
    }

    // ====== TÌM THEO MÃ ======
    public int timTheoMa(String madg) {
        for (int i = 0; i < soDG; i++) {
            if (ds[i].getMadg().equalsIgnoreCase(madg)) {
                return i;
            }
        }
        return -1;
    }

    public danhgiatour timDG(String madg) {
        int vt = timTheoMa(madg);
        if (vt == -1) return null;
        return ds[vt];
    }

    // ====== TÌM THEO MÃ KẾ HOẠCH TOUR ======
public void timTheoMaKHTour(String makhtour) {
    boolean found = false;
    System.out.printf("%-10s %-12s %-20s %-6s %-30s\n",
            "MaDG", "MaKHTour", "TenKH", "Sao", "NhanXet");

    for (int i = 0; i < soDG; i++) {
        if (ds[i].getMakhtour().equalsIgnoreCase(makhtour)) {
            ds[i].xuat();
            found = true;
        }
    }

    if (!found) {
        System.out.println("❌ Khong co danh gia nao thuoc ma ke hoach tour: " + makhtour);
    }
}



    // ====== THÊM (CÓ THAM SỐ) ======
    public void themDGCoTs(danhgiatour dg) {
        ds = Arrays.copyOf(ds, soDG + 1);
        ds[soDG] = new danhgiatour(dg); // dùng constructor sao chép để an toàn
        soDG++;
        System.out.println("✅ Da them danh gia (tham so) thanh cong!");
    }

    // ====== XÓA (CÓ THAM SỐ) ======
    public void xoaDGCoTs(String madg) {
        int idx = timTheoMa(madg);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay danh gia co ma: " + madg);
            return;
        }
        for (int i = idx; i < soDG - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, soDG - 1);
        soDG--;
        System.out.println("✅ Da xoa danh gia co ma: " + madg);
    }

  
    // ====== THỐNG KÊ THEO MÃ KẾ HOẠCH TOUR ======
public void thongKeTheoMaKHTour() {
    if (soDG == 0) {
        System.out.println("❌ Danh sach danh gia rong!");
        return;
    }

    System.out.print("Nhap ma ke hoach tour can thong ke: ");
    String makhtour = sc.nextLine();

    int count = 0;
    int tongSao = 0;

    for (int i = 0; i < soDG; i++) {
        if (ds[i].getMakhtour().equalsIgnoreCase(makhtour)) {
            count++;
            tongSao += ds[i].getSao();
        }
    }

    if (count == 0) {
        System.out.println("❌ Khong co danh gia nao thuoc ma ke hoach tour: " + makhtour);
    } else {
        double tbSao = (double) tongSao / count;
        System.out.println("✅ Ma ke hoach tour '" + makhtour + "' co tong " + count + " danh gia.");
        System.out.printf("⭐ Trung binh so sao: %.2f\n", tbSao);
    }
}


    // ====== SỬA ======
    public void suaDG() {
        System.out.print("Nhap ma danh gia can sua: ");
        String madg = sc.nextLine();
        int idx = timTheoMa(madg);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay danh gia co ma: " + madg);
            return;
        }

        danhgiatour dg = ds[idx];
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN DANH GIA TOUR =====");
            System.out.println("1. Sua ten khach hang");
            System.out.println("2. Sua so sao");
            System.out.println("3. Sua nhan xet");
            System.out.println("4. Sua ma ke hoach tour (khoa ngoai)");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ten khach hang moi: ");
                    dg.setTenkh(sc.nextLine());
                    break;
                case 2:
                    int s;
                    do {
                        System.out.print("Nhap so sao moi (1-5): ");
                        s = Integer.parseInt(sc.nextLine());
                    } while (s < 1 || s > 5);
                    dg.setSao(s);
                    break;
                case 3:
                    System.out.print("Nhap nhan xet moi: ");
                    dg.setNhanxet(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhap ma ke hoach tour moi: ");
                    dg.setMakhtour(sc.nextLine());
                    break;
                case 0:
                    System.out.println("⬅ Thoat sua thong tin.");
                    break;
                default:
                    System.out.println("❌ Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = dg;
        System.out.println("✅ Da cap nhat danh gia co ma: " + madg);
    }
}
