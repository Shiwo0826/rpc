package com.shiwo.rpc.core.filter.client;

import com.shiwo.rpc.core.common.ChannelFutureWrapper;
import com.shiwo.rpc.core.common.RpcInvocation;
import com.shiwo.rpc.core.common.utils.CommonUtil;
import com.shiwo.rpc.core.filter.ClientFilter;

import java.util.List;

/**
 * @description: ip直连过滤器
 */
public class DirectInvokeFilterImpl implements ClientFilter {

    @Override
    public void doFilter(List<ChannelFutureWrapper> src, RpcInvocation rpcInvocation) {
        String url = (String) rpcInvocation.getAttachments().get("url");
        if (CommonUtil.isEmpty(url)) return;

        src.removeIf(channelFutureWrapper -> !(channelFutureWrapper.getHost() + ":" + channelFutureWrapper.getPort()).equals(url));
        if (CommonUtil.isEmptyList(src)) {
            throw new RuntimeException("no match provider url for " + url);
        }
    }
}
