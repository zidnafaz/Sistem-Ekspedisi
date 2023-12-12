public class ColoredTerminal {

    // ANSI escape codes for text colors
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        System.out.println(RED + "Ini teks berwarna merah" + RESET);
        System.out.println(GREEN + "Ini teks berwarna hijau" + RESET);
        System.out.println(BLUE + "Ini teks berwarna biru" + RESET);
        System.out.println(YELLOW + "Ini teks berwarna kuning" + RESET);
        System.out.println(PURPLE + "Ini teks berwarna ungu" + RESET);
        System.out.println(CYAN + "Ini teks berwarna cyan" + RESET);
        System.out.println(WHITE + "Ini teks berwarna putih" + RESET);
    }
}
