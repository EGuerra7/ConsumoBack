package br.com.guerra.controleGasolina.service;

import br.com.guerra.controleGasolina.model.DTO.CombustivelDTO;

import java.util.List;

public interface CombustivelService {

    CombustivelDTO addCombustivel(CombustivelDTO combustivelDTO);

    List<CombustivelDTO> listarCombustivel();

    boolean deletarCombustivel(Integer id);
}
