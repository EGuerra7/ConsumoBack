package br.com.guerra.controleGasolina.controller;

import br.com.guerra.controleGasolina.model.DTO.VeiculoDTO;
import br.com.guerra.controleGasolina.repository.VeiculoRepository;
import br.com.guerra.controleGasolina.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos/")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;


    @PostMapping
    public VeiculoDTO criarVeiculo(@RequestBody VeiculoDTO veiculoDTO){
        return veiculoService.criarVeiculo(veiculoDTO);
    }

    @GetMapping
    public List<VeiculoDTO> listarVeiculos(){
        return veiculoService.listarVeiculo();
    }
    @PutMapping("{placa}")
    public VeiculoDTO editarVeiculo(@PathVariable String placa, @RequestBody VeiculoDTO veiculoDTO) {
        return veiculoService.editarVeiculo(veiculoDTO);
    }

    @DeleteMapping("{placa}")
    public  boolean deletarVeiculo(@PathVariable("placa") String placa){
        return veiculoService.deletarVeiculo(placa);
    }
}
