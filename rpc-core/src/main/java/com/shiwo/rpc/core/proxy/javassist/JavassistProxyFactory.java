package com.shiwo.rpc.core.proxy.javassist;

import com.shiwo.rpc.core.client.RpcReferenceWrapper;
import com.shiwo.rpc.core.proxy.ProxyFactory;


public class JavassistProxyFactory implements ProxyFactory {

    @Override
    public <T> T getProxy(RpcReferenceWrapper<T> rpcReferenceWrapper) throws Throwable {
        return (T) ProxyGenerator.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                rpcReferenceWrapper.getAimClass(), new JavassistInvocationHandler(rpcReferenceWrapper));
    }
}
