package br.com.minhas.contas.validations.item.impl;

import br.com.minhas.contas.dtos.item.ItemDto;
import br.com.minhas.contas.models.item.ItemModel;
import br.com.minhas.contas.validations.item.ItemValidation;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Component
public class ItemValidationImpl implements ItemValidation {
    @Override
    public void validateItemInfos(List<ItemDto> itemDtos) {
        if (CollectionUtils.isEmpty(itemDtos)) {
            throw new ServiceException("Ops! As informações dos itens não estão corretas, por favor verifique novamente ou entre em contato com o Administrador.");
        }
    }

    @Override
    public void validateItemModel(ItemModel itemModel) {
        if (Objects.isNull(itemModel)) {
            throw new ServiceException("Ops! O item não foi encontrado, por favor verifique novamente ou entre em contato com o Administrador.");
        }
    }
}
