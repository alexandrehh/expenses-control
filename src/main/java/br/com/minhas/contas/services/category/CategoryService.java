package br.com.minhas.contas.services.category;

import br.com.minhas.contas.dtos.category.CategoryDto;
import br.com.minhas.contas.models.category.CategoryModel;
import br.com.minhas.contas.models.month.MonthModel;

import java.util.List;

public interface CategoryService {

    /**
     * Salva as categorias do mês
     * @param categoryDtos DTOs com as infos das categorias do mês
     * @param monthModel Entidade do mês
     * @return Lista de DTOs {@link CategoryDto} com as infos das categorias do mês
     */
    List<CategoryDto> saveUpdateCategories(List<CategoryDto> categoryDtos, MonthModel monthModel);

    /**
     * Busca uma categoria
     * @param categoryId Id da categoria
     * @return DTO {@link CategoryDto} com as infos da categoria
     */
    CategoryDto getCategory(String categoryId);

    /**
     * Uma lista de categorias
     * @return Uma lista de DTOs {@link CategoryDto} com as infos das categorias
     */
    List<CategoryDto> getCategories();

    /**
     * Busca as categorias a partir do mês
     * @param monthId Id do mês
     * @return Uma lista de DTOs {@link CategoryDto} com as infos das categorias
     */
    List<CategoryDto> getCategoriesByMonthId(String monthId);

    /**
     * Busca uma categoria
     * @param categoryId Id da categoria
     * @return A entidade {@link CategoryModel} com as infos da categoria
     */
    CategoryModel getCategoryModel(String categoryId);

    /**
     * Busca as entidades {@link CategoryModel} com as infos das categorias baseadas no mês
     * @param monthId Id do mês
     * @return As entidades {@link CategoryModel} com as infos das categorias baseadas no mês
     */
    List<CategoryModel> getCategoryModelsByMonthId(String monthId);
}
