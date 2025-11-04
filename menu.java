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
            System.out.println("\nCHUONG TRINH QUAN LY TOUR DU LICH");
            System.out.println("Chon cac chuc nang quan ly duoi day");
            System.out.println("1. Quan ly huong dan vien");
            System.out.println("2. Quan ly khach hang");
            System.out.println("3. Quan ly tour du lich");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Nhap lua chon cua ban: ");
            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1: {
                        int subChon;
                        do {
                            System.out.println("\n===== QUAN LY HUONG DAN VIEN =====");
                            System.out.println("1. Nhap danh sach HDV");
                            System.out.println("2. Xuat danh sach HDV");
                            System.out.println("0. Quay lai menu chinh");
                            System.out.print("Nhap lua chon cua ban: ");
                            subChon = Integer.parseInt(sc.nextLine());
                            
                            switch (subChon) {
                                case 1:
                                    dshdv.nhapDshdv();
                                    break;
                                case 2:
                                    dshdv.xuatDshdv();
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Lua chon khong hop le!");
                                    break;
                            }
                        } while (subChon != 0);
                        break;
                    }
                    case 2: {
                        int subChon;
                        do {
                            System.out.println("\n===== QUAN LY KHACH HANG =====");
                            System.out.println("1. Nhap khach hang");
                            System.out.println("2. Xuat khach hang");
                            System.out.println("0. Quay lai menu chinh");
                            System.out.print("Nhap lua chon cua ban: ");
                            subChon = Integer.parseInt(sc.nextLine());
                            
                            switch (subChon) {
                                case 1:
                                    dskh.nhapds();
                                    break;
                                case 2:
                                    dskh.xuatds();
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Lua chon khong hop le!");
                                    break;
                            }
                        } while (subChon != 0);
                        break;
                    }
                    case 3: {
                        int subChon;
                        do {
                            System.out.println("\n===== QUAN LY TOUR DU LICH =====");
                            System.out.println("1. Nhap danh sach tour");
                            System.out.println("2. Xuat danh sach tour");
                            System.out.println("3. Them chi tiet ke hoach tour");
                            System.out.println("4. Nhap chi tiet ke hoach tour");
                            System.out.println("5. Nhap hop dong");
                            System.out.println("6. Thong ke tien");
                            System.out.println("0. Quay lai menu chinh");
                            System.out.print("Nhap lua chon cua ban: ");
                            subChon = Integer.parseInt(sc.nextLine());
                            
                            switch (subChon) {
                                case 1:
                                    dst.nhapDstour();
                                    break;
                                case 2:
                                    dst.xuatDstour();
                                    break;
                                case 3: {
                                    dskht.nhapDsKHT();
                                    dskht.xuatDsKHT();
                                    break;
                                }
                                case 4: {
                                    dsctkht.nhapds();
                                    dsctkht.xuatds();
                                    break;
                                }
                                case 5: {
                                    dshd.nhapDshopdong();
                                    dshd.xuatDshopdong();
                                    break;
                                }
                                case 6:
                                    System.out.println("Chuc nang dang phat trien...");
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Lua chon khong hop le!");
                                    break;
                            }
                        } while (subChon != 0);
                        break;
                    }
                    case 0:
                        System.out.println("Cam on ban da su dung chuong trinh!");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
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

    public void quanLyHDV() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY HUONG DAN VIEN =====");
            System.out.println("1. Nhap danh sach HDV");
            System.out.println("2. Xuat danh sach HDV");
            System.out.println("3. Tim kiem HDV");
            System.out.println("4. Them HDV moi");
            System.out.println("5. Xoa HDV");
            System.out.println("6. Sua thong tin HDV");
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
                            System.out.println("Tim thay HDV:");
                            hdv.xuat();
                        } else {
                            System.out.println("Khong tim thay HDV co ma " + maHDV);
                        }
                        break;
                    case 4:
                        HDV hdvMoi = new HDV();
                        hdvMoi.nhap();
                        dshdv.themHDVCoTs(hdvMoi);
                        break;
                    case 5:
                        System.out.print("Nhap ma HDV can xoa: ");
                        dshdv.xoaHDVCoTs(sc.nextLine());
                        break;
                    case 6:
                        dshdv.suaHDV();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public void quanLyKhachHang() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY KHACH HANG =====");
            System.out.println("1. Nhap danh sach khach hang");
            System.out.println("2. Xuat danh sach khach hang");
            System.out.println("3. Tim kiem khach hang");
            System.out.println("4. Them khach hang");
            System.out.println("5. Xoa khach hang");
            System.out.println("6. Sua thong tin khach hang");
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
                        dskh.timKhachHang(sc.nextLine());
                        break;
                    case 4:
                        khachhang kh = new khachhang();
                        kh.nhap();
                        dskh.themKhachHang(kh);
                        break;
                    case 5:
                        System.out.print("Nhap ma khach hang can xoa: ");
                        dskh.xoaKhachHang(sc.nextLine());
                        break;
                    case 6:
                        dskh.suaKhachHang();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public void quanLyTour() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY TOUR DU LICH =====");
            System.out.println("1. Quan ly danh sach tour");
            System.out.println("2. Quan ly ke hoach tour");
            System.out.println("3. Quan ly hop dong");
            System.out.println("4. Quan ly hoa don");
            System.out.println("5. Thong ke doanh thu");
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
                        quanLyHopDong();
                        break;
                    case 4:
                        quanLyHoaDon();
                        break;
                    case 5:
                        thongKeDoanhThu();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public void quanLyDanhSachTour() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY DANH SACH TOUR =====");
            System.out.println("1. Nhap danh sach tour");
            System.out.println("2. Xuat danh sach tour");
            System.out.println("3. Tim kiem tour");
            System.out.println("4. Them tour");
            System.out.println("5. Xoa tour");
            System.out.println("6. Sua thong tin tour");
            System.out.println("7. Thong ke theo loai tour");
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
                        System.out.println("Chon loai tour (1-Trong nuoc, 2-Nuoc ngoai): ");
                        int loai = Integer.parseInt(sc.nextLine());
                        tour t = loai == 1 ? new tourtrongnuoc() : new tournuocngoai();
                        t.nhap();
                        dst.themTourCoTs(t);
                        break;
                    case 5:
                        System.out.print("Nhap ma tour can xoa: ");
                        dst.xoaTourCoTs(sc.nextLine());
                        break;
                    case 6:
                        dst.suaTour();
                        break;
                    case 7:
                        dst.thongKeTheoLoaiTour();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    private static void quanLyKeHoachTour() {
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
                            System.out.println("Tim thay ke hoach tour:");
                            kht.xuat();
                        } else {
                            System.out.println("Khong tim thay ke hoach tour");
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
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public void quanLyHopDong() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY HOP DONG =====");
            System.out.println("1. Nhap danh sach hop dong");
            System.out.println("2. Xuat danh sach hop dong");
            System.out.println("3. Tim kiem hop dong");
            System.out.println("4. Them hop dong");
            System.out.println("5. Xoa hop dong");
            System.out.println("6. Sua hop dong");
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
                        dshd.timHopDong(sc.nextLine());
                        break;
                    case 4:
                        hopdong hd = new hopdong();
                        hd.nhap();
                        dshd.themHopDongCots(hd);
                        break;
                    case 5:
                        System.out.print("Nhap ma hop dong can xoa: ");
                        dshd.xoaHopDongCots(sc.nextLine());
                        break;
                    case 6:
                        dshd.suaHopDong();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public void quanLyHoaDon() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY HOA DON =====");
            System.out.println("1. Nhap danh sach hoa don");
            System.out.println("2. Xuat danh sach hoa don");
            System.out.println("3. Tim kiem hoa don");
            System.out.println("4. Them hoa don");
            System.out.println("5. Xoa hoa don");
            System.out.println("6. Sua hoa don");
            System.out.println("7. Thong ke theo ma khach hang");
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
                            System.out.println("Tim thay hoa don:");
                            hd.xuat();
                        } else {
                            System.out.println("Khong tim thay hoa don");
                        }
                        break;
                    case 4:
                        hoadon hd1 = new hoadon();
                        hd1.nhap();
                        dshoadon.themHDCoTs(hd1);
                        break;
                    case 5:
                        System.out.print("Nhap ma hoa don can xoa: ");
                        dshoadon.xoaHDCoTs(sc.nextLine());
                        break;
                    case 6:
                        dshoadon.suaHD();
                        break;
                    case 7:
                        dshoadon.thongKeTheoMaKH();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public void thongKeDoanhThu() {
        int chon;
        do {
            System.out.println("\n===== THONG KE DOANH THU =====");
            System.out.println("1. Thong ke doanh thu theo tour");
            System.out.println("2. Thong ke doanh thu theo khach hang");
            System.out.println("3. Thong ke chi phi theo ke hoach tour");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        System.out.println("=== THONG KE DOANH THU THEO TOUR ===");
                        System.out.print("Nhap ma tour: ");
                        String maTour = sc.nextLine();
                        dskht.thongKeTheoMaTour();
                        break;
                    case 2:
                        System.out.println("=== THONG KE DOANH THU THEO KHACH HANG ===");
                        dshoadon.thongKeTheoMaKH();
                        break;
                    case 3:
                        System.out.println("=== THONG KE CHI PHI THEO KE HOACH TOUR ===");
                        System.out.print("Nhap ma ke hoach tour: ");
                        String maKHT = sc.nextLine();
                        kehoachtour kht = dskht.timKHT(maKHT);
                        if (kht != null) {
                            kht.thongKeTienTheoNgay();
                        } else {
                            System.out.println("Khong tim thay ke hoach tour!");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }
}