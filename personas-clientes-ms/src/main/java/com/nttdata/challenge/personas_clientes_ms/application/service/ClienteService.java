package com.nttdata.challenge.personas_clientes_ms.application.service;

import com.nttdata.challenge.personas_clientes_ms.domain.model.Cliente;
import com.nttdata.challenge.personas_clientes_ms.infrastructure.repository.JpaClienteRepositoryAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final JpaClienteRepositoryAdapter repository;

    public ClienteService(JpaClienteRepositoryAdapter repository) {
        this.repository = repository;
    }

    public Cliente crearCliente(Cliente cliente) {
        return repository.guardar(cliente);
    }

    public Optional<Cliente> obtenerCliente(String clienteId) {
        return repository.obtenerXId(clienteId);
    }

    public List<Cliente> listarClientes() {
        return repository.listar();
    }

    public void eliminarCliente(String clienteId) {
        repository.eliminar(clienteId);
    }

    public Cliente actualizarCliente(Cliente cliente) {
        return repository.obtenerXId(cliente.getIdCliente()).map(
                clienteEncontrado -> {
                    clienteEncontrado.setContrasenia(cliente.getContrasenia());
                    clienteEncontrado.setEstado(cliente.getEstado());
                    clienteEncontrado.setNombre(cliente.getNombre());
                    clienteEncontrado.setGenero(cliente.getGenero());
                    clienteEncontrado.setEdad(cliente.getEdad());
                    clienteEncontrado.setIdentificacion(cliente.getIdentificacion());
                    clienteEncontrado.setDireccion(cliente.getDireccion());
                    clienteEncontrado.setTelefono(cliente.getTelefono());
                    return repository.guardar(clienteEncontrado);
                } ).orElseThrow(()-> new RuntimeException("Cliente no encontrado"));

    }

}
