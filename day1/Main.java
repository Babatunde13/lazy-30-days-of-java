import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Console.log("Hello, World!");
        String name = Console.input("What is your name? ");
        Console.log(displayMessage(name));
    }

    public static String displayMessage(String name) {
        Pattern specialCharacters = Pattern.compile("[^a-zA-Z0-9]");
        Pattern boluOrOdun = Pattern.compile("^((B|b)olu|(O|o)dun)$");

        if (specialCharacters.matcher(name).find()) {
            return "Please remove all spaces or special characters";
        } else if (boluOrOdun.matcher(name).find()) {
            if (name.equalsIgnoreCase("bolu")) {
                return "Welcome back, Bolu";
            } else {
                return "Welcome back, Odun!";
            }
        } else {
            return "It is nice to meet you, " + name;
        }
    }
}