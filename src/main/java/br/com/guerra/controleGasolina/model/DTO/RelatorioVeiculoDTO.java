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
public class RelatorioVeiculoDTO {
    private String placa;
    private int totalAbastecimentos;
    private BigDecimal valorTotal;
    private double autonomia; // Km/L
    private BigDecimal custoMedioCombustivel; // R$/L
    private String condutorPrincipal;
    private double litragemConsumida;
}
