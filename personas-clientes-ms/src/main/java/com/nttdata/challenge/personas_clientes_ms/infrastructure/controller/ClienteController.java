package com.nttdata.challenge.personas_clientes_ms.infrastructure.controller;

import com.nttdata.challenge.personas_clientes_ms.application.service.ClienteService;
import com.nttdata.challenge.personas_clientes_ms.domain.model.Cliente;
import com.nttdata.challenge.personas_clientes_ms.shared.DTO.ClienteDTO;
import com.nttdata.challenge.personas_clientes_ms.shared.mapper.ClienteMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO clienteDto) {
        Cliente nuevoCliente = service.crearCliente(ClienteMapper.toEntity(clienteDto));
        return ResponseEntity.ok(ClienteMapper.toDTO(nuevoCliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtener(@PathVariable Long id) {
        return service.obtenerCliente(id)
                .map(cliente -> ResponseEntity.ok(ClienteMapper.toDTO(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ClienteDTO> listar() {
        return service.listarClientes().stream()
                .map(ClienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> actualizar(@RequestBody ClienteDTO clienteDto) {
        Cliente clienteActualizado = service.actualizarCliente(ClienteMapper.toEntity(clienteDto));
        return ResponseEntity.ok(ClienteMapper.toDTO(clienteActualizado));
    }
}
