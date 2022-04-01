package com.jtmc.apps.reforma.api.v1.annotations;

import org.glassfish.jersey.message.filtering.EntityFiltering;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NameBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@EntityFiltering
public @interface JwtRequired {
}