package br.com.minhas.contas.mappers.item;

import br.com.minhas.contas.dtos.category.CategoryDto;
import br.com.minhas.contas.dtos.item.ItemDto;
import br.com.minhas.contas.models.category.CategoryModel;
import br.com.minhas.contas.models.item.ItemModel;

public interface ItemMapper {

    /**
     * Cria a entidade {@link ItemModel} a partir do DTO {@link ItemDto}
     * @param itemDto DTO com as infos do item
     * @param categoryModel Entidade da categoria
     * @return Entidade {@link ItemModel} a partir do DTO {@link ItemDto}
     */
    ItemModel toItemModel(ItemDto itemDto, CategoryModel categoryModel);

    /**
     * Cria o DTO {@link ItemDto} a partir da entidade {@link ItemModel}
     * @param itemModel Entidade com as infos do item
     * @param categoryDto DTO com as infos da categoria
     * @return DTO {@link ItemDto} a partir da entidade {@link ItemModel}
     */
    ItemDto toItemDto(ItemModel itemModel, CategoryDto categoryDto);
}
