package mx.com.seting.shopiing.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.com.seting.shopiing.dao.ProductDao;
import mx.com.seting.shopiing.model.Product;


@Service
public class ProductService {

    

    //Inyeccion de dependencias de ProductDao
    @Autowired
    private ProductDao productDao;
    
    public int addProduct(Product product){
        return productDao.insertProduct(product);
    }

    public List<Product> getAllProduct(){
        return productDao.selectAllProduct();
    }

    public Optional<Product> selectProductById(int id){
        return productDao.selectProductById(id);
    }

    public int deleteProduct(int id){
        return productDao.deleteProductById(id);
    }

    public int updateProduct(int id, Product newProduct){
        return productDao.updateProductById(id, newProduct);
    }
}
