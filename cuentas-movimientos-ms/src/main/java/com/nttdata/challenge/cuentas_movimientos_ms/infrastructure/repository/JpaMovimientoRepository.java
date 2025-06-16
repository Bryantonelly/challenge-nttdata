package com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.repository;

import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovimientoRepository extends JpaRepository<Movimiento, String> {
}
