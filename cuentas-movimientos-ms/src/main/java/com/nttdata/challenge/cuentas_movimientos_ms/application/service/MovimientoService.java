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

    public MovimientoService(JpaMovimientoRepositoryAdapter repository){
        this.repository = repository;
    }

    public Movimiento crearMovimiento(Movimiento movimiento) {
        return repository.guardar(movimiento);
    }

    public Optional<Movimiento> obtenerMovimiento(String movimientoId) {
        return repository.obtenerXId(movimientoId);
    }

    public List<Movimiento> listarMovimientos() {
        return repository.listar();
    }

    public void eliminarMovimiento(String movimientoId) {
        repository.eliminar(movimientoId);
    }

    public Movimiento actualizarMovimiento(Movimiento movimiento) {
        return repository.obtenerXId(movimiento.getIdMovimiento()).map(
                movimientoEncontrado -> {
                    movimientoEncontrado.setTipoMovimiento(movimiento.getTipoMovimiento());
                    movimientoEncontrado.setFecha(movimiento.getFecha());
                    movimientoEncontrado.setValor(movimiento.getValor());
                    movimientoEncontrado.setSaldo(movimiento.getSaldo());
                    return repository.guardar(movimientoEncontrado);
                } ).orElseThrow(()-> new RuntimeException("Movimiento no encontrado"));
    }
}
