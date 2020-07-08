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

	Optional<User> findByUserId(Long userId);

}
