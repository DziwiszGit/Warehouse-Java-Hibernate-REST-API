package pl.warehouse.controllers;


import pl.warehouse.models.Product;

import java.util.List;

public interface IProductController {
    public void addProduct(Product product);
    public void deleteProductById(int id);
    public List<Product> getProductList();
    public Product getProductById(int id);
    public void uppdateWeight(Product product);
}
