package com.jtmc.apps.reforma.repository.mybatis.exception;

import com.jtmc.apps.reforma.repository.exception.RepositoryException;

public class MyBatisRepositoryException extends RepositoryException {

    public MyBatisRepositoryException(String message, int statusCode) {
        super(message, statusCode);
    }
}
