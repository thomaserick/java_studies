package com.tef.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;



public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> 
{

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		 List<String> errors = new ArrayList<>();
         Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
         for(ConstraintViolation<?> error : constraintViolations) {
       	  String message = error.getMessage().toString();
       	  errors.add(message);
         }
         
         return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errors).build();
	}   
}