import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class dskehoachtour {
    private kehoachtour[] ds;
    private int N;
    private Scanner sc = new Scanner(System.in);

    public dskehoachtour() {
        N = 0;
        ds = new kehoachtour[0];
    }

    public dskehoachtour(kehoachtour[] ds, int N) {
        this.ds = ds;
        this.N = N;
    }

    public dskehoachtour(dskehoachtour dskht) {
        this.ds = dskht.ds;
        this.N = dskht.N;
    }

    public kehoachtour[] getDs() {
        return ds;
    }

    public int getN() {
        return N;
    }

    public void setDs(kehoachtour[] ds) {
        this.ds = ds;
    }

    public void setN(int N) {
        this.N = N;
    }

    public void nhapDsKHT() {
        System.out.print("Nhap so luong ke hoach tour: ");
        N = Integer.parseInt(sc.nextLine());
        ds = new kehoachtour[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Nhap ke hoach tour thu " + (i + 1) + ": ");
            ds[i] = new kehoachtour();
            ds[i].nhap();
        }
        N = ds.length;
    }

    public void xuatDsKHT() {
        System.out.printf("%-10s %-10s %-12s %-12s %-8s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "MaKHT", "MaTour", "Ngay di", "Ngay ve", "Don gia", "Tong ve",
                "Ve con", "Tong chi", "An", "O", "Di lai", "MaHDV");
        for (int i = 0; i < N; i++) {
            ds[i].xuat();
        }
    }

    public int timTheoMa(String makhtour) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getMakhtour().equalsIgnoreCase(makhtour)) {
                return i;
            }
        }
        return -1;
    }

    public kehoachtour timKHT(String makhtour) {
        int vt = timTheoMa(makhtour);
        if (vt == -1) {
            return null;
        }
        return ds[vt];
    }

    public void timTheoMaTour(String matour) {
        boolean found = false;
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Ma HD", "Ma tour", "Ma KH", "Dieu khoan");
        for (int i = 0; i < N; i++) {
            if (ds[i].getMatour().equalsIgnoreCase(matour)) {
                ds[i].xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Khong co hop dong nao thuoc tour co ma: " + matour);
        }
    }

    public void themKHTCoTs(kehoachtour k) {
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = new kehoachtour(k);
        N++;
        System.out.println("✅ Da them ke hoach tour (tham so) thanh cong!");
    }

    public void xoaKHTCoTs(String makhtour) {
        int idx = timTheoMa(makhtour);
        if (idx == -1) {
            System.out.println("❌ Khong tim thay ke hoach tour co ma: " + makhtour);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println("✅ Da xoa ke hoach tour co ma: " + makhtour);
    }

    public void thongKeTheoMaTour() {
        if (N == 0) {
            System.out.println("❌ Danh sach ke hoach tour rong!");
            return;
        }

        System.out.print("Nhap ma tour can thong ke: ");
        String matour = sc.nextLine();

        int dem = 0;
        long tongDoanhThu = 0;

        System.out.printf("%-10s %-10s %-12s %-12s %-8s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "MaKHT", "MaTour", "Ngay di", "Ngay ve", "Don gia", "Tong ve",
                "Ve con", "Tong chi", "An", "O", "Di lai", "MaHDV");

        for (int i = 0; i < N; i++) {
            if (ds[i].getMatour().equalsIgnoreCase(matour)) {
                ds[i].xuat();
                dem++;
                tongDoanhThu += (long) ds[i].getDongia() * ds[i].getTongsove();
            }
        }

        if (dem == 0) {
            System.out.println("❌ Khong co ke hoach tour nao thuoc tour co ma: " + matour);
        } else {
            System.out.println("✅ Tong so ke hoach tour cua ma tour '" + matour + "': " + dem);
            System.out.println("💰 Tong doanh thu du kien: " + tongDoanhThu);
        }
    }

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
    public void docFile(String file){
        try {
        FileInputStream fis=new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        int n=0;
        ds= new kehoachtour[n];
        
        String line;
        while((line = br.readLine())!=null){
            String[] part=line.split(",");

            if(part.length>=12){
                String ma=part[0];
                String mat=part[1];
                LocalDate ngaydi=LocalDate.parse(part[2]);
                LocalDate ngayve=LocalDate.parse(part[3]);
                int dongia=Integer.parseInt(part[4]);
                int tongsove=Integer.parseInt(part[5]);
                int soveconlai= Integer.parseInt(part[6]);
                int tongchi=Integer.parseInt(part[7]);
                int tongan=Integer.parseInt(part[8]);
                int tongo=Integer.parseInt(part[9]);
                int tongdilai=Integer.parseInt(part[10]);
                String mahdv=part[11];
                int tongtienve=Integer.parseInt(part[12]);
                
                ds[n++]=new kehoachtour(ma,mat,ngaydi,ngayve,dongia,tongsove,soveconlai,tongchi,tongan,tongo,tongdilai,tongtienve,mahdv);
            }
        }
        br.close();
            N=n;
            ds=Arrays.copyOf(ds,N);
        System.out.println("Da doc "+N+" ke hoach tour tu file "+file);
        } catch(Exception e){
            System.out.println("Loi khong doc duoc file"+e.getMessage());
            e.printStackTrace();
        }
    }
    public void ghiFile(String file){
        try {
            BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for(int i=0;i<N;i++){
                kehoachtour k=ds[i];
                String line="";
                
                line=String.join(",",
                k.getMakhtour(),
                k.getMatour(),
                String.valueOf(k.getNgaydi()),
                String.valueOf(k.getNgayve()),
                String.valueOf(k.getDongia()),
                String.valueOf(k.getTongsove()),
                String.valueOf(k.getSoveconlai()),
                String.valueOf(k.getTongchi()),
                String.valueOf(k.getTongan()),
                String.valueOf(k.getTongo()),
                String.valueOf(k.getTongdilai()),
                k.getMahdv());

                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Da ghi "+N+" ke hoach tour vao file "+file);
        } catch(Exception e){
            System.out.println("Loi ghi fiel "+e.getMessage());
            e.printStackTrace();
        }
    }
}
