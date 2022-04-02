package pl.warehouse.validation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.warehouse.database.IAccountDAO;
import pl.warehouse.database.implementation.AccountDAO;
import pl.warehouse.exceptions.AuthValidationException;

public class LoginValidation {

    public static void validateLogin(String login) {
        if(login == null || login.length() <= 1) {
            throw new AuthValidationException("Login incorrect");
        }
    }

    public static void validatePass(String pass) {
        if(pass == null || pass.length() <= 1) {
            throw new AuthValidationException("Password incorrect");
        }
    }

}
