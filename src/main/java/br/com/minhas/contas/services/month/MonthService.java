package br.com.minhas.contas.services.month;

import br.com.minhas.contas.dtos.month.MonthDto;
import br.com.minhas.contas.dtos.month.SaveUpdateMonthDto;

import java.util.List;

public interface MonthService {

    /**
     * Salva e atualiza as informações do mês
     * @param saveUpdateMonthDto DTO com as infos do mês
     * @return DTO {@link SaveUpdateMonthDto} com as infos salvas
     */
    SaveUpdateMonthDto saveUpdateMonth(SaveUpdateMonthDto saveUpdateMonthDto);

    /**
     * Busca um mês
     * @param monthId Id do mês
     * @return DTO {@link MonthDto} com as infos do mês
     */
    MonthDto getMonth(String monthId);

    /**
     * Busca todos os meses
     * @return Uma lista de DTOs {@link MonthDto} com as infos dos meses
     */
    List<MonthDto> getMonths();

    /**
     * Delete um mês
     * @param monthId Id do mês
     */
    void deleteMonth(String monthId);
}
