package br.com.minhas.contas.mappers.email.impl;

import org.springframework.stereotype.Component;

import br.com.minhas.contas.dtos.email.EmailDto;
import br.com.minhas.contas.mappers.email.EmailMapper;

@Component
public class EmailMapperImpl implements EmailMapper {

    @Override
    public EmailDto toDto(String ownerRef, String emailFrom, String emailTo, String subject, String text) {
        return new EmailDto(ownerRef, emailFrom, emailTo, subject, text);
    }
}
