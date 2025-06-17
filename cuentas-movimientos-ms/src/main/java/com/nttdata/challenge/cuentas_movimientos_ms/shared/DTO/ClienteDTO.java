package com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long idCliente;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String contrasenia;
    private Boolean estado;
}