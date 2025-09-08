package com.shiwo.rpc.core.client;

import com.shiwo.rpc.core.common.RpcInvocation;
import com.shiwo.rpc.core.common.RpcProtocol;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import static com.shiwo.rpc.core.common.cache.CommonClientCache.CLIENT_SERIALIZE_FACTORY;
import static com.shiwo.rpc.core.common.cache.CommonClientCache.RESP_MAP;


/**
 * ClientHandler 是 RPC 客户端接收响应、匹配请求、唤醒调用线程的核心 Netty 处理器，
 * 它实现了“异步网络IO”到“同步方法调用”的桥梁，
 * 但当前实现存在线程同步、异常处理、资源清理等多处可优化点。
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcProtocol rpcProtocol = (RpcProtocol) msg;
        RpcInvocation rpcInvocation = CLIENT_SERIALIZE_FACTORY.deserialize(rpcProtocol.getContent(), RpcInvocation.class);
        if (rpcInvocation.getE() != null) {
            rpcInvocation.getE().printStackTrace();
        }
        //通过之前发送的uuid来注入匹配的响应数值
        if(!RESP_MAP.containsKey(rpcInvocation.getUuid())){
            throw new IllegalArgumentException("server response is error!");
        }

        RESP_MAP.put(rpcInvocation.getUuid(),rpcInvocation);
        ReferenceCountUtil.release(msg);
    }

    /**
     * 当 Channel 管道中发生未被捕获的异常时，Netty 会调用此方法。
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        Channel channel = ctx.channel();
        if(channel.isActive()){
            ctx.close();
        }
    }
}
