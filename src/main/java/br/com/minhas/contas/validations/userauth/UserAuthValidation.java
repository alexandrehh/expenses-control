package br.com.minhas.contas.validations.userauth;

import br.com.minhas.contas.models.userauth.UserAuthEntity;

public interface UserAuthValidation {

    void validateUserAuth(UserAuthEntity userAuthEntity);
}
