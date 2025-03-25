import java.util.ArrayList;

public class TransaksiPenyewaan {
    private int idTransaksi;
    private int idSepeda;
    private String penyewa;
    private boolean selesai;

    public TransaksiPenyewaan(int idTransaksi, int idSepeda, String penyewa, boolean selesai) {
        this.idTransaksi = idTransaksi;
        this.idSepeda = idSepeda;
        this.penyewa = penyewa;
        this.selesai = selesai;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public int getIdSepeda() {
        return idSepeda;
    }

    public String getPenyewa() {
        return penyewa;
    }

    public boolean isSelesai() {
        return selesai;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }
    
    public void setIdSepeda(int idSepeda) {
        this.idSepeda = idSepeda;
    }
    
    public void setPenyewa(String penyewa) {
        this.penyewa = penyewa;
    }    

    public void setSelesai(boolean selesai) {
        this.selesai = selesai;
    }

    public void tampilkanInfo() {
        System.out.println("ID Transaksi: " + idTransaksi + " | ID Sepeda: " + idSepeda + " | Penyewa: " + penyewa + " | Selesai: " + (selesai ? "Ya" : "Tidak"));
    }

    // Metode CRUD untuk Transaksi Penyewaan
    public static void tambahTransaksi(ArrayList<TransaksiPenyewaan> daftarTransaksi, ArrayList<Sepeda> daftarSepeda, int idTransaksi, int idSepeda, String penyewa) {
        for (Sepeda s : daftarSepeda) {
            if (s.getId() == idSepeda && s.isTersedia()) {
                daftarTransaksi.add(new TransaksiPenyewaan(idTransaksi, idSepeda, penyewa, false));
                s.setTersedia(false);
                System.out.println("Transaksi berhasil dibuat!");
                return;
            }
        }
        System.out.println("Sepeda tidak tersedia atau tidak ditemukan.");
    }

    public static void lihatSemuaTransaksi(ArrayList<TransaksiPenyewaan> daftarTransaksi) {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Tidak ada transaksi penyewaan.");
            return;
        }
        for (TransaksiPenyewaan t : daftarTransaksi) {
            t.tampilkanInfo();
        }
    }

    public static void perbaruiTransaksi(ArrayList<TransaksiPenyewaan> daftarTransaksi, ArrayList<Sepeda> daftarSepeda, int id) {
        for (TransaksiPenyewaan t : daftarTransaksi) {
            if (t.getIdTransaksi() == id) {
                t.setSelesai(true);
                for (Sepeda s : daftarSepeda) {
                    if (s.getId() == t.getIdSepeda()) {
                        s.setTersedia(true);
                        break;
                    }
                }
                System.out.println("Transaksi berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Transaksi tidak ditemukan.");
    }
    public static void hapusTransaksi(ArrayList<TransaksiPenyewaan> daftarTransaksi, int id) {
        daftarTransaksi.removeIf(t -> t.idTransaksi == id);
        System.out.println("Transaksi berhasil dihapus!");
    }
}
