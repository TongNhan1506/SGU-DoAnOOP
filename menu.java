import java.util.Scanner;

public class menu {
    private static Scanner sc = new Scanner(System.in);
    private static dsHDV dshdv = new dsHDV();
    private static dskhachhang dskh = new dskhachhang();
    private static dstour dst = new dstour();
    private static dskehoachtour dskht = new dskehoachtour();
    private static dsctkhtour dsctkht = new dsctkhtour();
    private static dshopdong dshd = new dshopdong();
    private static dshoadon dshoadon = new dshoadon();

    public static void main(String[] args) {
        khoiTao();
        int chon = -1;
        
        while (chon != 0) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║  CHUONG TRINH QUAN LY TOUR DU LICH    ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("Chon cac chuc nang quan ly duoi day");
            System.out.println("1. Quan ly huong dan vien");
            System.out.println("2. Quan ly khach hang");
            System.out.println("3. Quan ly tour du lich");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Nhap lua chon cua ban: ");
            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        quanLyHDV();
                        break;
                    case 2:
                        quanLyKhachHang();
                        break;
                    case 3:
                        quanLyTour();
                        break;
                    case 0:
                        System.out.println("╔════════════════════════════════════════╗");
                        System.out.println("║  Cam on ban da su dung chuong trinh!  ║");
                        System.out.println("╚════════════════════════════════════════╝");
                        break;
                    default:
                        System.out.println("❌ Lua chon khong hop le!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui long nhap so!");
            }
        }
        sc.close();
    }

    public static void khoiTao() {
        dshdv = new dsHDV();
        dskh = new dskhachhang();
        dst = new dstour();
        dskht = new dskehoachtour();
        dsctkht = new dsctkhtour();
        dshd = new dshopdong();
        dshoadon = new dshoadon();
    }

    public static void quanLyHDV() {
        int chon;
        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║      QUAN LY HUONG DAN VIEN           ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Nhap danh sach HDV");
            System.out.println("2. Xuat danh sach HDV");
            System.out.println("3. Tim kiem HDV theo ma");
            System.out.println("4. Tim kiem HDV theo ten");
            System.out.println("5. Them HDV moi");
            System.out.println("6. Xoa HDV");
            System.out.println("7. Sua thong tin HDV");
            System.out.println("8. Thong ke theo ma tour");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon cua ban: ");
            
            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dshdv.nhapDshdv();
                        break;
                    case 2:
                        dshdv.xuatDshdv();
                        break;
                    case 3:
                        System.out.print("Nhap ma HDV can tim: ");
                        String maHDV = sc.nextLine();
                        HDV hdv = dshdv.timHDV(maHDV);
                        if (hdv != null) {
                            System.out.println("✅ Tim thay HDV:");
                            System.out.printf("%-10s %-10s %-10s %-10s %-15s %-15s %-10s %-15s%n",
                                    "MaHDV", "MaTour", "Ho", "Ten", "NgaySinh", "SoDT", "GioiTinh", "DiaChi");
                            hdv.xuat();
                        } else {
                            System.out.println("❌ Khong tim thay HDV co ma " + maHDV);
                        }
                        break;
                    case 4:
                        System.out.print("Nhap ten HDV can tim: ");
                        String tenHDV = sc.nextLine();
                        dshdv.timTheoTen(tenHDV);
                        break;
                    case 5:
                        HDV hdvMoi = new HDV();
                        hdvMoi.nhap();
                        dshdv.themHDVCoTs(hdvMoi);
                        break;
                    case 6:
                        System.out.print("Nhap ma HDV can xoa: ");
                        dshdv.xoaHDVCoTs(sc.nextLine());
                        break;
                    case 7:
                        dshdv.suaHDV();
                        break;
                    case 8:
                        dshdv.thongKeTheoMaTour();
                        break;
                    case 0:
                        System.out.println("⬅ Quay lai menu chinh...");
                        break;
                    default:
                        System.out.println("❌ Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyKhachHang() {
        int chon;
        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║         QUAN LY KHACH HANG            ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Nhap danh sach khach hang");
            System.out.println("2. Xuat danh sach khach hang");
            System.out.println("3. Tim kiem khach hang theo ma");
            System.out.println("4. Tim kiem khach hang theo ten");
            System.out.println("5. Them khach hang");
            System.out.println("6. Xoa khach hang");
            System.out.println("7. Sua thong tin khach hang");
            System.out.println("8. Thong ke theo ma khach hang");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dskh.nhapds();
                        break;
                    case 2:
                        dskh.xuatds();
                        break;
                    case 3:
                        System.out.print("Nhap ma khach hang can tim: ");
                        String makh = sc.nextLine();
                        khachhang kh = dskh.timKhachHang(makh);
                        if (kh != null) {
                            System.out.println("✅ Tim thay khach hang:");
                            System.out.printf("%-10s %-10s %-10s %-15s %-10s %-20s %-15s\n",
                                    "MaKH", "Ho", "Ten", "NgaySinh", "GioiTinh", "DiaChi", "SDT");
                            kh.xuat();
                        } else {
                            System.out.println("❌ Khong tim thay khach hang co ma: " + makh);
                        }
                        break;
                    case 4:
                        System.out.print("Nhap ten khach hang can tim: ");
                        String ten = sc.nextLine();
                        dskh.timKhachTheoTen(ten);
                        break;
                    case 5:
                        khachhang khMoi = new khachhang();
                        khMoi.nhap();
                        dskh.themKhachHang(khMoi);
                        break;
                    case 6:
                        System.out.print("Nhap ma khach hang can xoa: ");
                        dskh.xoaKhachHang(sc.nextLine());
                        break;
                    case 7:
                        dskh.suaKhachHang();
                        break;
                    case 8:
                        dskh.thongKeMaKH();
                        break;
                    case 0:
                        System.out.println("⬅ Quay lai menu chinh...");
                        break;
                    default:
                        System.out.println("❌ Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyTour() {
        int chon;
        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║       QUAN LY TOUR DU LICH            ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Quan ly danh sach tour");
            System.out.println("2. Quan ly ke hoach tour");
            System.out.println("3. Quan ly chi tiet ke hoach tour");
            System.out.println("4. Quan ly hop dong");
            System.out.println("5. Quan ly hoa don");
            System.out.println("6. Thong ke doanh thu");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        quanLyDanhSachTour();
                        break;
                    case 2:
                        quanLyKeHoachTour();
                        break;
                    case 3:
                        quanLyChiTietKeHoachTour();
                        break;
                    case 4:
                        quanLyHopDong();
                        break;
                    case 5:
                        quanLyHoaDon();
                        break;
                    case 6:
                        thongKeDoanhThu();
                        break;
                    case 0:
                        System.out.println("⬅ Quay lai menu chinh...");
                        break;
                    default:
                        System.out.println("❌ Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyDanhSachTour() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY DANH SACH TOUR =====");
            System.out.println("1. Nhap danh sach tour");
            System.out.println("2. Xuat danh sach tour");
            System.out.println("3. Tim kiem tour theo ma");
            System.out.println("4. Tim kiem tour theo ten");
            System.out.println("5. Them tour");
            System.out.println("6. Xoa tour");
            System.out.println("7. Sua thong tin tour");
            System.out.println("8. Thong ke theo loai tour");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dst.nhapDstour();
                        break;
                    case 2:
                        dst.xuatDstour();
                        break;
                    case 3:
                        System.out.print("Nhap ma tour can tim: ");
                        dst.timTheoMaTour(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Nhap ten tour can tim: ");
                        dst.timTheoTenTour(sc.nextLine());
                        break;
                    case 5:
                        System.out.println("Chon loai tour (1-Trong nuoc, 2-Nuoc ngoai): ");
                        int loai = Integer.parseInt(sc.nextLine());
                        tour t = loai == 1 ? new tourtrongnuoc() : new tournuocngoai();
                        t.nhap();
                        dst.themTourCoTs(t);
                        break;
                    case 6:
                        System.out.print("Nhap ma tour can xoa: ");
                        dst.xoaTourCoTs(sc.nextLine());
                        break;
                    case 7:
                        dst.suaTour();
                        break;
                    case 8:
                        dst.thongKeTheoLoaiTour();
                        break;
                    case 0:
                        System.out.println("⬅ Quay lai...");
                        break;
                    default:
                        System.out.println("❌ Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyKeHoachTour() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY KE HOACH TOUR =====");
            System.out.println("1. Nhap ke hoach tour");
            System.out.println("2. Xuat ke hoach tour");
            System.out.println("3. Tim kiem ke hoach tour");
            System.out.println("4. Them ke hoach tour");
            System.out.println("5. Xoa ke hoach tour");
            System.out.println("6. Sua ke hoach tour");
            System.out.println("7. Thong ke theo ma tour");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dskht.nhapDsKHT();
                        break;
                    case 2:
                        dskht.xuatDsKHT();
                        break;
                    case 3:
                        System.out.print("Nhap ma ke hoach tour can tim: ");
                        kehoachtour kht = dskht.timKHT(sc.nextLine());
                        if (kht != null) {
                            System.out.println("✅ Tim thay ke hoach tour:");
                            System.out.printf("%-10s %-10s %-12s %-12s %-8s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                                    "MaKHT", "MaTour", "Ngay di", "Ngay ve", "Don gia", "Tong ve",
                                    "Ve con", "Tong chi", "An", "O", "Di lai", "MaHDV");
                            kht.xuat();
                        } else {
                            System.out.println("❌ Khong tim thay ke hoach tour");
                        }
                        break;
                    case 4:
                        kehoachtour kht1 = new kehoachtour();
                        kht1.nhap();
                        dskht.themKHTCoTs(kht1);
                        break;
                    case 5:
                        System.out.print("Nhap ma ke hoach tour can xoa: ");
                        dskht.xoaKHTCoTs(sc.nextLine());
                        break;
                    case 6:
                        dskht.suaKHT();
                        break;
                    case 7:
                        dskht.thongKeTheoMaTour();
                        break;
                    case 0:
                        System.out.println("⬅ Quay lai...");
                        break;
                    default:
                        System.out.println("❌ Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyChiTietKeHoachTour() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY CHI TIET KE HOACH TOUR =====");
            System.out.println("1. Nhap chi tiet ke hoach tour");
            System.out.println("2. Xuat chi tiet ke hoach tour");
            System.out.println("3. Tim kiem theo ma ke hoach tour");
            System.out.println("4. Tim kiem theo ngay chi");
            System.out.println("5. Them chi tiet ke hoach tour");
            System.out.println("6. Xoa chi tiet ke hoach tour");
            System.out.println("7. Sua chi tiet ke hoach tour");
            System.out.println("8. Thong ke theo ma");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dsctkht.nhapds();
                        break;
                    case 2:
                        dsctkht.xuatds();
                        break;
                    case 3:
                        System.out.print("Nhap ma ke hoach tour can tim: ");
                        ctkhtour ct = dsctkht.timCots(sc.nextLine());
                        if (ct != null) {
                            System.out.println("✅ Tim thay chi tiet ke hoach tour:");
                            System.out.printf("%-15s %-15s %-15s %-15s%n", "Ma KH Tour", "Ngay Chi", "Tien An", "Tien O");
                            ct.xuat();
                        } else {
                            System.out.println("❌ Khong tim thay chi tiet ke hoach tour");
                        }
                        break;
                    case 4:
                        System.out.print("Nhap ngay chi can tim: ");
                        dsctkht.timTheoNgayChi(sc.nextLine());
                        break;
                    case 5:
                        ctkhtour ctMoi = new ctkhtour();
                        ctMoi.nhap();
                        dsctkht.themCots(ctMoi);
                        break;
                    case 6:
                        System.out.print("Nhap ma ke hoach tour can xoa: ");
                        dsctkht.xoaCots(sc.nextLine());
                        break;
                    case 7:
                        dsctkht.suaKhtour();
                        break;
                    case 8:
                        dsctkht.thongKeTheoMa();
                        break;
                    case 0:
                        System.out.println("⬅ Quay lai...");
                        break;
                    default:
                        System.out.println("❌ Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyHopDong() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY HOP DONG =====");
            System.out.println("1. Nhap danh sach hop dong");
            System.out.println("2. Xuat danh sach hop dong");
            System.out.println("3. Tim kiem hop dong theo ma");
            System.out.println("4. Tim kiem hop dong theo ma tour");
            System.out.println("5. Them hop dong");
            System.out.println("6. Xoa hop dong");
            System.out.println("7. Sua hop dong");
            System.out.println("8. Thong ke theo ma tour");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dshd.nhapDshopdong();
                        break;
                    case 2:
                        dshd.xuatDshopdong();
                        break;
                    case 3:
                        System.out.print("Nhap ma hop dong can tim: ");
                        hopdong hd = dshd.timHopDong(sc.nextLine());
                        if (hd != null) {
                            System.out.println("✅ Tim thay hop dong:");
                            System.out.printf("%-15s %-15s %-15s %-15s\n", "Ma HD", "Ma tour", "Ma KH", "Dieu khoan");
                            hd.xuat();
                        } else {
                            System.out.println("❌ Khong tim thay hop dong");
                        }
                        break;
                    case 4:
                        System.out.print("Nhap ma tour can tim: ");
                        dshd.timTheoMaTour(sc.nextLine());
                        break;
                    case 5:
                        hopdong hdMoi = new hopdong();
                        hdMoi.nhap();
                        dshd.themHopDongCots(hdMoi);
                        break;
                    case 6:
                        System.out.print("Nhap ma hop dong can xoa: ");
                        dshd.xoaHopDongCots(sc.nextLine());
                        break;
                    case 7:
                        dshd.suaHopDong();
                        break;
                    case 8:
                        dshd.thongKeTheoMaTour();
                        break;
                    case 0:
                        System.out.println("⬅ Quay lai...");
                        break;
                    default:
                        System.out.println("❌ Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyHoaDon() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY HOA DON =====");
            System.out.println("1. Nhap danh sach hoa don");
            System.out.println("2. Xuat danh sach hoa don");
            System.out.println("3. Tim kiem hoa don theo ma");
            System.out.println("4. Tim kiem hoa don theo ma khach hang");
            System.out.println("5. Them hoa don");
            System.out.println("6. Xoa hoa don");
            System.out.println("7. Sua hoa don");
            System.out.println("8. Thong ke theo ma khach hang");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dshoadon.nhapDsHD();
                        break;
                    case 2:
                        dshoadon.xuatDsHD();
                        break;
                    case 3:
                        System.out.print("Nhap ma hoa don can tim: ");
                        hoadon hd = dshoadon.timHD(sc.nextLine());
                        if (hd != null) {
                            System.out.println("✅ Tim thay hoa don:");
                            System.out.printf("%-10s %-10s %-12s %-10s\n", "MaHD", "MaKH", "MaKHTour", "TongTien");
                            hd.xuat();
                        } else {
                            System.out.println("❌ Khong tim thay hoa don");
                        }
                        break;
                    case 4:
                        System.out.print("Nhap ma khach hang can tim: ");
                        dshoadon.timTheoMaKH(sc.nextLine());
                        break;
                    case 5:
                        hoadon hd1 = new hoadon();
                        hd1.nhap();
                        dshoadon.themHDCoTs(hd1);
                        break;
                    case 6:
                        System.out.print("Nhap ma hoa don can xoa: ");
                        dshoadon.xoaHDCoTs(sc.nextLine());
                        break;
                    case 7:
                        dshoadon.suaHD();
                        break;
                    case 8:
                        dshoadon.thongKeTheoMaKH();
                        break;
                    case 0:
                        System.out.println("⬅ Quay lai...");
                        break;
                    default:
                        System.out.println("❌ Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void thongKeDoanhThu() {
        int chon;
        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║       THONG KE DOANH THU              ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Thong ke doanh thu theo tour");
            System.out.println("2. Thong ke doanh thu theo khach hang");
            System.out.println("3. Thong ke chi phi theo ke hoach tour");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        System.out.println("\n=== THONG KE DOANH THU THEO TOUR ===");
                        dskht.thongKeTheoMaTour();
                        break;
                    case 2:
                        System.out.println("\n=== THONG KE DOANH THU THEO KHACH HANG ===");
                        dshoadon.thongKeTheoMaKH();
                        break;
                    case 3:
                        System.out.println("\n=== THONG KE CHI PHI THEO KE HOACH TOUR ===");
                        System.out.print("Nhap ma ke hoach tour: ");
                        String maKHT = sc.nextLine();
                        kehoachtour kht = dskht.timKHT(maKHT);
                        if (kht != null) {
                            kht.thongKeTienTheoNgay();
                        } else {
                            System.out.println("❌ Khong tim thay ke hoach tour!");
                        }
                        break;
                    case 0:
                        System.out.println("⬅ Quay lai...");
                        break;
                    default:
                        System.out.println("❌ Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }
}