package com.sxli.hotheadlines;

import com.sxli.hotheadlines.producer.PageViewOutput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
        Message<String> message = MessageBuilder.withPayload("147:258").build();
        output.send(message);
    }

}
