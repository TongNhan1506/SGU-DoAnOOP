import java.util.Scanner;
import java.util.Arrays;

class dsctkhtour {
    private ctkhtour[] ds;
    private int n = 0;
    Scanner sc = new Scanner(System.in);

    
    public dsctkhtour() {
        ds = new ctkhtour[100];
        n = 0;
    }

    public dsctkhtour(ctkhtour[] ds, int n) {
        this.ds = ds;
        this.n = n;
    }

    public dsctkhtour(dsctkhtour dsct) {
        this.ds = dsct.ds;
        this.n = dsct.n;
    }

  
    public ctkhtour[] getDs() {
        return ds;
    }

    public int getN() {
        return n;
    }

    public void setDs(ctkhtour[] ds) {
        this.ds = ds;
    }

    public void setN(int n) {
        this.n = n;
    }

   
    public void nhapds() {
        System.out.print("Nhap so luong chi tiet ke hoach tour: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new ctkhtour[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap chi tiet ke hoach tour thu " + (i + 1) + ":");
            ds[i] = new ctkhtour();
            ds[i].nhap();
        }
    }

    public void xuatds() {
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Ma KH Tour", "Ngay Chi", "Tien An", "Tien O");
        for (int i = 0; i < n; i++) {
            ds[i].xuat();
        }
    }

  
    public int timTheoMa(String makhtour) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakhtour().equals(makhtour)) {
                return i;
            }
        }
        return -1;
    }

   
    public ctkhtour timCots(String makhtour) {
        int idx = timTheoMa(makhtour);
        if (idx != -1)
            return ds[idx];
        return null;
    }

 
public void timTheoNgayChi(String ngaychi) {
    boolean found = false;
    System.out.println("\n=== KET QUA TIM KIEM THEO NGAY CHI: " + ngaychi + " ===");
    System.out.printf("%-15s %-15s %-15s %-15s%n", "Ma KH Tour", "Ngay Chi", "Tien An", "Tien O");

    for (int i = 0; i < n; i++) {
        if (ds[i].getNgaychi().equalsIgnoreCase(ngaychi)) {
            ds[i].xuat();
            found = true;
        }
    }

    if (!found) {
        System.out.println("❌ Khong tim thay ke hoach tour nao co ngay chi: " + ngaychi);
    }
}


   
    public void themCots(ctkhtour k) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new ctkhtour(k);
        n++;
        System.out.println("✅ Da them ke hoach tour moi (co tham so).");
    }


    
    public void xoaCots(String makhtour) {
        int idx = timTheoMa(makhtour);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay ke hoach tour de xoa!");
            return;
        }

        for (int i = idx; i < n - 1; i++) {
            ds[i] = ds[i + 1];
        }

        ds = Arrays.copyOf(ds, n - 1);
        n--;
        System.out.println("✅ Da xoa ke hoach tour co ma: " + makhtour);
    }



public void thongKeTheoMa() {
    if (n == 0) {
        System.out.println("❌ Danh sach ke hoach tour rong!");
        return;
    }

    System.out.print("Nhap ma ke hoach tour can thong ke: ");
    String makhtour = sc.nextLine();
    int count = 0;

    for (int i = 0; i < n; i++) {
        if (ds[i].getMakhtour().equalsIgnoreCase(makhtour)) {
            count++;
        }
    }

    if (count == 0) {
        System.out.println("❌ Khong tim thay ke hoach tour co ma: " + makhtour);
    } else {
        System.out.println("✅ Ma ke hoach tour '" + makhtour + "' xuat hien " + count + " lan trong danh sach.");
    }
}


   
    public void suaKhtour() {
        System.out.print("Nhap ma ke hoach tour can sua: ");
        String makhtour = sc.nextLine();
        int idx = timTheoMa(makhtour);

        if (idx == -1) {
            System.out.println("❌ Khong tim thay ke hoach tour co ma: " + makhtour);
            return;
        }


        

        ctkhtour k = ds[idx];
        int chon;
        do {
            System.out.println("\n=== CHON MUC CAN SUA ===");
            System.out.println("1. Ngay chi");
            System.out.println("2. Tien an");
            System.out.println("3. Tien o");
            System.out.println("0. Thoat sua");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ngay chi moi: ");
                    k.setNgaychi(sc.nextLine());
                    System.out.println("✅ Da sua ngay chi!");
                    break;
                case 2:
                    System.out.print("Nhap tien an moi: ");
                    k.setTienan(sc.nextLine());
                    System.out.println("✅ Da sua tien an!");
                    break;
                case 3:
                    System.out.print("Nhap tien o moi: ");
                    k.setTieno(sc.nextLine());
                    System.out.println("✅ Da sua tien o!");
                    break;
                case 0:
                    System.out.println("Thoat sua thong tin.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
}
