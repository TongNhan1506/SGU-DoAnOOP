public class tourtrongnuoc extends tour {
    private String tinhthanh;
    private String dacsan;

    public tourtrongnuoc() {
    }

    public tourtrongnuoc(String matour, String tentour, int dongia, String thutuc, String diadiemKH,String diadiemden, String tinhthanh, String dacsan) {
        super(matour, tentour, dongia, thutuc, diadiemKH,diadiemden);
        this.tinhthanh = tinhthanh;
        this.dacsan = dacsan;
    }

    public tourtrongnuoc(tourtrongnuoc ttnn) {
        super(ttnn);
        this.tinhthanh = ttnn.tinhthanh;
        this.dacsan = ttnn.dacsan;
    }

    public String getTinhthanh() {
        return tinhthanh;
    }

    public String getDacsan() {
        return dacsan;
    }

    public void setTinhthanh(String tinhthanh) {
        this.tinhthanh = tinhthanh;
    }

    public void setDacsan(String dacsan) {
        this.dacsan = dacsan;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.println("Nhap tinh thanh: ");
        tinhthanh = sc.nextLine();
        System.out.println("Nhap dac san: ");
        dacsan = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-15s %-15s\n", tinhthanh, dacsan);
    }
}