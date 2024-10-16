package br.com.guerra.controleGasolina.service.implement;

import br.com.guerra.controleGasolina.model.Abastecimento;
import br.com.guerra.controleGasolina.model.Combustivel;
import br.com.guerra.controleGasolina.model.Condutor;
import br.com.guerra.controleGasolina.model.DTO.AbastecimentoDTO;
import br.com.guerra.controleGasolina.repository.AbastecimentoRepository;
import br.com.guerra.controleGasolina.repository.CombustivelRepository;
import br.com.guerra.controleGasolina.repository.CondutorRepository;
import br.com.guerra.controleGasolina.service.AbastecimentoService;
import jakarta.persistence.EntityManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbastecimentoServiceImpl implements AbastecimentoService {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AbastecimentoDTO criarAbastecimento(AbastecimentoDTO abastecimentoDTO){

        double litros = abastecimentoDTO.getValorTotal() / abastecimentoDTO.getPreco();
        BigDecimal roundedResult = new BigDecimal(litros).setScale(2, RoundingMode.HALF_UP);
        abastecimentoDTO.setLitros(roundedResult.doubleValue());



        Abastecimento abastecimento = modelMapper.map(abastecimentoDTO, Abastecimento.class);
        abastecimentoRepository.save(abastecimento);
        AbastecimentoDTO DTO = modelMapper.map(abastecimento, AbastecimentoDTO.class);
        return DTO;
    }

    @Override
    public List<AbastecimentoDTO> listarAbastecimento(){
        Sort sorteado = Sort.by("data").descending();
        List<Abastecimento> abastecimentos = abastecimentoRepository.findAll(sorteado).stream().toList();

        return abastecimentos.stream()
                .map(abastecimento -> modelMapper.map(abastecimento, AbastecimentoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean excluirAbastecimento(Integer id){
        try {
            abastecimentoRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
