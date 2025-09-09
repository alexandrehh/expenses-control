package br.com.minhas.contas.infra;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.minhas.contas.repositories.userauth.UserAuthRepository;
import br.com.minhas.contas.services.auth.TokenService;

@Component
public class FilterToken extends OncePerRequestFilter {

    private final static String AUTHORIZATION = "Authorization";
    private final static String BEARER = "Bearer ";

    @Autowired
    private TokenService loginService;
    @Autowired
    private UserAuthRepository userAuthRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, //
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        var authHeader = request.getHeader(AUTHORIZATION);

        if (Objects.nonNull(authHeader)) {
            var token = authHeader.replace(BEARER, "");
            var email = loginService.getSubject(token);
            var userAuth = userAuthRepository.findByEmail(email);
            var authenticationToken = new UsernamePasswordAuthenticationToken(userAuth, null, userAuth.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
    }
}
