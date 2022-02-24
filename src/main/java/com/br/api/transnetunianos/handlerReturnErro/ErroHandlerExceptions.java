package com.br.api.transnetunianos.handlerReturnErro;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.br.api.transnetunianos.exceptions.ReturnErroMessageCostomization;

@RestControllerAdvice
public class ErroHandlerExceptions {
   
	
	@ExceptionHandler(ReturnErroMessageCostomization.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ExceptionsErroCustom returnErro(Exception ex,WebRequest request) {
		ExceptionsErroCustom erro = new ExceptionsErroCustom(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		
		return erro;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ExceptionsErroCustom erroSubscrever (Exception ex, WebRequest request) {
		 ExceptionsErroCustom erroReturn = new ExceptionsErroCustom(
				 HttpStatus.INTERNAL_SERVER_ERROR.value(),
				 new Date(), 
				 ex.getMessage(), 
				 request.getDescription(false));
		 
		return erroReturn;
	}
}