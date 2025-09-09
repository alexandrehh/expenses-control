package br.com.minhas.contas.validations.month;

import br.com.minhas.contas.dtos.month.MonthDto;
import br.com.minhas.contas.models.month.MonthModel;

public interface MonthValidation {

    /**
     * Valida se as infos do DTO {@link MonthDto} são validas
     * @param monthDto DTO com as infos do mês
     */
    void validateMonthInfos(MonthDto monthDto);

    /**
     * Verifica a entidade {@link MonthModel} com as infos do mês
     * @param monthModel Entidade do mês
     */
    void validateMonthModel(MonthModel monthModel);
}
