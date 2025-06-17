package com.nttdata.challenge.cuentas_movimientos_ms.domain.repository;

import com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO.ReporteDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReporteRepositoryPort {
    List<ReporteDTO> obtenerReporte(LocalDate fechaInicio, LocalDate fechaFinal);
}
