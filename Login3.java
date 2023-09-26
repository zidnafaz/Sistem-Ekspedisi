import java.util.Scanner;

public class Login3 {
    public static void main(String[] args) {
        Scanner inputPilihan = new Scanner(System.in);

        int pilihan;

        System.out.println("\n========== Welcome to Pos Indonesia ==========");
        System.out.println("|               Please Login Here              |");
        System.out.println("|                                              |");
        System.out.println("|         1. Admin                             |");
        System.out.println("|         2. User                              |");
        System.out.println("|                                              |\n");
        System.out.println("============ Masukkan Pilihan Anda =============");
        pilihan = inputPilihan.nextInt();

        switch (pilihan) {
            case 1:
                Scanner inputLoginAdmin = new Scanner(System.in);

                String usernameAdmin, passwordAdmin;

                System.out.println("\n=========== Login Admin ===========\n");
                System.out.print("Masukkan Username   = ");
                usernameAdmin = inputLoginAdmin.next();
                System.out.print("Masukkan Password   = ");
                passwordAdmin = inputLoginAdmin.next();
                System.out.println("\n===================================\n");
                
                if (usernameAdmin.equals("Admin1") && passwordAdmin.equals("IniAdmin1")) {
                    System.out.println("Login Successfully\n");
                } else {
                    System.out.println("Failed Login Please Try Again or Create Account via Admin\n");
                }
                break;
                case 2:
                Scanner inputLoginUser = new Scanner(System.in);
                String usernameUser, passwordUser;
                
                System.out.println("\n========== Login User ==========\n");
                System.out.print("Masukkan Username   = ");
                usernameUser = inputLoginUser.next();
                System.out.print("Masukkan Password   = ");
                passwordUser = inputLoginUser.next();
                System.out.println("\n===================================\n");

                if (usernameUser.equals("User1") && passwordUser.equals("IniUser1")) {
                    System.out.println("Login Successfully\n");
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