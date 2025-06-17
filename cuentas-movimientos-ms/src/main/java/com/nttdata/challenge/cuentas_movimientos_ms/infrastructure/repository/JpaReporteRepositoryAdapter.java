package com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.repository;

import com.nttdata.challenge.cuentas_movimientos_ms.domain.repository.ReporteRepositoryPort;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO.ReporteDTO;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaReporteRepositoryAdapter implements ReporteRepositoryPort {

    private JpaReporteRepository repository;

    public JpaReporteRepositoryAdapter(JpaReporteRepository repository){
        this.repository = repository;
    }

    @Override
    public List<ReporteDTO> obtenerReporte(LocalDate fechaInicio, LocalDate fechaFinal) {
        List<Object[]> resultados = repository.reporte(fechaInicio, fechaFinal);
        return resultados.stream()
                .map(obj -> new ReporteDTO(
                        (LocalDate) obj[0],
                        (String) obj[1],
                        (String) obj[2],
                        (String) obj[3],
                        (Double) obj[4],
                        (Boolean) obj[5],
                        (Double) obj[6],
                        (Double) obj[7]
                ))
                .collect(Collectors.toList());
    }
}
