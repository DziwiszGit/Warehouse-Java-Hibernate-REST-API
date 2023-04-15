package servicesTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.warehouse.database.implementation.ProductDAO;
import pl.warehouse.models.Product;
import pl.warehouse.services.implementation.ProductService;

import java.util.Date;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    public ProductDAO productDAO;

    @InjectMocks
    public ProductService productService ;

    @Test
    public void checkExistingTestWithWrongParametr(){
        Product product = new Product();
        product.setName("Water");
        product.setWeight(10);
        product.setDate(new Date());

        Product secoundProduct = new Product();
        secoundProduct.setName("Sand");
        secoundProduct.setDate(new Date());
        secoundProduct.setWeight(20);

        when(productDAO.getProductById(anyInt())).thenReturn(product);
        boolean result = productService.checkExisting(productDAO.getProductById(6).getName());
        Assert.assertFalse(result);
    }


}
