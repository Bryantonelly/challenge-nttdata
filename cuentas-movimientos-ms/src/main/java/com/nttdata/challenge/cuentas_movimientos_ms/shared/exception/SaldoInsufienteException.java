package com.nttdata.challenge.cuentas_movimientos_ms.shared.exception;

public class SaldoInsufienteException extends RuntimeException{
    public SaldoInsufienteException(String mensaje) {
        super(mensaje);
    }
}
