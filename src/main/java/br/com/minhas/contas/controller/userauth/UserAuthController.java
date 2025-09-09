package br.com.minhas.contas.controller.userauth;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.minhas.contas.dtos.userauth.UserAuthEmailDto;
import br.com.minhas.contas.dtos.userauth.UserAuthDto;
import br.com.minhas.contas.services.userauth.UserAuthService;

@Validated
@RestController
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/auth/saveUserAuth")
    public void saveUserAuth(@RequestBody @Valid UserAuthDto request) {
        userAuthService.saveUserAuth(request);
    }

    @GetMapping("/auth/isValidUserAuth/{email}")
    public ResponseEntity<Boolean> isValidUserAuth(@PathVariable @NotBlank @Email String email) {
        return ResponseEntity.status(HttpStatus.OK).body(userAuthService.isValidUserAuth(email));
    }

    @GetMapping("/auth/userAuth/{id}")
    public ResponseEntity<UserAuthDto> getUserAuth(@PathVariable @NotBlank String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userAuthService.getUserAuth(id));
    }

    @PostMapping("/auth/sendForgotPasswordEmail")
    public void sendForgotPasswordEmail(@RequestBody @Valid UserAuthEmailDto request) {
        userAuthService.sendForgotPasswordEmail(request.getEmail());
    }
}
