package com.example.springcloud.service.impl;

import com.example.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/5/20 下午3:50
 */
@Slf4j
// 定义消息的推送管道
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        // 发送
        output.send(MessageBuilder.withPayload(serial)
                .build());
        log.info("----> serial: " + serial);
        return null;
    }

}
