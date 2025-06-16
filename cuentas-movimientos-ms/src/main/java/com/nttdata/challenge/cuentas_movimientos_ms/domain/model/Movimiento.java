package com.nttdata.challenge.cuentas_movimientos_ms.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "movimientos")
public class Movimiento {
    @Id
    @Column(name = "movimiento_id", nullable = false)
    private String idMovimiento;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private String tipoMovimiento;
    @Column(nullable = false)
    private String valor;
    @Column(nullable = false)
    private Double saldo;

    @Column(name = "cuenta_id")
    private String idCuenta;
}
