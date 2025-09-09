package br.com.minhas.contas.services.rabbitmq;

import br.com.minhas.contas.dtos.email.EmailDto;

public interface RabbitMQSenderService {

    /**
     * Envio de e-mail
     * @param emailDto Dto com as infos do e-mail
     * @return Uma mensagem de sucesso ou falha
     */
    String sendEmail(EmailDto emailDto);
}
