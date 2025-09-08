package com.shiwo.rpc.core.filter.server;

import com.shiwo.rpc.core.common.RpcInvocation;
import com.shiwo.rpc.core.common.ServerServiceSemaphoreWrapper;
import com.shiwo.rpc.core.common.annotations.SPI;
import com.shiwo.rpc.core.filter.ServerFilter;

import static com.shiwo.rpc.core.common.cache.CommonServerCache.SERVER_SERVICE_SEMAPHORE_MAP;

/**
 * @description: 服务端用于释放semaphore对象
 */
@SPI("after")
public class ServerServiceAfterLimitFilterImpl implements ServerFilter {

    @Override
    public void doFilter(RpcInvocation rpcInvocation) {
        String serviceName = rpcInvocation.getTargetServiceName();
        if (!SERVER_SERVICE_SEMAPHORE_MAP.containsKey(serviceName)) {
            return;
        }
        ServerServiceSemaphoreWrapper serverServiceSemaphoreWrapper = SERVER_SERVICE_SEMAPHORE_MAP.get(serviceName);
        serverServiceSemaphoreWrapper.getSemaphore().release();
    }
}
