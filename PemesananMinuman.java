import java.util.Scanner;

/**
 * Metode main untuk memulai aplikasi pemesanan minuman. Meminta input dari
 * pengguna, memvalidasi data, menghitung total harga, dan menampilkan hasil.
 */
public class PemesananMinuman {
    private static final double HARGA_ESPRESSO = 25000;
    private static final double HARGA_LATTE = 30000;
    private static final double HARGA_MOCHA = 35000;
    private static final double HARGA_TEA = 15000;

    /**
     * Metode main untuk memulai aplikasi pemesanan minuman. Meminta input dari pengguna, memvalidasi data, menghitung total harga, dan menampilkan hasil.
     * @param args argumen baris perintah yang tidak digunakan dalam program ini
     * @param args
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nama = getInput(scanner, "Masukkan nama: ");
        String pilihanMinuman = getInput(scanner, "Pilih minuman (Espresso, Latte, Mocha, Tea): ");
        int jumlah = Integer.parseInt(getInput(scanner, "Masukkan jumlah pesanan: "));

        if (nama.isEmpty() || pilihanMinuman.isEmpty() || jumlah <= 0) {
            System.out.println("Data harus diisi dengan benar.");
            return;
        }

        double hargaTotal = hitungHarga(pilihanMinuman, jumlah);

        if (hargaTotal == -1) {
            System.out.println("Pilihan minuman tidak valid.");
        } else {
            System.out.printf("\nPesanan atas nama %s:\n", nama);
            System.out.printf("Minuman: %s\n", pilihanMinuman);
            System.out.printf("Jumlah: %d\n", jumlah);
            System.out.printf("Total harga: Rp %.0f\n", hargaTotal);
        }
    }

    /**
     * Metode untuk mengambil input dari pengguna.
     * @param scanner scanner Scanner untuk membaca input dari pengguna
     * @param prompt prompt  Pesan yang ditampilkan kepada pengguna sebelum memasukkan data
     * @return String input dari pengguna yang telah dipangkas spasi
     */

    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Metode untuk menghitung total harga berdasarkan jenis minuman dan jumlah pesanan.
     * @param pilihanMinuman pilihanMinuman Jenis minuman yang dipilih oleh pengguna
     * @param jumlah jumlah         Jumlah pesanan minuman
     * @return double Total harga yang harus dibayar. Mengembalikan -1 jika jenis
     *      *         minuman tidak valid.
     */

    private static double hitungHarga(String pilihanMinuman, int jumlah) {
        double hargaMinuman;
        switch (pilihanMinuman.toLowerCase()) {
            case "espresso":
                hargaMinuman = HARGA_ESPRESSO;
                break;
            case "latte":
                hargaMinuman = HARGA_LATTE;
                break;
            case "mocha":
                hargaMinuman = HARGA_MOCHA;
                break;
            case "tea":
                hargaMinuman = HARGA_TEA;
                break;
            default:
                return -1; // Minuman tidak valid
        }
        return hargaMinuman * jumlah;
    }
}