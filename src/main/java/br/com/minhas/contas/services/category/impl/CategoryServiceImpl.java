package br.com.minhas.contas.services.category.impl;


import br.com.minhas.contas.dtos.category.CategoryDto;
import br.com.minhas.contas.mappers.category.CategoryMapper;
import br.com.minhas.contas.mappers.month.MonthMapper;
import br.com.minhas.contas.models.category.CategoryModel;
import br.com.minhas.contas.models.month.MonthModel;
import br.com.minhas.contas.repositories.category.CategoryRepository;
import br.com.minhas.contas.services.category.CategoryService;
import br.com.minhas.contas.validations.category.CategoryValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryValidation categoryValidation;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private MonthMapper monthMapper;

    @Override
    public List<CategoryDto> saveUpdateCategories(List<CategoryDto> categoryDtos, MonthModel monthModel) {
        categoryValidation.validateCategoryInfos(categoryDtos);
        var categoryModels = getCategoryModels(categoryDtos, monthModel);
        var newCategoryModels = categoryRepository.saveAll(categoryModels);
        return getCategoryDtos(newCategoryModels);
    }

    @Override
    public CategoryDto getCategory(String categoryId) {
        return getCategoryDto(getCategoryModel(categoryId));
    }

    @Override
    public List<CategoryDto> getCategories() {
        var categoryModels = categoryRepository.findAll();
        return categoryModels.stream().map(this::getCategoryDto).collect(Collectors.toList());
    }

    @Override
    public List<CategoryDto> getCategoriesByMonthId(String monthId) {
        var categoryModels = categoryRepository.findCategoryModelsByMonthId(monthId);
        return categoryModels.stream().map(this::getCategoryDto).collect(Collectors.toList());
    }

    @Override
    public CategoryModel getCategoryModel(String categoryId) {
        var categoryModel = categoryRepository.findById(categoryId).orElse(null);
        categoryValidation.validateCategoryModel(categoryModel);
        return categoryModel;
    }

    @Override
    public List<CategoryModel> getCategoryModelsByMonthId(String monthId) {
        return categoryRepository.findCategoryModelsByMonthId(monthId);
    }

    /**
     * Busca uma lista de entidades {@link CategoryModel} que representam as categorias de um mês
     * @param categoryDtos Lista de DTOs com as infos das categorias de um mês
     * @param monthModel Entidade do mês
     * @return Uma lista de entidades {@link CategoryModel} que representam as categorias de um mês
     */
    List<CategoryModel> getCategoryModels(List<CategoryDto> categoryDtos, MonthModel monthModel) {
       return categoryDtos.stream().filter(Objects::nonNull)
               .map(categoryDto -> categoryMapper.toCategoryModel(categoryDto, monthModel))
               .collect(Collectors.toList());
    }

    /**
     * Busca uma lista de DTOs {@link CategoryDto} que representam as infos salvas das categorias
     * a partir das entidades {@link CategoryModel} salvas
     * @param categoryModels Entidades das categorias
     * @return Uma lista de DTOs {@link CategoryDto} com as infos salvas
     */
    List<CategoryDto> getCategoryDtos(List<CategoryModel> categoryModels) {
        return categoryModels.stream().filter(Objects::nonNull).map(this::getCategoryDto).collect(Collectors.toList());
    }

    /**
     * Cria um novo DTO {@link CategoryDto} com as infos da categoria
     * @param categoryModel Entidade da categoria
     * @return DTO {@link CategoryDto} com as infos da categoria
     */
    CategoryDto getCategoryDto(CategoryModel categoryModel) {
        var monthModel = Objects.nonNull(categoryModel) && Objects.nonNull(categoryModel.getMonth()) ? categoryModel.getMonth() : null;
        return categoryMapper.toCategoryDto(categoryModel, monthMapper.toMonthDto(monthModel));
    }
}
