package com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.repository;

public interface JpaClienteRepositoryAdapter {
    boolean validarCuenta(String idCuenta);
}
