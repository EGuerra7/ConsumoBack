package br.com.guerra.controleGasolina.model.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {
    private String placa;

    private String tipo;

    private String marca;

    private String tipoCombustivel;

    private double capacidadeTanque;

}
