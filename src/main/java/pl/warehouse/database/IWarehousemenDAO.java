package pl.warehouse.database;

import pl.warehouse.models.Product;
import pl.warehouse.models.Warehouseman;

import java.util.List;

public interface IWarehousemenDAO {
    List<Warehouseman> getWarehousemenList();
    Warehouseman getWarehousemenByID(int id);
    void addWarehouseman(Warehouseman warehouseman);
    void deleteWarehouseman(int id);
}
