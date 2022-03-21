package pl.warehouse.controllers;

import pl.warehouse.models.Account;
import pl.warehouse.models.Warehouseman;

import java.util.List;

public interface IAccountController {
    void addAccount(Account account);
    void deleteAccount(int id);
    Account getAccountByLogin(String login);
    List<Account> getAccountList();
}
