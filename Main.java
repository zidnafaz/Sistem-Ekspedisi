import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String 
        NamaPengirim, AlamatPengirim,
        NamaPenerima, AlamatPenerima,
        JenisBarang;

        long NomorTeleponPengirim, NomorTeleponPenerima;

        int 
        KodePos, Jarak,
        BiayaJarak,
        BeratBarang, TotalBiaya,
        NomorResi;

        double 
        BiayaBeratBarang;

        //Tarif Jarak ( \ km = 50)
        // Malang - Bandung = 700km
        // Malang - Jakarta = 800km
        // Malang - Surabaya = 40km
        
        // Tarif Berat ( \ kg = 5000)

        System.out.println("\n========== Informasi Pengiriman ==========");
        System.out.print("\nNama Pengirim             : ");
        NamaPengirim = sc.nextLine();
        System.out.print("Alamat Pengirim           : ");
        AlamatPengirim = sc.nextLine();
        System.out.print("Nomor Telepon Pengirim    : ");
        NomorTeleponPengirim = sc.nextLong();
        System.out.print("Nama Penerima             : " );
        NamaPenerima = sc.next();
        System.out.print("Alamat Penerima           : ");
        AlamatPenerima = sc.next();
        System.out.print("Nomor Telepon Penerima    : ");
        NomorTeleponPenerima = sc.nextLong();
        System.out.print("Kode Pos                  : ");
        KodePos = sc.nextInt();
        System.out.print("Jenis Barang              : ");
        JenisBarang = sc.next();
        System.out.print("Nomor Resi                : ");
        NomorResi = sc.nextInt();
        System.out.print("Jarak                     : ");
        Jarak = sc.nextInt();
        System.out.print("Berat Barang              : ");
        BeratBarang = sc.nextInt();
        System.out.println();

        BiayaJarak = Jarak*50;
        BiayaBeratBarang = BeratBarang*5000;
        TotalBiaya = (int) (BiayaJarak + BiayaBeratBarang);

        System.out.println("Jumlah Biaya              : " + TotalBiaya);
        System.out.println("\n========== Terima Kasih ==========\n ");

    }
}