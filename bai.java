import java.util.Scanner;

public class bai {
    public static void main(String[] args) {
        dsHDV dshdv = new dsHDV(); // tạo danh sách HDV
        danhsachkhachhang danhsachkhachhang = new danhsachkhachhang();
        dstour dst = new dstour() {  };
        Scanner sc = new Scanner(System.in);
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
                                    danhsachkhachhang.nhapds();
                                    break;
                                case 2:
                                    danhsachkhachhang.xuatds();
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
                                    dskehoachtour dskht = new dskehoachtour();
                                    dskht.nhapDsKHT();
                                    dskht.xuatDsKHT();
                                    break;
                                }
                                case 4: {
                                    dsctkhtour dsctkhtour = new dsctkhtour();
                                    dsctkhtour.nhapds();
                                    dsctkhtour.xuatds();
                                    break;
                                }
                                case 5: {
                                    dshopdong dsHopDong = new dshopdong();
                                    dsHopDong.nhapDshopdong();
                                    dsHopDong.xuatDshopdong();
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
}