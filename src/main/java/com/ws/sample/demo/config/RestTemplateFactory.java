package com.ws.sample.demo.config;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class RestTemplateFactory {

    public static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }

        interceptors.add(new TicketInterceptor());
        restTemplate.setInterceptors(interceptors);

        restTemplate.setRequestFactory(new ClientRequestFactoryWithEntity());
        return restTemplate;
    }
}
