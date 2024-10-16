package br.com.guerra.controleGasolina.service.implement;

import br.com.guerra.controleGasolina.model.DTO.VeiculoDTO;
import br.com.guerra.controleGasolina.model.Veiculo;
import br.com.guerra.controleGasolina.repository.VeiculoRepository;
import br.com.guerra.controleGasolina.service.VeiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoServiceImpl implements VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VeiculoDTO criarVeiculo(VeiculoDTO veiculoDTO){
        Veiculo veiculo = modelMapper.map(veiculoDTO, Veiculo.class);
        veiculoRepository.save(veiculo);
        VeiculoDTO DTO = modelMapper.map(veiculo, VeiculoDTO.class);
        return DTO;
    }
    @Override
    public List<VeiculoDTO> listarVeiculo(){
        List<Veiculo> veiculos = veiculoRepository.findAll().stream().toList();
        return veiculos.stream()
                .map(veiculo -> modelMapper.map(veiculo, VeiculoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VeiculoDTO editarVeiculo(VeiculoDTO veiculoDTO){
        if(!veiculoRepository.existsByPlaca(veiculoDTO.getPlaca())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Placa não encontrada!");
        } else {
        return criarVeiculo(veiculoDTO);
        }
    }

    @Override
    public boolean deletarVeiculo(String placa){
        try{
            veiculoRepository.deleteById(placa);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
