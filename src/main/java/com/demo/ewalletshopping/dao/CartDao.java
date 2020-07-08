package com.demo.ewalletshopping.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.ewalletshopping.model.Cart;
import com.demo.ewalletshopping.model.User;
/**
 * @author 
 * This interface extends {@link CrudRepository}
 *
 */
@Repository
public interface CartDao extends CrudRepository<Cart, Long>{
	
	/**
	 * @param cartId
	 * @return cartid
	 */
	Optional<Cart> findByCartId(Long cartId);
	/**
	 * @param cartId
	 * @param user
	 * @return find cart by userid
	 */
	Optional<Cart> findByCartIdAndUser(Long cartId,User user);

}
