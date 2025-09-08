package com.shiwo.rpc.core.filter.server;

import com.shiwo.rpc.core.common.RpcInvocation;
import com.shiwo.rpc.core.common.annotations.SPI;
import com.shiwo.rpc.core.filter.ServerFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 服务端日志过滤器
 */
@SPI("before")
public class ServerLogFilterImpl implements ServerFilter {

    private final Logger logger = LoggerFactory.getLogger(ServerLogFilterImpl.class);

    @Override
    public void doFilter(RpcInvocation rpcInvocation) {
        logger.info(rpcInvocation.getAttachments().get("c_app_name") + " do invoke -----> " +
                rpcInvocation.getTargetServiceName() + "#" + rpcInvocation.getTargetMethod());
    }
}
