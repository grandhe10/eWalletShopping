package com.demo.ewalletshopping.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.ewalletshopping.model.Cart;
import com.demo.ewalletshopping.model.User;
/**
 * @author Suma
 * This interface extends {@link CrudRepository}
 *
 */
@Repository
public interface CartDao extends CrudRepository<Cart, Long>{

	Optional<List<Cart>> findByUser(User user);
Optional<Cart> findByCartId(Long cartId);
}
