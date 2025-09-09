package br.com.minhas.contas.validations.item;

import br.com.minhas.contas.dtos.item.ItemDto;
import br.com.minhas.contas.models.item.ItemModel;

import java.util.List;

public interface ItemValidation {

    /**
     * Valida as infos dos itens de uma categoria de um mês
     * @param itemDtos DTOs com as infos dos itens de uma categoria de um mês
     */
    void validateItemInfos(List<ItemDto> itemDtos);

    /**
     * Verifica se a entidade {@link ItemModel} é valida
     * @param itemModel Entidade do item
     */
    void validateItemModel(ItemModel itemModel);
}
