package pl.warehouse.services.implementation;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.warehouse.database.IUserDAO;
import pl.warehouse.database.IWarehousemenDAO;
import pl.warehouse.exceptions.AuthValidationException;
import pl.warehouse.exceptions.LoginCheckException;
import pl.warehouse.models.User;
import pl.warehouse.services.IUserService;
import pl.warehouse.validation.LoginValidation;

import java.util.List;

@Service
public class UserService implements IUserService {

    final PasswordEncoder passwordEncoder;
    final IUserDAO userDAO;
    final IWarehousemenDAO warehousemenDAO;
    public UserService(IUserDAO userDAO, IWarehousemenDAO warehousemenDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.warehousemenDAO = warehousemenDAO;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void addUser(User user) {
        try{
            LoginValidation.validateLogin(user.getUsername());
            LoginValidation.validatePass(user.getPassword());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            checkThisSameUsername(user.getUsername());
        }catch(AuthValidationException e){
            return;
        }
        warehousemenDAO.addWarehouseman(user.getWarehouseman());
        userDAO.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
        warehousemenDAO.deleteWarehouseman(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Override
    public List<User> getUserList() {
        return userDAO.getUserList();
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void checkThisSameUsername(String username){
        try{
            username.equals(userDAO.getUserByUsername(username));
        }catch(LoginCheckException e){
            return;
        }
    }
}
