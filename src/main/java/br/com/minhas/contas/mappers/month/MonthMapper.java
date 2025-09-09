package br.com.minhas.contas.mappers.month;

import br.com.minhas.contas.dtos.category.CategoryDto;
import br.com.minhas.contas.dtos.item.ItemDto;
import br.com.minhas.contas.dtos.month.MonthDto;
import br.com.minhas.contas.dtos.month.SaveUpdateMonthDto;
import br.com.minhas.contas.models.month.MonthModel;

import java.util.List;

public interface MonthMapper {

    /**
     * Cria o DTO {@link MonthDto} a partir da entidade {@link MonthModel}
     * @param monthModel Entidade com as infos do mês
     * @return DTO {@link MonthDto} a partir da entidade {@link MonthModel}
     */
    MonthDto toMonthDto(MonthModel monthModel);

    /**
     * Cria a entidade {@link MonthModel} a partir da entidade {@link MonthDto}
     * @param monthDto DTO com as infos do mês
     * @return Entidade {@link MonthModel} a partir da entidade {@link MonthDto}
     */
    MonthModel toMonthModel(MonthDto monthDto);

    /**
     * Cria o DTO {@link SaveUpdateMonthDto} com as infos salvas ou atualizadas do mês, categoria e itens
     * @param monthDto DTO do mês
     * @param categoryDtos DTO das categorias
     * @param itemDtos DTO dos itens
     * @return DTO {@link SaveUpdateMonthDto} com as infos salvas ou atualizadas do mês, categoria e itens
     */
    SaveUpdateMonthDto toSaveUpdateMonthDto(MonthDto monthDto, List<CategoryDto> categoryDtos, List<ItemDto> itemDtos);
}
