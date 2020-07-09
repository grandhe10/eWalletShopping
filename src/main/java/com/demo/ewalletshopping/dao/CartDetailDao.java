package com.demo.ewalletshopping.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.ewalletshopping.model.Cart;
import com.demo.ewalletshopping.model.CartDetail;
/**
 * @author Suma
 * This interface extends {@link CrudRepository}
 *
 */
@Repository
public interface CartDetailDao extends CrudRepository<CartDetail, Long>{

	/**
	 * This method is used to get Cart details by cart 
	 * @param cart
	 * @return List<CartDetail>
	 */
	Optional<List<CartDetail>> findByCart(Cart cart);

}
