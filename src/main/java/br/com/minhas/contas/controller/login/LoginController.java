package br.com.minhas.contas.controller.login;

import javax.validation.Valid;

import br.com.minhas.contas.dtos.login.LoginDto;
import br.com.minhas.contas.dtos.login.TokenDto;
import br.com.minhas.contas.services.login.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/auth/login")
    public ResponseEntity<TokenDto> login(@RequestBody @Valid LoginDto request) {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.login(request));
    }
}
