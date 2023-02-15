package com.leonds.nio.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Leon
 */
public class FileChannelTest {
    public static void main(String[] args) {
        FileChannelTest fileChannelTest = new FileChannelTest();
//        fileChannelTest.testWrite();
//        fileChannelTest.testRead();
        fileChannelTest.testTransfer();

    }

    public void testRead() {
        try {
            // 1. 创建FileChannel
            RandomAccessFile file = new RandomAccessFile("/Users/leon/project/javatrain/src/main/java/com/leonds/basic/nio/channel/b.txt", "r");
            FileChannel channel = file.getChannel();

            // 2. 创建buffer
            ByteBuffer buffer = ByteBuffer.allocate(20);

            // 3. 读取数据到buffer中
            while (channel.read(buffer) != -1) {
                buffer.flip();
                buffer.clear();
            }

            channel.close();
            file.close();

//            String content = new String(buffer.array());
            Charset charset = StandardCharsets.UTF_8;
            String content = charset.decode(buffer).toString();
            System.out.println(content);
            System.out.println("结束了");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testWrite() {
        try {
            // 1. 创建FileChannel
            RandomAccessFile file = new RandomAccessFile("/Users/leon/project/javatrain/src/main/java/com/leonds/basic/nio/channel/b.txt", "rw");
            FileChannel channel = file.getChannel();

            // 2. 创建buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // 3. 写入
            String text = "这是一段文本";

            buffer.clear();
            buffer.put(text.getBytes(StandardCharsets.UTF_8));
            buffer.flip();

            while (buffer.hasRemaining()) {
                channel.write(buffer);
            }

            channel.close();
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * transferTo 和 transferFrom 可以实现两个通道之间的数据传输
     */
    public void testTransfer() {
        try {
            // 1. 创建FileChannel
            RandomAccessFile file = new RandomAccessFile("/Users/leon/project/javatrain/src/main/java/com/leonds/basic/nio/channel/b.txt", "rw");
            FileChannel channel = file.getChannel();

            RandomAccessFile file2 = new RandomAccessFile("/Users/leon/project/javatrain/src/main/java/com/leonds/basic/nio/channel/b1.txt", "rw");
            FileChannel channel2 = file2.getChannel();

            channel2.transferFrom(channel, 0, channel.size());

//            channel.transferTo(0,channel.size(),channel2);

            file.close();
            file2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
