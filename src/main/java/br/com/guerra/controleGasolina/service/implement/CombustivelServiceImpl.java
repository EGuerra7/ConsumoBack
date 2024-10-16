package br.com.guerra.controleGasolina.service.implement;

import br.com.guerra.controleGasolina.model.Combustivel;
import br.com.guerra.controleGasolina.model.DTO.CombustivelDTO;
import br.com.guerra.controleGasolina.repository.CombustivelRepository;
import br.com.guerra.controleGasolina.service.CombustivelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CombustivelServiceImpl implements CombustivelService {

    @Autowired
    private CombustivelRepository combustivelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CombustivelDTO addCombustivel(CombustivelDTO combustivelDTO){
        Combustivel combustivel = modelMapper.map(combustivelDTO, Combustivel.class);
        combustivelRepository.save(combustivel);
        CombustivelDTO DTO = modelMapper.map(combustivel, CombustivelDTO.class);
        return DTO;
    }


    @Override
    public List<CombustivelDTO> listarCombustivel(){
        Sort sorteado = Sort.by("tipo").ascending();
        List<Combustivel> combustiveis = combustivelRepository.findAll(sorteado).stream().toList();

        return combustiveis.stream()
                .map(combustivel -> modelMapper.map(combustivel, CombustivelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deletarCombustivel(Integer id){
        try {
            combustivelRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
