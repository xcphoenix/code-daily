package xuanc;

import java.nio.CharBuffer;

/**
 * ClassName    Chapter15-BufferTest
 * Description  Buffer 常规操作
 *
 * @author      xuanc
 * @date        19-5-7 下午4:06
 * @version     1.0
 */ 
public class BufferTest {

    public static void main(String[] args) {
        // 创建 Buffer
        CharBuffer buff = CharBuffer.allocate(8);
        System.out.println("capacity: " + buff.capacity());
        System.out.println("limit: " + buff.limit());
        System.out.println("position: " + buff.position());

        // 放入元素
        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println("加入第三个元素后, position = " + buff.position());

        // 调用 flip() 方法
        buff.flip();
        System.out.println("执行 flip() 方法后, limit = " + buff.limit());
        System.out.println("position = " + buff.position());
        // 取出第一个元素
        System.out.println("第一个元素(position = 0): " + buff.get());
        System.out.println("取出第一个元素后，position = " + buff.position());

        // 调用 clear() 方法
        buff.clear();
        System.out.println("执行 clear() 后，limit = " + buff.limit());
        System.out.println("执行 clear() 后，position = " + buff.position());
        System.out.println("执行 clear() 后，缓冲区内容并没有清除：" + "第三个元素为：" + buff.get(2));
        System.out.println("执行绝对路径读取后，position = " + buff.position());
    }

}
