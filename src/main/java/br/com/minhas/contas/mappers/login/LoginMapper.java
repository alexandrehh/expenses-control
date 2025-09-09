package br.com.minhas.contas.mappers.login;

import br.com.minhas.contas.dtos.login.TokenDto;

public interface LoginMapper {

    TokenDto toTokenDto(String token);
}
