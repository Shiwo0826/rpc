package com.shiwo.rpc.provider.springboot.impl;

import com.shiwo.rpc.interfaces.UserService;
import com.shiwo.rpc.spring.starter.common.EasyRpcService;

/**
 * @description:
 */
@EasyRpcService
public class UserServiceImpl implements UserService {

    @Override
    public void test() {
        System.out.println("UserServiceImpl : test");
    }
}
