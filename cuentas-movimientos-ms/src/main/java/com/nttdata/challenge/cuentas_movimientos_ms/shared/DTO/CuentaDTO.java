package com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentaDTO {
    private Long idCuenta;
    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;
    private Long idCliente;
}
