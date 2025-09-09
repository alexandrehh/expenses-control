package br.com.minhas.contas.mappers.userauth;

import br.com.minhas.contas.dtos.userauth.UserAuthDto;
import br.com.minhas.contas.models.userauth.UserAuthEntity;

public interface UserAuthMapper {

    UserAuthEntity toEntity(UserAuthDto dto);

    UserAuthDto toDto(UserAuthEntity entity);
}
