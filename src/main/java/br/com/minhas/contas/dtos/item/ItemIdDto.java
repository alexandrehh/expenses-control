package br.com.minhas.contas.dtos.item;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ItemIdDto {

    @NotBlank
    private String itemId;
}
