package pl.warehouse.controllers;

import pl.warehouse.models.Warehouseman;

import java.util.List;

public interface IWarehousemenController {
    List<Warehouseman> getWarehousemenList();
    void getWarehousemenByID(int id);
}
