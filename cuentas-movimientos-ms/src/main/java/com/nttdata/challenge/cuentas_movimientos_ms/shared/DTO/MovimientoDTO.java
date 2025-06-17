package com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovimientoDTO {
    private Long idMovimiento;
    private Date fecha;
    private String tipoMovimiento;
    private Double valor;
    private Double saldoInicial;
    private Double saldoDisponible;
    private Long idCuenta;
}
