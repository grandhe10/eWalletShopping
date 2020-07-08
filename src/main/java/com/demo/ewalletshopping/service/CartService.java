package com.demo.ewalletshopping.service;

import com.demo.ewalletshopping.model.User;

public interface CartService {
	public boolean UpdateCartStatusByCartIdAndUser(Long CartId,User user);

}
