package br.com.guerra.controleGasolina.service;

import br.com.guerra.controleGasolina.model.DTO.RelatorioCondutorDTO;

public interface RelatorioCondutorService {

    public RelatorioCondutorDTO gerarRelatorio(Integer condutorId);
}
