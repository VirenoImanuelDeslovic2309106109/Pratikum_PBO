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
            System.out.println("7. Ubah Transaksi");
            System.out.println("8. Hapus Transaksi");
            System.out.println("9. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1: {
                    System.out.println("Pilih tipe sepeda:");
                    System.out.println("1. Sepeda Gunung");
                    System.out.println("2. Sepeda Lipat");
                    System.out.print("Pilihan: ");
                    int tipe = input.nextInt();
                    input.nextLine();
                    System.out.print("Masukkan jenis sepeda: ");
                    String jenis = input.nextLine();

                    if (tipe == 1) {
                        daftarSepeda.add(new SepedaGunung(idSepedaCounter++, jenis));
                    } else if (tipe == 2) {
                        daftarSepeda.add(new SepedaLipat(idSepedaCounter++, jenis));
                    } else {
                        System.out.println("Inputan Tidak Valid.");
                        break;
                    }
                    System.out.println("Sepeda berhasil ditambahkan!");
                    break;
                }

                case 2: {
                    Sepeda.LihatSemuaSepeda(daftarSepeda);
                    break;
                }

                case 3: {
                    System.out.print("Masukkan ID sepeda yang ingin diperbarui: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Masukkan jenis sepeda baru: ");
                    String jenis = input.nextLine();
                    System.out.print("Apakah tersedia? (true/false): ");
                    boolean tersedia = input.nextBoolean();
                    Sepeda.PerbaruiSepeda(daftarSepeda, id, jenis, tersedia);
                    break;
                }

                case 4: {
                    System.out.print("Masukkan ID sepeda yang ingin dihapus: ");
                    int id = input.nextInt();
                    Sepeda.HapusSepeda(daftarSepeda, id);
                    break;
                }

                case 5: {
                    System.out.print("Masukkan nama penyewa: ");
                    String penyewa = input.nextLine();
                    System.out.print("Masukkan ID sepeda yang ingin disewa: ");
                    int idSepeda = input.nextInt();
                    TransaksiPenyewaan.TambahTransaksi(daftarTransaksi, daftarSepeda, idTransaksiCounter++, idSepeda, penyewa);
                    break;
                }

                case 6: {
                    TransaksiPenyewaan.LihatSemuaTransaksi(daftarTransaksi);
                    break;
                }

                case 7: {
                    System.out.print("Masukkan ID transaksi yang ingin diperbarui: ");
                    int id = input.nextInt();
                    TransaksiPenyewaan.PerbaruiTransaksi(daftarTransaksi, daftarSepeda, id);
                    break;
                }

                case 8: {
                    System.out.print("Masukkan ID transaksi yang ingin dihapus: ");
                    int id = input.nextInt();
                    TransaksiPenyewaan.HapusTransaksi(daftarTransaksi, id);
                    break;
                }

                case 9: {
                    System.out.println("Program selesai.");
                    System.exit(0);
                    break;
                }

                default: {
                    System.out.println("Silakan coba lagi.");
                    break;
                }
            }
        }
    }
}
