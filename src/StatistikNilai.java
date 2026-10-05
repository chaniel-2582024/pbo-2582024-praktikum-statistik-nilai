import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class StatistikNilai {

    // Sentinel: angka penanda "sudah selesai"
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();
        int nilai;

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        do {
            // Nomor diambil dari size() + 1. Nilai yang ditolak tidak
            // ditambahkan, jadi nomor yang sama ditanyakan lagi.
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) {
                continue; // lompat ke syarat while, loop berhenti
            }
            if (nilai < 0 || nilai > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue; // add() dilewati, nilai tidak masuk daftar
            }
            daftar.add(nilai);
        } while (nilai != SELESAI);

        // Kalau langsung -1 (daftar kosong), cetak pesan, bukan error
        if (daftar.isEmpty()) {
            System.out.println();
            System.out.println("Belum ada nilai yang dimasukkan.");
            return;
        }

        System.out.println();
        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());

        // Jumlahkan semua nilai, lalu cari rata-rata
        int total = 0;
        for (int n : daftar) {
            total += n;
        }
        double rata = (double) total / daftar.size();

        // Tertinggi dan terendah dicari dengan loop sendiri.
        // Nilai awal = elemen pertama daftar, bukan 0 atau 100.
        // Alasan: kalau terendah dimulai dari 0, hasilnya salah karena
        // tidak ada nilai yang lebih kecil dari 0. Dengan elemen pertama,
        // nilai awalnya pasti nilai asli dari daftar.
        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);
        for (int i = 1; i < daftar.size(); i++) {
            int n = daftar.get(i);
            if (n > tertinggi) {
                tertinggi = n;
            }
            if (n < terendah) {
                terendah = n;
            }
        }

        // Jumlah di atas rata-rata dihitung di PUTARAN KEDUA.
        // Alasan: rata-rata baru diketahui setelah semua nilai dijumlahkan.
        // Waktu membaca nilai (putaran pertama), rata-rata belum ada,
        // jadi belum bisa dibandingkan. Maka putaran 1 mencari rata-rata,
        // putaran 2 membandingkan tiap nilai dengan rata-rata itu.
        int diAtasRata = 0;
        for (int n : daftar) {
            if (n > rata) {
                diAtasRata++;
            }
        }

        // Locale Indonesia dipaksa supaya desimalnya selalu koma
        String rataTeks = String.format(Locale.forLanguageTag("id-ID"), "%.2f", rata);

        System.out.println("Rata-rata       : " + rataTeks);
        System.out.println("Tertinggi       : " + tertinggi);
        System.out.println("Terendah        : " + terendah);
        System.out.println("Di atas rata2   : " + diAtasRata + " orang");
    }
}