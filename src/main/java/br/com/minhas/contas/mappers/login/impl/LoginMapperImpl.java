package br.com.minhas.contas.mappers.login.impl;

import org.springframework.stereotype.Component;

import br.com.minhas.contas.dtos.login.TokenDto;
import br.com.minhas.contas.mappers.login.LoginMapper;

@Component
public class LoginMapperImpl implements LoginMapper {

    @Override
    public TokenDto toTokenDto(String token) {
        return new TokenDto(token);
    }
}
