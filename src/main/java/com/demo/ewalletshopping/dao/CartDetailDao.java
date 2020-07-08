package com.demo.ewalletshopping.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.ewalletshopping.model.CartDetail;
/**
 * @author Suma
 * This interface extends {@link CrudRepository}
 *
 */
@Repository
public interface CartDetailDao extends CrudRepository<CartDetail, Long>{

}
