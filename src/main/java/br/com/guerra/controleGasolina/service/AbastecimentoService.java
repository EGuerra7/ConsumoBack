package br.com.guerra.controleGasolina.service;

import br.com.guerra.controleGasolina.model.DTO.AbastecimentoDTO;

import java.math.BigDecimal;
import java.util.List;

public interface AbastecimentoService {
    AbastecimentoDTO criarAbastecimento(AbastecimentoDTO abastecimentoDTO);
    List<AbastecimentoDTO>  listarAbastecimento();
    boolean excluirAbastecimento(Integer id);

}
