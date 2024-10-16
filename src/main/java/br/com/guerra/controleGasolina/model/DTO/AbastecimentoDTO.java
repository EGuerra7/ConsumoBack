package br.com.guerra.controleGasolina.model.DTO;


import br.com.guerra.controleGasolina.model.Combustivel;
import br.com.guerra.controleGasolina.model.Condutor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbastecimentoDTO {
    private Integer id;
    private LocalDate data;
    private LocalTime hora;
    private Condutor condutor;
    private String placaVeiculo;
    private int quilometragem;
    private Combustivel combustivel;
    private double litros;
    private double preco;
    private double valorTotal;

    public AbastecimentoDTO(LocalDate data, LocalTime hora, Condutor condutor, String placaVeiculo, int quilometragem, Combustivel combustivel, double litros, double preco, double valorTotal) {
        this.data = data;
        this.hora = hora;
        this.condutor = condutor;
        this.placaVeiculo = placaVeiculo;
        this.quilometragem = quilometragem;
        this.combustivel = combustivel;
        this.litros = litros;
        this.preco = preco;
        this.valorTotal = valorTotal;
    }
}
