package servicesTest;


import com.mysql.cj.exceptions.WrongArgumentException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.warehouse.configuration.PasswordEncoderConfiguration;
import pl.warehouse.database.implementation.UserDAO;
import pl.warehouse.models.Role;
import pl.warehouse.models.User;
import pl.warehouse.models.Warehouseman;
import pl.warehouse.services.implementation.LoginService;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    public LoginService loginService ;


    @Test
    public void checkLoginAndPassTestWithPositiveData(){
        User user = new User(6,"root","$2a$04$83r0O3WjIK0TnsbDpI29Guz3MDs/Sjwypk/qRwPbjVcPOHCSpCxsK", new Warehouseman(), Role.ADMIN);

        when(userDAO.getUserByUsername("root")).thenReturn(user);

        boolean result = loginService.checkLoginAndPass(userDAO.getUserByUsername("root").getUsername(),
                userDAO.getUserByUsername("root").getPassword());

        Assert.assertTrue(result);

    }
}
