package com.ext.common.service.impl;

import com.ext.common.service.RabbitMessageService;
import com.ext.common.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RabbitMessageServiceImpl implements RabbitMessageService{

    private Logger log = LoggerFactory.getLogger(RabbitMessageServiceImpl.class);

    @Resource
    private RabbitTemplate rabbitTemplate;


    public void sendMsgByQuene(String queue,String context){
        log.info("mq host is :" + rabbitTemplate.getConnectionFactory().getHost());
        log.info("send to quene: "+queue+" message is:" + context);
        this.rabbitTemplate.convertAndSend(queue, queue, context);
        log.info("send to quene "+queue+" message sucess");
    }




}
