package com.jtmc.apps.reforma.repository.mybatis.exception;

import com.jtmc.apps.reforma.repository.exception.RepositoryException;

public class MyBatisRepositoryMapperException extends RepositoryException {

    public MyBatisRepositoryMapperException(String message, int statusCode) {
        super(message, statusCode);
    }
}
