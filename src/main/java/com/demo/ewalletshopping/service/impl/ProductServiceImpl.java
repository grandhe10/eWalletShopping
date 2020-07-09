package com.demo.ewalletshopping.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dao.ProductDao;
import com.demo.ewalletshopping.dto.ProductResponse;
import com.demo.ewalletshopping.dto.ProductResponseDto;
import com.demo.ewalletshopping.exception.ProductNotFoundException;
import com.demo.ewalletshopping.model.Product;
import com.demo.ewalletshopping.service.ProductService;

@Transactional
@Service
public class ProductServiceImpl implements ProductService{

Log logger = LogFactory.getLog(ProductServiceImpl.class);
	
	@Autowired
	ProductDao productDao;
	@Override
	public ProductResponseDto getProductListByName(String productName) {
		
		logger.info(ApplicationConstants.LOGINFO_PRODUCT_1);
		Optional<List<Product>> productList = productDao.findByProductNameContaining(productName);
		
		if(!productList.isPresent())	
		{
			logger.info(ApplicationConstants.LOGINFO_PRODUCT_4);	
			throw new ProductNotFoundException(ApplicationConstants.PRODUCT_NOT_FOUND);
		}
		
		List<ProductResponse> responseList = productList.get().stream().map(this::getProductResponse).collect(Collectors.toList());
		
		ProductResponseDto productResponseDto = new ProductResponseDto();
		
		productResponseDto.setStatusCode(ApplicationConstants.PRODUCT_FOUND_CODE);
		productResponseDto.setMessage(ApplicationConstants.PRODUCT_FOUND);
		productResponseDto.setProductResponseList(responseList);
		
		logger.info(ApplicationConstants.LOGINFO_PRODUCT_3);
		
		return productResponseDto;
	}

	private ProductResponse getProductResponse(Product product)
	{
		logger.info(ApplicationConstants.LOGINFO_PRODUCT_2);
		ProductResponse productResponse = new ProductResponse();
		
		productResponse.setDescritpion(product.getDescription());
		productResponse.setPrice(product.getPrice());
		productResponse.setProductId(product.getProductId());
		productResponse.setProductName(product.getProductName());
		return productResponse;
		
	}

}
