package br.com.minhas.contas.dtos.category;

import br.com.minhas.contas.dtos.month.MonthDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class CategoryDto {

    private String id;
    @NotBlank
    private String name;
    private MonthDto month;
    private LocalDateTime createdAt;
}
