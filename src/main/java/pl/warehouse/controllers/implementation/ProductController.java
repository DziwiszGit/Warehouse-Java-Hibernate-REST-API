package pl.warehouse.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.warehouse.controllers.IProductController;
import pl.warehouse.models.Product;
import pl.warehouse.services.IProductService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductController implements IProductController {

    @Autowired
    IProductService productService;

    @Override
    @RequestMapping(value="/products",method= RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @Override
    @RequestMapping(value="/products/{id}",method = RequestMethod.POST)
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @Override
    @RequestMapping(value="/products",method = RequestMethod.GET)
    public List<Product> getProductList() {
        return productService.getProductList();
    }

    @Override
    @RequestMapping(value="/products/{id}",method = RequestMethod.GET)
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @Override
    @RequestMapping(value="/products/update",method = RequestMethod.POST)
    public void uppdateWeight(@RequestBody Product product) {
        productService.uppdateWeight(product);
    }


}
