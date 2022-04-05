package pl.warehouse.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.warehouse.controllers.IUserController;
import pl.warehouse.models.User;
import pl.warehouse.services.IUserService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController implements IUserController {

    @Autowired
    IUserService userService;

    @Override
    @RequestMapping(value="/user",method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @Override
    @RequestMapping(value="/user/{id}",method = RequestMethod.POST)
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @Override
    @RequestMapping(value="/user/{username}",method = RequestMethod.GET)
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @Override
    @RequestMapping(value="/user",method = RequestMethod.GET)
    public List<User> getUserList() {
        return userService.getUserList();
    }
}
