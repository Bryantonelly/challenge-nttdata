package com.nttdata.challenge.Movimientos_movimientos_ms.domain.repository;

import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Movimiento;

import java.util.List;
import java.util.Optional;

public interface MovimientoRepositoryPort {
    Movimiento guardar(Movimiento Movimiento);
    Optional<Movimiento> obtenerXId(String idMovimiento);
    List<Movimiento> listar();
    void eliminar(String idMovimiento);
}
