package com.demo.ewalletshopping.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dao.CartDetailDao;
import com.demo.ewalletshopping.dao.ProductDao;
import com.demo.ewalletshopping.exception.ProductNotFoundException;
import com.demo.ewalletshopping.model.Cart;
import com.demo.ewalletshopping.model.CartDetail;
import com.demo.ewalletshopping.model.Product;
import com.demo.ewalletshopping.service.CartDetailService;
@Service
public class CartDetailServiceImpl implements CartDetailService{

	Log logger = LogFactory.getLog(CartDetailServiceImpl.class);
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartDetailDao cartDetailDao;
	@Override
	public double addToCart(Long productId, Long userId,Cart cart) {
		
		
		logger.info(ApplicationConstants.LOGINFO_CARTDETAIL_1);
		
	Optional<Product> productOptional =  productDao.findByProductId(productId);
			if(!productOptional.isPresent())
				throw new ProductNotFoundException(ApplicationConstants.PRODUCT_NOT_FOUND);
		CartDetail cartDetail = new CartDetail(); 
			cartDetail.setAddDate(LocalDate.now());
			cartDetail.setProduct(productOptional.get());
			cartDetail.setCart(cart);
			cartDetailDao.save(cartDetail);
			return productOptional.get().getPrice();
			
		
	}

}
