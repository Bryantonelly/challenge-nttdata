package com.nttdata.challenge.cuentas_movimientos_ms.shared.exception;

public class UsuarioNoEncontradoException extends RuntimeException{
    public UsuarioNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
