package com.nttdata.challenge.personas_clientes_ms.shared.DTO;

import lombok.Data;

@Data
public class ClienteDTO {
    private String idCliente;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String contrasenia;
    private Boolean estado;
}