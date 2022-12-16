package br.dev.webit.application.jaxrs;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ClientErrorExceptionMapper implements ExceptionMapper<ClientErrorException> {

    @Override
    public Response toResponse(ClientErrorException ex) {
        return ex.getResponse();
    }
}
