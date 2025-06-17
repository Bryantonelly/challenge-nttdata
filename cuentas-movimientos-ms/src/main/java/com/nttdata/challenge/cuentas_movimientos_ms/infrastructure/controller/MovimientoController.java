package com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.controller;

import com.nttdata.challenge.cuentas_movimientos_ms.application.service.MovimientoService;
import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Movimiento;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO.MovimientoDTO;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.exception.SaldoInsufienteException;
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
    public ResponseEntity<?> crear(@RequestBody MovimientoDTO clienteDto) {
        try{
            Movimiento nuevoCliente = service.crearMovimiento(MovimientoMapper.toEntity(clienteDto));
            return ResponseEntity.ok(MovimientoMapper.toDTO(nuevoCliente));
        } catch (SaldoInsufienteException e){
            return ResponseEntity
                    .badRequest()
                    .body("Error: " + e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoDTO> obtener(@PathVariable Long id) {
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
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarMovimiento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<MovimientoDTO> actualizar(@RequestBody MovimientoDTO movimientoDto) {
        Movimiento movimientoActualizado = service.actualizarMovimiento(MovimientoMapper.toEntity(movimientoDto));
        return ResponseEntity.ok(MovimientoMapper.toDTO(movimientoActualizado));
    }
}
