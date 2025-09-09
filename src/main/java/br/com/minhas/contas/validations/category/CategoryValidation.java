package br.com.minhas.contas.validations.category;

import br.com.minhas.contas.dtos.category.CategoryDto;
import br.com.minhas.contas.models.category.CategoryModel;

import java.util.List;

public interface CategoryValidation {

    /**
     * Valida as infos das categorias de um mês
     * @param categoryDtos DTOs com as infos das categorias de um mês
     */
    void validateCategoryInfos(List<CategoryDto> categoryDtos);

    /**
     * Valida se a entidade {@link CategoryModel} é valida
     * @param categoryModel Entidade da categoria
     */
    void validateCategoryModel(CategoryModel categoryModel);
}
