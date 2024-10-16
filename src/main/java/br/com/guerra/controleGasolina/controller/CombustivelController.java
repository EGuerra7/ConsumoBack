package br.com.guerra.controleGasolina.controller;

import br.com.guerra.controleGasolina.model.DTO.CombustivelDTO;
import br.com.guerra.controleGasolina.service.CombustivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combustivel/")
public class CombustivelController {

    @Autowired
    private CombustivelService combustivelService;

    @PostMapping
    public CombustivelDTO addCombustivel(@RequestBody CombustivelDTO combustivelDTO){
        return combustivelService.addCombustivel(combustivelDTO);
    }

    @GetMapping
    public List<CombustivelDTO> listarCombustivel(){
        return combustivelService.listarCombustivel();
    }

    @DeleteMapping("{id}")
    public boolean deletarCombustivel(@PathVariable("id") Integer id){
        return combustivelService.deletarCombustivel(id);
    }
}
