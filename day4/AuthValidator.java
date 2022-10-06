package day4;

import java.util.HashMap;

public class AuthValidator {
    private String email;
    private String password;

    AuthValidator (String email, String password) {
        this.email = email;
        this.password = password;
    }

    private boolean validateEmail() {
        return this.email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }

    private boolean validatePassword() {
        return this.password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }

    public HashMap<String, Boolean> validateCredentials() {
        HashMap<String, Boolean> validationMap = new HashMap<String, Boolean>();

        validationMap.put("email", this.validateEmail());
        validationMap.put("password", this.validatePassword());

        return validationMap;
    }
}
