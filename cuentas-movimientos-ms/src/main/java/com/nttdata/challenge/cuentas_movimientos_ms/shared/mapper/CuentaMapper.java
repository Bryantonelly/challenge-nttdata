package com.nttdata.challenge.cuentas_movimientos_ms.shared.mapper;


import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Cuenta;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO.CuentaDTO;

public class CuentaMapper {

    public static CuentaDTO toDTO(Cuenta cuenta) {
        CuentaDTO dto = new CuentaDTO();
        dto.setIdCuenta(cuenta.getIdCuenta());
        dto.setEstado(cuenta.getEstado());
        dto.setTipoCuenta(cuenta.getTipoCuenta());
        dto.setNumeroCuenta(cuenta.getNumeroCuenta());
        dto.setSaldoInicial(cuenta.getSaldoInicial());
        dto.setIdCliente(cuenta.getIdCliente());
        return dto;
    }

    public static Cuenta toEntity(CuentaDTO dto) {
        Cuenta cuenta = new Cuenta();
        cuenta.setIdCuenta(dto.getIdCuenta());
        cuenta.setEstado(dto.getEstado());
        cuenta.setTipoCuenta(dto.getTipoCuenta());
        cuenta.setNumeroCuenta(dto.getNumeroCuenta());
        cuenta.setSaldoInicial(dto.getSaldoInicial());
        cuenta.setIdCliente(dto.getIdCliente());
        return cuenta;
    }
}
