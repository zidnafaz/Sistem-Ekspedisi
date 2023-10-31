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
        String usernameAdmin = "", passwordAdmin, usernameUser, passwordUser;
        int maxLoginAttempts = 3;
        boolean login = false;

        // Data Pengiriman
        String[] lokasiPaket = new String[1];
        String[] NamaPengirim = new String[1];
        long[] NomorTeleponPengirim = new long[1];
        String[] AlamatPengirim = new String[1];
        String[] TanggalPengiriman = new String[1];
        String[] NamaPenerima = new String[1];
        long[] NomorTeleponPenerima = new long[1];
        String[] AlamatPenerima = new String[1];
        int[] KodePos = new int[1];
        String[] JenisLayanan = new String[1];
        String[] JenisBarang = new String[1];
        double[] BeratBarang = new double[1];
        String[] nomorResi = new String[1];

        // Perhitungan Jarak dan Layanan
        int Jarak = 0, BiayaLayanan = 0, TotalBiaya;

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

                        if (usernameAdmin.equals("Admin1") && passwordAdmin.equals("IniAdmin1")) {
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

                                    System.out.println(header);
                                    System.out.println("            DATA PENGIRIMAN");
                                    System.out.println(header);
                                    System.out.println("\nNama Admin              : " + usernameAdmin);
                                    System.out.print("Lokasi Agen             : ");
                                    lokasiPaket[0] = inputDataPengiriman.next();
                                    System.out.println("");
                                    System.out.print("\nNama Pengirim             : ");
                                    NamaPengirim[0] = inputDataPengiriman.next();
                                    System.out.print("Nomor Telepon Pengirim    : ");
                                    NomorTeleponPengirim[0] = inputDataPengiriman.nextLong();
                                    System.out.print("Alamat Pengirim           : ");
                                    AlamatPengirim[0] = inputDataPengiriman.next();
                                    System.out.print("Tanggal Pengiriman        : ");
                                    TanggalPengiriman[0] = inputDataPengiriman.next();
                                    System.out.print("Nama Penerima             : ");
                                    NamaPenerima[0] = inputDataPengiriman.next();
                                    System.out.print("Nomor Telepon Penerima    : ");
                                    NomorTeleponPenerima[0] = inputDataPengiriman.nextLong();
                                    System.out.print("Alamat Penerima           : ");
                                    AlamatPenerima[0] = inputDataPengiriman.next();
                                    System.out.print("Kode Pos                  : ");
                                    KodePos[0] = inputDataPengiriman.nextInt();

                                    boolean jenisLayananValid = false;
                                    while (!jenisLayananValid) {
                                        System.out.print("Jenis Layanan             : ");
                                        JenisLayanan[0] = inputDataPengiriman.next();

                                        if (JenisLayanan[0].equalsIgnoreCase("Regular")) {
                                            BiayaLayanan = 50;
                                            jenisLayananValid = true;
                                        } else if (JenisLayanan[0].equalsIgnoreCase("Ekspress")) {
                                            BiayaLayanan = 75;
                                            jenisLayananValid = true;
                                        } else {
                                            System.out.println("Layanan Tidak Tersedia. Masukkan Dengan Benar.\n");
                                        }
                                    }

                                    System.out.print("Jenis Barang              : ");
                                    JenisBarang[0] = inputDataPengiriman.next();
                                    System.out.print("Berat Barang (kg)         : ");
                                    BeratBarang[0] = inputDataPengiriman.nextDouble();

                                    // Perhitungan Jarak
                                    if (AlamatPengirim[0].equalsIgnoreCase("Malang")
                                            && AlamatPenerima[0].equalsIgnoreCase("Jakarta")) {
                                        Jarak = 850;
                                    } else if (AlamatPengirim[0].equalsIgnoreCase("Malang")
                                            && AlamatPenerima[0].equalsIgnoreCase("Bandung")) {
                                        Jarak = 700;
                                    } else if (AlamatPengirim[0].equalsIgnoreCase("Malang")
                                            && AlamatPenerima[0].equalsIgnoreCase("Surabaya")) {
                                        Jarak = 40;
                                    } else if (AlamatPengirim[0].equalsIgnoreCase("Jakarta")
                                            && AlamatPenerima[0].equalsIgnoreCase("Malang")) {
                                        Jarak = 850;
                                    } else if (AlamatPengirim[0].equalsIgnoreCase("Jakarta")
                                            && AlamatPenerima[0].equalsIgnoreCase("Bandung")) {
                                        Jarak = 150;
                                    } else if (AlamatPengirim[0].equalsIgnoreCase("Jakarta")
                                            && AlamatPenerima[0].equalsIgnoreCase("Surabaya")) {
                                        Jarak = 800;
                                    } else if (AlamatPengirim[0].equalsIgnoreCase("Bandung")
                                            && AlamatPenerima[0].equalsIgnoreCase("Malang")) {
                                        Jarak = 700;
                                    } else if (AlamatPengirim[0].equalsIgnoreCase("Bandung")
                                            && AlamatPenerima[0].equalsIgnoreCase("Surabaya")) {
                                        Jarak = 750;
                                    } else if (AlamatPengirim[0].equalsIgnoreCase("Bandung")
                                            && AlamatPenerima[0].equalsIgnoreCase("Jakarta")) {
                                        Jarak = 150;
                                    } else if (AlamatPengirim[0].equalsIgnoreCase("Surabaya")
                                            && AlamatPenerima[0].equalsIgnoreCase("Malang")) {
                                        Jarak = 40;
                                    } else if (AlamatPengirim[0].equalsIgnoreCase("Surabaya")
                                            && AlamatPenerima[0].equalsIgnoreCase("Jakarta")) {
                                        Jarak = 800;
                                    } else if (AlamatPengirim[0].equalsIgnoreCase("Surabaya")
                                            && AlamatPenerima[0].equalsIgnoreCase("Bandung")) {
                                        Jarak = 750;
                                    } else {
                                        System.out
                                                .println("Pengiriman tidak tersedia masukkan alamat dengan benar\n");
                                        System.out.print("Masukkan Alamat Pengirim : ");
                                        AlamatPengirim[0] = inputDataPengiriman.next();
                                        System.out.print("Masukkan Alamat Penerima : ");
                                        AlamatPenerima[0] = inputDataPengiriman.next();
                                    }

                                    TotalBiaya = (int) (Jarak * BiayaLayanan + BeratBarang[0] * 5000);

                                    boolean payment = true;
                                    while (payment) {
                                        LocalDate today = LocalDate.now();
                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMM");
                                        String tanggal = today.format(formatter);
                                        nomorResi[0] = tanggal + Jarak + dataBaru;

                                        System.out.println(header);
                                        System.out.println("Nomor Resi Anda adalah " + nomorResi[0]);
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

                        if (usernameUser.equals("User1") && passwordUser.equals("IniAdmin1")) {
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
