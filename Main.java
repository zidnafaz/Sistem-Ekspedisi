import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
        NamaPengirim = sc.next();
        System.out.print("Nomor Telepon Pengirim    : ");
        NomorTeleponPengirim = sc.nextLong();
        System.out.print("Alamat Pengirim           : ");
        AlamatPengirim = sc.next();
        System.out.print("Tanggal Pengiriman        : ");
        TanggalPengiriman = sc.next();
        System.out.print("Nama Penerima             : " );
        NamaPenerima = sc.next();
        System.out.print("Nomor Telepon Penerima    : ");
        NomorTeleponPenerima = sc.nextLong();
        System.out.print("Alamat Penerima           : ");
        AlamatPenerima = sc.next();
        System.out.print("Kode Pos                  : ");
        KodePos = sc.nextInt();
        System.out.print("Jenis Layanan             : ");
        JenisLayanan = sc.next();
        System.out.print("Jenis Barang              : ");
        JenisBarang = sc.next();
        System.out.print("Nomor Resi                : ");
        NomorResi = sc.nextInt();
        System.out.print("Jarak                     : ");
        Jarak = sc.nextInt();
        System.out.print("Berat Barang              : ");
        BeratBarang = sc.nextDouble();
        System.out.println();

        TotalBiaya = (int) ((Jarak*50) + (BeratBarang*5000));

        System.out.println("Jumlah Biaya              : " + TotalBiaya);
        System.out.println("\n============ Terima Kasih ============\n ");

    }
}