package br.com.minhas.contas.validations.month.impl;

import br.com.minhas.contas.dtos.month.MonthDto;
import br.com.minhas.contas.models.month.MonthModel;
import br.com.minhas.contas.validations.month.MonthValidation;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MonthValidationImpl implements MonthValidation {

    @Override
    public void validateMonthInfos(MonthDto monthDto) {
        if (Objects.isNull(monthDto)) {
            throw new ServiceException("Ops! As informações do mês não estão corretas, por favor verifique novamente ou entre em contato com o Administrador.");
        }
    }

    @Override
    public void validateMonthModel(MonthModel monthModel) {
        if (Objects.isNull(monthModel)) {
            throw new ServiceException("Ops! As informações do mês não foram encontradas, por favor verifique novamente ou entre em contato com o Administrador.");
        }
    }
}
