package br.com.minhas.contas.services.login.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.minhas.contas.dtos.login.LoginDto;
import br.com.minhas.contas.dtos.login.TokenDto;
import br.com.minhas.contas.mappers.login.LoginMapper;
import br.com.minhas.contas.models.userauth.UserAuthEntity;
import br.com.minhas.contas.services.auth.TokenService;
import br.com.minhas.contas.services.login.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Override
    public TokenDto login(LoginDto request) {
        try {
            var token = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
            var authenticate = authenticationManager.authenticate(token);
            return loginMapper.toTokenDto(tokenService.createToken((UserAuthEntity) authenticate.getPrincipal()));
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
