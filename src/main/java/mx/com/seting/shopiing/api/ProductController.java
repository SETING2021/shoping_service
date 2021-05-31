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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.seting.shopiing.model.ErrorResponse;
import mx.com.seting.shopiing.model.Product;
import mx.com.seting.shopiing.service.ProductService;

@ApiOperation(value = "/detail/v1/product", tags = "Product Detail Controller")
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
    
    @ApiResponses( value = {
    		@ApiResponse(code = 200, message = "SUCCESS"),
    		@ApiResponse(code = 201, message = "CREATED"),
    		@ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
    		@ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
    		@ApiResponse(code = 404, message = "NOT FOUND")
    })
    @ApiOperation(value = "Add Product Record", response = Product.class)
    @PostMapping
    public void addProduct(@RequestBody Product product){
    	LOGGER.log(Level.INFO, "Add product with name : " + product.getName());
        productService.addProduct(product);
    }

    @ApiResponses( value = {
    		@ApiResponse(code = 200, message = "SUCCESS", response = Product.class),
    		@ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
    		@ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
    		@ApiResponse(code = 404, message = "NOT FOUND")	
    })
    @ApiOperation(value = "Get All Products", response = Iterable.class)
    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @ApiResponses( value = {
    		@ApiResponse(code = 200, message = "SUCCESS", response = Product.class),
    		@ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
    		@ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
    		@ApiResponse(code = 404, message = "NOT FOUND")
    })
    @ApiOperation(value = "Get Product By Id", response = Product.class)
    @GetMapping(path = "{id}")
    public Product selectProductById(@PathVariable("id") int id){
        return productService.selectProductById(id).orElse(null);

    }

    @ApiResponses( value = {
    		@ApiResponse(code = 200, message = "SUCCESS"),
    		@ApiResponse(code = 204, message = "NO CONTENT"),
    		@ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
    		@ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
    		@ApiResponse(code = 404, message = "NOT FOUND")
    })
    @ApiOperation(value = "Delete a Product By Id", response = Product.class)
    @DeleteMapping(path = "{id}")
    public void deleteProductById(@PathVariable("id") int id){
    	LOGGER.log(Level.INFO, "Delete product with id : " + id);
        productService.deleteProduct(id);
    }

    @ApiResponses( value = {
    		@ApiResponse(code = 200, message = "SUCCESS"),
    		@ApiResponse(code = 201, message = "CREATED"),
    		@ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
    		@ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
    		@ApiResponse(code = 404, message = "NOT FOUND")
    })
    @ApiOperation(value = "Update Product Details By Id", response = Product.class)
    @PutMapping(path = "{id}")
    public void updateProduct(@PathVariable("id") int id, @RequestBody Product productToUpdate){
    	LOGGER.log(Level.INFO, "Update product with id : " + id);
        productService.updateProduct(id, productToUpdate);
    }

}
