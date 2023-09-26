import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {

    private Map<String, String> userDatabase; // Simpan username dan password di sini

    public Login() {
        userDatabase = new HashMap<>();
        // Isi database dengan informasi pengguna (biasanya dilakukan di luar program)
        userDatabase.put("Admin1", "IniAdmin1");
        userDatabase.put("Admin2", "IniAdmin2");
        
    }

    public boolean login(String username, String password) {
        // Periksa apakah username ada dalam database
        if (userDatabase.containsKey(username)) {
            // Periksa apakah password cocok dengan yang ada di database
            String storedPassword = userDatabase.get(username);
            return storedPassword.equals(password);
        }
        return false;
    }

    public void createUser(String username, String password) {
        // Tambahkan pengguna baru ke database
        userDatabase.put(username, password);
        System.out.println("Akun " + username + " berhasil dibuat!");
    }

    public static void main(String[] args) {
        Login loginSystem = new Login();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di sistem login multiuser!");

        // Loop login sampai berhasil
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (loginSystem.login(username, password)) {
                loggedIn = true;
                System.out.println("Login berhasil! Selamat datang, " + username + "!");
            } else {
                System.out.println("Login gagal. Coba lagi atau buat akun baru? (y/n)");
                String choice = scanner.nextLine().trim().toLowerCase();
                if (choice.equals("y")) {
                    System.out.print("Buat username baru: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Buat password baru: ");
                    String newPassword = scanner.nextLine();
                    loginSystem.createUser(newUsername, newPassword);
                }
            }
        }

        // Tutup scanner
        scanner.close();
    }
}
