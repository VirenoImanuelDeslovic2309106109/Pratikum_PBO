import java.util.ArrayList;

public class TransaksiPenyewaan implements InfoTampilan {
    private final int idTransaksi;
    private int idSepeda;
    private String penyewa;
    private boolean selesai;

    private static int jumlahTransaksiSelesai = 0;

    public TransaksiPenyewaan(int idTransaksi, int idSepeda, String penyewa, boolean selesai) {
        this.idTransaksi = idTransaksi;
        this.idSepeda = idSepeda;
        this.penyewa = penyewa;
        this.selesai = selesai;
    }

    public int GetIdTransaksi() { return idTransaksi; }
    public int GetIdSepeda() { return idSepeda; }
    public String GetPenyewa() { return penyewa; }
    public boolean IsSelesai() { return selesai; }

    public void SetIdSepeda(int idSepeda) { this.idSepeda = idSepeda; }
    public void SetPenyewa(String penyewa) { this.penyewa = penyewa; }
    public void SetSelesai(boolean selesai) { this.selesai = selesai; }

    public static int GetJumlahTransaksiSelesai() {
        return jumlahTransaksiSelesai;
    }

    @Override
    public void TampilkanInfo() {
        System.out.println("ID Transaksi: " + idTransaksi + " | ID Sepeda: " + idSepeda + " | Penyewa: " + penyewa + " | Selesai: " + (selesai ? "Ya" : "Tidak"));
    }

    @Override
    public String GetDeskripsi() {
        return "Transaksi ID: " + idTransaksi + " oleh " + penyewa;
    }

    public static void TambahTransaksi(ArrayList<TransaksiPenyewaan> daftarTransaksi, ArrayList<Sepeda> daftarSepeda, int idTransaksi, int idSepeda, String penyewa, boolean langsungSelesai) {
        for (Sepeda s : daftarSepeda) {
            if (s.GetId() == idSepeda && s.IsTersedia()) {
                daftarTransaksi.add(new TransaksiPenyewaan(idTransaksi, idSepeda, penyewa, langsungSelesai));
                s.SetTersedia(!langsungSelesai);
                if (langsungSelesai) jumlahTransaksiSelesai++;
                System.out.println("Transaksi (langsung selesai: " + langsungSelesai + ") berhasil dibuat!");
                return;
            }
        }
        System.out.println("Sepeda tidak tersedia atau tidak ditemukan.");
    }

    public static void TambahTransaksi(ArrayList<TransaksiPenyewaan> daftarTransaksi, ArrayList<Sepeda> daftarSepeda, int idTransaksi, int idSepeda, String penyewa) {
        TambahTransaksi(daftarTransaksi, daftarSepeda, idTransaksi, idSepeda, penyewa, false);
    }

    public static void LihatSemuaTransaksi(ArrayList<TransaksiPenyewaan> daftarTransaksi) {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Tidak ada transaksi penyewaan.");
            return;
        }
        for (TransaksiPenyewaan t : daftarTransaksi) {
            t.TampilkanInfo();
        }
    }

    public static void PerbaruiTransaksi(ArrayList<TransaksiPenyewaan> daftarTransaksi, ArrayList<Sepeda> daftarSepeda, int id) {
        for (TransaksiPenyewaan t : daftarTransaksi) {
            if (t.GetIdTransaksi() == id) {
                if (!t.IsSelesai()) {
                    t.SetSelesai(true);
                    jumlahTransaksiSelesai++;
                    for (Sepeda s : daftarSepeda) {
                        if (s.GetId() == t.GetIdSepeda()) {
                            s.SetTersedia(true);
                            break;
                        }
                    }
                    System.out.println("Transaksi berhasil diperbarui!");
                } else {
                    System.out.println("Transaksi sudah selesai sebelumnya.");
                }
                return;
            }
        }
        System.out.println("Transaksi tidak ditemukan.");
    }

    public static void HapusTransaksi(ArrayList<TransaksiPenyewaan> daftarTransaksi, int id) {
        daftarTransaksi.removeIf(t -> t.GetIdTransaksi() == id);
        System.out.println("Transaksi berhasil dihapus!");
    }
}