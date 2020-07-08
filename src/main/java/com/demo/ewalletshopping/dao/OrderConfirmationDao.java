package com.demo.ewalletshopping.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.ewalletshopping.model.OrderConfirmation;

/**
 * @author Suma
 * This interface extends {@link CrudRepository}
 *
 */
@Repository
public interface OrderConfirmationDao  extends CrudRepository<OrderConfirmation, Long>{

}
