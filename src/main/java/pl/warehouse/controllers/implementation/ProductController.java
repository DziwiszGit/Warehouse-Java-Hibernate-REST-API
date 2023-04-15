package pl.warehouse.controllers.implementation;

import org.springframework.web.bind.annotation.*;
import pl.warehouse.controllers.IProductController;
import pl.warehouse.models.Product;
import pl.warehouse.services.IProductService;
import pl.warehouse.services.implementation.LoginService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController implements IProductController {

    private final LoginService loginService;

    private final IProductService productService;

    public ProductController(LoginService loginService, IProductService productService) {
        this.loginService = loginService;
        this.productService = productService;
    }

    @Override
    @RequestMapping(value="/api/products",method= RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @Override
    @RequestMapping(value="/api/products/{id}",method = RequestMethod.DELETE)
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @Override
    @RequestMapping(value="/api/products",method = RequestMethod.GET)
    public List<Product> getProductList() {
        return productService.getProductList();
    }

    @Override
    @RequestMapping(value="/api/products/{id}",method = RequestMethod.GET)
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @Override
    @RequestMapping(value="/api/products/update",method = RequestMethod.PUT)
    public void uppdateWeight(@RequestBody Product product) {
        productService.uppdateWeight(product);
    }

    @Override
    @RequestMapping(value="/api/products/check/{name}",method = RequestMethod.GET)
    public boolean checkExisting(@PathVariable String name) {
        return productService.checkExisting(name);
    }


}
