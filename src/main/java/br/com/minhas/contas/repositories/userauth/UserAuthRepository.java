package br.com.minhas.contas.repositories.userauth;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.minhas.contas.models.userauth.UserAuthEntity;
import br.com.minhas.contas.repositories.common.RepositoryBase;

@Repository
public interface UserAuthRepository extends RepositoryBase<UserAuthEntity> {

    UserDetails findByEmail(String email);

    Optional<UserAuthEntity> findUserAuthEntityByEmail(String email);
}
