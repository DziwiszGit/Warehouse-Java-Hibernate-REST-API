package pl.warehouse.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.warehouse.controllers.IWarehousemenController;
import pl.warehouse.models.Warehouseman;
import pl.warehouse.services.IWarehousemenService;
import pl.warehouse.services.implementation.WarehousemenService;

import java.util.List;

@RestController
public class WarehousemenController implements IWarehousemenController {

    @Autowired
    IWarehousemenService warehousemenService;

    @Override
    @RequestMapping(value="/warehousemen",method = RequestMethod.GET)
    public List<Warehouseman> getWarehousemenList() {
        return warehousemenService.getWarehousemenList();
    }

    @Override
    @RequestMapping(value="/warehousemen/{id}",method = RequestMethod.GET)
    public void getWarehousemenByID(@PathVariable int id) {
        warehousemenService.getWarehousemenByID(id);
    }
}
