import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Sistem_Ekspedisi {

    // DISCLAIMER !!!

    // Program ini hanya untuk pengiriman
    // 1. dari MALANG ke Jakarta, Bandung, Surabaya, Semarang, dan Serang (Bolak-balik)
    // 2. dari SURABAYA ke Solo (Bolak-balik)

    // Username dan Password ADMIN sudah di setting agar tidak semua orang dapat menginpukan pengiriman
    // Username : Wawan
    // Password : IniWawan

    // Untuk Username dan Password USER dapat anda buat sesuai keinginan anda

    static Scanner inputPilihan = new Scanner(System.in);
    static Scanner inputLogin = new Scanner(System.in);
    static Scanner inputDataPengiriman = new Scanner(System.in);

    static String dataPengiriman[][] = new String[50][25];
    static String usernameDanPasswordAdmin[] = new String[] { "Wawan", "IniWawan" };
    static String usernameDanPasswordUser[][] = new String[50][2];

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {

        boolean exitProgram = false;

        while (!exitProgram) {
            header();
            System.out.println(YELLOW + "              Pilih Bahasa" + RESET);
            System.out.println(YELLOW + "\033[3m            Select Language\033[0m" + RESET);
            header();
            System.out.println("\n1. Bahasa Indonesia");
            System.out.println("2. English");
            System.out.print("3. Keluar ");
            System.out.println("\033[3m(Exit)\033[0m\n");
            System.out.println("            Masukkan Pilihan");
            System.out.println("\033[3m              Enter Options\033[0m");
            header();

            int pilihan = inputPilihan.nextInt();

            switch (pilihan) {
                case 1:
                    BahasaIndonesia();
                    break;

                case 2:
                    Bahasainggris();
                    break;

                case 3:
                    exitProgram = true;
                    break;

                default:
                    header();
                    System.out.println(RED + "       Masukkan Pilihan Yang Benar" + RESET);
                    System.out.println(RED + "\033[3m          Enter Correct Option\033[0m" + RESET);
                    header();
                    break;
            }
        }

    }

    public static void BahasaIndonesia() {

        int pilihan;
        int dataBaru = 0;

        boolean menuLogin = true;
        boolean menu = true;
        boolean cekResi = false;
        boolean menuLaporan = true;

        while (menuLogin) {
            header();
            System.out.println(YELLOW + "            SELAMAT DATANG DI" + RESET);
            System.out.println(YELLOW + "              POS INDONESIA" + RESET);
            header();
            System.out.println("             Silahkan Login");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Kembali\n");
            System.out.println("            Masukkan Pilihan");
            header();
            pilihan = inputPilihan.nextInt();

            switch (pilihan) {
                case 1:
                    if (loginAdmin(true)) {
                        while (menu) {

                            header();
                            System.out.println(YELLOW + "               HALO ADMIN" + RESET);
                            header();
                            System.out.println("\n1. Input Paket Baru");
                            System.out.println("2. Input Lokasi Paket");
                            System.out.println("3. Cek Paket");
                            System.out.println("4. Laporan Keuangan");
                            System.out.println("5. Keluar\n");
                            System.out.println("            Masukkan Pilihan");
                            header();
                            pilihan = inputPilihan.nextInt();

                            switch (pilihan) {
                                case 1:

                                    inputDataPengiriman(dataBaru);

                                    break;

                                case 2:

                                    while (cekResi = true) {
                                        updateLokasiPaket(cekResi, dataBaru);

                                        System.out.print(YELLOW + "Update Lagi? (Y/N) : " + RESET);
                                        String kembaliKeMenu = inputPilihan.next();
                                        if (kembaliKeMenu.equalsIgnoreCase("N")) {
                                            break;
                                        } else if (kembaliKeMenu.equalsIgnoreCase("Y")) {
                                            cekResi = true;
                                        }
                                    }

                                    break;

                                case 3:

                                    while (cekResi = true) {
                                        cekResi(dataBaru, cekResi);

                                        System.out.print(YELLOW + "Cek Lagi? (Y/N) : " + RESET);
                                        String kembaliKeMenu = inputPilihan.next();
                                        if (kembaliKeMenu.equalsIgnoreCase("N")) {
                                            break;
                                        } else if (kembaliKeMenu.equalsIgnoreCase("Y")) {
                                            cekResi = true;
                                        }
                                    }

                                    break;

                                case 4:

                                    menuLaporanKeuangan(menuLaporan, pilihan);

                                    break;

                                case 5:

                                    header();
                                    System.out.println(YELLOW + "            KONFIRMASI KELUAR" + RESET);
                                    header();
                                    System.out.print(RED + "Anda Yakin Ingin Keluar (Y/N)? : " + RESET);
                                    String kembaliKeMenu = inputPilihan.next();
                                    if (kembaliKeMenu.equalsIgnoreCase("N")) {
                                        menu = true;
                                    } else if (kembaliKeMenu.equalsIgnoreCase("Y")) {
                                        breakText();
                                        menu = false;
                                    }

                                    break;

                                default:

                                    defaultText();

                                    break;
                            }
                        }
                    }
                    break;

                case 2:

                    menuAwalUser(menuLogin, cekResi, menuLaporan, dataBaru);

                    break;

                case 3:

                    breakText();

                    menuLogin = false;

                    break;

                default:

                    defaultText();

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

        String lokasiPaket, NamaPengirim, AlamatPengirim, TanggalPengiriman, BulanPengiriman, TahunPengiriman,
                NamaPenerima, AlamatPenerima, JenisBarang, NomorTeleponPengirim, NomorTeleponPenerima, KodePos,
                AlamatLengkapPenerima;

        double BeratBarang, Panjang, Lebar, Tinggi;

        dataBaru = searchingDataPengiriman();

        if (dataBaru != -1) {

            System.out.println("\nNama Admin              : " + usernameDanPasswordAdmin[0]);
            System.out.println("Nomor Urut              : " + (dataBaru + 1));
            dataPengiriman[dataBaru][0] = String.valueOf(dataBaru + 1);

            System.out.print("Lokasi Agen             : ");
            lokasiPaket = inputDataPengiriman.next();
            dataPengiriman[dataBaru][1] = lokasiPaket;

            System.out.print("Tanggal Pengiriman      : ");
            TanggalPengiriman = inputDataPengiriman.next();
            dataPengiriman[dataBaru][2] = TanggalPengiriman;

            System.out.print("Bulan Pengiriman        : ");
            BulanPengiriman = inputDataPengiriman.next();
            dataPengiriman[dataBaru][3] = BulanPengiriman;

            System.out.print("Tahun Pengiriman        : ");
            TahunPengiriman = inputDataPengiriman.next();
            dataPengiriman[dataBaru][4] = TahunPengiriman;
            inputDataPengiriman.nextLine();

            System.out.print("Nama Pengirim           : ");
            NamaPengirim = inputDataPengiriman.nextLine();
            dataPengiriman[dataBaru][5] = NamaPengirim;

            System.out.print("Nomor Telepon Pengirim  : ");
            NomorTeleponPengirim = inputDataPengiriman.next();
            dataPengiriman[dataBaru][6] = String.valueOf(NomorTeleponPengirim);

            System.out.print("Alamat Pengirim         : ");
            AlamatPengirim = inputDataPengiriman.next();
            dataPengiriman[dataBaru][7] = AlamatPengirim;
            inputDataPengiriman.nextLine();

            System.out.print("Nama Penerima           : ");
            NamaPenerima = inputDataPengiriman.nextLine();
            dataPengiriman[dataBaru][8] = NamaPenerima;

            System.out.print("Nomor Telepon Penerima  : ");
            NomorTeleponPenerima = inputDataPengiriman.next();
            dataPengiriman[dataBaru][9] = String.valueOf(NomorTeleponPenerima);

            System.out.print("Kota Penerima           : ");
            AlamatPenerima = inputDataPengiriman.next();
            dataPengiriman[dataBaru][10] = AlamatPenerima;
            inputDataPengiriman.nextLine();

            System.out.print("Alamat Lengkap Penerima : ");
            AlamatLengkapPenerima = inputDataPengiriman.nextLine();
            dataPengiriman[dataBaru][22] = AlamatLengkapPenerima;

            System.out.print("Kode Pos                : ");
            KodePos = inputDataPengiriman.next();
            dataPengiriman[dataBaru][11] = KodePos;
            inputDataPengiriman.nextLine();

            System.out.print("Jenis Barang            : ");
            JenisBarang = inputDataPengiriman.nextLine();
            dataPengiriman[dataBaru][12] = JenisBarang;

            System.out.print("Berat Barang (kg)       : ");
            BeratBarang = inputDataPengiriman.nextDouble();
            dataPengiriman[dataBaru][13] = String.valueOf(BeratBarang);

            System.out.print("Panjang Barang (cm)     : ");
            Panjang = inputDataPengiriman.nextDouble();
            dataPengiriman[dataBaru][14] = String.valueOf(Panjang);

            System.out.print("Lebar Barang (cm)       : ");
            Lebar = inputDataPengiriman.nextDouble();
            dataPengiriman[dataBaru][15] = String.valueOf(Lebar);

            System.out.print("Tinggi Barang (cm)      : ");
            Tinggi = inputDataPengiriman.nextDouble();
            dataPengiriman[dataBaru][16] = String.valueOf(Tinggi);

            double volume = hitungVolume(Panjang, Lebar, Tinggi, dataBaru);
            int biayaLayanan = pilihanLayanan(dataBaru, volume);
            int jarak = hitungJarak(dataBaru, AlamatPengirim, AlamatPenerima, biayaLayanan);
            double totalBiaya = hitungBiayaPengiriman(volume, BeratBarang, jarak, biayaLayanan, dataBaru);

            NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
            String formattedPrice = numberFormat.format(totalBiaya);
            dataPengiriman[dataBaru][19] = String.valueOf(formattedPrice);

            buatNomorResi(dataBaru);
            pembayaran(dataBaru);

            System.out.print(
                    YELLOW + "Memasukkan data pengiriman lagi? (Y/T) : " + RESET);
            String lanjutkan = inputDataPengiriman.next();
            if (lanjutkan.equalsIgnoreCase("Y")) {
                inputDataPengiriman(dataBaru);
            }

        } else {

            header();
            System.out.println(RED + "          Data Pengiriman Penuh" + RESET);
            header();

        }

    }

    public static void pembayaran(int dataBaru) {

        header();
        System.out.println(YELLOW + "               PEMBAYARAN" + RESET);
        header();
        System.out.println(" Pastikan Bahwa Pelanggan Sudah Membayar");
        System.out.println("\n1. Sudah");
        System.out.println("2. Belum");
        System.out.println("3. Batalkan Pengiriman\n");
        System.out.println("            Masukkan Pilihan");
        header();
        int pilihan = inputPilihan.nextInt();

        if (pilihan == 1) {

            cetakResi(dataBaru);

            header();
            System.out.println(YELLOW + "               TERIMA KASIH" + RESET);
            header();
            System.out.println(BLUE + "       Paket Akan Segera Dikirimkan" + RESET);
            header();

        } else if (pilihan == 2) {

            header();
            System.out.println(RED + "                  MAAF" + RESET);
            header();
            System.out.println(RED + "       Mohon Selesaikan Pembayaran" + RESET);
            header();

            pembayaran(dataBaru);

        } else if (pilihan == 3) {

            header();
            System.out.println(YELLOW + "               TERIMA KASIH" + RESET);
            header();

            for (int j = 0; j < 25; j++) {
                dataPengiriman[dataBaru][j] = null;
            }

        } else {

            header();
            System.out.println(RED + "                  MAAF" + RESET);
            header();
            System.out.println(RED + "       Masukkan Pilihan Yang Benar" + RESET);
            header();

            pembayaran(dataBaru);

        }

    }

    public static void cetakResi(int dataBaru) {

        header();
        System.out.println(YELLOW + "             DATA PENGIRIMAN" + RESET);
        header();

        System.out.println(
                "\nNomor Urut              : " + dataPengiriman[dataBaru][0]);
        System.out.println(
                "Lokasi Paket            : " + dataPengiriman[dataBaru][1]);
        System.out.println(
                "Estimasi Pengiriman     : " + dataPengiriman[dataBaru][21]);
        System.out.println(
                "Jenis Layanan           : " + dataPengiriman[dataBaru][17]);
        System.out.println(
                "Tanggal Pengiriman      : " + dataPengiriman[dataBaru][2] + "-" + dataPengiriman[dataBaru][3] + "-"
                        + dataPengiriman[dataBaru][4]);
        System.out.println(
                "Nama Pengirim           : " + dataPengiriman[dataBaru][5]);
        System.out.println(
                "Nomor Telepon Pengirim  : " + dataPengiriman[dataBaru][6]);
        System.out.println(
                "Alamat Pengirim         : " + dataPengiriman[dataBaru][7]);
        System.out.println(
                "Nama Penerima           : " + dataPengiriman[dataBaru][8]);
        System.out.println(
                "Nomor Telepon Penerima  : " + dataPengiriman[dataBaru][9]);
        System.out.println(
                "Kota Penerima           : " + dataPengiriman[dataBaru][10]);
        System.out.println(
                "Alamat Lengkap Penerima : " + dataPengiriman[dataBaru][22]);
        System.out.println(
                "Kode Pos                : " + dataPengiriman[dataBaru][11]);
        System.out
                .println("Jenis Barang            : "
                        + dataPengiriman[dataBaru][12]);
        System.out
                .println("Berat Barang (kg)       : "
                        + dataPengiriman[dataBaru][13]);
        System.out
                .println("Volume Barang (cm)      : "
                        + dataPengiriman[dataBaru][18]);
        System.out
                .println("Total Biaya             : " + YELLOW + "Rp."
                        + dataPengiriman[dataBaru][19] + RESET);
        System.out.println(
                "Nomor Resi              : " + YELLOW + dataPengiriman[dataBaru][20] + RESET);
        System.out.println();

    }

    public static String buatNomorResi(int dataBaru) {

        int jumlahAngka = 100000;
        Set<Integer> angkaRandom = new HashSet<>();
        Random random = new Random();

        while (angkaRandom.size() < jumlahAngka) {
            angkaRandom.add(random.nextInt(Integer.MAX_VALUE));
        }

        Integer[] hasilArray = angkaRandom.toArray(new Integer[0]);

        int angkaPertama = hasilArray[0];

        String hasilString = String.valueOf(angkaPertama);

        dataPengiriman[dataBaru][20] = (hasilString);

        header();
        System.out.println("Nomor Resi Anda adalah " + YELLOW + dataPengiriman[dataBaru][20] + RESET);
        header();
        System.out.println("Total Biaya adalah " + YELLOW + "Rp." + dataPengiriman[dataBaru][19] + RESET);
        header();

        return hasilString;
    }

    public static boolean loginAdmin(boolean login) {

        String usernameAdmin, passwordAdmin;
        int maxLoginAttempts = 3;
        login = false;

        for (int loginAttempt = 1; loginAttempt <= maxLoginAttempts; loginAttempt++) {

            header();
            System.out.println(YELLOW + "               Login Admin" + RESET);
            header();
            System.out.print("Masukkan Username   = ");
            usernameAdmin = inputLogin.next();
            System.out.print("Masukkan Password   = ");
            passwordAdmin = inputLogin.next();
            header();

            if (usernameDanPasswordAdmin[0].equals(usernameAdmin)
                    && usernameDanPasswordAdmin[1].equals(passwordAdmin)) {
                System.out.println(GREEN + "             Login Berhasil" + RESET);
                login = true;
                break;
            } else if (loginAttempt >= 3) {
                System.out.println(RED + "Melebihi Maksimal Login, Anda Akan Kembali Ke Menu Awal\n" + RESET);
                login = false;
            } else {
                System.out.println(RED + "     Login Gagal Silahkan Coba lagi" + RESET);
            }
        }
        return login;
    }

    public static boolean loginUser(boolean login, boolean menuLogin) {

        usernameDanPasswordUser[0][0] = "Iwan";
        usernameDanPasswordUser[0][1] = "IniIwan";

        String usernameUser, passwordUser;
        int maxLoginAttempts = 3;
        login = false;

        for (int loginAttempt = 1; loginAttempt <= maxLoginAttempts; loginAttempt++) {

            header();
            System.out.println(YELLOW + "                Login User" + RESET);
            header();
            System.out.print("Masukkan Username   = ");
            usernameUser = inputLogin.next();
            System.out.print("Masukkan Password   = ");
            passwordUser = inputLogin.next();
            header();

            if (buatAkunUser(usernameUser, passwordUser)) {
                System.out.println(GREEN + "             Login Berhasil" + RESET);
                login = true;
                break;
            } else if (loginAttempt >= 3) {
                System.out.println(RED + "Melebihi Maksimal Login Anda Akan Kembali Ke Menu Awal\n" + RESET);
                login = false;
                break;
            } else {
                System.out.println(RED + "     Login Gagal Silahkan Coba lagi" + RESET);
            }

        }
        return login;
    }

    public static int pilihanLayanan(int dataBaru, double volume) {

        int biayaLayanan = 0;

        header();
        System.out.println(YELLOW + "             Pilihan layanan" + RESET);
        header();
        System.out.println("\n1. Regular");
        System.out.println("2. Ekspress");
        System.out.println("3. Kargo\n");
        System.out.println("            Masukkan Pilihan");
        header();
        int jenisLayanan = inputPilihan.nextInt();

        switch (jenisLayanan) {
            case 1:
                biayaLayanan = 50;
                dataPengiriman[dataBaru][17] = "Regular";
                break;
            case 2:
                biayaLayanan = 75;
                dataPengiriman[dataBaru][17] = "Ekspress";
                break;
            case 3:
                if (volume >= 10000) {
                    biayaLayanan = 100;
                    dataPengiriman[dataBaru][17] = "Kargo";
                } else {
                    header();
                    System.out.println(YELLOW + "        Paket anda terlalu kecil" + RESET);
                    System.out.println(YELLOW + "       Silahkan pilih layanan lain" + RESET);
                    header();

                    return pilihanLayanan(dataBaru, volume);
                }
                break;
            default:
                header();
                System.out.println(RED + "Layanan Tidak Tersedia. Masukkan Dengan Benar.\n" + RESET);
                return pilihanLayanan(dataBaru, volume);
        }

        return biayaLayanan;
    }

    public static int hitungJarak(int dataBaru, String alamatPengirim, String alamatPenerima, int biayaLayanan) {

        int jarak;

        if ((alamatPengirim.equalsIgnoreCase("Malang") && alamatPenerima.equalsIgnoreCase("Jakarta")) ||
                (alamatPengirim.equalsIgnoreCase("Jakarta") && alamatPenerima.equalsIgnoreCase("Malang"))) {
            jarak = 850;
            if (biayaLayanan == 50) {
                dataPengiriman[dataBaru][21] = "5 Hari";
            } else if (biayaLayanan == 75) {
                dataPengiriman[dataBaru][21] = "4 Hari";
            } else {
                dataPengiriman[dataBaru][21] = "7 Hari";
            }
        } else if ((alamatPengirim.equalsIgnoreCase("Malang") && alamatPenerima.equalsIgnoreCase("Bandung")) ||
                (alamatPengirim.equalsIgnoreCase("Bandung") && alamatPenerima.equalsIgnoreCase("Malang"))) {
            jarak = 700;
            if (biayaLayanan == 50) {
                dataPengiriman[dataBaru][21] = "6 Hari";
            } else if (biayaLayanan == 75) {
                dataPengiriman[dataBaru][21] = "5 Hari";
            } else {
                dataPengiriman[dataBaru][21] = "8 Hari";
            }
        } else if ((alamatPengirim.equalsIgnoreCase("Malang") && alamatPenerima.equalsIgnoreCase("Surabaya")) ||
                (alamatPengirim.equalsIgnoreCase("Surabaya") && alamatPenerima.equalsIgnoreCase("Malang"))) {
            jarak = 40;
            if (biayaLayanan == 50) {
                dataPengiriman[dataBaru][21] = "2 Hari";
            } else if (biayaLayanan == 75) {
                dataPengiriman[dataBaru][21] = "1 Hari";
            } else {
                dataPengiriman[dataBaru][21] = "3 Hari";
            }
        } else if ((alamatPengirim.equalsIgnoreCase("Malang") && alamatPenerima.equalsIgnoreCase("Semarang")) ||
                (alamatPengirim.equalsIgnoreCase("Semarang") && alamatPenerima.equalsIgnoreCase("Malang"))) {
            jarak = 400;
            if (biayaLayanan == 50) {
                dataPengiriman[dataBaru][21] = "3 Hari";
            } else if (biayaLayanan == 75) {
                dataPengiriman[dataBaru][21] = "2 Hari";
            } else {
                dataPengiriman[dataBaru][21] = "5 Hari";
            }
        } else if ((alamatPengirim.equalsIgnoreCase("Malang") && alamatPenerima.equalsIgnoreCase("Serang")) ||
                (alamatPengirim.equalsIgnoreCase("Serang") && alamatPenerima.equalsIgnoreCase("Malang"))) {
            jarak = 900;
            if (biayaLayanan == 50) {
                dataPengiriman[dataBaru][21] = "7 Hari";
            } else if (biayaLayanan == 75) {
                dataPengiriman[dataBaru][21] = "5 Hari";
            } else {
                dataPengiriman[dataBaru][21] = "10 Hari";
            }
        } else if ((alamatPengirim.equalsIgnoreCase("Surabaya") && alamatPenerima.equalsIgnoreCase("Solo")) ||
                (alamatPengirim.equalsIgnoreCase("Solo") && alamatPenerima.equalsIgnoreCase("Surabaya"))) {
            jarak = 250;
            if (biayaLayanan == 50) {
                dataPengiriman[dataBaru][21] = "5 Hari";
            } else if (biayaLayanan == 75) {
                dataPengiriman[dataBaru][21] = "4 Hari";
            } else {
                dataPengiriman[dataBaru][21] = "6 Hari";
            }
        } else {
            System.out.println(RED + "Pengiriman tidak tersedia. Masukkan alamat dengan benar.\n" + RESET);
            System.out.print("Masukkan Alamat Pengirim : ");
            alamatPengirim = inputDataPengiriman.next();
            dataPengiriman[dataBaru][7] = alamatPengirim;

            System.out.print("Kota Penerima            : ");
            alamatPenerima = inputDataPengiriman.next();
            dataPengiriman[dataBaru][10] = alamatPenerima;
            inputDataPengiriman.nextLine();

            System.out.print("Alamat Lengkap Penerima  : ");
            String AlamatLengkapPenerima = inputDataPengiriman.nextLine();
            dataPengiriman[dataBaru][22] = AlamatLengkapPenerima;

            hitungJarak(dataBaru, alamatPengirim, alamatPenerima, biayaLayanan);

            return hitungJarak(dataBaru, alamatPengirim, alamatPenerima, biayaLayanan);
        }

        return jarak;
    }

    public static double hitungVolume(double panjangBarang, double lebarBarang, double tinggiBarang, int dataBaru) {

        double volume = panjangBarang * lebarBarang * tinggiBarang;
        String volumeString = String.valueOf(volume);
        dataPengiriman[dataBaru][18] = (volumeString);

        return volume;
    }

    public static double hitungBiayaPengiriman(double volume, double berat, int jarak, int biayaLayanan, int dataBaru) {

        double biayaVolume = volume;
        double biayaBerat = berat * 5000;
        double biaya = 0;

        if (biayaBerat > biayaVolume) {
            biaya = biayaBerat;
        } else if (biayaVolume > biayaBerat) {
            biaya = biayaVolume;
        }

        double totalBiaya = (jarak * biayaLayanan) + biaya;

        return totalBiaya;
    }

    public static int searchingResi(String resiToFind) {
        int foundIndex = -1;
        for (int i = 0; i < dataPengiriman.length; i++) {
            if (dataPengiriman[i][2] != null && dataPengiriman[i][20].equals(resiToFind)) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }

    public static int searchingDataPengiriman() {
        int foundIndex = -1;
        for (int dataBaru = 0; dataBaru < 50; dataBaru++) {
            if (dataPengiriman[dataBaru][0] == null) {
                foundIndex = dataBaru;
                break;
            }
        }
        return foundIndex;
    }

    public static boolean cekResi(int dataBaru, boolean cekResi) {

        System.out.print("\nSilahkan Masukkan Nomor Resi : ");
        String cariNomorResi = inputPilihan.next();

        int index = searchingResi(cariNomorResi);

        if (index != -1) {
            cekResi = true;
            cetakResi(index);
        } else {
            cekResi = false;
            System.out.println(RED + "Nomor Resi Tidak Ditemukan" + RESET);
        }

        return cekResi;
    }

    public static boolean updateLokasiPaket(boolean update, int index) {

        System.out.print("\nSilahkan Masukkan Nomor Resi : ");
        String cariNomorResi = inputPilihan.next();

        index = searchingResi(cariNomorResi);

        if (index != -1) {
            update = true;
            System.out.print("Input Lokasi Paket           : ");
            String lokasiPaket = inputDataPengiriman.next();
            dataPengiriman[index][1] = lokasiPaket;

            cetakResi(index);

        } else {
            update = false;
            System.out.println(RED + "Nomor Resi Tidak Ditemukan" + RESET);
        }

        return update;
    }

    public static void breakText() {

        header();
        System.out.println(YELLOW + "      TERIMA KASIH - POS INDONESIA" + RESET);
        header();

    }

    public static void defaultText() {

        header();
        System.out.println(RED + "       Masukkan Pilihan Yang Benar" + RESET);
        header();

    }

    public static boolean laporanKeuanganHarian(boolean menuLaporan) {

        header();
        System.out.println(YELLOW + "             Laporan Harian" + RESET);
        header();

        System.out.print("\nMasukkan Tanggal        : ");
        int cariTanggal = inputPilihan.nextInt();
        String caritanggalString = String.valueOf(cariTanggal);

        System.out.print("Masukkan Bulan          : ");
        int cariBulan = inputPilihan.nextInt();
        String cariBulanString = String.valueOf(cariBulan);

        int totalHarian = 0;
        boolean foundData = false;

        header();
        System.out.println(YELLOW + "          Rincian Pendapatan" + RESET);
        header();

        System.out.println("\nTanggal                : " + caritanggalString);
        System.out.println("Bulan                  : " + cariBulanString + "\n");

        for (int i = 0; i < dataPengiriman.length; i++) {

            if (dataPengiriman[i][0] != null && dataPengiriman[i][2].equals(caritanggalString)
                    && dataPengiriman[i][3].equals(cariBulanString)) {

                String totalHarianString = String.valueOf(dataPengiriman[i][19]);
                System.out.println("Rp." + totalHarianString);
                totalHarianString = totalHarianString.replace(",", "");
                totalHarian += Integer.parseInt(totalHarianString);
                foundData = true;

            }

        }

        if (foundData) {
            NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
            String formattedPrice = numberFormat.format(totalHarian);
            header();
            System.out.println("\nTotal Pendapatan Pada Tanggal " + cariTanggal + " Bulan \n" + cariBulan + " adalah "
                    + YELLOW + "Rp."
                    + formattedPrice + RESET);
            header();
        } else {
            System.out.println(RED + "Data tidak ditemukan pada bulan " + YELLOW + cariBulanString + RESET);
            header();
        }

        System.out.print("Cek Lagi? (Y/N) : ");
        String kembaliKeMenu = inputPilihan.next();
        if (kembaliKeMenu.equalsIgnoreCase("Y")) {
            laporanKeuanganHarian(menuLaporan);
        } else if (kembaliKeMenu.equalsIgnoreCase("N")) {
            menuLaporanKeuangan(menuLaporan, totalHarian);
        }

        return menuLaporan;

    }

    public static boolean laporanKeuanganBulanan(boolean menuLaporan) {

        System.out.print("Masukkan Bulan          : ");
        int cariBulan = inputPilihan.nextInt();
        String cariBulanString = String.valueOf(cariBulan);

        int totalBulanan = 0;
        boolean foundData = false;

        header();
        System.out.println(YELLOW + "          Rincian Pendapatan" + RESET);
        header();

        System.out.println("Bulan                  : " + cariBulanString + "\n");

        for (int i = 0; i < dataPengiriman.length; i++) {
            if (dataPengiriman[i][0] != null && dataPengiriman[i][3].equals(cariBulanString)) {
                String totalHarianString = String.valueOf(dataPengiriman[i][19]);
                System.out.println("Rp." + totalHarianString);
                totalHarianString = totalHarianString.replace(",", "");
                totalBulanan += Integer.parseInt(totalHarianString);
                foundData = true;
            }
        }

        if (foundData) {
            NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
            String formattedPrice = numberFormat.format(totalBulanan);
            header();
            System.out.println("\nTotal Pendapatan Pada Bulan " + cariBulan + " adalah " + YELLOW + "Rp."
                    + formattedPrice + RESET);
            header();
        } else {
            System.out.println(RED + "Data tidak ditemukan pada bulan " + cariBulanString + RESET);
            header();
        }

        System.out.print("Cek Lagi? (Y/N) : ");
        String kembaliKeMenu = inputPilihan.next();
        if (kembaliKeMenu.equalsIgnoreCase("Y")) {
            laporanKeuanganBulanan(menuLaporan);
        } else if (kembaliKeMenu.equalsIgnoreCase("N")) {
            menuLaporanKeuangan(menuLaporan, totalBulanan);
        }

        return menuLaporan;

    }

    public static boolean menuLaporanKeuangan(boolean menuLaporan, int pilihan) {

        while (menuLaporan = true) {
            header();
            System.out.println(YELLOW + "            LAPORAN KEUANGAN" + RESET);
            header();
            System.out.println("1. Laporan Keuangan Harian");
            System.out.println("2. Laporan Keuangan Bulanan");
            System.out.println("3. Kembali\n");
            System.out.println("            Masukkan Pilihan");
            header();
            pilihan = inputPilihan.nextInt();

            switch (pilihan) {
                case 1:

                    laporanKeuanganHarian(menuLaporan);

                    break;

                case 2:

                    laporanKeuanganBulanan(menuLaporan);

                    break;

                case 3:
                    breakText();
                    menuLaporan = false;
                    break;

                default:
                    menuLaporanKeuangan(menuLaporan, pilihan);
                    menuLaporan = true;
            }

            break;

        }

        return menuLaporan;

    }

    public static boolean buatAkunUser(String Username, String Password) {
        boolean login = false;

        for (int i = 0; i < 50; i++) {
            if (usernameDanPasswordUser[i][0] != null && usernameDanPasswordUser[i][0].equals(Username)
                    && usernameDanPasswordUser[i][1] != null && usernameDanPasswordUser[i][1].equals(Password)) {
                login = true;
                return true;
            }
        }
        return login;
    }

    public static void menuAwalUser(boolean menuLogin, boolean cekResi, boolean menu, int dataBaru) {

        int pilihan;

        menu = true;

        while (menu) {
            header();
            System.out.println("                HALO USER");
            header();
            System.out.println("             Silahkan Login");
            System.out.println("1. Login");
            System.out.println("2. Buat Akun");
            System.out.println("3. Kembali\n");
            System.out.println("            Masukkan Pilihan");
            header();
            pilihan = inputPilihan.nextInt();

            switch (pilihan) {
                case 1:

                    menuKeduaUser(menuLogin, cekResi, menu, dataBaru);

                    break;

                case 2:

                    header();
                    System.out.println(YELLOW + "              Buat Akun Baru" + RESET);
                    header();

                    for (int i = 0; i < usernameDanPasswordUser.length; i++) {
                        if (usernameDanPasswordUser[i][0] == null
                                && usernameDanPasswordUser[i][1] == null) {
                            System.out.print("Masukkan Username   : ");
                            usernameDanPasswordUser[i][0] = inputLogin.next();

                            System.out.print("Masukkan Password   : ");
                            usernameDanPasswordUser[i][1] = inputLogin.next();

                            header();
                            System.out.println(GREEN + "           Berhasil Buat Akun" + RESET);
                            System.out.println(GREEN + "         Silahkan Login Kembali" + RESET);
                            header();

                            break;

                        }
                    }

                    break;

                case 3:

                    header();
                    System.out.println(YELLOW + "            KONFIRMASI KELUAR" + RESET);
                    header();
                    System.out.print(RED + "Anda Yakin Ingin Keluar (Y/N)? : " + RESET);
                    String kembaliKeMenu = inputPilihan.next();
                    if (kembaliKeMenu.equalsIgnoreCase("N")) {
                        menu = true;
                    } else if (kembaliKeMenu.equalsIgnoreCase("Y")) {
                        breakText();
                        menu = false;
                    }

                    break;

                default:

                    defaultText();

                    menu = true;
            }
        }
    }

    public static void menuKeduaUser(boolean menuLogin, boolean cekResi, boolean menu, int dataBaru) {

        int pilihan;
        menuLogin = true;

        if (loginUser(true, true)) {
            while (menuLogin) {
                header();
                System.out.println("                HALO USER");
                header();
                System.out.println("             Silahkan Login");
                System.out.println("1. Cek Paket");
                System.out.println("2. Kembali\n");
                System.out.println("            Masukkan Pilihan");
                header();
                pilihan = inputPilihan.nextInt();

                switch (pilihan) {
                    case 1:

                        while (cekResi = true) {
                            cekResi(dataBaru, cekResi);

                            System.out.print("Cek Lagi? (Y/N) : ");
                            String kembaliKeMenu = inputPilihan.next();
                            if (kembaliKeMenu.equalsIgnoreCase("N")) {
                                menuLogin = true;
                                menu = true;
                                break;
                            } else if (kembaliKeMenu.equalsIgnoreCase("Y")) {
                                cekResi = true;
                            }
                        }

                        break;

                    case 2:

                        breakText();

                        menuLogin = false;

                        break;

                    default:

                        defaultText();

                        break;
                }
            }
        }
    }

    // Bilingual Bahasa Inggris

    public static void Bahasainggris() {

        int pilihan;
        int dataBaru = 0;

        boolean menuLogin = true;
        boolean menu = true;
        boolean cekResi = false;
        boolean menuLaporan = true;

        while (menuLogin) {
            header();
            System.out.println(YELLOW + "        WELCOME TO POS INDONESIA" + RESET);
            header();
            System.out.println("              Please Login");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Back\n");
            System.out.println("              Enter Options");
            header();
            pilihan = inputPilihan.nextInt();

            switch (pilihan) {
                case 1:
                    if (loginAdminInggris(true)) {
                        while (menu) {

                            header();
                            System.out.println(YELLOW + "               HELLO ADMIN" + RESET);
                            header();
                            System.out.println("\n1. Add New Package");
                            System.out.println("2. Input Package Location");
                            System.out.println("3. Check Package");
                            System.out.println("4. Financial Report");
                            System.out.println("5. Exit\n");
                            System.out.println("              Enter Options");
                            header();
                            pilihan = inputPilihan.nextInt();

                            switch (pilihan) {
                                case 1:

                                    inputDataPengirimanInggris(dataBaru);

                                    break;

                                case 2:

                                    while (cekResi = true) {
                                        updateLokasiPaketInggris(cekResi, dataBaru);

                                        System.out.print(YELLOW + "Update again? (Y/N) : " + RESET);
                                        String kembaliKeMenu = inputPilihan.next();
                                        if (kembaliKeMenu.equalsIgnoreCase("N")) {
                                            break;
                                        } else if (kembaliKeMenu.equalsIgnoreCase("Y")) {
                                            cekResi = true;
                                        }
                                    }

                                    break;

                                case 3:

                                    while (cekResi = true) {
                                        cekResi(dataBaru, cekResi);

                                        System.out.print(YELLOW + "Check again? (Y/N) : " + RESET);
                                        String kembaliKeMenu = inputPilihan.next();
                                        if (kembaliKeMenu.equalsIgnoreCase("N")) {
                                            break;
                                        } else if (kembaliKeMenu.equalsIgnoreCase("Y")) {
                                            cekResi = true;
                                        }
                                    }

                                    break;

                                case 4:

                                    menuLaporanKeuanganInggris(menuLaporan, pilihan);

                                    break;

                                case 5:

                                    header();
                                    System.out.println(YELLOW + "              CONFIRM EXIT" + RESET);
                                    header();
                                    System.out.print(RED + "Are you sure you want to quit? (Y/N)? : " + RESET);
                                    String kembaliKeMenu = inputPilihan.next();
                                    if (kembaliKeMenu.equalsIgnoreCase("N")) {
                                        menu = true;
                                    } else if (kembaliKeMenu.equalsIgnoreCase("Y")) {
                                        breakText();
                                        menu = false;
                                    }

                                    break;

                                default:

                                    defaultTextInggris();

                                    break;
                            }
                        }
                    }
                    break;

                case 2:

                    menuAwalUserInggris(menuLogin, cekResi, menuLaporan, dataBaru);

                    break;

                case 3:

                    breakTextInggris();

                    menuLogin = false;

                    break;

                default:

                    defaultTextInggris();

                    break;
            }
        }
    }

    public static void inputDataPengirimanInggris(int dataBaru) {

        String lokasiPaket, NamaPengirim, AlamatPengirim, TanggalPengiriman, BulanPengiriman, TahunPengiriman,
                NamaPenerima, AlamatPenerima, JenisBarang, NomorTeleponPengirim, NomorTeleponPenerima, KodePos,
                AlamatLengkapPenerima;

        double BeratBarang, Panjang, Lebar, Tinggi;

        dataBaru = searchingDataPengirimanInggris();

        if (dataBaru != -1) {

            System.out.println("\nAdmin Name                : " + usernameDanPasswordAdmin[0]);
            System.out.println("Number                    : " + (dataBaru + 1));
            dataPengiriman[dataBaru][0] = String.valueOf(dataBaru + 1);

            System.out.print("Agent Location            : ");
            lokasiPaket = inputDataPengiriman.next();
            dataPengiriman[dataBaru][1] = lokasiPaket;

            System.out.print("Delivery Date             : ");
            TanggalPengiriman = inputDataPengiriman.next();
            dataPengiriman[dataBaru][2] = TanggalPengiriman;

            System.out.print("Delivery Month            : ");
            BulanPengiriman = inputDataPengiriman.next();
            dataPengiriman[dataBaru][3] = BulanPengiriman;

            System.out.print("Delivery Year             : ");
            TahunPengiriman = inputDataPengiriman.next();
            dataPengiriman[dataBaru][4] = TahunPengiriman;
            inputDataPengiriman.nextLine();

            System.out.print("Sender's Name             : ");
            NamaPengirim = inputDataPengiriman.nextLine();
            dataPengiriman[dataBaru][5] = NamaPengirim;

            System.out.print("Sender's Phone Number     : ");
            NomorTeleponPengirim = inputDataPengiriman.next();
            dataPengiriman[dataBaru][6] = String.valueOf(NomorTeleponPengirim);

            System.out.print("Sender's Address          : ");
            AlamatPengirim = inputDataPengiriman.next();
            dataPengiriman[dataBaru][7] = AlamatPengirim;
            inputDataPengiriman.nextLine();

            System.out.print("Recipient's Name          : ");
            NamaPenerima = inputDataPengiriman.nextLine();
            dataPengiriman[dataBaru][8] = NamaPenerima;

            System.out.print("Recipient's Phone Number  : ");
            NomorTeleponPenerima = inputDataPengiriman.next();
            dataPengiriman[dataBaru][9] = String.valueOf(NomorTeleponPenerima);

            System.out.print("Receiving City            : ");
            AlamatPenerima = inputDataPengiriman.next();
            dataPengiriman[dataBaru][10] = AlamatPenerima;
            inputDataPengiriman.nextLine();

            System.out.print("Full Address of Recipient : ");
            AlamatLengkapPenerima = inputDataPengiriman.nextLine();
            dataPengiriman[dataBaru][22] = AlamatLengkapPenerima;

            System.out.print("Postcode                  : ");
            KodePos = inputDataPengiriman.next();
            dataPengiriman[dataBaru][11] = KodePos;
            inputDataPengiriman.nextLine();

            System.out.print("Item Type                 : ");
            JenisBarang = inputDataPengiriman.nextLine();
            dataPengiriman[dataBaru][12] = JenisBarang;

            System.out.print("Item Weight (kg)          : ");
            BeratBarang = inputDataPengiriman.nextDouble();
            dataPengiriman[dataBaru][13] = String.valueOf(BeratBarang);

            System.out.print("Item Length (cm)          : ");
            Panjang = inputDataPengiriman.nextDouble();
            dataPengiriman[dataBaru][14] = String.valueOf(Panjang);

            System.out.print("Item Width (cm)           : ");
            Lebar = inputDataPengiriman.nextDouble();
            dataPengiriman[dataBaru][15] = String.valueOf(Lebar);

            System.out.print("Item Height (cm)          : ");
            Tinggi = inputDataPengiriman.nextDouble();
            dataPengiriman[dataBaru][16] = String.valueOf(Tinggi);

            double volume = hitungVolumeInggris(Panjang, Lebar, Tinggi, dataBaru);
            int biayaLayanan = pilihanLayananInggris(dataBaru, volume);
            int jarak = hitungJarakInggris(dataBaru, AlamatPengirim, AlamatPenerima, biayaLayanan);
            double totalBiaya = hitungBiayaPengirimanInggris(volume, BeratBarang, jarak, biayaLayanan, dataBaru);

            NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
            String formattedPrice = numberFormat.format(totalBiaya);
            dataPengiriman[dataBaru][19] = String.valueOf(formattedPrice);

            buatNomorResiInggris(dataBaru);
            pembayaranInggris(dataBaru);

            System.out.print(
                    YELLOW + "Enter shipping data again? (Y/N) : " + RESET);
            String lanjutkan = inputDataPengiriman.next();
            if (lanjutkan.equalsIgnoreCase("Y")) {
                inputDataPengirimanInggris(dataBaru);
            }

        } else {

            header();
            System.out.println(RED + "           Full Shipping Data" + RESET);
            header();

        }

    }

    public static void pembayaranInggris(int dataBaru) {

        header();
        System.out.println(YELLOW + "               PAYMENT" + RESET);
        header();
        System.out.println("    Ensure That The Customer Has Paid");
        System.out.println("\n1. Done");
        System.out.println("2. Not Yet");
        System.out.println("3. Cancel Shipping\n");
        System.out.println("              Enter Options");
        header();
        int pilihan = inputPilihan.nextInt();

        if (pilihan == 1) {

            cetakResiInggris(dataBaru);

            header();
            System.out.println(YELLOW + "                THANK YOU" + RESET);
            header();
            System.out.println(BLUE + "   The package will be delivered soon" + RESET);
            header();

        } else if (pilihan == 2) {

            header();
            System.out.println(RED + "                  SORRY" + RESET);
            header();
            System.out.println(RED + "       Please complete the payment" + RESET);
            header();

            pembayaranInggris(dataBaru);

        } else if (pilihan == 3) {

            header();
            System.out.println(YELLOW + "                THANK YOU" + RESET);
            header();

            for (int j = 0; j < 25; j++) {
                dataPengiriman[dataBaru][j] = null;
            }

        } else {

            header();
            System.out.println(RED + "                 SORRY" + RESET);
            header();
            System.out.println(RED + "          Enter Correct Options" + RESET);
            header();

            pembayaranInggris(dataBaru);

        }

    }

    public static void cetakResiInggris(int dataBaru) {

        header();
        System.out.println(YELLOW + "              SHIPPING DATA" + RESET);
        header();

        System.out.println(
                "\nNumber                    : " + dataPengiriman[dataBaru][0]);
        System.out.println(
                "Package Location            : " + dataPengiriman[dataBaru][1]);
        System.out.println(
                "Estimated Shipping          : " + dataPengiriman[dataBaru][21]);
        System.out.println(
                "Service Type                : " + dataPengiriman[dataBaru][17]);
        System.out.println(
                "Delivery Date               : " + dataPengiriman[dataBaru][2] + "-" + dataPengiriman[dataBaru][3] + "-"
                        + dataPengiriman[dataBaru][4]);
        System.out.println(
                "Sender's Name               : " + dataPengiriman[dataBaru][5]);
        System.out.println(
                "Sender's Phone Number       : " + dataPengiriman[dataBaru][6]);
        System.out.println(
                "Sender's Address            : " + dataPengiriman[dataBaru][7]);
        System.out.println(
                "Recipient's Name            : " + dataPengiriman[dataBaru][8]);
        System.out.println(
                "Recipient's Phone Number    : " + dataPengiriman[dataBaru][9]);
        System.out.println(
                "KReceiving City             : " + dataPengiriman[dataBaru][10]);
        System.out.println(
                "Full Address of Recipient   : " + dataPengiriman[dataBaru][22]);
        System.out.println(
                "Postcode                    : " + dataPengiriman[dataBaru][11]);
        System.out
                .println("Item Type                   : "
                        + dataPengiriman[dataBaru][12]);
        System.out
                .println("Item Weight (kg)            : "
                        + dataPengiriman[dataBaru][13]);
        System.out
                .println("Item Volume (cm)            : "
                        + dataPengiriman[dataBaru][18]);
        System.out
                .println("Total Cost                  : " + YELLOW + "Rp."
                        + dataPengiriman[dataBaru][19] + RESET);
        System.out.println(
                "Receipt Number              : " + YELLOW + dataPengiriman[dataBaru][20] + RESET);
        System.out.println();

    }

    public static String buatNomorResiInggris(int dataBaru) {

        int jumlahAngka = 100000;
        Set<Integer> angkaRandom = new HashSet<>();
        Random random = new Random();

        while (angkaRandom.size() < jumlahAngka) {
            angkaRandom.add(random.nextInt(Integer.MAX_VALUE));
        }

        Integer[] hasilArray = angkaRandom.toArray(new Integer[0]);

        int angkaPertama = hasilArray[0];

        String hasilString = String.valueOf(angkaPertama);

        dataPengiriman[dataBaru][20] = (hasilString);

        header();
        System.out.println("Your Receipt Number is " + YELLOW + dataPengiriman[dataBaru][20] + RESET);
        header();
        System.out.println("Total Cost is " + YELLOW + "Rp." + dataPengiriman[dataBaru][19] + RESET);
        header();

        return hasilString;
    }

    public static boolean loginAdminInggris(boolean login) {

        String usernameAdmin, passwordAdmin;
        int maxLoginAttempts = 3;
        login = false;

        for (int loginAttempt = 1; loginAttempt <= maxLoginAttempts; loginAttempt++) {

            header();
            System.out.println(YELLOW + "               Login Admin" + RESET);
            header();
            System.out.print("Enter Username      = ");
            usernameAdmin = inputLogin.next();
            System.out.print("Enter Password      = ");
            passwordAdmin = inputLogin.next();
            header();

            if (usernameDanPasswordAdmin[0].equals(usernameAdmin)
                    && usernameDanPasswordAdmin[1].equals(passwordAdmin)) {
                System.out.println(GREEN + "           Login Successfully" + RESET);
                login = true;
                break;
            } else if (loginAttempt >= 3) {
                System.out.println(RED + "Exceeding the Maximum Login, You Will Return to the Start Menu\n" + RESET);
                login = false;
            } else {
                System.out.println(RED + "      Login Failed Please Try Again" + RESET);
            }
        }
        return login;
    }

    public static boolean loginUserInggris(boolean login, boolean menuLogin) {

        usernameDanPasswordUser[0][0] = "Iwan";
        usernameDanPasswordUser[0][1] = "IniIwan";

        String usernameUser, passwordUser;
        int maxLoginAttempts = 3;
        login = false;

        for (int loginAttempt = 1; loginAttempt <= maxLoginAttempts; loginAttempt++) {

            header();
            System.out.println(YELLOW + "                Login User" + RESET);
            header();
            System.out.print("Enter Username      = ");
            usernameUser = inputLogin.next();
            System.out.print("Enter Password      = ");
            passwordUser = inputLogin.next();
            header();

            if (buatAkunUserInggris(usernameUser, passwordUser)) {
                System.out.println(GREEN + "           Login Successfully" + RESET);
                login = true;
                break;
            } else if (loginAttempt >= 3) {
                System.out.println(RED + "Exceeding the Maximum Login, You Will Return to the Start Menu\n" + RESET);
                login = false;
                break;
            } else {
                System.out.println(RED + "      Login Failed Please Try Again" + RESET);
            }

        }
        return login;
    }

    public static int pilihanLayananInggris(int dataBaru, double volume) {

        int biayaLayanan = 0;

        header();
        System.out.println(YELLOW + "             Service Options" + RESET);
        header();
        System.out.println("\n1. Regular");
        System.out.println("2. Express");
        System.out.println("3. Cargo\n");
        System.out.println("            Masukkan Pilihan");
        header();
        int jenisLayanan = inputPilihan.nextInt();

        switch (jenisLayanan) {
            case 1:
                biayaLayanan = 50;
                dataPengiriman[dataBaru][17] = "Regular";
                break;
            case 2:
                biayaLayanan = 75;
                dataPengiriman[dataBaru][17] = "Express";
                break;
            case 3:
                if (volume >= 10000) {
                    biayaLayanan = 100;
                    dataPengiriman[dataBaru][17] = "Cargo";
                } else {
                    header();
                    System.out.println(YELLOW + "        Your package is too small" + RESET);
                    System.out.println(YELLOW + "      Please choose another service" + RESET);
                    header();

                    return pilihanLayananInggris(dataBaru, volume);
                }
                break;
            default:
                header();
                System.out.println(RED + "Service Unavailable. Enter Correctly.\n" + RESET);
                return pilihanLayananInggris(dataBaru, volume);
        }

        return biayaLayanan;
    }

    public static int hitungJarakInggris(int dataBaru, String alamatPengirim, String alamatPenerima, int biayaLayanan) {

        int jarak;

        if ((alamatPengirim.equalsIgnoreCase("Malang") && alamatPenerima.equalsIgnoreCase("Jakarta")) ||
                (alamatPengirim.equalsIgnoreCase("Jakarta") && alamatPenerima.equalsIgnoreCase("Malang"))) {
            jarak = 850;
            if (biayaLayanan == 50) {
                dataPengiriman[dataBaru][21] = "5 Days";
            } else if (biayaLayanan == 75) {
                dataPengiriman[dataBaru][21] = "4 Days";
            } else {
                dataPengiriman[dataBaru][21] = "7 Days";
            }
        } else if ((alamatPengirim.equalsIgnoreCase("Malang") && alamatPenerima.equalsIgnoreCase("Bandung")) ||
                (alamatPengirim.equalsIgnoreCase("Bandung") && alamatPenerima.equalsIgnoreCase("Malang"))) {
            jarak = 700;
            if (biayaLayanan == 50) {
                dataPengiriman[dataBaru][21] = "6 Days";
            } else if (biayaLayanan == 75) {
                dataPengiriman[dataBaru][21] = "5 Days";
            } else {
                dataPengiriman[dataBaru][21] = "8 Days";
            }
        } else if ((alamatPengirim.equalsIgnoreCase("Malang") && alamatPenerima.equalsIgnoreCase("Surabaya")) ||
                (alamatPengirim.equalsIgnoreCase("Surabaya") && alamatPenerima.equalsIgnoreCase("Malang"))) {
            jarak = 40;
            if (biayaLayanan == 50) {
                dataPengiriman[dataBaru][21] = "2 Days";
            } else if (biayaLayanan == 75) {
                dataPengiriman[dataBaru][21] = "1 Days";
            } else {
                dataPengiriman[dataBaru][21] = "3 Days";
            }
        } else if ((alamatPengirim.equalsIgnoreCase("Malang") && alamatPenerima.equalsIgnoreCase("Semarang")) ||
                (alamatPengirim.equalsIgnoreCase("Semarang") && alamatPenerima.equalsIgnoreCase("Malang"))) {
            jarak = 400;
            if (biayaLayanan == 50) {
                dataPengiriman[dataBaru][21] = "3 Days";
            } else if (biayaLayanan == 75) {
                dataPengiriman[dataBaru][21] = "2 Days";
            } else {
                dataPengiriman[dataBaru][21] = "5 Days";
            }
        } else if ((alamatPengirim.equalsIgnoreCase("Malang") && alamatPenerima.equalsIgnoreCase("Serang")) ||
                (alamatPengirim.equalsIgnoreCase("Serang") && alamatPenerima.equalsIgnoreCase("Malang"))) {
            jarak = 900;
            if (biayaLayanan == 50) {
                dataPengiriman[dataBaru][21] = "7 Days";
            } else if (biayaLayanan == 75) {
                dataPengiriman[dataBaru][21] = "5 Days";
            } else {
                dataPengiriman[dataBaru][21] = "10 Days";
            }
        } else if ((alamatPengirim.equalsIgnoreCase("Surabaya") && alamatPenerima.equalsIgnoreCase("Solo")) ||
                (alamatPengirim.equalsIgnoreCase("Solo") && alamatPenerima.equalsIgnoreCase("Surabaya"))) {
            jarak = 250;
            if (biayaLayanan == 50) {
                dataPengiriman[dataBaru][21] = "5 Days";
            } else if (biayaLayanan == 75) {
                dataPengiriman[dataBaru][21] = "4 Days";
            } else {
                dataPengiriman[dataBaru][21] = "6 Days";
            }
        } else {
            System.out.println(RED + "Shipping is not available. Enter address correctly.\n" + RESET);
            System.out.print("Sender's Address          : ");
            alamatPengirim = inputDataPengiriman.next();
            dataPengiriman[dataBaru][7] = alamatPengirim;

            System.out.print("Receiving City            : ");
            alamatPenerima = inputDataPengiriman.next();
            dataPengiriman[dataBaru][10] = alamatPenerima;
            inputDataPengiriman.nextLine();

            System.out.print("Full Address of Recipient : ");
            String AlamatLengkapPenerima = inputDataPengiriman.nextLine();
            dataPengiriman[dataBaru][22] = AlamatLengkapPenerima;

            hitungJarakInggris(dataBaru, alamatPengirim, alamatPenerima, biayaLayanan);

            return hitungJarakInggris(dataBaru, alamatPengirim, alamatPenerima, biayaLayanan);
        }

        return jarak;
    }

    public static double hitungVolumeInggris(double panjangBarang, double lebarBarang, double tinggiBarang,
            int dataBaru) {

        double volume = panjangBarang * lebarBarang * tinggiBarang;
        String volumeString = String.valueOf(volume);
        dataPengiriman[dataBaru][18] = (volumeString);

        return volume;
    }

    public static double hitungBiayaPengirimanInggris(double volume, double berat, int jarak, int biayaLayanan,
            int dataBaru) {

        double biayaVolume = volume;
        double biayaBerat = berat * 5000;
        double biaya = 0;

        if (biayaBerat > biayaVolume) {
            biaya = biayaBerat;
        } else if (biayaVolume > biayaBerat) {
            biaya = biayaVolume;
        }

        double totalBiaya = (jarak * biayaLayanan) + biaya;

        return totalBiaya;
    }

    public static int searchingResiInggris(String resiToFind) {
        int foundIndex = -1;
        for (int i = 0; i < dataPengiriman.length; i++) {
            if (dataPengiriman[i][2] != null && dataPengiriman[i][20].equals(resiToFind)) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }

    public static int searchingDataPengirimanInggris() {
        int foundIndex = -1;
        for (int dataBaru = 0; dataBaru < 50; dataBaru++) {
            if (dataPengiriman[dataBaru][0] == null) {
                foundIndex = dataBaru;
                break;
            }
        }
        return foundIndex;
    }

    public static boolean cekResiInggris(int dataBaru, boolean cekResi) {

        System.out.print("\nPlease Enter Receipt Number   : ");
        String cariNomorResi = inputPilihan.next();

        int index = searchingResiInggris(cariNomorResi);

        if (index != -1) {
            cekResi = true;
            cetakResiInggris(index);
        } else {
            cekResi = false;
            System.out.println(RED + "Receipt Number Not Found" + RESET);
        }

        return cekResi;
    }

    public static boolean updateLokasiPaketInggris(boolean update, int index) {

        System.out.print("\nPlease Enter Receipt Number   : ");
        String cariNomorResi = inputPilihan.next();

        index = searchingResiInggris(cariNomorResi);

        if (index != -1) {
            update = true;
            System.out.print("Enter Package Location        : ");
            String lokasiPaket = inputDataPengiriman.next();
            dataPengiriman[index][1] = lokasiPaket;

            cetakResiInggris(index);

        } else {
            update = false;
            System.out.println(RED + "Receipt Number Not Found" + RESET);
        }

        return update;
    }

    public static void breakTextInggris() {

        header();
        System.out.println(YELLOW + "        THANK YOU - POS INDONESIA" + RESET);
        header();

    }

    public static void defaultTextInggris() {

        header();
        System.out.println(RED + "          Enter Correct Option" + RESET);
        header();

    }

    public static boolean laporanKeuanganHarianInggris(boolean menuLaporan) {

        header();
        System.out.println(YELLOW + "               Daily Report" + RESET);
        header();

        System.out.print("\nEnter Date            : ");
        int cariTanggal = inputPilihan.nextInt();
        String caritanggalString = String.valueOf(cariTanggal);

        System.out.print("Enter Month             : ");
        int cariBulan = inputPilihan.nextInt();
        String cariBulanString = String.valueOf(cariBulan);

        int totalHarian = 0;
        boolean foundData = false;

        header();
        System.out.println(YELLOW + "             Income Details" + RESET);
        header();

        System.out.println("\nDate                   : " + caritanggalString);
        System.out.println("Month                  : " + cariBulanString + "\n");

        for (int i = 0; i < dataPengiriman.length; i++) {

            if (dataPengiriman[i][0] != null && dataPengiriman[i][2].equals(caritanggalString)
                    && dataPengiriman[i][3].equals(cariBulanString)) {

                String totalHarianString = String.valueOf(dataPengiriman[i][19]);
                System.out.println("Rp." + totalHarianString);
                totalHarianString = totalHarianString.replace(",", "");
                totalHarian += Integer.parseInt(totalHarianString);
                foundData = true;

            }

        }

        if (foundData) {
            NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
            String formattedPrice = numberFormat.format(totalHarian);
            header();
            System.out.println("\nTotal Income on " + cariTanggal + " of \n" + cariBulan + " is "
                    + YELLOW + "Rp."
                    + formattedPrice + RESET);
            header();
        } else {
            System.out.println(RED + "Data was not found in " + YELLOW + cariBulanString + RESET);
            header();
        }

        System.out.print("Check again? (Y/N) : ");
        String kembaliKeMenu = inputPilihan.next();
        if (kembaliKeMenu.equalsIgnoreCase("Y")) {
            laporanKeuanganHarianInggris(menuLaporan);
        } else if (kembaliKeMenu.equalsIgnoreCase("N")) {
            menuLaporanKeuanganInggris(menuLaporan, totalHarian);
        }

        return menuLaporan;

    }

    public static boolean laporanKeuanganBulananInggris(boolean menuLaporan) {

        System.out.print("Enter Month             : ");
        int cariBulan = inputPilihan.nextInt();
        String cariBulanString = String.valueOf(cariBulan);

        int totalBulanan = 0;
        boolean foundData = false;

        header();
        System.out.println(YELLOW + "             Income Details" + RESET);
        header();

        System.out.println("Month                  : " + cariBulanString + "\n");

        for (int i = 0; i < dataPengiriman.length; i++) {
            if (dataPengiriman[i][0] != null && dataPengiriman[i][3].equals(cariBulanString)) {
                String totalHarianString = String.valueOf(dataPengiriman[i][19]);
                System.out.println("Rp." + totalHarianString);
                totalHarianString = totalHarianString.replace(",", "");
                totalBulanan += Integer.parseInt(totalHarianString);
                foundData = true;
            }
        }

        if (foundData) {
            NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
            String formattedPrice = numberFormat.format(totalBulanan);
            header();
            System.out.println("\nTotal Income on Month " + cariBulan + " is " + YELLOW + "Rp."
                    + formattedPrice + RESET);
            header();
        } else {
            System.out.println(RED + "Data was not found in Month " + cariBulanString + RESET);
            header();
        }

        System.out.print("Check again? (Y/N) : ");
        String kembaliKeMenu = inputPilihan.next();
        if (kembaliKeMenu.equalsIgnoreCase("Y")) {
            laporanKeuanganBulananInggris(menuLaporan);
        } else if (kembaliKeMenu.equalsIgnoreCase("N")) {
            menuLaporanKeuanganInggris(menuLaporan, totalBulanan);
        }

        return menuLaporan;

    }

    public static boolean menuLaporanKeuanganInggris(boolean menuLaporan, int pilihan) {

        while (menuLaporan = true) {
            header();
            System.out.println(YELLOW + "            FINANCIAL REPORT" + RESET);
            header();
            System.out.println("1. Daily Financial Report");
            System.out.println("2. Monthly Financial Report");
            System.out.println("3. Back\n");
            System.out.println("              Enter Options");
            header();
            pilihan = inputPilihan.nextInt();

            switch (pilihan) {
                case 1:

                    laporanKeuanganHarianInggris(menuLaporan);

                    break;

                case 2:

                    laporanKeuanganBulananInggris(menuLaporan);

                    break;

                case 3:
                    breakTextInggris();
                    menuLaporan = false;
                    break;

                default:
                    menuLaporanKeuanganInggris(menuLaporan, pilihan);
                    menuLaporan = true;
            }

            break;

        }

        return menuLaporan;

    }

    public static boolean buatAkunUserInggris(String Username, String Password) {
        boolean login = false;

        for (int i = 0; i < 50; i++) {
            if (usernameDanPasswordUser[i][0] != null && usernameDanPasswordUser[i][0].equals(Username)
                    && usernameDanPasswordUser[i][1] != null && usernameDanPasswordUser[i][1].equals(Password)) {
                login = true;
                return true;
            }
        }
        return login;
    }

    public static void menuAwalUserInggris(boolean menuLogin, boolean cekResi, boolean menu, int dataBaru) {

        int pilihan;

        menu = true;

        while (menu) {
            header();
            System.out.println("               HELLO USER");
            header();
            System.out.println("              Please Login");
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Back\n");
            System.out.println("              Enter Options");
            header();
            pilihan = inputPilihan.nextInt();

            switch (pilihan) {
                case 1:

                    menuKeduaUserInggris(menuLogin, cekResi, menu, dataBaru);

                    break;

                case 2:

                    header();
                    System.out.println(YELLOW + "          Create a New Account" + RESET);
                    header();

                    for (int i = 0; i < usernameDanPasswordUser.length; i++) {
                        if (usernameDanPasswordUser[i][0] == null
                                && usernameDanPasswordUser[i][1] == null) {
                            System.out.print("Enter Username      : ");
                            usernameDanPasswordUser[i][0] = inputLogin.next();

                            System.out.print("Enter Password      : ");
                            usernameDanPasswordUser[i][1] = inputLogin.next();

                            header();
                            System.out.println(GREEN + "        Create Account Successfully" + RESET);
                            System.out.println(GREEN + "             Please Login Again" + RESET);
                            header();

                            break;

                        }
                    }

                    break;

                case 3:

                    header();
                    System.out.println(YELLOW + "              CONFIRM EXIT" + RESET);
                    header();
                    System.out.print(RED + "Are you sure you want to quit? (Y/N)? : " + RESET);
                    String kembaliKeMenu = inputPilihan.next();
                    if (kembaliKeMenu.equalsIgnoreCase("N")) {
                        menu = true;
                    } else if (kembaliKeMenu.equalsIgnoreCase("Y")) {
                        breakText();
                        menu = false;
                    }

                    break;

                default:

                    defaultTextInggris();

                    menu = true;
            }
        }
    }

    public static void menuKeduaUserInggris(boolean menuLogin, boolean cekResi, boolean menu, int dataBaru) {

        int pilihan;

        if (loginUserInggris(true, true)) {

            while (menuLogin) {
                header();
                System.out.println("        WELCOME TO POS INDONESIA");
                header();
                System.out.println("              Please Login");
                System.out.println("1. Check Package");
                System.out.println("2. Back\n");
                System.out.println("              Enter Options");
                header();
                pilihan = inputPilihan.nextInt();

                switch (pilihan) {
                    case 1:

                        while (cekResi = true) {

                            cekResi(dataBaru, cekResi);

                            System.out.print("Check again (Y/N) : ");
                            String kembaliKeMenu = inputPilihan.next();
                            if (kembaliKeMenu.equalsIgnoreCase("N")) {
                                menuLogin = true;
                                menu = true;
                                break;
                            } else if (kembaliKeMenu.equalsIgnoreCase("Y")) {
                                cekResi = true;
                            }
                        }

                        break;

                    case 2:

                        breakTextInggris();

                        menuLogin = false;

                        break;

                    default:

                        defaultTextInggris();

                        break;
                }
            }
        }
    }

}