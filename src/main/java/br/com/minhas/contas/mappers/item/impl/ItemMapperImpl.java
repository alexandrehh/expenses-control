package br.com.minhas.contas.mappers.item.impl;

import br.com.minhas.contas.dtos.category.CategoryDto;
import br.com.minhas.contas.dtos.item.ItemDto;
import br.com.minhas.contas.mappers.item.ItemMapper;
import br.com.minhas.contas.models.category.CategoryModel;
import br.com.minhas.contas.models.item.ItemModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class ItemMapperImpl implements ItemMapper {
    @Override
    public ItemModel toItemModel(ItemDto itemDto, CategoryModel categoryModel) {
        if (Objects.isNull(itemDto)) {
            return null;
        }

        var itemModel = new ItemModel();

        itemModel.setId(itemDto.getId());
        itemModel.setName(itemDto.getName());
        itemModel.setValue(itemDto.getValue());
        itemModel.setCategory(categoryModel);
        itemModel.setCreatedAt(LocalDateTime.now());

        return itemModel;
    }

    @Override
    public ItemDto toItemDto(ItemModel itemModel, CategoryDto categoryDto) {
        if (Objects.isNull(itemModel)) {
            return null;
        }

        var itemDto = new ItemDto();

        itemDto.setId(itemModel.getId());
        itemDto.setName(itemModel.getName());
        itemDto.setValue(itemModel.getValue());
        itemDto.setCategory(categoryDto);
        itemDto.setCreatedAt(itemModel.getCreatedAt());

        return itemDto;
    }
}
