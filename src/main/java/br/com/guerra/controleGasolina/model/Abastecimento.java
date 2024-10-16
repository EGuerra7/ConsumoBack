package br.com.guerra.controleGasolina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "Abastecimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Abastecimento {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private Integer id;

    @Column(name = "data_abastecimento")
    private LocalDate data;

    @Column(name = "hora_abastecimento")
    private LocalTime hora;

    @ManyToOne
    private Condutor condutor;

    @ManyToOne
    private Combustivel combustivel;

    @Column(name = "quilometragem")
    private int quilometragem;

    @Column(name = "placa_veiculo")
    private String placaVeiculo;

    @Column(name = "litros")
    private double litros;

    @Column(name = "preco")
    private double preco;

    @Column(name = "valor_total")
    private double valorTotal;


    public Abastecimento(LocalDate data, LocalTime hora, Condutor condutor, Combustivel combustivel, int quilometragem, String placaVeiculo, double litros, double preco, double valorTotal) {
        this.data = data;
        this.hora = hora;
        this.condutor = condutor;
        this.combustivel = combustivel;
        this.quilometragem = quilometragem;
        this.placaVeiculo = placaVeiculo;
        this.litros = litros;
        this.preco = preco;
        this.valorTotal = valorTotal;
    }
}
