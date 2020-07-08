package com.demo.ewalletshopping.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dto.ProductResponseDto;
import com.demo.ewalletshopping.service.ProductService;

@RestController
public class ProductController {

Log logger = LogFactory.getLog(ProductController.class);
	
	@Autowired
	ProductService productService;	
			
	/**
	 * This method is used to get list of pet animals by petAnimalName
	 * @param petAnimalName
	 * @return ResponseEntity with header and List<PetAnimalResponse>
	 */
	@GetMapping("/products")
	public ResponseEntity<ProductResponseDto> getProductList(@RequestParam("productName") String productName)
	{
		logger.info(ApplicationConstants.LOGINFO_PRODUCT_CONTROLLER_1);
		return new ResponseEntity<>(productService.getProductListByName(productName),HttpStatus.OK);
	}
	
}
