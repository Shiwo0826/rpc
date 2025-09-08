package com.shiwo.rpc.core.router;

import com.shiwo.rpc.core.common.ChannelFutureWrapper;
import com.shiwo.rpc.core.registry.URL;

/**
 * @description: 路由接口
 */
public interface Router {

    /**
     * 刷新路由数组
     *
     * @param selector
     */
    void refreshRouterArr(Selector selector);

    /**
     * 获取到请求的连接通道
     *
     * @param channelFutureWrappers
     * @return
     */
    ChannelFutureWrapper select(ChannelFutureWrapper[] channelFutureWrappers);

    /**
     * 更新权重信息
     *
     * @param url
     */
    void updateWeight(URL url);
}