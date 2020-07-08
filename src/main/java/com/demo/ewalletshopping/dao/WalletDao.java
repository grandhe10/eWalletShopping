package com.demo.ewalletshopping.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.ewalletshopping.model.Wallet;

/**
 * @author Suma
 * This interface extends {@link CrudRepository}
 *
 */
@Repository
public interface WalletDao extends CrudRepository<Wallet, Long>{

}
