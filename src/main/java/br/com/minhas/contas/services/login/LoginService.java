package br.com.minhas.contas.services.login;

import br.com.minhas.contas.dtos.login.LoginDto;
import br.com.minhas.contas.dtos.login.TokenDto;

public interface LoginService {

    TokenDto login(LoginDto request);
}
