package com.example.dev.exeption;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.controller.Categorycontroller;
import com.example.dev.payload.ApiResponce;

@RestController
public class GobalExeption {


	private static final Logger logger = Logger.getLogger(GobalExeption.class.getName());
	
	@ExceptionHandler(ResourceNotFoundExeption.class)
	public ResponseEntity<ApiResponce> resourceNotFounExeptionHandler(ResourceNotFoundExeption ex){
		logger.info("exeption info");
		String message =ex.getMessage();
		ApiResponce apiResponce = new ApiResponce(message ,false);
		return new ResponseEntity<ApiResponce>(apiResponce,HttpStatus.NOT_FOUND);
	}
	
	
	
	public ResponseEntity<Map<String ,String>> handleMethodArgNotvalidEx(MethodArgumentNotValidException ex){
		
		Map <String ,String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		
	return new 	ResponseEntity<Map<String ,String>>(resp,HttpStatus.BAD_REQUEST);
	}
}
