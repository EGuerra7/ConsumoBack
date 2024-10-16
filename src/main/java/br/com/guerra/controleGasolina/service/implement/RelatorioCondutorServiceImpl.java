package br.com.guerra.controleGasolina.service.implement;

import br.com.guerra.controleGasolina.model.DTO.RelatorioCondutorDTO;
import br.com.guerra.controleGasolina.repository.AbastecimentoRepository;
import br.com.guerra.controleGasolina.service.RelatorioCondutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RelatorioCondutorServiceImpl implements RelatorioCondutorService {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;


    public RelatorioCondutorDTO gerarRelatorio(Integer condutorId) {
        RelatorioCondutorDTO relatorio = new RelatorioCondutorDTO();

        relatorio.setCondutorId(condutorId);
        relatorio.setTotalAbastecimentos(abastecimentoRepository.totalAbastecimentosPorCondutor(condutorId));
        relatorio.setValorTotal(abastecimentoRepository.valorTotalPorCondutor(condutorId).orElse(BigDecimal.ZERO));
        relatorio.setLitragemConsumida(abastecimentoRepository.litrosConsumidosPorCondutor(condutorId).orElse(0.0));
        relatorio.setCustoMedioCombustivel(abastecimentoRepository.custoMedioPorCondutor(condutorId).orElse(BigDecimal.ZERO));

        List<String> veiculos = abastecimentoRepository.veiculoPrincipal(condutorId);
        relatorio.setVeiculoPrincipal(veiculos.isEmpty() ? "Nenhum veículo encontrado" : veiculos.get(0));

        return relatorio;
    }
}
