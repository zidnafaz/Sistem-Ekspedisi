import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class FungsiKel05_18 {

    static Scanner inputPilihan = new Scanner(System.in);
    static Scanner inputLogin = new Scanner(System.in);
    static Scanner inputDataPengiriman = new Scanner(System.in);

    static String dataPengiriman[][] = new String[50][25];
    static String usernameDanPasswordAdmin[] = new String[] { "Wawan", "IniWawan" };
    static String usernameDanPasswordUser[] = new String[] { "Iwan", "IniIwan" };

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {

        int pilihan;
        int dataBaru = 0;
        String pilihaString;

        boolean menuLogin = true;
        boolean menu = true;
        boolean cekResi = false;
        boolean menuLaporan = true;

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
                        while (menu) {

                            header();
                            System.out.println("               HELLO ADMIN");
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

                                    while (cekResi = true) {
                                        updateLokasiPaket(cekResi, dataBaru);

                                        System.out.print("Update Lagi? (Y/N) : ");
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

                                        System.out.print("Cek Lagi? (Y/N) : ");
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

                                    breakText();

                                    menu = false;

                                    break;

                                default:

                                    defaultText();

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

                                    while (cekResi = true) {
                                        cekResi(dataBaru, cekResi);

                                        System.out.print("Cek Lagi? (Y/N) : ");
                                        String kembaliKeMenu = inputPilihan.next();
                                        if (kembaliKeMenu.equalsIgnoreCase("N")) {
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

                    break;

                case 3:

                    menuLogin = false;

                    breakText();

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

        for (dataBaru = 0; dataBaru < 50; dataBaru++) {

            if (dataPengiriman[dataBaru][0] == null) {

                System.out.println("Nama Admin              : " + usernameDanPasswordAdmin[0]);
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

                System.out.print("Nama Pengirim           : ");
                NamaPengirim = inputDataPengiriman.next();
                dataPengiriman[dataBaru][5] = NamaPengirim;

                System.out.print("Nomor Telepon Pengirim  : ");
                NomorTeleponPengirim = inputDataPengiriman.next();
                dataPengiriman[dataBaru][6] = String.valueOf(NomorTeleponPengirim);

                System.out.print("Alamat Pengirim         : ");
                AlamatPengirim = inputDataPengiriman.next();
                dataPengiriman[dataBaru][7] = AlamatPengirim;

                System.out.print("Nama Penerima           : ");
                NamaPenerima = inputDataPengiriman.next();
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

                System.out.print("Jenis Barang            : ");
                JenisBarang = inputDataPengiriman.next();
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

                System.out.println(
                        "Apakah ingin memasukkan data pengiriman lagi? (Y/T)");
                String lanjutkan = inputDataPengiriman.next();
                if (lanjutkan.equalsIgnoreCase("T")) {
                    break;
                }

            } else {

                header();
                System.out.println("          Data Pengiriman Penuh");
                header();

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
        System.out.println("3. Batalkan Pengiriman");
        System.out.println("            Masukkan Pilihan");
        header();
        int pilihan = inputPilihan.nextInt();

        if (pilihan == 1) {

            cetakResi(dataBaru);

            header();
            System.out.println("               TERIMA KASIH");
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

        } else if (pilihan == 3) {

            header();
            System.out.println("               TERIMA KASIH");
            header();

            for (int j = 0; j < 25; j++) {
                dataPengiriman[dataBaru][j] = null;
            }

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
                .println("Total Biaya             : Rp."
                        + dataPengiriman[dataBaru][19]);
        System.out.println(
                "Nomor Resi              : " + dataPengiriman[dataBaru][20]);
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
        System.out.println("Nomor Resi Anda adalah " + dataPengiriman[dataBaru][20]);
        header();
        System.out.println("Total Biaya adalah Rp." + dataPengiriman[dataBaru][19]);
        header();

        return hasilString;
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
                System.out.println("           Login Successfully");
                login = true;
                break;
            } else if (loginAttempt >= 3) {
                System.out.println("Melebihi Maksimal Login, Anda Akan Kembali Ke Menu Awal\n");
                login = false;
            } else {
                System.out.println("     Login Gagal Silahkan Coba lagi");
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
                System.out.println("           Login Successfully");
                login = true;
                break;
            } else if (loginAttempt >= 3) {
                System.out.println("Melebihi Maksimal Login Anda Akan Kembali Ke Menu Awal\n");
                login = false;
            } else {
                System.out.println("     Login Gagal Silahkan Coba lagi");
            }
        }
        return login = true;
    }

    public static int pilihanLayanan(int dataBaru, double volume) {

        int biayaLayanan = 0;

        header();
        System.out.println("             Pilihan layanan");
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
                if (volume >= 1000000) {
                    biayaLayanan = 100;
                    dataPengiriman[dataBaru][17] = "Kargo";
                } else {
                    header();
                    System.out.println("        Paket anda terlalu kecil");
                    System.out.println("       Silahkan pilih layanan lain");
                    header();

                    pilihanLayanan(dataBaru, volume);
                }
                break;
            default:
                System.out.println("Layanan Tidak Tersedia. Masukkan Dengan Benar.\n");
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
            System.out.println("Pengiriman tidak tersedia. Masukkan alamat dengan benar.\n");
            System.out.print("Masukkan Alamat Pengirim : ");
            alamatPengirim = inputDataPengiriman.next();

            System.out.print("Masukkan Alamat Penerima : ");
            alamatPenerima = inputDataPengiriman.next();

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

    public static boolean cekResi(int dataBaru, boolean cekResi) {

        System.out.print("Silahkan Masukkan Nomor Resi : ");
        String cariNomorResi = inputPilihan.next();

        int index = searchingResi(cariNomorResi);

        if (index != -1) {
            cekResi = true;
            cetakResi(index);
        } else {
            cekResi = false;
            System.out.println("Nomor Resi Tidak Ditemukan");
        }

        return cekResi;
    }

    public static boolean updateLokasiPaket(boolean update, int index) {

        System.out.print("Silahkan Masukkan Nomor Resi : ");
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
            System.out.println("Nomor Resi Tidak Ditemukan");
        }

        return update;
    }

    public static void breakText() {

        header();
        System.out.println("        THANK YOU - POS INDONESIA");
        header();

    }

    public static void defaultText() {

        header();
        System.out.println("       Masukkan Pilihan Yang Benar");
        header();

    }

    public static boolean laporanKeuanganHarian(boolean menuLaporan) {

        System.out.print("\nMasukkan Tanggal        : ");
        int cariTanggal = inputPilihan.nextInt();
        String caritanggalString = String.valueOf(cariTanggal);

        System.out.print("Masukkan Bulan          : ");
        int cariBulan = inputPilihan.nextInt();
        String cariBulanString = String.valueOf(cariBulan);

        int totalHarian = 0;
        boolean foundData = false;

        header();
        System.out.println("          Rincian Pendapatan");
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
            System.out.println("\nTotal Pendapatan Pada Tanggal " + cariTanggal + " Bulan " + cariBulan + " adalah Rp."
                    + formattedPrice);
            header();
        } else {
            System.out.println("\nData tidak ditemukan pada bulan " + cariBulanString);
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
        System.out.println("          Rincian Pendapatan");
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
            System.out.println("\nTotal Pendapatan Pada Bulan " + cariBulan + " adalah Rp." + formattedPrice);
            header();
        } else {
            System.out.println("Data tidak ditemukan pada bulan " + cariBulanString);
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
            System.out.println("            Laporan Keuangan");
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

}