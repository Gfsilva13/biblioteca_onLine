package com.home.exceptions;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {

        int status;

        if (exception instanceof NotFoundException) {
            status = Response.Status.NOT_FOUND.getStatusCode();
        } else if (exception instanceof BadRequestException) {
            status = Response.Status.BAD_REQUEST.getStatusCode();
        } else {
            status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        }

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status);
        body.put("error", exception.getClass().getSimpleName());
        body.put("message", exception.getMessage());
        return Response.status(status).entity(body).build();
    }
}
