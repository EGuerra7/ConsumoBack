package br.com.guerra.controleGasolina.model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CombustivelDTO {
    private Integer id;

    private String tipo;

    public CombustivelDTO(String tipo) {
        this.tipo = tipo;
    }
}
