package com.tef.config;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.tef.exception.AuthenticationException;
import com.tef.exception.EntityNotFound;
import com.tef.exception.InvalidRequest;


/**
 * ExceptionProvider
 */

@Provider
public class ExceptionProvider implements ExceptionMapper<Exception>
{

    @Override
    public Response toResponse(Exception exception)
    {
        Map<String, Object> entity = new HashMap<>();
        entity.put("message", exception.getMessage());
        int statusCode = 500;
        if (exception instanceof AuthenticationException)
        {   
            statusCode = 401;
        }
        if (exception instanceof EntityNotFound)
        {
            statusCode = 404;
        }
        if (exception instanceof InvalidRequest)
        {
            statusCode = 400;
        }    
        
        if(statusCode == 500) {
            exception.printStackTrace();
        }
        return Response.status(statusCode).entity(entity)
                .header("content-type", MediaType.APPLICATION_JSON).build();
    }

}