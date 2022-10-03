import java.util.Scanner;

public class Console {
    public static void log(String message) {
        System.out.println(message);
    }

    public static String input(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
}