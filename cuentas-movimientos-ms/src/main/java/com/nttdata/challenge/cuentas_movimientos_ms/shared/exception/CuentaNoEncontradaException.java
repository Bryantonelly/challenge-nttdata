package com.nttdata.challenge.cuentas_movimientos_ms.shared.exception;

public class CuentaNoEncontradaException extends RuntimeException {
    public CuentaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
