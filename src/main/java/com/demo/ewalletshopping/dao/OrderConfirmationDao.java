package com.demo.ewalletshopping.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.ewalletshopping.model.Cart;
import com.demo.ewalletshopping.model.OrderConfirmation;
import com.demo.ewalletshopping.model.User;

/**
 * @author 
 * This interface extends {@link CrudRepository}
 *
 */
@Repository
public interface OrderConfirmationDao  extends CrudRepository<OrderConfirmation, Long>{
	/**
	 * @param cart
	 * @param user
	 * @return cart user objects 
	 */
	Optional<OrderConfirmation> findByCartAndUser(Cart cart,User user);
	

}
