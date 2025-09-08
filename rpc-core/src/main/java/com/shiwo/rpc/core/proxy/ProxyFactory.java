package com.shiwo.rpc.core.proxy;

import com.shiwo.rpc.core.client.RpcReferenceWrapper;

/**
 * @description: 代理工厂接口
 */
public interface ProxyFactory {


    <T> T getProxy(final RpcReferenceWrapper<T> rpcReferenceWrapper) throws Throwable;
}
