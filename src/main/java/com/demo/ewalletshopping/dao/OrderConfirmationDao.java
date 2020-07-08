package com.demo.ewalletshopping.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.ewalletshopping.model.OrderConfirmation;
import com.demo.ewalletshopping.model.User;


/**
 * @author haritha
 * This interface extends {@link CrudRepository}
 *
 */
@Repository
public interface OrderConfirmationDao  extends CrudRepository<OrderConfirmation, Long>{
	
	

	/**
	 * this method is used to find order history
	 * @param date
	 * @param user
	 * @return OrderConfirmation
	 */
	Optional<List<OrderConfirmation>> findByOrderDateAndUser(LocalDate date, User user);
}
