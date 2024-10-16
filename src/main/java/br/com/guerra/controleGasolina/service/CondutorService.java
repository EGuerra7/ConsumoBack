package br.com.guerra.controleGasolina.service;

import br.com.guerra.controleGasolina.model.DTO.CondutorDTO;

import java.util.List;

public interface CondutorService {
    CondutorDTO salvarCondutor(CondutorDTO condutorDTO);
    List<CondutorDTO> listarCondutores();
    CondutorDTO editarCondutor(CondutorDTO condutorDTO);
}
