package com.ws.sample.demo.error;

public class RestError extends RuntimeException {
    private RestFault faultInfo;

    public RestError(String message, RestFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public RestError(String message, RestFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    public RestError(RestError error) {
        super(error.getMessage(), error);
        this.faultInfo = error.faultInfo;
    }

    public RestError(String code, Object... params) {
        super(ErrorStatic.makeErrorParams(code, params));
        this.faultInfo = new RestFault(code, params, this.getMessage());
    }

    public String getCode() {
        return this.faultInfo.getCode();
    }

    public void setCode(String code) {
        this.faultInfo.setCode(code);
    }

    public Object[] getParams() {
        return this.faultInfo.getParams();
    }

    public void setParams(Object[] params) {
        this.faultInfo.setParams(params);
    }

    public RestFault getFaultInfo() {
        return this.faultInfo;
    }

    public void setFaultInfo(RestFault faultInfo) {
        this.faultInfo = faultInfo;
    }
}
