package pl.warehouse.services;

import pl.warehouse.models.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void deleteProductById(int id);
    List<Product> getProductList();
    Product getProductById(int id);
    void uppdateWeight(Product product);
    boolean checkExisting(String name);
}
