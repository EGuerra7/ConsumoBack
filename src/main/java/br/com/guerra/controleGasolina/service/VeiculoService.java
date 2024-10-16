package br.com.guerra.controleGasolina.service;

import br.com.guerra.controleGasolina.model.DTO.VeiculoDTO;


import java.util.List;

public interface VeiculoService {
    VeiculoDTO criarVeiculo(VeiculoDTO veiculoDTO);
    List<VeiculoDTO> listarVeiculo();
    VeiculoDTO editarVeiculo(VeiculoDTO veiculoDTO);
    boolean deletarVeiculo(String placa);
}
