package br.com.minhas.contas.services.rabbitmq.impl;

import br.com.minhas.contas.dtos.email.EmailDto;
import br.com.minhas.contas.services.rabbitmq.RabbitMQSenderService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSenderServiceImpl implements RabbitMQSenderService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    @Override
    public String sendEmail(EmailDto emailDto) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingkey, emailDto);
            return "deu boa";
        } catch (ServiceException e) {
            throw new ServiceException("deu ruim", e);
        }
    }
}
