import java.util.Scanner;

class nhahang {
    private String manh;      
    private String tennh;
    private String diachi;
    private String sodt;
    private String makhtour;

    public nhahang() {
    }

    public nhahang(String manh, String tennh, String diachi, String sodt, String makhtour) {
        this.manh = manh;
        this.tennh = tennh;
        this.diachi = diachi;
        this.sodt = sodt;
        this.makhtour = makhtour;
    }

   
    public nhahang(nhahang nh) {
        this.manh = nh.manh;
        this.tennh = nh.tennh;
        this.diachi = nh.diachi;
        this.sodt = nh.sodt;
        this.makhtour = nh.makhtour;
    }

    
    public String getManh() {
        return manh;
    }

    public String getTennh() {
        return tennh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getSodt() {
        return sodt;
    }

    public String getMakhtour() {
        return makhtour;
    }

  
    public void setManh(String manh) {
        this.manh = manh;
    }

    public void setTennh(String tennh) {
        this.tennh = tennh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public void setMakhtour(String makhtour) {
        this.makhtour = makhtour;
    }

    Scanner sc = new Scanner(System.in);

    
    public void nhap() {
        System.out.print("Nhap ma nha hang: ");
        manh = sc.nextLine();
        System.out.print("Nhap ten nha hang: ");
        tennh = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diachi = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        sodt = sc.nextLine();
        System.out.print("Nhap ma ke hoach tour (khoa ngoai): ");
        makhtour = sc.nextLine();
    }

    
    public void xuat() {
        System.out.printf("%-15s %-20s %-25s %-15s %-15s\n", manh, tennh, diachi, sodt, makhtour);
    }
    
}
