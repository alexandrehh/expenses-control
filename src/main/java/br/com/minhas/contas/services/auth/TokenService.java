package br.com.minhas.contas.services.auth;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import br.com.minhas.contas.models.userauth.UserAuthEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class TokenService {

    private static final long EXPIRATION_TIME = 3000L;
    private static final String SECRET = "!KKBI]ChcZA+rc#";
    private static final String ID = "id";
    private static final String DEFAULT_UTC = "-03:00";

    public String getSubject(String token) {
        //FIXME tentar colocar a secret em um local mais seguro (variaveis de ambiente? application properties?)
        return JWT.require(Algorithm.HMAC256(SECRET))
                .build().verify(token).getSubject();
    }

    public String createToken(UserAuthEntity userAuthEntity) {
        return JWT.create()
                .withSubject(userAuthEntity.getEmail())
                .withClaim(ID, userAuthEntity.getId())
                .withExpiresAt(getTokenExpirationTime())
                .sign(Algorithm.HMAC256(SECRET));

    }

    Instant getTokenExpirationTime() {
        return LocalDateTime.now() //
                .plusSeconds(EXPIRATION_TIME) //
                .toInstant(ZoneOffset.of(DEFAULT_UTC));
    }
}
