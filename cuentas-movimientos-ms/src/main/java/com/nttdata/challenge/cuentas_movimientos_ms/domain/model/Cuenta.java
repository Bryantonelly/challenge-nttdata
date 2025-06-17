package com.nttdata.challenge.cuentas_movimientos_ms.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuenta_id", nullable = false)
    private Long idCuenta;
    @Column(nullable = false)
    private String numeroCuenta;
    @Column(nullable = false)
    private String tipoCuenta;
    @Column(nullable = false)
    private Double saldoInicial;
    @Column(nullable = false)
    private Boolean estado;

    @Column(name = "cliente_id", nullable = false)
    private Long idCliente;
}
