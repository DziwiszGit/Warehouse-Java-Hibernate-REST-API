package pl.warehouse.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.warehouse.controllers.IWarehousemenController;
import pl.warehouse.models.Warehouseman;
import pl.warehouse.services.IWarehousemenService;
import pl.warehouse.services.implementation.WarehousemenService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WarehousemenController implements IWarehousemenController {

    final IWarehousemenService warehousemenService;

    public WarehousemenController(IWarehousemenService warehousemenService) {
        this.warehousemenService = warehousemenService;
    }

    @Override
    @RequestMapping(value="/api/warehousemen",method = RequestMethod.GET)
    public List<Warehouseman> getWarehousemenList() {
        return warehousemenService.getWarehousemenList();
    }

    @Override
    @RequestMapping(value="/api/warehousemen/{id}",method = RequestMethod.GET)
    public void getWarehousemenByID(@PathVariable int id) {
        warehousemenService.getWarehousemenByID(id);
    }
}
