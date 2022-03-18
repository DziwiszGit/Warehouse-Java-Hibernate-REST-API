package pl.warehouse.database;

import pl.warehouse.models.Product;
import pl.warehouse.models.Warehouseman;

import java.util.List;

public interface IWarehousemenDAO {
    List<Warehouseman> getWarehousemenList();
    Warehouseman getWarehousemenByID(int id);
}
