package pl.warehouse.controllers;

import pl.warehouse.models.User;

public interface ILoginController {
    boolean login(User user);
}
