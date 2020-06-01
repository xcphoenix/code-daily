package chapter9.example9d5;

import javax.transaction.Synchronization;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author      xuanc
 * @date        2019/12/10 下午12:30
 * @version     1.0
 */ 
public class EchoServer {

    public static int DEFAULT_PORT = 1077;

    public static void main(String[] args) {

        // 端口设置
        int port;
        try {
            port = Integer.parseInt(args[0]);
        } catch (RuntimeException ex) {
            port = DEFAULT_PORT;
        }
        System.out.println("Listening for connections on port " + port);

        ServerSocketChannel serverSocketChannel;
        Selector selector;
        try {
            // 创建一个通道
            serverSocketChannel = ServerSocketChannel.open();
            ServerSocket ss = serverSocketChannel.socket();
            InetSocketAddress address = new InetSocketAddress(port);
            // 绑定端口
            ss.bind(address);
            // 配置非阻塞
            serverSocketChannel.configureBlocking(false);
            // 打开通道选择器
            selector = Selector.open();
            // 使用通道的 register() 方法向监视这个通道的选择器进行注册 accept 事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }

        /*
         * 轮询判断事件
         */
        while (true) {
            try {
                selector.select();
            } catch (IOException ex) {
                ex.printStackTrace();
                break;
            }

            // 获取 Channel
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            // 迭代器
            Iterator<SelectionKey> iterator = readyKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        System.out.println("Accepted connection from " + client);
                        client.configureBlocking(false);
                        // client.configureBlocking(false);
                        // 向 selector 注册写事件和读事件
                        SelectionKey clientKey = client.register(
                                selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ
                        );
                        // 创建缓存区并分配大小
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        // 将信息附加到通道上
                        clientKey.attach(buffer);
                    }
                    if (key.isReadable()) {
                        System.out.println("log key is readable");
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        client.read(output);
                    }
                    if (key.isWritable()) {
                        System.out.println("log: key is writeable");
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        // flip方法将Buffer从写模式切换到读模式。调用flip()方法会将position设回0，
                        // 并将limit设置成之前position的值。
                        output.flip();
                        client.write(output);
                        // compact()方法将所有未读的数据拷贝到Buffer起始处。然后将position设到最后一个未读元素正后面。
                        // limit属性依然像clear()方法一样，设置成capacity。现在Buffer准备好写数据了，但是不会覆盖未读的数据。
                        output.compact();
                    }
                } catch (IOException ex) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException ignored) {}
                }
            }
        }
    }

}
