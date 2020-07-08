package com.demo.ewalletshopping.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.ewalletshopping.model.User;
import com.demo.ewalletshopping.model.Wallet;

/**
 * @author Suma
 * This interface extends {@link CrudRepository}
 *
 */
@Repository
public interface WalletDao extends CrudRepository<Wallet, Long>{
	Optional<Wallet> findByUserAndWalletNumber(User user,Long walletNumber);
	Optional<Wallet> findByWalletIdAndExpiryDate(Long walletId,LocalDate expriyDate);

}
