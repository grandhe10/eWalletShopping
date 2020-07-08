package com.demo.ewalletshopping.dao;

import java.util.List;
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

	/**
	 * This method is used to get PetAnimals list by petName
	 * @param petAnimalName
	 * @return List of Pets
	 */
	Optional<List<Product>> findByProductNameContaining(String productName);

	
	
	/**
	 * This method is used to fetch productDetails by product Id
	 * @param productId
	 * @return Product
	 */
	Optional<Product> findByProductId(Long productId);
}
