package br.com.minhas.contas.mappers.userauth.impl;

import br.com.minhas.contas.dtos.userauth.UserAuthDto;
import br.com.minhas.contas.mappers.userauth.UserAuthMapper;
import br.com.minhas.contas.models.userauth.UserAuthEntity;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Objects;

@Component
public class UserAuthMapperImpl implements UserAuthMapper {

    @Override
    public UserAuthEntity toEntity(UserAuthDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }

        return new UserAuthEntity(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getPassword(),
                Instant.now()
        );
    }

    @Override
    public UserAuthDto toDto(UserAuthEntity entity) {
        if (Objects.isNull(entity)) {
            return null;
        }

        return new UserAuthDto(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword()
        );
    }
}
