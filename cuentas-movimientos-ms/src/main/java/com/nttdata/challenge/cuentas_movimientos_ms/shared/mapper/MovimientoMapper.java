package com.nttdata.challenge.cuentas_movimientos_ms.shared.mapper;


import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Movimiento;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO.MovimientoDTO;

public class MovimientoMapper {

    public static MovimientoDTO toDTO(Movimiento movimiento) {
        MovimientoDTO dto = new MovimientoDTO();
        dto.setIdMovimiento(movimiento.getIdMovimiento());
        dto.setTipoMovimiento(movimiento.getTipoMovimiento());
        dto.setFecha(movimiento.getFecha());
        dto.setValor(movimiento.getValor());
        dto.setSaldoInicial(movimiento.getSaldoInicial());
        dto.setSaldoDisponible(movimiento.getSaldoDisponible());
        dto.setIdCuenta(movimiento.getIdCuenta());
        return dto;
    }

    public static Movimiento toEntity(MovimientoDTO dto) {
        Movimiento movimiento = new Movimiento();
        movimiento.setIdMovimiento(dto.getIdMovimiento());
        movimiento.setTipoMovimiento(dto.getTipoMovimiento());
        movimiento.setFecha(dto.getFecha());
        movimiento.setValor(dto.getValor());
        movimiento.setSaldoInicial(dto.getSaldoInicial());
        movimiento.setSaldoDisponible(dto.getSaldoDisponible());
        movimiento.setIdCuenta(dto.getIdCuenta());
        return movimiento;
    }
}
