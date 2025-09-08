package com.shiwo.rpc.core.filter.server;

import com.shiwo.rpc.core.common.RpcInvocation;
import com.shiwo.rpc.core.common.annotations.SPI;
import com.shiwo.rpc.core.common.utils.CommonUtil;
import com.shiwo.rpc.core.filter.ServerFilter;
import com.shiwo.rpc.core.server.ServiceWrapper;

import static com.shiwo.rpc.core.common.cache.CommonServerCache.PROVIDER_SERVICE_WRAPPER_MAP;

/**
 * @description: 简单版本的token校验
 */
@SPI("before")
public class ServerTokenFilterImpl implements ServerFilter {

    @Override
    public void doFilter(RpcInvocation rpcInvocation) {
        String token = String.valueOf(rpcInvocation.getAttachments().get("serviceToken"));
        if (!PROVIDER_SERVICE_WRAPPER_MAP.containsKey(rpcInvocation.getTargetServiceName())) {
            return;
        }
        ServiceWrapper serviceWrapper = PROVIDER_SERVICE_WRAPPER_MAP.get(rpcInvocation.getTargetServiceName());
        String matchToken = String.valueOf(serviceWrapper.getServiceToken());
        if (CommonUtil.isEmpty(matchToken)) return;
        if (CommonUtil.isNotEmpty(token) && token.equals(matchToken)) return;
        throw new RuntimeException("token is " + token + " , verify result is false!");
    }
}