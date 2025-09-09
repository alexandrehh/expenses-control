package br.com.minhas.contas.services.item;

import br.com.minhas.contas.dtos.item.ItemDto;
import br.com.minhas.contas.models.category.CategoryModel;

import java.util.List;

public interface ItemService {

    /**
     * Salva as infos dos itens de uma categoria de um mês
     * @param itemDtos DTOs com as infos dos itens
     * @param categoryModels Entidades das categorias
     * @return Uma lista de DTOs {@link ItemDto} com as infos salvas
     */
    List<ItemDto> saveUpdateItems(List<ItemDto> itemDtos, List<CategoryModel> categoryModels);

    /**
     * Busca uma item
     * @param itemId Id do item
     * @return DTO {@link ItemDto} com as infos do item
     */
    ItemDto getItem(String itemId);

    /**
     * Uma lista de items
     * @return Uma lista de {@link ItemDto} com as infos dos itens
     */
    List<ItemDto> getItems();

    /**
     * Busca os items a partir da categoria
     * @param categoryId Id da categoria
     * @return Uma lista de {@link ItemDto} com as infos dos itens
     */
    List<ItemDto> getItemsByCategoryId(String categoryId);
}
