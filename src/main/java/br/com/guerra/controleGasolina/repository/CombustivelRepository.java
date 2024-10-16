package br.com.guerra.controleGasolina.repository;

import br.com.guerra.controleGasolina.model.Combustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombustivelRepository extends JpaRepository<Combustivel, Integer> {
}
