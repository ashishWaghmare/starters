package io.apptitude;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.kqueue.KQueue;
import io.netty.channel.kqueue.KQueueServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetector.Level;

public class App {

    static {
        ResourceLeakDetector.setLevel(Level.DISABLED);
    }

    private final int port;

    public App(int port) {
        this.port = port;
    }

    public void run() throws Exception {

        if (Epoll.isAvailable()) {
            doRun(new EpollEventLoopGroup(), EpollServerSocketChannel.class, IoMultiplexer.EPOLL);
        } else if (KQueue.isAvailable()) {
            doRun(new EpollEventLoopGroup(), KQueueServerSocketChannel.class, IoMultiplexer.KQUEUE);
        } else {
            doRun(new NioEventLoopGroup(), NioServerSocketChannel.class, IoMultiplexer.JDK);
        }
    }

    private void doRun(EventLoopGroup loupGroup, Class<? extends ServerChannel> serverChannelClass,
            IoMultiplexer multiplexer) throws InterruptedException {
        try {
            InetSocketAddress inet = new InetSocketAddress(port);

            ServerBootstrap b = new ServerBootstrap();

            if (multiplexer == IoMultiplexer.EPOLL) {
                b.option(EpollChannelOption.SO_REUSEPORT, true);
            }

            b.option(ChannelOption.SO_BACKLOG, 8192);
            b.option(ChannelOption.SO_REUSEADDR, true);
            b.group(loupGroup).channel(serverChannelClass).childHandler(new HelloServerInitializer(loupGroup.next()));
            b.childOption(ChannelOption.SO_REUSEADDR, true);

            Channel ch = b.bind(inet).sync().channel();

            System.out.printf("Httpd started. Listening on: %s%n", inet.toString());

            ch.closeFuture().sync();
        } finally {
            loupGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new App(port).run();
    }
}
