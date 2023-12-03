import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class FungsiKel05_18 {
    static Scanner inputPilihan = new Scanner(System.in);
    static Scanner inputLogin = new Scanner(System.in);
    static Scanner inputDataPengiriman = new Scanner(System.in);

    static String dataPengiriman[][] = new String[50][20];
    static String usernameDanPasswordAdmin[] = new String[] { "Wawan", "IniWawan" };
    static String usernameDanPasswordUser[] = new String[] { "Iwan", "IniIwan" };

    public static void main(String[] args) {

        int pilihan;
        String pilihaString;

        // Login

        // Perhitungan Jarak dan Layanan
        int Jarak = 0, BiayaLayanan = 0, TotalBiaya = 0, dataBaru = 0;
        ;

        // Admin

        boolean menuLogin = true;
        boolean cekResi = true;

        while (menuLogin) {
            header();
            System.out.println("        WELCOME TO POS INDONESIA");
            header();
            System.out.println("             Silahkan Login");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit\n");
            System.out.println("            Masukkan Pilihan");
            header();
            pilihan = inputPilihan.nextInt();

            switch (pilihan) {
                case 1:
                    if (loginAdmin(true)) {
                        while (true) {

                            header();
                            System.out.println("             HELLO ADMIN");
                            header();
                            System.out.println("1. Input Paket Baru");
                            System.out.println("2. Input Lokasi Paket");
                            System.out.println("3. Cek Paket");
                            System.out.println("4. Laporan Keuangan");
                            System.out.println("5. Kembali\n");
                            System.out.println("            Masukkan Pilihan");
                            header();
                            pilihan = inputPilihan.nextInt();

                            switch (pilihan) {
                                case 1:

                                    inputDataPengiriman(dataBaru);

                                    break;

                                case 2:

                                    while (updateLokasiPaket(cekResi, dataBaru)) {

                                    }

                                    break;

                                case 3:

                                    while (cekResi(dataBaru, cekResi)) {

                                    }

                                    break;

                                case 4:

                                    break;

                                case 5:

                                    break;

                                default:

                                    break;
                            }
                        }
                    }
                    break;

                case 2:

                    if (loginUser(menuLogin)) {
                        while (menuLogin) {
                            header();
                            System.out.println("        WELCOME TO POS INDONESIA");
                            header();
                            System.out.println("             Silahkan Login");
                            System.out.println("1. Cek Paket");
                            System.out.println("2. Kembali\n");
                            System.out.println("            Masukkan Pilihan");
                            header();
                            pilihan = inputPilihan.nextInt();

                            switch (pilihan) {
                                case 1:

                                    while (cekResi(dataBaru, cekResi)) {
                                        
                                    }

                                    break;

                                case 2:

                                    break;

                                default:
                                    break;
                            }
                        }
                    }

                    break;

                case 3:

                    break;

                default:
                    break;
            }
        }
    }

    public static void header() {
        for (int i = 1; i <= 40; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public static void inputDataPengiriman(int dataBaru) {

        String lokasiPaket, NamaPengirim, AlamatPengirim, TanggalPengiriman, NamaPenerima, AlamatPenerima, JenisBarang,
                nomorResi, NomorTeleponPengirim, NomorTeleponPenerima, KodePos;

        double BeratBarang, Panjang, Lebar, Tinggi;

        for (int i = 0; i < 50; i++) {

            System.out.println("Nama Admin              : " + usernameDanPasswordAdmin[0]);
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
            NomorTeleponPengirim = inputDataPengiriman.next();
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
            NomorTeleponPenerima = inputDataPengiriman.next();
            dataPengiriman[dataBaru][7] = String.valueOf(NomorTeleponPenerima);

            System.out.print("Alamat Penerima         : ");
            AlamatPenerima = inputDataPengiriman.next();
            dataPengiriman[dataBaru][8] = AlamatPenerima;

            System.out.print("Kode Pos                : ");
            KodePos = inputDataPengiriman.next();
            dataPengiriman[dataBaru][9] = KodePos;

            System.out.print("Jenis Barang            : ");
            JenisBarang = inputDataPengiriman.next();
            dataPengiriman[dataBaru][11] = JenisBarang;

            System.out.print("Berat Barang (kg)       : ");
            BeratBarang = inputDataPengiriman.nextDouble();
            dataPengiriman[dataBaru][12] = String.valueOf(BeratBarang);

            System.out.print("Panjang Barang (cm)     : ");
            Panjang = inputDataPengiriman.nextDouble();
            dataPengiriman[dataBaru][13] = String.valueOf(Panjang);

            System.out.print("Lebar Barang (cm)       : ");
            Lebar = inputDataPengiriman.nextDouble();
            dataPengiriman[dataBaru][14] = String.valueOf(Lebar);

            System.out.print("Tinggi Barang (cm)      : ");
            Tinggi = inputDataPengiriman.nextDouble();
            dataPengiriman[dataBaru][15] = String.valueOf(Tinggi);

            int biayaLayanan = pilihanLayanan(dataBaru);
            int jarak = hitungJarak(AlamatPengirim, AlamatPenerima);
            double totalBiaya = hitungBiayaPengiriman(Panjang, Lebar, Tinggi, BeratBarang, jarak, biayaLayanan,
                    dataBaru);

            NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
            String formattedPrice = numberFormat.format(totalBiaya);
            dataPengiriman[dataBaru][17] = String.valueOf(formattedPrice);

            buatNomorResi(dataBaru, AlamatPengirim, AlamatPenerima);
            pembayaran(dataBaru);

            System.out.println(
                    "Apakah ingin memasukkan data pengiriman lagi? (Y/T)");
            String lanjutkan = inputDataPengiriman.next();
            if (lanjutkan.equalsIgnoreCase("T")) {
                break;
            }
        }
    }

    public static void pembayaran(int dataBaru) {

        header();
        System.out.println("               PEMBAYARAN");
        header();
        System.out.println(" Pastikan Bahwa Pelanggan Sudah Membayar");
        System.out.println("1. Sudah");
        System.out.println("2. Belum");
        System.out.println("            Masukkan Pilihan");
        header();
        int pilihan = inputPilihan.nextInt();

        if (pilihan == 1) {

            cetakResi(dataBaru);

            header();
            System.out.println("                TERIMA KASIH");
            header();
            System.out.println("       Paket Akan Segera Dikirimkan");
            header();

        } else if (pilihan == 2) {

            header();
            System.out.println("                  MAAF");
            header();
            System.out.println("       Mohon Selesaikan Pembayaran");
            header();

            pembayaran(dataBaru);

        } else {

            header();
            System.out.println("                  MAAF");
            header();
            System.out.println("       Masukkan Pilihan Yang Benar");
            header();

            pembayaran(dataBaru);

        }

    }

    public static void cetakResi(int dataBaru) {

        header();
        System.out.println("             DATA PENGIRIMAN");
        header();

        System.out.println(
                "\nNomor Urut              : " + dataPengiriman[dataBaru][0]);
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
                .println("Volume Barang (cm)      : "
                        + dataPengiriman[dataBaru][16]);
        System.out
                .println("Total Biaya             : Rp."
                        + dataPengiriman[dataBaru][17]);
        System.out.println(
                "Nomor Resi              : " + dataPengiriman[dataBaru][18]);
        System.out.println();

    }

    public static String buatNomorResi(int dataBaru, String alamatPengirim, String alamatPenerima) {

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMM");
        String tanggal = today.format(formatter);
        int jarak = hitungJarak(alamatPengirim, alamatPenerima);
        String nomorResi = tanggal + jarak + dataPengiriman[dataBaru][0];
        dataPengiriman[dataBaru][18] = (nomorResi);

        header();
        System.out
                .println("Nomor Resi Anda adalah " + dataPengiriman[dataBaru][18]);
        System.out.println("Total Biaya adalah Rp." + dataPengiriman[dataBaru][17]);
        header();

        return nomorResi;
    }

    public static boolean loginAdmin(boolean login) {
        String usernameAdmin, passwordAdmin;
        int maxLoginAttempts = 3;
        login = false;

        for (int loginAttempt = 1; loginAttempt <= maxLoginAttempts; loginAttempt++) {

            header();
            System.out.println("               Login Admin");
            header();
            System.out.print("Masukkan Username   = ");
            usernameAdmin = inputLogin.next();
            System.out.print("Masukkan Password   = ");
            passwordAdmin = inputLogin.next();
            header();

            if (usernameDanPasswordAdmin[0].equals(usernameAdmin)
                    && usernameDanPasswordAdmin[1].equals(passwordAdmin)) {
                System.out.println("Login Successfully\n");
                login = true;
                break;
            } else if (loginAttempt >= 3) {
                System.out.println("Melebihi Maksimal Login Anda Akan Kembali Ke Menu Awal\n");
                login = false;
            } else {
                System.out.println("Login Gagal Silahkan Coba lagi");
            }
        }
        return login;
    }

    public static boolean loginUser(boolean login) {
        String usernameUser, passwordUser;
        int maxLoginAttempts = 3;
        login = false;

        for (int loginAttempt = 1; loginAttempt <= maxLoginAttempts; loginAttempt++) {

            header();
            System.out.println("                Login User");
            header();
            System.out.print("Masukkan Username   = ");
            usernameUser = inputLogin.next();
            System.out.print("Masukkan Password   = ");
            passwordUser = inputLogin.next();
            header();

            if (usernameDanPasswordUser[0].equals(usernameUser)
                    && usernameDanPasswordUser[1].equals(passwordUser)) {
                System.out.println("Login Successfully\n");
                login = true;
                break;
            } else if (loginAttempt >= 3) {
                System.out.println("Melebihi Maksimal Login Anda Akan Kembali Ke Menu Awal\n");
                login = false;
            } else {
                System.out.println("Login Gagal Silahkan Coba lagi");
            }
        }
        return login = true;
    }

    public static int pilihanLayanan(int dataBaru) {

        int biayaLayanan = 0;

        header();
        System.out.println("             Pilihan layanan");
        header();
        System.out.println("\n1. Regular");
        System.out.println("2. Ekspress\n");
        System.out.println("            Masukkan Pilihan");
        header();
        int jenisLayanan = inputPilihan.nextInt();

        switch (jenisLayanan) {
            case 1:
                System.out.println("Anda memilih layanan Regular.");
                biayaLayanan = 50;
                dataPengiriman[dataBaru][10] = "Regular";
                break;
            case 2:
                System.out.println("Anda memilih layanan Ekspress.");
                dataPengiriman[dataBaru][10] = "Ekspress";
                break;
            default:
                System.out.println("Layanan Tidak Tersedia. Masukkan Dengan Benar.\n");
                return pilihanLayanan(dataBaru);
        }

        return biayaLayanan;
    }

    public static int hitungJarak(String alamatPengirim, String alamatPenerima) {
        int jarak;

        if ((alamatPengirim.equalsIgnoreCase("Malang") && alamatPenerima.equalsIgnoreCase("Jakarta")) ||
                (alamatPengirim.equalsIgnoreCase("Jakarta") && alamatPenerima.equalsIgnoreCase("Malang"))) {
            jarak = 850;
        } else if ((alamatPengirim.equalsIgnoreCase("Malang") && alamatPenerima.equalsIgnoreCase("Bandung")) ||
                (alamatPengirim.equalsIgnoreCase("Bandung") && alamatPenerima.equalsIgnoreCase("Malang"))) {
            jarak = 700;
        } else if ((alamatPengirim.equalsIgnoreCase("Malang") && alamatPenerima.equalsIgnoreCase("Surabaya")) ||
                (alamatPengirim.equalsIgnoreCase("Surabaya") && alamatPenerima.equalsIgnoreCase("Malang"))) {
            jarak = 40;
        } else {
            System.out.println("Pengiriman tidak tersedia. Masukkan alamat dengan benar.\n");
            System.out.print("Masukkan Alamat Pengirim : ");
            alamatPengirim = inputDataPengiriman.next();

            System.out.print("Masukkan Alamat Penerima : ");
            alamatPenerima = inputDataPengiriman.next();

            return hitungJarak(alamatPengirim, alamatPenerima);
        }

        return jarak;
    }

    public static double hitungBiayaPengiriman(double panjangBarang, double lebarBarang, double tinggiBarang,
            double berat, int jarak, int biayaLayanan, int dataBaru) {

        double volume = panjangBarang * lebarBarang * tinggiBarang;
        String volumeString = String.valueOf(volume);
        dataPengiriman[dataBaru][16] = (volumeString);
        double biayaBerat = berat * volume;
        double totalBiaya = (jarak * biayaLayanan) + (biayaBerat / 2);

        return totalBiaya;
    }

    public static boolean cekResi(int dataBaru, boolean cekResi) {

        System.out.print("Masukkan Nomor Urut          : ");
        int cariNomorUrut = inputPilihan.nextInt();
        System.out.print("Silahkan Masukkan Nomor Resi : ");
        String cariNomorResi = inputPilihan.next();

        for (int i = 0; i < dataPengiriman.length;) {
            if (dataPengiriman[cariNomorUrut][18].equals(cariNomorResi)) {
                cekResi = true;
                cetakResi(dataBaru);
                break;
            } else {
                System.out.println("Nomor Resi Tidak Ditemukan");
            }

            System.out.print("Cek Lagi? (Y/N)");
            String pilihaString = inputPilihan.next();

            if (pilihaString.equalsIgnoreCase("y")) {
                cekResi(dataBaru, cekResi);
            } else if (pilihaString.equalsIgnoreCase("n")) {
                break;
            }
            break;
        }

        return cekResi;

    }

    public static boolean updateLokasiPaket(boolean update, int dataBaru) {

        System.out.print("Masukkan Nomor Urut          : ");
        int cariNomorUrut = inputPilihan.nextInt();
        System.out.print("Silahkan Masukkan Nomor Resi : ");
        String cariNomorResi = inputPilihan.next();

        for (int i = 0; i < dataPengiriman.length;) {
            if (dataPengiriman[cariNomorUrut][18].equals(cariNomorResi)) {
                update = true;
                System.out.print("Input Lokasi Paket  : ");
                String lokasiPaket = inputDataPengiriman.next();
                dataPengiriman[dataBaru][1] = lokasiPaket;
                break;
            } else {
                System.out.println("Nomor Resi Tidak Ditemukan");
            }

            System.out.print("Cek Lagi? (Y/N)");
            String pilihaString = inputPilihan.next();

            if (pilihaString.equalsIgnoreCase("y")) {
                updateLokasiPaket(update, dataBaru);
            } else if (pilihaString.equalsIgnoreCase("n")) {
                break;
            }
            break;
        }

        return update;

    }

}