package br.com.emmanuelneri.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderConsumer {

    @RabbitListener(queues = "OrderQueue")
    public void receive(@Payload String order) {

        log.info("Order: " + order);
    }

    @RabbitListener(queues = "FailOrderQueue")
    public void failReceive(@Payload String order) {

        log.info("Fail Order: " + order);
    }
}