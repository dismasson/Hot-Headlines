package com.sxli.hotheadlines;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotheadlinesApplication.class)
public class HotheadlinesApplicationTests {

    @Resource(name = "stream.pageview")
    private MessageChannel output;

    /**
     * 模拟用户点击浏览某个头条
     */
    @Test
    public void userReaderNewsTest() {
        // 模拟用户ID：147浏览了头条ID：258
        Message<String> message = MessageBuilder.withPayload("147:258").build();
        output.send(message);
    }

    /**
     * 此处生成100000条热点新闻
     * 模拟10000000个用户，每个随机浏览10次以内的新闻，允许一条新闻阅读多次，但是算一次点击量
     * 计算过程中可以观察 /news/hot ，这里可以看到当前时间热点新闻内容（新闻ID）
     */
    @Test
    public void bigUserReaderNewsTest() {
        Random ra = new Random();
        // 循环模拟用户
        for (int userId = 0; userId < 10000000; userId++) {
            int readerMax = ra.nextInt(10);
            for (int readerCount = 0; readerCount < readerMax; readerCount++) {
                int newsId = ra.nextInt(100000);
                // 用户ID:新闻ID
                String msg = new StringBuilder(userId).append(":").append(newsId).toString();
                Message<String> message = MessageBuilder.withPayload(msg).build();
                output.send(message);
            }
        }
    }
}
