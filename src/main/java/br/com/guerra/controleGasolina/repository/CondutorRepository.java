package br.com.guerra.controleGasolina.repository;


import br.com.guerra.controleGasolina.model.Condutor;
import br.com.guerra.controleGasolina.model.DTO.CondutorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Integer> {
    boolean existsById(CondutorDTO condutorDTO);
}
