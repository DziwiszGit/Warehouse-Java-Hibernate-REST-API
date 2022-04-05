package pl.warehouse.validation;

import pl.warehouse.exceptions.AuthValidationException;

public class LoginValidation {

    public static void validateLogin(String username) {
        if(username == null || username.length() <= 1) {
            throw new AuthValidationException("Login incorrect");
        }
    }

    public static void validatePass(String pass) {
        if(pass == null || pass.length() <= 1) {
            throw new AuthValidationException("Password incorrect");
        }
    }

}
