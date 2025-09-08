package com.shiwo.rpc.core.filter.server;

import com.shiwo.rpc.core.common.RpcInvocation;
import com.shiwo.rpc.core.filter.ServerFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 服务端模块的前置过滤链设计
 */
public class ServerBeforeFilterChain {

    private static List<ServerFilter> serverFilters = new ArrayList<>();

    public void addServerFilter(ServerFilter iServerFilter) {
        serverFilters.add(iServerFilter);
    }

    public void doFilter(RpcInvocation rpcInvocation) {
        for (ServerFilter serverFilter : serverFilters) {
            serverFilter.doFilter(rpcInvocation);
        }
    }
}
