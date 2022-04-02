package pl.warehouse.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.warehouse.database.implementation.AccountDAO;
import pl.warehouse.models.Account;
import pl.warehouse.services.ILoginService;

@Service
public class LoginService implements ILoginService {
    
    @Autowired
    AccountDAO accountDAO;
    
    @Override
    public boolean checkLoginAndPass(String login, String password) {
        Account tempAccount= new Account(login,password);
        for (Account account: accountDAO.getAccountList()) {
            if(account.getLogin().equals(tempAccount.getLogin())
                    && (account.getPassword().equals(tempAccount.getPassword()))) {
                return true;
            }
        }
        return false;
    }
}
