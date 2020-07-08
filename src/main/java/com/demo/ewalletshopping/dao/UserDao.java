package com.demo.ewalletshopping.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.ewalletshopping.model.User;

/**
 * @author Suma
 * This interface is extends CrudRepository
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	/**
	 * This method is used to authenticate user
	 * @param userName
	 * @param password
	 * @return User
	 */
	Optional<User> findByUserNameAndPassword(String userName, String password);

	/**
	 * This method is used to fetch User Details by userId
	 * @param userId
	 * @return User
	 */
	Optional<User> findByUserId(Long userId);

}
