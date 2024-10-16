package br.com.guerra.controleGasolina.repository;

import br.com.guerra.controleGasolina.model.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Integer> {

    // Total de abastecimentos por veículo
    @Query("SELECT COUNT(a) FROM Abastecimento a WHERE a.placaVeiculo = :placa")
    int totalAbastecimentosPorVeiculo(String placa);

    // Valor total gasto em combustível por veículo
    @Query("SELECT SUM(a.valorTotal) FROM Abastecimento a WHERE a.placaVeiculo = :placa")
    Optional<BigDecimal> valorTotalPorVeiculo(String placa);

    // Litragem total consumida por veículo
    @Query("SELECT SUM(a.litros) FROM Abastecimento a WHERE a.placaVeiculo = :placa")
    Optional<Double> litrosConsumidosPorVeiculo(String placa);

    // Preço médio por litro de combustível
    @Query("SELECT AVG(a.valorTotal / a.litros) FROM Abastecimento a WHERE a.placaVeiculo = :placa")
    Optional<BigDecimal> custoMedioPorVeiculo(String placa);

    // Condutor principal
    @Query("SELECT a.condutor.nome FROM Abastecimento a WHERE a.placaVeiculo = :placa " +
            "GROUP BY a.condutor.nome ORDER BY COUNT(a) DESC")
    List<String> condutorPrincipal(String placa);

    // Calcular autonomia
    @Query(value = """
    SELECT SUM(t.km_percorrido) / SUM(t.litros) AS autonomia
    FROM (
        SELECT 
            (a1.quilometragem - LAG(a1.quilometragem) OVER (ORDER BY a1.data_abastecimento)) AS km_percorrido,
            a1.litros AS litros
        FROM Abastecimento a1
        WHERE a1.placa_veiculo = :placa
    ) t
    WHERE t.km_percorrido IS NOT NULL
    """, nativeQuery = true)
    Optional<Double> autonomiaPorVeiculo(@Param("placa") String placa);



    // Total de abastecimentos por condutor
    @Query("SELECT COUNT(a) FROM Abastecimento a WHERE a.condutor.id = :condutorId")
    int totalAbastecimentosPorCondutor(Integer condutorId);

    // Valor total gasto em combustível por condutor
    @Query("SELECT SUM(a.valorTotal) FROM Abastecimento a WHERE a.condutor.id = :condutorId")
    Optional<BigDecimal> valorTotalPorCondutor(Integer condutorId);

    // Litragem total consumida por condutor
    @Query("SELECT SUM(a.litros) FROM Abastecimento a WHERE a.condutor.id = :condutorId")
    Optional<Double> litrosConsumidosPorCondutor(Integer condutorId);

    // Preço médio por litro de combustível por condutor
    @Query("SELECT AVG(a.valorTotal / a.litros) FROM Abastecimento a WHERE a.condutor.id = :condutorId")
    Optional<BigDecimal> custoMedioPorCondutor(Integer condutorId);

    // Veículo Principal (mais utilizado pelo condutor)
    @Query("""
        SELECT a.placaVeiculo 
        FROM Abastecimento a 
        WHERE a.condutor.id = :condutorId 
        GROUP BY a.placaVeiculo 
        ORDER BY COUNT(a) DESC
    """)
    List<String> veiculoPrincipal(Integer condutorId);

}
