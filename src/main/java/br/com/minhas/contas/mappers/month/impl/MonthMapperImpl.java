package br.com.minhas.contas.mappers.month.impl;

import br.com.minhas.contas.mappers.month.MonthMapper;
import br.com.minhas.contas.dtos.category.CategoryDto;
import br.com.minhas.contas.dtos.item.ItemDto;
import br.com.minhas.contas.dtos.month.MonthDto;
import br.com.minhas.contas.dtos.month.SaveUpdateMonthDto;
import br.com.minhas.contas.models.month.MonthModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Component
public class MonthMapperImpl implements MonthMapper {
    @Override
    public MonthDto toMonthDto(MonthModel monthModel) {
        if (Objects.isNull(monthModel)) {
            return null;
        }

        var monthDto = new MonthDto();

        monthDto.setId(monthModel.getId());
        monthDto.setName(monthModel.getName());
        monthDto.setCreatedAt(monthModel.getCreatedAt());

        return monthDto;
    }

    @Override
    public MonthModel toMonthModel(MonthDto monthDto) {
        if (Objects.isNull(monthDto)) {
            return null;
        }

        var monthModel = new MonthModel();

        monthModel.setId(monthDto.getId());
        monthModel.setName(monthDto.getName());
        monthModel.setCreatedAt(LocalDateTime.now());

        return monthModel;
    }

    @Override
    public SaveUpdateMonthDto toSaveUpdateMonthDto(MonthDto monthDto, List<CategoryDto> categoryDtos, List<ItemDto> itemDtos) {
        var saveUpdateMonthDto = new SaveUpdateMonthDto();

        saveUpdateMonthDto.setMonth(monthDto);
        saveUpdateMonthDto.setCategories(categoryDtos);
        saveUpdateMonthDto.setItems(itemDtos);

        return saveUpdateMonthDto;
    }
}
