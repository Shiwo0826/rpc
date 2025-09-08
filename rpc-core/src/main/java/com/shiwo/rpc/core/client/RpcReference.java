package com.shiwo.rpc.core.client;

import com.shiwo.rpc.core.common.utils.CommonUtil;
import com.shiwo.rpc.core.proxy.ProxyFactory;

import static com.shiwo.rpc.core.common.cache.CommonClientCache.CLIENT_CONFIG;

/**
 * rpc远程调用类
 */
public class RpcReference {

    public ProxyFactory proxyFactory;

    public RpcReference(ProxyFactory proxyFactory) {
        this.proxyFactory = proxyFactory;
    }

    /**
     * 根据接口类型获取代理对象
     */
    public <T> T get(RpcReferenceWrapper<T> rpcReferenceWrapper) throws Throwable {
        initGlobalRpcReferenceConfig(rpcReferenceWrapper);
        return proxyFactory.getProxy(rpcReferenceWrapper);
    }

    private void initGlobalRpcReferenceConfig(RpcReferenceWrapper<?> rpcReferenceWrapper) {
        if (CommonUtil.isEmpty(rpcReferenceWrapper.getTimeOut())) {
            rpcReferenceWrapper.setTimeOut(CLIENT_CONFIG.getTimeOut());
        }
    }
}