package com.shiwo.rpc.core.common.exception;

import com.shiwo.rpc.core.common.RpcInvocation;

/**
 * @description: 服务端限流异常
 */
public class MaxServiceLimitRequestException extends RpcException{

    public MaxServiceLimitRequestException(RpcInvocation rpcInvocation) {
        super(rpcInvocation);
    }
}
