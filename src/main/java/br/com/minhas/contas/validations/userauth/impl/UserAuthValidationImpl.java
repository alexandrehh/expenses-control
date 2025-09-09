package br.com.minhas.contas.validations.userauth.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Objects;

import br.com.minhas.contas.models.userauth.UserAuthEntity;
import br.com.minhas.contas.validations.userauth.UserAuthValidation;

@Component
public class UserAuthValidationImpl implements UserAuthValidation {

    @Override
    public void validateUserAuth(UserAuthEntity userAuthEntity) {
        if (Objects.isNull(userAuthEntity)) {
            throw new ServiceException("Não foi possível encontrar o usuário");
        }
    }
}
