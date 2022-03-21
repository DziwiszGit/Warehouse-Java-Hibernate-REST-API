package pl.warehouse.database;

import pl.warehouse.models.Account;
import pl.warehouse.models.Warehouseman;

import java.util.List;

public interface IAccountDAO {
    void addAccount(Account account);
    void deleteAccount(int id);
    Account getAccountByLogin(String login);
    List<Account> getAccountList();
    Account getAccountById(int id);
}
