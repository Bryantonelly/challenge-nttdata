package com.nttdata.challenge.personas_clientes_ms.infrastructure.repository;

import com.nttdata.challenge.personas_clientes_ms.domain.model.Cliente;
import com.nttdata.challenge.personas_clientes_ms.domain.repository.ClienteRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final JpaClienteRepository repository;

    public JpaClienteRepositoryAdapter(JpaClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Optional<Cliente> obtenerXId(String idCliente) {
        return repository.findById(idCliente);
    }

    @Override
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @Override
    public void eliminar(String idCliente) {
        repository.deleteById(idCliente);
    }

}
