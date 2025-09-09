package br.com.minhas.contas.dtos.month;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Data
public class MonthDto {

    private String id;
    @NotBlank
    private String name;
    private LocalDateTime createdAt;
}
