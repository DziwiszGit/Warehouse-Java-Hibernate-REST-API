package pl.warehouse.database;

import pl.warehouse.models.User;

import java.util.List;

public interface IUserDAO {
    void addUser(User user);
    void deleteUser(int id);
    User getUserByUsername(String login);
    List<User> getUserList();
    User getUserById(int id);
}
