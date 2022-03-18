package pl.warehouse.controllers.implementation;

import org.springframework.web.bind.annotation.*;
import pl.warehouse.controllers.IProductController;
import pl.warehouse.models.Product;

import java.util.List;

@RestController
public class ProductController implements IProductController {

    @Override
    @RequestMapping(value="/products",method= RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {

    }

    @Override
    @RequestMapping(value={"/products/{id}"})
    public void deleteProductById(@PathVariable int id) {

    }

    @Override
    public List<Product> getProductList() {
        return null;
    }

    @Override
    public Product getProductById(@PathVariable int id) {
        return null;
    }

    @Override
    public void uppdateWeight(Product product) {

    }


}
