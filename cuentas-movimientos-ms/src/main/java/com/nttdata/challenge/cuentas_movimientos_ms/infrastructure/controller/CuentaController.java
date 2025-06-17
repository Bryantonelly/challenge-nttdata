package com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.controller;

import com.nttdata.challenge.cuentas_movimientos_ms.application.service.CuentaService;
import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Cuenta;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO.CuentaDTO;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.exception.UsuarioNoEncontradoException;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.mapper.CuentaMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    private final CuentaService service;

    public CuentaController(CuentaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody CuentaDTO clienteDto) {
        try{
            Cuenta nuevoCliente = service.crearCuenta(CuentaMapper.toEntity(clienteDto));
            return ResponseEntity.ok(CuentaMapper.toDTO(nuevoCliente));
        } catch (UsuarioNoEncontradoException e){
            return ResponseEntity
                    .badRequest()
                    .body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaDTO> obtener(@PathVariable Long id) {
        return service.obtenerCuenta(id)
                .map(cliente -> ResponseEntity.ok(CuentaMapper.toDTO(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<CuentaDTO> listar() {
        return service.listarCuentas().stream()
                .map(CuentaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarCuenta(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<CuentaDTO> actualizar(@RequestBody CuentaDTO cuentaDto) {
        Cuenta cuentaActualizado = service.actualizarCuenta(CuentaMapper.toEntity(cuentaDto));
        return ResponseEntity.ok(CuentaMapper.toDTO(cuentaActualizado));
    }
}
