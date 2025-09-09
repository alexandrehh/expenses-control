package br.com.minhas.contas.controller.email;

import br.com.minhas.contas.dtos.email.EmailDto;
import br.com.minhas.contas.services.rabbitmq.RabbitMQSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    private RabbitMQSenderService rabbitMQSenderService;

    @GetMapping("/api/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody @Valid EmailDto emailDto) {
        return ResponseEntity.status(HttpStatus.OK).body(rabbitMQSenderService.sendEmail(emailDto));
    }
}
