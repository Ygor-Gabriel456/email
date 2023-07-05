package com.ms.email.consumers;

import com.ms.email.dtos.EmailDtos;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailServices;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailServices emailServices;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDtos emailDtos){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDtos, emailModel);
        emailServices.sendingEmail(emailModel);
        System.out.println("Email Status  " +  emailModel.getStatusEmail().toString());
    }
}
