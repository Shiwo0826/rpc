package com.shiwo.rpc.core.filter.client;

import com.shiwo.rpc.core.common.ChannelFutureWrapper;
import com.shiwo.rpc.core.common.RpcInvocation;
import com.shiwo.rpc.core.common.utils.CommonUtil;
import com.shiwo.rpc.core.filter.ClientFilter;

import java.util.List;

/**
 * @description: 服务分组的过滤链路
 */
public class GroupFilterImpl implements ClientFilter {

    @Override
    public void doFilter(List<ChannelFutureWrapper> src, RpcInvocation rpcInvocation) {
        String group = String.valueOf(rpcInvocation.getAttachments().get("group"));
        src.removeIf(channelFutureWrapper -> !channelFutureWrapper.getGroup().equals(group));
        if (CommonUtil.isEmptyList(src)) {
            throw new RuntimeException("no provider match for group " + group);
        }
    }
}