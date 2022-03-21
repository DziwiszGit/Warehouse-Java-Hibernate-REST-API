package pl.warehouse.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.warehouse.controllers.ILoginController;
import pl.warehouse.exceptions.AuthValidationException;
import pl.warehouse.models.Account;
import pl.warehouse.services.implementation.LoginService;
import pl.warehouse.validation.LoginValidation;

@RestController
public class LoginController implements ILoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public boolean login(@RequestBody Account account){
        if(loginService.checkLoginAndPass(account.getLogin(), account.getPassword())){
            return true;
        }
        return false;

    }
}
