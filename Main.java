import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputPilihan = new Scanner(System.in);
        Scanner inputLoginAdmin = new Scanner(System.in);
        Scanner inputLoginUser = new Scanner(System.in);

        String usernameAdmin, passwordAdmin, // Login Admin
                
                UpdateLokasi, // Menu Admin

                usernameUser, passwordUser; // Login User

        int maxLoginAttempts = 3, // Login

                pilihan, PilihanAdmin, // Menu Admin
                NomorResiUpadate, PilihanPayment,
                PilihanLaporan,
                PilihanBulanan, PilihanHarian;

        boolean Login = false; // Login

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
        int[] NomorResi = new int[1];
        double[] BeratBarang = new double[1];

        int Jarak = 0, BiayaLayanan = 0, TotalBiaya;

        System.out.println("\n========== Welcome to Pos Indonesia ==========");
        System.out.println("|                                              |");
        System.out.println("|               Please Login Here              |");
        System.out.println("|                                              |");
        System.out.println("|         1. Admin                             |");
        System.out.println("|         2. User                              |");
        System.out.println("|                                              |\n");
        System.out.println("============= Masukkan Pilihan Anda ============");
        pilihan = inputPilihan.nextInt();

        switch (pilihan) {
            case 1:

                for (int loginAttempt = 1; loginAttempt <= maxLoginAttempts; loginAttempt++) {

                    System.out.println("\n============== Login Admin ==============\n");
                    System.out.print("Masukkan Username   = ");
                    usernameAdmin = inputLoginAdmin.next();
                    System.out.print("Masukkan Password   = ");
                    passwordAdmin = inputLoginAdmin.next();
                    System.out.println("\n=========================================\n");

                    if (usernameAdmin.equals("Admin1") && passwordAdmin.equals("IniAdmin1")) {
                        System.out.println("Login Successfully\n");
                        Login = true;
                    } else {
                        System.out.println("Failed Login Please Try Again or Create Account via Admin\n");
                    }
                    break;
                }

                if (Login) {

                    System.out.println("\n================= Pos Indonesia ================");
                    System.out.println("|                                              |");
                    System.out.println("|   Hello Admin, Welcome to Admin Dashboard    |");
                    System.out.println("|                                              |");
                    System.out.println("|         1. Input Paket Baru                  |");
                    System.out.println("|         2. Input Lokasi Paket                |");
                    System.out.println("|         3. Laporan Keuangan                  |");
                    System.out.println("|                                              |\n");
                    System.out.println("============= Masukkan Pilihan Anda ============");

                    PilihanAdmin = inputPilihan.nextInt();

                    switch (PilihanAdmin) {
                        case 1:
                            Scanner inputDataPengiriman = new Scanner(System.in);

                            /*
                             * Tarif Jarak ( \ km = 50)
                             * 
                             * / Malang - Bandung = 700km
                             * / Malang - Jakarta = 800km
                             * / Malang - Surabaya = 40km
                             * 
                             * Tarif Berat ( \ kg = 5000)
                             */

                             System.out.println("\n============= Informasi Pengiriman =============");
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
                             System.out.print("Jenis Layanan             : ");
                             JenisLayanan[0] = inputDataPengiriman.next();
                             System.out.print("Jenis Barang              : ");
                             JenisBarang[0] = inputDataPengiriman.next();
                             System.out.print("Nomor Resi                : ");
                             NomorResi[0] = inputDataPengiriman.nextInt();
                             System.out.print("Berat Barang (in kg)      : ");
                             BeratBarang[0] = inputDataPengiriman.nextDouble();

                            // Perhitungan Layanan

                            if (JenisLayanan[0].equals("Regular")) {

                                BiayaLayanan = 50;

                            } else if (JenisLayanan[0].equals("Ekspress")) {

                                BiayaLayanan = 75;

                            } else {

                                System.out.println("Layanan Tidak Tersedia");

                            }

                            if (AlamatPenerima[0].equals("Malang") && AlamatPengirim[0].equals("Jakarta")) {
                                Jarak = 850;
                            } else if (AlamatPenerima[0].equals("Malang") && AlamatPengirim[0].equals("Bandung")) {
                                Jarak = 700;
                            } else if (AlamatPenerima[0].equals("Malang") && AlamatPengirim[0].equals("Surabaya")) {
                                Jarak = 40;
                            } else if (AlamatPenerima[0].equals("Jakarta") && AlamatPengirim[0].equals("Malang")) {
                                Jarak = 850;
                            } else if (AlamatPenerima[0].equals("Jakarta") && AlamatPengirim[0].equals("Bandung")) {
                                Jarak = 150;
                            } else if (AlamatPenerima[0].equals("Jakarta") && AlamatPengirim[0].equals("Surabaya")) {
                                Jarak = 800;
                            } else if (AlamatPenerima[0].equals("Bandung") && AlamatPengirim[0].equals("Malang")) {
                                Jarak = 700;
                            } else if (AlamatPenerima[0].equals("Bandung") && AlamatPengirim[0].equals("Surabaya")) {
                                Jarak = 750;
                            } else if (AlamatPenerima[0].equals("Bandung") && AlamatPengirim[0].equals("Jakarta")) {
                                Jarak = 150;
                            } else if (AlamatPenerima[0].equals("Surabaya") && AlamatPengirim[0].equals("Malang")) {
                                Jarak = 40;
                            } else if (AlamatPenerima[0].equals("Surabaya") && AlamatPengirim[0].equals("Jakarta")) {
                                Jarak = 800;
                            } else if (AlamatPenerima[0].equals("Surabaya") && AlamatPengirim[0].equals("Bandung")) {
                                Jarak = 750;
                            } else {
                                System.out.println("Pengiriman tidak tersedia pada kota tersebut");
                            }


                            TotalBiaya = (int) (Jarak * BiayaLayanan + BeratBarang[0] * 5000);

                            boolean payment;
                            while (payment = true) {
                                System.out.println("\n============= Resi Pengiriman =============");
                                System.out.println("Nama Pengirim             : " + NamaPengirim[0]);
                                System.out.println("Nomor Telepon Pengirim    : " + NomorTeleponPengirim[0]);
                                System.out.println("Alamat Pengirim           : " + AlamatPengirim[0]);
                                System.out.println("Tanggal Pengiriman        : " + TanggalPengiriman[0]);
                                System.out.println("Nama Penerima             : " + NamaPenerima[0]);
                                System.out.println("Nomor Telepon Penerima    : " + NomorTeleponPenerima[0]);
                                System.out.println("Alamat Penerima           : " + AlamatPenerima[0]);
                                System.out.println("Kode Pos                  : " + KodePos[0]);
                                System.out.println("Jenis Layanan             : " + JenisLayanan[0]);
                                System.out.println("Jenis Barang              : " + JenisBarang[0]);
                                System.out.println("Nomor Resi                : " + NomorResi[0]);
                                System.out.println("Berat Barang (in kg)      : " + BeratBarang[0]);
                                System.out.println("________________________________________________");
                                System.out.println("Total Biaya               : Rp." + TotalBiaya);
                                System.out.println("=================== Payment ====================");
                                System.out.println("|                                              |");
                                System.out.println("|           Make Sure That Customer            |");
                                System.out.println("|             Has Made a Payement              |");
                                System.out.println("|                                              |");
                                System.out.println("|         1. Done                              |");
                                System.out.println("|         2. Undone                            |");
                                System.out.println("|                                              |\n");
                                System.out.println("============= Masukkan Pilihan Anda ============");
                                PilihanPayment = inputPilihan.nextInt();

                                if (PilihanPayment == 1) {

                                    System.out.println("\n================= Thank You ===================");
                                    System.out.println("|                                              |");
                                    System.out.println("|       Your package will be sent soon         |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                    break;

                                } else if (PilihanPayment == 2) {

                                    System.out.println("\n=================== Sorry =====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|          Please Finish The Payment           |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");

                                } else {

                                    System.out.println("\n=================== Sorry =====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|       Please Insert The Right Options        |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");

                                }
                            }

                            break;

                        case 2:
                            Scanner inputLokasiPaket = new Scanner(System.in);

                            System.out.println("\n================= Pos Indonesia ================");
                            System.out.println("|                                              |");
                            System.out.println("|         Hello Admin, Please Insert           |");
                            System.out.println("|           The Location Of Package            |");
                            System.out.println("|                                              |");
                            System.out.println("================= Pos Indonesia ================\n");
                            System.out.println("Nomor Resi          : ");
                            NomorResiUpadate = inputLokasiPaket.nextInt();
                            System.out.println("Lokasi Paket        : ");
                            UpdateLokasi = inputLokasiPaket.next();
                            System.out.println("\n================= Thank You ===================");
                            System.out.println("|                                              |");
                            System.out.println(
                                    "|      Package Number :           " + NomorResiUpadate + "               |");
                            System.out.println("|    Is Now At      :           " + UpdateLokasi + "               |");
                            System.out.println("|                                              |");
                            System.out.println("|                Have a Nice Day               |");
                            System.out.println("|                                              |\n");
                            System.out.println("================= Pos Indonesia ================\n");
                            break;
                        case 3:

                            System.out.println("\n============ Financial Statements =============");
                            System.out.println("|                                              |");
                            System.out.println("|           Select Financial Reports           |");
                            System.out.println("|                                              |");
                            System.out.println("|         1. Daily                             |");
                            System.out.println("|         2. Mountly                           |");
                            System.out.println("|                                              |\n");
                            System.out.println("============= Masukkan Pilihan Anda ============");
                            PilihanLaporan = inputPilihan.nextInt();
// LaporanKeuangan
                            if (PilihanLaporan == 1) {

                                System.out.println("\n============ Financial Statements =============");
                                System.out.println("|                                              |");
                                System.out.println("|                  Select Day                  |");
                                System.out.println("|                                              |");
                                System.out.println("|         1. Sunday                            |");
                                System.out.println("|         2. Monday                            |");
                                System.out.println("|         3. Tuesday                           |");
                                System.out.println("|         4. Wednesday                         |");
                                System.out.println("|         5. Thursday                          |");
                                System.out.println("|         6. Friday                            |");
                                System.out.println("|         7. Saturday                          |");
                                System.out.println("|                                              |\n");
                                System.out.println("============= Masukkan Pilihan Anda ============");
                                PilihanHarian = inputPilihan.nextInt();

                                if (PilihanHarian == 1) {
                                    System.out.println("\n=================== Sunday ====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanHarian == 2) {
                                    System.out.println("\n=================== Monday ====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanHarian == 3) {
                                    System.out.println("\n================== Tuesday ====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanHarian == 4) {
                                    System.out.println("\n================= Wednesday ===================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanHarian == 5) {
                                    System.out.println("\n================== Thursday ===================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanHarian == 6) {
                                    System.out.println("\n=================== Friday ====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanHarian == 7) {
                                    System.out.println("\n================== Saturday ===================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                }

                            } else if (PilihanLaporan == 2) {

                                System.out.println("\n============ Financial Statements =============");
                                System.out.println("|                                              |");
                                System.out.println("|                   Select Mount               |");
                                System.out.println("|                                              |");
                                System.out.println("|         1. January                           |");
                                System.out.println("|         2. February                          |");
                                System.out.println("|         3. March                             |");
                                System.out.println("|         4. April                             |");
                                System.out.println("|         5. May                               |");
                                System.out.println("|         6. June                              |");
                                System.out.println("|         7. July                              |");
                                System.out.println("|         8. August                            |");
                                System.out.println("|         9. September                         |");
                                System.out.println("|         10. October                          |");
                                System.out.println("|         11. November                         |");
                                System.out.println("|         12. December                         |");
                                System.out.println("|                                              |\n");
                                System.out.println("============= Masukkan Pilihan Anda ============");
                                PilihanBulanan = inputPilihan.nextInt();

                                if (PilihanBulanan == 1) {
                                    System.out.println("\n=================== January ====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanBulanan == 2) {
                                    System.out.println("\n=================== February ====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanBulanan == 3) {
                                    System.out.println("\n================== March ====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanBulanan == 4) {
                                    System.out.println("\n================= April ===================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanBulanan == 5) {
                                    System.out.println("\n================== May ===================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanBulanan == 6) {
                                    System.out.println("\n=================== June ====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanBulanan == 7) {
                                    System.out.println("\n================== July ===================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanBulanan == 8) {
                                    System.out.println("\n=================== August ====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanBulanan == 9) {
                                    System.out.println("\n=================== September ====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanBulanan == 10) {
                                    System.out.println("\n================== October ====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanBulanan == 11) {
                                    System.out.println("\n================= November ===================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else if (PilihanBulanan == 12) {
                                    System.out.println("\n================== Desember ===================");
                                    System.out.println("|                                              |");
                                    System.out.println("|                    Income                    |");
                                    System.out.println("|                                              |");
                                    System.out.println("|                Rp. 000.000.000               |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");
                                } else {
                                    
                                    System.out.println("\n=================== Sorry =====================");
                                    System.out.println("|                                              |");
                                    System.out.println("|       Please Insert The Right Options        |");
                                    System.out.println("|                                              |");
                                    System.out.println("================= Pos Indonesia ================\n");

                                }

                            }

                            break;

                        default:
                            System.out.println("Masukkan Pilihan Yang Benar");
                            break;
                    }

                } else {
                    System.out.println("\nMaximum incorrect login attempts. The program will exit.\n");
                }
                break;
            case 2:

                for (int loginAttempt = 1; loginAttempt <= maxLoginAttempts; loginAttempt++) {

                    System.out.println("\n=============== Login User ===============\n");
                    System.out.print("Masukkan Username   = ");
                    usernameUser = inputLoginUser.next();
                    System.out.print("Masukkan Password   = ");
                    passwordUser = inputLoginUser.next();
                    System.out.println("\n==========================================\n");

                    if (usernameUser.equals("User1") && passwordUser.equals("IniUser1")) {
                        System.out.println("\nLogin Successfully\n");
                        Login = true;
                    } else {
                        System.out.println("Failed Login Please Try Again or Create Account via Admin\n");
                    }
                }

                if (Login) {
                    // Program Cek Resi
                } else {
                    System.out.println("\nMaximum incorrect login attempts. The program will exit.\n");
                }

                break;
            default:

                System.out.println("\n=================== Sorry =====================");
                System.out.println("|                                              |");
                System.out.println("|         Please Choose Admin or User          |");
                System.out.println("|                                              |");
                System.out.println("================= Pos Indonesia ================\n");

                break;
        }
    }
}
