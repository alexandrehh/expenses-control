package br.com.minhas.contas.repositories.item;

import br.com.minhas.contas.repositories.common.RepositoryBase;
import br.com.minhas.contas.models.item.ItemModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends RepositoryBase<ItemModel> {

    /**
     * Busca uma lista de entidades {@link ItemModel} com as infos dos itens da categoria
     * @param categoryId Id da categoria
     * @return Uma lista de entidades {@link ItemModel} com as infos dos itens do mês
     */
    List<ItemModel> findItemModelsByCategoryId(String categoryId);
}
