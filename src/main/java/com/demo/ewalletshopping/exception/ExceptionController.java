package com.demo.ewalletshopping.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.ewalletshopping.constants.ApplicationConstants;



@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{
	@ExceptionHandler(value = UserUnauthorizedException.class)
	public ResponseEntity<ErrorResponse> exception(UserUnauthorizedException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ApplicationConstants.UNAUTHORIZED_USER);
		errorResponse.setStatusCode(ApplicationConstants.UNAUTHORIZED_USER_CODE);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> exception(UserNotFoundException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ApplicationConstants.USER_NOT_FOUND);
		errorResponse.setStatusCode(ApplicationConstants.USER_NOT_FOUND_CODE);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = BalanceInsufficientException.class)
	public ResponseEntity<ErrorResponse> exception(BalanceInsufficientException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ApplicationConstants.USER_NOT_FOUND);
		errorResponse.setStatusCode(ApplicationConstants.USER_NOT_FOUND_CODE);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = CartNotFoundException.class)
	public ResponseEntity<ErrorResponse> exception(CartNotFoundException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ApplicationConstants.CART_NOT_FOUND);
		errorResponse.setStatusCode(ApplicationConstants.CART_NOT_FOUND_CODE);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = WalletNotFoundException.class)
	public ResponseEntity<ErrorResponse> exception(WalletNotFoundException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ApplicationConstants.WALLET_NOT_FOUND);
		errorResponse.setStatusCode(ApplicationConstants.WALLET_NOT_FOUND_CODE);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NoOrdersFoundException.class)
	public ResponseEntity<ErrorResponse> exception(NoOrdersFoundException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ApplicationConstants.NO_ORDERS_FOUND);
		errorResponse.setStatusCode(ApplicationConstants.NO_ORDERS_FOUND_CODE);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	 @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	       ErrorResponse errorResponse = new ErrorResponse();
	       errorResponse.setStatusCode(ApplicationConstants.INVALD_INPUT);
	       String allErrors = ex.getBindingResult().getFieldErrors().stream().
	    		   map(e->e.getDefaultMessage()).collect(Collectors.joining(","));
	       errorResponse.setMessage(allErrors);
	        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	    }
}