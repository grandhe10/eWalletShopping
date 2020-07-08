package com.demo.ewalletshopping.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ewalletshopping.dao.CartDao;
import com.demo.ewalletshopping.dao.CartDetailDao;
import com.demo.ewalletshopping.dao.OrderConfirmationDao;
import com.demo.ewalletshopping.dao.ProductDao;
import com.demo.ewalletshopping.dao.UserDao;
import com.demo.ewalletshopping.dto.HistoryRequestDto;
import com.demo.ewalletshopping.dto.OrderHistoryDto;
import com.demo.ewalletshopping.dto.OrderHistoryResponseDto;
import com.demo.ewalletshopping.exception.NoOrdersFoundException;
import com.demo.ewalletshopping.model.OrderConfirmation;
import com.demo.ewalletshopping.model.User;
import com.demo.ewalletshopping.service.OrderConfirmationService;

@Service
public class OrderConfirmationServiceImpl implements OrderConfirmationService {
	static Log logger = LogFactory.getLog(OrderConfirmationServiceImpl.class);
	@Autowired
	CartDao cartDao;
	@Autowired
	OrderConfirmationDao orderConfirmationDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	CartDetailDao cartDetailDao;

	@Override
	public OrderHistoryResponseDto getOrderHistory(HistoryRequestDto historyRequestDto, Long userId) {
		OrderHistoryResponseDto orderHistoryResponseDto = new OrderHistoryResponseDto();
		LocalDate date = LocalDate.parse(historyRequestDto.getOrderDate());
		Optional<User> user = userDao.findByUserId(userId);
		if (!user.isPresent()) {

			throw new NoOrdersFoundException("No user found for this userId");
		}
		Optional<List<OrderConfirmation>> orderConfirmations = orderConfirmationDao.findByOrderDateAndUser(date,
				user.get());
		if (!orderConfirmations.isPresent()) {

			throw new NoOrdersFoundException("No orders found for this userId and date");
		}

		List<OrderHistoryDto> getorderHistoryDtoList = orderConfirmations.get().stream()
				.map(orderConfirmation -> getOrderHistoryDto(orderConfirmation)).collect(Collectors.toList());
		orderHistoryResponseDto.setOrderHistoryDtoList(getorderHistoryDtoList);
		orderHistoryResponseDto.setMessage("Please find the account details");
		orderHistoryResponseDto.setStatusCode(200);
		return orderHistoryResponseDto;
	}

	private OrderHistoryDto getOrderHistoryDto(OrderConfirmation orderConfirmation) {

		OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
		BeanUtils.copyProperties(orderConfirmation, orderHistoryDto);
		return orderHistoryDto;
	}

}
