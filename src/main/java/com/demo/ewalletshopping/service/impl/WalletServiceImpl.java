package com.demo.ewalletshopping.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dao.WalletDao;
import com.demo.ewalletshopping.exception.WalletNotFoundException;
import com.demo.ewalletshopping.model.Wallet;
import com.demo.ewalletshopping.service.WalletService;

@Transactional
@Service
public class WalletServiceImpl implements WalletService{

	@Autowired
	WalletDao walletDao;
	
	@Override
	public void updatebalance(double amount, Long walletId) {
		
		Optional<Wallet> walletOptional = walletDao.findByWalletId(walletId);
		
		if(!walletOptional.isPresent())
			throw new WalletNotFoundException(ApplicationConstants.WALLET_NOT_FOUND);
		
		walletOptional.get().setBalance(walletOptional.get().getBalance()-amount);
		walletDao.save(walletOptional.get());
		
	}

}
