package br.com.guerra.controleGasolina.service.implement;


import br.com.guerra.controleGasolina.model.DTO.RelatorioVeiculoDTO;
import br.com.guerra.controleGasolina.repository.AbastecimentoRepository;
import br.com.guerra.controleGasolina.service.RelatorioVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RelatorioVeiculoServiceImpl implements RelatorioVeiculoService {


    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    public RelatorioVeiculoDTO gerarRelatorio(String placa){
        RelatorioVeiculoDTO relatorio = new RelatorioVeiculoDTO();

        relatorio.setPlaca(placa);
        relatorio.setTotalAbastecimentos(abastecimentoRepository.totalAbastecimentosPorVeiculo(placa));
        relatorio.setValorTotal(abastecimentoRepository.valorTotalPorVeiculo(placa).orElse(BigDecimal.ZERO));
        relatorio.setLitragemConsumida(abastecimentoRepository.litrosConsumidosPorVeiculo(placa).orElse(0.0));
        relatorio.setCustoMedioCombustivel(abastecimentoRepository.custoMedioPorVeiculo(placa).orElse(BigDecimal.ZERO));
        relatorio.setAutonomia(abastecimentoRepository.autonomiaPorVeiculo(placa).orElse(0.0));

        List<String> condutores = abastecimentoRepository.condutorPrincipal(placa);

        if (!condutores.isEmpty()) {
            relatorio.setCondutorPrincipal(condutores.get(0));
        } else {
            relatorio.setCondutorPrincipal("Nenhum condutor encontrado");
        }


        return relatorio;
    }
}
