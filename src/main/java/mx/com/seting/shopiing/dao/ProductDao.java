package mx.com.seting.shopiing.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import mx.com.seting.shopiing.model.Product;


public interface ProductDao{

   
    public int insertProduct(Product product);
   
    // JAVA 8 introducida
    Optional<Product> selectProductById(int id);

    List<Product> selectAllProduct();

    public int deleteProductById(int id);

    public int updateProductById(int id, Product product);



}

