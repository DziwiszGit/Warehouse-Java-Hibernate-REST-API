package pl.warehouse.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.warehouse.database.IAccountDAO;
import pl.warehouse.database.implementation.WarehousemenDAO;
import pl.warehouse.exceptions.AuthValidationException;
import pl.warehouse.models.Account;
import pl.warehouse.models.Warehouseman;
import pl.warehouse.services.IAccountService;
import pl.warehouse.validation.LoginValidation;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    IAccountDAO accountDAO;

    @Autowired
    WarehousemenDAO warehousemenDAO;

    @Override
    public void addAccount(Account account) {
        try{
            LoginValidation.validateLogin(account.getLogin());
            LoginValidation.validatePass(account.getPassword());
        }catch(AuthValidationException e){
            return;
        }
        warehousemenDAO.addWarehouseman(account.getWarehouseman());
        accountDAO.addAccount(account);
    }

    @Override
    public void deleteAccount(int id) {
        accountDAO.deleteAccount(id);
        warehousemenDAO.deleteWarehouseman(id);
    }

    @Override
    public Account getAccountByLogin(String login) {
        return accountDAO.getAccountByLogin(login);
    }

    @Override
    public List<Account> getAccountList() {
        return accountDAO.getAccountList();
    }

    @Override
    public Account getAccountById(int id) {
        return accountDAO.getAccountById(id);
    }


}
