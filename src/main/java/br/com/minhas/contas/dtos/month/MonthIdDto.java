package br.com.minhas.contas.dtos.month;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MonthIdDto {

    @NotBlank
    private String monthId;
}
