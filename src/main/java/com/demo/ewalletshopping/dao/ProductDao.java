package com.demo.ewalletshopping.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.ewalletshopping.model.Product;
/**
 * @author Suma
 * This interface extends {@link CrudRepository}
 *
 */
@Repository
public interface ProductDao extends CrudRepository<Product, Long>{
Optional<Product> findByProductId(Long productId);
}
