package br.com.guerra.controleGasolina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Combustivel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Combustivel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo_nome")
    private String tipo;



    public Combustivel(String tipo) {
        this.tipo = tipo;
    }
}

