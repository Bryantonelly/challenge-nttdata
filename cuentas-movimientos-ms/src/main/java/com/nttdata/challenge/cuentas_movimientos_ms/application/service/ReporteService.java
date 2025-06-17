package com.nttdata.challenge.cuentas_movimientos_ms.application.service;

import com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.repository.JpaReporteRepositoryAdapter;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO.ReporteDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReporteService {

    private final JpaReporteRepositoryAdapter repository;

    public ReporteService (JpaReporteRepositoryAdapter repository){
        this.repository = repository;
    }

    public List<ReporteDTO> obtenerReporte(String fechaInicio, String fechaFinal){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
        LocalDate fin = LocalDate.parse(fechaFinal, formatter);
        return repository.obtenerReporte(inicio, fin);
    }
}
