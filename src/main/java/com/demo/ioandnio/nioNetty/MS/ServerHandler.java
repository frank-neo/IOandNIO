package com.demo.ioandnio.nioNetty.MS;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ServerHandler extends ChannelHandlerAdapter {

    public void channelActive (ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channel active（服务端通道已经可用）... ");
    }

    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{

        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println("Server 【服务端】:" + body );
        String response = "返回给客户端的响应：" + body ;
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
        // future完成后触发监听器, 此处是写完即关闭(短连接). 因此需要关闭连接时, 要通过server端关闭. 直接关闭用方法ctx[.channel()].close()
        //.addListener(ChannelFutureListener.CLOSE);
    }

    public void channelReadComplete(ChannelHandlerContext ctx)
            throws Exception {
        System.out.println("server读完了");
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable t)
            throws Exception {
        ctx.close();
    }
}
