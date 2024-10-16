package br.com.guerra.controleGasolina.service;

import br.com.guerra.controleGasolina.model.DTO.RelatorioVeiculoDTO;
import org.springframework.stereotype.Service;


public interface RelatorioVeiculoService {

    RelatorioVeiculoDTO gerarRelatorio(String placa);
}
