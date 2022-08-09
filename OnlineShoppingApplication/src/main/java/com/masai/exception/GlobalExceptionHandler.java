package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<MyError> myExceptionHandler(ProductNotFoundException pne, WebRequest wr){
		MyError err= new MyError(LocalDateTime.now(),pne.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<MyError> orderExceptionHandler(OrderNotFoundException pne, WebRequest wr){
		MyError err= new MyError(LocalDateTime.now(),pne.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<MyError> addressExceptionHandler(AddressException ae, WebRequest wr){
		MyError err= new MyError(LocalDateTime.now(),ae.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyError> customerExceptionHandler(CustomerException ce, WebRequest wr){
		MyError err= new MyError(LocalDateTime.now(),ce.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyError> userExceptionHandler(UserException ue, WebRequest wr){
		MyError err= new MyError(LocalDateTime.now(),ue.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyError> cartExceptionHandler(CartException ce, WebRequest wr){
		MyError err= new MyError(LocalDateTime.now(),ce.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {
		
		MyError err=new MyError(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));

	return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
				
}
	
	public ResponseEntity<MyError> myExcHandler(Exception e, WebRequest wr){
		MyError err=new MyError(LocalDateTime.now(),e.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
}
