package br.com.minhas.contas.services.userauth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.minhas.contas.dtos.userauth.UserAuthDto;
import br.com.minhas.contas.mappers.email.EmailMapper;
import br.com.minhas.contas.mappers.userauth.UserAuthMapper;
import br.com.minhas.contas.repositories.userauth.UserAuthRepository;
import br.com.minhas.contas.services.rabbitmq.RabbitMQSenderService;
import br.com.minhas.contas.services.userauth.UserAuthService;
import br.com.minhas.contas.validations.userauth.UserAuthValidation;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    private static final int PASSWORD_MIN_LENGTH = 0;
    private static final int PASSWORD_MAX_LENGTH = 8;
    private static final String PASSWORD_ALIAS = "{0}";
    private static final String OWNER_REF = "Sistema de Despesas";
    private static final String EMAIL_FROM = "alexandrehh@gmail.com";
    private static final String EMAIL_SUBJECT = "Recuperação de senha";
    private static final String EMAIL_TEXT = "Olá, você solicitou a recuperação de senha. Sua nova senha é: " + PASSWORD_ALIAS + ". Por favor, troque sua senha assim que possível.";
    private static final String FIX_PASSWORD = "12345678";

    @Autowired
    private UserAuthRepository userAuthRepository;
    @Autowired
    private UserAuthMapper userAuthMapper;
    @Autowired
    private BCryptPasswordEncoder bcrypt;
    @Autowired
    private UserAuthValidation userAuthValidation;
    @Autowired
    private EmailMapper emailMapper;
    @Autowired
    private RabbitMQSenderService rabbitMQSenderService;

    @Override
    public void saveUserAuth(UserAuthDto request) {
        var userAuth = userAuthMapper.toEntity(request);
        userAuthValidation.validateUserAuth(userAuth);
        userAuth.setPassword(getPasswordEncoder(userAuth.getPassword()));
        userAuthRepository.save(userAuth);
    }

    @Override
    public Boolean isValidUserAuth(String email) {
        return userAuthRepository.findUserAuthEntityByEmail(email).isPresent();
    }

    @Override
    public UserAuthDto getUserAuth(String id) {
        return userAuthMapper.toDto(userAuthRepository.findById(id).orElseThrow());
    }

    @Override
    public void sendForgotPasswordEmail(String email) {
        var newPassword = getPasswordEncoder(FIX_PASSWORD).substring(PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH);
        updateUserAuth(email, getPasswordEncoder(newPassword));
        var emailDto = emailMapper.toDto(OWNER_REF, EMAIL_FROM, email, EMAIL_SUBJECT, EMAIL_TEXT.replace(PASSWORD_ALIAS, newPassword));
        rabbitMQSenderService.sendEmail(emailDto);
    }

    void updateUserAuth(String email, String passwordEncoder) {
        var userAuth = userAuthRepository.findUserAuthEntityByEmail(email).orElseThrow();
        userAuth.setPassword(passwordEncoder);
        userAuthRepository.save(userAuth);
    }

    String getPasswordEncoder(String password) {
        return bcrypt.encode(password);
    }
}
