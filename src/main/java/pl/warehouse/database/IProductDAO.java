package pl.warehouse.database;

import pl.warehouse.models.Product;

import java.util.List;

public interface IProductDAO {
    void addProduct(Product product);
    void deleteProductById(int id);
    List<Product> getProductList();
    Product getProductById(int id);
    void uppdateWeight(Product product);
}
