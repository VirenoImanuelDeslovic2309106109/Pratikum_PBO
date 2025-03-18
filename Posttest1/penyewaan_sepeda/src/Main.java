import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Sepeda> daftarSepeda = new ArrayList<>();
    static ArrayList<TransaksiPenyewaan> daftarTransaksi = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static int idSepedaCounter = 1;
    static int idTransaksiCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== SISTEM PENYEWAAN SEPEDA ===");
            System.out.println("1. Tambah Sepeda");
            System.out.println("2. Lihat Semua Sepeda");
            System.out.println("3. Ubah Sepeda");
            System.out.println("4. Hapus Sepeda");
            System.out.println("5. Tambah Transaksi Penyewaan");
            System.out.println("6. Lihat Semua Transaksi");
            System.out.println("7. Perbarui Transaksi");
            System.out.println("8. Hapus Transaksi");
            System.out.println("9. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1 : {
                    System.out.print("Masukkan jenis sepeda: ");
                    String jenis = input.nextLine();
                    Sepeda.tambahSepeda(daftarSepeda, idSepedaCounter++, jenis);
                }
                case 2 : Sepeda.lihatSemuaSepeda(daftarSepeda);
                case 3 : {
                    System.out.print("Masukkan ID sepeda yang ingin diperbarui: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Masukkan jenis sepeda baru: ");
                    String jenis = input.nextLine();
                    System.out.print("Apakah tersedia? (true/false): ");
                    boolean tersedia = input.nextBoolean();
                    Sepeda.perbaruiSepeda(daftarSepeda, id, jenis, tersedia);
                }
                case 4 : {
                    System.out.print("Masukkan ID sepeda yang ingin dihapus: ");
                    int id = input.nextInt();
                    Sepeda.hapusSepeda(daftarSepeda, id);
                }
                case 5 : {
                    System.out.print("Masukkan nama penyewa: ");
                    String penyewa = input.nextLine();
                    System.out.print("Masukkan ID sepeda yang ingin disewa: ");
                    int idSepeda = input.nextInt();
                    TransaksiPenyewaan.tambahTransaksi(daftarTransaksi, daftarSepeda, idTransaksiCounter++, idSepeda, penyewa);
                }
                case 6 : TransaksiPenyewaan.lihatSemuaTransaksi(daftarTransaksi);
                case 7 : {
                    System.out.print("Masukkan ID transaksi yang ingin diperbarui: ");
                    int id = input.nextInt();
                    TransaksiPenyewaan.perbaruiTransaksi(daftarTransaksi, daftarSepeda, id);
                }
                case 8 : {
                    System.out.print("Masukkan ID transaksi yang ingin dihapus: ");
                    int id = input.nextInt();
                    TransaksiPenyewaan.hapusTransaksi(daftarTransaksi, id);
                }
                case 9 : {
                    System.out.println("Terima kasih! Program selesai.");
                    System.exit(0);
                }
                default : System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
