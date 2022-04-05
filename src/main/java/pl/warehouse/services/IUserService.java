package pl.warehouse.services;

import pl.warehouse.models.User;

import java.util.List;

public interface IUserService {
    void addUser(User user);
    void deleteUser(int id);
    User getUserByUsername(String username);
    List<User> getUserList();
    User getUserById(int id);
    void checkThisSameUsername(String username);
}
