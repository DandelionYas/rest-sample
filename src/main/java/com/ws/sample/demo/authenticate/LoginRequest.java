package com.ws.sample.demo.authenticate;

import lombok.Data;

@Data
public final class LoginRequest {
    private String clientPassword;
    private String clientUsername;

    public LoginRequest(String clientUsername, String clientPassword) {
        this.clientUsername = clientUsername;
        this.clientPassword = clientPassword;
    }
}