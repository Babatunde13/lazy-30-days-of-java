package day4;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String email = args.length > 0 ? args[0] : "";
        String password = args.length > 1 ? args[1] : "";
        HashMap<String, Boolean> validationResults = validateCredentials(email, password);
        System.out.println(validationResults);
    }

    public static HashMap<String, Boolean> validateCredentials(String email, String password) {
        AuthValidator authValidator = new AuthValidator(email, password);

        return authValidator.validateCredentials();
    }
}
