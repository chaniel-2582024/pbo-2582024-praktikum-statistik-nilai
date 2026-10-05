import java.util.ArrayList;
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
    }
}