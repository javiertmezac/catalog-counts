package com.jtmc.apps.reforma;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.dbmapper.UserMapper;
import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import org.mybatis.guice.transactional.Transactional;

public class FooServiceMapperImpl implements FooService {

    @Inject
    private UserMapper userMapper;

    @Transactional
    public void doSomeBusinessStuff(int userId) {
        CatalogCountEnum catalogCountEnum = userMapper.getCatalogCountEnum(userId);
        System.out.println(catalogCountEnum.toString());
    }

    public void sayHello() {
        System.out.println("hey world, this is with DI");
    }
}
