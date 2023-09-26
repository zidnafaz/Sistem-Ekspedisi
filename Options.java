import java.util.*;

public class Options {

    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        int User;

        
        System.out.println("========== Welcome to Pos Indonesia ==========");
        System.out.println("\nPlease Login Here\n\n1.User\n2.Admin");
        User = inputUser.nextInt();

        if (User) {
            inputUser = 1;
            System.out.println("Silahkan Masukkan Username");
            System.out.println("Silahkan Masukkan Password");
        } else {
            
        }
        switch (inputUser) {
            case 1:
                
                break;
        
            default:
                break;
        }

    }

}
