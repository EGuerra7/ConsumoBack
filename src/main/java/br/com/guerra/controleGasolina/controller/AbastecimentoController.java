package br.com.guerra.controleGasolina.controller;

import br.com.guerra.controleGasolina.model.DTO.AbastecimentoDTO;
import br.com.guerra.controleGasolina.model.DTO.RelatorioCondutorDTO;
import br.com.guerra.controleGasolina.model.DTO.RelatorioVeiculoDTO;
import br.com.guerra.controleGasolina.service.AbastecimentoService;
import br.com.guerra.controleGasolina.service.RelatorioCondutorService;
import br.com.guerra.controleGasolina.service.RelatorioVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoService abastecimentoService;

    @Autowired
    private RelatorioCondutorService relatorioCondutorService;

    @Autowired
    private RelatorioVeiculoService relatorioVeiculoService;

    @PostMapping
    public AbastecimentoDTO criarAbastecimento(@RequestBody  AbastecimentoDTO abastecimentoDTO){
        return abastecimentoService.criarAbastecimento(abastecimentoDTO);
    }

    @GetMapping
    public List<AbastecimentoDTO> listarAbastecimento(){
        return abastecimentoService.listarAbastecimento();
    }

    @GetMapping("veiculo/{placa}")
    public RelatorioVeiculoDTO gerarRelatorioVeiculo(@PathVariable String placa) {
        return relatorioVeiculoService.gerarRelatorio(placa);
    }

    @GetMapping("condutor/{id}")
    public RelatorioCondutorDTO gerarRelatorioCondutor(@PathVariable Integer id) {
        return relatorioCondutorService.gerarRelatorio(id);
    }

    @DeleteMapping("{id}")
    public boolean deletarAbastecimento(@PathVariable("id") Integer id){
        return abastecimentoService.excluirAbastecimento(id);
    }
}
