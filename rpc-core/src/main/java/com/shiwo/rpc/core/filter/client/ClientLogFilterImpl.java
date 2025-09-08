package com.shiwo.rpc.core.filter.client;

import com.shiwo.rpc.core.common.ChannelFutureWrapper;
import com.shiwo.rpc.core.common.RpcInvocation;
import com.shiwo.rpc.core.filter.ClientFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.shiwo.rpc.core.common.cache.CommonClientCache.CLIENT_CONFIG;

/**
 * @description: 客户端日志记录过滤链路
 */
public class ClientLogFilterImpl implements ClientFilter {

    private final Logger logger = LoggerFactory.getLogger(ClientLogFilterImpl.class);

    @Override
    public void doFilter(List<ChannelFutureWrapper> src, RpcInvocation rpcInvocation) {
        rpcInvocation.getAttachments().put("c_app_name", CLIENT_CONFIG.getApplicationName());
        logger.info(rpcInvocation.getAttachments().get("c_app_name") + " do invoke -----> " +
                rpcInvocation.getTargetServiceName() + "#" + rpcInvocation.getTargetMethod());
    }

}