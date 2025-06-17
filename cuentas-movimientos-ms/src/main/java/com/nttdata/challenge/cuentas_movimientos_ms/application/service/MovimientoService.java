package com.nttdata.challenge.cuentas_movimientos_ms.application.service;

import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Cuenta;
import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Movimiento;
import com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.repository.JpaMovimientoRepositoryAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {

    private final JpaMovimientoRepositoryAdapter repository;
    private final CuentaService serviceCuenta;

    public MovimientoService(JpaMovimientoRepositoryAdapter repository, CuentaService serviceCuenta){
        this.repository = repository;
        this.serviceCuenta = serviceCuenta;
    }

    public Movimiento crearMovimiento(Movimiento movimiento) {
        Cuenta cuentaEncontrada = serviceCuenta.obtenerCuenta(movimiento.getIdCuenta()).orElseThrow(()-> new RuntimeException("Cuenta no encontrada"));
        movimiento.setTipoMovimiento("DEPOSITO");
        if(movimiento.getValor() < 0 ){
            movimiento.setTipoMovimiento("RETIRO");
            if(cuentaEncontrada.getSaldoInicial() < Math.abs(movimiento.getValor())){
                throw new IllegalArgumentException("Saldo no disponible");
            }
        }
        movimiento.setSaldoDisponible(cuentaEncontrada.getSaldoInicial() + movimiento.getValor());
        movimiento.setSaldoInicial(cuentaEncontrada.getSaldoInicial());

        cuentaEncontrada.setSaldoInicial(cuentaEncontrada.getSaldoInicial() + movimiento.getValor());
        serviceCuenta.actualizarCuenta(cuentaEncontrada);
        return repository.guardar(movimiento);
    }

    public Optional<Movimiento> obtenerMovimiento(Long movimientoId) {
        return repository.obtenerXId(movimientoId);
    }

    public List<Movimiento> listarMovimientos() {
        return repository.listar();
    }

    public void eliminarMovimiento(Long movimientoId) {
        repository.eliminar(movimientoId);
    }

    public Movimiento actualizarMovimiento(Movimiento movimiento) {
        return repository.obtenerXId(movimiento.getIdMovimiento()).map(
                movimientoEncontrado -> {
                    movimientoEncontrado.setTipoMovimiento(movimiento.getTipoMovimiento());
                    movimientoEncontrado.setFecha(movimiento.getFecha());
                    movimientoEncontrado.setValor(movimiento.getValor());
                    movimientoEncontrado.setSaldoInicial(movimiento.getSaldoInicial());
                    movimientoEncontrado.setSaldoDisponible(movimiento.getSaldoDisponible());
                    movimientoEncontrado.setIdCuenta(movimiento.getIdCuenta());
                    return repository.guardar(movimientoEncontrado);
                } ).orElseThrow(()-> new RuntimeException("Movimiento no encontrado"));
    }
}
