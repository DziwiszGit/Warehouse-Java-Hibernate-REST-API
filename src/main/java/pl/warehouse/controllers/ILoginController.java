package pl.warehouse.controllers;

import pl.warehouse.models.Account;

public interface ILoginController {
    boolean login(Account account);
}
