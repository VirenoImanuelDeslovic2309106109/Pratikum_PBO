import java.util.ArrayList;

public class Sepeda {
    int id;
    String jenis;
    boolean tersedia;

    public Sepeda(int id, String jenis, boolean tersedia) {
        this.id = id;
        this.jenis = jenis;
        this.tersedia = tersedia;
    }

    public void tampilkanInfo() {
        System.out.println("ID: " + id + " | Jenis: " + jenis + " | Tersedia: " + (tersedia ? "Ya" : "Tidak"));
    }

    // Metode CRUD untuk Sepeda
    public static void tambahSepeda(ArrayList<Sepeda> daftarSepeda, int id, String jenis) {
        daftarSepeda.add(new Sepeda(id, jenis, true));
        System.out.println("Sepeda berhasil ditambahkan!");
    }

    public static void lihatSemuaSepeda(ArrayList<Sepeda> daftarSepeda) {
        if (daftarSepeda.isEmpty()) {
            System.out.println("Tidak ada sepeda tersedia.");
            return;
        }
        for (Sepeda s : daftarSepeda) {
            s.tampilkanInfo();
        }
    }

    public static void perbaruiSepeda(ArrayList<Sepeda> daftarSepeda, int id, String jenisBaru, boolean tersedia) {
        for (Sepeda s : daftarSepeda) {
            if (s.id == id) {
                s.jenis = jenisBaru;
                s.tersedia = tersedia;
                System.out.println("Sepeda berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Sepeda tidak ditemukan.");
    }

    public static void hapusSepeda(ArrayList<Sepeda> daftarSepeda, int id) {
        daftarSepeda.removeIf(s -> s.id == id);
        System.out.println("Sepeda berhasil dihapus!");
    }
}
