import java.util.Scanner;

public class Main_Array2 {

    static String[][] usernameDanPasswordAdmin = new String[10][2];
    static String[][] usernameDanPasswordUser = new String[][] { { "Iwan", "IniIwan" } };
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Pre-fill the first row of usernameDanPasswordAdmin
        usernameDanPasswordAdmin[0][0] = "Wawan";
        usernameDanPasswordAdmin[0][1] = "IniWawan";

        while (true) {
            System.out.println("A. Buat  Akun");
            System.out.println("B. Login");
            System.out.print("Masukkan Pilihan : ");
            String pilihan = input.nextLine();

            switch (pilihan) {
                case "A":
                    buatAkun();
                    break;
                case "B":
                    System.out.println("Masukkan Username   : ");
                    String Username = input.nextLine();

                    System.out.println("Masukkan Password   : ");
                    String Password = input.nextLine();

                    loginAdmin(Username, Password);

                    break;
                default:
                    break;
            }
        }
    }

    public static void loginAdmin(String Username, String Password) {
        for (int i = 0; i < usernameDanPasswordAdmin.length; i++) {
            if (usernameDanPasswordAdmin[i][0] != null && usernameDanPasswordAdmin[i][0].equals(Username)
                    && usernameDanPasswordAdmin[i][1] != null && usernameDanPasswordAdmin[i][1].equals(Password)) {
                System.out.println("Login Berhasil");
                return;
            }
        }
        System.out.println("Login Gagal");
    }

    public static void buatAkun() {
        for (int i = 0; i < usernameDanPasswordAdmin.length; i++) {
            if (usernameDanPasswordAdmin[i][0] == null && usernameDanPasswordAdmin[i][1] == null) {
                System.out.println("Masukkan Username   : ");
                usernameDanPasswordAdmin[i][0] = input.nextLine();

                System.out.println("Masukkan Password   : ");
                usernameDanPasswordAdmin[i][1] = input.nextLine();

                System.out.println("Berhasil Buat Akun");
                return;
            }
        }
        System.out.println("Gagal Buat Akun");
    }
}
