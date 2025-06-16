package com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.controller;

import com.nttdata.challenge.cuentas_movimientos_ms.application.service.MovimientoService;
import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Movimiento;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO.MovimientoDTO;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.mapper.MovimientoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    private final MovimientoService service;

    public MovimientoController(MovimientoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MovimientoDTO> crear(@RequestBody MovimientoDTO clienteDto) {
        Movimiento nuevoCliente = service.crearMovimiento(MovimientoMapper.toEntity(clienteDto));
        return ResponseEntity.ok(MovimientoMapper.toDTO(nuevoCliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoDTO> obtener(@PathVariable String id) {
        return service.obtenerMovimiento(id)
                .map(cliente -> ResponseEntity.ok(MovimientoMapper.toDTO(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<MovimientoDTO> listar() {
        return service.listarMovimientos().stream()
                .map(MovimientoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminarMovimiento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<MovimientoDTO> actualizar(@RequestBody MovimientoDTO cuentaDto) {
        Movimiento cuentaActualizado = service.actualizarMovimiento(MovimientoMapper.toEntity(cuentaDto));
        return ResponseEntity.ok(MovimientoMapper.toDTO(cuentaActualizado));
    }
}
