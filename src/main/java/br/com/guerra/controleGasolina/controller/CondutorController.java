package br.com.guerra.controleGasolina.controller;

import br.com.guerra.controleGasolina.model.DTO.CondutorDTO;
import br.com.guerra.controleGasolina.service.CondutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condutores/")
public class CondutorController {
    @Autowired
    private CondutorService condutorService;

    @PostMapping
    public CondutorDTO criarCondutor(@RequestBody CondutorDTO condutor){
        return condutorService.salvarCondutor(condutor);
    }

    @GetMapping
    public List<CondutorDTO> listarCondutores(){
        return condutorService.listarCondutores();
    }

    @PutMapping("{id}")
    public CondutorDTO editarCondutor( @PathVariable("id") Integer id, @RequestBody CondutorDTO condutor){
        return condutorService.salvarCondutor(condutor);
    }
}
