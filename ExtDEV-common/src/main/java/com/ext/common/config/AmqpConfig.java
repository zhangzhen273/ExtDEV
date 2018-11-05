package com.ext.common.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Configuration
public class AmqpConfig {

    @Value("${spring.rabbitmq.host:}")
    private String host;
    @Value("${spring.rabbitmq.port:}")
    private int port;
    @Value("${spring.rabbitmq.username:}")
    private String username;
    @Value("${spring.rabbitmq.password:}")
    private String password;
    @Value("${spring.rabbitmq.virtualHost:}")
    private String virtualHost;

    private final static String  LOG_QUEUE_NAME = "EXT.QUEUE.LOG";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }


    @Bean
    RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    //创建队列
    @Bean
    public Queue queueService(RabbitAdmin rabbitAdmin) {
        Queue queue = new Queue(AmqpConfig.LOG_QUEUE_NAME);
        rabbitAdmin.declareQueue(queue);
        return queue;
    }


    //创建交换器
    @Bean
    DirectExchange exchange(RabbitAdmin rabbitAdmin) {
        DirectExchange exchange = new DirectExchange(AmqpConfig.LOG_QUEUE_NAME, false, false);
        rabbitAdmin.declareExchange(exchange);
        return exchange;
    }




    //对列绑定并关联到ROUTINGKEY
    @Bean
    Binding bindingExchangeMessages(Queue queueService, DirectExchange exchange,RabbitAdmin rabbitAdmin) {
        Binding binding = BindingBuilder.bind(queueService).to(exchange).with(AmqpConfig.LOG_QUEUE_NAME);
        rabbitAdmin.declareBinding(binding);
        return binding;//*表示一个词,#表示零个或多个词
    }

    @Bean
    public MappingJackson2MessageConverter jackson2Converter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        return converter;
    }

    /**
     * 生产者用
     *
     * @return
     */
    @Bean
    public RabbitMessagingTemplate rabbitMessagingTemplate(RabbitTemplate rabbitTemplate) {
        RabbitMessagingTemplate rabbitMessagingTemplate = new RabbitMessagingTemplate();
        rabbitMessagingTemplate.setMessageConverter(jackson2Converter());
        rabbitMessagingTemplate.setRabbitTemplate(rabbitTemplate);
        return rabbitMessagingTemplate;
    }

}
