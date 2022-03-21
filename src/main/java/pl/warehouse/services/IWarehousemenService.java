package pl.warehouse.services;

import pl.warehouse.models.Warehouseman;

import java.util.List;

public interface IWarehousemenService {
    List<Warehouseman> getWarehousemenList();
    Warehouseman getWarehousemenByID(int id);
    void addWarehouseman(Warehouseman warehouseman);
}
