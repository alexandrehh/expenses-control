package br.com.minhas.contas.dtos.category;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryIdDto {

    @NotBlank
    private String categoryId;
}
