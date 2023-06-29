//package com.aravindcz.listingservice.configuration;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQQueueConfiguration {
//
//    @Autowired
//    private RabbitMQHostConfiguration rabbitMQHostConfiguration;
//
//    @Bean
//    @Qualifier("createQueue")
//    public Queue getCreateQueue() {
//        return new Queue(rabbitMQHostConfiguration.getCreateQueue(), true);
//    }
//
//
//    @Bean
//    @Qualifier("updateQueue")
//    public Queue getUpdateQueue() {
//        return new Queue(rabbitMQHostConfiguration.getUpdateQueue(), true);
//    }
//
//    @Bean
//    @Qualifier("deleteQueue")
//    public Queue getDeleteQueue() {
//        return new Queue(rabbitMQHostConfiguration.getDeleteQueue(), true);
//    }
//
//    @Bean
//    @Qualifier("directExchange")
//    public DirectExchange getDirectExchange() {
//        return new DirectExchange(rabbitMQHostConfiguration.getDirectExchange());
//    }
//
//    @Bean
//    @Qualifier("createBinding")
//    Binding getCreateBinding(@Qualifier("createQueue") Queue queue, DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(rabbitMQHostConfiguration.getCreateQueue());
//    }
//
//    @Bean
//    @Qualifier("updateBinding")
//    Binding getUpdateBinding(@Qualifier("updateQueue") Queue queue, DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(rabbitMQHostConfiguration.getUpdateQueue());
//    }
//
//    @Bean
//    @Qualifier("deleteBinding")
//    Binding getDeleteBinding(@Qualifier("deleteQueue") Queue queue, DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(rabbitMQHostConfiguration.getDeleteQueue());
//    }
//
//
//
//}
