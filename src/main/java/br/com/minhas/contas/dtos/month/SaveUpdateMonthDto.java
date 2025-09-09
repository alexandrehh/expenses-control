package br.com.minhas.contas.dtos.month;

import br.com.minhas.contas.dtos.category.CategoryDto;
import br.com.minhas.contas.dtos.item.ItemDto;
import lombok.Data;

import java.util.List;

@Data
public class SaveUpdateMonthDto {

    private MonthDto month;
    private List<CategoryDto> categories;
    private List<ItemDto> items;
}
