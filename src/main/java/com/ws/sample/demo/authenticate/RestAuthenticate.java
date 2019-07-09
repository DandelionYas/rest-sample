package com.ws.sample.demo.authenticate;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value = {METHOD, TYPE})
@Retention(value = RUNTIME)
public @interface RestAuthenticate {
}
