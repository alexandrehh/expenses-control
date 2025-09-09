package br.com.minhas.contas.mappers.email;

import br.com.minhas.contas.dtos.email.EmailDto;

public interface EmailMapper {

    EmailDto toDto(String ownerRef, String emailFrom, String emailTo, String subject, String text);
}
