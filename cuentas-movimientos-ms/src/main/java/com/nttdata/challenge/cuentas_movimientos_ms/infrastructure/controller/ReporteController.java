package com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.controller;

import com.nttdata.challenge.cuentas_movimientos_ms.application.service.ReporteService;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO.ReporteDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/reportes")
public class ReporteController {

    private ReporteService service;

    public ReporteController(ReporteService service){
        this.service = service;
    }

    @GetMapping
    public List<ReporteDTO> obtenerReporte(@RequestParam String fechaInicio, @RequestParam String fechaFinal){
        return service.obtenerReporte(fechaInicio, fechaFinal);
    }
}
