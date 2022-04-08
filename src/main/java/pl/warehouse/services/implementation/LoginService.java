package pl.warehouse.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.warehouse.database.implementation.UserDAO;
import pl.warehouse.models.User;
import pl.warehouse.services.ILoginService;

@Service
public class LoginService implements ILoginService {
    
    final UserDAO userDAO;

    public LoginService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean checkLoginAndPass(String login, String password) {
        User tempUser = new User(login,password);
        for (User user : userDAO.getUserList()) {
            if(user.getUsername().equals(tempUser.getUsername())
                    && (user.getPassword().equals(tempUser.getPassword()))) {
                return true;
            }
        }
        return false;
    }
}
