package com.demo.ewalletshopping.service.impl;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dao.CartDao;
import com.demo.ewalletshopping.dao.ProductDao;
import com.demo.ewalletshopping.dao.UserDao;
import com.demo.ewalletshopping.dto.CartResponse;
import com.demo.ewalletshopping.dto.OrderResponseDto;
import com.demo.ewalletshopping.dto.ProductIdDto;
import com.demo.ewalletshopping.dto.Status;
import com.demo.ewalletshopping.model.Cart;
import com.demo.ewalletshopping.model.Product;
import com.demo.ewalletshopping.model.User;


public class CartServiceImplTest {
	
	@Mock
	UserDao userDao;
	
	@Mock
	ProductDao productDao;
	
	@Mock
	CartDao cartDao;

	@InjectMocks
	CartServiceimpl cartServiceImpl;
	
	OrderResponseDto orderResponseDto;

	@BeforeEach
	public void setUp() {

	}
	
	@Test
	public void addToCartTest()
	{	
	User user = new User();
	user.setPassword("test123");
	user.setUserId(1L);
	user.setUserName("TEST123");	
	
	Cart cart = new Cart();
	cart.setAmount(2000);
	cart.setCartId(1L);
	cart.setStatus(Status.INCART);
	cart.setUser(user);
	
	CartResponse cartResponse = new CartResponse();
	cartResponse.setAmount(5000);
	cartResponse.setCarId(1L);
	cartResponse.setMessage(ApplicationConstants.CART_SUCCESS);
	cartResponse.setStatuscode(ApplicationConstants.CART_SUCCESS_CODE);
	
	ProductIdDto productIdDto = new ProductIdDto();
	productIdDto.setProductId(1L);
	
	List<ProductIdDto> productList = new ArrayList<>();
	productList.add(productIdDto);
	
	
	Product product = new Product();
	product.setDescription("description");
	product.setPrice(200);
	product.setProductId(1L);
	product.setProductName("product1");
	
	
	}
}
