package br.com.guerra.controleGasolina.model.DTO;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class CondutorDTO {
    private Integer id;
    private String nome;
    private boolean ativo;

    public CondutorDTO() {
    }

    public CondutorDTO(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }

    }
