package pl.warehouse.controllers.implementation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.warehouse.controllers.IAccountController;
import pl.warehouse.models.Account;
import pl.warehouse.models.Warehouseman;

import java.util.List;

@RestController
public class AccountController implements IAccountController {

    @Override
    public void addAccount(@PathVariable String login,
                           @PathVariable String password,
                           @RequestBody Warehouseman warehouseman) {

    }

    @Override
    public void deleteAccount(@RequestBody Warehouseman warehouseman) {

    }

    @Override
    public Account getAccountByLogin(@RequestParam String login) {
        return null;
    }

    @Override
    public List<Account> getAccountList() {
        return null;
    }
}
