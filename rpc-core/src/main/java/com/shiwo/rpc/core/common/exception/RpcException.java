package com.shiwo.rpc.core.common.exception;

import com.shiwo.rpc.core.common.RpcInvocation;

public class RpcException extends Exception {
    private RpcInvocation rpcInvocation;

    public RpcException(RpcInvocation rpcInvocation) {
        this.rpcInvocation = rpcInvocation;
    }

    public RpcInvocation getRpcInvocation() {
        return rpcInvocation;
    }

    public void setRpcInvocation(RpcInvocation rpcInvocation) {
        this.rpcInvocation = rpcInvocation;
    }

}
