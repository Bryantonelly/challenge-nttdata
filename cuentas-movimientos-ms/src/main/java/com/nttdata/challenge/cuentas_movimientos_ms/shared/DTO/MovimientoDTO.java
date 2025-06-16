package com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovimientoDTO {
    private String idMovimiento;
    private Date fecha;
    private String tipoMovimiento;
    private String valor;
    private Double saldo;
    private String idCuenta;
}
