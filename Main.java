import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputPilihan = new Scanner(System.in);

        int pilihan;

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
                Scanner inputLoginAdmin = new Scanner(System.in);

                String usernameAdmin, passwordAdmin;

                System.out.println("\n============== Login Admin ==============\n");
                System.out.print("Masukkan Username   = ");
                usernameAdmin = inputLoginAdmin.next();
                System.out.print("Masukkan Password   = ");
                passwordAdmin = inputLoginAdmin.next();
                System.out.println("\n=========================================\n");

                if (usernameAdmin.equals("Admin1") && passwordAdmin.equals("IniAdmin1")) {
                    System.out.println("Login Successfully\n");
                } else {
                    System.out.println("Failed Login Please Try Again or Create Account via Admin\n");
                }

                int PilihanAdmin, PilihanPayment;

                System.out.println("\n================= Pos Indonesia ================");
                System.out.println("|                                              |");
                System.out.println("|   Hello Admin, Welcome to Admin Dashboard    |");
                System.out.println("|                                              |");
                System.out.println("|         1. Input Paket Baru                  |");
                System.out.println("|         2. Input Lokasi Paket                |");
                System.out.println("|         3. Laporan Keuangan                 |");
                System.out.println("|                                              |\n");
                System.out.println("============= Masukkan Pilihan Anda ============");
                
                PilihanAdmin = inputPilihan.nextInt();

                switch (PilihanAdmin) {
                    case 1:
                        Scanner inputDataPengiriman = new Scanner(System.in);
                        Scanner inputPilihanAdmin = new Scanner(System.in);

                        String 
                        NamaPengirim, AlamatPengirim,
                        NamaPenerima, AlamatPenerima,
                        JenisBarang, TanggalPengiriman,
                        JenisLayanan;
                
                        long NomorTeleponPengirim, NomorTeleponPenerima;
                
                        int 
                        KodePos, Jarak,
                        TotalBiaya,
                        NomorResi;
                
                        double
                        BeratBarang ; 
                        
                
                        //Tarif Jarak ( \ km = 50)
                        // Malang - Bandung = 700km
                        // Malang - Jakarta = 800km
                        // Malang - Surabaya = 40km
                        
                        // Tarif Berat ( \ kg = 5000)
                
                        System.out.println("\n========== Informasi Pengiriman ==========");
                        System.out.print("\nNama Pengirim             : ");
                        NamaPengirim = inputDataPengiriman.next();
                        System.out.print("Nomor Telepon Pengirim    : ");
                        NomorTeleponPengirim = inputDataPengiriman.nextLong();
                        System.out.print("Alamat Pengirim           : ");
                        AlamatPengirim = inputDataPengiriman.next();
                        System.out.print("Tanggal Pengiriman        : ");
                        TanggalPengiriman = inputDataPengiriman.next();
                        System.out.print("Nama Penerima             : " );
                        NamaPenerima = inputDataPengiriman.next();
                        System.out.print("Nomor Telepon Penerima    : ");
                        NomorTeleponPenerima = inputDataPengiriman.nextLong();
                        System.out.print("Alamat Penerima           : ");
                        AlamatPenerima = inputDataPengiriman.next();
                        System.out.print("Kode Pos                  : ");
                        KodePos = inputDataPengiriman.nextInt();
                        System.out.print("Jenis Layanan             : ");
                        JenisLayanan = inputDataPengiriman.next();
                        System.out.print("Jenis Barang              : ");
                        JenisBarang = inputDataPengiriman.next();
                        System.out.print("Nomor Resi                : ");
                        NomorResi = inputDataPengiriman.nextInt();
                        System.out.print("Jarak                     : ");
                        Jarak = inputDataPengiriman.nextInt();
                        System.out.print("Berat Barang              : ");
                        BeratBarang = inputDataPengiriman.nextDouble();
                        System.out.println();
                
                        TotalBiaya = (int) ((Jarak*50) + (BeratBarang*5000));
                
                        System.out.println("Jumlah Biaya              : " + TotalBiaya + ("\n"));
                        System.out.println("\n=================== Payment ====================");
                        System.out.println("|                                              |");
                        System.out.println("|           Make Sure That Customer            |");
                        System.out.println("|             Has Made a Payement              |");
                        System.out.println("|                                              |");
                        System.out.println("|         1. Done                              |");
                        System.out.println("|         2. Undone                            |");
                        System.out.println("|                                              |\n");
                        System.out.println("============= Masukkan Pilihan Anda ============");
                        PilihanPayment = inputPilihanAdmin.nextInt();

                        if (PilihanPayment == 1) {
                            
                            System.out.println("\n================= Thank You ===================");
                            System.out.println("|                                              |");
                            System.out.println("|       Your package will be sent soon         |");
                            System.out.println("|                                              |");
                            System.out.println("================= Pos Indonesia ================\n");

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

                        break;
                    case 2:
                        Scanner inputLokasiPaket = new Scanner(System.in);
                        int NomorResiUpadate;
                        String UpdateLokasi;

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
                        System.out.println("|      Package Number :           " + NomorResiUpadate + "               |");
                        System.out.println("|    Is Now At      :           " + UpdateLokasi + "               |");
                        System.out.println("|                                              |");
                        System.out.println("|                Have a Nice Day               |");
                        System.out.println("|                                              |\n");
                        System.out.println("================= Pos Indonesia ================\n");
                        break;
                    case 3:
                        System.out.println("Laporan Keuangan Menyusul, hehehehehehehehe");
                        break;
                    default:
                        System.out.println("Masukkan Pilihan Yang Benar");
                        break;
                }
                break;
            case 2:
                Scanner inputLoginUser = new Scanner(System.in);

                String usernameUser, passwordUser;

                System.out.println("\n=============== Login User ===============\n");
                System.out.print("Masukkan Username   = ");
                usernameUser = inputLoginUser.next();
                System.out.print("Masukkan Password   = ");
                passwordUser = inputLoginUser.next();
                System.out.println("\n==========================================\n");

                if (usernameUser.equals("User1") && passwordUser.equals("IniUser1")) {
                    System.out.println("\nLogin Successfully\n");
                } else {
                    System.out.println("Failed Login Please Try Again or Create Account via Admin\n");
                }
                break;
            default:
                System.out.println("Wrong Options, Please Try Again");
                break;
        }
    }
}
