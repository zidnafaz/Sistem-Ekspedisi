import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FungsiKel05_18 {

    // Data Pengiriman
    static String dataPengiriman[][] = new String[50][20];

    static String lokasiPaket, NamaPengirim, AlamatPengirim, TanggalPengiriman, NamaPenerima, AlamatPenerima,
            JenisBarang,
            nomorResi;

    static long NomorTeleponPengirim, NomorTeleponPenerima;

    static int KodePos, JenisLayanan;

    static double BeratBarang;

    static Scanner inputPilihan = new Scanner(System.in);
    static Scanner inputLogin = new Scanner(System.in);
    static Scanner inputDataPengiriman = new Scanner(System.in);

    static String header = String.format("========================================");

    static int pilihan;
    static String pilihaString;

    // Login
    static String usernameDanPassword[][] = new String[][] { { "Admin1", "User1" },
            { "IniAdmin1", "IniUser1" } };
    static String usernameAdmin = "", passwordAdmin, usernameUser, passwordUser;
    static int maxLoginAttempts = 3;
    static boolean login = false;

    // Perhitungan Jarak dan Layanan
    static int Jarak = 0, BiayaLayanan = 0, TotalBiaya = 0;

    // Admin
    static int dataBaru = 0;

    static String cariNomorResi;
    static int cariNomorUrut;

    public static void main(String[] args) {

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
                            login = false;
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
                                    InputDataPengiriman();
                                case 2:
                                    System.out.println(header);
                                    System.out.println("              POS INDONESIA");
                                    System.out.println(header);
                                    System.out.println("Hello Admin, Silahkan Masukkan Lokasi Paket");
                                    System.out.println(header);

                                    // String cekResiString;
                                    boolean cekResi;

                                    while (true) {
                                        CekBerdasarkanNoUrutDanResi();

                                        for (int i = 0; i < dataPengiriman.length;) {
                                            if (dataPengiriman[cariNomorUrut][14].equals(cariNomorResi)) {
                                                System.out.print("Input Lokasi Paket  : ");
                                                lokasiPaket = inputDataPengiriman.next();
                                                dataPengiriman[dataBaru][1] = lokasiPaket;
                                                break;
                                            } else {
                                                System.out.println("Nomor Resi Tidak Ditemukan");
                                            }

                                            System.out.print("Cek Lagi? (Y/N)");
                                            pilihaString = inputPilihan.next();

                                            if (pilihaString.equalsIgnoreCase("y")) {
                                                cekResi = true;
                                            } else if (pilihaString.equalsIgnoreCase("n")) {
                                                break;
                                            }
                                            break;

                                        }
                                        break;

                                    }
                                case 3:
                                                                        
                                    while (true) {
                                        CekBerdasarkanNoUrutDanResi();
                                        CetakResi();
                                    }
                                    //break;
                                case 4:
                                    // Laporan Keuangan
                                    break;
                                case 5:
                                    System.out.println(header);
                                    System.out.println("    THANK YOU ADMIN - POS INDONESIA");
                                    System.out.println(header);
                                    login = false;

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
                                    boolean cekPaket;

                                    while (true) {
                                        CekBerdasarkanNoUrutDanResi();
                                        CetakResi();
                                    }
                                    //break;
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

    public static void InputDataPengiriman() {
        for (int i = 0; i < 50; i++) {
            // dataPengiriman[dataBaru] = new String[20];
            System.out.println("Nama Admin              : " + usernameDanPassword[0][0]);
            System.out.print("Nomor Urut              : ");
            dataBaru = inputDataPengiriman.nextInt();
            dataPengiriman[dataBaru][0] = String.valueOf(dataBaru);

            System.out.print("Lokasi Agen             : ");
            lokasiPaket = inputDataPengiriman.next();
            dataPengiriman[dataBaru][1] = lokasiPaket;

            System.out.print("Nama Pengirim           : ");
            NamaPengirim = inputDataPengiriman.next();
            dataPengiriman[dataBaru][2] = NamaPengirim;

            System.out.print("Nomor Telepon Pengirim  : ");
            NomorTeleponPengirim = inputDataPengiriman.nextLong();
            dataPengiriman[dataBaru][3] = String.valueOf(NomorTeleponPengirim);

            System.out.print("Alamat Pengirim         : ");
            AlamatPengirim = inputDataPengiriman.next();
            dataPengiriman[dataBaru][4] = AlamatPengirim;

            System.out.print("Tanggal Pengiriman      : ");
            TanggalPengiriman = inputDataPengiriman.next();
            dataPengiriman[dataBaru][5] = TanggalPengiriman;

            System.out.print("Nama Penerima           : ");
            NamaPenerima = inputDataPengiriman.next();
            dataPengiriman[dataBaru][6] = NamaPenerima;

            System.out.print("Nomor Telepon Penerima  : ");
            NomorTeleponPenerima = inputDataPengiriman.nextLong();
            dataPengiriman[dataBaru][7] = String.valueOf(NomorTeleponPenerima);

            System.out.print("Alamat Penerima         : ");
            AlamatPenerima = inputDataPengiriman.next();
            dataPengiriman[dataBaru][8] = AlamatPenerima;

            System.out.print("Kode Pos                : ");
            KodePos = inputDataPengiriman.nextInt();
            dataPengiriman[dataBaru][9] = String.valueOf(KodePos);

            System.out.println("\nPilihan layanan");
            System.out.println("1. Regular");
            System.out.println("2. Ekspress\n");

            System.out.print("Jenis Layanan           : ");
            JenisLayanan = inputDataPengiriman.nextInt();

            switch (JenisLayanan) {
                case 1:
                    BiayaLayanan = 50;
                    dataPengiriman[dataBaru][10] = "Regular";
                    break;
                case 2:
                    BiayaLayanan = 75;
                    dataPengiriman[dataBaru][10] = "Ekspress";
                    break;
                default:
                    System.out.println("Layanan Tidak Tersedia. Masukkan Dengan Benar.\n");
                    break;
            }

            System.out.print("Jenis Barang            : ");
            JenisBarang = inputDataPengiriman.next();
            dataPengiriman[dataBaru][11] = JenisBarang;

            System.out.print("Berat Barang (kg)       : ");
            BeratBarang = inputDataPengiriman.nextDouble();
            dataPengiriman[dataBaru][12] = String.valueOf(BeratBarang);

            if (dataPengiriman[dataBaru][4].equalsIgnoreCase("Malang")
                    && dataPengiriman[dataBaru][8].equalsIgnoreCase("Jakarta")) {
                Jarak = 850;
            } else if (dataPengiriman[dataBaru][4].equalsIgnoreCase("Malang")
                    && dataPengiriman[dataBaru][8].equalsIgnoreCase("Bandung")) {
                Jarak = 700;
            } else if (dataPengiriman[dataBaru][4].equalsIgnoreCase("Malang")
                    && dataPengiriman[dataBaru][8].equalsIgnoreCase("Surabaya")) {
                Jarak = 40;
            } else {
                System.out.println(
                        "Pengiriman tidak tersedia masukkan alamat dengan benar\n");
                System.out.print("Masukkan Alamat Pengirim : ");
                AlamatPengirim = inputDataPengiriman.next();
                dataPengiriman[dataBaru][4] = AlamatPengirim;

                System.out.print("Masukkan Alamat Penerima : ");
                AlamatPenerima = inputDataPengiriman.next();
                dataPengiriman[dataBaru][8] = AlamatPenerima;
            }

            TotalBiaya = (int) (Jarak * BiayaLayanan + BeratBarang * 5000);
            dataPengiriman[dataBaru][13] = String.valueOf(TotalBiaya);

            System.out.println("Total Biaya             : " + dataPengiriman[dataBaru][13]);

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
                nomorResi = tanggal + Jarak + dataPengiriman[dataBaru][0];
                dataPengiriman[dataBaru][14] = (nomorResi);

                System.out.println(header);
                System.out
                        .println("Nomor Resi Anda adalah " + dataPengiriman[dataBaru][14]);
                System.out.println("Total Biaya adalah Rp." + dataPengiriman[dataBaru][13]);
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

                    System.out.println(
                            "Nomor Urut              : " + dataPengiriman[dataBaru][0]);
                    System.out.println(
                            "Lokasi Paket            : " + dataPengiriman[dataBaru][1]);
                    System.out.println(
                            "Nama Pengirim           : " + dataPengiriman[dataBaru][2]);
                    System.out.println(
                            "Nomor Telepon Pengirim  : " + dataPengiriman[dataBaru][3]);
                    System.out.println(
                            "Alamat Pengirim         : " + dataPengiriman[dataBaru][4]);
                    System.out.println(
                            "Tanggal Pengiriman      : " + dataPengiriman[dataBaru][5]);
                    System.out.println(
                            "Nama Penerima           : " + dataPengiriman[dataBaru][6]);
                    System.out.println(
                            "Nomor Telepon Penerima  : " + dataPengiriman[dataBaru][7]);
                    System.out.println(
                            "Alamat Penerima         : " + dataPengiriman[dataBaru][8]);
                    System.out.println(
                            "Kode Pos                : " + dataPengiriman[dataBaru][9]);
                    System.out
                            .println("Jenis Layanan           : "
                                    + dataPengiriman[dataBaru][10]);
                    System.out
                            .println("Jenis Barang            : "
                                    + dataPengiriman[dataBaru][11]);
                    System.out
                            .println("Berat Barang (kg)       : "
                                    + dataPengiriman[dataBaru][12]);
                    System.out
                            .println("Total Biaya             : "
                                    + dataPengiriman[dataBaru][13]);
                    System.out.println(
                            "Nomor Resi              : " + dataPengiriman[dataBaru][14]);

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
        //break;
    }

    public static void CekBerdasarkanNoUrutDanResi() {
        System.out.print("Masukkan Nomor Urut          : ");
        cariNomorUrut = inputPilihan.nextInt();
        System.out.print("Silahkan Masukkan Nomor Resi : ");
        cariNomorResi = inputPilihan.next();
    }

    public static void CetakResi() {
        boolean cekPaket;

        for (int i = 0; i < dataPengiriman.length;) {
            if (dataPengiriman[cariNomorUrut][14].equals(cariNomorResi)) {

                System.out.println(
                        "Nomor Urut              : " + dataPengiriman[dataBaru][0]);
                System.out.println(
                        "Lokasi Paket            : " + dataPengiriman[dataBaru][1]);
                System.out.println(
                        "Nama Pengirim           : " + dataPengiriman[dataBaru][2]);
                System.out.println(
                        "Nomor Telepon Pengirim  : " + dataPengiriman[dataBaru][3]);
                System.out.println(
                        "Alamat Pengirim         : " + dataPengiriman[dataBaru][4]);
                System.out.println(
                        "Tanggal Pengiriman      : " + dataPengiriman[dataBaru][5]);
                System.out.println(
                        "Nama Penerima           : " + dataPengiriman[dataBaru][6]);
                System.out.println(
                        "Nomor Telepon Penerima  : " + dataPengiriman[dataBaru][7]);
                System.out.println(
                        "Alamat Penerima         : " + dataPengiriman[dataBaru][8]);
                System.out.println(
                        "Kode Pos                : " + dataPengiriman[dataBaru][9]);
                System.out
                        .println("Jenis Layanan           : "
                                + dataPengiriman[dataBaru][10]);
                System.out
                        .println("Jenis Barang            : "
                                + dataPengiriman[dataBaru][11]);
                System.out
                        .println("Berat Barang (kg)       : "
                                + dataPengiriman[dataBaru][12]);
                System.out
                        .println("Total Biaya             : "
                                + dataPengiriman[dataBaru][13]);
                System.out.println(
                        "Nomor Resi              : " + dataPengiriman[dataBaru][14]);

            } else {
                System.out.println("Nomor Resi Tidak Ditemukan");
            }

            System.out.print("Cek Lagi? (Y/N)");
            pilihaString = inputPilihan.next();

            if (pilihaString.equalsIgnoreCase("y")) {
                cekPaket = true;
            } else if (pilihaString.equalsIgnoreCase("n")) {
                break;
            }

        }
        //break;
    }

}