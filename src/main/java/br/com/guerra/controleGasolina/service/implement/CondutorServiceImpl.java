package br.com.guerra.controleGasolina.service.implement;

import br.com.guerra.controleGasolina.model.Condutor;
import br.com.guerra.controleGasolina.model.DTO.CondutorDTO;
import br.com.guerra.controleGasolina.repository.CondutorRepository;
import br.com.guerra.controleGasolina.service.CondutorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CondutorServiceImpl implements CondutorService {
    @Autowired
    private CondutorRepository condutorRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CondutorDTO salvarCondutor(CondutorDTO condutorDTO){
        Condutor condutor = modelMapper.map(condutorDTO, Condutor.class);
        condutorRepository.save(condutor);
        CondutorDTO DTO = modelMapper.map(condutor, CondutorDTO.class);
        return DTO;
    }

    @Override
    public List<CondutorDTO> listarCondutores(){
        Sort sorteado = Sort.by("nome").ascending();
        List<Condutor> condutores = condutorRepository.findAll(sorteado).stream().toList();

        return condutores.stream()
                .map(condutor -> modelMapper.map(condutor, CondutorDTO.class))
                        .collect(Collectors.toList());
    }

    @Override
    public CondutorDTO editarCondutor(CondutorDTO condutorDTO){
        if(!condutorRepository.existsById(condutorDTO.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id do condutor não encontrado!");
        } else {
            return salvarCondutor(condutorDTO);
        }
    }

}
