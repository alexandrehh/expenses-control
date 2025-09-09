package br.com.minhas.contas.dtos.item;

import br.com.minhas.contas.dtos.category.CategoryDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ItemDto {

    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private BigDecimal value;
    @NotNull
    private CategoryDto category;
    private LocalDateTime createdAt;
}
