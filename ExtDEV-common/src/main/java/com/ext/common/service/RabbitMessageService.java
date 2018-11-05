package com.ext.common.service;

public interface RabbitMessageService {

    void sendMsgByQuene(String queue,String context);
}
