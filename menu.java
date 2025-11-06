import java.util.Scanner;

public class menu {
    private static Scanner sc = new Scanner(System.in);
    private static dscthoadon dscthd=new dscthoadon();
    private static dsHDV dshdv = new dsHDV();
    private static dskhachhang dskh = new dskhachhang();
    private static dstour dst = new dstour();
    private static dskehoachtour dskht = new dskehoachtour();
    private static dsctkhtour dsctkt = new dsctkhtour();
    private static dshopdong dshd = new dshopdong();
    private static dshoadon dshoadon = new dshoadon();
    private static dsdanhgiatour dsdgt=new dsdanhgiatour();
    private static dsnhahang dsnh=new dsnhahang();

    private static void loaddulieu(){
        dst.docFile("dstour.txt");
        dsctkt.docFile("dsctkhtour.txt");
        dshd.docFile("dshopdong.txt");
        dshoadon.docFile("dshoadon.txt");
        dskht.docFile("dskehoachtour.txt");
        dskh.docFile("dskhachhang.txt");
        dshdv.docFile("dshdv.txt");
        dscthd.docFile("dscthoadon.txt");
        dsdgt.docFile("dsdanhgiatour.txt");
        dsnh.docFile("dsnhahang.txt");
    }

    public static void main(String[] args) {
        khoiTao();
        loaddulieu();
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
                        quanLyHDV();
                        break;
                    }
                    case 2: {
                        quanLyKhachHang();
                        break;
                    }
                    case 3: {
                        quanLyTour();
                        break;
                    }
                    case 4:{
                        quanLyHoaDon();
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

    private static void khoiTao() {
        dshdv = new dsHDV();
        dskh = new dskhachhang();
        dst = new dstour() {};
        dskht = new dskehoachtour();
        dsctkt = new dsctkhtour();
        dshd = new dshopdong();
        dshoadon = new dshoadon();
    }

    private static void quanLyHDV() {
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

    private static void quanLyKhachHang() {
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

    private static void quanLyTour() {
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

    private static void quanLyDanhSachTour() {
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
                        dskht.thongketheosove();
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

    private static void quanLyHopDong() {
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

    private static void quanLyHoaDon() {
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
                        for(int i=0;i<dshoadon.getN();i++){
                            hoadon hd=dshoadon.getDs()[i];
                            capnhatsove(hd.getMakhtour(),hd.getSove());
                        }
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
                        if(dshoadon.timHD(hd1.getMahd())!=null){
                            System.out.println(" Ma hoa don da ton tai, khong the them!");
                            break;
                        }
                        dshoadon.themHDCoTs(hd1);
                        capnhatsove(hd1.getMakhtour(),hd1.getSove());
                        dshoadon.ghiFile("dshoadon.txt");
                        dskht.ghiFile("dskehoachtour.txt");
                        break;
                    case 5:
                        System.out.print("Nhap ma hoa don can xoa: ");
                        String mahoadon=sc.nextLine();
                        dshoadon.xoaHDCoTs(mahoadon);
                        capnhatsovekhisua(mahoadon);
                        dskht.ghiFile("dskehoachtour.txt");
                        dshoadon.ghiFile("dshoadon.txt");
                        break;
                    case 6:
                        System.out.print("Nhap ma hoa don can sua: ");
                        String mhd = sc.nextLine();
                        dshoadon.suaHD(mhd);
                        capnhatsovekhisua(mhd);
                        dshoadon.ghiFile("dshoadon.txt");
                        dskht.ghiFile("dskehoachtour.txt");
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

    private static void thongKeDoanhThu() {
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
    public static void capnhatsove(String makhtour,int sove){
        for(int i=0;i<dskht.getN();i++){
            if(dskht.getDs()[i].getMakhtour().equalsIgnoreCase(makhtour)){
                int soveconlai=dskht.getDs()[i].getSoveconlai();
                dskht.getDs()[i].setSoveconlai(soveconlai - sove);
            }
        }
    }    public static void capnhatsovekhisua(String mahoadon){
        for(int i=0;i<dskht.getN();i++){
            String makhtour=dskht.getDs()[i].getMakhtour();
            int sovebanduoc=0;
            for(int j=0;j<dshoadon.getN();j++){
                String mahd=dshoadon.getDs()[i].getMahd();
                if(dshoadon.getDs()[j].getMakhtour().equalsIgnoreCase(makhtour) && mahd==mahoadon){
                    sovebanduoc+=dshoadon.getDs()[j].getSove();
                }
            }
            int tongsove=dskht.getDs()[i].getSoveconlai();
            dskht.getDs()[i].setSoveconlai(tongsove - sovebanduoc);
        }
    }
}