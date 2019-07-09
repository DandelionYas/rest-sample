package com.ws.sample.demo.error;

public class RestFault {
    String code;
    Object[] params;
    String message;

    public RestFault() {
    }

    public RestFault(String code, Object[] params, String message) {
        this.code = code;
        this.params = params;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object[] getParams() {
        return this.params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
