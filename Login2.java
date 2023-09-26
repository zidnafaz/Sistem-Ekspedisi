import java.util.Scanner;

public class Login2 {
    public static void main(String[] args) {
        Scanner InputPilihan = new Scanner(System.in);
        
        int Pilihan;
        
        System.out.println("\n========== Welcome to Pos Indonesia ==========");
        System.out.println("|             Please Login Here              |");
        System.out.println("|                                            |");
        System.out.println("|         1. Admin                           |");
        System.out.println("|         2. User                            |");
        System.out.println("|                                            |");
        System.out.println("|                                            |\n");
        System.out.println("============ Masukkan Pilihan Anda ===========");
        Pilihan = InputPilihan.nextInt();
        
        switch (Pilihan) {
            case 1:
            Scanner InputLoginAdmin = new Scanner(System.in);
                
            int UsernameAdmin = 1234567;
            int PasswordAdmin = 1234567;
            
            System.out.println("\n========== Login Admin ==========\n");
            System.out.print("Masukkan Username   = ");
            UsernameAdmin = InputLoginAdmin.nextInt();
            System.out.print("Masukkan Password   = ");
            PasswordAdmin = InputLoginAdmin.nextInt();
            
            if (InputLoginAdmin == UsernameAdmin && InputLoginAdmin == PasswordAdmin) {
                System.out.println("Login Successfully");
            } else {
                System.out.println("Failed Login Please Try Again");
            }
            break;
            case 2 :
            Scanner InputLoginUser = new Scanner(System.in);
            String UsernameUser, PasswordUser;
                
            System.out.println("\n========== Login User ==========\n");
            System.out.print("Masukkan Username   =       ");
            UsernameUser = InputLoginUser.next();
            System.out.print("Masukkan Password   =       ");
            PasswordUser = InputLoginUser.next();

            if (UsernameUser == "User1" && PasswordUser == "IniUser1" ) {
                System.out.println("Login Successfully");
            } else if (UsernameUser != "User1" || PasswordUser != "IniUser1") {
                 System.out.println("Failed Login Please Try Again");
            }
            break; 

        default: 
            System.out.println("Anda belum memiliki akun, silahkan hubungi admin");
            break;
        }

    }
}
