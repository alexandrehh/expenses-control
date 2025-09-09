package br.com.minhas.contas.mappers.category;

import br.com.minhas.contas.dtos.category.CategoryDto;
import br.com.minhas.contas.dtos.month.MonthDto;
import br.com.minhas.contas.models.category.CategoryModel;
import br.com.minhas.contas.models.month.MonthModel;

public interface CategoryMapper {

    /**
     * Cria a entidade {@link CategoryModel} a partir do DTO {@link CategoryDto}
     * @param categoryDto DTO com as infos da categoria
     * @param monthModel Entidade com as infos do mês
     * @return A entidade {@link CategoryModel} a partir do DTO {@link CategoryDto}
     */
    CategoryModel toCategoryModel(CategoryDto categoryDto, MonthModel monthModel);

    /**
     * Cria a DTO {@link CategoryDto} a partir do entidade {@link CategoryModel}
     * @param categoryModel Entidade com as infos da categoria
     * @param monthDto DTO com as infos do mês
     * @return DTO {@link CategoryDto} a partir do entidade {@link CategoryModel}
     */
    CategoryDto toCategoryDto(CategoryModel categoryModel, MonthDto monthDto);
}
