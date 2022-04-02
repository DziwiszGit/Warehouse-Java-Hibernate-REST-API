package pl.warehouse.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.warehouse.controllers.IAccountController;
import pl.warehouse.models.Account;
import pl.warehouse.models.Warehouseman;
import pl.warehouse.services.IAccountService;
import pl.warehouse.services.IWarehousemenService;
import pl.warehouse.services.implementation.WarehousemenService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class AccountController implements IAccountController {

    @Autowired
    IAccountService accountService;

    @Override
    @RequestMapping(value="/account",method = RequestMethod.POST)
    public void addAccount(@RequestBody Account account){
          accountService.addAccount(account);
    }

    @Override
    @RequestMapping(value="/account/{id}",method = RequestMethod.POST)
    public void deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
    }

    @Override
    @RequestMapping(value="/account/{login}",method = RequestMethod.GET)
    public Account getAccountByLogin(@PathVariable String login) {
        return accountService.getAccountByLogin(login);
    }

    @Override
    @RequestMapping(value="/account",method = RequestMethod.GET)
    public List<Account> getAccountList() {
        return accountService.getAccountList();
    }
}
