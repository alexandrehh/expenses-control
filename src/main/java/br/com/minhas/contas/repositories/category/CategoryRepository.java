package br.com.minhas.contas.repositories.category;

import br.com.minhas.contas.models.category.CategoryModel;
import br.com.minhas.contas.repositories.common.RepositoryBase;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends RepositoryBase<CategoryModel> {

    /**
     * Busca uma lista de entidade {@link CategoryModel} com as infos das categorias do mês
     * @param monthId Id do mês
     * @return Uma lista de entidade {@link CategoryModel} com as infos das categorias do mês
     */
    List<CategoryModel> findCategoryModelsByMonthId(String monthId);
}
