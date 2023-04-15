package servicesTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.warehouse.database.implementation.UserDAO;
import pl.warehouse.models.Role;
import pl.warehouse.models.User;
import pl.warehouse.models.Warehouseman;
import pl.warehouse.services.implementation.UserService;

import static org.mockito.Mockito.when;

    @RunWith(MockitoJUnitRunner.class)
    public class UserServiceTest {

        @Mock
        UserDAO userDAO;

        @InjectMocks
        UserService userService;

        @Test
        public void getUserByUsernameTest(){

            User user = new User();
            user.setUsername("test");
            user.setId(6);
            user.setPassword("test");
            user.setRole(Role.USER);
            user.setWarehouseman(new Warehouseman());

            when(userDAO.getUserByUsername("test")).thenReturn(user);

            Assert.assertEquals(userDAO.getUserByUsername("test"),userService.getUserByUsername("test"));
        }
}
