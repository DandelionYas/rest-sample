package com.ws.sample.demo.aspect;

import com.ws.sample.demo.authenticate.LoginRequest;
import com.ws.sample.demo.authenticate.LoginResult;
import com.ws.sample.demo.authenticate.TicketContainer;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Aspect
public class RestAuthenticator {
    private static LoginResult LOGIN_RESULT;
    private final String restUrl;
    private final String username;
    private final RestTemplate restTemplate;
    private String password;

    @Autowired
    public RestAuthenticator(RestTemplate restTemplate,
                             @Value("#{environment['rest.service.url']}") String restUrl,
                             @Value("#{environment['rest.service.username']}") String username,
                             @Value("#{environment['rest.service.password']}") String password) {
        this.restTemplate = restTemplate;
        this.restUrl = restUrl;
        this.username = username;
        this.password = password;
    }

    @PostConstruct
    public void init() {
//        this.password = PropertyEncryption.decrypt(this.password);
        this.doAuthenticate();
    }

    @Before("@within(RestAuthenticate) || @annotation(RestAuthenticate)")
    public void doAuthenticate() {
        if (LOGIN_RESULT == null) {
            LOGIN_RESULT = this.login(new LoginRequest(this.username, this.password));
        }

        TicketContainer.setTicket(LOGIN_RESULT.getTicket());
    }

    private LoginResult login(LoginRequest request) {
        return (LoginResult) this.restTemplate.exchange(this.restUrl + "login", HttpMethod.POST, new HttpEntity(request), LoginResult.class, new Object[0]).getBody();
    }
}