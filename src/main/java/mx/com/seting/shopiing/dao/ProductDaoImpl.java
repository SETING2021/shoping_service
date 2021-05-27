package mx.com.seting.shopiing.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.com.seting.shopiing.api.ProductController;
import mx.com.seting.shopiing.model.Product;

@Repository ("personaDao")
public class ProductDaoImpl implements  ProductDao{
	
	private static final Logger LOGGER = Logger.getLogger(ProductDaoImpl.class.getName());
	
	@Autowired
	private ProductData data;

    @Override
    public int insertProduct(Product product) {
    	
    	int respuesta = 0;
    	Product p = data.save(product);
    	
    	if(!p.equals(null)) {
    		respuesta = 1;
    	}
    	
        return respuesta;
    }

    @Override
    public List<Product> selectAllProduct() {
    	
        return (List<Product>)data.findAll();
    }

    @Override
    public Optional<Product> selectProductById(int id) {
        return data.findById(id);

    }

    @Override
    public int deleteProductById(int id) {
    	
    	int respuesta = 0;
    	
    	LOGGER.log(Level.INFO, "Vamos a buscar producto con id : " + id);
    	Optional<Product> p = data.findById(id);
    	if(!p.isPresent()) {
    		respuesta = 1;
    		LOGGER.log(Level.INFO, "No esta presente el producto con id : " + id);
    	}else {
    		LOGGER.log(Level.INFO, "Si esta presente el producto con id : " + id);
    	}
    	
    	
    	LOGGER.log(Level.INFO, "Vamos a borrar producto con id : " + id);
    	data.deleteById(id);
    	
    	LOGGER.log(Level.INFO, "Vamos a buscar producto con id : " + id);
    	Optional<Product> p2 = data.findById(id);
    	if(!p2.isPresent()) {
    		respuesta = 1;
    		LOGGER.log(Level.INFO, "No esta presente el producto con id : " + id);
    	}else {
    		LOGGER.log(Level.INFO, "Si esta presente el producto con id : " + id);
    	}
      
        return respuesta;

    }

    @Override
    public int updateProductById(int id, Product product) {
    	int respuesta = 0;
    	product.setId(id);
    	Product p = data.save(product);
    	
    	if(!p.equals(null)) {
    		respuesta = 1;
    	}
    	
     return respuesta;
    }        

}
