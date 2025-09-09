package br.com.minhas.contas.services.userauth;

import br.com.minhas.contas.dtos.userauth.UserAuthDto;

public interface UserAuthService {

    /**
     * Salva o novo usuário
     * @param request - Dados do usuário
     */
    void saveUserAuth(UserAuthDto request);

    /**
     * Verifica se o usuário é válido
     * @param email - Email do usuário
     * @return - Retorna se o usuário é válido
     */
    Boolean isValidUserAuth(String email);

    /**
     * Retorna os dados do usuário
     * @param id - Id do usuário
     * @return - Retorna os dados do usuário
     */
    UserAuthDto getUserAuth(String id);

    /**
     * Envia um email para recuperação de senha
     * @param email - Email do usuário
     */
    void sendForgotPasswordEmail(String email);
}
