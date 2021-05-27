package mx.com.seting.shopiing.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import mx.com.seting.shopiing.model.Product;

public interface ProductData  extends CrudRepository<Product, Integer>{

}
