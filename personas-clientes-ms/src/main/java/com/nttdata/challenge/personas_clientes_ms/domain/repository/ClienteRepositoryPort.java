package com.nttdata.challenge.personas_clientes_ms.domain.repository;

import com.nttdata.challenge.personas_clientes_ms.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryPort {
    Cliente guardar(Cliente cliente);
    Optional<Cliente> obtenerXId(String idCliente);
    List<Cliente> listar();
    void eliminar(String idCliente);
}
