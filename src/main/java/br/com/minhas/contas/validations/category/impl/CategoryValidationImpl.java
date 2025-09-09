package br.com.minhas.contas.validations.category.impl;

import br.com.minhas.contas.dtos.category.CategoryDto;
import br.com.minhas.contas.models.category.CategoryModel;
import br.com.minhas.contas.validations.category.CategoryValidation;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Component
public class CategoryValidationImpl implements CategoryValidation {
    @Override
    public void validateCategoryInfos(List<CategoryDto> categoryDtos) {
        if (CollectionUtils.isEmpty(categoryDtos)) {
            throw new ServiceException("Ops! As informações da categoria não estão corretas, por favor verifique novamente ou entre em contato com o Administrador.");
        }
    }

    @Override
    public void validateCategoryModel(CategoryModel categoryModel) {
        if (Objects.isNull(categoryModel)) {
            throw new ServiceException("Ops! A categoria não foi encontrada, por favor verifique novamente ou entre em contato com o Administrador.");
        }
    }
}
