package com.nttdata.challenge.personas_clientes_ms.infrastructure.repository;

import com.nttdata.challenge.personas_clientes_ms.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaClienteRepository extends JpaRepository<Cliente, String> {
}
