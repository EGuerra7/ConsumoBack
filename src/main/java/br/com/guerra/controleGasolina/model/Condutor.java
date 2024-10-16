package br.com.guerra.controleGasolina.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Condutores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Condutor {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome_completo")
    private String nome;

    @Column(name = "ativo")
    private boolean ativo;

    public Condutor(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }
}
