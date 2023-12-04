import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main_Demo2 {
    public static void main(String[] args) {
        Scanner inputPilihan = new Scanner(System.in);
        Scanner inputLogin = new Scanner(System.in);
        Scanner inputDataPengiriman = new Scanner(System.in);

        String header = String.format("========================================");

        int pilihan;
        String pilihaString;

        // Login
        String usernameDanPassword[][] = new String[][] { { "Admin1", "User1" },
                { "IniAdmin1", "IniUser1" } };
        String usernameAdmin = "", passwordAdmin, usernameUser, passwordUser;
        int maxLoginAttempts = 3;
        boolean login = false;

        // Data Pengiriman
        String[] lokasiPaket = new String[10];
        String[] NamaPengirim = new String[10];
        String[] NomorTeleponPengirim = new String[10];
        String[] AlamatPengirim = new String[10];
        String[] TanggalPengiriman = new String[10];
        String[] NamaPenerima = new String[10];
        String[] NomorTeleponPenerima = new String[10];
        String[] AlamatPenerima = new String[10];
        int[] KodePos = new int[10];
        String[] JenisLayanan = new String[10];
        String[] JenisBarang = new String[10];
        double[] BeratBarang = new double[10];
        String[] nomorResi = new String[10];

        // Perhitungan Jarak dan Layanan
        int Jarak = 0, BiayaLayanan = 0, TotalBiaya = 0;

        // Admin
        int dataBaru = 0;

        boolean menuLogin = true;
        while (menuLogin) {
            System.out.println(header);
            System.out.println("        WELCOME TO POS INDONESIA");
            System.out.println(header);
            System.out.println("             Silahkan Login");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit\n");
            System.out.println("            Masukkan Pilihan");
            System.out.println(header);
            pilihan = inputPilihan.nextInt();

            switch (pilihan) {
                case 1:
                    for (int loginAttempt = 1; loginAttempt <= maxLoginAttempts; loginAttempt++) {

                        System.out.println(header);
                        System.out.println("               Login Admin");
                        System.out.println(header);
                        System.out.print("Masukkan Username   = ");
                        usernameAdmin = inputLogin.next();
                        System.out.print("Masukkan Password   = ");
                        passwordAdmin = inputLogin.next();
                        System.out.println(header);

                        if (usernameDanPassword[0][0].equals(usernameAdmin)
                                && usernameDanPassword[1][0].equals(passwordAdmin)) {
                            System.out.println("Login Successfully\n");
                            login = true;
                            break;
                        } else if (loginAttempt >= 3) {
                            System.out.println("Melebihi Maksimal Login Anda Akan Kembali Ke Menu Awal\n");
                        } else {
                            System.out.println("Login Gagal Silahkan Coba lagi atau Hubungi Admin\n");
                        }
                    }

                    while (true) {
                        if (login) {
                            System.out.println(header);
                            System.out.println("             HELLO ADMIN");
                            System.out.println(header);
                            System.out.println("1. Input Paket Baru");
                            System.out.println("2. Input Lokasi Paket");
                            System.out.println("3. Cek Paket");
                            System.out.println("4. Laporan Keuangan");
                            System.out.println("5. Kembali\n");
                            System.out.println("            Masukkan Pilihan");
                            System.out.println(header);
                            pilihan = inputPilihan.nextInt();

                            switch (pilihan) {
                                case 1:

                                    for (int i = 0; i < 10; i++) {
                                        System.out.println("\nNama Admin              : " + usernameDanPassword[0][0]);
                                        
                                        System.out.print("Lokasi Agen             : ");
                                        lokasiPaket[i] = inputDataPengiriman.next();

                                        System.out.print("\nNama Pengirim           : ");
                                        NamaPengirim[i] = inputDataPengiriman.next();

                                        System.out.print("Nomor Telepon Pengirim  : ");
                                        NomorTeleponPengirim[i] = inputDataPengiriman.next();

                                        System.out.print("Alamat Pengirim         : ");
                                        AlamatPengirim[i] = inputDataPengiriman.next();

                                        System.out.print("Tanggal Pengiriman      : ");
                                        TanggalPengiriman[i] = inputDataPengiriman.next();

                                        System.out.print("Nama Penerima           : ");
                                        NamaPenerima[i] = inputDataPengiriman.next();

                                        System.out.print("Nomor Telepon Penerima  : ");
                                        NomorTeleponPenerima[i] = inputDataPengiriman.next();

                                        System.out.print("Alamat Penerima         : ");
                                        AlamatPenerima[i] = inputDataPengiriman.next();

                                        System.out.print("Kode Pos                : ");
                                        KodePos[i] = inputDataPengiriman.nextInt();

                                        System.out.println("\nPilihan layanan");
                                        System.out.println("1. Regular");
                                        System.out.println("2. Ekspress\n");

                                        System.out.print("Jenis Layanan           : ");

                                        System.out.print("Jenis Barang            : ");
                                        JenisBarang[i] = inputDataPengiriman.next();

                                        System.out.print("Berat Barang (kg)       : ");
                                        BeratBarang[i] = inputDataPengiriman.nextDouble();

                                        // Perhitungan Jarak
                                        if ((AlamatPengirim[i].equalsIgnoreCase("Malang")
                                                && AlamatPenerima[i].equalsIgnoreCase("Jakarta")) ||
                                                (AlamatPengirim[i].equalsIgnoreCase("Jakarta")
                                                        && AlamatPenerima[i].equalsIgnoreCase("Malang"))) {
                                            Jarak = 850;
                                        } else if ((AlamatPengirim[i].equalsIgnoreCase("Malang")
                                                && AlamatPenerima[i].equalsIgnoreCase("Bandung")) ||
                                                (AlamatPengirim[i].equalsIgnoreCase("Bandung")
                                                        && AlamatPenerima[i].equalsIgnoreCase("Malang"))) {
                                            Jarak = 700;
                                        } else if ((AlamatPengirim[i].equalsIgnoreCase("Malang")
                                                && AlamatPenerima[i].equalsIgnoreCase("Surabaya")) ||
                                                (AlamatPengirim[i].equalsIgnoreCase("Surabaya")
                                                        && AlamatPenerima[i].equalsIgnoreCase("Malang"))) {
                                            Jarak = 40;
                                        } else {
                                            System.out.println(
                                                    "Pengiriman tidak tersedia masukkan alamat dengan benar\n");
                                            System.out.print("Masukkan Alamat Pengirim : ");
                                            AlamatPengirim[i] = inputDataPengiriman.next();
                                            
                                            System.out.print("Masukkan Alamat Penerima : ");
                                            AlamatPenerima[i] = inputDataPengiriman.next();                                            
                                        }

                                        TotalBiaya = (int) (Jarak * BiayaLayanan + BeratBarang[i] * 5000);

                                        System.out.println("Total Biaya             : " + TotalBiaya);

                                        // // Memeriksa apakah ingin memasukkan data pengiriman lagi
                                        // System.out.println("Apakah ingin memasukkan data pengiriman lagi?
                                        // (Ya/Tidak)");
                                        // String lanjutkan = inputDataPengiriman.next();
                                        // dataBaru++;

                                        // if (lanjutkan.equalsIgnoreCase("Tidak")) {
                                        // break;
                                        // }

                                        boolean payment = true;
                                        while (payment) {

                                            LocalDate today = LocalDate.now();
                                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMM");
                                            String tanggal = today.format(formatter);
                                            nomorResi[i] = tanggal + Jarak + dataBaru;

                                            System.out.println(header);
                                            System.out.println("Nomor Resi Anda adalah " + nomorResi[i]);
                                            System.out.println("Total Biaya adalah Rp." + TotalBiaya);
                                            System.out.println(header);

                                            System.out.println(header);
                                            System.out.println("               PEMBAYARAN");
                                            System.out.println(header);
                                            System.out.println(" Pastikan Bahwa Pelanggan Sudah Membayar");
                                            System.out.println("1. Sudah");
                                            System.out.println("2. Belum");
                                            System.out.println("            Masukkan Pilihan");
                                            System.out.println(header);
                                            pilihan = inputPilihan.nextInt();

                                            if (pilihan == 1) {

                                                System.out.println(header);
                                                System.out.println("                THANK YOU");
                                                System.out.println(header);
                                                System.out.println("       Paket Akan Segera Dikirimkan");
                                                System.out.println(header);
                                                // TotalBiaya++;
                                                // totalPendapatanHarian += TotalBiaya;
                                                payment = false;
                                                break;

                                            } else if (pilihan == 2) {

                                                System.out.println(header);
                                                System.out.println("                THANK YOU");
                                                System.out.println(header);
                                                System.out.println("       Mohon Selesaikan Pembayaran");
                                                System.out.println(header);

                                            } else {

                                                System.out.println(header);
                                                System.out.println("                THANK YOU");
                                                System.out.println(header);
                                                System.out.println("         Masukkan Pilihan Yang Benar");
                                                System.out.println(header);

                                            }

                                        }
                                        System.out.println(
                                                "Apakah ingin memasukkan data pengiriman lagi? (Y/T)");
                                        String lanjutkan = inputDataPengiriman.next();
                                        if (lanjutkan.equalsIgnoreCase("T")) {
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println(header);
                                    System.out.println("              POS INDONESIA");
                                    System.out.println(header);
                                    System.out.println("Hello Admin, Silahkan Masukkan Lokasi Paket");
                                    System.out.println(header);

                                    String cekResiString;
                                    boolean cekResi = true;
                                    while (cekResi) {
                                        System.out.print("Masukkan Nomor Resi    : ");
                                        cekResiString = inputDataPengiriman.next();

                                        if (cekResiString.equals(nomorResi[0])) {
                                            System.out.print("Input Lokasi Paket  : ");
                                            lokasiPaket[0] = inputDataPengiriman.next();
                                            cekResi = false;
                                        } else {
                                            System.out.println("Nomor Resi Tidak Ditemukan");
                                            System.out.println("Cek Lagi? (Y/N)");
                                            pilihaString = inputPilihan.next();

                                            if (pilihaString.equalsIgnoreCase("y")) {
                                                cekResi = true;
                                            } else if (pilihaString.equalsIgnoreCase("n")) {
                                                cekResi = false;
                                            }
                                        }
                                    }
                                    break;
                                case 3:
                                    boolean cekPaket = true;

                                    while (cekPaket) {
                                        System.out.print("Silahkan Masukkan Nomor Resi : ");
                                        String cariNomorResi = inputPilihan.next();

                                        if (cariNomorResi.equals(nomorResi[0])) {
                                            System.out.println("Lokasi Paket            : " + lokasiPaket[0]);
                                            System.out.println("Nama Pengirim             : " + NamaPengirim[0]);
                                            System.out
                                                    .println("Nomor Telepon Pengirim    : " + NomorTeleponPengirim[0]);
                                            System.out.println("Alamat Pengirim           : " + AlamatPengirim[0]);
                                            System.out.println("Tanggal Pengiriman        : " + TanggalPengiriman[0]);
                                            System.out.println("Nama Penerima             : " + NamaPenerima[0]);
                                            System.out
                                                    .println("Nomor Telepon Penerima    : " + NomorTeleponPenerima[0]);
                                            System.out.println("Alamat Penerima           : " + AlamatPenerima[0]);
                                            System.out.println("Kode Pos                  : " + KodePos[0]);
                                            System.out.println("Jenis Layanan             : " + JenisLayanan[0]);
                                            System.out.println("Jenis Barang              : " + JenisBarang[0]);
                                            System.out.println("Berat Barang (in kg)      : " + BeratBarang[0]);
                                            cekPaket = false;
                                        } else {
                                            System.out.println("Nomor Resi Tidak Ditemukan");
                                            System.out.println("Cek Lagi? (Y/N)");
                                            pilihaString = inputPilihan.next();

                                            if (pilihaString.equalsIgnoreCase("y")) {
                                                cekPaket = true;
                                            } else if (pilihaString.equalsIgnoreCase("n")) {
                                                cekPaket = false;
                                            }
                                        }
                                    }
                                    break;
                                case 4:
                                    // Laporan Keuangan
                                    break;
                                case 5:
                                    System.out.println(header);
                                    System.out.println("    THANK YOU ADMIN - POS INDONESIA");
                                    System.out.println(header);
                                    login = false;
                                    return;
                                default:
                                    System.out.println("Masukkan Pilihan Yang Benar");
                                    break;
                            }
                        } else {
                            break;
                        }
                    }
                    break;

                case 2:
                    for (int loginAttempt = 1; loginAttempt <= maxLoginAttempts; loginAttempt++) {

                        System.out.println(header);
                        System.out.println("                LOGIN USER");
                        System.out.println(header);
                        System.out.print("Masukkan Username   = ");
                        usernameUser = inputLogin.next();
                        System.out.print("Masukkan Password   = ");
                        passwordUser = inputLogin.next();
                        System.out.println(header);

                        if (usernameDanPassword[0][1].equals(usernameUser)
                                && usernameDanPassword[1][1].equals(passwordUser)) {
                            System.out.println("Login Successfully\n");
                            login = true;
                            break;
                        } else if (loginAttempt >= 3) {
                            System.out.println("Melebihi Maksimal Login Anda Akan Kembali Ke Menu Awal\n");
                        } else {
                            System.out.println("Login Gagal Silahkan Coba lagi atau Hubungi Admin\n");
                        }
                    }

                    while (true) {
                        if (login) {
                            System.out.println(header);
                            System.out.println("              HELLO USER");
                            System.out.println(header);
                            System.out.println("1. Cek Paket");
                            System.out.println("2. Kembali");
                            System.out.println("            Masukkan Pilihan");
                            System.out.println(header);
                            pilihan = inputPilihan.nextInt();

                            switch (pilihan) {
                                case 1:
                                    boolean cekPaket = true;

                                    while (cekPaket) {
                                        System.out.print("Silahkan Masukkan Nomor Resi : ");
                                        String cariNomorResi = inputPilihan.next();

                                        if (cariNomorResi.equals(nomorResi[0])) {
                                            System.out.println("Lokasi Paket            : " + lokasiPaket[0]);
                                            System.out.println("Nama Pengirim             : " + NamaPengirim[0]);
                                            System.out
                                                    .println("Nomor Telepon Pengirim    : " + NomorTeleponPengirim[0]);
                                            System.out.println("Alamat Pengirim           : " + AlamatPengirim[0]);
                                            System.out.println("Tanggal Pengiriman        : " + TanggalPengiriman[0]);
                                            System.out.println("Nama Penerima             : " + NamaPenerima[0]);
                                            System.out
                                                    .println("Nomor Telepon Penerima    : " + NomorTeleponPenerima[0]);
                                            System.out.println("Alamat Penerima           : " + AlamatPenerima[0]);
                                            System.out.println("Kode Pos                  : " + KodePos[0]);
                                            System.out.println("Jenis Layanan             : " + JenisLayanan[0]);
                                            System.out.println("Jenis Barang              : " + JenisBarang[0]);
                                            System.out.println("Berat Barang (in kg)      : " + BeratBarang[0]);
                                            cekPaket = false;
                                        } else {
                                            System.out.println("Nomor Resi Tidak Ditemukan");
                                            System.out.println("Cek Lagi? (Y/N)");
                                            pilihaString = inputPilihan.next();

                                            if (pilihaString.equalsIgnoreCase("y")) {
                                                cekPaket = true;
                                            } else if (pilihaString.equalsIgnoreCase("n")) {
                                                cekPaket = false;
                                            }
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println(header);
                                    System.out.println("    THANK YOU - POS INDONESIA");
                                    System.out.println(header);
                                    login = false;
                                    break;
                                default:
                                    System.out.println("Masukkan Pilihan Yang Benar");
                                    break;
                            }
                        } else {
                            break;
                        }
                        break;
                    }
                    break;
                case 3:
                    System.out.println(header);
                    System.out.println("       THANK YOU - POS INDONESIA");
                    System.out.println(header);
                    menuLogin = false;
                    break;
                default:
                    System.out.println("Masukkan Pilihan Yang Benar");
                    break;
            }
        }
    }
}
