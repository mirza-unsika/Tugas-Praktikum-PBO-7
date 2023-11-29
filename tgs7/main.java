package tgs7;

import java.util.*;

public class main {
    static class Barang {
        String kode, nama;
        int harga;

        public Barang(String kode, String nama, int harga) {
            this.kode = kode;
            this.nama = nama;
            this.harga = harga;
        }
    }

    static class Belanjaan {
        Barang barang;
        int jumlahBeli;

        public Belanjaan(Barang barang, int jumlahBeli) {
            this.barang = barang;
            this.jumlahBeli = jumlahBeli;
        }

        public int getJumlahBayar() {
            return barang.harga * jumlahBeli;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Barang[] daftarBarang = {
            new Barang("a001", "Buku", 3000),
            new Barang("a002", "Pensil", 4000),
            new Barang("a003", "Pulpen", 5000)
        };

        System.out.println("Toko Serba Ada");
        System.out.print("Masukkan Jumlah Barang : ");
        int jumlahBarang = scanner.nextInt();
        scanner.nextLine();

        Belanjaan[] daftarBelanjaan = new Belanjaan[jumlahBarang];

        for (int i = 0; i < jumlahBarang; ) {
            System.out.println("Data ke " + (++i));
            System.out.print("Masukkan Kode Barang : ");
            String kode = scanner.nextLine();

            Barang barang = cariBarang(daftarBarang, kode);

            if (barang == null) {
                System.out.println("Barang tidak ditemukan!");
                continue;
            }

            System.out.print("Masukkan Jumlah Beli : ");
            int jumlahBeli = scanner.nextInt();
            scanner.nextLine();

            daftarBelanjaan[i - 1] = new Belanjaan(barang, jumlahBeli);
        }

        System.out.println("\n\nToko Serba Ada");
        System.out.println("********************");
        System.out.printf("%-5s %-15s %-15s %-10s %-13s %-13s \n",  "No", "Kode Barang", "Nama Barang", "Harga", "Jumlah Beli", "Jumlah Bayar");
        System.out.println("===============================-============================================");

        int totalBayar = 0;
        int totalJumlahBarang = 0;

        for (int i = 0; i < daftarBelanjaan.length; i++) {
            Belanjaan belanjaan = daftarBelanjaan[i];
            System.out.printf("%-5d %-15s %-15s %-10d %-13d %-13d \n", 
                (i+1), 
                belanjaan.barang.kode,
                belanjaan.barang.nama, 
                belanjaan.barang.harga, 
                belanjaan.jumlahBeli, 
                belanjaan.getJumlahBayar()
            );
            totalBayar += belanjaan.getJumlahBayar();
            totalJumlahBarang += belanjaan.jumlahBeli;
        }

        System.out.println("============================================================================");
        System.out.printf("%-40s %d\n", "Total Bayar", totalBayar);
        System.out.println("============================================================================");
    }

    private static Barang cariBarang(Barang[] daftarBarang, String kode) {
        for (Barang barang : daftarBarang) if (barang.kode.equals(kode)) return barang;
        return null;
    }
}
