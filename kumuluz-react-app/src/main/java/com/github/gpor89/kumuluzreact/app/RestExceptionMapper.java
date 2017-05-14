package com.github.gpor89.kumuluzreact.app;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by gregor on 14/05/2017.
 */
@Provider
public class RestExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable e) {
        //TODO make proper exception handler
        return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
    }
}
