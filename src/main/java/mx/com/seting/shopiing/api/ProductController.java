package mx.com.seting.shopiing.api;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.seting.shopiing.model.Product;
import mx.com.seting.shopiing.service.ProductService;


@RequestMapping ("api/v1/product")
@RestController
public class ProductController {
	
	/**
	 * Manejo de logs.
	 */
	private static final Logger LOGGER = Logger.getLogger(ProductController.class.getName());

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
    	LOGGER.log(Level.INFO, "Add product with name : " + product.getName());
        productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping(path = "{id}")
    public Product selectProductById(@PathVariable("id") int id){
        return productService.selectProductById(id).orElse(null);

    }

    @DeleteMapping(path = "{id}")
    public void deleteProductById(@PathVariable("id") int id){
        productService.deleteProduct(id);
    }

    @PutMapping(path = "{id}")
    public void updateProduct(@PathVariable("id") int id, @RequestBody Product productToUpdate){
        productService.updateProduct(id, productToUpdate);
    }

}
