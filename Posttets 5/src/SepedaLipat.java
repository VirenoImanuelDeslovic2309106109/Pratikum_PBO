public final class SepedaLipat extends Sepeda {
    public SepedaLipat(int id, String jenis) {
        super(id, jenis, true);
    }

    @Override
    public void TampilkanInfo() {
        System.out.println("== Sepeda Lipat ==");
        super.TampilkanInfo();
    }

    @Override
    public String GetTipe() {
        return "Sepeda Lipat";
    }
}
