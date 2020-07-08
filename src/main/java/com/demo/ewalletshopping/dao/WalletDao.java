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
/**
 * @author 91970
 *
 */
/**
 * @author 91970
 *
 */
@Repository
public interface WalletDao extends CrudRepository<Wallet, Long>{
	
	/**
	 * This method is used to get the Wallet details by userId and walletNumber
	 * @param user
	 * @param walletNumber
	 * @return Wallet
	 */ 
	Optional<Wallet> findByUserAndWalletNumber(User user,Long walletNumber);
	
	
	/**
	 * This method is used to walletId and expiryDate
	 * @param walletId
	 * @param expriyDate
	 * @return Wallet
	 */ 
	Optional<Wallet> findByWalletIdAndExpiryDate(Long walletId,LocalDate expriyDate);


	/**
	 * This method is used to update balance of the wallet
	 * @param walletId
	 * @return
	 */
	Optional<Wallet> findByWalletId(Long walletId);

}