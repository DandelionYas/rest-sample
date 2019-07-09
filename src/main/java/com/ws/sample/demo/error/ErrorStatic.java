package com.ws.sample.demo.error;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;

public class ErrorStatic {
    private static Map<String, String> errorsMap;
    public static final String ERROR_A2_INSUFFICIENT_PRIVILEGE = "EA20001";
    public static final String ERROR_A2_INVALID_USER_OR_PASSWORD = "EA20002";
    public static final String ERROR_A2_USER_NOT_LOGGED_IN = "EA20003";
    public static final String ERROR_A2_APPKEY_IS_INVALID = "EA20004";

    public ErrorStatic(Map<String, String> errorsMap) {
        errorsMap = errorsMap;
    }

    public static String makeErrorParams(String key, Object[] params) {
        String retValue = key;
        if (errorsMap.containsKey(key)) {
            retValue = key + ": " + MessageFormat.format((String)errorsMap.get(key), params);
        } else if (params != null && params.length > 0) {
            retValue = key + ": " + Arrays.asList(params).toString();
        }

        return retValue;
    }
}
