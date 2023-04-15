package pl.warehouse.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.warehouse.database.IProductDAO;
import pl.warehouse.models.Product;
import pl.warehouse.services.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final IProductDAO productDAO;

    public ProductService(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Override
    public void deleteProductById(int id) {
        productDAO.deleteProductById(id);
    }

    @Override
    public List<Product> getProductList() {
        return productDAO.getProductList();
    }

    @Override
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    @Override
    public void uppdateWeight(Product product) {
        productDAO.uppdateWeight(product);
    }

    @Override
    public boolean checkExisting(String name) {
        for (Product foundProduct : this.productDAO.getProductList()){
            if(foundProduct.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
