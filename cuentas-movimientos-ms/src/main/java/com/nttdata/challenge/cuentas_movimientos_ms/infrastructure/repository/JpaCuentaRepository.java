package com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.repository;

import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCuentaRepository extends JpaRepository<Cuenta, Long> {
}
