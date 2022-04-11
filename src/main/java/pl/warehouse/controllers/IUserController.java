package pl.warehouse.controllers;

import pl.warehouse.models.User;

import java.util.List;

public interface IUserController {
    void addUser(User user);
    void deleteUser(int id);
    User getUserByUsername(String username);
    List<User> getUserList();
    boolean authorization();
}
