package com.nttdata.challenge.personas_clientes_ms.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", nullable = false)
    private Long idCliente;

    @Column(nullable = false)
    private String contrasenia;

    @Column(nullable = false)
    private Boolean estado;
}
