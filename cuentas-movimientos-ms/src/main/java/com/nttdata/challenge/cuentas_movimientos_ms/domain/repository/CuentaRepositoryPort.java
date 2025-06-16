package com.nttdata.challenge.cuentas_movimientos_ms.domain.repository;

import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaRepositoryPort {
    Cuenta guardar(Cuenta cuenta);
    Optional<Cuenta> obtenerXId(String idCuenta);
    List<Cuenta> listar();
    void eliminar(String idCuenta);
}
