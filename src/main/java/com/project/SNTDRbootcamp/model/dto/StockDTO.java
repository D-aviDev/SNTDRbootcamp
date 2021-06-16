package com.project.SNTDRbootcamp.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class StockDTO {

// Não dá pra usar o @NotNull, pois no start essa variável é nula
    private Long id;                        // Tipo LONG(more actions) action's id no banco de dados

    @NotNull                                // Impede que a variável name seja nulo na execução da aplicação
    private String name;                    // Tipo STRING action's name no banco de dados

    @NotNull
    @DecimalMin(value = "0.00")             // Valor mínimo
    @Digits(integer = 6, fraction = 2)      // Máximo de digitos
    private Double price;                   // Tipo DOUBLE action's price

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")    //modifica o formato da data para o brBR 
    private LocalDate date;                 // Tipo LocalDate action's date

    @NotNull
    @DecimalMin(value = "0.00")             // Valor mínimo
    @Digits(integer = 3, fraction = 3)      // Máximo de digitos
    private Double variation;               // Tipo DOUBLE action's price variation

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getVariation() {
        return variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }
}
