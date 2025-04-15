public class SepedaGunung extends Sepeda {
    public SepedaGunung(int id, String jenis) {
        super(id, jenis, true);
    }

    @Override
    public void TampilkanInfo() {
        System.out.println("== Sepeda Gunung ==");
        super.TampilkanInfo();
    }
}
