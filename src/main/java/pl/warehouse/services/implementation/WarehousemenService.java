package pl.warehouse.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.warehouse.database.IWarehousemenDAO;
import pl.warehouse.database.implementation.WarehousemenDAO;
import pl.warehouse.models.Warehouseman;
import pl.warehouse.services.IWarehousemenService;

import java.util.List;

@Service
public class WarehousemenService implements IWarehousemenService {

    @Autowired
    IWarehousemenDAO warehousemenDAO;

    @Override
    public List<Warehouseman> getWarehousemenList() {
        return warehousemenDAO.getWarehousemenList();
    }

    @Override
    public Warehouseman getWarehousemenByID(int id) {
        return warehousemenDAO.getWarehousemenByID(id);
    }

    @Override
    public void addWarehouseman(Warehouseman warehouseman) {
        warehousemenDAO.addWarehouseman(warehouseman);
    }


}
