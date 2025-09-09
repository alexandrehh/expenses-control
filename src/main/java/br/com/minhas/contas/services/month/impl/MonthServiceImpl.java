package br.com.minhas.contas.services.month.impl;

import br.com.minhas.contas.dtos.month.MonthDto;
import br.com.minhas.contas.dtos.month.SaveUpdateMonthDto;
import br.com.minhas.contas.mappers.month.MonthMapper;
import br.com.minhas.contas.models.month.MonthModel;
import br.com.minhas.contas.repositories.month.MonthRepository;
import br.com.minhas.contas.services.category.CategoryService;
import br.com.minhas.contas.services.item.ItemService;
import br.com.minhas.contas.services.month.MonthService;
import br.com.minhas.contas.validations.month.MonthValidation;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MonthServiceImpl implements MonthService {

    @Autowired
    private MonthRepository monthRepository;
    @Autowired
    private MonthValidation monthValidation;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private MonthMapper monthMapper;

    @Override
    public SaveUpdateMonthDto saveUpdateMonth(SaveUpdateMonthDto saveUpdateMonthDto) {
        if (Objects.isNull(saveUpdateMonthDto)) {
            return new SaveUpdateMonthDto();
        }

        try {
            monthValidation.validateMonthInfos(saveUpdateMonthDto.getMonth());

            var monthDto = saveUpdateMonth(saveUpdateMonthDto.getMonth());
            var categoryDto = categoryService.saveUpdateCategories(saveUpdateMonthDto.getCategories(), getMonthModel(monthDto.getId()));
            var itemDtos = itemService.saveUpdateItems(saveUpdateMonthDto.getItems(), categoryService.getCategoryModelsByMonthId(monthDto.getId()));

            return monthMapper.toSaveUpdateMonthDto(monthDto, categoryDto, itemDtos);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public MonthDto getMonth(String monthId) {
        var monthModel = getMonthModel(monthId);
        return monthMapper.toMonthDto(monthModel);
    }

    @Override
    public List<MonthDto> getMonths() {
        var monthModels = monthRepository.findAll();
        return monthModels.stream().map(monthModel -> monthMapper.toMonthDto(monthModel)).collect(Collectors.toList());
    }

    @Override
    public void deleteMonth(String monthId) {
        monthRepository.deleteById(monthId);
    }

    /**
     * Salva a entidade {@link MonthModel} a partir das infos do DTO {@link MonthDto}
     * @param monthDto DTO com as infos do mês
     * @return DTO {@link MonthDto} com as infos salvas do mês
     */
    MonthDto saveUpdateMonth(MonthDto monthDto) {
        var monthModel = monthMapper.toMonthModel(monthDto);
        var newMonthModel = monthRepository.save(monthModel);
        return monthMapper.toMonthDto(newMonthModel);
    }

    /**
     * Busca a entidade {@link MonthModel} que representa as infos do mês
     * @param monthId Id do mês
     * @return A entidade {@link MonthModel} que representa as infos do mês
     */
    MonthModel getMonthModel(String monthId) {
        var monthModel = monthRepository.findById(monthId).orElse(null);
        monthValidation.validateMonthModel(monthModel);
        return monthModel;
    }
}
