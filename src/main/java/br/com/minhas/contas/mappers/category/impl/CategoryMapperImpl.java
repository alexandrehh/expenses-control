package br.com.minhas.contas.mappers.category.impl;

import br.com.minhas.contas.dtos.category.CategoryDto;
import br.com.minhas.contas.dtos.month.MonthDto;
import br.com.minhas.contas.mappers.category.CategoryMapper;
import br.com.minhas.contas.models.category.CategoryModel;
import br.com.minhas.contas.models.month.MonthModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryModel toCategoryModel(CategoryDto categoryDto, MonthModel monthModel) {
        if (Objects.isNull(categoryDto)) {
            return null;
        }

        var categoryModel = new CategoryModel();

        categoryModel.setId(categoryDto.getId());
        categoryModel.setName(categoryDto.getName());
        categoryModel.setMonth(monthModel);
        categoryModel.setCreatedAt(LocalDateTime.now());

        return categoryModel;
    }

    @Override
    public CategoryDto toCategoryDto(CategoryModel categoryModel, MonthDto monthDto) {
        if (Objects.isNull(categoryModel)) {
            return null;
        }

        var categoryDto = new CategoryDto();

        categoryDto.setId(categoryModel.getId());
        categoryDto.setName(categoryModel.getName());
        categoryDto.setMonth(monthDto);
        categoryDto.setCreatedAt(categoryModel.getCreatedAt());

        return categoryDto;
    }
}
