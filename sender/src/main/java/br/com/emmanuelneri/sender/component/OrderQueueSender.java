package br.com.emmanuelneri.sender.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(String order) {

        System.out.println(this.queue.getName());

        if(order.contains("Correto")){

            rabbitTemplate.convertAndSend("OrderQueue", order);
        }else{

            rabbitTemplate.convertAndSend("FailOrderQueue", order);
        }
    }
}