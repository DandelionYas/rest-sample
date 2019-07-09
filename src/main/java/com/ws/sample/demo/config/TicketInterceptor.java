package com.ws.sample.demo.config;

import com.ws.sample.demo.authenticate.TicketContainer;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class TicketInterceptor implements ClientHttpRequestInterceptor {
    private static final String NAKISA_HEADER = "nakisa-ticket";

    @Override
    public ClientHttpResponse intercept(HttpRequest request,
                                        byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {


        request.getHeaders().add(NAKISA_HEADER, TicketContainer.getTicket());

        ClientHttpResponse response = execution.execute(request, body);
        return response;
    }
}