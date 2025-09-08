package com.shiwo.rpc.core.common;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description 负载均衡部分，轮询方式的实现
 */
public class ChannelFuturePollingRef {

    private final AtomicLong referenceTimes = new AtomicLong(0);


    public ChannelFutureWrapper getChannelFutureWrapper(ChannelFutureWrapper[] arr){
        long i = referenceTimes.getAndIncrement();
        int index = (int) (i % arr.length);
        return arr[index];
    }

}
