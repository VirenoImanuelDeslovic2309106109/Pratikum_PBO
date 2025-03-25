import java.util.ArrayList;

public class Sepeda {
    private int id;
    private String jenis;
    private boolean tersedia;

    public Sepeda(int id, String jenis, boolean tersedia) {
        this.id = id;
        this.jenis = jenis;
        this.tersedia = tersedia;
    }

    public int GetId() {
        return id;
    }

    public void SetId(int id) {
        this.id = id;
    }

    public String GetJenis() {
        return jenis;
    }

    public boolean IsTersedia() {
        return tersedia;
    }

    public void SetJenis(String jenis) {
        this.jenis = jenis;
    }

    public void SetTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public void TampilkanInfo() {
        System.out.println("ID: " + id + " | Jenis: " + jenis + " | Tersedia: " + (tersedia ? "Ya" : "Tidak"));
    }

    public static void TambahSepeda(ArrayList<Sepeda> daftarSepeda, int id, String jenis) {
        daftarSepeda.add(new Sepeda(id, jenis, true));
        System.out.println("Sepeda berhasil ditambahkan!");
    }

    public static void LihatSemuaSepeda(ArrayList<Sepeda> daftarSepeda) {
        if (daftarSepeda.isEmpty()) {
            System.out.println("Tidak ada sepeda tersedia.");
            return;
        }
        for (Sepeda s : daftarSepeda) {
            s.TampilkanInfo();
        }
    }

    public static void PerbaruiSepeda(ArrayList<Sepeda> daftarSepeda, int id, String jenisBaru, boolean tersedia) {
        for (Sepeda s : daftarSepeda) {
            if (s.GetId() == id) {
                s.SetJenis(jenisBaru);
                s.SetTersedia(tersedia);
                System.out.println("Sepeda berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Sepeda tidak ditemukan.");
    }

    public static void HapusSepeda(ArrayList<Sepeda> daftarSepeda, int id) {
        daftarSepeda.removeIf(s -> s.GetId() == id);
        System.out.println("Sepeda berhasil dihapus!");
    }
}
