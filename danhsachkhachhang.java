import java.util.Scanner;
import java.util.Arrays;
import java.time.LocalDate;

class danhsachkhachhang {
    private khachhang[] ds;
    private int n;
    Scanner sc = new Scanner(System.in);

    public danhsachkhachhang() {
        ds = new khachhang[100];
        n = 0;
    }
    public danhsachkhachhang(khachhang[] ds, int n) {
        this.ds = ds;
        this.n = n;
    }
    public danhsachkhachhang(danhsachkhachhang dskh) {
        this.ds = dskh.ds;
        this.n = dskh.n;
    }
    public khachhang[] getDs() {
        return ds;
    }
    public int getN() {
        return n;
    }
    public void setDs(khachhang[] ds) {
        this.ds = ds;
    }
    public void setN(int n) {
        this.n = n;
    }
    
    public void nhapds() {
        System.out.print("Nhap so luong khach hang: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new khachhang[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap khach hang thu " + (i + 1) + ":");
            ds[i] = new khachhang();
            ds[i].nhap();
        }
    }

    public void xuatds() {
        if (n == 0) {
            System.out.println("Danh sach rong.");
            return;
        }
        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-20s %-15s\n",
                "MaKH", "Ho", "Ten", "NgaySinh", "GioiTinh", "DiaChi", "SDT");
        for (int i = 0; i < n; i++) {
            ds[i].xuat();
        }
    }

    // Tìm index theo mã khách hàng, trả về -1 nếu không tìm thấy
    public int timTheoMakh(String makh) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) return i;
        }
        return -1;
    }

    // --- HÀM TÌM CÓ THAM SỐ ---
    // Trả về đối tượng khachhang (null nếu không tìm thấy)
    public khachhang timKhachTheoMakh(String makh) {
        int idx = timTheoMakh(makh);
        if (idx == -1) return null;
        return ds[idx];
    }
    // === Tìm khách hàng không có tham số ===
    // Người dùng nhập mã khách hàng trực tiếp trong hàm
    public void timKhach() {
    System.out.print("Nhap ma khach hang can tim: ");
    String makh = sc.nextLine();
    int idx = timTheoMakh(makh);
    if (idx == -1) {
        System.out.println("Khong tim thay khach hang co ma: " + makh);
        return;
    }
    System.out.printf("%-10s %-10s %-10s %-15s %-10s %-20s %-15s\n",
            "MaKH", "Ho", "Ten", "NgaySinh", "GioiTinh", "DiaChi", "SDT");
    ds[idx].xuat();
}

    // Thêm khách hàng mới (nhập từ bàn phím)
    public void themKhach() {
        System.out.println("Nhap thong tin khach hang can them:");
        khachhang k = new khachhang();
        k.nhap();
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = k;
        n++;
        System.out.println("Da them khach hang.");
    }

    // Thêm khách hàng bằng tham số
    public void themKhach(khachhang k) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new khachhang(k); // copy constructor nếu có
        n++;
        System.out.println("✅ Da them khach hang bang tham so.");
    }

    // Xóa khách hàng theo mã (nhập từ bàn phím)
   public void xoaKhach() {
    System.out.print("Nhap ma khach hang can xoa: ");
    String makh = sc.nextLine();
    int idx = timTheoMakh(makh);

    if (idx == -1) {
        System.out.println("❌ Khong tim thay khach hang voi ma: " + makh);
        return;
    }

    for (int i = idx; i < n - 1; i++)
        ds[i] = ds[i + 1];

    ds = Arrays.copyOf(ds, n - 1);
    n--;

    System.out.println("✅ Da xoa khach hang: " + makh);
}

    // Xóa khách hàng bằng tham số
    public void xoaKhach(String makh) {
        int idx = timTheoMakh(makh);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay khach hang voi ma: " + makh);
            return;
        }
        for (int i = idx; i < n - 1; i++) 
        ds[i] = ds[i + 1];
        ds = Arrays.copyOf(ds, n - 1);
        n--;
        System.out.println("✅ Da xoa khach hang bang tham so: " + makh);
    }

    // Sửa thông tin khách hàng theo mã (menu chọn trường)
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
}
