package com.demo.ewalletshopping.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.ewalletshopping.model.Cart;
/**
 * @author Suma
 * This interface extends {@link CrudRepository}
 *
 */
@Repository
public interface CartDao extends CrudRepository<Cart, Long>{

	/**
	 * This method is used to get the CartDetails by cartId
	 * @param cartId
	 * @return Cart
	 */
	Optional<Cart> findByCartId(Long cartId);

}
