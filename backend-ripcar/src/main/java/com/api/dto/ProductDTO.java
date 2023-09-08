package com.api.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {


    private Long id;

    @NotEmpty
    @Size(min = 4, message = "el tipo deberia tener mas de 4 caracteres")
    private String type;

    @NotEmpty
    @Size(min = 10, message = "La descripción deberia tener mas de 10 caracteres")
    private String description;

    @NotNull
    private int amount;
    @NotNull
    private double price;

}
