import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);

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
        NamaPengirim = inputUser.next();
        System.out.print("Nomor Telepon Pengirim    : ");
        NomorTeleponPengirim = inputUser.nextLong();
        System.out.print("Alamat Pengirim           : ");
        AlamatPengirim = inputUser.next();
        System.out.print("Tanggal Pengiriman        : ");
        TanggalPengiriman = inputUser.next();
        System.out.print("Nama Penerima             : " );
        NamaPenerima = inputUser.next();
        System.out.print("Nomor Telepon Penerima    : ");
        NomorTeleponPenerima = inputUser.nextLong();
        System.out.print("Alamat Penerima           : ");
        AlamatPenerima = inputUser.next();
        System.out.print("Kode Pos                  : ");
        KodePos = inputUser.nextInt();
        System.out.print("Jenis Layanan             : ");
        JenisLayanan = inputUser.next();
        System.out.print("Jenis Barang              : ");
        JenisBarang = inputUser.next();
        System.out.print("Nomor Resi                : ");
        NomorResi = inputUser.nextInt();
        System.out.print("Jarak                     : ");
        Jarak = inputUser.nextInt();
        System.out.print("Berat Barang              : ");
        BeratBarang = inputUser.nextDouble();
        System.out.println();

        TotalBiaya = (int) ((Jarak*50) + (BeratBarang*5000));

        System.out.println("Jumlah Biaya              : " + TotalBiaya);
        System.out.println("\n============ Terima Kasih ============\n ");

    }
}