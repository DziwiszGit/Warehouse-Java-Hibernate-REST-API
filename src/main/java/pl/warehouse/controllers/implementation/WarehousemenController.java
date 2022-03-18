package pl.warehouse.controllers.implementation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.warehouse.controllers.IWarehousemenController;
import pl.warehouse.models.Warehouseman;

import java.util.List;

@RestController
public class WarehousemenController implements IWarehousemenController {

    @Override
    @RequestMapping(value="/warehousemen",method = RequestMethod.GET)
    public List<Warehouseman> getWarehousemenList() {
        return null;
    }
    @RequestMapping(value="/warehousemen/{id}",method = RequestMethod.GET)
    @Override
    public void getWarehousemenByID(@RequestParam int id) {

    }
}
