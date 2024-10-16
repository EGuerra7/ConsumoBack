package br.com.guerra.controleGasolina.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioCondutorDTO {
    private Integer condutorId;
    private int totalAbastecimentos;
    private BigDecimal valorTotal;
    private double litragemConsumida;
    private BigDecimal custoMedioCombustivel;
    private String veiculoPrincipal;

    // Getters e Setters
}

