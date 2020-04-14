package com.tef.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.tef.cursomc.services.exceptions.AuthorizationException;
import com.tef.cursomc.services.exceptions.DataIntegrityException;
import com.tef.cursomc.services.exceptions.FileException;
import com.tef.cursomc.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourcesExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

		StandardError err =	new StandardError(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(),"Not Found", e.getMessage(), request.getRequestURI() );
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {

		StandardError err = new StandardError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),"Data Integrity", e.getMessage(), request.getRequestURI() );
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

		ValidationError err = new ValidationError(System.currentTimeMillis(),HttpStatus.UNPROCESSABLE_ENTITY.value(),"Validation error", e.getMessage(), request.getRequestURI() );
		for (FieldError error : e.getBindingResult().getFieldErrors()) {
			err.addError(error.getField(), error.getDefaultMessage());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {

		StandardError err =	new StandardError(System.currentTimeMillis(),HttpStatus.FORBIDDEN.value(),"Access denied", e.getMessage(), request.getRequestURI() );
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}

	@ExceptionHandler(FileException.class)
	public ResponseEntity<StandardError> file(FileException e, HttpServletRequest request) {

		StandardError err =	new StandardError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),"File error", e.getMessage(), request.getRequestURI() );
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(AmazonServiceException.class)
	public ResponseEntity<StandardError> amazonService(AmazonServiceException e, HttpServletRequest request) {
		// Pega o codigo http que veio da exceção e transforma para obj tipo status
		HttpStatus httpStatus = HttpStatus.valueOf(e.getErrorCode());
		StandardError err =	new StandardError(System.currentTimeMillis(),httpStatus.value(),"Error Amazon Service", e.getMessage(), request.getRequestURI() );
		return ResponseEntity.status(httpStatus).body(err);
	}

	@ExceptionHandler(AmazonClientException.class)
	public ResponseEntity<StandardError> amazonClient(AmazonClientException e, HttpServletRequest request) {

		StandardError err =	new StandardError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),"Error Amazon Client", e.getMessage(), request.getRequestURI() );
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(AmazonS3Exception.class)
	public ResponseEntity<StandardError> amazons3(AmazonS3Exception e, HttpServletRequest request) {

		StandardError err =	new StandardError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),"Error Amazon S3", e.getMessage(), request.getRequestURI() );
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

}
