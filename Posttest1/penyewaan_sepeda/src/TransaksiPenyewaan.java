import java.util.ArrayList;

public class TransaksiPenyewaan {
    int idTransaksi;
    int idSepeda;
    String penyewa;
    boolean selesai;

    public TransaksiPenyewaan(int idTransaksi, int idSepeda, String penyewa, boolean selesai) {
        this.idTransaksi = idTransaksi;
        this.idSepeda = idSepeda;
        this.penyewa = penyewa;
        this.selesai = selesai;
    }

    public void tampilkanInfo() {
        System.out.println("ID Transaksi: " + idTransaksi + " | ID Sepeda: " + idSepeda + " | Penyewa: " + penyewa + " | Selesai: " + (selesai ? "Ya" : "Tidak"));
    }

    // Metode CRUD untuk Transaksi Penyewaan
    public static void tambahTransaksi(ArrayList<TransaksiPenyewaan> daftarTransaksi, ArrayList<Sepeda> daftarSepeda, int idTransaksi, int idSepeda, String penyewa) {
        for (Sepeda s : daftarSepeda) {
            if (s.id == idSepeda && s.tersedia) {
                daftarTransaksi.add(new TransaksiPenyewaan(idTransaksi, idSepeda, penyewa, false));
                s.tersedia = false;
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
            if (t.idTransaksi == id) {
                t.selesai = true;
                for (Sepeda s : daftarSepeda) {
                    if (s.id == t.idSepeda) {
                        s.tersedia = true;
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
